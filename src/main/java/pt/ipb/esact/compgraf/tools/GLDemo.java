package pt.ipb.esact.compgraf.tools;

import javax.media.opengl.GLContext;

import pt.ipb.esact.compgraf.tools.math.Color;
import pt.ipb.esact.compgraf.tools.math.Vector;
import pt.ipb.esact.compgraf.tools.math.VectorList;

public class GLDemo extends GL2Wrapper {
	
	private void sync() {
		setCurrent(GLContext.getCurrentGL().getGL2());
	}
	
	public void drawPlain() {
		drawPlain(false);
	}
	
	public void drawPlain(boolean paintNormals) {
		sync();
		
		boolean calculateNormals = true;
		
		VectorList v = new VectorList();

		// Save the matrix state
		glPushMatrix();

			// Nose Piramid /////////////////////////////
			v.clear();
			v.append(0.0f, 0.0f, 60.0f);
			v.append(new Vector(-15.0f, 0.0f, 30.0f));
			v.append(new Vector(15.0f,0.0f,30.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector(15.0f,0.0f,30.0f));
			v.append(new Vector(0.0f, 15.0f, 30.0f));
			v.append(new Vector(0.0f, 0.0f, 60.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector(0.0f, 0.0f, 60.0f));
			v.append(new Vector(0.0f, 15.0f, 30.0f));
			v.append(new Vector(-15.0f,0.0f,30.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Body of the Plane ////////////////////////
			v.clear();
			v.append(new Vector(-15.0f,0.0f,30.0f));
			v.append(new Vector(0.0f, 15.0f, 30.0f));
			v.append(new Vector(0.0f, 0.0f, -56.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector(0.0f, 0.0f, -56.0f));
			v.append(new Vector(0.0f, 15.0f, 30.0f));
			v.append(new Vector(15.0f,0.0f,30.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector(15.0f,0.0f,30.0f));
			v.append(new Vector(-15.0f, 0.0f, 30.0f));
			v.append(new Vector(0.0f, 0.0f, -56.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			///////////////////////////////////////////////
			// Left wing
			v.clear();
			v.append(new Vector(0.0f,2.0f,27.0f));
			v.append(new Vector(-60.0f, 2.0f, -8.0f));
			v.append(new Vector(60.0f, 2.0f, -8.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector(60.0f, 2.0f, -8.0f));
			v.append(new Vector(0.0f, 7.0f, -8.0f));
			v.append(new Vector(0.0f,2.0f,27.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector(60.0f, 2.0f, -8.0f));
			v.append(new Vector(-60.0f, 2.0f, -8.0f));
			v.append(new Vector(0.0f,7.0f,-8.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Other wing top section
			v.clear();
			v.append(new Vector(0.0f,2.0f,27.0f));
			v.append(new Vector(0.0f, 7.0f, -8.0f));
			v.append(new Vector(-60.0f, 2.0f, -8.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Tail section///////////////////////////////
			v.clear();
			v.append(new Vector(-30.0f, -0.50f, -57.0f));
			v.append(new Vector(30.0f, -0.50f, -57.0f));
			v.append(new Vector(0.0f,-0.50f,-40.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// top of left side
			v.clear();
			v.append(new Vector(0.0f,-0.5f,-40.0f));
			v.append(new Vector(30.0f, -0.5f, -57.0f));
			v.append(new Vector(0.0f, 4.0f, -57.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// top of right side
			v.clear();
			v.append(new Vector(0.0f, 4.0f, -57.0f));
			v.append(new Vector(-30.0f, -0.5f, -57.0f));
			v.append(new Vector(0.0f,-0.5f,-40.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// back of bottom of tail
			v.clear();
			v.append(new Vector(30.0f,-0.5f,-57.0f));
			v.append(new Vector(-30.0f, -0.5f, -57.0f));
			v.append(new Vector(0.0f, 4.0f, -57.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Top of Tail section left
			v.clear();
			v.append(new Vector(0.0f,0.5f,-40.0f));
			v.append(new Vector(3.0f, 0.5f, -57.0f));
			v.append(new Vector(0.0f, 25.0f, -65.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			v.clear();
			v.append(new Vector(0.0f, 25.0f, -65.0f));
			v.append(new Vector(-3.0f, 0.5f, -57.0f));
			v.append(new Vector(0.0f,0.5f,-40.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

			// Back of horizontal section
			v.clear();
			v.append(new Vector(3.0f,0.5f,-57.0f));
			v.append(new Vector(-3.0f, 0.5f, -57.0f));
			v.append(new Vector(0.0f, 25.0f, -65.0f));
			v.paintVertex(GL_TRIANGLES, calculateNormals, paintNormals);

		glPopMatrix();
	}

}
