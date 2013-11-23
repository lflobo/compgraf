package pt.ipb.esact.compgraf.tools;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLProfile;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.opengl.GLData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import pt.ipb.esact.compgraf.tools.math.Vector;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.jogamp.opengl.math.Quaternion;
import com.jogamp.opengl.util.gl2.GLUT;

public abstract class SWTGLWindow extends GLUTWrapper implements GLListener, GLWindow {
	
	private Composite composite;

	private GLCanvas canvas;

	private GLContext context;
	
	private long elapsedTime = 0L;
	
	private long currentTime = 0L;
	
	private long lastTime = System.currentTimeMillis();
	
	private Set<Integer> keycodes = new HashSet<>();

	private Display display;
	
	private GLDemo demo;
	
	private boolean mouseDown = false;
	
	private boolean mousePan = false;

	private boolean mouseZoom = false;
	
	private Point lastMouseLocation = null;
	
	private int zoom = 0;

	List<ReleaseListener> releaseListeners = Lists.newArrayList();
	
	public SWTGLWindow(Composite parent, boolean continuous) {
		Preconditions.checkNotNull(parent, "The parent cannot be null");
		display = parent.getDisplay();

		// Setup initial camera
		Cameras.addDefaultCamera();
		
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());

		GLProfile profile = GLProfile.getDefault();
		GLData glData = new GLData();
		glData.depthSize = 16;
		glData.doubleBuffer = true;
		glData.samples = 2;
		canvas = new GLCanvas(composite, SWT.NO_BACKGROUND, glData);
		setCurrent();

		context = GLDrawableFactory.getFactory(profile).createExternalGLContext();
		
		canvas.addListener(SWT.Resize, new Listener() {
			
			private boolean init = true;
			
			@Override
			public void handleEvent(Event e) {
				if(init) {
					setCurrent();
					context.makeCurrent();
					setCurrent(context.getGL().getGL2());
					init();
					context.release();
					currentTime = System.nanoTime();
					
					internalInit();
					
					init = false;
				}
				
				Rectangle rectangle = canvas.getClientArea();
				setCurrent();
				context.makeCurrent();
				setCurrent(context.getGL().getGL2());
				resize(rectangle.width, rectangle.height);
				context.release();
			}
		});
		
