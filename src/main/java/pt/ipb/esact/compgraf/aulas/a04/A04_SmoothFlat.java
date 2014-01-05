package pt.ipb.esact.compgraf.aulas.a04;

import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class A04_SmoothFlat extends DefaultGLWindow {

	public A04_SmoothFlat() {
		super("A04 Smooth Flat", true);
	}

	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_MULTISAMPLE);
		glEnable(GL_CULL_FACE);

		glCullFace(GL_BACK);

		// Configurar as luzes
		configureLighting();
		
		// Configurar Color Tracking
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
		glMateriali(GL_FRONT, GL_SHININESS, 64);
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

	@Override
	public void release() {
		// Libertar recursos
	}
	
	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Especularidade do material definida explicitamente
		float[] specRef = {1.0f, 1.0f, 1.0f, 1.0f};
		glMaterialfv(GL_FRONT, GL_SPECULAR, specRef, 0);
		
		// Definir a cor dos objetos (color tracking está on)
		glColor3f(0.5f, 0.5f, 0.5f);
		
		// Desenhar esfera com FLAT shading (á esquerda)
		glShadeModel(GL_FLAT);
		glPushMatrix();
			glTranslatef(-35.0f, 0.0f, 0.0f);
			glutSolidSphere(30.0f, 32, 32);
		glPopMatrix();

		// Desenhar esfera com SMOOTH shading (á direita)
		glShadeModel(GL_SMOOTH);
		glPushMatrix();
			glTranslatef(35.0f, 0.0f, 0.0f);
			glutSolidSphere(30.0f, 32, 32);
		glPopMatrix();

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
		float volume = 100;
		
		// Projeção Ortogonal (left, right, bottom, top, near, far)
		// gluPerspective(130.0f, aspect, near, far);
		glOrtho(-volume, volume, -volume/aspect, volume/aspect, near, far);
	
		// Mudar para a matriz de MODELVIEW
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		gluLookAt(
			0.0f, 0.0f, 50.0f,			// Ponto onde está observador
			0f, 0f, 0f,					// Para onde está a olhar
			0f, 1f, 0f);				// Vector que define a orientação vertical
		
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A04_SmoothFlat();
	}

}
