package pt.ipb.esact.compgraf.aulas.a03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

/**
 * Esta classe demonstra a primitiva POINTS
 * 
 * @author Luis Lobo <lflobo@gmail.com>
 */
public class A03_LineLoop extends DefaultGLWindow {

	public A03_LineLoop() {
		super("GL_LINE_LOOP", true);
	}
	
	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade (ignorar para já)
		glEnable(GL_DEPTH_TEST);
	}

	@Override
	public void release() {
		// Libertar recursos
	}

	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// A cor da 'caneta' será branca (RGBA={255, 255, 255, 255})
		glColor4f(1f, 1f, 1f, 1f);

		// Começar a primitiva GL_LINES
        glBegin(GL_LINE_LOOP);
            float angle, x, y, z;
            // O angulo varia entre 0 e 2pi
            for(angle=0.0f; angle<=2.0f * GL_PI;
                angle += GL_PI / 20f) {
                // equacao da circunferencia
                x = 30.0f * sinf(angle);
                y = 30.0f * cosf(angle);
                glVertex3f(x, y, 0); // Colocar um Vertex
            }
        glEnd();

        
        // Dizer o que estamos a desenhar
		renderText("Line Loop", 10, 20);
	}

    private static final Logger logger = LoggerFactory.getLogger(A03_LineLoop.class);

	@Override
	public void resize(int width, int height) {
		// Configurar uma camara na posição [0,0,100]
		Camera camera = new Camera(0, 0, 50);
		// Dizer que a nossa camara é a camara atual
		Cameras.setCurrent(camera);

		// Configurar a projeção ortogonal
		setProjectionOrtho(width, height, 50, 0.001f, 10000);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A03_LineLoop();
	}

}