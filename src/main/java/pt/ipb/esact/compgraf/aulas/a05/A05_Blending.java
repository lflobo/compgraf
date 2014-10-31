package pt.ipb.esact.compgraf.aulas.a05;

import java.awt.event.KeyEvent;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class A05_Blending extends DefaultGLWindow {

	public A05_Blending() {
		super("A05 Blending", true);
		setMousePan(true);
		setMouseZoom(true);
	}
	
	/**
	 * Desenha 4 Esferas
	 */
	void drawWorld() {

		// Desenhar 4 Esferas
		float radius = 3.0f;
		int slices = 32;
		int stacks = 16;
		float height = 5.0f;

		// Guardar o estado dos materiais e cores para repor mais tarde
		glPushAttrib(GL_LIGHTING_BIT | GL_CURRENT_BIT);
		
			// Esferas a vermelho
			glColor4f(1.0f, 0.0f, 0.0f, 0.5f);

			// Esfera 1
			glPushMatrix();
				glTranslatef(8.0f, height, 8.0f);
				glutSolidSphere(radius, slices, stacks);
			glPopMatrix();
	
			// Esfera 2
			glPushMatrix();
				glTranslatef(-8.0f, height, 8.0f);
				glutSolidSphere(radius, slices, stacks);
			glPopMatrix();
	
			// Esfera 3
			glPushMatrix();
				glTranslatef(-8.0f, height, -8.0f);
				glutSolidSphere(radius, slices, stacks);
			glPopMatrix();
	
			// Esfera 4
			glPushMatrix();
				glTranslatef(8.0f, height, -8.0f);
				glutSolidSphere(radius, slices, stacks);
			glPopMatrix();
			
			// Cubo e Piramide a verde
			glColor4f(0.0f, 1.0f, 0.0f, 0.5f);

			// Desenhar um cone
			glPushMatrix();
				glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
				glutSolidCone(radius, height, slices, stacks);
			glPopMatrix();
			
			// Desenhar um Cubo
			glPushMatrix();
				glTranslatef(0.0f, radius * 2.0f, 0.0f);
				glutSolidCube(radius);
			glPopMatrix();
		
		glPopAttrib();
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

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));		// Componente especular
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(0.0f, 5.0f, 0.0f, 1.0f));	// Posição da Luz0

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}

	@Override
	public void release() {
		// Libertar recursos
	}
	
	// Variavel que indica se a transparencia esta ativa
	private boolean transOn = false;
	
	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Desenhar primeiro objectos opacos!!!
		glColor3f(0.5f, 0.5f, 0.5f);
		demo().drawFloor(12.0f, 10);

		glPushAttrib(GL_ENABLE_BIT | GL_DEPTH_BUFFER_BIT);
		
			if(transOn) {
				glEnable(GL_BLEND);
				glDepthMask(false); // Desativar teste de profundidade
				glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			}
			
			// Desenhar depois objetos transparentes
			drawWorld();
			
		glPopAttrib();

		renderText("t - toggle transparency", 10, 20);
	}
	
	@Override
	protected void onKeyUp(KeyEvent e) {
		// Ao premir 't' alternar a transparencia
		if(e.getKeyChar() == 't')
			transOn = ! transOn;
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100, 0.001f, 130.0f);
		Cameras.setCurrent(new Camera(20, 20, 20));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A05_Blending();
	}

}
