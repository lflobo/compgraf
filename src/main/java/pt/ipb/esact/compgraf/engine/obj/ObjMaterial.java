package pt.ipb.esact.compgraf.engine.obj;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.file.Paths;
import java.util.Set;

import javax.media.opengl.GL2;

import pt.ipb.esact.compgraf.tools.GlTools;
import pt.ipb.esact.compgraf.tools.Shader;
import pt.ipb.esact.compgraf.tools.math.GlMath;

import com.google.common.collect.Sets;


public class ObjMaterial {

	private String name;

	private Set<Integer> textureIds = Sets.newHashSet();
	
	FloatBuffer ka = FloatBuffer.allocate(4);
	FloatBuffer kd = FloatBuffer.allocate(4);
	FloatBuffer ks = FloatBuffer.allocate(4);

	private boolean kaset;

	private boolean ksset;

	private boolean kdset;

	private boolean nsset;

	private boolean dset;

	private float ns;

	private float d;

	private boolean mkdset;
	
	private boolean mbumpset;
	
	private int TEX_BUMP = 0;
	
	private int TEX_DIFFUSE = 0;

	public ObjMaterial(String name) {
		this.name = name;
	}
	
	public void setKa(float r, float g, float b) {
		kaset = true;
		ka = FloatBuffer.wrap(new float[] {r, b, b, 1.0f});
	}

	public void setKd(float r, float g, float b) {
		kdset = true;
		kd = FloatBuffer.wrap(new float[] {r, b, b, 1.0f});
	}

	public void setKs(float r, float g, float b) {
		ksset = true;
		ks = FloatBuffer.wrap(new float[] {r, b, b, 1.0f});
	}

	public void setMapKd(Object reference, String prefix, String value) {
		mkdset = true;
		String name = Paths.get(value).getFileName().toString();
		GL2 gl = GlTools.gl();
		
		IntBuffer texture = IntBuffer.allocate(1);
		gl.glGenTextures(1, texture);
		TEX_DIFFUSE = texture.get(0);
		GlTools.loadPackageTexture(reference, prefix + name, TEX_DIFFUSE);
	}

	public void setMapBump(Object reference, String prefix, String value) {
		mbumpset = true;
		String name = Paths.get(value).getFileName().toString();
		GL2 gl = GlTools.gl();
		
		IntBuffer texture = IntBuffer.allocate(1);
		gl.glGenTextures(1, texture);
		TEX_BUMP = texture.get(0);
		GlTools.loadPackageTexture(reference, prefix + name, TEX_BUMP);
	}

	public void setD(float value) {
		dset = true;
		d = GlMath.clamp(value, 0.0f, 1.0f);
	}

	public void setNs(float value) {
		nsset = true;
		ns = GlMath.clamp(value, 0.0f, 1.0f);
	}

	public void set() {
		GL2 gl = GlTools.gl();
		if(kdset)
			gl.glColor4fv(kd);
		
		if(kaset)
			gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT, ka);
		if(kdset)
			gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_DIFFUSE, kd);
		if(ksset)
			gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, ks);
		if(nsset)
			gl.glMaterialf(GL2.GL_FRONT, GL2.GL_SHININESS, ns);

		if(dset && d < 1.0f) {
			gl.glEnable(GL2.GL_BLEND);
			gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		} else {
			gl.glDisable(GL2.GL_BLEND);
		}

		if(mkdset || mbumpset) {
			gl.glEnable(GL2.GL_TEXTURE_2D);
		}

		if(mbumpset) {
			gl.glActiveTexture(Shader.NORMAL_MAP_INDEX);
			gl.glBindTexture(GL2.GL_TEXTURE_2D, TEX_BUMP);
		}

		if(mkdset) {
			gl.glActiveTexture(Shader.DIFFUSE_MAP_INDEX);
			gl.glBindTexture(GL2.GL_TEXTURE_2D, TEX_DIFFUSE);
		}

		if(!mkdset && !mbumpset)
			gl.glDisable(GL2.GL_TEXTURE_2D);
	}

	@Override
	public String toString() {
		return "ObjMaterial [name=" + name + ", textureIds=" + textureIds + ", ka=" + ka + ", kd=" + kd + ", ks=" + ks + ", kaset=" + kaset + ", ksset=" + ksset + ", kdset=" + kdset + ", nsset=" + nsset + ", dset=" + dset + ", ns=" + ns + ", d=" + d + ", mkdset=" + mkdset + ", mbumpset=" + mbumpset + ", TEX_BUMP=" + TEX_BUMP + ", TEX_DIFFUSE=" + TEX_DIFFUSE + "]";
	}
	
	
	
}
