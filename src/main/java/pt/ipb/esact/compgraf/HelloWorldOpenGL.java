package pt.ipb.esact.compgraf;

import javax.media.opengl.GL;

import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class HelloWorldOpenGL extends SWTGLWindow {

	// Variável que irá armazenar o valor do ângulo de rotação
	private float angle = 0.0f;

	public HelloWorldOpenGL(Composite parent) {
		super(parent, true);
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
		glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		
		// A cor da 'caneta' será vermelha (RGBA={1, 0, 0, 255})
		glColor4f(1.0f, 0.0f, 0.0f, 1.0f);

		// Atualizamos o 'movimento'
		updateMovement();

		// Guardar o estado actual das transformações
		glPushMatrix();
		
			// Aplicar a rotação armazenada na variável 'angle'
			glRotatef(angle, 0, 1.0f, 0);
		
			// Efectuar transformações para o desenho
			glScalef(1f, 1f, 3f);
	
			// Desenhar o Cubo
			glutWireCube(50f);

		glPopMatrix();
	}

	private void updateMovement() {
		// Aumentar o angle em 30graus por segundo (... conseguido multiplicanto por timeElapsed())
		float increment = 30.0f;
		
		// Se a tecla r está premida duplicar a velocidade do angulo
		if(isKeyPressed('r'))
			increment *= 2.0f;
		
		// Aplicar o incremento
		angle += increment * timeElapsed();
		
		// Garantir que o angulo está sempre entre 0 e 360
		angle %= 360.0f;
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
		
		// Projecção em Perspectiva
		// gluPerspective(100f, fAspect, 1.0f, volume * 2f);
		
		// Projecção Ortogonal
		 if(width <= height) 
		 	glOrtho(-volume, volume, -volume, volume / fAspect, volume * 5f, -volume * 5f);
		 else
		 	glOrtho(-volume * fAspect, volume * fAspect, -volume, volume, volume * 5f, -volume * 5f);
		
		// Mudar para a matriz de MODELVIEW
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		gluLookAt(
			50f, 10f, 120.0f,			// Ponto onde está o meu olho
			0f, 0f, 0f,					// Para onde estou a olhar
			0f, 1f, 0f);				// Vector que define a orientação vertical
		
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("Modelo OpenGL");
		display.start(new HelloWorldOpenGL(display.getShell()));
	}

}