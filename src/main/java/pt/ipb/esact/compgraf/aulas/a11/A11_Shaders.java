package pt.ipb.esact.compgraf.aulas.a11;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.Shader;

public class A11_Shaders extends DefaultGLWindow {

	// .obj loaders
	private Shader phongShader;
	private Shader ambientShader;
	
	// skybox
	public A11_Shaders() {
		super("A11 Shaders", true);
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
		configureShaders();

	}

	private void configureShaders() {
		phongShader = new Shader();
		phongShader.load(this, "shaders/phong.vert", "shaders/phong.frag");
		ambientShader = new Shader();
		ambientShader.load(this, "shaders/ambient.vert", "shaders/ambient.frag");
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

		// Configurar uma point light
		glLightfv(GL_LIGHT0, GL_AMBIENT,  newFloatBuffer(.4f, .4f, .4f, 1));
		glLightfv(GL_LIGHT0, GL_DIFFUSE,  newFloatBuffer(1, 1, 1, 1));
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(1, 1, 1, 1));
		glEnable(GL_LIGHT0);

	}
	
	@Override
	public void release() {
		// Libertar as texturas (GPU)z
	}
		
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Posicionar as luzes
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(0.0f, 5.0f, 5.0f, 1.0f));

		// Desenhar o Wheatley
		glPushMatrix();
			glTranslatef(-2.0f, 0.0f, 0.0f);
			phongShader.bind();
			glutSolidTorus(0.5f, 1.0f, 10, 30);
			phongShader.unbind();
		glPopMatrix();

		glPushMatrix();
			glTranslatef(2.0f, 0.0f, 0.0f);
			ambientShader.bind();
			glutSolidTorus(0.5f, 1.0f, 10, 30);
			ambientShader.unbind();
		glPopMatrix();
		
	}
	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		Cameras.setCurrent(new Camera(0, 1, 3));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A11_Shaders();
	}

}
