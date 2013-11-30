package pt.ipb.esact.compgraf.aulas.a09;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class A09_Obj extends SWTGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { 0.0f, 3.0f, 0.0f, 1.0f };
	
	// .obj loaders
	private ObjLoader wheatley;
	private ObjLoader moon;
	private ObjLoader miniGun;
	private ObjLoader floor;
	
	// skybox
	private Skybox skybox;

	private ObjLoader glass;

	public A09_Obj(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 3.0f;
		camera.eye.y = 3.0f;
		camera.eye.z = 3.0f;
		
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
		
		// Configurar os materiais
		configureMaterials();
	
		// Carregar os ficheiros .obj/.mtl
		wheatley = new ObjLoader(this);
		wheatley.load("wheatley/wheatley.obj", "wheatley/wheatley.mtl");
		
		moon = new ObjLoader(this);
		moon.load("moon/moon.obj", "moon/moon.mtl");

		glass = new ObjLoader(this);
		glass.load("glass/glass.obj", "glass/glass.mtl");

		miniGun = new ObjLoader(this);
		miniGun.setScale(0.5f); // Opcionalmente definir a escala
		miniGun.load("minigun/MiniGun.obj", "minigun/MiniGun.mtl");

		floor = new ObjLoader(this);
		floor.load("floor/floor.obj", "floor/floor.mtl");
		
		// carregar as texturas da skybox
		skybox = new Skybox(this);
		skybox.load("skybox/dd-px.png", "skybox/dd-py.png", "skybox/dd-pz.png", "skybox/dd-nx.png", "skybox/dd-ny.png", "skybox/dd-nz.png");
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

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		float[] ambientLowLight = { 0.1f, 0.1f, 0.1f, 1.0f };
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);

		// Este é o array com o RGB da luz ambiente
		float[] ambientLight = { 0.2f, 0.2f, 0.2f, 1.0f };
		// Este é o array com o RGB da luz difusa
		float[] diffuseLight = { 0.4f, 0.4f, 0.4f, 1.0f };
		// Este é o array com o RGB da luz especular
		float[] specularLight = { 0.5f, 0.5f, 0.5f, 1.0f };

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, ambientLight, 0);		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuseLight, 0);		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, specularLight, 0);		// Componente especular

		// Activação da luz 0
		glEnable(GL_LIGHT0);
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
	
	// Variavel para a rotação do wheatley
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
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);
		glColor3f(0.5f, 0.5f, 0.5f);

		// Atualizar as variaveis de rotação
		updateRotation();
		
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
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A09 Obj");
		display.start(new A09_Obj(display.getShell()));
	}

}
