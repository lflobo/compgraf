package pt.ipb.esact.compgraf.tools;

import java.util.HashSet;
import java.util.Set;

import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLProfile;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
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

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
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
	
	public SWTGLWindow(Composite parent, boolean continuous) {
		Preconditions.checkNotNull(parent, "The parent cannot be null");
		display = parent.getDisplay();
		
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());

		GLProfile profile = GLProfile.getDefault();
		GLData glData = new GLData();
		glData.depthSize = 16;
		glData.doubleBuffer = true;
		canvas = new GLCanvas(composite, SWT.NO_BACKGROUND, glData);
		setCurrent();

		context = GLDrawableFactory.getFactory(profile).createExternalGLContext();
		
		{
			setCurrent();
			context.makeCurrent();
			setCurrent(context.getGL().getGL2());
			init();
			context.release();
			currentTime = System.nanoTime();
		}
		
		canvas.addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(Event e) {
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
		
		glPushAttrib(GL_LIGHTING_BIT);
	
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
	}
	
	protected void render() {
		Rectangle rectangle = canvas.getClientArea();
		setCurrent();
		context.makeCurrent();
		setCurrent(context.getGL().getGL2());

		currentTime = System.currentTimeMillis();
		elapsedTime = currentTime - lastTime;
		lastTime = currentTime;
		render(rectangle.width, rectangle.height);
		
		canvas.swapBuffers();
		context.release();		
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
