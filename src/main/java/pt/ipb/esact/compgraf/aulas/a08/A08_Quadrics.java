package pt.ipb.esact.compgraf.aulas.a08;

import java.nio.IntBuffer;

import javax.media.opengl.glu.GLUquadric;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class A08_Quadrics extends SWTGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { -10.0f, 20.0f, -10.0f, 1.0f };
	
	/**
	 * Variáveis de controlo do planeta / asteróides
	 */
	// Rotação do planeta
	float pRot = 0.0f;
	float pRotSpeed = 0.005f * GL_PI;
	float pTilt = 0.05f * GL_PI;

	// Rotação das nuvens (clouds)
	float cRot = 0.0f;
	float cRotSpeed = 0.15f * GL_PI;

	// Rotação dos asteroides
	float aRot0 = 0.0f;
	float aRot0Speed = 0.05f * GL_PI;

	float aRot1 = 0.0f;
	float aRot1Speed = 0.1f * GL_PI;

	float aTilt = 0.05f * GL_PI;

	/**
	 * Identificadores das listas gerados no método createDisplayLists();
	 */
	private int LIST_AST_0;
	private int LIST_AST_1;
	private int LIST_PLANET;
	private int LIST_CLOUDS;
	
	// Objeto que desenha uma skybox (inicializada no construtor)
	Skybox skybox;
	
	public A08_Quadrics(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 0.0f;
		camera.eye.y = 0.5f;
		camera.eye.z = 6.0f;
		
		camera.at.y = 0.0f;
		
		Cameras.setCurrent(camera);
		
		// Inicializar a skybox
		skybox = new Skybox(this);
	}
	
	private int createListAsteroidBelt(int count, float radius, float thickness, float sizeMin, float sizeMax, int texture) {
		// Criar uma Display List
		int id = glGenLists(1);
		glNewList(id, GL_COMPILE);
		
		// Criar um quadric para as esferas (asteroides)
		GLUquadric quad = gluNewQuadric();
		
		// Configurar o quad
		gluQuadricNormals(quad, GLU_SMOOTH);
		gluQuadricDrawStyle(quad, GLU_FILL);
		gluQuadricTexture(quad, true);
		
		// Utilizar a textura passada como argumento
		glBindTexture(GL_TEXTURE_2D, texture);

		// Para cada asteroide gerar posicao/angulo aleatorio dentro de um disco
		for(int i=0; i<count; i++) {
			float distance = radius + randomBinomial(thickness);
			float alpha = randomBinomial(2.0f * GL_PI);
			float aradius = sizeMin + random(sizeMax - sizeMin);
			float gray = 0.5f + randomBinomial(0.25f);
			glColor3f(gray, gray, gray);
			glPushMatrix();
				glTranslatef(distance * sinf(alpha), 0.0f, distance * cosf(alpha));
				gluSphere(quad, aradius, 10, 5);
			glPopMatrix();
		}
		
		// Apagar o quad (libertar memoria)
		gluDeleteQuadric(quad);
		
		// Terminamos a lista...
		glEndList();
		
		return id;
	}
		
	private int createListPlanet(float radius, int texture) {
		// Criar uma Display List
		int id = glGenLists(1);
		glNewList(id, GL_COMPILE);
		
		// Criar um quadric para desenhar o planeta
		GLUquadric quad = gluNewQuadric();
		
		// Configurar o quad
		gluQuadricNormals(quad, GLU_SMOOTH);
		gluQuadricDrawStyle(quad, GLU_FILL);
		gluQuadricTexture(quad, true);
		
		// Utilizar a textura passada como argumento
		glBindTexture(GL_TEXTURE_2D, texture);
		
		glPushMatrix();
			// Colocar a esfera de pé
			glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
			gluSphere(quad, radius, 60, 30);
		glPopMatrix();
		
		// Apagar o quad (libertar memoria)
		gluDeleteQuadric(quad);
		
		// Terminamos a lista...
		glEndList();
		
		return id;
	}
	
	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_MULTISAMPLE);
		glEnable(GL_CULL_FACE);

		// Não calcular texturas/material para a parte de trás
		glCullFace(GL_BACK);

		// Configurar as luzes
		configureLighting();
		
		// Configurar os materiais
		configureMaterials();
		
		// Configurar as texturas
		configureTextures();
		
		// Criar as Display Lists
		configureDisplayLists();
		
		// carregar as texturas da skybox
		skybox.load("skybox/dd-px.png", "skybox/dd-py.png", "skybox/dd-pz.png", "skybox/dd-nx.png", "skybox/dd-ny.png", "skybox/dd-nz.png");
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
		
		// Secondary Color
		glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);
	}
	
	// Representam as posições (identificadores) das texturas
	private int TEX_PLANET;
	private int TEX_CLOUDS;
	private int TEX_ASTEROIDS;
	
	// Array com os IDs dos texture objects ('gavetas')
	private IntBuffer textures; 
	
	private void configureTextures() {
		int textureCount = 3;
		textures = IntBuffer.allocate(textureCount);

		// Allocar as texturas
		glGenTextures(textureCount, textures);
		
		// Associar os IDs às variáveis
		TEX_PLANET = textures.get(0);
		TEX_CLOUDS = textures.get(1);
		TEX_ASTEROIDS = textures.get(2);
		
		// Carregar as texturas
		loadPackageTexture("earth.png", TEX_PLANET);
		loadPackageTexture("clouds.png", TEX_CLOUDS);
		loadPackageTexture("asteroid.png", TEX_ASTEROIDS);
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
	}


	private void configureDisplayLists() {
		LIST_AST_0 = createListAsteroidBelt(2000, 3.5f, 0.6f, 0.001f, 0.02f, TEX_ASTEROIDS);
		LIST_AST_1 = createListAsteroidBelt(1000, 4.3f, 0.1f, 0.001f, 0.02f, TEX_ASTEROIDS);
		LIST_PLANET = createListPlanet(1.95f, TEX_PLANET);
		LIST_CLOUDS = createListPlanet(2.0f, TEX_CLOUDS); 
	}

	@Override
	protected void onKeyUp(KeyEvent e) {
		switch (e.keyCode) {
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

		// Desenhar primeiro a skybox
		skybox.render();
		
		// Desenhar os restantes objetos
		drawPlanet();
		drawAsteroids();
		drawClouds();
	}
	
	private void drawPlanet() {
		pRot -= pRotSpeed;
		pRot %= 2.0f * GL_PI;

		glPushMatrix();
			glRotatef(-toDegrees(pTilt), 0.0f, 0.0f, 1.0f);
			glPushMatrix();
				glRotatef(-toDegrees(pRot), 0.0f, 1.0f, 0.0f);
				glCallList(LIST_PLANET);
			glPopMatrix();
		glPopMatrix();
	}
	
	private void drawClouds() {
		cRot += cRotSpeed * timeElapsed();
		cRot %= 2.0f * GL_PI;

		glDisable(GL_COLOR_MATERIAL);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		glPushMatrix();
			glRotatef(-toDegrees(pTilt), 0.0f, 0.0f, 1.0f);
			glPushMatrix();
				glRotatef(toDegrees(cRot), 0.0f, 1.0f, 0.0f);
				glCallList(LIST_CLOUDS);
			glPopMatrix();
		glPopMatrix();

		glDisable(GL_BLEND);
		glEnable(GL_COLOR_MATERIAL);
	}

	private void drawAsteroids() {
		aRot0 += aRot0Speed * timeElapsed() * 5.0f;
		aRot0 %= 2.0f * GL_PI;

		aRot1 += aRot1Speed * timeElapsed();
		aRot1 %= 2.0f * GL_PI;

		glPushMatrix();
			glRotatef(toDegrees(aTilt), 0.0f, 0.0f, 1.0f);
			glPushMatrix();
				glRotatef(toDegrees(aRot0), 0.0f, 1.0f, 0.0f);
				glCallList(LIST_AST_0);
			glPopMatrix();
			glPushMatrix();
				glRotatef(toDegrees(aRot1), 0.0f, 1.0f, 0.0f);
				glCallList(LIST_AST_1);
			glPopMatrix();
		glPopMatrix();
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 2000.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A08 Quadrics");
		display.start(new A08_Quadrics(display.getShell()));
	}

}
