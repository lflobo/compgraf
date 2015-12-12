package pt.ipb.esact.compgraf.tools.math;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class GlMath {
	
	public static final Vector3f VECTOR_UP = new Vector3f(0, 1, 0);
	public static final Vector3f VECTOR_FORWARD = new Vector3f(0, 0, 1);

	public static float clamp(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	public static int clamp(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}

	public static Vector3f rotate(float angle, Vector3f axis, Vector3f vector) {
		Quat4f q = new Quat4f();
		q.set(new AxisAngle4f(axis, (float) Math.toRadians(angle)));
		
		Matrix4f m = new Matrix4f();
		m.set(q);
		
		Vector3f result = new Vector3f(vector);
		m.transform(result);
		return result;
	}
	
}
