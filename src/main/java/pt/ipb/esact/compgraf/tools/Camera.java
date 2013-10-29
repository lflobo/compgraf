package pt.ipb.esact.compgraf.tools;

import pt.ipb.esact.compgraf.tools.math.Vector;

public class Camera {

	public Vector eye = new Vector(0.0f, 1.0f, 1.0f);
	
	public Vector at = Vector.ORIGIN;
	
	public Vector up = Vector.UP;
	
}
