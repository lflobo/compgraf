package pt.ipb.esact.compgraf;

import javax.media.opengl.GL;

import pt.ipb.esact.compgraf.tools.SWTGLWindow;

import com.jogamp.opengl.util.FPSAnimator;

public class ModeloOpenGL extends SWTGLWindow {

	FPSAnimator animator;
	
	public static void main(String[] args) {
		new ModeloOpenGL();
	}

	public ModeloOpenGL() {
		super("Modelo OpenGL", true);
	}
	
	@Override
	public void init() {
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade (ignorar para já)
		glEnable(GL_DEPTH_TEST);
	}

	@Override
	public void dispose() {
		// Libertar recursos
	}

	@Override
	public void render(int width, int height) {
		// Limpar os buffers de cor e profundidade
		glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		
		// A cor da 'caneta' será cinza (RGBA={128, 128, 128, 255})
		glColor4f(1f, 0f, 0f, 1f);
		
		// Guardar o estado actual das transformações
		glPushMatrix();
		
			// Efectuar transformações para o desenho
			glScalef(1f, 1f, 3f);
	
			// Desenhar o Cubo
			glutWireCube(50f);

		glPopMatrix();
	}

	@Override
	public void resize(int width, int height) {
		if (height == 0)
			height = 1; // prevnir divisão por 0

		// O meu viewport terá o tamanho da janela (width x height)
		glViewport(0, 0, width, height);

		// Mudar para a matiz de PROJECTION
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		
		float volume = 100f;
		float fAspect = (float) width / (float) height;
		
		// Projecção em Perspectiva
		// gluPerspective(100f, fAspect, 1.0f, volume * 2f);
		
		// Projecção Ortogonal
		 if(width <= height) 
		 	glOrtho(-volume, volume, -volume, volume / fAspect, volume * 5f, -volume * 5f);
		 else
		 	glOrtho(-volume * fAspect, volume * fAspect, -volume, volume, volume * 5f, -volume * 5f);
		
		// Mudar para a matriz de MODELVIEW
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		gluLookAt(
			50f, 10f, 120.0f,			// Ponto onde está o meu olho
			0f, 0f, 0f,					// Para onde estou a olhar
			0f, 1f, 0f);				// Vector que define a orientação vertical
		
	}


}