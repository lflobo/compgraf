package pt.ipb.esact.compgraf.aulas.a11;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.*;

import javax.vecmath.Vector3f;
import java.awt.event.KeyEvent;

public class A11_Board extends DefaultGLWindow {

    /**
     * Parametrização - algumas constantes
     */

    // Velocidade Máxima
    private static final float MAX_VELOCITY = 3.0f;

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
    Vector3f position = new Vector3f(-.5f, 0, -.5f);
    Vector3f velocity = new Vector3f(0, 0, 0);

    // Display lists
    private int boardDl;

    // Varáveis de controlo da posição dos cubos
    private float xStart = -(float) CUBES_PER_ROW / 2.0f * CUBE_SIZE;
    private float zStart = xStart;

    // Linha e colunas atuais (controladas pelas teclas)
    private int currentRow = CUBES_PER_ROW / 2;
    private int currentCol = CUBES_PER_ROW / 2;

    // Flag que determina se a esfera está no centro do cubo
    private boolean arrived = true;
    private Shader diffuseShader;

    // skybox
    public A11_Board() {
        super("A11 Board", true);
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
        configureModels();
        configureMaterials();
        configureShaders();

        // Criar display lists
        createBoardList();
    }

    private void configureShaders() {
        diffuseShader = new Shader();
        diffuseShader.load("assets/shaders/diffuse.vert", "assets/shaders/diffuse.frag");
        diffuseShader.bind();
    }


    private void createBoardList() {
        boardDl = glGenLists(1);
        glNewList(boardDl, GL_COMPILE);

        glPushAttrib(GL_ENABLE_BIT | GL_CURRENT_BIT);
        glEnable(GL_TEXTURE_2D);

        for (int row = 0; row < CUBES_PER_ROW; row++) {
            for (int col = 0; col < CUBES_PER_ROW; col++) {
                float x = xStart + (float) row * CUBE_SIZE;
                float z = zStart + (float) col * CUBE_SIZE;
                glPushMatrix();
                {
                    glTranslatef(x, 0.0f, z);
                    cube.render();
                }
                glPopMatrix();
            }
        }

        glPopAttrib();

        glEndList();
    }

    private void configureMaterials() {
        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
    }

    private void configureModels() {
        cube = new ObjLoader(this);
        cube.load("assets/models/cube/cube.obj", "assets/models/cube/cube.mtl");
        sphere = new ObjLoader(this);
        sphere.load("assets/models/sphere/sphere.obj", "assets/models/sphere/sphere.mtl");
    }

    private void configureLighting() {
        // Ativar a Lighting globalmente
        glEnable(GL_LIGHTING);

        // Definição do Modelo de luz para a luz ambiente
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));

        // Configurar uma point light
        glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(.5f, .5f, .5f, 1));
        glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(1, 1, 1, 1));
        glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(1, 1, 1, 1));
        glEnable(GL_LIGHT0);

        // Configurar uma spot light
        glLightfv(GL_LIGHT1, GL_AMBIENT, newFloatBuffer(.1f, .1f, .1f, 1));
        glLightfv(GL_LIGHT1, GL_DIFFUSE, newFloatBuffer(1, 1, 1, 1));
        glLightfv(GL_LIGHT1, GL_SPECULAR, newFloatBuffer(1, 1, 1, 1));
        glLightf(GL_LIGHT1, GL_SPOT_CUTOFF, 45.0f);
        glLightf(GL_LIGHT1, GL_SPOT_EXPONENT, 0.1f);
        glEnable(GL_LIGHT1);
    }

    @Override
    public void release() {
        // Libertar recursos
        diffuseShader.release();
    }

    @Override
    protected void onKeyUp(KeyEvent e) {
        if (e.getKeyChar() == 'w') forward();
        if (e.getKeyChar() == 's') backward();

        if (e.getKeyChar() == 'a') left();
        if (e.getKeyChar() == 'd') right();
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Posicionar as luzes e ajustar a direção do SPOT
        glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-.5f, 20.0f, -.5f, 1f));
        glLightfv(GL_LIGHT1, GL_POSITION, newFloatBuffer(-.5f, 5.0f, -.5f, 1f));
        glLightfv(GL_LIGHT1, GL_SPOT_DIRECTION, newFloatBuffer(0, -1, 0));

        updateMovement();
        updateCamera();

        glCallList(boardDl);

        glPushMatrix();
        {
            glTranslatef(position.x, position.y, position.z);
            sphere.render();
        }
        glPopMatrix();

        renderText("row: " + currentRow + ", col: " + currentCol, 10, 20);
        renderText("arrived: " + arrived, 10, 30);
        renderText("position: " + position, 10, 40);
    }

    private void updateCamera() {
        Cameras.getCurrent().at = new Vector3f(position);

    }

    private void move(int rows, int cols) {
        // Não permitir mais movimento - previne diagonais
        if(!arrived)
            return;

        int targetRow = currentRow + rows;
        if(targetRow >= 0 && targetRow < CUBES_PER_ROW)
            currentRow += rows;

        int targetCol = currentCol + cols;
        if(targetCol >= 0 && targetCol < CUBES_PER_ROW)
            currentCol += cols;
    }

    void forward() {
        move(-1, 0);
    }

    void backward() {
        move(1, 0);
    }

    void left() {
        move(0, -1);
    }

    void right() {
        move(0, 1);
    }

    private void updateMovement() {
        // Calcular o target com base na row/col atuais
        float z = zStart + (float) currentRow * CUBE_SIZE;
        float x = xStart + (float) currentCol * CUBE_SIZE;
        Vector3f target = new Vector3f(x, 0, z);

        // A distancia é o vetor entre postition <-> target
        Vector3f distance = new Vector3f();
        distance.sub(target, position);

        // Quando a distância é nula, não há movimento
        if (distance.length() == 0)
            return;

        // Quando a distância é menor que a margem chegámos!
        arrived = distance.length() < ARRIVE_MARGIN;

        // Se já chegámos...
        if (arrived) {
            // Parar!
            velocity.set(0, 0, 0);

            // Snap ao centro do cubo
            position = target;

            // Tocar um som ao chegar
            MediaPlayer.playSound("assets/audio/pop.wav");
        } else {
            // Velocidade é o vetor distância afetado da velocidade máxima
            velocity.set(distance);

            // Queremos apenas a direção -> normalize()
            velocity.normalize();

            // Forçamos o vetor a ter o "tamanho" da MAX_VELOCITY
            velocity.scale(MAX_VELOCITY * timeElapsed());

            // "andamos" no sentido da velocidade
            position.add(velocity);
        }
    }

    @Override
    public void resize(int width, int height) {
        // Perspective
        setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
        Cameras.setCurrent(new Camera(0, 5, 5));

        // Ortho
        /*
        setProjectionOrtho(width, height, 10.0f, 0.001f, 500.0f);
        Cameras.setCurrent(new Camera(5, 5, 5));
        */


        setupCamera();
    }

    // Função main confere capacidade de executável ao .java atual
    public static void main(String[] args) {
        new A11_Board();
    }

}
