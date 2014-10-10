package pt.ipb.esact.compgraf.aulas.a03;

import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

/**
 * Esta classe demonstra a primitiva POINTS
 * 
 * @author Luis Lobo <lflobo@gmail.com>
 */
public class A03_LineWidth extends DefaultGLWindow {

	public A03_LineWidth() {
		super("POINTS", true);
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
		
		// A cor da 'caneta' será bracne (RGBA={255, 255, 255, 255})
		glColor4f(1f, 1f, 1f, 1f);

		// Usar um buffer de memória de floats para obter os valores
		FloatBuffer buffer;
		
		// Obter o valor do line width actual
		buffer = FloatBuffer.allocate(1);
		glGetFloatv(GL_LINE_WIDTH, buffer);
		float currentLineWidth = buffer.get(0);

		// Obter os valores de LWmin/LWmax
		buffer = FloatBuffer.allocate(2);
		glGetFloatv(GL_LINE_WIDTH_RANGE, buffer);
		float minWidth = buffer.get(0);
		float maxWidth = buffer.get(1);

		// Obter o valor de LWstep
		buffer = FloatBuffer.allocate(1);
		glGetFloatv(GL_LINE_WIDTH_GRANULARITY, buffer);
		float step = buffer.get(0);

		// A lagura da linha começa no valor mínimo (LWmin)
		float y, curwidth = 1;

		// Calcular o número de intevalos possível
		float intervals = ((maxWidth - minWidth) / step);
		
		for(y=-90.0f; y<90.0f; y += 180.f / intervals) {
			// Se ultrapassámos o tamanho máximo -> quebrar o ciclo
			if(curwidth > maxWidth)
				break;

			// Alterar a Largura
			glLineWidth(curwidth);

			// Comecar Tiras
			glBegin(GL_LINE_STRIP);
				glVertex2f(-80.0f, y);
				glVertex2f(80.0f, y);
			//Terminar Tiras
			glEnd();

			curwidth += step; // aumentar a largura da linha
		}

		// Restaurar o valor da Line Width
		glLineWidth(currentLineWidth);
		
		// Dizer o que estamos a desenhar
		renderText("Line Width\nmin=" + minWidth + ", max=" + maxWidth + ", step=" + step, 10, 20);

	}
	
	@Override
	public void resize(int width, int height) {
		// Configurar uma camara na posição [0,0,100]
		Camera camera = new Camera(0, 0, 100);
		// Dizer que a nossa camara é a camara atual
		Cameras.setCurrent(camera);

		// Configurar a projeção ortogonal
		setProjectionOrtho(width, height, 100, 0.001f, 10000);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A03_LineWidth();
	}

}