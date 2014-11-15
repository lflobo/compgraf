package pt.ipb.esact.compgraf.engine;

import java.nio.IntBuffer;

import javax.media.opengl.GL2;
import javax.vecmath.Vector3f;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.ReleaseListener;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import com.jogamp.opengl.util.texture.Texture;

public class Skybox implements ReleaseListener {

	private Texture TEX_POSITIVE_X;
	private Texture TEX_POSITIVE_Y;
	private Texture TEX_POSITIVE_Z;
	private Texture TEX_NEGATIVE_X;
	private Texture TEX_NEGATIVE_Y;
	private Texture TEX_NEGATIVE_Z;
	
	private DefaultGLWindow gl;
	private IntBuffer textures = IntBuffer.allocate(6);
	
	private int LIST;
	
	private float scale = 100.0f;

	public Skybox(DefaultGLWindow window) {
		this.gl = window;
		window.addReleaseListener(this);
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}
	
	public float getScale() {
		return scale;
	}
	
	public void load(String ddpx, String ddpy, String ddpz, String ddnx, String ddny, String ddnz) {
		// Setup das texturas
		TEX_POSITIVE_X = gl.loadPackageTexture(ddpx);
		TEX_POSITIVE_Y = gl.loadPackageTexture(ddpy);
		TEX_POSITIVE_Z = gl.loadPackageTexture(ddpz);
		TEX_NEGATIVE_X = gl.loadPackageTexture(ddnx);
		TEX_NEGATIVE_Y = gl.loadPackageTexture(ddny);
		TEX_NEGATIVE_Z = gl.loadPackageTexture(ddnz);
		
		create();
	}

	private void create() {
		LIST = gl.glGenLists(1);
		
		gl.glNewList(LIST, GL2.GL_COMPILE);
		
		gl.glPushAttrib(GL2.GL_ENABLE_BIT | GL2.GL_POLYGON_BIT);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			gl.glDisable(GL2.GL_LIGHTING);
			gl.glDisable(GL2.GL_BLEND);
			gl.glDisable(GL2.GL_DEPTH_TEST);
	
			// Ativar o CULLING para as faces de fora (hint: estamos dentro do cube)
			gl.glCullFace(GL2.GL_FRONT);
	
			// Just in case we set all vertices to white.
			gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	
			int mode = GL2.GL_QUADS;
	
			// Quad anterior
			TEX_POSITIVE_Z.bind(gl);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 0); gl.glVertex3f(  scale, -scale, -scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f( -scale, -scale, -scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f( -scale,  scale, -scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f(  scale,  scale, -scale );
			gl.glEnd();
	
			// Quad na direit
			TEX_POSITIVE_X.bind(gl);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 0); gl.glVertex3f(  scale, -scale,  scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f(  scale, -scale, -scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f(  scale,  scale, -scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f(  scale,  scale,  scale );
			gl.glEnd();
	
			// Quad posterior
			TEX_NEGATIVE_Z.bind(gl);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 0); gl.glVertex3f( -scale, -scale,  scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f(  scale, -scale,  scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f(  scale,  scale,  scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f( -scale,  scale,  scale );
			gl.glEnd();
	
			// Quad da esquerda
			TEX_NEGATIVE_X.bind(gl);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 0); gl.glVertex3f( -scale, -scale, -scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f( -scale, -scale,  scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f( -scale,  scale,  scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f( -scale,  scale, -scale );
			gl.glEnd();
	
			// Quad superior
			TEX_POSITIVE_Y.bind(gl);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 1); gl.glVertex3f( -scale,  scale, -scale );
				gl.glTexCoord2f(0, 0); gl.glVertex3f( -scale,  scale,  scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f(  scale,  scale,  scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f(  scale,  scale, -scale );
			gl.glEnd();
	
			// Quad inferior
			TEX_NEGATIVE_Y.bind(gl);
			gl.glBegin(mode);
				gl.glTexCoord2f(1, 0); gl.glVertex3f(  scale, -scale, -scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f(  scale, -scale,  scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f( -scale, -scale,  scale );
				gl.glTexCoord2f(0, 0); gl.glVertex3f( -scale, -scale, -scale );
			gl.glEnd();
	
		// Restore enable bits and matrix
		gl.glPopAttrib();
		
		gl.glEndList();
	}
	
	public void render() {
		Camera cam = Cameras.getCurrent();
		if(cam == null)
			return;
		
		// p = Camera.at - Camera.eye = vetor direcao
		Vector3f p = Vectors.sub(cam.at, cam.eye);
		p.normalize();

		gl.glPushAttrib(GL2.GL_ENABLE_BIT);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			gl.glPushMatrix();
				gl.glLoadIdentity();
				gl.gluLookAt(
					0.0f, -p.y, 0.0f,
					p.x, 0.0f, p.z,
					0.0f, 1.0f, 0.0f
				);
				gl.glCallList(LIST);
			gl.glPopMatrix();
		gl.glPopAttrib();
	}
	
	@Override
	public void release(GL2 gl) {
		gl.glDeleteTextures(textures.capacity(), textures);
		gl.glDeleteLists(LIST, 1);
	}
	
}
