package pt.ipb.esact.compgraf.aulas.exercicios;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class Exercicio3 extends DefaultGLWindow {

	public Exercicio3() {
		super("Exercicio II", true);
		setMousePan(true);
	}
	
	public static void main(String[] args) {
		new Exercicio3();
	}
	
	/**
	 * Invocado para inicializar a cena (alocar recursos)
	 */
	public void init() {
	}

	@Override
	public void resize(int width, int height) {
		/**
		 * Funções para ajudar a configurar a perspective/observador
		 */
		setProjectionPerspective(width, height, 25, 0.001f, 1000);

		// Camera na posição [10, 10, 10]
		Camera camera = new Camera(0, 0, 4);
		Cameras.setCurrent(camera);
		
		// Aplicar! 
		setupCamera();
	}

	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT);
		glBegin(GL_TRIANGLES);
			// Triangulo I
			glVertex3f(0, 1, 0);
			glVertex3f(2, -2, 0);
			glVertex3f(3, 3, 0);

			// Triangulo II
			glVertex3f(0, 1, 0);
			glVertex3f(-2, -2, 0);
			glVertex3f(-3, 3, 0);
		glEnd();
	}

	@Override
	public void release() {
		
	}

}
