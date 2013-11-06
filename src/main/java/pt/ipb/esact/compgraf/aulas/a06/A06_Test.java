package pt.ipb.esact.compgraf.aulas.a06;

import java.io.InputStream;
import java.nio.ByteBuffer;

import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

import com.jogamp.opengl.util.texture.spi.PNGImage;

public class A06_Test extends SWTGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { 0.0f, 20.0f, 0.0f, 1.0f };
	
	float[] positionLitght0Inverted = { 0.0f, -20.0f, 0.0f, 1.0f };

	private PNGImage image;

	private byte[] data;

	private ByteBuffer buffer;

	public A06_Test(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 0.0f;
		camera.eye.y = 0.0f;
		camera.eye.z = 20.0f;
		
		Cameras.setCurrent(camera);
	}
	
	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_MULTISAMPLE);
		glEnable(GL_CULL_FACE);

		glCullFace(GL_BACK);

		// Configurar as luzes
		configureLighting();
		
		// Configurar os materiais
		configureMaterials();

//		image = loadImage("test.png");
//		data = toByteArray(image);
		
		try(InputStream stream = getClass().getResourceAsStream("test.png")) {
			image = PNGImage.read(stream);
			buffer = image.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void configureMaterials() {
		// Configurar Color Tracking
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
		glMateriali(GL_FRONT, GL_SHININESS, 100);
		
		// Especularidade do material definida explicitamente
		float[] specRef = {1.0f, 1.0f, 1.0f, 1.0f};
		glMaterialfv(GL_FRONT, GL_SPECULAR, specRef, 0);
	}

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Este é o array com o RGB da luz ambiente
		float[] ambientLight = { 0.6f, 0.6f, 0.6f, 1.0f };
		float[] ambientLowLight = { 0.5f, 0.5f, 0.5f, 1.0f };
		// Este é o array com o RGB da luz difusa
		float[] diffuseLight = { 0.4f, 0.4f, 0.4f, 1.0f };
		// Este é o array com o RGB da luz especular
		float[] specularLight = { 0.5f, 0.5f, 0.5f, 1.0f };

		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, ambientLight, 0);		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuseLight, 0);		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, specularLight, 0);		// Componente especular

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}

	@Override
	public void release() {
		// Libertar recursos
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT);
		glRasterPos2i(width/2, height/2);
		glPixelZoom(1.0f, 1.0f);
		glDrawPixels(image.getWidth(), image.getHeight(), GL_BGRA, GL_UNSIGNED_BYTE, buffer);
	}

	@Override
	public void resize(int width, int height) {
		setProjectionOrtho2D(width, height);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A04 Lighting");
		display.start(new A06_Test(display.getShell()));
	}

}
