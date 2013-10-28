package pt.ipb.esact.compgraf.aulas;

import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class Test extends SWTGLWindow {

	public Test(Composite parent) {
		super(parent, true);
	}

	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
		
		// Configurar as luzes
		configureLighting();
		
		// Configurar Color Tracking
		configureColorTracking();

	}

	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	
		// Especularidade/shininess do material definida explicitamente! mesmo com color tracking
		float[] specRef = {1.0f, 1.0f, 1.0f, 1.0f};
		glMaterialfv(GL_FRONT, GL_SPECULAR, specRef, 0);
		glMateriali(GL_FRONT, GL_SHININESS, 64);
		
		// Global Color
		glColor3f(0.0f, 0.0f, 1.0f);

		glPushMatrix();
			glTranslatef(30.0f, 0.0f, 0.0f);
			glPushAttrib(GL_CURRENT_BIT);
				glColor3f(0.0f, 1.0f, 1.0f);
				glutSolidCube(40.0f);
			glPopAttrib();
		glPopMatrix();
		
		// Com o color tracking, a esfera toma a cor da 'caneta' atual
		glutSolidSphere(40.0f, 32, 32);
	
	}

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);

		// Este é o array com o RGB da luz ambiente
		float[] ambientLight = { 0.6f, 0.6f, 0.6f, 1.0f };
		float[] ambientLowLight = { 0.5f, 0.5f, 0.5f, 1.0f };
		// Este é o array com o RGB da luz difusa
		float[] diffuseLight = { 0.4f, 0.4f, 0.4f, 1.0f };
		// Este é o array com o RGB da luz especular
		float[] specularLight = { 0.5f, 0.5f, 0.5f, 1.0f };
		// Array com a posição da luz
		float[] positionLitght0 = { 50.0f, 50.0f, 50.0f, 1.0f };

		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, ambientLight, 0);		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuseLight, 0);		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, specularLight, 0);		// Componente especular
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);	// Posição da Luz0

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}

	public void configureColorTracking() {
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
	}

	@Override
	public void release() {
		// Libertar recursos
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
		float near = 0.001f; // muito perto do olho
		float far = 130.0f; // tem que ter em conta onde está o observador
		float aspect = (float) width / (float) height;
		
		// Projeção Ortogonal (left, right, bottom, top, near, far)
		gluPerspective(130.0f, aspect, near, far);
	
		// Mudar para a matriz de MODELVIEW
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		gluLookAt(
			40.0f, 40.0f, 40.0f,			// Ponto onde está observador
			0f, 0f, 0f,					// Para onde está a olhar
			0f, 1f, 0f);				// Vector que define a orientação vertical
		
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A04 Lighting");
		display.start(new Test(display.getShell()));
	}

}
