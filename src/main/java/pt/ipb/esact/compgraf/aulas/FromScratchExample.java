package pt.ipb.esact.compgraf.aulas;

import com.jogamp.opengl.util.texture.Texture;
import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.math.GLPrimitives;

/**
 * 1) Criar a classe FromScratchExample
 * Fazer 'extends DefaultGLWindow' para que herde um contexto OpenGL
 */
public class FromScratchExample extends DefaultGLWindow {

    private Skybox skybox;
    private Texture texMoon;

    public FromScratchExample() {
        /**
         * 2) Invocar o super-construtor com o nome da Janela (1º argumento)
         *    Definir o refresh como 'continuous' (2º argumento)
         *
         */
        super("Tobias", true);

        /**
         * 3) Ativar o mouse zoom/pan
         */
        setMouseZoom(true);
        setMousePan(true);
    }

    /**
     * 4) Criar a função 'main' que permite que a classe atual seja 'executável'
     *
     * @HINT: escrever 'psvm' no corpo da classe, o IntelliJ faz o resto
     */
    public static void main(String[] args) {
        new FromScratchExample();
    }

    @Override
    public void init() {
        // 5a) definir a cor de fundo
        glClearColor(0, 0, 0, 0);

        /**
         * 5b) Ativar o teste de profundidade
         *   @URL: https://apps.ipb.pt/~ellobo/compgraf/opengl/red/chapter10.html#name7
         */
        glEnable(GL_DEPTH_TEST);

        // Ativar multisampling
        glEnable(GL_MULTISAMPLE);

        // Ativar Culling e Definir face para culling
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);

        configureLighting();
        configureMaterials();
        configureSkybox();
        configureTextures();
    }

    private void configureLighting() {
        /**
         * 6) Configurar as luzes
         */
        // ativar as luzes
        glEnable(GL_LIGHTING);

        // Definir as configurações globais da luz
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));

        // Criar um ponto de luz e configurá-lo
        glEnable(GL_LIGHT0);
        glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.1f, 0.1f, 0.1f, 1.0f));
        glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.8f, 0.8f, 0.8f, 1.0f));
        glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));

        glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);
    }

    private void configureMaterials() {
        /**
         * 7) Configuração global dos materiais
         */
        // Ativar color tracking
        glEnable(GL_COLOR_MATERIAL);
        // Dizer qual a componente da cor para o tracking
        glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);

        // Definir o tamanho do 'specular' effect
        // 64 - muito difuso, 128 - muito !
        glMateriali(GL_FRONT, GL_SHININESS, 128);
        // Definir a componente especular do material
        glMaterialfv(GL_FRONT, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));
    }

    private void configureSkybox() {
        /**
         * 8) Criar uma skybox
         */
        skybox = new Skybox(this);
        skybox.load(
                "assets/skyboxes/planet1/px.png",
                "assets/skyboxes/planet1/py.png",
                "assets/skyboxes/planet1/pz.png",
                "assets/skyboxes/planet1/nx.png",
                "assets/skyboxes/planet1/ny.png",
                "assets/skyboxes/planet1/nz.png"
        );
    }

    private void configureTextures() {
        /**
         * 9) Carregar
         */
        glEnable(GL_TEXTURE_2D);
        texMoon = loadTexture("assets/tex/moon.png");
    }

    @Override
    public void resize(int width, int height) {
        /**
         * 10) Configurar a perspectiva
         */
        setProjectionPerspective(width, height, 100f, 0.01f, 3000f);

        /**
         * 11) Configurar uma Camera e defini-la como 'current'
         */
        Camera camera = new Camera(0.0f, 0.0f, 4.0f);
        Cameras.setCurrent(camera);
        setupCamera();
    }

    @Override
    public void render(int width, int height) {
        /**
         * 12a) Limpar o COLOR/DEPTH Buffer
         */
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        /**
         * 12b) Posicionar a LIGHT0
         */
        glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(0, 4f, 0, 1f));

        // Se a skybox foi configurada, renderizá-la
        if (skybox != null)
            skybox.render();

        // Se foi carregada a textura 'moon.png' usá-la
        if (texMoon != null)
            texMoon.bind(this);

        // Desenhar uma 'Sphere' com a textura previamente carregada
        glPushMatrix();
        {
            glRotatef(-90f, 1f, 0, 0);
            GLPrimitives.drawSphere(2.0f, 32, 32);
        }
        glPopMatrix();
    }

    @Override
    public void release() {
        /**
         * 13) Libertar recursos
         */
        texMoon.destroy(this);
    }
}
