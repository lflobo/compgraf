package pt.ipb.esact.compgraf.aulas.a04;

import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.buffers.Buffers;

public class A04_Material extends DefaultGLWindow {

    public A04_Material() {
		super("A04 Material", true);
	}

	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
		
		// Configurar as luzes
		configureLighting();
	}

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);

        // Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.4f, 0.4f, 0.4f, 1.0f));		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.0f, 0.0f, 1.0f, 1.0f));   // Componente especular
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
		
		// Usar a cor em cima com cor do material
		glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, newFloatBuffer(1.0f, 1.0f, 0.0f, 1.0f));
		glMateriali(GL_FRONT, GL_SHININESS, 64);

		// Definir a especularidade do material
        glMaterialfv(GL_FRONT, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));

		// Desenhar o nosso objeto
		glutSolidSphere(5.0f, 132, 132);
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 18.0f, 0.001f, 100.0f);
		Cameras.setCurrent(new Camera(5.0f, 5.0f, 5.0f));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A04_Material();
	}

}
