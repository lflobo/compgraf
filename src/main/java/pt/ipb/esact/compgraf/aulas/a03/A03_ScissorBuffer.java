package pt.ipb.esact.compgraf.aulas.a03;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

/**
 * Esta classe demonstra a primitiva POINTS
 * 
 * @author Luis Lobo <lflobo@gmail.com>
 */
public class A03_ScissorBuffer extends DefaultGLWindow {

	public A03_ScissorBuffer() {
		super("GL_LINES", true);
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

		// 1. Ver se o Scissor Test está ativo
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
			glClearColor(0.2f, 0.2f, 0.2f, 1.0f); // Cor vermelha
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
	
	private void drawLines() {
		float angle, x, y;
		// Começar a primitiva GL_LINES
		glBegin(GL_LINES);
			// O angulo varia entre 0 e 2pi
			for(angle=0.0f; angle<=2.0f * GL_PI; angle += GL_PI / 20f) {
				// equacao da circunferencia x = sin(angle), y = cos(angle)
				x = 30.0f * sinf(angle);
				y = 30.0f * cosf(angle);
				glVertex3f(x, y, 0); // Colocar um Vertex
			}
		glEnd();		
	}

	private void drawPoints() {
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
		new A03_ScissorBuffer();
	}

}