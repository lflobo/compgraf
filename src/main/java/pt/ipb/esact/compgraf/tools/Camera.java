package pt.ipb.esact.compgraf.tools;

import pt.ipb.esact.compgraf.tools.math.Vector;

public class Camera {

	public Vector eye = new Vector(0.0f, 1.0f, 1.0f);
	
	public Vector at = Vector.ORIGIN;
	
	public Vector up = Vector.UP;
	
	public Camera() {
	}
	
	public Camera(float eyeX, float eyeY, float eyeZ) {
		eye = new Vector(eyeX, eyeY, eyeZ);
	}
	
	public Vector forward() {
		return eye.sub(at);
	}
	
}
