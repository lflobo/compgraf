package pt.ipb.esact.compgraf.aulas.a11;

import pt.ipb.esact.compgraf.engine.light.Light;
import pt.ipb.esact.compgraf.engine.movement.Kinematic;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.*;
import pt.ipb.esact.compgraf.tools.math.Colors;

import javax.vecmath.Color4f;
import javax.vecmath.Vector3f;
import java.awt.event.KeyEvent;

public class A11_Kinematic extends DefaultGLWindow {

    private ObjLoader wheatley;

    private ObjLoader floor;

    private ObjLoader wall1;

    private ObjLoader monalisa;

    private Light spotlight;

    private Light pointlight;

    private Kinematic kinematic;

    // Limites de velocidade (linear e angular)
    private static final float MAX_LINEAR_SPEED = 3.0f;

    private static final float MAX_ANGULAR_SPEED = 90.0f;

    private Camera wheatleyCamera;

    private Camera hoverCamera;

    private ObjLoader doorframe;

    private ObjLoader door;

    private boolean openDoor;

    // skybox
    private A11_Kinematic() {
        super("A11 Kinematic", true);
        setMouseZoom(true);
        setMousePan(true);
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

    @Override
    protected void onKeyDown(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            Cameras.setCurrent(wheatleyCamera);
            setupCamera();
        }

        if (e.getKeyChar() == '2') {
            Cameras.setCurrent(hoverCamera);
            setupCamera();
        }

        if (e.getKeyChar() == 'o') {
            openDoor = !openDoor;
            if (openDoor)
                MediaPlayer.getInstance().play("assets/audio/doorcreek.mp3");
            else
                MediaPlayer.getInstance().play("assets/audio/doorclose.mp3", 800);
        }

        if(e.getKeyChar() == 'x') {
            spotlight.setSpotCutoff(50f);
            spotlight.setSpotExponent(1f);
            spotlight.setup();
        }

    }

    private void configureModels() {
        wheatley = new ObjLoader(this);
        wheatley.setScale(0.5f);
        wheatley.load("assets/models/wheatley/wheatley.obj", "assets/models/wheatley/wheatley.mtl");

        floor = new ObjLoader(this);
        floor.load("assets/models/floor/floor.obj", "assets/models/floor/floor.mtl");

        wall1 = new ObjLoader(this);
        wall1.load("assets/models/building/wall1.obj", "assets/models/building/wall1.mtl");

        doorframe = new ObjLoader(this);
        doorframe.load("assets/models/building/doorframe.obj", "assets/models/building/doorframe.mtl");

        door = new ObjLoader(this);
        door.load("assets/models/building/door.obj", "assets/models/building/door.mtl");

        monalisa = new ObjLoader(this);
        monalisa.load("assets/models/building/monalisa.obj", "assets/models/building/monalisa.mtl");

        kinematic = new Kinematic();
        kinematic.setMaxLinearSpeed(MAX_LINEAR_SPEED);
        kinematic.setMaxAngularSpeed(MAX_ANGULAR_SPEED);
        kinematic.setPosition(0f, 1f, -5f);
        kinematic.setForwardKey("w");
        kinematic.setBackwardKey("s");
        kinematic.setStrafeLeftKey("a");
        kinematic.setStrafeRightKey("d");
        kinematic.setRotateLeftKey("left");
        kinematic.setRotateRightKey("right");
    }

    private void configureMaterials() {
        // Configurar Color Tracking
        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
        glMateriali(GL_FRONT, GL_SHININESS, 100);

        // carregar o shader
        Shader shader = new Shader();
        shader.load("assets/shaders/diffuse.vert", "assets/shaders/diffuse.frag");
        shader.bind();
    }

    private void configureLighting() {
        // Ativar a Lighting globalmente
        glEnable(GL_LIGHTING);

        // Definição do Modelo de luz para a luz ambiente
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.0f, 0.0f, 0.0f, 1.0f));

        pointlight = new Light(GL_LIGHT0);
        pointlight.setPosition(0.0f, 2.0f, 0.0f);
        pointlight.setDiffuse(Colors.BLUE);
        pointlight.setup();

        spotlight = new Light(GL_LIGHT1);
        spotlight.setDiffuse(1.0f, 1.0f, 0.0f);
        spotlight.setPosition(-0.3f, 1.9f, 1.0f);
        spotlight.setSpotExponent(5.0f);
        spotlight.setSpotCutoff(25.0f);
        spotlight.setSpotDirection(new Vector3f(-1f, -1f, 0));

        spotlight.setup();

    }

    @Override
    public void release() {
        // Libertar as texturas (GPU)z
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Obter o input do utilizador
        kinematic.handleInput(this);
        boolean moved = kinematic.update(timeElapsed());
        if (moved)
            updateCameras();

        // Posicionar as luzes e ajustar a direção do SPOT
        spotlight.position();
        pointlight.position();

        // Desenhar o Wheatley
        glPushMatrix();
        {
            // Aplicar transformações do 'kinematic' do wheatley
            kinematic.transform();
            wheatley.render();
        }
        glPopMatrix();

        drawPainting();
        drawDoorSystem();
        drawWalls();

        floor.render();
    }

    private void drawPainting() {
        glPushMatrix();
        {
            glTranslatef(-0.75f, 1.0f, 1.0f);
            glRotatef(90.0f, 0, 1, 0);
            monalisa.render();
        }
        glPopMatrix();
    }

    private float doorAngle = 0.0f;

    private void drawDoorSystem() {
        // keep rotating until we reach 90deg
        if (openDoor && doorAngle < 90.0f) {
            doorAngle += 90 * timeElapsed();
        }

        // keep rotating until we reach 0deg
        if (!openDoor && doorAngle > 0) {
            doorAngle -= 90 * timeElapsed();
        }

        glPushMatrix();
        {
            glTranslatef(-0.6f, 0, 3);
            doorframe.render();
            glPushMatrix();
            {
                glRotatef(doorAngle, 0, 1, 0);
                door.render();
            }
            glPopMatrix();
        }
        glPopMatrix();
    }

    private void updateCameras() {

        // O novo eye da camera vai ser relativa à posição do wheatley
        // Um pouco para cima (y+)
        wheatleyCamera.eye = new Vector3f(kinematic.getPosition());
        wheatleyCamera.eye.y += 0.4f;

        // Olhar um pouco à frente do wheatley
        wheatleyCamera.at = new Vector3f(kinematic.getPosition());
        wheatleyCamera.at.add(kinematic.getForward());

        // forçar a hoverCamera a olhar para o wheatley
        hoverCamera.at = kinematic.getPosition();

        // Forçar a atualização da camera
        setupCamera();
    }

    private void drawWalls() {
        float z = -7;

        // Left Walls
        glPushMatrix();
        {
            glTranslatef(0.8f, 0, z);
            for (int i = 0; i < 10; i++) {
                glTranslatef(0, 0, 1);
                wall1.render();
            }
        }
        glPopMatrix();

        // Right Walls
        glPushMatrix();
        {
            glTranslatef(-0.85f, 0, z);
            for (int i = 0; i < 10; i++) {
                glTranslatef(0, 0, 1);
                wall1.render();
            }
        }
        glPopMatrix();
    }

    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);

        hoverCamera = new Camera(0, 5, -5);
        wheatleyCamera = new Camera();

        Cameras.setCurrent(wheatleyCamera);
        updateCameras();

        setupCamera();
    }

    // Função main confere capacidade de executável ao .java atual
    public static void main(String[] args) {
        new A11_Kinematic();
    }

}
