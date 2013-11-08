package pt.ipb.esact.compgraf.aulas.a06;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

import com.jogamp.opengl.util.texture.spi.PNGImage;

public class A06_Tunnel extends SWTGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { -10.0f, 20.0f, -10.0f, 1.0f };
	
	public A06_Tunnel(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 0.0f;
		camera.eye.y = 1.0f;
		camera.eye.z = 6.0f;
		
		camera.at.y = 1.0f;
		
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
	
	// Representam as posições (identificadores) das texturas
	private int TEX_BRICK;
	private int TEX_FLOOR;
	private int TEX_CEILING;
	
	// Array com os IDs dos texture objects ('gavetas')
	private IntBuffer textures; 
	
	private void configureTextures() {
		int textureCount = 3;
		textures = IntBuffer.allocate(textureCount);
		
		/**
		 * Criar os texture objects necessários para o exemplo
		 * Depois de executar este comando o buffer 'textures' conterá os IDs
		 * dos texture objects
		 */
		glGenTextures(textureCount, textures);
		
		// Associar os IDs às variáveis
		TEX_BRICK = textures.get(0);
		TEX_FLOOR = textures.get(1);
		TEX_CEILING = textures.get(2);
		
		// Posição 1 das texturas -> brick.png
		setupTexture("brick.png", TEX_BRICK);
		
		// Posição 2 das texturas -> brick.png
		setupTexture("floor.png", TEX_FLOOR);
		
		// Posição 3 das texturas -> brick.png
		setupTexture("ceiling.png", TEX_CEILING);
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
	}

	private void setupTexture(String name, int textureId) {
		PNGImage image = null;
		ByteBuffer buffer = null;
		
		System.out.println("loading " + name + " into " + textureId);
		// Tentar carregar a imagem a partir do package atual
		try(InputStream stream = getClass().getResourceAsStream(name)) {
			image = PNGImage.read(stream);
			buffer = image.getData();
		} catch (Exception e) {
			// Ocorreu um erro --> Terminar o programa
			exit("Foi impossivel carregar a imagem '" + name + "'");
		}
		
		// Fazer o bind do estado da textura ao identificador
		glBindTexture(GL_TEXTURE_2D, textureId);

		// Carregar os mipmaps para a textura
		gluBuild2DMipmaps(GL_TEXTURE_2D, GL_RGBA, image.getWidth(), image.getHeight(), image.getGLFormat(), GL_UNSIGNED_BYTE, buffer);

		// Parametros da textura (ignorar para ja)
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

	}

	
	private String currentFiltering = "GL_LINEAR_MIPMAP_LINEAR";
	
	/**
	 * Iremos capturar as teclas 1 ~ 5 e alternar o tipo de filtering
	 */
	@Override
	protected void onKeyUp(KeyEvent e) {
		
		switch (e.keyCode) {
			case '1':
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
				currentFiltering = "GL_NEAREST";
				break;
	
			case '2':
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
				currentFiltering = "GL_LINEAR";
				break;
	
			case '3':
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST_MIPMAP_NEAREST);
				currentFiltering = "GL_NEAREST_MIPMAP_NEAREST";
				break;
	
			case '4':
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST_MIPMAP_LINEAR);
				currentFiltering = "GL_NEAREST_MIPMAP_LINEAR";
				break;
	
			case '5':
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_NEAREST);
				currentFiltering = "GL_LINEAR_MIPMAP_NEAREST";
				break;
	
			case '6':
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
				currentFiltering = "GL_LINEAR_MIPMAP_LINEAR";
			break;
	
		}
	}
	
	@Override
	public void release() {
		// Libertar recursos
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glColor3f(1.0f, 1.0f, 1.0f);
		glPushMatrix();

			// Desenhar o chao
			glBindTexture(GL_TEXTURE_2D, TEX_FLOOR);
			drawWall();
	
			// Desenhar o tecto
			glBindTexture(GL_TEXTURE_2D, TEX_CEILING);
			glPushMatrix();
				glTranslatef(0f, 2f, 0f);
				glRotatef(180f, 0f, 0f, -1f);
				drawWall();
			glPopMatrix();
	
			// Desenhar a Parede da Esquerda
			glBindTexture(GL_TEXTURE_2D, TEX_BRICK);
			glPushMatrix();
				glTranslatef(-1f, 1f, 0f);
				glRotatef(90f, 0f, 0f, -1f);
				drawWall();
			glPopMatrix();
	
			// Desenhar a Parede da Direita
			glPushMatrix();
				glTranslatef(1f, 1f, 0f);
				glRotatef(90f, 0f, 0f, 1f);
				drawWall();
			glPopMatrix();

		glPopMatrix();
		
		renderText("Current Min Filter: " + currentFiltering, 10, 20);
	}
	
	private void drawWall() {
		for (float z = 6f; z >= 0f; z -= 1f) {
			glBegin(GL_QUADS);
			glTexCoord2f(0f, 0f);
			glVertex3f(-1f, 0f, z);

			glTexCoord2f(0f, 1f);
			glVertex3f(1f, 0f, z);

			glTexCoord2f(1f, 1f);
			glVertex3f(1f, 0f, z - 1f);

			glTexCoord2f(1f, 0f);
			glVertex3f(-1f, 0f, z - 1f);
			glEnd();
		}
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 30.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A06 Tunnel");
		display.start(new A06_Tunnel(display.getShell()));
	}

}
