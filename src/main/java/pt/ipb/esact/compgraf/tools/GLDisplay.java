package pt.ipb.esact.compgraf.tools;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Preconditions;

public class GLDisplay {

	private Display display;
	private Shell shell;

	public GLDisplay(String caption) {
		display = new Display();
		shell = new Shell(display);
		shell.setText(caption);
		shell.setLayout(new FillLayout());
		shell.setSize(800, 600);
	}
	
	public void start(GLWindow window) {
		Preconditions.checkNotNull(window, "The window widget cannot be null");
		shell.open();
		
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		
		display.dispose();
		window.dispose();
	}

	public Composite getShell() {
		return shell;
	}

}
