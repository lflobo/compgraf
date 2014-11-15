package pt.ipb.esact.compgraf.aulas.extra;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import com.jogamp.opengl.util.texture.Texture;

public class A07_CubeMap extends DefaultGLWindow {

	public A07_CubeMap() {
		super("A06 Cube Map", true);
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
	private Texture TEX_POSITIVE_X;
	private Texture TEX_POSITIVE_Y;
	private Texture TEX_POSITIVE_Z;
	private Texture TEX_NEGATIVE_X;
	private Texture TEX_NEGATIVE_Y;
	private Texture TEX_NEGATIVE_Z;
	private Texture TEX_FLOOR;
	
	private void configureTextures() {
		// Setup das texturas
		TEX_POSITIVE_X = loadPackageTexture("skybox/dd-px.png");
		TEX_POSITIVE_Y = loadPackageTexture("skybox/dd-py.png");
		TEX_POSITIVE_Z = loadPackageTexture("skybox/dd-pz.png");
		TEX_NEGATIVE_X = loadPackageTexture("skybox/dd-nx.png");
		TEX_NEGATIVE_Y = loadPackageTexture("skybox/dd-ny.png");
		TEX_NEGATIVE_Z = loadPackageTexture("skybox/dd-nz.png");
		TEX_FLOOR = loadPackageTexture("stone.png");
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
		
		// Activar separate color por omissão
		glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);
	}

	@Override
	public void release() {
		// Libertar as texturas (GPU)
		TEX_POSITIVE_X.destroy(this);
		TEX_POSITIVE_Y.destroy(this);
		TEX_POSITIVE_Z.destroy(this);
		TEX_NEGATIVE_X.destroy(this);
		TEX_NEGATIVE_Y.destroy(this);
		TEX_NEGATIVE_Z.destroy(this);
		TEX_FLOOR.destroy(this);
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-40.0f, 10.0f, -100.0f, 1.0f));
		
		// Utilizar cor cinza onde não há textura
		glColor3f(0.5f, 0.5f, 0.5f);

		// Desenhar a skybox
		drawSkybox(100.0f);

		// Desenhar o solo
		TEX_FLOOR.bind(this);
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
			TEX_POSITIVE_Z.bind(this);
			glBegin(mode);
				glTexCoord2f(0, 0); glVertex3f(  scale, -scale, -scale );
				glTexCoord2f(1, 0); glVertex3f( -scale, -scale, -scale );
				glTexCoord2f(1, 1); glVertex3f( -scale,  scale, -scale );
				glTexCoord2f(0, 1); glVertex3f(  scale,  scale, -scale );
			glEnd();
	
			// Quad na direita
			TEX_POSITIVE_X.bind(this);
			glBegin(mode);
				glTexCoord2f(0, 0); glVertex3f(  scale, -scale,  scale );
				glTexCoord2f(1, 0); glVertex3f(  scale, -scale, -scale );
				glTexCoord2f(1, 1); glVertex3f(  scale,  scale, -scale );
				glTexCoord2f(0, 1); glVertex3f(  scale,  scale,  scale );
			glEnd();
	
			// Quad posterior
			TEX_NEGATIVE_Z.bind(this);
			glBegin(mode);
				glTexCoord2f(0, 0); glVertex3f( -scale, -scale,  scale );
				glTexCoord2f(1, 0); glVertex3f(  scale, -scale,  scale );
				glTexCoord2f(1, 1); glVertex3f(  scale,  scale,  scale );
				glTexCoord2f(0, 1); glVertex3f( -scale,  scale,  scale );
			glEnd();
	
			// Quad da esquerda
			TEX_NEGATIVE_X.bind(this);
			glBegin(mode);
				glTexCoord2f(0, 0); glVertex3f( -scale, -scale, -scale );
				glTexCoord2f(1, 0); glVertex3f( -scale, -scale,  scale );
				glTexCoord2f(1, 1); glVertex3f( -scale,  scale,  scale );
				glTexCoord2f(0, 1); glVertex3f( -scale,  scale, -scale );
			glEnd();
	
			// Quad superior
			TEX_POSITIVE_Y.bind(this);
			glBegin(mode);
				glTexCoord2f(0, 1); glVertex3f( -scale,  scale, -scale );
				glTexCoord2f(0, 0); glVertex3f( -scale,  scale,  scale );
				glTexCoord2f(1, 0); glVertex3f(  scale,  scale,  scale );
				glTexCoord2f(1, 1); glVertex3f(  scale,  scale, -scale );
			glEnd();
	
			// Quad inferior
			TEX_NEGATIVE_Y.bind(this);
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
		Cameras.setCurrent(new Camera(4, 4, 4));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A07_CubeMap();
	}

}
