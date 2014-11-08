package pt.ipb.esact.compgraf.aulas.a06;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class A06_Texture extends DefaultGLWindow {

	private Texture TEX_BRICK;
	private Texture TEX_FLOOR;
	private Texture TEX_CEILING;
	private Texture TEX_STONE;

	public A06_Texture() {
		super("A06 Texture", true);
		setMousePan(true);
		setMouseZoom(true);
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
		glMaterialfv(GL_FRONT, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));
	}
	
	private void configureTextures() {
		TEX_STONE = createTexture("stone.png");
		TEX_BRICK = createTexture("brick.png");
		TEX_FLOOR = createTexture("floor.png");
		TEX_CEILING = createTexture("ceiling.png");
		glEnable(GL_TEXTURE_2D);
	}

	private Texture createTexture(String name) {
		try {
			Texture tex = TextureIO.newTexture(packageFile(name), true, TextureIO.PNG);
			tex.setTexParameteri(this, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			tex.setTexParameteri(this, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
			tex.setTexParameteri(this, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
			tex.setTexParameteri(this, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
			return tex;
		} catch (Exception e) {
			// Ocorreu um erro --> Terminar o programa
			exit("Foi impossivel carregar a imagem '" + name + "'");
			return null;
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
			TEX_FLOOR.bind(this);
			drawWall();
	
			// Desenhar o tecto
			TEX_CEILING.bind(this);
			glPushMatrix();
				glTranslatef(0f, 2f, 0f);
				glRotatef(180f, 0f, 0f, -1f);
				drawWall();
			glPopMatrix();
	
			// Desenhar a Parede da Esquerda
			TEX_BRICK.bind(this);
			glPushMatrix();
				glTranslatef(-1f, 1f, 0f);
				glRotatef(90f, 0f, 0f, -1f);
				drawWall();
			glPopMatrix();
	
			// Desenhar a Parede da Direita
			TEX_STONE.bind(this);
			glPushMatrix();
				glTranslatef(1f, 1f, 0f);
				glRotatef(90f, 0f, 0f, 1f);
				drawWall();
			glPopMatrix();

		glPopMatrix();
	}
	
	/**
	 * Desenha uma parede no plano x/z com largura = 2 e comprimento = 6
	 * e alinhada com o eixo-z
	 */
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
		Camera camera = new Camera(0, 1, 6);
		camera.at.y = 1.0f;
		Cameras.setCurrent(camera);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A06_Texture();
	}

}
