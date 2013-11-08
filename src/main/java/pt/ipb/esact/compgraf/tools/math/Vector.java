package pt.ipb.esact.compgraf.tools.math;

import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;
import javax.vecmath.Vector3f;

@SuppressWarnings("serial")
public class Vector extends Vector3f {
	
	public static final Vector ZERO = new Vector();
	public static final Vector ORIGIN = new Vector(0.0f, 0.0f, 0.0f);
	public static final Vector UP = new Vector(0.0f, 1.0f, 0.0f);;
	public static final Vector LEFT = new Vector(-1.0f, 0.0f, 0.0f);;
	public static final Vector FORWARD = new Vector(0.0f, 0.0f, 1.0f);;

	public Vector() {
	}
	
	public Vector(float x, float y, float z) {
		super(x, y, z);
	}

	public Vector(float[] xyz) {
		super(xyz);
	}

	public Vector(Vector v) {
		super(v);
	}

	private GL2 gl() {
		return GLContext.getCurrentGL().getGL2();
	}
	
	public void paint() {
		paint(Vector.ZERO, Color.WHITE);
	}
	
	public void paint(Color color) {
		paint(Vector.ZERO, color);
	}
	
	public void paint(Vector at, Color color) {
		GL2 gl = gl();
		if(lengthSquared() == 0)
			return;

		gl.glPushAttrib(GL2.GL_ENABLE_BIT);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			gl.glDisable(GL2.GL_LIGHTING);

			gl.glPushAttrib(GL2.GL_CURRENT_BIT | GL2.GL_LIGHTING_BIT);
				color.set();
				gl.glPushMatrix();
					if(!at.isOrigin())
						gl.glTranslatef(at.x, at.y, at.z);
	
					gl.glBegin(GL2.GL_LINES);
						gl.glVertex3f(0.0f, 0.0f, 0.0f);
						gl.glVertex3f(x, y, z);
					gl.glEnd();
	
					gl.glPushMatrix();
						gl.glTranslatef(x, y, z);
						GLPrimitives.drawSphere(0.05f, 10, 10);
					gl.glPopMatrix();
				gl.glPopMatrix();
			gl.glPopAttrib();
		gl.glPopAttrib();
	}

	public Vector sub(Vector other) {
		Vector v = new Vector(this);
		v.sub(this, other);
		return v;
	}

	public Vector add(Vector other) {
		Vector v = new Vector(this);
		v.add(this, other);
		return v;
	}

	public Vector cross(Vector other) {
		Vector v = new Vector(this);
		v.cross(this, other);
		return v;
	}

	/**
	 * Verifica se o vector atual corresponde à origam
	 * @return Se o vector corresponde à origem
	 */
	public boolean isOrigin() {
		return equals(ORIGIN);
	}

	/**
	 * Converter o vector num array de floats
	 * @return O array de floats que representa o vector atual
	 */
	public float[] toArray() {
		return new float[] {x, y, z};
	}
	
	/**
	 * Invoca a função glVertex3f(...) com as coordenadas do vector atual
	 */
	public void vertex() {
		GL2 gl = gl();
		gl.glVertex3f(x, y, z);
	}
	
}
