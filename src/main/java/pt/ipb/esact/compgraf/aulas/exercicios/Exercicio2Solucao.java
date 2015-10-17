package pt.ipb.esact.compgraf.aulas.exercicios;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class Exercicio2Solucao extends DefaultGLWindow {

	public Exercicio2Solucao() {
		super("Exercicio II", true);
		setMousePan(true);
	}
	
	public static void main(String[] args) {
		new Exercicio2Solucao();
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

		// Camera na posição [0, 0, 4]
		Camera camera = new Camera(0, 0, 4);
		Cameras.setCurrent(camera);
		
		// Aplicar! 
		setupCamera();
	}

	@Override
	public void render(int width, int height) {
		// Desenhar coisas aqui!
        glClear(GL_COLOR_BUFFER_BIT);
        glBegin(GL_LINE_STRIP);
            glVertex3f(3, 3, 0);
            glVertex3f(2, -2, 0);
            glVertex3f(0, 1, 0);
            glVertex3f(-2, -2, 0);
            glVertex3f(-3, 3, 0);
        glEnd();
	}

	@Override
	public void release() {
		
	}

}
