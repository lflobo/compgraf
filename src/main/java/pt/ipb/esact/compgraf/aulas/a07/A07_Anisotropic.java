package pt.ipb.esact.compgraf.aulas.a07;

import java.awt.event.KeyEvent;
import java.nio.FloatBuffer;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import com.jogamp.opengl.util.texture.Texture;

public class A07_Anisotropic extends DefaultGLWindow {

	// Representam as posições (identificadores) das texturas
	private Texture TEX_BRICK;

	public A07_Anisotropic() {
		super("A07 Anisotropic", true);
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
		
		// Configurar Anisotropy (executar antes de configureTextures!!!)
		setupAnisotropy();
		
		// Configurar as texturas
		configureTextures();
	}

	// Valores min/max da anisotropy suportados pelo GPU
	private float minAnisotropy = 0.0f;
	private float maxAnisotropy = 0.0f;
	private float currentAnisotropy = 0.0f;
	private boolean anisotropicAvailable = false;
	
	private void setupAnisotropy() {
		// Verificar se a extensão está disponível
		anisotropicAvailable = isExtensionAvailable("GL_EXT_texture_filter_anisotropic");
		
		// Se não está disponível parar por aqui
		if(!anisotropicAvailable) {
			System.out.println("Anisotropic filtering não está disponível.");
			return;
		}
		
		// Obter o valor mínimo/máximo de anisotropia suportado
		FloatBuffer values = FloatBuffer.allocate(1);
		glGetFloatv(GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT, values);
		maxAnisotropy = values.get(0);
		
		System.out.println("Max anisotropy is: " + maxAnisotropy);
	}

	private void configureMaterials() {
		// Configurar Color Tracking
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);
		glMateriali(GL_FRONT, GL_SHININESS, 100);
		
		// Especularidade do material definida explicitamente
		float[] specRef = {1.0f, 1.0f, 1.0f, 1.0f};
		glMaterialfv(GL_FRONT, GL_SPECULAR, specRef, 0);
	}

	private void configureLighting() {
		// Ativar a Lighting globalmente
		glEnable(GL_LIGHTING);
		
		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));;

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, newFloatBuffer(0.6f, 0.6f, 0.6f, 1.0f));;		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, newFloatBuffer(0.4f, 0.4f, 0.4f, 1.0f));;		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer(0.5f, 0.5f, 0.5f, 1.0f));;		// Componente especular

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}
	
	
	private void configureTextures() {
		glEnable(GL_TEXTURE_2D);
		TEX_BRICK = loadPackageTexture("brick.png");
	}

	@Override
	protected void onKeyUp(KeyEvent e) {
		if(e.getKeyChar() == 'o' || e.getKeyChar() == 'p') {
			// Calcular um valor para o incremento
			float increment = (maxAnisotropy - minAnisotropy) / 10.0f;
			
			// decrementar no caso de ser 'o', incrementar no caso de ser 'p'
			currentAnisotropy += e.getKeyChar() == 'o' ? -increment : increment;
			
			// fazer o clamp do valore entre (maxAnisotropy e minAnisotropy)
			currentAnisotropy = Math.max(minAnisotropy, Math.min(maxAnisotropy, currentAnisotropy));
			
			// Definira a anisotropia para a única textura que temos
			TEX_BRICK.setTexParameterf(this, GL_TEXTURE_MAX_ANISOTROPY_EXT, currentAnisotropy);
		}
	}
	
	@Override
	public void release() {
		// Libertar as texturas (GPU)
		TEX_BRICK.destroy(this);
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-10.0f, 20.0f, -10.0f, 1.0f));
		
		glColor3f(0.5f, 0.5f, 0.5f);
		
		glPushMatrix();
			glTranslatef(-1.0f, 0.0f, 0.0f);
			glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
			drawWall();
		glPopMatrix();
		
		renderText("     Max Anisotropy: " + maxAnisotropy, 10, 20);
		renderText(" Current Anisotropy: " + currentAnisotropy, 10, 35);
		renderText("o: decrease anisotropy", width - 200, 20);
		renderText("p: increase anisotropy", width - 200, 35);
	}
	
	private void drawWall() {
		TEX_BRICK.bind(this);
		for (float z = 6f; z >= 0f; z -= 1f) {
			glBegin(GL_QUADS);
				glTexCoord2f(0f, 0f);
				glVertex3f(-1f, 0f, z);
	
				glTexCoord2f(0f, 1f);
				glVertex3f(1f, 0f, z);
	
				glTexCoord2f(1f, 1f);
				glVertex3f(1f, 0f, z - 1f);
	
				glTexCoord2f(1f, 0f);
				glVertex3f(-1f, 0f, z - 1f);
			glEnd();
		}
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 30.0f);
		Cameras.setCurrent(new Camera(0, 0, 6));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A07_Anisotropic();
	}

}
