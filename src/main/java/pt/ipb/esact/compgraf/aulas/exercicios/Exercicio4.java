package pt.ipb.esact.compgraf.aulas.exercicios;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class Exercicio4 extends DefaultGLWindow {

	public Exercicio4() {
		super("Exercicio IV", true);
		setMousePan(true);
        setMouseZoom(true);
	}
	
	public static void main(String[] args) {
		new Exercicio4();
	}
	
	public void init() {
        // Definir a cor de background (RGBA={0, 0, 0, 255})
        glClearColor(0.0f, 0.0f, 0.0f, 1f);

        // Activar algumas features uteis
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);

        configureLights();
        configureMaterials();
    }

    private void configureLights() {
        // Configurar aqui a(s) luz(es)
    }

    private void configureMaterials() {
        // Configurar aqui as propriedades globais dos materiais
    }

    private void setupObjectMaterial() {
        // Configurar aqui as propriedades do material dos objetos
    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        setupObjectMaterial();
        glutSolidCube(40);
        glutSolidSphere(20.0, 130, 130);
    }

    @Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100, 0.001f, 1000);
		Camera camera = new Camera(0, 0, 60);
		Cameras.setCurrent(camera);
		setupCamera();
	}

	@Override
	public void release() {
		
	}

}
