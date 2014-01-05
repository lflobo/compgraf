package pt.ipb.esact.compgraf.aulas.a11;

import java.nio.IntBuffer;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class A11_ResolucaoExercicio extends SWTGLWindow {

	// .obj loaders
	private ObjLoader wheatley;
	private ObjLoader floor;
	
	// skybox
	private Skybox skybox;
	private int sphereDisplayList;

	public A11_ResolucaoExercicio(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 10.0f;
		camera.eye.y = 10.0f;
		camera.eye.z = 10.0f;
		
		camera.at.y = 0.0f;
		
		Cameras.setCurrent(camera);
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
	private IntBuffer textures;
	private int TEX_QUAD; 
	
	private void configureTextures() {
		int textureCount = 1;
		textures = IntBuffer.allocate(textureCount);

		// Allocar as texturas
		glGenTextures(textureCount, textures);
		
		// Associar os IDs às variáveis
		TEX_QUAD = textures.get(0);
		
		// Carregar as texturas
		loadPackageTexture("stone.png", TEX_QUAD);
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
	}


	float[] positionLitght0 = { 10.0f, 10.0f, 0.0f, 1.0f };
	float[] positionLitght1 = { 0.0f, 10.0f, 0.0f, 1.0f };
	float[] positionLitght2 = { -10.0f, 10.0f, 0.0f, 1.0f };

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		float[] ambientLowLight = { 0.1f, 0.1f, 0.1f, 1.0f };
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);

		glLightfv(GL_LIGHT0, GL_AMBIENT,  new float[] { .1f, 0, 0, 1 }, 0);
		glLightfv(GL_LIGHT0, GL_DIFFUSE,  new float[] { 1, 0, 0, 1 }, 0);
		glLightfv(GL_LIGHT0, GL_SPECULAR, new float[] { 1, 0, 0, 1 }, 0);
		glEnable(GL_LIGHT0);

		glLightfv(GL_LIGHT1, GL_AMBIENT,  new float[] { 0, 0, .1f, 1 }, 0);
		glLightfv(GL_LIGHT1, GL_DIFFUSE,  new float[] { 0, 0, 1, 1 }, 0);
		glLightfv(GL_LIGHT1, GL_SPECULAR, new float[] { 0, 0, 1, 1 }, 0);
		glEnable(GL_LIGHT1);

		glLightfv(GL_LIGHT2, GL_AMBIENT,  new float[] { .1f, .1f, 0, 1 }, 0);
		glLightfv(GL_LIGHT2, GL_DIFFUSE,  new float[] { 1, 1, 0, 1 }, 0);
		glLightfv(GL_LIGHT2, GL_SPECULAR, new float[] { 1, 1, 0, 1 }, 0);
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
	protected void onKeyUp(KeyEvent e) {
		switch (e.keyCode) {
		}
	}

	@Override
	public void release() {
		// Libertar as texturas (GPU)z
	}
		
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Posicionar as luzes
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);
		glLightfv(GL_LIGHT1, GL_POSITION, positionLitght1, 0);
		glLightfv(GL_LIGHT2, GL_POSITION, positionLitght2, 0);

		glColor3f(0.5f, 0.5f, 0.5f);

		skybox.render();
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);

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
			glBindTexture(GL_TEXTURE_2D, TEX_QUAD);
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
			glBindTexture(GL_TEXTURE_2D, TEX_QUAD);
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
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A09 Obj");
		display.start(new A11_ResolucaoExercicio(display.getShell()));
	}

}