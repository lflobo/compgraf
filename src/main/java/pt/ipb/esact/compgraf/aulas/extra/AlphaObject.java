package pt.ipb.esact.compgraf.aulas.extra;

import java.awt.event.KeyEvent;
import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class AlphaObject extends DefaultGLWindow {

	// .obj loaders
	private ObjLoader obj;
	
	// skybox
	public AlphaObject() {
		super("A12 Shaders", true);
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

		configureLighting();
		configureMaterials();
		configureModels();

	}

	private void configureModels() {
		obj = new ObjLoader(this);
		obj.load("alpha/alpha-plane.obj", "alpha/alpha-plane.mtl");
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
	
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		glLightfv(GL_LIGHT1, GL_DIFFUSE,  lightDiffuse);
		
		// Posicionar as luzes
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer( 0.0f, 5.0f, 0.0f, 1.0f ));
		glLightfv(GL_LIGHT1, GL_POSITION, newFloatBuffer( 0.0f, 6.0f, 0.0f, 1.0f ));
		glLightfv(GL_LIGHT1, GL_SPOT_DIRECTION, newFloatBuffer(0, -1, 0));

		// Desenhar o Wheatley
		glPushMatrix();
			glTranslatef(x, 1.0f, 0.0f);
			obj.render();
		glPopMatrix();
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		Cameras.setCurrent(new Camera(3,3,3));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new AlphaObject();
	}

}
