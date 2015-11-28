package pt.ipb.esact.compgraf.aulas.a09ex;

import com.jogamp.opengl.util.texture.Texture;
import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import java.nio.FloatBuffer;

public class A09_ExercicioSolucao extends DefaultGLWindow {

    private Skybox skybox;

	private int sphereDisplayList;

    private Texture texPlano1;
    private Texture texPlano2;
    private ObjLoader floor;
    private ObjLoader wheatley;

    public A09_ExercicioSolucao() {
		super("A09 Exercicio", true);
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

		// Configurar as luzes
		configureLighting();
		
		// Configurar as texturas
		configureTextures();
		
		// Configurat o fog
		configureFog();
		
		// Configurar os materiais
		configureMaterials();
		
		// Criar a display list com as esferas aleatorias
		createSpheres(20, 10);
	
		/**
		 * II
		 * 	e) utilizando ObjLoader carregar 'floor/floor.obj'
		 *  f) carregar o modelo 'wheatley/wheatley.obj'
		 */
        floor = new ObjLoader(this);
        floor.load(
                "assets/models/floor/floor.obj",
                "assets/models/floor/floor.mtl"
        );

        wheatley = new ObjLoader(this);
        wheatley.load(
                "assets/models/wheatley/wheatley.obj",
                "assets/models/wheatley/wheatley.mtl"
        );


        // I d) carregar aqui a skybox
        skybox = new Skybox(this);
        skybox.load(
                "assets/skyboxes/landscape/px.png",
                "assets/skyboxes/landscape/py.png",
                "assets/skyboxes/landscape/pz.png",
                "assets/skyboxes/landscape/nx.png",
                "assets/skyboxes/landscape/ny.png",
                "assets/skyboxes/landscape/nz.png"
        );

    }

