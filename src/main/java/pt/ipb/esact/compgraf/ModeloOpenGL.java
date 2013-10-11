package pt.ipb.esact.compgraf;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilitiesImmutable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 * A classe Modelo contém a estrutura modelo para os exercícios em Java
 * recorrendo à API JOGL (http://www.jogamp.org/). Trata-se de uma classe
 * 'executável' pela existência do método 'main'.
 * 
 * O Método 'void main(String[] args)' é executado pela Java VM quando é feito o
 * run do projecto. Como tal qualquer inicialização (não OpenGL) deverá ser
 * realizada neste método.
 * 
 * A classe ModeloOpenGL A classe JFrame faz parte da API gráfica Java Swing que
 * permite criar aplicações gráficas em Java. Representa uma janela.
 */
@SuppressWarnings("serial")
public class ModeloOpenGL extends JFrame
/*
 * Ao implementar a GLEventListener, a nossa classe segue as especificações
 * necessárias para o funcionamento com a API OpenGL
 */
implements GLEventListener {

	private GLU glu = new GLU();
	private GLUT glut = new GLUT();

	/**
	 * A classe GLCanvas contém o "pano de fundo" onde vamos pintar OpenGL
	 */
	private GLCanvas canvas;
	
	/**
	 * Loop OpenGL que faz o update do canvas
	 */
	FPSAnimator animator;
	
	/**
	 * Método executado pela Java VM
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ModeloOpenGL();
	}

	public ModeloOpenGL() {
		/* Inicializar a Janela */
		super("Modelo OpenGL");
		
		String xpto = "aaa";
		
		System.out.println(xpto);

		/* Ao fecharmos a Janela, o nosso programa fará um System.exit(..) */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* O tamanho inicial da Janela será 300x300 */
		setSize(300, 300);

		/* Para já a nossa janela terá nela apenas o canvas */
		canvas = new GLCanvas();
		add(canvas);
		
		/**
		 * Os métodos init, dispose, display e reshape que o OpenGL precisa para
		 * funcional estarão na instância deste object (daí o implements GLEventListener)
		 */
		canvas.addGLEventListener(this);
		
		/* Mostrar a Nossa Janela */
		setVisible(true);

		// O FPSAnimator está encarregue de refrescar a cena OpenGL
		// neste caso a cena será refrescada 25 x por segundo
		animator = new FPSAnimator(canvas, 25);
		animator.start();
	}

	/**
	 * Este método será invocado imediatamente depois de o contexto OpenGL ser
	 * inicializado. Normalmente é utilizado para inicializar a nossa cena, tal
	 * como configurar luzes.
	 */
	@Override
	public void init(GLAutoDrawable drawable) {
		// Ignorar para já...
		GLCapabilitiesImmutable cap = canvas.getChosenGLCapabilities();
		// cap.setDoubleBuffered(false);
		
		// Obter a instância actual da API OpenGL
		GL2 gl = drawable.getGL().getGL2();
		
		// Definir a cor de background (RGBA={0, 0, 0, 255})
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1f);
		
		// Activar o teste de profundidade (ignorar para já)
		gl.glEnable(GL2.GL_DEPTH_TEST);
	}

	/**
	 * Este método é invocado aquando da libertação de recursos no contexto
	 * OpenGL. A chamada tem lugar imediatamente antes de o contexto OpenGL ser
	 * destruído.
	 */
	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	/**
	 * Invocado pelo contexto OpenGL para inicializar o processo de rendering.
	 * No caso de double buffering, a chamada a este método troca
	 * automáticamente os buffers.
	 */
	@Override
	public void display(GLAutoDrawable drawable) {
		/**
		 * Aqui é onde vamos fazer a maior parte dos desenhos em OpenGL.
		 * 
		 * A titulo exemplificativo, o código em baixo desenha um triangulo tombado sobre os 3 eixos.
		 */
		
		// Obter a instância actual da API OpenGL
		GL2 gl = drawable.getGL().getGL2();
		
		// Limpar os buffers de cor e profundidade
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		
		// A cor da 'caneta' será cinza (RGBA={128, 128, 128, 255})
		gl.glColor4f(1f, 0f, 0f, 1f);
		
		// Descomentar para desenhar os eixos (x, y, z)
		// GlUtil.drawUnitArrows(glu, gl, 0, 0, 0, 100f);
		
		// Guardar o estado actual das transformações
		gl.glPushMatrix();
		
		// Efectuar transformações para o desenho
		gl.glScalef(1f, 1f, 3f);
		// Desenhar o Cubo
		glut.glutSolidCube(50f);

		// Restaurar o estado das transformações (anteriormente guardado)
		gl.glPopMatrix();

		// Enviar os comandos para o passo seguite do Pipeline
		gl.glFlush();
		
	}

	/**
	 * Chamada sempre que a janela (ou componente) contendo o viewport, são
	 * redimensionados. Permite a actualização e ajuste do viewport ou da
	 * visualização em geral, de forma a adequá-lo ao novo tamanho da janela.
	 */
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();

		if (height == 0)
			height = 1; // prevnir divisão por 0

		// O meu viewport terá o tamanho da janela (width x height)
		gl.glViewport(0, 0, width, height);

		// Mudar para a matiz de PROJECTION
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		float volume = 100f;
		float fAspect = (float) width / (float) height;
		
		// Projecção em Perspectiva
		glu.gluPerspective(100f, fAspect, 1.0f, volume * 2f);
		
		// Projecção Ortogonal
		// if(width <= height) 
		// 	gl.glOrtho(-volume, volume, -volume, volume / fAspect, volume * 5f, -volume * 5f);
		// else
		// 	gl.glOrtho(-volume * fAspect, volume * fAspect, -volume, volume, volume * 5f, -volume * 5f);
		
		// Mudar para a matriz de MODELVIEW
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		glu.gluLookAt(
			50f, 10f, 120.0f,			// Ponto onde está o meu olho
			0f, 0f, 0f,					// Para onde estou a olhar
			0f, 1f, 0f);				// Vector que define a orientação vertical
		
	}


}