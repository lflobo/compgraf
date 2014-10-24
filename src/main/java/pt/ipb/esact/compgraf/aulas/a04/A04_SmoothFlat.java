package pt.ipb.esact.compgraf.aulas.a04;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import java.nio.FloatBuffer;

public class A04_SmoothFlat extends DefaultGLWindow {

    public A04_SmoothFlat() {
		super("A04 Smooth Flat", true);
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
		
		// Configurar Color Tracking
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
		glMateriali(GL_FRONT, GL_SHININESS, 64);
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

	@Override
	public void release() {
		// Libertar recursos
	}
	
	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Especularidade do material definida explicitamente
		glMaterialfv(GL_FRONT, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));
		
		// Definir a cor dos objetos (color tracking está on)
		glColor3f(0.5f, 0.5f, 0.5f);
		
		// Desenhar esfera com FLAT shading (á esquerda)
		glShadeModel(GL_FLAT);
		glPushMatrix();
			glTranslatef(-35.0f, 0.0f, 0.0f);
			glutSolidSphere(30.0f, 32, 32);
		glPopMatrix();

		// Desenhar esfera com SMOOTH shading (á direita)
		glShadeModel(GL_SMOOTH);
		glPushMatrix();
			glTranslatef(35.0f, 0.0f, 0.0f);
			glutSolidSphere(30.0f, 32, 32);
		glPopMatrix();

	}

	@Override
	public void resize(int width, int height) {
		setProjectionOrtho(width, height, 100, 0.001f, 100);
        Cameras.setCurrent(new Camera(0, 0, 50));
        setupCamera();
    }

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A04_SmoothFlat();
	}

}
