package pt.ipb.esact.compgraf.engine.light;

import javax.media.opengl.GL2;
import javax.vecmath.Color4f;
import javax.vecmath.Vector4f;

import pt.ipb.esact.compgraf.tools.buffers.Buffers;
import pt.ipb.esact.compgraf.tools.math.Colors;
import pt.ipb.esact.compgraf.tools.math.Vectors;

public class Light {

	private Color4f ambient;
	
	private Color4f diffuse;
	
	private Color4f specular;
	
	private Vector4f position;

	private int id;
	
	public Light(GL2 gl, int id) {
		this.id = id;
		setAmbient(gl, Colors.LOW_AMBIENT);
		setDiffuse(gl, Colors.MEDIUM_DIFFUSE);
		setSpecular(gl, Colors.WHITE);
		setPosition(gl, new Vector4f(Vectors.origin()));
		setEnabled(gl, true);
	}
	
	public void setEnabled(GL2 gl, boolean enabled) {
		if(enabled) gl.glEnable(id); else gl.glDisable(id);
	}

	public Color4f getAmbient() {
		return ambient;
	}

	public void setAmbient(GL2 gl, Color4f ambient) {
		this.ambient = ambient;
		gl.glLightfv(id, GL2.GL_AMBIENT, Buffers.newFloatBuffer(ambient.x, ambient.y, ambient.z, ambient.w));
	}

	public Color4f getDiffuse() {
		return diffuse;
	}

	public void setDiffuse(GL2 gl, Color4f diffuse) {
		this.diffuse = diffuse;
		gl.glLightfv(id, GL2.GL_DIFFUSE, Buffers.newFloatBuffer(diffuse.x, diffuse.y, diffuse.z, diffuse.w));
	}

	public Color4f getSpecular() {
		return specular;
	}

	public void setSpecular(GL2 gl, Color4f specular) {
		this.specular = specular;
		gl.glLightfv(id, GL2.GL_SPECULAR, Buffers.newFloatBuffer(specular.x, specular.y, specular.z, specular.w));
	}

	public Vector4f getPosition() {
		return position;
	}

	public void setPosition(GL2 gl, Vector4f position) {
		this.position = position;
		gl.glLightfv(id, GL2.GL_POSITION, Buffers.newFloatBuffer(position.x, position.y, position.z, position.w));
	}

	public void setPosition(GL2 gl) {
		setPosition(gl, position);
	}
	
	
	
}
