package pt.ipb.esact.compgraf.aulas.a03;

import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

/**
 * Esta classe demonstra a configuração da projeção em Perspetiva
 * do OpenGL
 * 
 * @author Luis Lobo <lflobo@gmail.com>
 */
public class A03_ProjectionPerspective extends DefaultGLWindow {


	public A03_ProjectionPerspective() {
		super("Projection Perspective", true);
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

		// Desenhar um cubo no centro do cenário com altura/largura/profundidade = 5
		glutWireCube(5);
	}
	
	@Override
	public void resize(int width, int height) {
		 // prevenir divisão por 0!
		if (height == 0) height = 1;

		/**
		 * O meu viewport terá inicio no ponto 0/0
		 * e o tamanho da janela (width x height)
		 */
		glViewport(0, 0, width, height);

		/**
		 * Mudar para a matiz de PROJECTION - a partir
		 * daqui as transformações serão aplicadas na matriz de projeção (alias observador) 
		 */
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		
		float volume = 100f;
		float aspect = (float) width / (float) height;
		
		/**
		 * Configurar a projecção em perspectiva
		 */
		gluPerspective(
			30f,					// angulo no eixo Y (field of view)
			aspect,				// racio entre altura e largura
			1.0f,				// distância do plano 'near' ao observador
			volume * 2f			// distância do plano 'far' ao observador
		);
		
		// Mudar para a matriz de MODELVIEW
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		gluLookAt(
			20f, 10f, 10.0f,			// Ponto onde está o meu olho
			0f, 0f, 0f,					// Para onde estou a olhar
			0f, 1f, 0f);				// Vector que define a orientação vertical
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A03_ProjectionPerspective();
	}

}