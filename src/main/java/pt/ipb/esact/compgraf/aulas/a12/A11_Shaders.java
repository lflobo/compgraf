package pt.ipb.esact.compgraf.aulas.a12;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.util.glsl.ShaderCode;
import com.jogamp.opengl.util.glsl.ShaderProgram;
import com.jogamp.opengl.util.glsl.ShaderState;

public class A11_Shaders extends SWTGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { 0.0f, 1.0f, 0.0f, 1.0f };
	
	public A11_Shaders(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 0.0f;
		camera.eye.y = 1.0f;
		camera.eye.z = 2.0f;
		
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
		
		// Configurar texturas
		configureTextures();
		
		// Inicializar os Vertex Arrays
		configureBufferObjects();
		
		// Carregar os Shaders
		configureShaders();
	}
	
	// Array com os IDs dos texture objects ('gavetas')
	private IntBuffer textures;
	private int TEX_CUBE; 
	
	private void configureTextures() {
		int textureCount = 1;
		textures = IntBuffer.allocate(textureCount);

		// Allocar as texturas
		glGenTextures(textureCount, textures);
		
		// Associar os IDs às variáveis
		TEX_CUBE = textures.get(0);
		
		// Carregar as texturas
		loadPackageTexture("stone.png", TEX_CUBE);
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
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

	private void configureShaders() {
		ShaderState st = new ShaderState();
		ShaderCode vs = ShaderCode.create(getCurrent(), GL_VERTEX_SHADER, this.getClass(), "shader", "shader/bin", "diffuse", true);
		vs.defaultShaderCustomization(getCurrent(), true, true);
		
		ShaderCode fs = ShaderCode.create(getCurrent(), GL_FRAGMENT_SHADER, this.getClass(), "shader", "shader/bin", "diffuse", true);
		fs.defaultShaderCustomization(getCurrent(), true, true);
		
		ShaderProgram p = new ShaderProgram();
		p.add(getCurrent(), vs, System.err);
		p.add(getCurrent(), fs, System.err);
		st.attachShaderProgram(getCurrent(), p, true);
	}

	@Override
	public void release() {
		// Libertar
		glDeleteBuffers(3, buffers);
		glDeleteTextures(1, textures);
	}

	// Arrays com vertex, normal, texes e indices
	private FloatBuffer vertices;
	private FloatBuffer texes;
	private FloatBuffer normals;
	private IntBuffer quadIndexes;
	
	public void initData() {
		// Preparar os vertices
		vertices = Buffers.newDirectFloatBuffer(new float[] {
			 1.0f,  0.0f,  1.0f, // bottom-right - index: 0 
			 1.0f,  0.0f, -1.0f, // top-right    - index: 1
			-1.0f,  0.0f, -1.0f, // top-left     - index: 2
			-1.0f,  0.0f,  1.0f, // bottom-left  - index: 3
		});
		
		// Normais dos vertices
		normals = Buffers.newDirectFloatBuffer(new float[] {
			0.0f, 0.0f, 1.0f, // bottom-right - index: 0
			0.0f, 0.0f, 1.0f, // top-right    - index: 1
			0.0f, 0.0f, 1.0f, // top-left     - index: 2
			0.0f, 0.0f, 1.0f, // bottom-left  - index: 3
		});

		// Coordenadas das texturas
		texes = Buffers.newDirectFloatBuffer(new float[] {
			1.0f, 0.0f, // bottom-right - index: 0
			1.0f, 1.0f, // top-right    - index: 1
			0.0f, 1.0f, // top-left     - index: 2
			0.0f, 0.0f  // bottom-left  - index: 3
		});

		// Indices que ligam os vertices com as primitivas
		// ATENCAO: Winding interessa
		quadIndexes = Buffers.newDirectIntBuffer(new int[] {
			0, 1, 2, 3 // Face
		});
	}
	
	// Identificadores dos VBOs
	private IntBuffer buffers;
	private int VERTEX_BUFFER;
	private int NORMAL_BUFFER;
	private int TEX_BUFFER;
	private int QUAD_INDEX_BUFFER;

	public void configureBufferObjects() {
		// Criar 4 buffers
		buffers = IntBuffer.allocate(4);
		glGenBuffers(4, buffers);
		
		VERTEX_BUFFER = buffers.get(0);
		TEX_BUFFER = buffers.get(1);
		NORMAL_BUFFER = buffers.get(2);
		QUAD_INDEX_BUFFER = buffers.get(3);
		
		// Inicializar os dados (vertex, normal, coord)
		initData();
		
		int FLOAT_SIZE = Float.SIZE / 8;
		int INTEGER_SIZE = Integer.SIZE / 8;

		// Preencher o buffer de vertex data
		glBindBuffer(GL_ARRAY_BUFFER, VERTEX_BUFFER);
		glBufferData(GL_ARRAY_BUFFER, FLOAT_SIZE * vertices.capacity(), vertices, GL_STATIC_DRAW);

		// Preencher o buffer de normal data
		glBindBuffer(GL_ARRAY_BUFFER, NORMAL_BUFFER);
		glBufferData(GL_ARRAY_BUFFER, FLOAT_SIZE * normals.capacity(), normals, GL_STATIC_DRAW);

		// Preencher o buffer de texcoord data
		glBindBuffer(GL_ARRAY_BUFFER, TEX_BUFFER);
		glBufferData(GL_ARRAY_BUFFER, FLOAT_SIZE * texes.capacity(), texes, GL_STATIC_DRAW);

		// Preencher o buffer de index das faces do tipo QUAD (elementos)
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, QUAD_INDEX_BUFFER);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, INTEGER_SIZE * quadIndexes.capacity(), quadIndexes, GL_STATIC_DRAW);
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);
		glColor3f(1.0f, 1.0f, 1.0f);
		
		glBindTexture(GL_TEXTURE_2D, TEX_CUBE);
		
		glPushClientAttrib(GL_CLIENT_VERTEX_ARRAY_BIT);
			// Ativar funcionalidade necessaria no client side
			glEnableClientState(GL_VERTEX_ARRAY);
			glEnableClientState(GL_NORMAL_ARRAY);
			glEnableClientState(GL_TEXTURE_COORD_ARRAY);

			// Dizer ao GPU para "apontar" para o buffer contendo o vertex array
			glBindBuffer(GL_ARRAY_BUFFER, VERTEX_BUFFER);
			// Dizer ao OpenGL que os vertices devem ser carregados do buffer atual
			glVertexPointer(3, GL_FLOAT, 0, 0);
	
			// Dizer ao GPU para "apontar" para o buffer contendo o normal array
			glBindBuffer(GL_ARRAY_BUFFER, NORMAL_BUFFER);
			// Dizer ao OpenGL que as normals devem ser carregados do buffer atual
			glNormalPointer(GL_FLOAT, 0, 0);
	
			// Dizer ao GPU para "apontar" para o buffer contendo o texcoord array
			glBindBuffer(GL_ARRAY_BUFFER, TEX_BUFFER);
			// Dizer ao OpenGL que as texcoords devem ser carregadas do buffer atual
			glTexCoordPointer(2, GL_FLOAT, 0, 0);

			// Dizer ao GPU para "apontar" para o buffer contendo os indexes das faces
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, QUAD_INDEX_BUFFER);
			// Desenhar o cubo como QUADS usando os indexes no buffer atual
			glDrawElements(GL_QUADS, quadIndexes.capacity(), GL_UNSIGNED_INT, 0);
			
			// Desenhar o cubo como POINTS
			glPointSize(20.0f);
			glDrawElements(GL_POINTS, quadIndexes.capacity(), GL_UNSIGNED_INT, 0);
		glPopClientAttrib();
	}

	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A11 Shaders");
		display.start(new A11_Shaders(display.getShell()));
	}

}
