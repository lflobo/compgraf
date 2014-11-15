package pt.ipb.esact.compgraf.aulas.extra;

import java.awt.event.KeyEvent;

import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

import com.jogamp.opengl.util.texture.Texture;

public class A07_Texgen extends DefaultGLWindow {

	// Texto que diz qual o metodo de texgen usago
	private String text = "Texgen: Object Linear Mapping";
	
	public A07_Texgen() {
		super("A07 Texgen", true);
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

		// Configurar TexGen
		setObjectLinear();
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
	private Texture TEX_STRIPES;
	private Texture TEX_ENVIRONMENT;
	private Texture TEX_CURRENT;
	
	private void configureTextures() {
		// Carregar as texturas
		TEX_STRIPES = loadPackageTexture("texgen/stripes.png");
		TEX_ENVIRONMENT = loadPackageTexture("texgen/environment.png");
		
		// Activar as texturas
		glEnable(GL_TEXTURE_2D);
	}


	@Override
	protected void onKeyUp(KeyEvent e) {
		switch (e.getKeyChar()) {
			case '1': setObjectLinear(); break;
			case '2': setEyeLinear(); break;
			case '3': setSphereMap(); break;
		}
	}

	void setObjectLinear() {
		text = "Texgen: Object Linear Mapping";
		TEX_CURRENT = TEX_STRIPES;
		TEX_CURRENT.bind(this);
		float[] zPlane = { 1.0f, 0.0f, 0.0f, 0.0f };
		glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_OBJECT_LINEAR);
		glTexGenfv(GL_S, GL_OBJECT_PLANE, zPlane, 0);
		glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_OBJECT_LINEAR);
		glTexGenfv(GL_T, GL_OBJECT_PLANE, zPlane, 0);
	}
	
	void setEyeLinear() {
		text = "Texgen: Eye Linear Mapping";
		TEX_CURRENT = TEX_STRIPES;
		TEX_CURRENT.bind(this);
		float[] zPlane = { 0.0f, 0.0f, 1.0f, 0.0f };
		glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_EYE_LINEAR);
		glTexGenfv(GL_S, GL_EYE_PLANE, zPlane, 0);
		glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_EYE_LINEAR);
		glTexGenfv(GL_T, GL_EYE_PLANE, zPlane, 0);
	}
	
	void setSphereMap() {
		text = "Texgen: Sphere Mapping";
		TEX_CURRENT = TEX_ENVIRONMENT;
		TEX_CURRENT.bind(this);
		glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_SPHERE_MAP);
		glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_SPHERE_MAP);
	}
	
	@Override
	public void release() {
		// Libertar as texturas (GPU)
		TEX_ENVIRONMENT.destroy(this);
		TEX_STRIPES.destroy(this);
	}
	
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		// Reposicionar a luz
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer(-10.0f, 20.0f, -10.0f, 1.0f));
		
		// Utilizar cor branca onde não há textura
		glColor3f(1.0f, 1.0f, 1.0f);
		TEX_CURRENT.bind(this);

		glPushAttrib(GL_ENABLE_BIT);
			// Activar a Geração de Coordenadas
			glEnable(GL_TEXTURE_GEN_S);
			glEnable(GL_TEXTURE_GEN_T);

			glPushMatrix();
				glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
				glTranslatef(-4.0f, 0.0f, 0.0f);
				glutSolidTorus(0.9f, 2.8f, 30, 30);
			glPopMatrix();
			
		glPopAttrib();

		// Desenhar uma amostra da textura
		glPushMatrix();
			glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
			glTranslatef(4.0f, 0.0f, 0.0f);
			drawQuad(3.0f);
		glPopMatrix();
		
		renderText(text, 10, 20);
	}

	private void drawQuad(float quadSize) {
		glBegin(GL_QUADS);
			glTexCoord2f(0.0f, 0.0f);
			glVertex2f(-quadSize, -quadSize);

			glTexCoord2f(1.0f, 0.0f);
			glVertex2f(quadSize, -quadSize);

			glTexCoord2f(1.0f, 1.0f);
			glVertex2f(quadSize, quadSize);

			glTexCoord2f(0.0f, 1.0f);
			glVertex2f(-quadSize, quadSize);
		glEnd();
	}
	
	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 30.0f);
		Cameras.setCurrent(new Camera(0, 0, 10));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new A07_Texgen();
	}

}
