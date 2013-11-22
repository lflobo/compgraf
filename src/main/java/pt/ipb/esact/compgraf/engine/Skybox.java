package pt.ipb.esact.compgraf.engine;

import java.nio.IntBuffer;

import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;

import pt.ipb.esact.compgraf.tools.ReleaseListener;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class Skybox implements ReleaseListener {

	private int TEX_POSITIVE_X;
	private int TEX_POSITIVE_Y;
	private int TEX_POSITIVE_Z;
	private int TEX_NEGATIVE_X;
	private int TEX_NEGATIVE_Y;
	private int TEX_NEGATIVE_Z;
	
	private SWTGLWindow window;
	private IntBuffer textures = IntBuffer.allocate(6);
	
	private int LIST;
	
	private float scale = 10.0f;

	public Skybox(SWTGLWindow window) {
		this.window = window;
		window.addReleaseListener(this);
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}
	
	public float getScale() {
		return scale;
	}
	
	public void load(String ddpx, String ddpy, String ddpz, String ddnx, String ddny, String ddnz) {
		GL2 gl = gl();
		
		// Allocar as texturas
		gl.glGenTextures(6, textures);
		
		// Associar os IDs às variáveis
		TEX_POSITIVE_X = textures.get(0);
		TEX_POSITIVE_Y = textures.get(1);
		TEX_POSITIVE_Z = textures.get(2);
		TEX_NEGATIVE_X = textures.get(3);
		TEX_NEGATIVE_Y = textures.get(4);
		TEX_NEGATIVE_Z = textures.get(5);
		
		// Setup das texturas
		window.loadPackageTexture(ddpx, TEX_POSITIVE_X);
		window.loadPackageTexture(ddpy, TEX_POSITIVE_Y);
		window.loadPackageTexture(ddpz, TEX_POSITIVE_Z);
		window.loadPackageTexture(ddnx, TEX_NEGATIVE_X);
		window.loadPackageTexture(ddny, TEX_NEGATIVE_Y);
		window.loadPackageTexture(ddnz, TEX_NEGATIVE_Z);
		
		create();
	}

	private GL2 gl() {
		return GLContext.getCurrentGL().getGL2();
	}

	private void create() {
		GL2 gl = gl();
		LIST = gl.glGenLists(1);
		
		gl.glNewList(LIST, GL2.GL_COMPILE);
		
		gl.glPushAttrib(GL2.GL_ENABLE_BIT | GL2.GL_POLYGON_BIT);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			gl.glDisable(GL2.GL_LIGHTING);
			gl.glDisable(GL2.GL_BLEND);
	
			// Ativar o CULLING para as faces de fora (hint: estamos dentro do cube)
			gl.glCullFace(GL2.GL_FRONT);
	
			// Just in case we set all vertices to white.
			gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	
			int mode = GL2.GL_QUADS;
	
			// Quad anterior
			gl.glBindTexture(GL2.GL_TEXTURE_2D, TEX_POSITIVE_Z);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 0); gl.glVertex3f(  scale, -scale, -scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f( -scale, -scale, -scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f( -scale,  scale, -scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f(  scale,  scale, -scale );
			gl.glEnd();
	
			// Quad na direit
			gl.glBindTexture(GL2.GL_TEXTURE_2D, TEX_POSITIVE_X);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 0); gl.glVertex3f(  scale, -scale,  scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f(  scale, -scale, -scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f(  scale,  scale, -scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f(  scale,  scale,  scale );
			gl.glEnd();
	
			// Quad posterior
			gl.glBindTexture(GL2.GL_TEXTURE_2D, TEX_NEGATIVE_Z);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 0); gl.glVertex3f( -scale, -scale,  scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f(  scale, -scale,  scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f(  scale,  scale,  scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f( -scale,  scale,  scale );
			gl.glEnd();
	
			// Quad da esquerda
			gl.glBindTexture(GL2.GL_TEXTURE_2D, TEX_NEGATIVE_X);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 0); gl.glVertex3f( -scale, -scale, -scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f( -scale, -scale,  scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f( -scale,  scale,  scale );
				gl.glTexCoord2f(0, 1); gl.glVertex3f( -scale,  scale, -scale );
			gl.glEnd();
	
			// Quad superior
			gl.glBindTexture(GL2.GL_TEXTURE_2D, TEX_POSITIVE_Y);
			gl.glBegin(mode);
				gl.glTexCoord2f(0, 1); gl.glVertex3f( -scale,  scale, -scale );
				gl.glTexCoord2f(0, 0); gl.glVertex3f( -scale,  scale,  scale );
				gl.glTexCoord2f(1, 0); gl.glVertex3f(  scale,  scale,  scale );
				gl.glTexCoord2f(1, 1); gl.glVertex3f(  scale,  scale, -scale );
			gl.glEnd();
	
			// Quad inferior
			gl.glBindTexture(GL2.GL_TEXTURE_2D, TEX_NEGATIVE_Y);
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
		GL2 gl = gl();
		gl.glCallList(LIST);
	}
	
	@Override
	public void release(GL2 gl) {
		gl.glDeleteTextures(textures.capacity(), textures);
	}
	
}