	/**
	 * Cria esferas em posicoes aleatorias na extensao descrita por area
	 * @param numSpheres Numero de esferas a criar
	 * @param area A area
	 */
	private void createSpheres(int numSpheres, int area) {
		sphereDisplayList = glGenLists(1);
		glNewList(sphereDisplayList, GL_COMPILE);
			for(int s=0; s<numSpheres; s++) {
				glPushMatrix();
					glTranslatef(randomBinomial(area), 1, randomBinomial(area));
					glutSolidSphere(0.2f, 10, 10);
				glPopMatrix();
			}
		glEndList();
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
	
	private void configureTextures() {
        glEnable(GL_TEXTURE_2D);

		// II b) Carregar aqui as texturas para os 2 planos
        texPlano1 = loadTexture("assets/tex/brick.png");
        texPlano2 = loadTexture("assets/tex/stone.png");
    }

	FloatBuffer positionLitght0 = newFloatBuffer(10.0f, 10.0f, 0.0f, 1.0f);
	FloatBuffer positionLitght1 = newFloatBuffer(0.0f, 10.0f, 0.0f, 1.0f);
	FloatBuffer positionLitght2 = newFloatBuffer(-10.0f, 10.0f, 0.0f, 1.0f);

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.1f, 0.1f, 0.1f, 1.0f));

		// I c) Configurar aqui as 'light points'

        // Configurar e Activar a Luz 0
        glLightfv(GL_LIGHT0, GL_AMBIENT,  newFloatBuffer(1.0f, 0.0f, 0.0f, 1.0f));		// Componente ambiente
        glLightfv(GL_LIGHT0, GL_DIFFUSE,  newFloatBuffer(1.0f, 0.0f, 0.0f, 1.0f));		// Componente difusa
        glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(1.0f, 0.0f, 0.0f, 1.0f));		// Componente especular

        // Activação da luz 0
        glEnable(GL_LIGHT0);

        // Configurar e Activar a Luz 1
        glLightfv(GL_LIGHT1, GL_AMBIENT,  newFloatBuffer(0.0f, 0.0f, 1.0f, 1.0f));		// Componente ambiente
        glLightfv(GL_LIGHT1, GL_DIFFUSE,  newFloatBuffer(0.0f, 0.0f, 1.0f, 1.0f));		// Componente difusa
        glLightfv(GL_LIGHT1, GL_SPECULAR, newFloatBuffer(0.0f, 0.0f, 1.0f, 1.0f));		// Componente especular

        // Activação da luz 1
        glEnable(GL_LIGHT1);

        // Configurar e Activar a Luz 2
        glLightfv(GL_LIGHT2, GL_AMBIENT,  newFloatBuffer(1.0f, 1.0f, 0.0f, 1.0f));		// Componente ambiente
        glLightfv(GL_LIGHT2, GL_DIFFUSE,  newFloatBuffer(1.0f, 1.0f, 0.0f, 1.0f));		// Componente difusa
        glLightfv(GL_LIGHT2, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 0.0f, 1.0f));		// Componente especular

        // Activação da luz 2
        glEnable(GL_LIGHT2);

	}
	
	private void configureFog() {
		// II g) configurar aqui o FOG
        glEnable(GL_FOG);

        // Definir a cor do nevoeiro
        glFogfv(GL_FOG_COLOR, newFloatBuffer(0.75f, 0.75f, 0.75f, 1.0f));
        // A que distância os objectos começam a ser afetados
        glFogf(GL_FOG_START, 5.0f);
        // A que distância o FOG toma conta por completo
        glFogf(GL_FOG_END, 30.0f);
        // Curva para o cálculo do Fog
        glFogi(GL_FOG_MODE, GL_LINEAR);

        glFogf(GL_FOG_DENSITY, 0.1f);
    }

	@Override
	public void release() {
		// Libertar as texturas (GPU)z
	}
		
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Posicionar as luzes
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0);
		glLightfv(GL_LIGHT1, GL_POSITION, positionLitght1);
		glLightfv(GL_LIGHT2, GL_POSITION, positionLitght2);

		glColor3f(0.5f, 0.5f, 0.5f);

		// I d) fazer aqui o render da skybox
        skybox.render();

		// II e) Desenhar o floor no centro do cenário
        floor.render();
		
		// II f) Desenhar o wheatley
        glPushMatrix();
        {
            glTranslatef(2, 1, 1);
            wheatley.render();
        }
        glPopMatrix();
		
		// II h) desenhar aqui a display list 'sphereDisplayList'
		glCallList(sphereDisplayList);

		/**
		 * II
		 * 	a) criar 2 planos
		 *  c) aplicar as texturas a cada plano
		 *  d) adicione blending a um dos planos para simular transparencia
		 */

        texPlano1.bind(this);
        glBegin(GL_QUADS);
        {
            glTexCoord2f(1, 0);
            glVertex3f(1, 1, 0);

            glTexCoord2f(1, 1);
            glVertex3f(3, 1, 0);

            glTexCoord2f(0, 1);
            glVertex3f(3, 3, 0);

            glTexCoord2f(0, 0);
            glVertex3f(1, 3, 0);
        }
        glEnd();


        glPushAttrib(GL_ENABLE_BIT | GL_DEPTH_BUFFER_BIT);
        {
            glEnable(GL_BLEND);
            glDepthMask(false); // Desativar teste de profundidade
            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

            glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            texPlano2.bind(this);
            glBegin(GL_QUADS);
            {
                glTexCoord2f(1, 0);
                glVertex3f(-3, 1, 0);

                glTexCoord2f(1, 1);
                glVertex3f(-1, 1, 0);

                glTexCoord2f(0, 1);
                glVertex3f(-1, 3, 0);

                glTexCoord2f(0, 0);
                glVertex3f(-3, 3, 0);
            }
            glEnd();

        }
        glPopAttrib();




	}
	
	@Override
	public void resize(int width, int height) {
		// I a) Configurar a projection aqui
        setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		// I b) Configurar a Camera aqui
        Cameras.setCurrent(new Camera(3, 3, 3));

		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A09_ExercicioSolucao();
	}

}
