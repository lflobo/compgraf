package pt.ipb.esact.compgraf.aulas.a06;

import com.jogamp.opengl.util.texture.Texture;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.math.GLPrimitives;

import java.awt.event.KeyEvent;

public class A06_SecondaryColor extends DefaultGLWindow {

    // Variaveis das rotações dos objetos
    private float earthRot = 0.0f;

    // Texturas do exemplo
    private Texture texEarth;

    public A06_SecondaryColor() {
        super("A06 Secondary Color", true);
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

        // Configurar as luzes
        configureLighting();

        // Configurar os materiais
        configureMaterials();

        // Configurar as texturas
        configureTextures();
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
        glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));
        // Componente ambiente
        glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.8f, 0.8f, 0.0f, 1.0f));
        // Componente difusa
        glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));
        // Componente especular

        // Activação da luz 0
        glEnable(GL_LIGHT0);
    }

    private void configureTextures() {
        // Setup das texturas
        texEarth = loadTexture("assets/tex/earth.png");

        // Activar as texturas
        glEnable(GL_TEXTURE_2D);

        // Activar separate color por omissão
        glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);
    }

    @Override
    protected void onKeyUp(KeyEvent e) {
    }

    @Override
    public void release() {
        // Libertar as texturas (GPU)
        texEarth.destroy(this);
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Reposicionar a luz
        glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-2.0f, 0.0f, 10.0f, 1.0f));


        // Desenhar a Terra
        desenharTerra();

        // se premirmos 's' desativar o separate color
        if (isKeyPressed('s')) {
            glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);
        }

        if (isKeyPressed('d')) {
            glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SINGLE_COLOR);
        }
    }

    private void desenharTerra() {
        // Cor do material é cinza
        glColor3f(0.8f, 0.8f, 0.8f);

        // Bind da textura
        texEarth.bind(this);

        // Aplicar Transformações e Desenhar
        glPushMatrix();
        {
            glRotatef(90.0f, -1.0f, 0.0f, 0.0f);

            /**
             * Aplicar a rotação da terra
             * @note: Por causa do rotate 90º em -X -> o eixo vertical é agora o Z
             */
            glRotatef(toDegrees(earthRot), 0.0f, 0.0f, 1.0f);

            glScalef(1.0f, 1.0f, 0.8f); // Achatar ligeiramente os polos
            GLPrimitives.drawSphere(1.0f, 100, 100);
        }
        glPopMatrix();

        // Rotação
        earthRot += 0.1f * GL_PI * timeElapsed(); // 18 deg por segundo
        earthRot %= 2.0f * GL_PI; // garantir que não passamos de 2PI
    }

    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 100.0f, 0.001f, 300.0f);
        Cameras.setCurrent(new Camera(0, 0, 2));
        setupCamera();
    }

    // Função main confere capacidade de executável ao .java atual
    public static void main(String[] args) {
        new A06_SecondaryColor();
    }

}
