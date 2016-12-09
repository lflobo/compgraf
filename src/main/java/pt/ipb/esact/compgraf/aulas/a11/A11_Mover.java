package pt.ipb.esact.compgraf.aulas.a11;

import pt.ipb.esact.compgraf.engine.movement.Mover;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.Shader;

public class A11_Mover extends DefaultGLWindow {

    private ObjLoader wheatley;

    private ObjLoader floor;

    private Mover mover;

    // Limites de velocidade (linear e angular)
    private static final float MAX_LINEAR_SPEED = 3.0f;

    private static final float MAX_ANGULAR_SPEED = 90.0f;

    // skybox
    private A11_Mover() {
        super("A09 Movement", true);
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
        wheatley = new ObjLoader(this);
        wheatley.load("assets/models/wheatley/wheatley.obj", "assets/models/wheatley/wheatley.mtl");

        floor = new ObjLoader(this);
        floor.load("assets/models/floor/floor.obj", "assets/models/floor/floor.mtl");

        mover = new Mover();
        mover.setLinearAcceleration(0.1f);
        mover.setAngularAcceleration(0.1f);
        mover.setMaxLinearSpeed(MAX_LINEAR_SPEED);
        mover.setMaxAngularSpeed(MAX_ANGULAR_SPEED);
    }

    private void configureMaterials() {
        // Configurar Color Tracking
        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
        glMateriali(GL_FRONT, GL_SHININESS, 100);

        // Especularidade do material definida explicitamente
        glMaterialfv(GL_FRONT, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));

        // carregar o shader
        Shader shader = new Shader();
        shader.load("assets/shaders/diffuse.vert", "assets/shaders/diffuse.frag");
        shader.bind();
    }

    private void configureLighting() {
        // Ativar a Lighting globalmente
        glEnable(GL_LIGHTING);

        // Definição do Modelo de luz para a luz ambiente
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.1f, 0.1f, 0.1f, 1.0f));

        // Configurar uma point light
        glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(.1f, .1f, .1f, 1));
        glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(1, 1, 1, 1));
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

        // Posicionar as luzes e ajustar a direção do SPOT
        glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(0.0f, 5.0f, 0.0f, 1.0f));

        updateMovement();

        // Desenhar o Wheatley
        glPushMatrix();
        {
            // Aplicar transformações do 'mover' do wheatley
            mover.transform(timeElapsed());
            wheatley.render();
        }
        glPopMatrix();


        floor.render();

        // atualizar a Camera
        mover.updateCamera(this);

        renderText("a = " + mover.getAcceleration(), 10, 20);
        renderText("v = " + mover.getVelocity(), 10, 40);
    }

    private void updateMovement() {
        if (isKeyPressed('w')) mover.forward();
        if (isKeyPressed('a')) mover.strafeLeft(timeElapsed());
        if (isKeyPressed('d')) mover.strafeRight(timeElapsed());
        if (isKeyPressed('s')) mover.backward();

        if (isKeyPressed("space")) mover.stop();
        if (isKeyPressed("left")) mover.rotateLeft(timeElapsed());
        if (isKeyPressed("right")) mover.rotateRight(timeElapsed());
    }

    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
        Camera camera = new Camera();
        Cameras.setCurrent(camera);
        mover.updateCamera(this);
        setupCamera();
    }

    // Função main confere capacidade de executável ao .java atual
    public static void main(String[] args) {
        new A11_Mover();
    }

}
