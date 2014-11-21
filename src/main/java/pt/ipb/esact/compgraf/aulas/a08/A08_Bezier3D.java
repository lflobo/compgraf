package pt.ipb.esact.compgraf.aulas.a08;

import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import com.jogamp.opengl.util.texture.Texture;

public class A08_Bezier3D extends DefaultGLWindow {

	/**
	 * Configuração do Bezier 3D
	 */
	
	// Tamanho do Chão
	float FLOOR_SIZE = 100.0f;

	private static final int NUM_POINTS_U = 3;
	private static final int NUM_POINTS_V = 3;

	FloatBuffer TEX_POINTS = FloatBuffer.wrap(new float[] {
		// u0
		0.0f, 1.0f, // v0
		0.0f, 0.5f, // v1
		0.0f, 0.0f, // v2
		// u1
		0.5f, 1.0f, // v0
		0.5f, 0.5f, // v1
		0.5f, 0.0f, // v2
		// u2
		1.0f, 1.0f, // v0
		1.0f, 0.5f, // v1
		1.0f, 0.0f, // v2
	});

	FloatBuffer CONTROL_POINTS = FloatBuffer.wrap(new float[] {
		// u0
		-2.0f, 6.0f, 0.0f, // v0
		-2.0f, 4.0f, 0.0f, // v1
		-2.0f, 2.0f, 0.0f, // v2
		// u1
		0.0f, 6.0f, 0.0f,  // v0
		0.0f, 4.0f, 0.0f,  // v1
		0.0f, 2.0f, 0.0f,  // v2
		// u2
		2.0f, 6.0f, 0.0f,  // v0
		2.0f, 4.0f, 0.0f,  // v1
		2.0f, 2.0f, 0.0f,  // v2
	});

	private static final float U_MIN = 0.0f;
	private static final float U_MAX = 100.0f;

	private static final float V_MIN = 0.0f;
	private static final float V_MAX = 100.0f;
	
	public A08_Bezier3D() {
		super("A08 Bezier 3D", true);
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
//		glEnable(GL_CULL_FACE);

		glCullFace(GL_BACK);

		// Configurar as luzes
		configureLighting();
		
		// Configurar os materiais
		configureMaterials();
		
		// Configurar as texturas
		configureTextures();
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
		
		// Este é o array com o RGB da luz ambiente
		float[] ambientLight = { 0.6f, 0.6f, 0.6f, 1.0f };
		float[] ambientLowLight = { 0.5f, 0.5f, 0.5f, 1.0f };
		// Este é o array com o RGB da luz difusa
		float[] diffuseLight = { 0.4f, 0.4f, 0.4f, 1.0f };
		// Este é o array com o RGB da luz especular
		float[] specularLight = { 0.5f, 0.5f, 0.5f, 1.0f };

		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, ambientLight, 0);		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuseLight, 0);		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, specularLight, 0);		// Componente especular

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}
	
	// Representam as posições (identificadores) das texturas
	private Texture TEX_FLOOR;
	private Texture TEX_MESH;
	
	private void configureTextures() {
		// Carregar as texturas
		TEX_FLOOR = loadPackageTexture("floor.png");
		TEX_MESH = loadPackageTexture("mesh.png");
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
	}

	@Override
	public void release() {
		// Libertar as texturas (GPU)
		TEX_FLOOR.destroy(this);
		TEX_MESH.destroy(this);
	}
	
	// Variavel para o bounce do ponto central
	private float delta = 0.0f;
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-10.0f, 20.0f, -10.0f, 1.0f));
		
		glColor3f(0.5f, 0.5f, 0.5f);

		TEX_MESH.bind(this);

		// Mexer os pontos de baixo da Mesh
		delta += 1.0f * timeElapsed() * GL_PI;
		delta %= 2.0f * GL_PI;
		CONTROL_POINTS.put(14, 5.0f * sinf(delta));

		glEnable(GL_MAP2_TEXTURE_COORD_2);
		glEnable(GL_MAP2_VERTEX_3);

			// Carregar os pontos de controlo para a superfície
			glMap2f(
				GL_MAP2_VERTEX_3,			// Tipo de dados gerados
				U_MIN,						// Valor minimo do u
				U_MAX,						// Valor maximo do u
				3,							// Distancia entre pontos (dominio u)
				NUM_POINTS_U,				// Numero de pontos de controlo (dominio u)
				V_MIN,						// Valor minimo do v
				V_MAX,						// Valor maximo do v
				3 * NUM_POINTS_U,			// Distancia entre pontos (dominio v)
				NUM_POINTS_V,				// Numero de pontos de controlo (dominio v)
				CONTROL_POINTS				// FloatBuffer contendo pontos de controlo
			);

			// Carregar as coordenadas da textura
			glMap2f(
				GL_MAP2_TEXTURE_COORD_2,	// Tipo de dados gerados
				U_MIN,						// Valor minimo do u
				U_MAX,						// Valor maximo do u
				2,							// Distancia entre pontos (dominio u)
				NUM_POINTS_U,				// Numero de pontos de controlo (dominio u)
				V_MIN,						// Valor minimo do v
				V_MAX,						// Valor maximo do v
				2 * NUM_POINTS_U,			// Distancia entre pontos (dominio v)
				NUM_POINTS_V,				// Numero de pontos de controlo (dominio v)
				TEX_POINTS					// FloatBuffer contendo pontos de controlo
			);

			int paritions = 100;
			glMapGrid2f(paritions, U_MIN, U_MAX, paritions, V_MIN, V_MAX);

			glEvalMesh2(GL_FILL, 0, paritions, 0, paritions);

		glDisable(GL_MAP2_VERTEX_3);
		glDisable(GL_MAP2_TEXTURE_COORD_2);

		// Desenhar os pontos de controlo
		drawCtrlPoints();
		// drawCtrlLines();

		// Desenhar os suportes da Mesh
		drawBaseCones();

		glColor3f(1.0f, 1.0f, 1.0f);
		TEX_FLOOR.bind(this);
		demo().drawGround(GL_TRIANGLE_STRIP, FLOOR_SIZE, 20, 10.0f);
	}

	private void drawCtrlPoints() {
		glColor3f(0.3f, 0.0f, 0.0f);
		for(int i=0; i < NUM_POINTS_U * NUM_POINTS_V * 3; i += 3) {
			float x = CONTROL_POINTS.get(i), y = CONTROL_POINTS.get(i+1), z = CONTROL_POINTS.get(i+2);
			glPushMatrix();
				glTranslatef(x, y, z);
				glutSolidSphere(0.1, 10, 10);
			glPopMatrix();
		}
	}
	
	private void drawBaseCones() {
		glPushAttrib(GL_CURRENT_BIT | GL_ENABLE_BIT);
			glDisable(GL_TEXTURE_2D);
			glColor3f(0.3f, 0.3f, 0.0f);
			glPushMatrix();
				glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
				glTranslatef(2.0f, 0.0f, 0.0f);
				glutSolidCone(2.0f, 2.0f, 30, 10);
				glTranslatef(-4.0f, 0.0f, 0.0f);
				glutSolidCone(2.0f, 2.0f, 30, 10);
			glPopMatrix();
		glPopAttrib();
	}
	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		Cameras.setCurrent(new Camera(5, 7, 5));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A08_Bezier3D();
	}

}
