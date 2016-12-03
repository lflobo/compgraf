package pt.ipb.esact.compgraf.aulas.a07;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class A07_Obj extends DefaultGLWindow {

	// .obj loaders
	private ObjLoader wheatley;
	private ObjLoader moon;
	private ObjLoader miniGun;
	private ObjLoader floor;
	
	// skybox
	private Skybox skybox;

	private ObjLoader glass;

	public A07_Obj() {
		super("A07 Obj", true);
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
		
		// Configurar os materiais
		configureMaterials();
	
		// Carregar os ficheiros .obj/.mtl
		wheatley = new ObjLoader(this);
		wheatley.load("assets/models/wheatley/wheatley.obj", "assets/models/wheatley/wheatley.mtl");
		
		moon = new ObjLoader(this);
		moon.load("assets/models/moon/moon.obj", "assets/models/moon/moon.mtl");

		glass = new ObjLoader(this);
		glass.load("assets/models/glass/glass.obj", "assets/models/glass/glass.mtl");

		miniGun = new ObjLoader(this);
		miniGun.setScale(0.5f); // Opcionalmente definir a escala
		miniGun.load("assets/models/minigun/MiniGun.obj", "assets/models/minigun/MiniGun.mtl");

		floor = new ObjLoader(this);
		floor.load("assets/models/floor/floor.obj", "assets/models/floor/floor.mtl");
		
		// carregar as texturas da skybox
		skybox = new Skybox(this);
		skybox.load(
                "assets/skyboxes/landscape/px.png",
                "assets/skyboxes/landscape/py.png",
                "assets/skyboxes/landscape/pz.png",
                "assets/skyboxes/landscape/nx.png",
                "assets/skyboxes/landscape/ny.png",
                "assets/skyboxes/landscape/nz.png"
        );
	}

	private void configureMaterials() {
		// Configurar Color Tracking
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
		glMateriali(GL_FRONT, GL_SHININESS, 100);
		
		// Especularidade do material definida explicitamente
		glMaterialfv(GL_FRONT, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.1f, 0.1f, 0.1f, 1.0f));

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.2f, 0.2f, 0.2f, 1.0f));		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.8f, 0.8f, 0.8f, 1.0f));		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));		// Componente especular

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}

	@Override
	public void release() {
		// Libertar as texturas (GPU)z
	}
	
	// Variavel para a rotação da lua
	private float angle = 0.0f;

	void updateRotation() {
		// Actualizar o Angulo de Rotacao
		angle += GL_PI / 10.0f * timeElapsed();
		angle %= 2.0f * GL_PI;
	}

    @Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    	// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(0.0f, 3.0f, 0.0f, 1.0f));
		
		// Cor por omissão do cenário
		glColor3f(0.5f, 0.5f, 0.5f);

		// Atualizar as variaveis de rotação
		updateRotation();

		// Desenhar primeiro a skybox
		skybox.render();

		// Desenhar a MiniGun
		glPushMatrix();
			glTranslatef(-6.0f, 0.0f, -6.0f);
			glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
			miniGun.render();
		glPopMatrix();

		// Desenhar o Wheatley
		glPushMatrix();
			glTranslatef(0.0f, 1.0f, 0.0f);
			wheatley.render();
		glPopMatrix();
		
		// Desenhar o Chão
		floor.render();

		// Desenhar a Lua
		glPushMatrix();
			glTranslatef(6.0f, 1.0f, 6.0f);
			glRotatef(toDegrees(angle), 0.0f, 1.0f, 0.0f);
			moon.render();
		glPopMatrix();

		// Desenhar o Copo
		glPushMatrix();
			glTranslatef(6.0f, 0.0f, -6.0f);
			glass.render();
		glPopMatrix();
	}

	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		Cameras.setCurrent(new Camera(3, 3, 3));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A07_Obj();
	}

}
