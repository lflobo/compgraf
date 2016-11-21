package pt.ipb.esact.compgraf.aulas.a07;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class A07_ExercicioSolucao extends DefaultGLWindow {

    private ObjLoader board;
    private ObjLoader chair;
    private ObjLoader computador;
    private ObjLoader floor;
    private ObjLoader monitor;
    private ObjLoader table;
    private ObjLoader wall1;
    private ObjLoader wall2;
    private ObjLoader ceiling;


    public A07_ExercicioSolucao() {
        super("A07 Obj", true);
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

        // Configurar os materiais
        configureMaterials();

        board = new ObjLoader(this);
        board.setScale(1.5f);
        board.load(
                "assets/exercicios/aula7/models/board/Board.obj",
                "assets/exercicios/aula7/models/board/Board.mtl"
        );

        chair = new ObjLoader(this);
        chair.setScale(1.4f);
        chair.load(
                "assets/exercicios/aula7/models/chair/chair.obj",
                "assets/exercicios/aula7/models/chair/chair.mtl"
        );

        computador = new ObjLoader(this);
        computador.load(
                "assets/exercicios/aula7/models/computador/computador.obj",
                "assets/exercicios/aula7/models/computador/computador.mtl"
        );

        floor = new ObjLoader(this);
        floor.load(
                "assets/exercicios/aula7/models/floor/floor.obj",
                "assets/exercicios/aula7/models/floor/floor.mtl"
        );

        monitor = new ObjLoader(this);
        monitor.load(
                "assets/exercicios/aula7/models/monitor/monitor.obj",
                "assets/exercicios/aula7/models/monitor/monitor.mtl"
        );

        table = new ObjLoader(this);
        table.load(
                "assets/exercicios/aula7/models/table/table.obj",
                "assets/exercicios/aula7/models/table/table.mtl"
        );

        wall1 = new ObjLoader(this);
        wall1.load(
                "assets/exercicios/aula7/models/walls/wall1.obj",
                "assets/exercicios/aula7/models/walls/wall1.mtl"
        );

        wall2 = new ObjLoader(this);
        wall2.load(
                "assets/exercicios/aula7/models/walls/wall2.obj",
                "assets/exercicios/aula7/models/walls/wall2.mtl"
        );

        ceiling = new ObjLoader(this);
        ceiling.load(
                "assets/exercicios/aula7/models/walls/ceiling.obj",
                "assets/exercicios/aula7/models/walls/ceiling.mtl"
        );

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
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));

        // Configurar e Activar a Luz 0
        glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.2f, 0.2f, 0.2f, 1.0f));        // Componente ambiente
        glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.8f, 0.8f, 0.8f, 1.0f));        // Componente difusa
        glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));        // Componente especular

        // Activação da luz 0
        glEnable(GL_LIGHT0);
    }

    @Override
    public void release() {
        // Libertar as texturas (GPU)
    }

    // Variavel para a rotação do wheatley
    private float angle = 0.0f;

    void updateRotation() {
        // Actualizar o Angulo de Rotacao
        angle += GL_PI / 10.0f * timeElapsed();
        angle %= 2.0f * GL_PI;
    }


    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Reposicionar a luz
        glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(0.0f, 3.0f, 0.0f, 1.0f));

        // Cor por omissão do cenário
        glColor3f(1f, 1f, 1f);

        floor.render();

        glPushMatrix();
        {
            glTranslatef(0, 0, -4);
            wall2.render();

            glTranslatef(2, 1f, 0);
            board.render();

        }
        glPopMatrix();

        glPushMatrix();
        {
            glTranslatef(0, 0, 4);
            glRotatef(180f, 0, 1, 0);
            wall1.render();

        }
        glPopMatrix();

        glPushMatrix();
        {
            glTranslatef(-4, 0, 0);
            glRotatef(90f, 0, 1, 0);
            wall1.render();

        }
        glPopMatrix();

        glPushMatrix();
        {
            glTranslatef(4, 0, 0);
            glRotatef(-90f, 0, 1, 0);
            wall1.render();

        }
        glPopMatrix();


        glPushMatrix();
        {
            glTranslatef(-2.4f, 0, 0);
            drawDesk();
        }
        glPopMatrix();

        glPushMatrix();
        {
            glTranslatef(2.4f, 0, 0);
            drawDesk();
        }
        glPopMatrix();

        updateRotation();

    }

    private void drawDesk() {
        table.render();

        glPushMatrix();
        {
            glTranslatef(0.8f, 1.16f, 0);
            glRotatef(-15, 0, 1, 0);
            monitor.render();
        }
        glPopMatrix();

        glPushMatrix();
        {
            glTranslatef(0.0f, 1.16f, 0);
            glRotatef(toDegrees(angle), 0, 1, 0);
            computador.render();
        }
        glPopMatrix();

        glPushMatrix();
        {
            glTranslatef(0, 0, 1.5f);
            glRotatef(-180, 0, 1, 0);
            chair.render();
        }
        glPopMatrix();
    }


    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
        Cameras.setCurrent(new Camera(3, 3, 3));
        setupCamera();
    }

    // Função main confere capacidade de executável ao .java atual
    public static void main(String[] args) {
        new A07_ExercicioSolucao();
    }

}
