package pt.ipb.esact.compgraf.aulas.a03;

import java.awt.event.KeyEvent;
import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

/**
 * Esta classe demonstra as primitivas mais importantes e como podemos usá-las
 * de forma apropriada com o OpenGL, tendo em conta os limites e valores
 * suportados pela nossa placa gráfica.
 * 
 * @author Luis Lobo <lflobo@gmail.com>
 */
public class A03_Primitivas extends DefaultGLWindow {

	// Armazena a última tecla premida (por omissão = 1)
	char key = '1';
	
	
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

	void drawPoints() {
		float angle, x, z;
		// Valor do y (altura) começa em -50 e vai aumentar até +50
		float y = -50.0f;
		// Começar a primitiva GL_POINTS
		glBegin(GL_POINTS);
			// O angulo varia entre 0 e 3 * 2pi <==> dar 3 voltas
			for(angle=0.0f; angle<=(2.0f * GL_PI) * 3.0f; angle += 0.1f) {
				// equacao da circunferencia x = sin(angle), y = cos(angle)
				x = 30.0f * sinf(angle);
				z = 30.0f * cosf(angle);
				glVertex3f(x, y, z); // Colocar um Vertex
				y += 0.5f;		   // A altura aumenta em 0.5
			}
		glEnd();
		
		// Dizer o que estamos a desenhar
		renderText("Points", 10, 20);
	}
	
	void drawPointSize() {
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
	
	void drawLines() {
		float angle, x, y, z = 0.0f;
		// Comecar Linhas
		glBegin(GL_LINES);
			// O angulo varia entre 0 e 3 * 2pi <==> dar 3 voltas
			for(angle = 0.0f; angle <= GL_PI; angle += (GL_PI/20.0f)) {
				// Primeira metade do circulo
				x = 30.0f * (float) sin(angle);
				y = 30.0f * (float) cos(angle);
				glVertex3f(x, y, z);
			
				// Segunda metade do circulo (angle + GL_PI)
				x = 30.0f * (float) sin(angle + GL_PI);
				y = 30.0f * (float) cos(angle + GL_PI);
				glVertex3f(x, y, z);
			}

		// Terminar Linhas
		glEnd();

		// Dizer o que estamos a desenhar
		renderText("Lines", 10, 20);
	}
	
	void drawLineStrip() {
		float angle, x, z, y = -50.0f;

		// Comecar a Tiras de Linha
		glBegin(GL_LINE_STRIP);
			// O angulo varia entre 0 e 3 * 2pi <==> dar 3 voltas
			for(angle=0.0f; angle<=(2.0f*GL_PI)*3.0f; angle+=0.1f) {
			  x = 30.0f * (float) sin(angle);
			  z = 30.0f * (float) cos(angle);
			  glVertex3f(x, y, z);
			  y += 0.5f;
			}
		// Terminar Tiras de Linha
		glEnd();
		
		// Dizer o que estamos a desenhar
		renderText("Line Strip", 10, 20);
	}
	
	void drawLineWidth() {
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
	
	void drawLineStipple() {
		// Activar o line stipple
		glEnable(GL_LINE_STIPPLE);

		short pattern = 0x5555; // em binario = 0101 0101 0101 0101

		int factor = 1;
		glColor3f(1.0f, 1.0f, 1.0f);
		for(float y=-90.0f; y<90.0f; y+=20.0f) {
			// Aumentar o factor do line stipple
			glLineStipple(factor++, pattern);
			// Comecar Linhas
			glBegin(GL_LINE_STRIP);
				glVertex2f(-80.0f, y);
				glVertex2f(80.0f, y);
			// Terminar Linhas
			glEnd();
		}

		// Desactivar o line stipple
		glDisable(GL_LINE_STIPPLE);

		// Dizer o que estamos a desenhar
		renderText("Line Stipple\npattern=" + Integer.toBinaryString(pattern), 10, 20);
	}
	
	void drawScissorBuffer(int width, int height) {

		// 1. Ver se o ST está ativo
		// 2. Se não está ativar
		// do my stuff ()
		// 3. Se não estava ativo inicialmente, desativar

		// Verificar se o GL_SCISSOR_TEST está ativo
		boolean isEnabled = glIsEnabled(GL_SCISSOR_TEST);

		// Activar o Scissor Test
		if(!isEnabled)
			glEnable(GL_SCISSOR_TEST);

			glColor3f(1.0f, 1.0f, 1.0f);

			// Tamanho inicial da mascara = width x height
			glScissor(0, 0, width, height);

			// Limpar e desenhar o demo dos pontos
			glClear(GL_COLOR_BUFFER_BIT);
			drawPoints();

			// Mudar a máscara (scissor) com base na largura da cena
			glScissor(width/4, height/4, width/2, height/2);

			// Limpar e desenhar o demo das linhas
			glClear(GL_COLOR_BUFFER_BIT);
			drawLines();

			// Diminuir ainda mais a máscara
			glScissor(width/3, height/3, width/3, height/3);

			// Limpar e Desenhar o demo do point size
			glClearColor(1.0f, 0.0f, 0.0f, 1.0f); // Cor vermelha
			glClear(GL_COLOR_BUFFER_BIT);

			glutWireCube(12.0f);


		// Desactivar o Scissor Test
		if(!isEnabled)
			glDisable(GL_SCISSOR_TEST);

		// Repor o clear color
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

	}
	
	/******************************************************************************************
	 * Eventos/Callbacks do 'OpenGL'
	 ******************************************************************************************/
	
	public A03_Primitivas() {
		super("Aula 03 - Primitivas e Buffers", true);
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

		// Desenhar as primitivas com base na tecla premida
		switch (key) {
			default:
			case '1': drawPoints(); break;
			case '2': drawPointSize(); break;
			case '3': drawLines(); break;
			case '4': drawLineStrip(); break;
			case '5': drawLineWidth(); break;
			case '6': drawLineStipple(); break;
			case '7': drawScissorBuffer(width, height); break;
		}
	}
	
	@Override
	protected void onKeyUp(KeyEvent e) {
		/*
		 * Esta função (mensagem) permite nos obter a tecla que foi premida
		 * com base no evento 'KeyEvent' na sua variável membro 'keyCode' 
		 */
		
		// Ignorar todas as teclas que não interessam
		if(e.getKeyChar() >= '1' && e.getKeyChar() <= '7')
			key = e.getKeyChar();
	}

	@Override
	public void resize(int width, int height) {
		if (height == 0)
			height = 1; // prevnir divisão por 0

		// O meu viewport terá o tamanho da janela (width x height)
		glViewport(0, 0, width, height);

		// Mudar para a matiz de PROJECTION
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		
		float volume = 100f;
		float fAspect = (float) width / (float) height;
		
		// Projecção Ortogonal
		if(fAspect > 0)
			glOrtho(-volume, volume, -volume / fAspect, volume / fAspect, 0.001f, volume * 5.0f);
		else
			glOrtho(-volume/fAspect, volume/fAspect, -volume, volume, 0.001f, volume * 5.0f);
		
		// Mudar para a matriz de MODELVIEW
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		gluLookAt(
			0.0f, 0.0f, 100.0f,			// Ponto onde está o meu olho
			0f, 0f, 0f,					// Para onde estou a olhar
			0f, 1f, 0f);				// Vector que define a orientação vertical
		
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A03_Primitivas();
	}

}