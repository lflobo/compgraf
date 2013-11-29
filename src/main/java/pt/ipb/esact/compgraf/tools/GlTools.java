package pt.ipb.esact.compgraf.tools;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.gl2.GLUgl2;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.spi.JPEGImage;
import com.jogamp.opengl.util.texture.spi.PNGImage;
import com.jogamp.opengl.util.texture.spi.TGAImage;

public class GlTools {

	private static boolean anisotropicAvailable = false;
	
	private static float maxAnisotropy = 0.0f;
	
	private static GLU glu;

	private static GLUT glut;

	static {
		// Verificar se a extensão está disponível
		anisotropicAvailable = isExtensionAvailable("GL_EXT_texture_filter_anisotropic");
		
		// Se não está disponível parar por aqui
		if(anisotropicAvailable) {
			// Obter o valor mínimo/máximo de anisotropia suportado
			FloatBuffer values = FloatBuffer.allocate(1);
			gl().glGetFloatv(GL2.GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT, values);
			maxAnisotropy = values.get(0);
		}
		
		glu = new GLUgl2();
		glut = new GLUT();
	}
	
	/**
	 * Carrega uma textura a partir da package da classe do objeto reference
	 * @param reference O objeto que serve de referencia
	 * @param path A path dentro da package atual
	 * @param textureId O ID do Texture Object
	 */
	public static void loadPackageTexture(Object reference, String path, int textureId) {
		GL2 gl = gl();
		GLU glu = glu();
		ByteBuffer buffer = null;
		
		// Tentar carregar a imagem a partir do package atual
		int width = 0;
		int height = 0;
		int format = 0;
		try(InputStream stream = reference.getClass().getResourceAsStream(path)) {
			if(path.toLowerCase().endsWith("png")) {
				PNGImage image = PNGImage.read(stream);
				width = image.getWidth();
				height = image.getHeight();
				format = image.getGLFormat();
				buffer = image.getData();
			} else if(path.toLowerCase().endsWith("jpg")) {
				JPEGImage image = JPEGImage.read(stream);
				width = image.getWidth();
				height = image.getHeight();
				format = image.getGLFormat();
				buffer = image.getData();
			} else if(path.toLowerCase().endsWith("tga")) {
				TGAImage image = TGAImage.read(gl().getGLProfile(), stream);
				width = image.getWidth();
				height = image.getHeight();
				format = image.getGLFormat();
				buffer = image.getData();
			} else
				throw new GLException("Unsupported file type: " + path);
		} catch (Exception e) {
			// Ocorreu um erro --> Terminar o programa
			exit("Foi impossivel carregar a imagem '" + path + "':\n" + e.getMessage());
		}
		
		// Fazer o bind do estado da textura ao identificador
		gl.glBindTexture(GL2.GL_TEXTURE_2D, textureId);

		// Carregar os mipmaps para a textura
		glu.gluBuild2DMipmaps(GL2.GL_TEXTURE_2D, GL2.GL_RGBA, width, height, format, GL2.GL_UNSIGNED_BYTE, buffer);

		// Parametros da textura (ignorar para ja)
		gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_LINEAR);
		gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_LINEAR_MIPMAP_LINEAR);
		gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_CLAMP_TO_EDGE);
		gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_CLAMP_TO_EDGE);

		// Configurar a anisotropy para a nossa textura
		if(isAnisotropicAvailable())
			gl.glTexParameterf(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MAX_ANISOTROPY_EXT, getMaxAnisotropy());
	}

	public static float getMaxAnisotropy() {
		return maxAnisotropy;
	}

	private static GLU glu() {
		return glu;
	}

	public static boolean isAnisotropicAvailable() {
		return anisotropicAvailable;
	}

	private static boolean isExtensionAvailable(String extension) {
		return gl().isExtensionAvailable(extension);
	}

	public static void exit(String error) {
		Display display = Display.getCurrent();
		if(display != null) {
			MessageBox box = new MessageBox(new Shell(display));
			box.setText("Error");
			box.setMessage(error);
			box.open();
		} else {
			System.out.println(error);
		}
		System.exit(0);		
	}

	public static GL2 gl() {
		return GLContext.getCurrentGL().getGL2();
	}

	public static GLUT glut() {
		return glut;
	}

}
