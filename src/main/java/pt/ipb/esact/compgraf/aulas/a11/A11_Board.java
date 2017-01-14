package pt.ipb.esact.compgraf.aulas.a11;

import pt.ipb.esact.compgraf.engine.light.Light;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.*;
import pt.ipb.esact.compgraf.tools.math.Vectors;

import javax.vecmath.Vector2f;
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
    private static final int CUBES_PER_ROW = 33;

    private Vector2f[] obstaculos = new Vector2f[]{
            new Vector2f(1, 1),
            new Vector2f(1, 2),
            new Vector2f(1, 3),
            new Vector2f(2, 3),
            new Vector2f(4, 4),
            new Vector2f(7, 2),
            new Vector2f(7, 3),
            new Vector2f(6, 3),
            new Vector2f(5, 3),
            new Vector2f(4, 3),
    };

    /**
     * Fim da parametrização
     */

    // .obj loaders
    private ObjLoader cube;

    private ObjLoader sphere;

    // Vetores de movimento
    private Vector3f position;

    private Vector3f velocity = new Vector3f(0, 0, 0);

    // Varáveis de controlo da posição dos cubos
    // Varáveis de controlo da posição dos cubos
    private float xStart = -(float) CUBES_PER_ROW / 2.0f * CUBE_SIZE;
    private float zStart = xStart;

    // Linha e colunas atuais (controladas pelas teclas)
    private int currentRow = 0;
    private int currentCol = 0;

    // Flag que determina se a esfera está no centro do cubo
    private boolean arrived = true;

    private Shader diffuseShader;

    private Light light;

    // skybox
    private A11_Board() {
        super("A11 Board", true);
        setMousePan(true);

        // posicao inicial do character
        position = rowColVector(currentRow, currentCol);

        // camera
        Cameras.setCurrent(new Camera(0, 3, 3));
    }

    private Vector3f rowColVector(int row, int col) {
        float x = xStart + (float) col * CUBE_SIZE;
        float z = zStart + (float) row * CUBE_SIZE;
        return new Vector3f(x, 0, z);
    }

    @Override
    public void init() {
        // Definir a cor de background (RGBA={0, 0, 0, 255})
        glClearColor(0.0f, 0.0f, 0.0f, 1f);

        // Activar o teste de profundidade
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_MULTISAMPLE);
        glEnable(GL_CULL_FACE);
        glEnable(GL_TEXTURE_2D);
        glCullFace(GL_BACK);

        configureLighting();
        configureModels();
        configureMaterials();
        configureShaders();
    }

    private void configureShaders() {
        diffuseShader = new Shader();
        diffuseShader.load("assets/shaders/diffuse.vert", "assets/shaders/diffuse.frag");
        diffuseShader.bind();
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
        light = new Light(GL_LIGHT0);
        light.setAmbient(.5f, .5f, .5f);
        light.setDiffuse(1, 1, 1);
        light.setSpecular(1, 1, 1);

    }

    @Override
    public void release() {
        // Libertar recursos
        diffuseShader.release();
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        updateMovement();
        updateCamera();

        // Posicionar as luzes e ajustar a direção do SPOT
        light.setPosition(position.x, 10.0f, position.z);
        light.position();

        drawBoard();

        glPushMatrix();
        {
            glTranslatef(position.x, position.y, position.z);
            sphere.render();
        }
        glPopMatrix();

        renderText("row: " + currentRow + ", col: " + currentCol, 10, 20);
        renderText("arrived: " + arrived, 10, 40);
        renderText("position: " + position, 10, 60);

        if (isKeyPressed('w')) forward();
        if (isKeyPressed('s')) backward();

        if (isKeyPressed('a')) left();
        if (isKeyPressed('d')) right();
    }

    private void updateCamera() {
        // Olhar para o personagem (sphere)
        Camera camera = Cameras.getCurrent();

        // Calcular a diferença gerada pelo movimento
        Vector3f movement = Vectors.sub(position, camera.at);

        // Adicionar esse movimento à posição da camera (eye)
        camera.eye.add(movement);

        // "Olhar" para a nova posição
        camera.at = new Vector3f(position);

        // Atualizar a projeção
        setupCamera();
    }

    private void move(int rows, int cols) {
        // Não permitir mais movimento - apenas uma ordem de movimento de cada vez
        if (!arrived)
            return;

        int targetRow = currentRow + rows;
        int targetCol = currentCol + cols;

        // verificar obstaculos
        for (int o = 0; o < obstaculos.length; o++) {
            Vector2f obstaculo = obstaculos[o];
            if (targetCol == obstaculo.x && targetRow == obstaculo.y) {
                MediaPlayer.getInstance().play("assets/audio/laugh.mp3");
                return;
            }
        }

        if (targetRow >= 0 && targetRow < CUBES_PER_ROW)
            currentRow += rows;

        if (targetCol >= 0 && targetCol < CUBES_PER_ROW)
            currentCol += cols;
    }

    private void forward() {
        move(-1, 0);
    }

    private void backward() {
        move(1, 0);
    }

    private void left() {
        move(0, -1);
    }

    private void right() {
        move(0, 1);
    }

    private void updateMovement() {
        // Calcular o target com base na row/col atuais
        Vector3f target = rowColVector(currentRow, currentCol);

        // A distancia é o vetor entre postition <-> target
        Vector3f distance = Vectors.sub(target, position);

        // Quando a distância é nula, não há movimento
        float distanceSquared = distance.lengthSquared();
        if (distanceSquared == 0)
            return;

        // Quando a distância é menor que a margem chegámos!
        arrived = distanceSquared < ARRIVE_MARGIN * ARRIVE_MARGIN;

        // Se já chegámos...
        if (arrived) {
            // Parar!
            velocity.set(0, 0, 0);

            // Snap ao centro do cubo
            position = target;

            // Tocar um som ao chegar
            MediaPlayer.getInstance().play("assets/audio/pop.mp3");
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

    private void drawBoard() {
        for (int row = 0; row < CUBES_PER_ROW; row++) {
            for (int col = 0; col < CUBES_PER_ROW; col++) {
                Vector3f p = rowColVector(row, col);
                glPushMatrix();
                {
                    glTranslatef(p.x, p.y, p.z);
                    cube.render();
                }
                glPopMatrix();
            }
        }

        for (int o = 0; o < obstaculos.length; o++) {
            glPushMatrix();
            {
                Vector2f obstaculo = obstaculos[o];
                Vector3f p = rowColVector((int) obstaculo.y, (int) obstaculo.x);
                glTranslatef(p.x, CUBE_SIZE, p.z);
                cube.render();
            }
            glPopMatrix();
        }
    }

    @Override
    public void resize(int width, int height) {
        // Perspective
        setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);

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