		canvas.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				keycodes.remove(e.keyCode);
				onKeyUp(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(!keycodes.contains(e.keyCode))
					onKeyDown(e);
				if(e.keyCode == SWT.ESC)
					display.getActiveShell().close();
				keycodes.add(e.keyCode);
			}
		});
		
		canvas.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseScrolled(MouseEvent e) {
				zoom = e.count;
			}
		});
		
		canvas.addMouseListener(new MouseListener() {
			@Override
			public void mouseUp(MouseEvent e) {
				mouseDown = false;
				onMouseUp(e);
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDown = true;
				lastMouseLocation = MouseInfo.getPointerInfo().getLocation();
				onMouseDown(e);
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		
		if(continuous)
			display.asyncExec(new Runnable() {
				@Override
				public void run() {
					if(!canvas.isDisposed()) {
						render();
						display.asyncExec(this);
					}
				}
			});
		else
			canvas.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent e) {
					render();
				}
			});
		
		// Tools
		demo = new GLDemo();
		
	}
	
	public void addReleaseListener(ReleaseListener listener) {
		releaseListeners.add(listener);
	}
	
	public void removeReleaseListener(ReleaseListener listener) {
		releaseListeners.remove(listener);
	}
	
	/**
	 * Carrega uma textura a partir da package da classe atual
	 * @param path A path dentro da package atual
	 * @param textureId O ID do Texture Object
	 */
	public void loadPackageTexture(String path, int textureId) {
		GlTools.loadPackageTexture(this, path, textureId);
	}


	protected void internalInit() {
		
	}

	public float getMaxAnisotropy() {
		return GlTools.getMaxAnisotropy();
	}
	
	public boolean isAnisotropicAvailable() {
		return GlTools.isAnisotropicAvailable();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void exit(String error) {
		MessageBox box = new MessageBox(new Shell(display));
		box.setText("Error");
		box.setMessage(error);
		box.open();
		System.exit(0);
	}
	
	protected void onMouseDown(MouseEvent e) {
		
	}

	protected void onMouseUp(MouseEvent e) {
		
	}

	public void setMousePan(boolean mousePan) {
		this.mousePan = mousePan;
	}
	
	public void setMouseZoom(boolean mouseZoom) {
		this.mouseZoom = mouseZoom;
	}
	
	public void setProjectionPerspective(int width, int height, float fovy, float near, float far) {
		if (height == 0)
			height = 1;
		glViewport(0, 0, width, height);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		float aspect = (float) width / (float) height;
		gluPerspective(90.0f, aspect, near, far);
	}
	
	public void setProjectionOrtho(int width, int height, float volume, float near, float far) {
		if (height == 0)
			height = 1;
		glViewport(0, 0, width, height);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		float aspect = (float) width / (float) height;
		glOrtho(-volume, volume, -volume/aspect, volume/aspect, near, far);
	}

	public void setProjectionOrtho2D(int width, int height) {
		if (height == 0)
			height = 1;
		glViewport(0, 0, width, height);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluOrtho2D(0, width, 0, height);
	}

	public void setupCamera() {
		// Use the current camera
		Camera camera = Cameras.getCurrent();
		
		// Mudar para a matriz de MODELVIEW
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		gluLookAt(
			camera.eye.x, camera.eye.y, camera.eye.z,
			camera.at.x, camera.at.y, camera.at.z,
			camera.up.x, camera.up.y, camera.up.z
		);
	}
	
	protected GLDemo demo() {
		return demo;
	}
	
	protected void onKeyUp(KeyEvent e) {

	}

	protected void onKeyDown(KeyEvent e) {
		
	}
	
	/**
	 * Draw the selected text at the position described by left ant top
	 * @param text The text to draw
	 * @param left The distance to the left
	 * @param top The distance to the top
	 */
	public void renderText(String text, int left, int top) {
		renderText(text, GLUT.BITMAP_8_BY_13, left, top);
//		renderText(text, GLUT.BITMAP_9_BY_15, left, top);
//		renderText(text, GLUT.BITMAP_HELVETICA_10, left, top);
//		renderText(text, GLUT.BITMAP_HELVETICA_12, left, top);
//		renderText(text, GLUT.BITMAP_HELVETICA_18, left, top);
//		renderText(text, GLUT.BITMAP_TIMES_ROMAN_10, left, top);
//		renderText(text, GLUT.BITMAP_TIMES_ROMAN_24, left, top);
	}
	
	public void renderText(String text, int bitmap, int left, int top) {
		Iterable<String> lines = Splitter.on('\n').split(text);
		
		int height = canvas.getSize().y;
		int width = canvas.getSize().x;
		
		// Set up 2D mode
		glMatrixMode(GL_PROJECTION);
		glPushMatrix();
		glLoadIdentity();
		glOrtho(0, width, 0, height, -1, 1);
	
		glMatrixMode(GL_MODELVIEW);
		glPushMatrix();
		glLoadIdentity();

		// Render the text
		int i = 0;
		
		glPushAttrib(GL_LIGHTING_BIT | GL_ENABLE_BIT);
	
			glDisable(GL_TEXTURE_2D);
			glDisable(GL_LIGHTING);
			for(String line : lines) {
				glRasterPos2i(left, height - (top + i * 15));
				for(char c : line.toCharArray()) 
					glutBitmapCharacter(bitmap, c);
				i++;
			}
			glEnable(GL_LIGHTING);
			
		glPopAttrib();
			
		// Break down 2D mode
		glMatrixMode(GL_PROJECTION);
		glPopMatrix();
		glMatrixMode(GL_MODELVIEW);
		glPopMatrix();
	}

	@Override
	public void dispose() {
		canvas.dispose();
		release();
		for(ReleaseListener l : releaseListeners)
			l.release(getCurrent());
	}
	
	protected void render() {
		Rectangle rectangle = canvas.getClientArea();
		setCurrent();
		context.makeCurrent();
		setCurrent(context.getGL().getGL2());

		currentTime = System.currentTimeMillis();
		elapsedTime = currentTime - lastTime;
		lastTime = currentTime;
		
		Point location = null;
		if(mousePan && mouseDown) {
			location = MouseInfo.getPointerInfo().getLocation();
			
			float xdiff = lastMouseLocation.x - location.x;
			float ydiff = lastMouseLocation.y - location.y;
			if(xdiff!=0 || ydiff!=0)
				rotateScene(xdiff * 0.01f, ydiff * 0.01f);
			
		}

		if(mouseZoom && zoom != 0) {
			zoomScene(zoom);
			zoom = 0;
		}

		render(rectangle.width, rectangle.height);

		if(mousePan && mouseDown) {
			lastMouseLocation = location;
		}
		
		canvas.swapBuffers();
		context.release();		
	}

	private void zoomScene(int zoom) {
		float d = zoom;
		float signal = d / Math.abs(d);
		float percent = 0.1f * signal;
		
		Camera c = Cameras.getCurrent();
		Vector inc = c.at.sub(c.eye);
		inc.scale(percent);
		c.eye = c.eye.add(inc);
		setupCamera();
	}

	public void rotateScene(float hrot, float vrot) {
		Camera camera = Cameras.getCurrent();
		Vector forward = camera.eye.sub(camera.at);
		Vector up = camera.up;

		float[] forwardArray = forward.toArray();
		float[] upArray = up.toArray();
		Vector left = new Vector(new Quaternion(upArray, 90.0f).mult(forwardArray));
		left.y = 0.0f;
		
		float[] leftArray = left.toArray();
		Quaternion qx = new Quaternion(upArray, hrot);
		Vector eye = new Vector(qx.mult(forwardArray));

		Quaternion qy = new Quaternion(leftArray, vrot);
		camera.eye = new Vector(qy.mult(eye.toArray())).add(camera.at);
		
		setupCamera();
	}

	public GLCanvas getCanvas() {
		return canvas;
	}
	
	public void addListener(int eventType, Listener listener) {
		canvas.addListener(eventType, listener);
	}

	private void setCurrent() {
		canvas.setCurrent();
	}
	
	/**
	 * @return O tempo que passou desde que a última frame foi desenhada
	 */
	public float timeElapsed() {
		return (float) elapsedTime / (1000.0f); // para segundos
	}
	
	/**
	 * Verifica se uma tecla foi premida
	 * @param keyCode O 'code' da tecla a verificar
	 * @return @c TRUE caso a tecla tenha sido premida
	 * @see KeyEvent
	 */
	public boolean isKeyPressed(int keyCode) {
		return keycodes.contains(keyCode);
	}

}
