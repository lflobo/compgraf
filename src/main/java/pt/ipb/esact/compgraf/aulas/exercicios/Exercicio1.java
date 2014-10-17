package pt.ipb.esact.compgraf.aulas.exercicios;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class Exercicio1 extends DefaultGLWindow {

	public Exercicio1() {
		super("Exercicio I", true);
	}
	
	public static void main(String[] args) {
		new Exercicio1();
	}
	
	/**
	 * Invocado para inicializar a cena (alocar recursos)
	 */
	public void init() {

	}

	@Override
	public void resize(int width, int height) {
		// Configurar a projection aqui
	}

	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT);
		glutWireSphere(1, 16, 16);
	}

	@Override
	public void release() {
		
	}

}
