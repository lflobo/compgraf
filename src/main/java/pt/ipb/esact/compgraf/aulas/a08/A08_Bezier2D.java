package pt.ipb.esact.compgraf.aulas.a08;

import java.nio.FloatBuffer;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class A08_Bezier2D extends SWTGLWindow {

	/**
	 * Configuração da curva de bezier
	 */
	
	// Numero de pontos de controlo
	private static final int NUM_POINTS = 4;
	
	// Cordenadas dos pontos de Controlo
	private static final FloatBuffer CONTROL_POINTS = FloatBuffer.wrap(new float[] {
		-5.0f,  0.0f, 0.0f,
		-5.0f,  5.0f, 0.0f,
		 5.0f, -5.0f, 0.0f,
		 5.0f,  0.0f, 0.0f
	});

	// Inicio da curva
	private static final float U_MIN = 0.0f;

	// Final da curva
	private static final float U_MAX = 100.0f;
	
	public A08_Bezier2D(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 0.0f;
		camera.eye.y = 0.0f;
		camera.eye.z = 6.0f;
		
		camera.at.y = 0.0f;
		
		Cameras.setCurrent(camera);
	}
	
	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_MULTISAMPLE);
		
		// Não esquecer de ativer o MAP1 VERTEX_3
		glEnable(GL_MAP1_VERTEX_3);
	}

	@Override
	public void release() {
	}
	
	// Se as linhas de controlo devem ser mostradas
	private boolean showControlLines = false;
	
	@Override
	protected void onKeyUp(KeyEvent e) {
		// Mostrar/Esconder linhas quando a tecla 'l' é premida
		if(e.keyCode == 'l')
			showControlLines = ! showControlLines;
	}
	private float bounce = 0.0f;
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		glColor3f(1.0f, 1.0f, 0.0f);
		
		// Carregar os pontos de controlo para a superfície
		glMap1f(
			GL_MAP1_VERTEX_3,	// Tipo de Dados gerados
			U_MIN,				// Valor minimo do u
			U_MAX,				// Valor maximo do u
			3,					// Distancia entre pointos no array
			NUM_POINTS,			// Numero de pontos
			CONTROL_POINTS		// Pontos de controlo
		);
		
		// Desenhar a curva de bezier
		int partitions = 100;
		glMapGrid1f(partitions, U_MIN, U_MAX);
		glEvalMesh1(GL_LINE, 0, partitions);

		// Desenhar os pontos de controlo
		if(showControlLines) {
			drawCtrlPoints();
			drawCtrlLines();
		}
		
		// Bounce do 2o e 3o ponto de controlo (coordenada X)
		bounce += GL_PI * 0.5f * timeElapsed();
		bounce %= GL_PI * 2.0f;
		CONTROL_POINTS.put(3, -5.0f + 3.0f * sinf(bounce));
		CONTROL_POINTS.put(6, 5.0f + 3.0f * cosf(bounce));
		
		glColor3f(1.0f, 1.0f, 1.0f);
		renderText("tecla 'l' -> mostrar/esconder linhas de controlo", 10, 20);
	}
	
	private void drawCtrlPoints() {
		glColor3f(0.3f, 0.0f, 0.0f);
		for(int i=0; i<NUM_POINTS * 3; i += 3) {
			float x = CONTROL_POINTS.get(i), y = CONTROL_POINTS.get(i+1), z = CONTROL_POINTS.get(i+2);
			glPushMatrix();
				glTranslatef(x, y, z);
				glutSolidSphere(0.1, 10, 10);
			glPopMatrix();
		}
	}

	private void drawCtrlLines() {
		glColor3f(0.7f, 0.7f, 0.7f);
		glBegin(GL_LINE_STRIP);
		for(int i=0; i<NUM_POINTS * 3; i += 3) {
			float x = CONTROL_POINTS.get(i), y = CONTROL_POINTS.get(i+1), z = CONTROL_POINTS.get(i+2);
			glVertex3f(x, y, z);
		}
		glEnd();
	}
	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 50.0f, 0.001f, 30.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A08 Bezier 2D");
		display.start(new A08_Bezier2D(display.getShell()));
	}

}
