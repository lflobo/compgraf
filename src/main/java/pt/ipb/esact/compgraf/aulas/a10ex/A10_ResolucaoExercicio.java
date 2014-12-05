package pt.ipb.esact.compgraf.aulas.a10ex;

import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import com.jogamp.opengl.util.texture.Texture;

public class A10_ResolucaoExercicio extends DefaultGLWindow {

	// .obj loaders
	private ObjLoader wheatley;
	private ObjLoader floor;
	
	// skybox
	private Skybox skybox;
	private int sphereDisplayList;

	public A10_ResolucaoExercicio() {
		super("A10 Resolucao Exercicio", true);
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
	
		// Carregar os ficheiros .obj/.mtl
		wheatley = new ObjLoader(this);
		wheatley.load("wheatley/wheatley.obj", "wheatley/wheatley.mtl");
		
		floor = new ObjLoader(this);
		floor.load("floor/floor.obj", "floor/floor.mtl");
		
		// carregar as texturas da skybox
		skybox = new Skybox(this);
		skybox.load("skybox/dd-px.png", "skybox/dd-py.png", "skybox/dd-pz.png", "skybox/dd-nx.png", "skybox/dd-ny.png", "skybox/dd-nz.png");
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
	
	// Array com os IDs dos texture objects ('gavetas')
	private Texture TEX_QUAD; 
	
	private void configureTextures() {
		// Carregar as texturas
		TEX_QUAD = loadPackageTexture("stone.png");
	}

	FloatBuffer positionLitght0 = newFloatBuffer(10.0f, 10.0f, 0.0f, 1.0f);
	FloatBuffer positionLitght1 = newFloatBuffer(0.0f, 10.0f, 0.0f, 1.0f);
	FloatBuffer positionLitght2 = newFloatBuffer(-10.0f, 10.0f, 0.0f, 1.0f);

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.1f, 0.1f, 0.1f, 1.0f));

		glLightfv(GL_LIGHT0, GL_AMBIENT,  newFloatBuffer(.1f, 0, 0, 1));
		glLightfv(GL_LIGHT0, GL_DIFFUSE,  newFloatBuffer(1, 0, 0, 1));
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(1, 0, 0, 1));
		glEnable(GL_LIGHT0);

		glLightfv(GL_LIGHT1, GL_AMBIENT,  newFloatBuffer(0, 0, .1f, 1));
		glLightfv(GL_LIGHT1, GL_DIFFUSE,  newFloatBuffer(0, 0, 1, 1));
		glLightfv(GL_LIGHT1, GL_SPECULAR, newFloatBuffer(0, 0, 1, 1));
		glEnable(GL_LIGHT1);

		glLightfv(GL_LIGHT2, GL_AMBIENT,  newFloatBuffer(.1f, .1f, 0, 1));
		glLightfv(GL_LIGHT2, GL_DIFFUSE,  newFloatBuffer(1, 1, 0, 1));
		glLightfv(GL_LIGHT2, GL_SPECULAR, newFloatBuffer(1, 1, 0, 1));
		glEnable(GL_LIGHT2);

	}
	
	private void configureFog() {
		glEnable(GL_FOG);
		
		// Cor do nevoeiro
		float[] fogColor = {0.25f, 0.25f, 0.25f, 1.0f};
		
		// Definir a cor do nevoeiro
		glFogfv(GL_FOG_COLOR, fogColor, 0);
		// A que distância os objectos começam a ser afetados
		glFogf(GL_FOG_START, 1.0f);
		// A que distância o FOG toma conta por completo
		glFogf(GL_FOG_END, 30.0f);
		// Curva para o cálculo do Fog
		glFogi(GL_FOG_MODE, GL_LINEAR);
		
		glFogf(GL_FOG_DENSITY, 0.1f);
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

		skybox.render();

		// Desenhar o Wheatley
		glPushMatrix();
			glTranslatef(0.0f, 1.0f, 0.0f);
			wheatley.render();
		glPopMatrix();
		
		// Desenhar o Chão
		floor.render();

		// Invocar a lista das esferas
		glCallList(sphereDisplayList);
		
		// Desenhar os QUADS
		glBegin(GL_QUADS);

			// Primeiro o QUAD opaco
			glColor3f(1, 1, 1);
			TEX_QUAD.bind(this);
			glTexCoord2f(1, 0); glVertex3f(2, 2, -1);
			glTexCoord2f(1, 1); glVertex3f(2, 4, -1);
			glTexCoord2f(0, 1); glVertex3f(-2, 4, -1);
			glTexCoord2f(0, 0); glVertex3f(-2, 2, -1);
		
		glEnd();
	
		glPushAttrib(GL_ENABLE_BIT | GL_DEPTH_BUFFER_BIT);
			glEnable(GL_BLEND);
			glDepthMask(false); // Desativar teste de profundidade
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
			// Primeiro o QUAD transparente
			glColor4f(1, 1, 1, 0.5f);
			TEX_QUAD.bind(this);
			glBegin(GL_QUADS);
				glTexCoord2f(1, 0); glVertex3f(2, 2, 1);
				glTexCoord2f(1, 1); glVertex3f(2, 4, 1);
				glTexCoord2f(0, 1); glVertex3f(-2, 4, 1);
				glTexCoord2f(0, 0); glVertex3f(-2, 2, 1);
			glEnd();

		glPopAttrib();

		
	}
	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		Cameras.setCurrent(new Camera(10, 10, 10));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A10_ResolucaoExercicio();
	}

}
