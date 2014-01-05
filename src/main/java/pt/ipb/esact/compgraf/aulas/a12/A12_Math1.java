package pt.ipb.esact.compgraf.aulas.a12;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class A12_Math1 extends SWTGLWindow {

	// .obj loaders
	private ObjLoader car;
	private ObjLoader floor;
	
	// skybox
	private Skybox skybox;

	public A12_Math1(Composite parent) {
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
		
		// Configurar os materiais
		configureMaterials();

		// Carregar os ficheiros .obj/.mtl
		car = new ObjLoader(this);
		car.load("car/car3.obj", "car/car3.mtl");
		
		floor = new ObjLoader(this);
		floor.load("track/track.obj", "track/track.mtl");
		
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
	
	float[] positionLitght0 = { 10.0f, 10.0f, 0.0f, 1.0f };
	float[] positionLitght1 = { 0.0f, 10.0f, 0.0f, 1.0f };

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		float[] ambientLowLight = { 0.1f, 0.1f, 0.1f, 1.0f };
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);

		glLightfv(GL_LIGHT0, GL_AMBIENT,  new float[] { .4f, .4f, .4f, 1 }, 0);
		glLightfv(GL_LIGHT0, GL_DIFFUSE,  new float[] { 1, 1, 1, 1 }, 0);
		glLightfv(GL_LIGHT0, GL_SPECULAR, new float[] { 1, 1, 1, 1 }, 0);
		glEnable(GL_LIGHT0);

		glLightfv(GL_LIGHT1, GL_AMBIENT,  new float[] { .4f, .4f, .4f, 1 }, 0);
		glLightfv(GL_LIGHT1, GL_DIFFUSE,  new float[] { 1, 1, 1, 1 }, 0);
		glLightfv(GL_LIGHT1, GL_SPECULAR, new float[] { 1, 1, 1, 1 }, 0);
		glEnable(GL_LIGHT1);

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

		glColor3f(0.5f, 0.5f, 0.5f);

		skybox.render();
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);

		// Desenhar o Wheatley
		glPushMatrix();
			glTranslatef(0.0f, 1.0f, 0.0f);
			car.render();
		glPopMatrix();
		
		// Desenhar o Chão
		floor.render();
		
	}
	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A12 Math1");
		display.start(new A12_Math1(display.getShell()));
	}

}
