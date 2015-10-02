package pt.ipb.esact.compgraf.aulas.exercicios;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class Exercicio2 extends DefaultGLWindow {

	public Exercicio2() {
		super("Exercicio II", true);
		setMousePan(true);
	}
	
	public static void main(String[] args) {
		new Exercicio2();
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
	}

	@Override
	public void release() {
		
	}

}
