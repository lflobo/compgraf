package pt.ipb.esact.compgraf.aulas.a07;

import java.awt.event.KeyEvent;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class A07_Anisotropic extends DefaultGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { -10.0f, 20.0f, -10.0f, 1.0f };
	
	public A07_Anisotropic() {
		super("A07 Anisotropic", true);
		
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
			System.out.println("Anisotropic filterina não está disponível.");
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
		
		// Este é o array com o RGB da luz ambiente
		float[] ambientLight = { 0.6f, 0.6f, 0.6f, 1.0f };
		float[] ambientLowLight = { 0.5f, 0.5f, 0.5f, 1.0f };
		// Este é o array com o RGB da luz difusa
		float[] diffuseLight = { 0.4f, 0.4f, 0.4f, 1.0f };
		// Este é o array com o RGB da luz especular
		float[] specularLight = { 0.5f, 0.5f, 0.5f, 1.0f };

		// Definição do Modelo de luz para a luz ambiente
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);

		// Configurar e Activar a Luz 0
		glLightfv(GL_LIGHT0, GL_AMBIENT, ambientLight, 0);		// Componente ambiente
		glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuseLight, 0);		// Componente difusa
		glLightfv(GL_LIGHT0, GL_SPECULAR, specularLight, 0);		// Componente especular

		// Activação da luz 0
		glEnable(GL_LIGHT0);
	}
	
	// Representam as posições (identificadores) das texturas
	private int TEX_BRICK;
	
	// Array com os IDs dos texture objects ('gavetas')
	private IntBuffer textures; 
	
	private void configureTextures() {
		int textureCount = 1;
		textures = IntBuffer.allocate(textureCount);

		// Allocar as texturas
		glGenTextures(textureCount, textures);
		
		// Associar os IDs às variáveis
		TEX_BRICK = textures.get(0);
		
		// Posição 1 das texturas -> brick.png
		setupTexture("brick.png", TEX_BRICK);
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
	}

	private void setupTexture(String name, int textureId) {
//		PNGImage image = null;
//		ByteBuffer buffer = null;
//		
//		// Tentar carregar a imagem a partir do package atual
//		try(InputStream stream = getClass().getResourceAsStream(name)) {
//			image = PNGImage.read(stream);
//			buffer = image.getData();
//		} catch (Exception e) {
//			// Ocorreu um erro --> Terminar o programa
//			exit("Foi impossivel carregar a imagem '" + name + "'");
//		}
//		
//		// Fazer o bind do estado da textura ao identificador
//		glBindTexture(GL_TEXTURE_2D, textureId);
//
//		// Carregar os mipmaps para a textura
//		gluBuild2DMipmaps(GL_TEXTURE_2D, GL_RGBA, image.getWidth(), image.getHeight(), image.getGLFormat(), GL_UNSIGNED_BYTE, buffer);
//		
//		// Parametros da textura (ignorar para ja)
//		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
//		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
//		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
//		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
//
//		// Configurar a anisotropy para a nossa textura
//		if(anisotropicAvailable)
//			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAX_ANISOTROPY_EXT, currentAnisotropy);
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
			glBindTexture(GL_TEXTURE_2D, TEX_BRICK);
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAX_ANISOTROPY_EXT, currentAnisotropy);
		}
	}
	
	@Override
	public void release() {
		// Libertar as texturas (GPU)
		glDeleteTextures(textures.capacity(), textures);
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, positionLitght0, 0);
		
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
		glBindTexture(GL_TEXTURE_2D, TEX_BRICK);
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
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A07_Anisotropic();
	}

}
