package pt.ipb.esact.compgraf.tools.math;

import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;

public class GLPrimitives {

	private static GL2 gl() {
		return GLContext.getCurrentGL().getGL2();
	}
	
	public static void drawSphere(float radius, int slices, int stacks) {
		GL2 gl = gl();
		
		float drho = (float)(Math.PI) / (float) stacks;
		float dtheta = 2.0f * (float)(Math.PI) / (float) slices;
		float ds = 1.0f / (float) slices;
		float dt = 1.0f / (float) stacks;
		float t = 1.0f;
		float s = 0.0f;
		int i, j;     // Looping variables

		for (i = 0; i < stacks; i++) {
			float rho = (float)i * drho;
			float srho = (float)(Math.sin(rho));
			float crho = (float)(Math.cos(rho));
			float srhodrho = (float)(Math.sin(rho + drho));
			float crhodrho = (float)(Math.cos(rho + drho));

			// Many sources of OpenGL sphere drawing code uses a triangle fan
			// for the caps of the sphere. This however introduces texturing
			// artifacts at the poles on some OpenGL implementations
			gl.glBegin(GL2.GL_TRIANGLE_STRIP);
			s = 0.0f;
			for ( j = 0; j <= slices; j++) {
				float theta = (j == slices) ? 0.0f : j * dtheta;
				float stheta = (float)(-Math.sin(theta));
				float ctheta = (float)(Math.cos(theta));

				float x = stheta * srho;
				float y = ctheta * srho;
				float z = crho;

				gl.glTexCoord2f(s, t);
				gl.glNormal3f(x, y, z);
				gl.glVertex3f(x * radius, y * radius, z * radius);

				x = stheta * srhodrho;
				y = ctheta * srhodrho;
				z = crhodrho;
				gl.glTexCoord2f(s, t - dt);
				s += ds;
				gl.glNormal3f(x, y, z);
				gl.glVertex3f(x * radius, y * radius, z * radius);
			}
			gl.glEnd();

			t -= dt;
		}
	}

}
