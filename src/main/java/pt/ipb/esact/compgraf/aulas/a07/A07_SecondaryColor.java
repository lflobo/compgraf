package pt.ipb.esact.compgraf.aulas.a07;

import java.awt.event.KeyEvent;
import java.nio.IntBuffer;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.math.Color;
import pt.ipb.esact.compgraf.tools.math.GLPrimitives;
import pt.ipb.esact.compgraf.tools.math.Vector;

public class A07_SecondaryColor extends DefaultGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { -20.0f, 0.0f, 0.0f, 1.0f };

	// Variaveis das rotações dos objetos
	private float earthRot = 0.0f;
	private float earthRotSpeed = 0.01f * GL_PI;

	private float moonEarthDistance = 3.0f;
	private float moonTilt = 0.1f * GL_PI;

	private float moonRot = 0.0f;
	private float moonRotSpeed = 0.02f * GL_PI;

	private float moonTrl = 0.0f;
	private float moonTrlSpeed = 0.005f * GL_PI;

	public A07_SecondaryColor() {
		super("A06 Secondary Color", true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 0.0f;
		camera.eye.y = 0.0f;
		camera.eye.z = 4.0f;
		
		camera.at.y = 0.0f;
		
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
		float[] diffuseLight = { 0.8f, 0.8f, 0.0f, 1.0f };
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
	private int TEX_EARTH;
	private int TEX_MOON;
	
	// Array com os IDs dos texture objects ('gavetas')
	private IntBuffer textures; 
	
	private void configureTextures() {
		int textureCount = 2;
		textures = IntBuffer.allocate(textureCount);

		// Allocar as texturas
		glGenTextures(textureCount, textures);
		
		// Associar os IDs às variáveis
		TEX_EARTH = textures.get(0);
		TEX_MOON = textures.get(1);
		
		// Setup das texturas
		loadPackageTexture("earth.png", TEX_EARTH);
		loadPackageTexture("moon.png", TEX_MOON);
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
		
		// Activar separate color por omissão
		glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);
	}

	// Flag que dita se o separate color está enabled
	private boolean separateColor = true;
	
	@Override
	protected void onKeyUp(KeyEvent e) {
		switch(e.getKeyChar()) {
			case 's':
				separateColor = ! separateColor;
				glLightModeli(
					GL_LIGHT_MODEL_COLOR_CONTROL,
					separateColor ? GL_SEPARATE_SPECULAR_COLOR : GL_SINGLE_COLOR
				);
			break;
		}
	}
	
	@Override
	public void release() {
		// Libertar as texturas (GPU)
		glDeleteTextures(textures.capacity(), textures);
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);
		
		// Utilizar cor cinza onde não há textura
		glColor3f(0.5f, 0.5f, 0.5f);

		// Desenhar a Terra
		glPushMatrix();

			// Desenhar e rodar a Terra
			glPushMatrix();
				glBindTexture(GL_TEXTURE_2D, TEX_EARTH);
				glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
				/*
				 * Por causa do rotate 90º em X -> o eixo vertical é agora o Z
				 */
				glRotatef(toDegrees(earthRot), 0.0f, 0.0f, 1.0f);
				glScalef(1.0f, 1.0f, 0.8f); // Achatar ligeiramente os polos
				GLPrimitives.drawSphere(1.0f, 100, 100);
			glPopMatrix();

			// Aplicar o tilt da lua
			glRotatef(toDegrees(moonTilt), 1.0f, 0.0f, 0.0f);

			// Desenhar a orbita da lua
			drawOrbit(moonEarthDistance);

			// Avançar e transladar a Lua
			glRotatef(toDegrees(moonTrl), 0.0f, 1.0f, 0.0f);
			glTranslatef(moonEarthDistance, 0.0f, 0.0f);

			// Estamos no sítio certo para desenhar a lua
			// Desenhar e rodar a Lua
			glPushMatrix();
				glBindTexture(GL_TEXTURE_2D, TEX_MOON);
				glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
				glRotatef(toDegrees(moonRot), 0.0f, 0.0f, 1.0f);
				GLPrimitives.drawSphere(0.3f, 100, 100);
			glPopMatrix();

		glPopMatrix();

		// Ataualizar as variáveis das rotações
		updateRotations();
		
		renderText("separate color: " + (separateColor ? "enabled" : "disabled"), 10, 20);
		renderText("s: toggle separate color", width - 200, 20);
	}
	
	void drawOrbit(float radius) {
		glPushAttrib(GL_CURRENT_BIT | GL_LIGHTING_BIT | GL_ENABLE_BIT);
			glDisable(GL_TEXTURE_2D);
			glDisable(GL_LIGHTING);
			GLPrimitives.drawCircle(radius, Color.DARKGRAY, Vector.ORIGIN);
		glPopAttrib();
	}
	
	private float incrementRadians(float current, float increment) {
		current += increment;
		current %= 2.0f * GL_PI; // garantir que não passamos de 2PI
		return current;
	}

	private void updateRotations() {
		// Rotação
		earthRot = incrementRadians(earthRot, earthRotSpeed);
		moonRot = incrementRadians(moonRot, moonRotSpeed);

		// Translação
		moonTrl = incrementRadians(moonTrl, moonTrlSpeed);
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 30.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A07_SecondaryColor();
	}

}
