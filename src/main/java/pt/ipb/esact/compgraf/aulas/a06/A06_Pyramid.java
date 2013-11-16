package pt.ipb.esact.compgraf.aulas.a06;

import java.io.InputStream;
import java.nio.ByteBuffer;

import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;
import pt.ipb.esact.compgraf.tools.math.Color;
import pt.ipb.esact.compgraf.tools.math.Vector;
import pt.ipb.esact.compgraf.tools.math.VectorList;

import com.jogamp.opengl.util.texture.spi.PNGImage;

public class A06_Pyramid extends SWTGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { -10.0f, 20.0f, -10.0f, 1.0f };
	private Vector cTop;
	private Vector cBackLeft;
	private Vector cBackRight;
	private Vector cFrontRight;
	private Vector cFrontLeft;
	
	public A06_Pyramid(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 1.0f;
		camera.eye.y = 1.0f;
		camera.eye.z = 1.0f;
		
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
		
		// Configurar as texturas
		configureTextures();
		
		// Criar os vertices da piramide
		// Cantos da Piramide
		cTop		= new Vector( 0.0f, 0.8f,  0.0f);
		cBackLeft	= new Vector(-0.5f, 0.0f, -.50f);
		cBackRight	= new Vector( 0.5f, 0.0f, -0.50f);
		cFrontRight	= new Vector( 0.5f, 0.0f,  0.5f);
		cFrontLeft	= new Vector(-0.5f, 0.0f,  0.5f);
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

	private void configureTextures() {
		PNGImage image = null;
		ByteBuffer buffer = null;
		
		// Tentar carregar a imagem a partir do package atual
		try(InputStream stream = getClass().getResourceAsStream("stone.png")) {
			image = PNGImage.read(stream);
			buffer = image.getData();
		} catch (Exception e) {
			// Ocorreu um erro --> Terminar o programa
			exit("Foi impossivel carregar a imagem 'stone.png'");
		}
		
		// Definir a imagem carregada como a atual
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, image.getWidth(), image.getHeight(),
				0, image.getGLFormat(), GL_UNSIGNED_BYTE, buffer);

		// Parametros da textura (ignorar para ja)
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
		
		// Configuracao do Texture Environment
		glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
	}
	
	@Override
	public void release() {
		// Libertar recursos
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glPushAttrib(GL_ENABLE_BIT | GL_CURRENT_BIT | GL_LIGHTING_BIT);
			// Desativar temporariamente a textura para desenhar o chão
			glDisable(GL_TEXTURE_2D);
			Color.DARKGRAY.set();
			demo().drawFloor(10.0f, 10, 1.0f, true);
		glPopAttrib();
		
		glBegin(GL_TRIANGLES);
		
			// Seccao do Fundo (2 triangulos)
			glNormal3f(0f, -1f, 0f); // Virada para baixo
			
			// Bottom 0
			glTexCoord2f(1f, 1f);
			cBackRight.vertex();
			glTexCoord2f(0f, 0f);
			cFrontLeft.vertex();
			glTexCoord2f(1f, 0f);
			cBackLeft.vertex();
			
			// Bottom 1	    	
			glTexCoord2f(1f, 1f);
			cBackRight.vertex();
			glTexCoord2f(0f, 1f);
			cFrontRight.vertex();
			glTexCoord2f(0f, 0f);
			cFrontLeft.vertex();
			
			// Face da Frente
			VectorList.normal(cTop, cFrontLeft, cFrontRight);
			glTexCoord2f(.5f, 1f);
			cTop.vertex();
			glTexCoord2f(0f, 0f);
			cFrontLeft.vertex();
			glTexCoord2f(1f, 0f);
			cFrontRight.vertex();
			
			// Face da Esquerda
			VectorList.normal(cTop, cBackLeft, cFrontLeft);
			glTexCoord2f(.5f, 1f);
			cTop.vertex();
			glTexCoord2f(0f, 0f);
			cBackLeft.vertex();
			glTexCoord2f(1f, 0f);
			cFrontLeft.vertex();
			
			// Face de Tras
			VectorList.normal(cTop, cBackRight, cBackLeft);
			glTexCoord2f(.5f, 1f);
			cTop.vertex();
			glTexCoord2f(0f, 0f);
			cBackRight.vertex();
			glTexCoord2f(1f, 0f);
			cBackLeft.vertex();
			
			// Face da Direita
			VectorList.normal(cTop, cFrontRight, cBackRight);
			glTexCoord2f(.5f, 1f);
			cTop.vertex();
			glTexCoord2f(0f, 0f);
			cFrontRight.vertex();
			glTexCoord2f(1f, 0f);
			cBackRight.vertex();
		
		glEnd();
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 30.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A06 Pyramid");
		display.start(new A06_Pyramid(display.getShell()));
	}

}
