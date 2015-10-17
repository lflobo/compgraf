package pt.ipb.esact.compgraf.aulas.exercicios;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class Exercicio1Solucao extends DefaultGLWindow {

	public Exercicio1Solucao() {
		super("Exercicio I", true);
	}
	
	public static void main(String[] args) {
		new Exercicio1Solucao();
	}
	
	/**
	 * Invocado para inicializar a cena (alocar recursos)
	 */
	public void init() {

	}

	@Override
	public void resize(int width, int height) {
        // Configurar uma camara na posição [5,5,5]
        Camera camera = new Camera(2, 2, 2);
        // Dizer que a nossa camera deve ser usada por omissão
        Cameras.setCurrent(camera);

        // Configurar a projection
        setProjectionPerspective(width, height, 8f, 1.0f, 100f);
        setupCamera();
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
