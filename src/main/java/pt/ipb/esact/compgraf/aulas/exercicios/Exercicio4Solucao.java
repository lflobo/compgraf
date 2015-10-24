package pt.ipb.esact.compgraf.aulas.exercicios;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class Exercicio4Solucao extends DefaultGLWindow {

	public Exercicio4Solucao() {
		super("Exercicio IV", true);
		setMousePan(true);
        setMouseZoom(true);
	}
	
	public static void main(String[] args) {
		new Exercicio4Solucao();
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
        // Configurar aqui as propriedades globais dos materiais
        glEnable(GL_LIGHTING);

        // Definição do Modelo de luz para a luz ambiente
        glLightModelfv(GL_LIGHT_MODEL_AMBIENT,
                newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));

        // Configurar e Activar a Luz 0
        glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));		// Componente ambiente
        glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.4f, 0.4f, 0.4f, 1.0f));		// Componente difusa
        glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));		// Componente especular
        glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(0.0f, 50.0f, 50.0f, 1.0f));	// Posição da Luz0

        // Activação da luz 0
        glEnable(GL_LIGHT0);
    }

    private void configureMaterials() {
        // Configurar aqui as propriedades do material do avião
        // Usar a cor em cima com cor do material
        glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE,
                newFloatBuffer(0.0f, 0.5f, 1.0f, 1.0f));
        glMateriali(GL_FRONT, GL_SHININESS, 64);
    }

    private void setupObjectMaterial() {
        // Definir a especularidade do material
        glMaterialfv(GL_FRONT, GL_SPECULAR,
                newFloatBuffer(1.0f, 1.0f, 1.0f, 1.0f));

    }

    @Override
    public void render(int width, int height) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        setupObjectMaterial();

        glPushMatrix();
            glTranslatef(20, 0, 0);
            glutSolidCube(40);
        glPopMatrix();

        glPushMatrix();
            glTranslatef(-20, 0, 0);
            glutSolidSphere(20.0, 130, 130);
        glPopMatrix();
    }

    @Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100, 0.001f, 1000);
		Camera camera = new Camera(0, 30, 60);
		Cameras.setCurrent(camera);
		setupCamera();
	}

	@Override
	public void release() {
		
	}

}
