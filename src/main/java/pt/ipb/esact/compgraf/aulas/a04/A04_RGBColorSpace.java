package pt.ipb.esact.compgraf.aulas.a04;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class A04_RGBColorSpace extends DefaultGLWindow {

	public A04_RGBColorSpace() {
		super("A04 RGB Color Space", true);
	}

	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
	}

	@Override
	public void release() {
		// Libertar recursos
	}
	
	// Irá conter o valor do blue (que iremos variar)
	float blue = 0.0f;
	
	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Desenhar as linhas do RGB Space a Branco
		glColor3f(1.0f, 1.0f, 1.0f);
		glPushMatrix(); // Isolar o mundo das nossas trasnforms
			// Colocar o cubo encostado ao xyz=0
			glTranslatef(0.5f, 0.5f, 0.5f);
			glutWireCube(1.0f);
		glPopMatrix();

		// Incrementar o valor da cor azul em 0.2f por segundo
		blue += 0.2f * timeElapsed(); // ao multiplicar por timeElapsed() => valor por segundo
		blue %= 1.0f; // Manter o valor entre 0.0f e 1.0f

		// Usar GL_QUADS (hint: desenhar os vertices em CW - Clock Wise)
		glBegin(GL_QUADS);
			glColor3f(1.0f, 0.0f, blue);
			glVertex3f(1.0f, 0.0f, blue);

			glColor3f(0.0f, 0.0f, blue);
			glVertex3f(0.0f, 0.0f, blue);

			glColor3f(0.0f, 1.0f, blue);
			glVertex3f(0.0f, 1.0f, blue);

			glColor3f(1.0f, 1.0f, blue);
			glVertex3f(1.0f, 1.0f, blue);
		glEnd();
	}

	@Override
	public void resize(int width, int height) {
		setProjectionOrtho(width, height, 2, 0.001f, 10);
        Cameras.setCurrent(new Camera(2f, 1.7f, 1.2f));
        setupCamera();
    }

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A04_RGBColorSpace();
	}

}
