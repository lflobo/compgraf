package pt.ipb.esact.compgraf.aulas.examples;

import javazoom.jl.player.Player;
import pt.ipb.esact.compgraf.engine.light.Light;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.MediaPlayer;

import java.awt.event.KeyEvent;

public class AudioStartStop extends DefaultGLWindow {

    private ObjLoader wheatley;

    private Light light;

    public AudioStartStop() {
        super("Audio Start Stop", true);
        setMousePan(true);
        setMouseZoom(true);
        Cameras.setCurrent(new Camera(0, 1, 1));
    }

    public static void main(String[] args) {
        new AudioStartStop();
    }

    @Override
    public void init() {
        glClearColor(0.0f, 0.0f, 0.0f, 1f);

        // Activar o teste de profundidade
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_MULTISAMPLE);
        glEnable(GL_CULL_FACE);
        glEnable(GL_TEXTURE_2D);
        glCullFace(GL_BACK);

        // Ativar a Lighting globalmente
        glEnable(GL_LIGHTING);

        // Definição do Modelo de luz para a luz ambiente
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));

        // Configurar uma point light
        light = new Light(GL_LIGHT0);
        light.setAmbient(.5f, .5f, .5f);
        light.setDiffuse(1, 1, 1);
        light.setSpecular(1, 1, 1);

        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);

        wheatley = new ObjLoader(this);
        wheatley.setScale(0.5f);
        wheatley.load("assets/models/wheatley/wheatley.obj", "assets/models/wheatley/wheatley.mtl");
    }


    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
        setupCamera();
    }

    Player player;

    @Override
    protected void onKeyUp(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'p': {
                if (player != null)
                    player.close();
                player = MediaPlayer.getInstance().play("assets/audio/elevator-music.mp3");
            }
            break;
            case 's': {
                if (player != null)
                    player.close();
            }
            break;
        }
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        light.position();

        glColor3f(1, 1, 1);
        wheatley.render();

        renderText("Press 'p' to play", 10, 20);
        renderText("Press 's' to stop", 10, 30);
    }

    @Override
    public void release() {

    }
}
