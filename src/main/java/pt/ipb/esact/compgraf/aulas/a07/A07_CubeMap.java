package pt.ipb.esact.compgraf.aulas.a07;

import java.nio.IntBuffer;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.GLDisplay;
import pt.ipb.esact.compgraf.tools.SWTGLWindow;

public class A07_CubeMap extends SWTGLWindow {

	// Array com a posição da luz
	float[] positionLitght0 = { -40.0f, 10.0f, -100.0f, 1.0f };

	public A07_CubeMap(Composite parent) {
		super(parent, true);
		
		setMousePan(true);
		setMouseZoom(true);
		
		Camera camera = new Camera();
		camera.eye.x = 4.0f;
		camera.eye.y = 4.0f;
		camera.eye.z = 4.0f;
		
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
		
		// Configurar as texturas
		configureTextures();
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
		float[] diffuseLight = { 0.8f, 0.8f, 0.0f, 1.0f };
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
	private int TEX_POSITIVE_X;
	private int TEX_POSITIVE_Y;
	private int TEX_POSITIVE_Z;
	private int TEX_NEGATIVE_X;
	private int TEX_NEGATIVE_Y;
	private int TEX_NEGATIVE_Z;
	private int TEX_FLOOR;
	
	// Array com os IDs dos texture objects ('gavetas')
	private IntBuffer textures; 
	
	private void configureTextures() {
		int textureCount = 7;
		textures = IntBuffer.allocate(textureCount);

		// Allocar as texturas
		glGenTextures(textureCount, textures);
		
		// Associar os IDs às variáveis
		TEX_POSITIVE_X = textures.get(0);
		TEX_POSITIVE_Y = textures.get(1);
		TEX_POSITIVE_Z = textures.get(2);
		TEX_NEGATIVE_X = textures.get(3);
		TEX_NEGATIVE_Y = textures.get(4);
		TEX_NEGATIVE_Z = textures.get(5);
		TEX_FLOOR = textures.get(6);
		
		// Setup das texturas
		loadPackageTexture("skybox/dd-px.png", TEX_POSITIVE_X);
		loadPackageTexture("skybox/dd-py.png", TEX_POSITIVE_Y);
		loadPackageTexture("skybox/dd-pz.png", TEX_POSITIVE_Z);
		loadPackageTexture("skybox/dd-nx.png", TEX_NEGATIVE_X);
		loadPackageTexture("skybox/dd-ny.png", TEX_NEGATIVE_Y);
		loadPackageTexture("skybox/dd-nz.png", TEX_NEGATIVE_Z);
		loadPackageTexture("stone.png", TEX_FLOOR);
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
		
		// Activar separate color por omissão
		glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);
	}

	// Flag que dita se o separate color está enabled
	private boolean separateColor = true;
	
	@Override
	protected void onKeyUp(KeyEvent e) {
		switch(e.keyCode) {
			case 's':
				separateColor = ! separateColor;
				glLightModeli(
					GL_LIGHT_MODEL_COLOR_CONTROL,
					separateColor ? GL_SEPARATE_SPECULAR_COLOR : GL_SINGLE_COLOR
				);
			break;
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
		
		// Utilizar cor cinza onde não há textura
		glColor3f(0.5f, 0.5f, 0.5f);

		// Desenhar a skybox
		drawSkybox(100.0f);

		// Desenhar o solo
		glBindTexture(GL_TEXTURE_2D, TEX_FLOOR);
		demo().drawFloor(50.0f, 10, 10.0f, false);
		
	}
	
	private void drawSkybox(float scale) {
		glPushAttrib(GL_ENABLE_BIT | GL_POLYGON_BIT);
			glEnable(GL_TEXTURE_2D);
			glDisable(GL_LIGHTING);
			glDisable(GL_BLEND);

			// Ativar o CULLING para as faces de fora (hint: estamos dentro do cube)
			glCullFace(GL_FRONT);
	
			// Just in case we set all vertices to white.
			glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	
			int mode = GL_QUADS;
	
			// Quad anterior
			glBindTexture(GL_TEXTURE_2D, TEX_POSITIVE_Z);
			glBegin(mode);
				glTexCoord2f(0, 0); glVertex3f(  scale, -scale, -scale );
				glTexCoord2f(1, 0); glVertex3f( -scale, -scale, -scale );
				glTexCoord2f(1, 1); glVertex3f( -scale,  scale, -scale );
				glTexCoord2f(0, 1); glVertex3f(  scale,  scale, -scale );
			glEnd();
	
			// Quad na direit
			glBindTexture(GL_TEXTURE_2D, TEX_POSITIVE_X);
			glBegin(mode);
				glTexCoord2f(0, 0); glVertex3f(  scale, -scale,  scale );
				glTexCoord2f(1, 0); glVertex3f(  scale, -scale, -scale );
				glTexCoord2f(1, 1); glVertex3f(  scale,  scale, -scale );
				glTexCoord2f(0, 1); glVertex3f(  scale,  scale,  scale );
			glEnd();
	
			// Quad posterior
			glBindTexture(GL_TEXTURE_2D, TEX_NEGATIVE_Z);
			glBegin(mode);
				glTexCoord2f(0, 0); glVertex3f( -scale, -scale,  scale );
				glTexCoord2f(1, 0); glVertex3f(  scale, -scale,  scale );
				glTexCoord2f(1, 1); glVertex3f(  scale,  scale,  scale );
				glTexCoord2f(0, 1); glVertex3f( -scale,  scale,  scale );
			glEnd();
	
			// Quad da esquerda
			glBindTexture(GL_TEXTURE_2D, TEX_NEGATIVE_X);
			glBegin(mode);
				glTexCoord2f(0, 0); glVertex3f( -scale, -scale, -scale );
				glTexCoord2f(1, 0); glVertex3f( -scale, -scale,  scale );
				glTexCoord2f(1, 1); glVertex3f( -scale,  scale,  scale );
				glTexCoord2f(0, 1); glVertex3f( -scale,  scale, -scale );
			glEnd();
	
			// Quad superior
			glBindTexture(GL_TEXTURE_2D, TEX_POSITIVE_Y);
			glBegin(mode);
				glTexCoord2f(0, 1); glVertex3f( -scale,  scale, -scale );
				glTexCoord2f(0, 0); glVertex3f( -scale,  scale,  scale );
				glTexCoord2f(1, 0); glVertex3f(  scale,  scale,  scale );
				glTexCoord2f(1, 1); glVertex3f(  scale,  scale, -scale );
			glEnd();
	
			// Quad inferior
			glBindTexture(GL_TEXTURE_2D, TEX_NEGATIVE_Y);
			glBegin(mode);
				glTexCoord2f(1, 0); glVertex3f(  scale, -scale, -scale );
				glTexCoord2f(1, 1); glVertex3f(  scale, -scale,  scale );
				glTexCoord2f(0, 1); glVertex3f( -scale, -scale,  scale );
				glTexCoord2f(0, 0); glVertex3f( -scale, -scale, -scale );
			glEnd();
	
		// Restore enable bits and matrix
		glPopAttrib();		
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 200.0f);
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		GLDisplay display = new GLDisplay("A06 Cube Map");
		display.start(new A07_CubeMap(display.getShell()));
	}

}
