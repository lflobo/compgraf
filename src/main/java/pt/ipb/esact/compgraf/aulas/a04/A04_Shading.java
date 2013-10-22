package pt.ipb.esact.compgraf.aulas.a04;

import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class A04_Shading extends SWTGLWindow {

	public A04_Shading(Composite parent) {
		super(parent, true);
	}

	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
	}

	@Override
	public void release() {
		// Libertar recursos
	}
	
	// Irá conter o valor do blue (que iremos variar)
	float blue = 0.0f;
	
	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Desenhar as linhas do RGB Space a Branco
		glColor3f(1.0f, 1.0f, 1.0f);
		glPushMatrix(); // Isolar o mundo das nossas trasnforms
			// Colocar o cubo encostado ao xyz=0
			glTranslatef(0.5f, 0.5f, 0.5f);
			glutWireCube(1.0f);
		glPopMatrix();

		// Incrementar o valor da cor azul em 0.2f por segundo
		blue += 0.2f * timeElapsed(); // ao multiplicar por timeElapsed() => valor por segundo
		blue %= 1.0f; // Manter o valor entre 0.0f e 1.0f

		// Usar GL_QUADS (hint: desenhar os vertices em CW - Clock Wise)
		glBegin(GL_QUADS);
			glColor3f(1.0f, 0.0f, blue);
			glVertex3f(1.0f, 0.0f, blue);

			glColor3f(0.0f, 0.0f, blue);
			glVertex3f(0.0f, 0.0f, blue);

			glColor3f(0.0f, 1.0f, blue);
			glVertex3f(0.0f, 1.0f, blue);

			glColor3f(1.0f, 1.0f, blue);
			glVertex3f(1.0f, 1.0f, blue);
		glEnd();
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
		
		// Configuração da Projeção Ortho
		float volume = 2.0f;
		float near = 0.001f; // muito perto do olho
		float far = 10.0f; // tem que ter em conta onde está o observador
		float fAspect = (float) width / (float) height;
		
		// Projeção Ortogonal (left, right, bottom, top, near, far)
		glOrtho(-volume, volume, -volume/fAspect, volume/fAspect, near, far);
	
		// Mudar para a matriz de MODELVIEW
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		gluLookAt(
			2.0f, 1.7f, 1.2f,			// Ponto onde está observador
			0f, 0f, 0f,					// Para onde está a olhar
			0f, 1f, 0f);				// Vector que define a orientação vertical
		
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A04 Shading");
		display.start(new A04_Shading(display.getShell()));
	}

}
