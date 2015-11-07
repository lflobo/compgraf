package pt.ipb.esact.compgraf.aulas.a06;

import pt.ipb.esact.compgraf.engine.Skybox;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class A06_Skybox extends DefaultGLWindow {

    private Skybox skybox;

    public A06_Skybox() {
        super("A06 Skybox", true);
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

        skybox = new Skybox(this);
        skybox.load(
                "assets/skyboxes/planet1/px.png",
                "assets/skyboxes/planet1/py.png",
                "assets/skyboxes/planet1/pz.png",
                "assets/skyboxes/planet1/nx.png",
                "assets/skyboxes/planet1/ny.png",
                "assets/skyboxes/planet1/nz.png"
        );

        glEnable(GL_TEXTURE_2D);
    }

    @Override
    public void resize(int width, int height) {
        setProjectionPerspective(width, height, 100.0f, 0.001f, 300.0f);
        Camera camera = new Camera(0, 0, 1);
        Cameras.setCurrent(camera);
        setupCamera();
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        skybox.render();
    }

    @Override
    public void release() {

    }

    public static void main(String[] args) {
        new A06_Skybox();
    }
}
