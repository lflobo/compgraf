package pt.ipb.esact.compgraf.aulas.a04;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import java.nio.FloatBuffer;

public class A04_ColorTracking extends DefaultGLWindow {

	public A04_ColorTracking() {
		super("A04 Color Tracking", true);
	}

	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
		
		// Configurar as luzes
		configureLighting();
		
		// Configurar Color Tracking
		configureColorTracking();
	}

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);

        // Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.4f, 0.4f, 0.4f, 1.0f));		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));		// Componente especular
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-50.0f, 50.0f, 50.0f, 1.0f));	// Posição da Luz0

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}

	public void configureColorTracking() {
        // O material toma a cor definida por glColor
		glEnable(GL_COLOR_MATERIAL);
        // A cor atual afeta a face GL_FRONT e as componentes AMBIENT/DIFFUSE
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
	}

	@Override
	public void release() {
		// Libertar recursos
	}
	
	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		// Especularidade/shininess do material definida explicitamente! mesmo com color tracking
		glMaterialfv(GL_FRONT, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));
		glMateriali(GL_FRONT, GL_SHININESS, 64);
		
		// Com o color tracking, a esfera toma a cor da 'caneta' atual
		glColor3f(0.0f, 0.0f, 1.0f);
		glutSolidSphere(30.0f, 32, 32);

		glPushMatrix();
			glTranslatef(30.0f, 0.0f, 0.0f);
			glColor3f(0.0f, 1.0f, 1.0f);
			glutSolidCube(30.0f);
		glPopMatrix();
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 40.0f, 0.001f, 100.0f);
        Cameras.setCurrent(new Camera(40.0f, 40.0f, 40.0f));
        setupCamera();
    }

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A04_ColorTracking();
	}

}
