package pt.ipb.esact.compgraf.aulas.a13;

import java.awt.event.KeyEvent;

import javax.vecmath.Vector3f;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.MediaPlayer;
import pt.ipb.esact.compgraf.tools.math.Vector;

public class A13_Board extends DefaultGLWindow {
	
	/**
	 * Parametrização - algumas constantes
	 */

	// Velocidade Máxima
	private static final float MAX_VELOCITY = 1.0f;
	
	// Margem da chegada ao centro do cubo
	private static final float ARRIVE_MARGIN = 0.1f;
	
	// Tamanho dos cubos
	private static final float CUBE_SIZE = 1.0f;
	
	// Cubos por linha
	private static final int CUBES_PER_ROW = 11;
	
	/**
	 * Fim da parametrização
	 */

	// .obj loaders
	private ObjLoader cube;
	private ObjLoader sphere;
	
	// Vetores de movimento
	Vector3f position = new Vector3f(0, 2, 0);
	Vector3f velocity = new Vector3f(0, 0, 0);

	private Camera camera;
	
	// Display lists
	private int boardDl;
	
	// Varáveis de controlo da posição dos cubos
	private float xStart = - (float) CUBES_PER_ROW / 2.0f * CUBE_SIZE;
	private float zStart = xStart;
	
	// Linha e colunas atuais (controladas pelas teclas)
	private int currentRow = CUBES_PER_ROW / 2;
	private int currentCol = CUBES_PER_ROW / 2;

	// Flag que determina se a esfera está no centro do cubo
	private boolean arrived = true;
	
	// skybox
	public A13_Board() {
		super("A13 Board", true);
		
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

		// Criar display lists
		createBoardList();
	}

	private void createBoardList() {
		boardDl = glGenLists(1);
		glNewList(boardDl, GL_COMPILE);

			glPushAttrib(GL_ENABLE_BIT | GL_CURRENT_BIT);
			glEnable(GL_TEXTURE_2D);
	
			for(int row=0; row<CUBES_PER_ROW; row++) {
				for(int col=0; col<CUBES_PER_ROW; col++) {
					float x = xStart + (float) row * CUBE_SIZE;
					float z = zStart + (float) col * CUBE_SIZE;
					glPushMatrix();
						glTranslatef(x, 0.0f, z);
						cube.render();
					glPopMatrix();
				}
			}
	
			glPopAttrib();

		glEndList();
	}

	private void configureModels() {
		cube = new ObjLoader(this);
		cube.load("cube/cube.obj", "cube/cube.mtl");
		sphere = new ObjLoader(this);
		sphere.load("sphere/sphere.obj", "sphere/sphere.mtl");
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

		// Configurar uma light source
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
	protected void onKeyUp(KeyEvent e) {
		if(e.getKeyChar() == 'a') colUp();
		if(e.getKeyChar() == 'd') colDown();
		if(e.getKeyChar() == 'w') rowUp();
		if(e.getKeyChar() == 's') rowDown();

		// Bloquear mais teclas
		arrived = false;
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Posicionar as luzes e ajustar a direção do SPOT
		glLightfv(GL_LIGHT0, GL_POSITION, new float[] { 0.0f, 5.0f, 0.0f, 1.0f }, 0);
		updateMovement();
		
		glCallList(boardDl);
		
		glPushMatrix();
			glTranslatef(position.x, position.y, position.z);
			sphere.render();
		glPopMatrix();
	}
	
	void rowUp() {
		if(!arrived) return;
		currentRow += 1;
		if(currentRow > CUBES_PER_ROW - 1)
			currentRow = CUBES_PER_ROW - 1;
	}

	void rowDown() {
		if(!arrived) return;
		currentRow -= 1;
		if(currentRow < 0)
			currentRow = 0;
	}

	void colUp() {
		if(!arrived) return;
		currentCol += 1;
		if(currentCol > CUBES_PER_ROW - 1)
			currentCol = CUBES_PER_ROW - 1;
	}

	void colDown() {
		if(!arrived) return;
		currentCol -= 1;
		if(currentCol < 0)
			currentCol = 0;
	}
	
	private void updateMovement() {
		// Calcular o target com base na row/col atuais
		float x = xStart + (float) currentRow * CUBE_SIZE;
		float z = zStart + (float) currentCol * CUBE_SIZE;
		Vector3f target = new Vector3f(x, 0, z);
		
		// A distancia é o vetor entre postition <-> target
		Vector3f distance = new Vector3f();
		distance.sub(target, position);
		
		// Quando a distância é nula, não há movimento
		if(distance.length() == 0)
			return;
		
		// Quando a distância é menor que a margem chegámos!
		if(distance.length() < ARRIVE_MARGIN) {
			MediaPlayer.playSound(this, "audio/pop.wav");
			arrived = true;
			velocity.set(0, 0, 0);
			position = target;
			return;
		}
		
		// Velocidade é o vetor distância afetado da velocidade máxima
		velocity.set(distance);
		velocity.normalize();
		velocity.scale(MAX_VELOCITY * timeElapsed());
		position.add(velocity);
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A13_Board();
	}

}
