package pt.ipb.esact.compgraf.aulas.a12;

import java.awt.event.KeyEvent;
import java.nio.FloatBuffer;
import java.util.Random;

import com.jogamp.common.nio.Buffers;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.Shader;

public class A12_Shaders2 extends DefaultGLWindow {

	// .obj loaders
	private Shader diffuseShader;
	private ObjLoader wheatley;
	private ObjLoader floor;
	
	// skybox
	public A12_Shaders2() {
		super("A12 Shaders", true);
		
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

		configureLighting();
		configureMaterials();
		configureShaders();
		configureModels();

	}

	private void configureModels() {
		wheatley = new ObjLoader(this);
		wheatley.load("wheatley/wheatley.obj", "wheatley/wheatley.mtl");
		floor = new ObjLoader(this);
		floor.load("floor/floor.obj", "floor/floor.mtl");
	}

	private void configureShaders() {
		diffuseShader = new Shader();
		diffuseShader.load(this, "shaders/diffuse.vert", "shaders/diffuse.frag");
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

		// Configurar uma point light
		glLightfv(GL_LIGHT0, GL_AMBIENT,  newFloatBuffer( 0f, 0f, 0f, 1 ));
		glLightfv(GL_LIGHT0, GL_DIFFUSE,  newFloatBuffer( .4f, .4f, .4f, 1 ));
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer( 1, 1, 1, 1 ));
		glEnable(GL_LIGHT0);

		// Configurar uma spot light
		glLightfv(GL_LIGHT1, GL_AMBIENT,  newFloatBuffer( .4f, .4f, .4f, 1 ));
		lightDiffuse = newFloatBuffer( 1, 1, 1, 1 );
		glLightfv(GL_LIGHT1, GL_DIFFUSE,  lightDiffuse);
		glLightfv(GL_LIGHT1, GL_SPECULAR, newFloatBuffer( 1, 1, 1, 1 ));
		glLightf(GL_LIGHT1, GL_SPOT_CUTOFF, 25.0f);
		glLightf(GL_LIGHT1, GL_SPOT_EXPONENT, 0.1f);
		glEnable(GL_LIGHT1);

	}
	
	@Override
	public void release() {
		// Libertar as texturas (GPU)z
	}
	
	float x = -2.0f;

	boolean useShaders =  true;
	private FloatBuffer lightDiffuse;
	
	@Override
	protected void onKeyDown(KeyEvent e) {
		if(e.getKeyChar() == 's')
			useShaders = ! useShaders;
	}
	
	private Random random = new Random();
	
	public FloatBuffer randMult(FloatBuffer buffer) {
		FloatBuffer out = Buffers.copyFloatBuffer(buffer);
		boolean nextBoolean = random.nextBoolean();
		float nextFloat = nextBoolean ? random.nextFloat() : 0;
		for(int i=0; i<buffer.capacity(); i++) {
			out.put(i, nextFloat * buffer.get(i));
		}
		return out;
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		glLightfv(GL_LIGHT1, GL_DIFFUSE,  randMult(lightDiffuse));

		
		// Posicionar as luzes
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer( 0.0f, 5.0f, 0.0f, 1.0f ));
		glLightfv(GL_LIGHT1, GL_POSITION, newFloatBuffer( 0.0f, 6.0f, 0.0f, 1.0f ));
		glLightfv(GL_LIGHT1, GL_SPOT_DIRECTION, newFloatBuffer(0, -1, 0));

		// Desenhar o Wheatley
		glPushMatrix();
			glTranslatef(x, 1.0f, 0.0f);
			diffuseShader.bind();
			wheatley.render();
			diffuseShader.unbind();
		glPopMatrix();

		glPushMatrix();
			glTranslatef(2.0f, 1.0f, 0.0f);
			wheatley.render();
		glPopMatrix();
		
		if(useShaders)
			diffuseShader.bind();
		floor.render();
		if(useShaders)
			diffuseShader.unbind();

		if(isKeyPressed(KeyEvent.VK_A)) x -= timeElapsed();
		if(isKeyPressed(KeyEvent.VK_D)) x += timeElapsed();

	}
	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A12_Shaders2();
	}

}
