package pt.ipb.esact.compgraf.aulas.a05;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class A05_Mirror extends SWTGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { 0.0f, 20.0f, 0.0f, 1.0f };
	
	float[] positionLitght0Inverted = { 0.0f, -20.0f, 0.0f, 1.0f };
	
	public A05_Mirror(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 20.0f;
		camera.eye.y = 20.0f;
		camera.eye.z = 20.0f;
		
		Cameras.setCurrent(camera);
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
	
	// Variavel que indica se a transparencia esta ativa
	private boolean transOn = false;
	
	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		// Desenhar a luz invertida
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0Inverted, 0);

		// Desenhar objetos invertidos
		glPushMatrix();
			// Inverter mundo em Y
			glScalef(1.0f, -1.0f, 1.0f);
			
			// Normais/Triangulos estão também invertidos -> inverter winding
			glFrontFace(GL_CW);
			
			drawWorld();
			
			// Report winding
			glFrontFace(GL_CCW);
		glPopMatrix();
		
		glPushAttrib(GL_ENABLE_BIT | GL_DEPTH_BUFFER_BIT);
		
			// Desenhar agora o chão transparente
			glEnable(GL_BLEND);
			glDepthMask(false); // Desativar teste de profundidade
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

			glColor4f(0.5f, 0.5f, 0.5f, 0.5f);
			demo().drawFloor(30.0f, 10);

		glPopAttrib();

		// Desenhar a luz no sítio certo
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);


		// Desenhar depois objetos transparentes
		drawWorld();
		
	}
	
	@Override
	protected void onKeyUp(KeyEvent e) {
		// Ao premir 't' alternar a transparencia
		if(e.keyCode == 't')
			transOn = ! transOn;
	}

	@Override
	public void resize(int width, int height) {
		float near = 0.001f; // muito perto do olho
		float far = 130.0f; // tem que ter em conta onde está o observador
		float fovy = 100.0f;
		setProjectionPerspective(width, height, fovy, near, far);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A04 Lighting");
		display.start(new A05_Mirror(display.getShell()));
	}

}
