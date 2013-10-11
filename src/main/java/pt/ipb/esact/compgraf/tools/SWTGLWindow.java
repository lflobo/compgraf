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
import org.eclipse.swt.widgets.Shell;

public abstract class SWTGLWindow extends GLUTWrapper implements GLListener {

	private Display display;

	private Shell shell;

	private Composite composite;

	private GLCanvas canvas;

	private GLContext context;
	
	private long elapsedTime = 0L;
	
	private long currentTime = 0L;
	
	private long lastTime = System.currentTimeMillis();
	
	private Set<Integer> keycodes = new HashSet<>();
	
	public SWTGLWindow(String caption, boolean continuous) {
		display = new Display();
		shell = new Shell(display);
		shell.setText(caption);
		shell.setLayout(new FillLayout());
		shell.setSize(800, 600);

		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout());

		GLProfile profile = GLProfile.getDefault();
		GLData glData = new GLData();
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
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.ESC)
					shell.close();
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
		
		shell.open();
		
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		
		dispose();
		canvas.dispose();
		display.dispose();
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
	
	public float timeElapsed() {
		return (float) elapsedTime / (1000.0f); // para segundos
	}
	
	public boolean isKeyPressed(int keyCode) {
		return keycodes.contains(keyCode);
	}

}
