package pt.ipb.esact.compgraf.aulas.extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.FloatBuffer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.Camera;
import pt.ipb.esact.compgraf.tools.Cameras;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;

public class MenuExample extends DefaultGLWindow {

	// .obj loaders
	private ObjLoader obj;
	
	private FloatBuffer lightDiffuse;

	protected boolean wireframe = false;

	protected String selectedItem = "-";

	// skybox
	public MenuExample() {
		super("Menu Example", true);
		setMousePan(true);
		setMouseZoom(true);
		setPopupMenu(configurePopupMenu());
	}

	private JPopupMenu configurePopupMenu() {
		JPopupMenu menu = new JPopupMenu();
		
		// Top level item
		JMenuItem toggleWireframe = new JMenuItem("Toggle Wireframe");
		menu.add(toggleWireframe);
		toggleWireframe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// fazer o handle do click
				wireframe = ! wireframe;
			}
		});

		JMenu moreStuffMenu =  new JMenu("More Stuff...");
		menu.add(moreStuffMenu);
		
		JMenuItem potatoesItem = new JMenuItem("Potatoes");
		moreStuffMenu.add(potatoesItem);
		potatoesItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedItem = "Potatoes";
			}
		});
		
		JMenuItem tomatoesItem = new JMenuItem("Tomatoes");
		moreStuffMenu.add(tomatoesItem);
		tomatoesItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedItem = "Tomatoes";
			}
		});
		
		return menu;
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

		configureLighting();
		configureMaterials();
		configureModels();

	}

	private void configureModels() {
		obj = new ObjLoader(this);
		obj.load("assets/models/wheatley/wheatley.obj", "assets/models/wheatley/wheatley.mtl");
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
		float[] ambientLowLight = { 0.1f, 0.1f, 0.1f, 1.0f };
		glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLowLight, 0);

		// Configurar uma point light
		glLightfv(GL_LIGHT0, GL_AMBIENT,  newFloatBuffer( 0f, 0f, 0f, 1 ));
		glLightfv(GL_LIGHT0, GL_DIFFUSE,  newFloatBuffer( .4f, .4f, .4f, 1 ));
		glLightfv(GL_LIGHT0, GL_SPECULAR, newFloatBuffer( 1, 1, 1, 1 ));
		glEnable(GL_LIGHT0);

		// Configurar uma spot light
		glLightfv(GL_LIGHT1, GL_AMBIENT,  newFloatBuffer( .4f, .4f, .4f, 1 ));
		lightDiffuse = newFloatBuffer( 1, 1, 1, 1 );
		glLightfv(GL_LIGHT1, GL_DIFFUSE,  lightDiffuse);
		glLightfv(GL_LIGHT1, GL_SPECULAR, newFloatBuffer( 1, 1, 1, 1 ));
		glLightf(GL_LIGHT1, GL_SPOT_CUTOFF, 25.0f);
		glLightf(GL_LIGHT1, GL_SPOT_EXPONENT, 0.1f);
		glEnable(GL_LIGHT1);

	}
	
	@Override
	public void release() {
		// Libertar as texturas (GPU)z
	}
	
		
	@Override
	public void render(int width, int height) {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		glLightfv(GL_LIGHT1, GL_DIFFUSE,  lightDiffuse);
		
		// Posicionar as luzes
		glLightfv(GL_LIGHT0, GL_POSITION, newFloatBuffer( 0.0f, 5.0f, 0.0f, 1.0f ));
		glLightfv(GL_LIGHT1, GL_POSITION, newFloatBuffer( 0.0f, 6.0f, 0.0f, 1.0f ));
		glLightfv(GL_LIGHT1, GL_SPOT_DIRECTION, newFloatBuffer(0, -1, 0));

		// Desenhar o Wheatley
		glPushMatrix();
			obj.render(wireframe);
		glPopMatrix();
		
		renderText("Selected item: " + selectedItem, 10, 20);
		renderText("Click right mouse button...", 10, 40);
		render3DText(
			"I are wheatley" + (wireframe?" in wireframe":"") +"!", // texto
			0, .6f, 0, // posicao (x, y, z)
			0.02f); // escala
	}

	@Override
	public void resize(int width, int height) {
		setProjectionPerspective(width, height, 100.0f, 0.001f, 500.0f);
		Cameras.setCurrent(new Camera(3,3,3));
		setupCamera();
	}

	// Função main confere capacidade de executável ao .java atual
	public static void main(String[] args) {
		new MenuExample();
	}

}
