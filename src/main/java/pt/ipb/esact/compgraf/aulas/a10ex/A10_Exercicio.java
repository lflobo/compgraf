package pt.ipb.esact.compgraf.aulas.a10ex;

import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import com.jogamp.opengl.util.texture.Texture;

public class A10_Exercicio extends DefaultGLWindow {

	private int sphereDisplayList;

	public A10_Exercicio() {
		super("A10 Exercicio", true);
		setMousePan(true);
		setMouseZoom(true);
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
		
		// Configurar as texturas
		configureTextures();
		
		// Configurat o fog
		configureFog();
		
		// Configurar os materiais
		configureMaterials();
		
		// Criar a display list com as esferas aleatorias
		createSpheres(20, 10);
	
		/**
		 * II
		 * 	e) utilizando ObjLoader carregar 'floor/floor.obj'
		 *  f) carregar o modelo 'wheatley/wheatley.obj'
		 */
		
		// I d) carregar aqui a skybox
	}

	/**
	 * Cria esferas em posicoes aleatorias na extensao descrita por area
	 * @param numSpheres Numero de esferas a criar
	 * @param area A area
	 */
	private void createSpheres(int numSpheres, int area) {
		sphereDisplayList = glGenLists(1);
		glNewList(sphereDisplayList, GL_COMPILE);
			for(int s=0; s<numSpheres; s++) {
				glPushMatrix();
					glTranslatef(randomBinomial(area), 1, randomBinomial(area));
					glutSolidSphere(0.2f, 10, 10);
				glPopMatrix();
			}
		glEndList();
	}

	private void configureMaterials() {
		// Configurar Color Tracking
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
		glMateriali(GL_FRONT, GL_SHININESS, 100);
		
		// Especularidade do material definida explicitamente
		float[] specRef = {1.0f, 1.0f, 1.0f, 1.0f};
		glMaterialfv(GL_FRONT, GL_SPECULAR, specRef, 0);
	}
	
	private void configureTextures() {
		// II b) Carregar aqui as texturas para os 2 planos
	}

	FloatBuffer positionLitght0 = newFloatBuffer(10.0f, 10.0f, 0.0f, 1.0f);
	FloatBuffer positionLitght1 = newFloatBuffer(0.0f, 10.0f, 0.0f, 1.0f);
	FloatBuffer positionLitght2 = newFloatBuffer(-10.0f, 10.0f, 0.0f, 1.0f);

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.1f, 0.1f, 0.1f, 1.0f));

		// I c) Configurar aqui as 'light points'

	}
	
	private void configureFog() {
		// II g) configurar aqui o FOG
	}

	@Override
	public void release() {
		// Libertar as texturas (GPU)z
	}
		
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Posicionar as luzes
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0);
		glLightfv(GL_LIGHT1, GL_POSITION, positionLitght1);
		glLightfv(GL_LIGHT2, GL_POSITION, positionLitght2);

		glColor3f(0.5f, 0.5f, 0.5f);

		// I d) fazer aqui o render da skybox

		// II e) Desenhar o floor no centro do cenário
		
		// II f) Desenhar o wheatley
		
		// II h) desenhar aqui a display list 'sphereDisplayList'
		
		/**
		 * II
		 * 	a) criar 2 planos
		 *  c) aplicar as texturas a cada plano
		 *  d) adicione blending a um dos planos para simular transparencia
		 */
	}
	
	@Override
	public void resize(int width, int height) {
		// I a) Configurar a projection aqui
		
		// I b) Configurar a Camera aqui
		
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A10_Exercicio();
	}

}
