package pt.ipb.esact.compgraf.aulas.a12;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.Shader;
import pt.ipb.esact.compgraf.tools.math.GlMath;

import java.awt.event.KeyEvent;

public class A12_Planets extends DefaultGLWindow {

    private final Camera defaultCamera;
    private final Camera earthCamera;

    private ObjLoader earthClouds;
    private ObjLoader earth;
    private ObjLoader sun;
    private ObjLoader mercury;
    private ObjLoader moon;
    private Skybox skybox;
    private Shader shader;

    public static void main(String[] args) {
        new A12_Planets();
    }

    public A12_Planets() {
        super("A12 Planets", true);
        setMousePan(true);
        setMouseZoom(true);

        // Camera por omissão
        defaultCamera = new Camera(30, 30, 30);
        Cameras.setCurrent(defaultCamera);

        // Camera da terra
        earthCamera = new Camera(EARTH_DISTANCE * 1.1f, 0, 0);
    }

    @Override
    public void init() {
        glClearColor(0, 0, 0, 1);

        glEnable(GL_DEPTH_TEST);
        glEnable(GL_MULTISAMPLE);
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);

        configureLighting();

        earthClouds = new ObjLoader(this);
        earthClouds.load("assets/models/planets/earth-clouds.obj", "assets/models/planets/earth-clouds.mtl");

        earth = new ObjLoader(this);
        earth.load("assets/models/planets/earth.obj", "assets/models/planets/earth.mtl");

        moon = new ObjLoader(this);
        moon.load("assets/models/planets/moon.obj", "assets/models/planets/moon.mtl");

        sun = new ObjLoader(this);
        sun.load("assets/models/planets/sun.obj", "assets/models/planets/sun.mtl");

        mercury = new ObjLoader(this);
        mercury.load("assets/models/planets/mercury.obj", "assets/models/planets/mercury.mtl");

        skybox = new Skybox(this);
        skybox.load(
                "assets/skyboxes/stars/px.png",
                "assets/skyboxes/stars/py.png",
                "assets/skyboxes/stars/pz.png",
                "assets/skyboxes/stars/nx.png",
                "assets/skyboxes/stars/ny.png",
                "assets/skyboxes/stars/nz.png"
        );
    }

    private void configureLighting() {
        // Ativar a Lighting globalmente
        glEnable(GL_LIGHTING);

        // Luz Ambiente muito tenue
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(.1f, .1f, .1f, 1.0f));

        // Luz1 == SOL
        glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(.01f, .01f, .01f, 1));
        glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(1, 1, 1, 1));
        glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(1, 1, 1, 1));
        glEnable(GL_LIGHT0);

    }

    private String following = null;

    @Override
    protected void onKeyUp(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '1':
                following = "mercury";
                break;

            case '3':
                following = "earth";
                break;

            case '#':
                following = "earth.moon";
                break;

            case 's':
                following = null;
                Cameras.setCurrent(defaultCamera);
                setupCamera();
                break;
        }
    }

    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
        setupCamera();
    }

    // SOL
    private float sunRotSpeed = GL_PI / 10;
    private float sunRot = 0;

    // Terra
    private static final float EARTH_DISTANCE = 30f;

    private float earthRotSpeed = GL_PI / 5;
    private float earthRot = 0;

    private float earthTrlSpeed = GL_PI / 12;
    private float earthTrl = 0;

    // Terra
    private static final float EARTH_MOON_DISTANCE = 5f;

    private float moonRotSpeed = GL_PI / 5;
    private float moonRot = 0;

    private float moonTrlSpeed = GL_PI / 12;
    private float moonTrl = 0;

    // Mercúrio
    private static final float MERCURY_DISTANCE = 15f;

    private float mercuryRotSpeed = GL_PI / 5;
    private float mercuryRot = 0;

    private float mercuryTrlSpeed = GL_PI / 7;
    private float mercuryTrl = 0;


    private void updateRotations() {
        // Rotação do SOL
        sunRot += sunRotSpeed * timeElapsed();
        sunRot %= 2f * GL_PI;

        // Translação da Terra
        earthTrl += earthTrlSpeed * timeElapsed();
        earthTrl %= 2f * GL_PI;

        // Rotação da Terra/Clouds
        earthRot += earthRotSpeed * timeElapsed();
        earthRot %= 2f * GL_PI;

        // Translação da Lua
        moonTrl += moonTrlSpeed * timeElapsed();
        moonTrl %= 2f * GL_PI;

        // Rotação da Lua
        moonRot += moonRotSpeed * timeElapsed();
        moonRot %= 2f * GL_PI;

        // Translação de Mercury
        mercuryTrl += mercuryTrlSpeed * timeElapsed();
        mercuryTrl %= 2f * GL_PI;

        // Rotação de Mercury
        mercuryRot += mercuryRotSpeed * timeElapsed();
        mercuryRot %= 2f * GL_PI;
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Luz do sol (LIGHT0) no centro do sistema solar
        glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(0.0f, 0.0f, 0.0f, 1f));

        skybox.render();

        updateRotations();

        if ("earth".equals(following))
            followPlanet(EARTH_DISTANCE, earthTrl, 3f);

        if ("earth.moon".equals(following))
            followPlanet(EARTH_DISTANCE + EARTH_MOON_DISTANCE, earthTrl, 5f);

        if ("mercury".equals(following))
            followPlanet(MERCURY_DISTANCE, mercuryTrl, 1f);

        /**
         * =========== SUN ================
         */
        glPushMatrix();
        {
            glRotatef(toDegrees(sunRot), 0, 1, 0);
            sun.render();
        }
        glPopMatrix();


        /**
         * =========== EARTH ================
         */
        glPushMatrix();
        {
            // Movimento de translação
            glRotatef(toDegrees(earthTrl), 0, 1, 0);
            glTranslatef(EARTH_DISTANCE, 0, 0);

            // Movimento de rotação (terra)
            glPushMatrix();
            {
                glRotatef(toDegrees(earthRot), 0, 1, 0);
                earth.render();

                // Movimento de Translação da lua
                glRotatef(toDegrees(moonTrl), 0, 1, 0);
                glTranslatef(EARTH_MOON_DISTANCE, 0, 0);

                // Movimento de Rotação da lua
                glPushMatrix();
                {
                    glRotatef(toDegrees(moonRot), 0, 1, 0);
                    moon.render();
                }
                glPopMatrix();
            }
            glPopMatrix();

            // Movimento de rotação (nuvens)
            glPushMatrix();
            {
                glRotatef(toDegrees(-earthRot), 0, 1, 0);
                earthClouds.render();
            }
            glPopMatrix();

        }
        glPopMatrix();

        /**
         * =========== MERCURY ================
         */
        glPushMatrix();
        {
            // Movimento de translação
            glRotatef(toDegrees(mercuryTrl), 0, 1, 0);
            glTranslatef(MERCURY_DISTANCE, 0, 0);

            // Movimento de rotação (terra)
            glPushMatrix();
            {
                glRotatef(toDegrees(mercuryRot), 0, 1, 0);
                mercury.render();
            }
            glPopMatrix();
        }
        glPopMatrix();


    }

    private void followPlanet(float radius, float trl, float up) {
        earthCamera.eye = GlMath.polarToVector(radius * 1.1f, trl, 0);
        earthCamera.eye.y = up;
        Cameras.setCurrent(earthCamera);
        setupCamera();
    }

    @Override
    public void release() {

    }
}
