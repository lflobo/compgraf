package pt.ipb.esact.compgraf.aulas.examples;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import javax.vecmath.Vector3f;
import java.awt.event.KeyEvent;

public class SideScroller extends DefaultGLWindow {

	// .obj loaders
	private ObjLoader character;
	private ObjLoader floor;

    // Acelerações
    Vector3f jumpAcc = new Vector3f(0, 30, 0);
    Vector3f gravityAcc = new Vector3f(0, -10, 0);

	// Limites de velocidade (linear e angular)
	private static final float MAX_LINEAR_VELOCITY = 10.0f;

	// Armazena a posição atual do personagem
	Vector3f position = new Vector3f(0, 0, 0);

	// Armazena o vetor "FORWARD" da personagem
	Vector3f forward = Vectors.forward();

	// Armazena a velocidade atual do personagem
	Vector3f velocity = new Vector3f(0, 0, 0);

	// skybox
	public SideScroller() {
		super("Side Scroller", true);
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
		character = new ObjLoader(this);
        character.setScale(0.4f);
		character.load("assets/models/minigun/MiniGun.obj", "assets/models/minigun/MiniGun.mtl");

        floor = new ObjLoader(this);
		floor.load("assets/models/floor/floor.obj", "assets/models/floor/floor.mtl");
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
		glLightfv(GL_LIGHT0, GL_AMBIENT,  newFloatBuffer( .1f, .1f, .1f, 1));
		glLightfv(GL_LIGHT0, GL_DIFFUSE,  newFloatBuffer( 1, 1, 1, 1));
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer( 1, 1, 1, 1));
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
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(position.x - 2, position.y, position.z, 1.0f));

		// Desenhar o Wheatley
		glPushMatrix();
			glTranslatef(position.x, position.y, position.z);
			character.render();
		glPopMatrix();

		floor.render();
		
		// Atualizar o Movimento
		updateMovement();

        // Atualizar a Camera se houver movimento/rotação
        updateCameraPosition();
	}

    private float jumpTime = 0;

    @Override
    protected void onKeyDown(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && position.y == 0) {
            jumpTime = 0.2f;
        }
    }

    /**
	 * Efetua os cálculos da velocidade com base no user input
	 * @return @c TRUE no caso de ser gerado movimento (velocity>0)
	 */
	private void updateMovement() {
		// Colocar a velocidade a 0s
		velocity.set(0, 0, 0);

		if(isKeyPressed('d'))  {
			// Adicionar o vetor FORWARD ao vetor velocidade
			velocity.add(forward);
		}
		
		if(isKeyPressed('a'))  {
			// Adicionar o vetor FORWARD (negado) ao vetor velocidade
			velocity.add(forward);
			velocity.negate();
		}

		// Aplicar a MAX_VELOCITY definida ao vetor velocidade 
		velocity.scale(timeElapsed() * MAX_LINEAR_VELOCITY);

        // Aplicar a força do salto
        if(jumpTime > 0) {
            jumpTime -= timeElapsed();

            Vector3f jumpAccVector = new Vector3f(jumpAcc);
            jumpAccVector.scale(timeElapsed());
            velocity.add(jumpAccVector);

            if(jumpTime < 0)
                jumpTime = 0;
        }

        // Aplicar __SEMPRE__ a força da gravidade
        if(position.y > 0) {
            Vector3f gravityAccVector = new Vector3f(gravityAcc);
            gravityAccVector.scale(timeElapsed());
            velocity.add(gravityAccVector);
        }

        // Somar essa velocidade à nossa posição atual
        position.add(velocity);

        // Não pode passar do chão
        if(position.y < 0)
            position.y = 0;
    }
	
	private void updateCameraPosition() {
		// Obter a camera atual
		Camera camera = Cameras.getCurrent();
		
		// O novo eye da camera vai ser relativa à posição do character
		// Movê-lo para trás na direção do "FORWARD"
		// Um pouco para cima (y+)
		camera.eye = new Vector3f(position);
		camera.eye.x -= 5f;

		// Olhar um pouco à frente do character
		camera.at = new Vector3f(position);

		// Forçar a atualização da camera
		setupCamera();
	}

	@Override
	public void resize(int width, int height) {
		setProjectionOrtho(width, height, 10.0f, 0.001f, 500.0f);
		Cameras.setCurrent(new Camera());
		updateCameraPosition();
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new SideScroller();
	}

}
