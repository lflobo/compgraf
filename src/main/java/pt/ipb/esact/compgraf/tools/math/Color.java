package pt.ipb.esact.compgraf.tools.math;

import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;
import javax.vecmath.Color4f;

@SuppressWarnings("serial")
public class Color extends Color4f {

	public static final Color RED = new Color(1.0f, 0.0f, 0.0f, 1.0f);
	public static final Color GREEN = new Color(0.0f, 1.0f, 0.0f, 1.0f);
	public static final Color BLUE = new Color(0.0f, 0.0f, 1.0f, 1.0f);
	public static final Color WHITE = new Color(1.0f, 1.0f, 1.0f, 1.0f);
	public static final Color GRAY = new Color(0.5f, 0.5f, 0.5f, 1.0f);
	public static final Color LIGHT_GRAY = new Color(0.8f, 0.8f, 0.8f, 1.0f);

	private GL2 gl() {
		return GLContext.getCurrentGL().getGL2();
	}
	
	public Color() {
		super();
	}

	public Color(Color color) {
		super(color);
	}

	public Color(float r, float g, float b, float a) {
		super(r, g, b, a);
	}

	public Color(float[] rgba) {
		super(rgba);
	}

	public void set() {
		gl().glColor4f(x, y, z, w);
	}
	
}
