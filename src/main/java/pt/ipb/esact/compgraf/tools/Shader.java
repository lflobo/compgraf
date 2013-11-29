package pt.ipb.esact.compgraf.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.media.opengl.GL2;

public class Shader {

	int program = 0;

	private int diffuseUniform;

	private int normalUniform;

	private int specularUniform;
	
	public static final String UNIFORM_DIFFUSE_MAP_NAME = "diffuse_map";
	
	public static final String UNIFORM_NORMAL_MAP_NAME = "normal_map";
	
	public static final String UNIFORM_SPECULAR_MAP_NAME = "specular_map";
	
	public static final int DIFFUSE_MAP_INDEX = GL2.GL_TEXTURE0;
	
	public static final int NORMAL_MAP_INDEX = GL2.GL_TEXTURE2;
	
	public static final int SPECULAR_MAP_INDEX = GL2.GL_TEXTURE4;
	
	public Shader() {
	}
	
	public void load(Object reference, String vertexShader, String fragmentShader) {
		GL2 gl = GlTools.gl();
		int vertex = compile(reference, GL2.GL_VERTEX_SHADER, vertexShader);
		int fragment = compile(reference, GL2.GL_FRAGMENT_SHADER, fragmentShader);
		
		program = gl.glCreateProgram();
		
		gl.glAttachShader(program, vertex);
		gl.glAttachShader(program, fragment);
		
		gl.glLinkProgram(program);
		gl.glValidateProgram(program);
		
		diffuseUniform = gl.glGetUniformLocation(program, UNIFORM_DIFFUSE_MAP_NAME);
		normalUniform = gl.glGetUniformLocation(program, UNIFORM_NORMAL_MAP_NAME);
		specularUniform = gl.glGetUniformLocation(program, UNIFORM_SPECULAR_MAP_NAME);
	}
	
	public int compile(Object reference, int type, String path) {
		GL2 gl = GlTools.gl();
		int shader = gl.glCreateShader(type);
		
		try (BufferedReader stream = new BufferedReader(new InputStreamReader(reference.getClass().getResourceAsStream(path)));) {
			StringBuilder lines = new StringBuilder();
			String line = null;
			while((line = stream.readLine()) != null)
				lines.append(line).append("\n");
			gl.glShaderSource(shader, 1, new String[] { lines.toString() }, (int[]) null, 0);
			gl.glCompileShader(shader);
		} catch (IOException e) {
			GlTools.exit(e.getMessage());
		}

		return shader;
	}

	public void use() {
		GL2 gl = GlTools.gl();
		
		gl.glUniform1i(diffuseUniform, DIFFUSE_MAP_INDEX - GL2.GL_TEXTURE0);
		gl.glUniform1i(normalUniform, NORMAL_MAP_INDEX - GL2.GL_TEXTURE0);
		gl.glUniform1i(specularUniform, SPECULAR_MAP_INDEX - GL2.GL_TEXTURE0);
		
		gl.glUseProgram(program);
	}
	
}
