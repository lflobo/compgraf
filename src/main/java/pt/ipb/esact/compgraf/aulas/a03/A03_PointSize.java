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
public class A03_PointSize extends DefaultGLWindow {

	public A03_PointSize() {
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
	

	/*
	 * Explicação da utilização dos FloatBuffer's
	 * -----------------------------------------------------------------
	 * Nas linguagens puramente orientadas a objetos, não existem variáveis de saída nas funções.
	 * Por esta razão, num exemplo deste tipo:
	 * <code>
	 * float[] array = new float[10];
	 * umaFuncao(array);
	 * </code>
	 * 
	 * A variável array nunca poderia ser escrita dentro de uma funcção.
	 * 
	 *  Como é resolvido o problema no Java ?
	 *  
	 *  Utilizando um objeto que 'mimetiza' o funcionamento das variáveis de saída - Buffers:
	 *  Exemplo:
	 *  
	 *  float[] array = new float[3];
	 *  
	 *  É equivalente a:
	 *  
	 *  FloatBuffer array = FloatBuffer.allocate(3);
	 * 
	 */

	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// A cor da 'caneta' será bracne (RGBA={255, 255, 255, 255})
		glColor4f(1f, 1f, 1f, 1f);

		// Usar um buffer de memória de floats para obter os valores
		FloatBuffer buffer;

		// Obter o valor do point size actual para restaurar
		// mais tarde (objectivo: deixar sempre tudo como estava)
		buffer = FloatBuffer.allocate(1);
		glGetFloatv(GL_POINT_SIZE, buffer);
		float currentPointSize = buffer.get(0);

		// Os valores do PSmin/PSmax ocupam 2 posições de memória
		// pelo que o nosso array de sizes[] ter tamanho 2
		buffer = FloatBuffer.allocate(2);
		glGetFloatv(GL_POINT_SIZE_RANGE, buffer); // guarda os valores no array sizes
		float minSize = buffer.get(0);
		float maxSize = buffer.get(1);

		// Obter o PSstep
		buffer = FloatBuffer.allocate(1);
		glGetFloatv(GL_POINT_SIZE_GRANULARITY, buffer); // idem
		float step = buffer.get(0);

		// Comecar no point size minimo
		float psize = minSize;

		float angle, x, z;
		float y = -50;
		// O angulo varia entre 0 e 3 * 2pi <==> dar 3 voltas
		for(angle=0.0f; angle <= (2.0f*GL_PI) * 3.0f; angle += 0.1f) {
			// equacao da circunferencia x = sin(angle), y = cos(angle)
			x = 30.0f * sinf(angle);
			z = 30.0f * cosf(angle);
			glPointSize(psize);
			psize += step; // Incrementar em PSstep
			// Começar a desenhar pontos
			glBegin(GL_POINTS);
				glVertex3f(x, y, z); // Colocar o vertex
			glEnd();
			y += 0.5f; // A altura aumenta em 0.5
		}

		// Restaurar o point size anterior
		glPointSize(currentPointSize);
		
		// Dizer o que estamos a desenhar
		renderText("Point Size\nmin=" + minSize + ", max=" + maxSize + ", step=" + step, 10, 20);

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
		new A03_PointSize();
	}

}