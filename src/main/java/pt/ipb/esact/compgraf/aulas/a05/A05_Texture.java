package pt.ipb.esact.compgraf.aulas.a05;

import java.awt.event.KeyEvent;
import java.io.InputStream;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.math.GLPrimitives;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class A05_Texture extends DefaultGLWindow {

	private Texture textBrick;
	private Texture texFloor;
	private Texture texCeiling;
	private Texture textStone;
	private Texture textMoon;

	public A05_Texture() {
		super("A05 Texture", true);
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
		// Ativar as texturas globalmente
		glEnable(GL_TEXTURE_2D);
		
		// A textura deve ser MODULTE'd (multiplicada) pelo material
		glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
		
		// Descomentar para fazer o blend da textura com uma cor
		/*
		glTexEnvfv(GL_TEXTURE_ENV, GL_TEXTURE_ENV_COLOR, newFloatBuffer(1, 0, 0, 1));
		glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_BLEND);
		*/

		// Carregar as texturas
		textStone = createTexture("assets/tex/stone.png");
		textBrick = createTexture("assets/tex/brick.png");
		texFloor = createTexture("assets/tex/floor.png");
		texCeiling = createTexture("assets/tex/ceiling.png");
		textMoon = createTexture("assets/tex/moon.png");
	}

	private Texture createTexture(String name) {
		try(InputStream stream = fileStream(name)) {
            Texture tex = TextureIO.newTexture(stream, true, TextureIO.PNG);
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
		textStone.destroy(this);
		textBrick.destroy(this);
		texCeiling.destroy(this);
		textMoon.destroy(this);
		texFloor.destroy(this);
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glColor3f(1.0f, 1.0f, 1.0f);

		// Desenhar o chao
		texFloor.bind(this);
        drawWall();

		// Desenhar o tecto
		texCeiling.bind(this);
		glPushMatrix();
			glTranslatef(0f, 2f, 0f);
			glRotatef(180f, 0f, 0f, -1f);
			drawWall();
		glPopMatrix();

		// Desenhar a Parede da Esquerda
		textBrick.bind(this);
		glPushMatrix();
			glTranslatef(-1f, 1f, 0f);
			glRotatef(90f, 0f, 0f, -1f);
			drawWall();
		glPopMatrix();

		// Desenhar a Parede da Direita
		textStone.bind(this);
		glPushMatrix();
			glTranslatef(1f, 1f, 0f);
			glRotatef(90f, 0f, 0f, 1f);
			drawWall();
		glPopMatrix();

		textMoon.bind(this);
        glPushMatrix();
			glRotatef(90, -1, 0, 0);
			glTranslatef(0, 0, 1f);
			GLPrimitives.drawSphere(0.6f, 32, 32);
		glPopMatrix();
		
	}
	
	@Override
	protected void onKeyUp(KeyEvent e) {

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
		Camera camera = new Camera(0, 1, 1);
		Cameras.setCurrent(camera);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A05_Texture();
	}

}
