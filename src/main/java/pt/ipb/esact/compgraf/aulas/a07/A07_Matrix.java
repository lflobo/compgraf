package pt.ipb.esact.compgraf.aulas.a07;

import java.awt.event.KeyEvent;
import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.math.Colors;

public class A07_Matrix extends DefaultGLWindow {
	
	// Current Matrix
	private FloatBuffer mv = FloatBuffer.allocate(16);

	public A07_Matrix() {
		super("A07 Matrix", true);
	}
	
	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		// Activar o teste de profundidade
		glEnable(GL_DEPTH_TEST);
	}

	@Override
	protected void onKeyUp(KeyEvent e) {
		float signal = e.isShiftDown() ? -0.25f : 0.25f;

		// Obter a matriz atual
		readMatrix();
		
		// lower case por causa do SHIFT
		switch(Character.toLowerCase(e.getKeyChar())) {
			// Eixo X
			case '1': case '!': incrementMatrix(0, signal); break;
			case '2': case '"': incrementMatrix(4, signal);  break;
			case '3': case '#': incrementMatrix(8, signal);  break;
			case '4': case '$': incrementMatrix(12, signal);  break;

			// Eixo Y
			case 'q': incrementMatrix(1, signal); break;
			case 'w': incrementMatrix(5, signal);  break;
			case 'e': incrementMatrix(9, signal);  break;
			case 'r': incrementMatrix(13, signal);  break;

			// Eixo Z
			case 'a': incrementMatrix(2, signal); break;
			case 's': incrementMatrix(6, signal);  break;
			case 'd': incrementMatrix(10, signal);  break;
			case 'f': incrementMatrix(14, signal);  break;

			// Translation
			case 'z': incrementMatrix(3, signal); break;
			case 'x': incrementMatrix(7, signal);  break;
			case 'c': incrementMatrix(11, signal);  break;
			case 'v': incrementMatrix(15, signal);  break;
		}
	}

	private void readMatrix() {
		glGetFloatv(GL_MODELVIEW_MATRIX, mv);
	}

	private void incrementMatrix(int index, float value) {
		mv.put(index, mv.get(index) + value);
	}

	@Override
	public void release() {
		
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		// Aplicar a matriz alterada
		glLoadMatrixf(mv);

		Colors.BLUE.set();
		glutWireTeapot(2.0);
		
		glPushMatrix();
			glTranslatef(0.0f, -2.0f, 0.0f);
			Colors.DARKGRAY.set();
			demo().drawGround(GL_LINE_STRIP, 5.0f, 30, 1.0f);
		glPopMatrix();
		
		Colors.GRAY.set();
		paintMatrix(width);
	}
	
	private void paintMatrix(int width) {
		StringBuilder builder = new StringBuilder();
		builder.append("        X       Y       Z       T\n");
		builder.append(String.format("x - %6.2f, %6.2f, %6.2f, %6.2f\n", mv.get(0), mv.get(4), mv.get(8), mv.get(12)));
		builder.append(String.format("y - %6.2f, %6.2f, %6.2f, %6.2f\n", mv.get(1), mv.get(5), mv.get(9), mv.get(13)));
		builder.append(String.format("z - %6.2f, %6.2f, %6.2f, %6.2f\n", mv.get(2), mv.get(6), mv.get(10), mv.get(14)));
		builder.append(String.format("w - %6.2f, %6.2f, %6.2f, %6.2f"  , mv.get(3), mv.get(7), mv.get(11), mv.get(15)));
		renderText(builder.toString(), 10, 20);

		StringBuilder help = new StringBuilder();
		help.append("        X  Y  Z  T\n");
		help.append(String.format("    x - 1, 2, 3, 4\n", mv.get(0), mv.get(4), mv.get(8), mv.get(12)));
		help.append(String.format("    y - q, w, e, r\n", mv.get(1), mv.get(5), mv.get(9), mv.get(13)));
		help.append(String.format("    z - a, s, d, f\n", mv.get(2), mv.get(6), mv.get(10), mv.get(14)));
		help.append(String.format("    w - z, x, c, v\n"  , mv.get(3), mv.get(7), mv.get(11), mv.get(15)));
		help.append("shift - decrementa");
		renderText(help.toString(), width - 180, 20);

	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 30.0f, 0.001f, 30.0f);
//		setProjectionOrtho(width, height, 5.0f, 0.001f, 30.0f);
		Cameras.setCurrent(new Camera(0, 0, 5));
		setupCamera();
		
		// Ler a matrix on resize
		readMatrix();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A07_Matrix();
	}

}
