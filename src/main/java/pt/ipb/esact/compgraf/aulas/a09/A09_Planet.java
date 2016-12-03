package pt.ipb.esact.compgraf.aulas.a09;

import javax.vecmath.Vector4f;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import java.util.ArrayList;
import java.util.List;

public class A09_Planet extends DefaultGLWindow {

    /**
     * Variáveis de controlo do planeta / asteróides
     */
    private float pRot = 0.0f; // planeta
    private float cRot = 0.0f; // nuvens
    private float mTrl = 0.0f; // moon (translacao)
    private float aRot = 0.0f; // asteroids

    // Objeto que desenha uma skybox (inicializada no construtor)
    private Skybox skybox;

    private ObjLoader earth;

    private List<Vector4f> asteroidPositions;

    private ObjLoader earthClouds;

    private ObjLoader asteroid;

    private ObjLoader moon;

    private A09_Planet() {
        super("A09 Planet", true);
        setMousePan(true);
        setMouseZoom(true);
    }


    private List<Vector4f> prepareAsteroidBelt(int count, float radius, float thickness, float sizeMin, float sizeMax) {
        List<Vector4f> vectors = new ArrayList<Vector4f>();

        // Para cada asteroide gerar posicao/angulo aleatorio dentro de um disco
        for (int i = 0; i < count; i++) {
            float distance = radius + randomBinomial(thickness);
            float alpha = randomBinomial(2.0f * GL_PI);
            float aradius = sizeMin + random(sizeMax - sizeMin);
            float gray = 0.5f + randomBinomial(0.25f);
            glColor3f(gray, gray, gray);
            glPushMatrix();

            vectors.add(new Vector4f(distance * sinf(alpha), 0.0f, distance * cosf(alpha), aradius));

            glPopMatrix();
        }

        return vectors;
    }

    @Override
    public void init() {
        // Definir a cor de background (RGBA={0, 0, 0, 255})
        glClearColor(0.0f, 0.0f, 0.0f, 1f);

        // Activar o teste de profundidade
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_MULTISAMPLE);
        glEnable(GL_CULL_FACE);

        // Não calcular texturas/material para a parte de trás
        glCullFace(GL_BACK);

        // Configurar as luzes
        configureLighting();

        // Configurar os materiais
        configureMaterials();

        // Carregar objectos
        configureObjects();

        // carregar as texturas da skybox
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

    private void configureObjects() {
        earth = new ObjLoader(this);
        earth.load("assets/models/planets/earth.obj", "assets/models/planets/earth.mtl");

        moon = new ObjLoader(this);
        moon.setScale(0.27f);
        moon.load("assets/models/moon/moon.obj", "assets/models/moon/moon.mtl");

        earthClouds = new ObjLoader(this);
        earthClouds.load("assets/models/planets/earth-clouds.obj", "assets/models/planets/earth-clouds.mtl");

        asteroid = new ObjLoader(this);
        asteroid.load("assets/models/planets/asteroid1.obj", "assets/models/planets/asteroid1.mtl");

        asteroidPositions = prepareAsteroidBelt(500, 3.5f, 0.3f, 0.001f, 0.01f);
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
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));

        // Configurar e Activar a Luz 0
        glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));        // Componente ambiente
        glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.4f, 0.4f, 0.4f, 1.0f));        // Componente difusa
        glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));        // Componente especular

        // Activação da luz 0
        glEnable(GL_LIGHT0);

        // Secondary Color
        glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);
    }


    @Override
    public void release() {
        // Libertar recursos (GPU)
        earth.release();
        moon.release();
        earthClouds.release();
        asteroid.release();
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Reposicionar a luz
        glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-10.0f, 20.0f, -10.0f, 1.0f));

        // Desenhar primeiro a skybox
        skybox.render();

        // Desenhar os restantes objetos
        drawPlanetMoon();
        drawAsteroids();

        // Mostrar FPS
        renderText("FPS: " + (int) (1 / timeElapsed()), 10, 20);
    }

    private void drawPlanetMoon() {
        float pRotSpeed = 0.05f * GL_PI;
        pRot -= pRotSpeed * timeElapsed();
        pRot %= 2.0f * GL_PI;

        float cRotSpeed = 0.15f * GL_PI;
        cRot -= cRotSpeed * timeElapsed();
        cRot %= 2.0f * GL_PI;

        float mTrlSpeed = 0.1f * GL_PI;
        mTrl -= mTrlSpeed * timeElapsed();
        mTrl %= 2.0f * GL_PI;

        float mDistance = 8.0f;

        glPushMatrix();
        {
            float pTilt = 0.05f * GL_PI;
            glRotatef(-toDegrees(pTilt), 0.0f, 0.0f, 1.0f);
            glPushMatrix();
            {
                glRotatef(-toDegrees(pRot), 0.0f, 1.0f, 0.0f);
                earth.render();
            }
            glPopMatrix();

            glPushMatrix();
            {
                glRotatef(-toDegrees(cRot), 0.0f, 1.0f, 0.0f);
                earthClouds.render();
            }
            glPopMatrix();

        }
        glPopMatrix();

        glPushMatrix();
        {
            glRotatef(-toDegrees(mTrl), 0.0f, 1.0f, 0.0f);
            glTranslatef(mDistance, 0f, 0f);
            moon.render();
        }
        glPopMatrix();

    }

    private void drawAsteroids() {
        float aRot0Speed = 0.05f * GL_PI;
        aRot += aRot0Speed * timeElapsed();
        aRot %= 2.0f * GL_PI;

        glPushMatrix();
        {
            float aTilt0 = 0.05f * GL_PI;
            glRotatef(toDegrees(aTilt0), 0.0f, 0.0f, 1.0f);
            glRotatef(toDegrees(aRot), 0.0f, 1.0f, 0.0f);
            for (Vector4f vector : asteroidPositions) {
                glPushMatrix();
                {
                    glTranslatef(vector.x, vector.y, vector.z);
                    glScalef(vector.w, vector.w, vector.w);
                    asteroid.render();
                }
                glPopMatrix();
            }
        }
        glPopMatrix();
    }

    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 100.0f, 0.001f, 2000.0f);
        Cameras.setCurrent(new Camera(0, 0.5f, 6));
        setupCamera();
    }

    // Função main confere capacidade de executável ao .java atual
    public static void main(String[] args) {
        new A09_Planet();
    }

}
