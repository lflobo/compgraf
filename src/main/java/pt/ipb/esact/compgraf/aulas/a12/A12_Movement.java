package pt.ipb.esact.compgraf.aulas.a12;

import javax.vecmath.Vector3f;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.math.GlMath;
import pt.ipb.esact.compgraf.tools.math.Vector;

public class A12_Movement extends DefaultGLWindow {

	// .obj loaders
	private ObjLoader wheatley;
	private ObjLoader floor;
	private Camera camera;
	
	// Vetores de movimento
	Vector3f position = new Vector3f(0, 1, 0);
	Vector3f forward = GlMath.VECTOR_FORWARD;
	Vector3f velocity = new Vector3f(0, 0, 0);
	private float orientation = 0.0f;
	
	private static final float MAX_VELOCITY = 3.0f;
	private static final float MAX_ANGULAR_VELOCITY = 90.0f;
	
	// skybox
	public A12_Movement() {
		super("A12 Movement", true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		camera = new Camera();
		camera.eye.x = 3.0f;
		camera.eye.y = 3.0f;
		camera.eye.z = 3.0f;
		
		camera.at = new Vector(position);
		
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
		configureModels();

	}

	private void configureModels() {
		wheatley = new ObjLoader(this);
		wheatley.load("wheatley/wheatley.obj", "wheatley/wheatley.mtl");
		floor = new ObjLoader(this);
		floor.load("floor/floor.obj", "floor/floor.mtl");
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
		glLightfv(GL_LIGHT0, GL_AMBIENT,  new float[] { .1f, .1f, .1f, 1 }, 0);
		glLightfv(GL_LIGHT0, GL_DIFFUSE,  new float[] { 1, 1, 1, 1 }, 0);
		glLightfv(GL_LIGHT0, GL_SPECULAR, new float[] { 1, 1, 1, 1 }, 0);
		glEnable(GL_LIGHT0);

	}
	
	@Override
	public void release() {
		// Libertar as texturas (GPU)z
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Posicionar as luzes e ajustar a direção do SPOT
		glLightfv(GL_LIGHT0, GL_POSITION, new float[] { 0.0f, 5.0f, 0.0f, 1.0f }, 0);

		// Desenhar o Wheatley
		glPushMatrix();
			glTranslatef(position.x, position.y, position.z);
			glRotatef(orientation, 0, 1, 0);
			wheatley.render();
		glPopMatrix();

		floor.render();
		
		// Atualizar o Movimento
		updateRotation();
		updateMovement();
	}
	
	private void updateRotation() {
		if(isKeyPressed("left")) {
			// Aumentar o valor do ângulo da orientação
			orientation += MAX_ANGULAR_VELOCITY * timeElapsed();
			// Aplicar esse ângulo ao vetor FORWARD atual
			forward = GlMath.rotate(orientation, GlMath.VECTOR_UP, GlMath.VECTOR_FORWARD);
		}

		if(isKeyPressed("right")) {
			// Aumentar o valor do ângulo da orientação
			orientation -= MAX_ANGULAR_VELOCITY * timeElapsed();
			// Aplicar esse ângulo ao vetor FORWARD atual
			forward = GlMath.rotate(orientation, GlMath.VECTOR_UP, GlMath.VECTOR_FORWARD);
		}
	}

	private void updateMovement() {
		// Colocar a velocidade a 0s
		velocity.set(0, 0, 0);
		
		// Dar um passo para a esquerda
		if(isKeyPressed('a')) {
			// Calcular o vector LEFT com base no vector FORWARD
			Vector3f left = GlMath.rotate(90.0f, GlMath.VECTOR_UP, forward);
			// Adicionar esse movimento ao vetor velocidade
			velocity.add(left);
		}
		
		if(isKeyPressed('d'))  {
			// Calcular o vector LEFT com base no vector FORWARD
			Vector3f right = GlMath.rotate(-90.0f, GlMath.VECTOR_UP, forward);
			// Adicionar esse movimento ao vetor velocidade
			velocity.add(right);
		}
		
		if(isKeyPressed('w'))  {
			// Adicionar o vetor FORWARD ao vetor velocidade
			velocity.add(forward);
		}
		
		if(isKeyPressed('s'))  {
			// Adicionar o vetor FORWARD (negado) ao vetor velocidade
			velocity.add(forward);
			velocity.negate();
		}
		
		// Aplicar a MAX_VELOCITY definida ao vetor velocidade 
		velocity.scale(timeElapsed() * MAX_VELOCITY);

		// Somar essa velocidade à nossa posição atual
		position.add(velocity);
		
		// Se houve movimento -> atualizar a camara
		if(velocity.lengthSquared() > 0) {
			// Olhar para a posição atual (vetor at)
			camera.at = new Vector(position);
			// Forçar a atualização da camera
			setupCamera();
		}
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A12_Movement();
	}

}
