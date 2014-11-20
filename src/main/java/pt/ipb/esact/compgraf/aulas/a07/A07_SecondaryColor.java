package pt.ipb.esact.compgraf.aulas.a07;

import java.awt.event.KeyEvent;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.math.Colors;
import pt.ipb.esact.compgraf.tools.math.GLPrimitives;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import com.jogamp.opengl.util.texture.Texture;

public class A07_SecondaryColor extends DefaultGLWindow {

	// Variaveis das rotações dos objetos
	private float earthRot = 0.0f;
	private float earthRotSpeed = 0.1f * GL_PI;

	private float moonEarthDistance = 3.0f;
	private float moonTilt = 0.3f * GL_PI;

	private float moonRot = 0.0f;
	private float moonRotSpeed = 5.7f * GL_PI;

	private float moonTrl = 0.0f;
	private float moonTrlSpeed = 1.05f * GL_PI;

	// Texturas do exemplo
	private Texture TEX_EARTH;
	private Texture TEX_MOON;
	
	// Colocar uma skybox no exemplo
	private Skybox skybox;
	
	public A07_SecondaryColor() {
		super("A06 Secondary Color", true);
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

		// Configurar as luzes
		configureLighting();
		
		// Configurar os materiais
		configureMaterials();
		
		// Configurar as texturas
		configureTextures();
		
		// Criar uma skybox
		skybox = new Skybox(this);
		skybox.load("skybox/px.png", "skybox/py.png", "skybox/pz.png", "skybox/nx.png", "skybox/ny.png", "skybox/nz.png");
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
		// Este é o array com o RGB da luz especular
		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));;		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.8f, 0.8f, 0.0f, 1.0f));;		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));;		// Componente especular

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}
	
	private void configureTextures() {
		// Setup das texturas
		TEX_EARTH = loadPackageTexture("earth.png");
		TEX_MOON = loadPackageTexture("moon.png");
		
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
		TEX_EARTH.destroy(this);
		TEX_MOON.destroy(this);
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-20.0f, 0.0f, 0.0f, 1.0f));
		
		// Desenhar a skybox primeiro
		skybox.render();
		
		// Utilizar cor cinza onde não há textura
		glColor3f(0.5f, 0.5f, 0.5f);

		// Desenhar a Terra
		glPushMatrix();

			// Desenhar e rodar a Terra
			glPushMatrix();
				TEX_EARTH.bind(this);
				glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
				/*
				 * Por causa do rotate 90º em -X -> o eixo vertical é agora o Z
				 */
				glRotatef(toDegrees(earthRot), 0.0f, 0.0f, 1.0f);
				glScalef(1.0f, 1.0f, 0.8f); // Achatar ligeiramente os polos
				GLPrimitives.drawSphere(1.0f, 100, 100);
			glPopMatrix();

			// Aplicar o tilt da lua
			glRotatef(toDegrees(moonTilt), 0.0f, 0.0f, 1.0f);

			// Desenhar a orbita da lua
			drawOrbit(moonEarthDistance);

			// Avançar e transladar a Lua
			glRotatef(toDegrees(moonTrl), 0.0f, 1.0f, 0.0f);
			glTranslatef(moonEarthDistance, 0.0f, 0.0f);

			// Estamos no sítio certo para desenhar a lua
			// Desenhar e rodar a Lua
			glPushMatrix();
				TEX_MOON.bind(this);
				glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
				glRotatef(toDegrees(moonRot), 0.0f, 0.0f, 1.0f);
				GLPrimitives.drawSphere(0.3f, 100, 100);
			glPopMatrix();

		glPopMatrix();

		// Ataualizar as variáveis das rotações
		updateRotations();
		
		renderText("separate color: " + (separateColor ? "enabled" : "disabled"), 10, 20);
		renderText("      earthRot: " + toDegrees(earthRotSpeed) + " DEG/s - " + toDegrees(earthRot) + " DEG", 10, 40);
		renderText("       moonRot: " + toDegrees(moonRotSpeed) + " DEG/s - " + toDegrees(moonRot) + " DEG", 10, 50);
		
		renderText("s: toggle separate color", width - 200, 20);
	}
	
	void drawOrbit(float radius) {
		glPushAttrib(GL_CURRENT_BIT | GL_LIGHTING_BIT | GL_ENABLE_BIT);
			glDisable(GL_TEXTURE_2D);
			glDisable(GL_LIGHTING);
			GLPrimitives.drawCircle(radius, Colors.DARKGRAY, Vectors.ORIGIN);
		glPopAttrib();
	}
	
	private float incrementRadians(float current, float increment) {
		current += increment * timeElapsed();
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
		setProjectionPerspective(width, height, 100.0f, 0.001f, 300.0f);
		Cameras.setCurrent(new Camera(0, 0, 4));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A07_SecondaryColor();
	}

}
