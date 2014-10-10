package pt.ipb.esact.compgraf.aulas.a03a;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class A03a_PushPop extends DefaultGLWindow {

	// Variáveies que armazenam os valores das rotações dos planetas
	float rotEarth = 0.0f;
	float rotMoon = 0.0f;

	public A03a_PushPop() {
		super("A03 Push Pop", true);
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
	
	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Atualizamos o 'movimento'
		updateMovement();

		// Cor do sol
		glColor4f(1.0f, 1.0f, 0.0f, 1.0f);

		// Sun
		glutWireSphere(1.0, 10, 10);

		// Herda as transformacoes do Sun
		glPushMatrix();
		
			// Cor da terra
			glColor4f(0.0f, 0.0f, 1.0f, 1.0f);

			// Earth
			glRotatef(rotEarth, 0.0f, 1.0f, 0.0f); // Rodar a Terra
			glTranslatef(10.0f, 0.0f, 0.0f); // Deslocar a 10 de distancia
			glScalef(0.5f, 0.5f, 0.5f);
			glutWireSphere(1.0, 10, 10);
	
			// Herda as transformacoes da Terra
			glPushMatrix();
			
				// Cor da lua
				glColor4f(0.7f, 0.7f, 0.7f, 1.0f);

				// Moon
				glRotatef(rotMoon, 0.0f, 1.0f, 0.0f); // Rodar a Lua
				glTranslatef(5.0f, 0.0f, 0.0f); // Deslocar a 5 de distancia
				glScalef(0.5f, 0.5f, 0.5f);
				glutWireSphere(1.0, 10, 10);
	
			glPopMatrix();

		glPopMatrix();
		
	}

	private void updateMovement() {
		// Aumentar as rotações em 30graus por segundo (... conseguido multiplicanto por timeElapsed())
		float incEarth = 30.0f;
		float incMoon = 60.0f;

		// Se a tecla r está premida duplicar a velocidade de rotação
		if(isKeyPressed('r')) {
			incEarth *= 2.0f;
			incMoon *= 2.0f;
		}
		
		// Aplicar o incremento
		rotEarth += incEarth * timeElapsed();
		rotMoon += incMoon * timeElapsed();
		
		// Garantir que o angulo está sempre entre 0 e 360
		rotEarth %= 360.0f;
		rotMoon %= 360.0f;
		
		renderText("Earth Rotation = " + rotEarth + "\nMoon Rotation = " + rotMoon, 10, 20);
	}

	@Override
	public void resize(int width, int height) {
		// Configurar uma camara na posição [5,5,5]
		Camera camera = new Camera(5, 5, 5);
		// Dizer que a nossa camera deve ser usada por omissão 
		Cameras.setCurrent(camera);
		
		// Configurar a projection
		setProjectionPerspective(width, height, 8f, 1.0f, 100f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A03a_PushPop();
	}

}