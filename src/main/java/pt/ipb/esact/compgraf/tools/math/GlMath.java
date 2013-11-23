package pt.ipb.esact.compgraf.tools.math;

public class GlMath {

	public static float clamp(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}
	
}
