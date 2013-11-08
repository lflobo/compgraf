package pt.ipb.esact.compgraf.tools;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import javax.media.opengl.glu.gl2.GLUgl2;

import com.jogamp.opengl.util.glsl.ShaderState;

public class GLUWrapper extends GL2Wrapper {
	
	private GLU glu = new GLUgl2();

	/**
	 * @param gluFunctionName
	 * @return
	 * @see javax.media.opengl.glu.GLU#isFunctionAvailable(java.lang.String)
	 */
	public boolean isFunctionAvailable(String gluFunctionName) {
		return glu.isFunctionAvailable(gluFunctionName);
	}

	/**
	 * @param errorCode
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluErrorString(int)
	 */
	public final String gluErrorString(int errorCode) {
		return glu.gluErrorString(errorCode);
	}

	/**
	 * @param extName
	 * @param extString
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluCheckExtension(java.lang.String, java.lang.String)
	 */
	public final boolean gluCheckExtension(String extName, String extString) {
		return glu.gluCheckExtension(extName, extString);
	}

	/**
	 * @param name
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluGetString(int)
	 */
	public final String gluGetString(int name) {
		return glu.gluGetString(name);
	}

	/**
	 * @param quad
	 * @param base
	 * @param top
	 * @param height
	 * @param slices
	 * @param stacks
	 * @see javax.media.opengl.glu.GLU#gluCylinder(javax.media.opengl.glu.GLUquadric, double, double, double, int, int)
	 */
	public final void gluCylinder(GLUquadric quad, double base, double top, double height, int slices, int stacks) {
		glu.gluCylinder(quad, base, top, height, slices, stacks);
	}

	/**
	 * @param quad
	 * @see javax.media.opengl.glu.GLU#gluDeleteQuadric(javax.media.opengl.glu.GLUquadric)
	 */
	public final void gluDeleteQuadric(GLUquadric quad) {
		glu.gluDeleteQuadric(quad);
	}

	/**
	 * @param quad
	 * @param inner
	 * @param outer
	 * @param slices
	 * @param loops
	 * @see javax.media.opengl.glu.GLU#gluDisk(javax.media.opengl.glu.GLUquadric, double, double, int, int)
	 */
	public final void gluDisk(GLUquadric quad, double inner, double outer, int slices, int loops) {
		glu.gluDisk(quad, inner, outer, slices, loops);
	}

	/**
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluNewQuadric()
	 */
	public final GLUquadric gluNewQuadric() {
		return glu.gluNewQuadric();
	}

	/**
	 * @param useGLSL
	 * @param st
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluNewQuadric(boolean, com.jogamp.opengl.util.glsl.ShaderState)
	 */
	public final GLUquadric gluNewQuadric(boolean useGLSL, ShaderState st) {
		return glu.gluNewQuadric(useGLSL, st);
	}

	/**
	 * @param useGLSL
	 * @param shaderProgram
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluNewQuadric(boolean, int)
	 */
	public final GLUquadric gluNewQuadric(boolean useGLSL, int shaderProgram) {
		return glu.gluNewQuadric(useGLSL, shaderProgram);
	}

	/**
	 * @param quad
	 * @param inner
	 * @param outer
	 * @param slices
	 * @param loops
	 * @param start
	 * @param sweep
	 * @see javax.media.opengl.glu.GLU#gluPartialDisk(javax.media.opengl.glu.GLUquadric, double, double, int, int, double, double)
	 */
	public final void gluPartialDisk(GLUquadric quad, double inner, double outer, int slices, int loops, double start, double sweep) {
		glu.gluPartialDisk(quad, inner, outer, slices, loops, start, sweep);
	}

	/**
	 * @param quad
	 * @param draw
	 * @see javax.media.opengl.glu.GLU#gluQuadricDrawStyle(javax.media.opengl.glu.GLUquadric, int)
	 */
	public final void gluQuadricDrawStyle(GLUquadric quad, int draw) {
		glu.gluQuadricDrawStyle(quad, draw);
	}

	/**
	 * @param quad
	 * @param normal
	 * @see javax.media.opengl.glu.GLU#gluQuadricNormals(javax.media.opengl.glu.GLUquadric, int)
	 */
	public final void gluQuadricNormals(GLUquadric quad, int normal) {
		glu.gluQuadricNormals(quad, normal);
	}

	/**
	 * @param quad
	 * @param orientation
	 * @see javax.media.opengl.glu.GLU#gluQuadricOrientation(javax.media.opengl.glu.GLUquadric, int)
	 */
	public final void gluQuadricOrientation(GLUquadric quad, int orientation) {
		glu.gluQuadricOrientation(quad, orientation);
	}

	/**
	 * @param quad
	 * @param texture
	 * @see javax.media.opengl.glu.GLU#gluQuadricTexture(javax.media.opengl.glu.GLUquadric, boolean)
	 */
	public final void gluQuadricTexture(GLUquadric quad, boolean texture) {
		glu.gluQuadricTexture(quad, texture);
	}

	/**
	 * @param quad
	 * @param radius
	 * @param slices
	 * @param stacks
	 * @see javax.media.opengl.glu.GLU#gluSphere(javax.media.opengl.glu.GLUquadric, double, int, int)
	 */
	public final void gluSphere(GLUquadric quad, double radius, int slices, int stacks) {
		glu.gluSphere(quad, radius, slices, stacks);
	}

	/**
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @see javax.media.opengl.glu.GLU#gluOrtho2D(float, float, float, float)
	 */
	public void gluOrtho2D(float left, float right, float bottom, float top) {
		glu.gluOrtho2D(left, right, bottom, top);
	}

	/**
	 * @param fovy
	 * @param aspect
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.glu.GLU#gluPerspective(float, float, float, float)
	 */
	public void gluPerspective(float fovy, float aspect, float zNear, float zFar) {
		glu.gluPerspective(fovy, aspect, zNear, zFar);
	}

	/**
	 * @param eyeX
	 * @param eyeY
	 * @param eyeZ
	 * @param centerX
	 * @param centerY
	 * @param centerZ
	 * @param upX
	 * @param upY
	 * @param upZ
	 * @see javax.media.opengl.glu.GLU#gluLookAt(float, float, float, float, float, float, float, float, float)
	 */
	public void gluLookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
		glu.gluLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
	}

	/**
	 * @param objX
	 * @param objY
	 * @param objZ
	 * @param model
	 * @param model_offset
	 * @param proj
	 * @param proj_offset
	 * @param view
	 * @param view_offset
	 * @param winPos
	 * @param winPos_offset
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluProject(float, float, float, float[], int, float[], int, int[], int, float[], int)
	 */
	public boolean gluProject(float objX, float objY, float objZ, float[] model, int model_offset, float[] proj, int proj_offset, int[] view, int view_offset, float[] winPos, int winPos_offset) {
		return glu.gluProject(objX, objY, objZ, model, model_offset, proj, proj_offset, view, view_offset, winPos, winPos_offset);
	}

	/**
	 * @param objX
	 * @param objY
	 * @param objZ
	 * @param model
	 * @param proj
	 * @param view
	 * @param winPos
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluProject(float, float, float, java.nio.FloatBuffer, java.nio.FloatBuffer, java.nio.IntBuffer, java.nio.FloatBuffer)
	 */
	public boolean gluProject(float objX, float objY, float objZ, FloatBuffer model, FloatBuffer proj, IntBuffer view, FloatBuffer winPos) {
		return glu.gluProject(objX, objY, objZ, model, proj, view, winPos);
	}

	/**
	 * @param winX
	 * @param winY
	 * @param winZ
	 * @param model
	 * @param model_offset
	 * @param proj
	 * @param proj_offset
	 * @param view
	 * @param view_offset
	 * @param objPos
	 * @param objPos_offset
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluUnProject(float, float, float, float[], int, float[], int, int[], int, float[], int)
	 */
	public boolean gluUnProject(float winX, float winY, float winZ, float[] model, int model_offset, float[] proj, int proj_offset, int[] view, int view_offset, float[] objPos, int objPos_offset) {
		return glu.gluUnProject(winX, winY, winZ, model, model_offset, proj, proj_offset, view, view_offset, objPos, objPos_offset);
	}

	/**
	 * @param winX
	 * @param winY
	 * @param winZ
	 * @param model
	 * @param proj
	 * @param view
	 * @param objPos
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluUnProject(float, float, float, java.nio.FloatBuffer, java.nio.FloatBuffer, java.nio.IntBuffer, java.nio.FloatBuffer)
	 */
	public boolean gluUnProject(float winX, float winY, float winZ, FloatBuffer model, FloatBuffer proj, IntBuffer view, FloatBuffer objPos) {
		return glu.gluUnProject(winX, winY, winZ, model, proj, view, objPos);
	}

	/**
	 * @param winX
	 * @param winY
	 * @param winZ
	 * @param clipW
	 * @param model
	 * @param model_offset
	 * @param proj
	 * @param proj_offset
	 * @param view
	 * @param view_offset
	 * @param nearVal
	 * @param farVal
	 * @param objPos
	 * @param objPos_offset
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluUnProject4(float, float, float, float, float[], int, float[], int, int[], int, float, float, float[], int)
	 */
	public boolean gluUnProject4(float winX, float winY, float winZ, float clipW, float[] model, int model_offset, float[] proj, int proj_offset, int[] view, int view_offset, float nearVal, float farVal, float[] objPos, int objPos_offset) {
		return glu.gluUnProject4(winX, winY, winZ, clipW, model, model_offset, proj, proj_offset, view, view_offset, nearVal, farVal, objPos, objPos_offset);
	}

	/**
	 * @param winX
	 * @param winY
	 * @param winZ
	 * @param clipW
	 * @param model
	 * @param proj
	 * @param view
	 * @param nearVal
	 * @param farVal
	 * @param objPos
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluUnProject4(float, float, float, float, java.nio.FloatBuffer, java.nio.FloatBuffer, java.nio.IntBuffer, float, float, java.nio.FloatBuffer)
	 */
	public boolean gluUnProject4(float winX, float winY, float winZ, float clipW, FloatBuffer model, FloatBuffer proj, IntBuffer view, float nearVal, float farVal, FloatBuffer objPos) {
		return glu.gluUnProject4(winX, winY, winZ, clipW, model, proj, view, nearVal, farVal, objPos);
	}

	/**
	 * @param x
	 * @param y
	 * @param delX
	 * @param delY
	 * @param viewport
	 * @param viewport_offset
	 * @see javax.media.opengl.glu.GLU#gluPickMatrix(float, float, float, float, int[], int)
	 */
	public void gluPickMatrix(float x, float y, float delX, float delY, int[] viewport, int viewport_offset) {
		glu.gluPickMatrix(x, y, delX, delY, viewport, viewport_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param delX
	 * @param delY
	 * @param viewport
	 * @see javax.media.opengl.glu.GLU#gluPickMatrix(float, float, float, float, java.nio.IntBuffer)
	 */
	public void gluPickMatrix(float x, float y, float delX, float delY, IntBuffer viewport) {
		glu.gluPickMatrix(x, y, delX, delY, viewport);
	}

	/**
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @see javax.media.opengl.glu.GLU#gluOrtho2D(double, double, double, double)
	 */
	public void gluOrtho2D(double left, double right, double bottom, double top) {
		glu.gluOrtho2D(left, right, bottom, top);
	}

	/**
	 * @param fovy
	 * @param aspect
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.glu.GLU#gluPerspective(double, double, double, double)
	 */
	public void gluPerspective(double fovy, double aspect, double zNear, double zFar) {
		glu.gluPerspective(fovy, aspect, zNear, zFar);
	}

	/**
	 * @param eyeX
	 * @param eyeY
	 * @param eyeZ
	 * @param centerX
	 * @param centerY
	 * @param centerZ
	 * @param upX
	 * @param upY
	 * @param upZ
	 * @see javax.media.opengl.glu.GLU#gluLookAt(double, double, double, double, double, double, double, double, double)
	 */
	public void gluLookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
		glu.gluLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
	}

	/**
	 * @param objX
	 * @param objY
	 * @param objZ
	 * @param model
	 * @param model_offset
	 * @param proj
	 * @param proj_offset
	 * @param view
	 * @param view_offset
	 * @param winPos
	 * @param winPos_offset
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluProject(double, double, double, double[], int, double[], int, int[], int, double[], int)
	 */
	public boolean gluProject(double objX, double objY, double objZ, double[] model, int model_offset, double[] proj, int proj_offset, int[] view, int view_offset, double[] winPos, int winPos_offset) {
		return glu.gluProject(objX, objY, objZ, model, model_offset, proj, proj_offset, view, view_offset, winPos, winPos_offset);
	}

	/**
	 * @param winX
	 * @param winY
	 * @param winZ
	 * @param model
	 * @param model_offset
	 * @param proj
	 * @param proj_offset
	 * @param view
	 * @param view_offset
	 * @param objPos
	 * @param objPos_offset
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluUnProject(double, double, double, double[], int, double[], int, int[], int, double[], int)
	 */
	public boolean gluUnProject(double winX, double winY, double winZ, double[] model, int model_offset, double[] proj, int proj_offset, int[] view, int view_offset, double[] objPos, int objPos_offset) {
		return glu.gluUnProject(winX, winY, winZ, model, model_offset, proj, proj_offset, view, view_offset, objPos, objPos_offset);
	}

	/**
	 * @param winX
	 * @param winY
	 * @param winZ
	 * @param clipW
	 * @param model
	 * @param model_offset
	 * @param proj
	 * @param proj_offset
	 * @param view
	 * @param view_offset
	 * @param nearVal
	 * @param farVal
	 * @param objPos
	 * @param objPos_offset
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluUnProject4(double, double, double, double, double[], int, double[], int, int[], int, double, double, double[], int)
	 */
	public boolean gluUnProject4(double winX, double winY, double winZ, double clipW, double[] model, int model_offset, double[] proj, int proj_offset, int[] view, int view_offset, double nearVal, double farVal, double[] objPos, int objPos_offset) {
		return glu.gluUnProject4(winX, winY, winZ, clipW, model, model_offset, proj, proj_offset, view, view_offset, nearVal, farVal, objPos, objPos_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param delX
	 * @param delY
	 * @param viewport
	 * @param viewport_offset
	 * @see javax.media.opengl.glu.GLU#gluPickMatrix(double, double, double, double, int[], int)
	 */
	public void gluPickMatrix(double x, double y, double delX, double delY, int[] viewport, int viewport_offset) {
		glu.gluPickMatrix(x, y, delX, delY, viewport, viewport_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param delX
	 * @param delY
	 * @param viewport
	 * @see javax.media.opengl.glu.GLU#gluPickMatrix(double, double, double, double, java.nio.IntBuffer)
	 */
	public void gluPickMatrix(double x, double y, double delX, double delY, IntBuffer viewport) {
		glu.gluPickMatrix(x, y, delX, delY, viewport);
	}

	/**
	 * @param format
	 * @param widthin
	 * @param heightin
	 * @param typein
	 * @param datain
	 * @param widthout
	 * @param heightout
	 * @param typeout
	 * @param dataout
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluScaleImage(int, int, int, int, java.nio.Buffer, int, int, int, java.nio.Buffer)
	 */
	public int gluScaleImage(int format, int widthin, int heightin, int typein, Buffer datain, int widthout, int heightout, int typeout, Buffer dataout) {
		return glu.gluScaleImage(format, widthin, heightin, typein, datain, widthout, heightout, typeout, dataout);
	}

	/**
	 * @param target
	 * @param internalFormat
	 * @param width
	 * @param format
	 * @param type
	 * @param userLevel
	 * @param baseLevel
	 * @param maxLevel
	 * @param data
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluBuild1DMipmapLevels(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public int gluBuild1DMipmapLevels(int target, int internalFormat, int width, int format, int type, int userLevel, int baseLevel, int maxLevel, Buffer data) {
		return glu.gluBuild1DMipmapLevels(target, internalFormat, width, format, type, userLevel, baseLevel, maxLevel, data);
	}

	/**
	 * @param target
	 * @param internalFormat
	 * @param width
	 * @param format
	 * @param type
	 * @param data
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluBuild1DMipmaps(int, int, int, int, int, java.nio.Buffer)
	 */
	public int gluBuild1DMipmaps(int target, int internalFormat, int width, int format, int type, Buffer data) {
		return glu.gluBuild1DMipmaps(target, internalFormat, width, format, type, data);
	}

	/**
	 * @param target
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param userLevel
	 * @param baseLevel
	 * @param maxLevel
	 * @param data
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluBuild2DMipmapLevels(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public int gluBuild2DMipmapLevels(int target, int internalFormat, int width, int height, int format, int type, int userLevel, int baseLevel, int maxLevel, Buffer data) {
		return glu.gluBuild2DMipmapLevels(target, internalFormat, width, height, format, type, userLevel, baseLevel, maxLevel, data);
	}

	/**
	 * @param target
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param data
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluBuild2DMipmaps(int, int, int, int, int, int, java.nio.Buffer)
	 */
	public int gluBuild2DMipmaps(int target, int internalFormat, int width, int height, int format, int type, Buffer data) {
		return glu.gluBuild2DMipmaps(target, internalFormat, width, height, format, type, data);
	}

	/**
	 * @param target
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param type
	 * @param userLevel
	 * @param baseLevel
	 * @param maxLevel
	 * @param data
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluBuild3DMipmapLevels(int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public int gluBuild3DMipmapLevels(int target, int internalFormat, int width, int height, int depth, int format, int type, int userLevel, int baseLevel, int maxLevel, Buffer data) {
		return glu.gluBuild3DMipmapLevels(target, internalFormat, width, height, depth, format, type, userLevel, baseLevel, maxLevel, data);
	}

	/**
	 * @param target
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param type
	 * @param data
	 * @return
	 * @see javax.media.opengl.glu.GLU#gluBuild3DMipmaps(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public int gluBuild3DMipmaps(int target, int internalFormat, int width, int height, int depth, int format, int type, Buffer data) {
		return glu.gluBuild3DMipmaps(target, internalFormat, width, height, depth, format, type, data);
	}

}
