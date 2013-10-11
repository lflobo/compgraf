package pt.ipb.esact.compgraf.tools;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GL2ES2;
import javax.media.opengl.GL2GL3;
import javax.media.opengl.GL3;
import javax.media.opengl.GL3ES3;
import javax.media.opengl.GL3bc;
import javax.media.opengl.GL4;
import javax.media.opengl.GL4ES3;
import javax.media.opengl.GL4bc;
import javax.media.opengl.GLArrayData;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLES1;
import javax.media.opengl.GLES2;
import javax.media.opengl.GLES3;
import javax.media.opengl.GLException;
import javax.media.opengl.GLProfile;
import javax.media.opengl.GLUniformData;

import com.jogamp.common.nio.PointerBuffer;

public class GL2Wrapper implements GL2 {

	private GL2 current;
	
	protected void setCurrent(GL2 current) {
		this.current = current;
	}
	
	public GL2 getCurrent() {
		if(current == null)
			throw new RuntimeException("Current GL2 is null, did you forget to invoke setCurrent()?");
		return current;
	}

	/**
	 * @param arrayName
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glEnableClientState(int)
	 */
	public void glEnableClientState(int arrayName) {
		getCurrent().glEnableClientState(arrayName);
	}

	/**
	 * @param arrayName
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glDisableClientState(int)
	 */
	public void glDisableClientState(int arrayName) {
		getCurrent().glDisableClientState(arrayName);
	}

	/**
	 * @param array
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glVertexPointer(javax.media.opengl.GLArrayData)
	 */
	public void glVertexPointer(GLArrayData array) {
		getCurrent().glVertexPointer(array);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glVertexPointer(int, int, int, java.nio.Buffer)
	 */
	public void glVertexPointer(int size, int type, int stride, Buffer pointer) {
		getCurrent().glVertexPointer(size, type, stride, pointer);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glVertexPointer(int, int, int, long)
	 */
	public void glVertexPointer(int size, int type, int stride, long pointer_buffer_offset) {
		getCurrent().glVertexPointer(size, type, stride, pointer_buffer_offset);
	}

	/**
	 * @param array
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glColorPointer(javax.media.opengl.GLArrayData)
	 */
	public void glColorPointer(GLArrayData array) {
		getCurrent().glColorPointer(array);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glColorPointer(int, int, int, java.nio.Buffer)
	 */
	public void glColorPointer(int size, int type, int stride, Buffer pointer) {
		getCurrent().glColorPointer(size, type, stride, pointer);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glColorPointer(int, int, int, long)
	 */
	public void glColorPointer(int size, int type, int stride, long pointer_buffer_offset) {
		getCurrent().glColorPointer(size, type, stride, pointer_buffer_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glColor4f(float, float, float, float)
	 */
	public void glColor4f(float red, float green, float blue, float alpha) {
		getCurrent().glColor4f(red, green, blue, alpha);
	}

	/**
	 * @param array
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glNormalPointer(javax.media.opengl.GLArrayData)
	 */
	public void glNormalPointer(GLArrayData array) {
		getCurrent().glNormalPointer(array);
	}

	/**
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glNormalPointer(int, int, java.nio.Buffer)
	 */
	public void glNormalPointer(int type, int stride, Buffer pointer) {
		getCurrent().glNormalPointer(type, stride, pointer);
	}

	/**
	 * @param type
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glNormalPointer(int, int, long)
	 */
	public void glNormalPointer(int type, int stride, long pointer_buffer_offset) {
		getCurrent().glNormalPointer(type, stride, pointer_buffer_offset);
	}

	/**
	 * @param array
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glTexCoordPointer(javax.media.opengl.GLArrayData)
	 */
	public void glTexCoordPointer(GLArrayData array) {
		getCurrent().glTexCoordPointer(array);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glTexCoordPointer(int, int, int, java.nio.Buffer)
	 */
	public void glTexCoordPointer(int size, int type, int stride, Buffer pointer) {
		getCurrent().glTexCoordPointer(size, type, stride, pointer);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.fixedfunc.GLPointerFunc#glTexCoordPointer(int, int, int, long)
	 */
	public void glTexCoordPointer(int size, int type, int stride, long pointer_buffer_offset) {
		getCurrent().glTexCoordPointer(size, type, stride, pointer_buffer_offset);
	}

	/**
	 * @param light
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.fixedfunc.GLLightingFunc#glLightfv(int, int, java.nio.FloatBuffer)
	 */
	public void glLightfv(int light, int pname, FloatBuffer params) {
		getCurrent().glLightfv(light, pname, params);
	}

	/**
	 * @param light
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.fixedfunc.GLLightingFunc#glLightfv(int, int, float[], int)
	 */
	public void glLightfv(int light, int pname, float[] params, int params_offset) {
		getCurrent().glLightfv(light, pname, params, params_offset);
	}

	/**
	 * @param face
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.fixedfunc.GLLightingFunc#glMaterialf(int, int, float)
	 */
	public void glMaterialf(int face, int pname, float param) {
		getCurrent().glMaterialf(face, pname, param);
	}

	/**
	 * @param face
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.fixedfunc.GLLightingFunc#glMaterialfv(int, int, java.nio.FloatBuffer)
	 */
	public void glMaterialfv(int face, int pname, FloatBuffer params) {
		getCurrent().glMaterialfv(face, pname, params);
	}

	/**
	 * @param face
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.fixedfunc.GLLightingFunc#glMaterialfv(int, int, float[], int)
	 */
	public void glMaterialfv(int face, int pname, float[] params, int params_offset) {
		getCurrent().glMaterialfv(face, pname, params, params_offset);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.fixedfunc.GLLightingFunc#glShadeModel(int)
	 */
	public void glShadeModel(int mode) {
		getCurrent().glShadeModel(mode);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glMatrixMode(int)
	 */
	public void glMatrixMode(int mode) {
		getCurrent().glMatrixMode(mode);
	}

	/**
	 * 
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glPushMatrix()
	 */
	public void glPushMatrix() {
		getCurrent().glPushMatrix();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL()
	 */
	public boolean isGL() {
		return getCurrent().isGL();
	}

	/**
	 * 
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glPopMatrix()
	 */
	public void glPopMatrix() {
		getCurrent().glPopMatrix();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL4bc()
	 */
	public boolean isGL4bc() {
		return getCurrent().isGL4bc();
	}

	/**
	 * 
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glLoadIdentity()
	 */
	public void glLoadIdentity() {
		getCurrent().glLoadIdentity();
	}

	/**
	 * @param m
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glLoadMatrixf(java.nio.FloatBuffer)
	 */
	public void glLoadMatrixf(FloatBuffer m) {
		getCurrent().glLoadMatrixf(m);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL4()
	 */
	public boolean isGL4() {
		return getCurrent().isGL4();
	}

	/**
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glLoadMatrixf(float[], int)
	 */
	public void glLoadMatrixf(float[] m, int m_offset) {
		getCurrent().glLoadMatrixf(m, m_offset);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL3bc()
	 */
	public boolean isGL3bc() {
		return getCurrent().isGL3bc();
	}

	/**
	 * @param m
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glMultMatrixf(java.nio.FloatBuffer)
	 */
	public void glMultMatrixf(FloatBuffer m) {
		getCurrent().glMultMatrixf(m);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL3()
	 */
	public boolean isGL3() {
		return getCurrent().isGL3();
	}

	/**
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glMultMatrixf(float[], int)
	 */
	public void glMultMatrixf(float[] m, int m_offset) {
		getCurrent().glMultMatrixf(m, m_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glTranslatef(float, float, float)
	 */
	public void glTranslatef(float x, float y, float z) {
		getCurrent().glTranslatef(x, y, z);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL2()
	 */
	public boolean isGL2() {
		return getCurrent().isGL2();
	}

	/**
	 * @param angle
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glRotatef(float, float, float, float)
	 */
	public void glRotatef(float angle, float x, float y, float z) {
		getCurrent().glRotatef(angle, x, y, z);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glScalef(float, float, float)
	 */
	public void glScalef(float x, float y, float z) {
		getCurrent().glScalef(x, y, z);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGLES1()
	 */
	public boolean isGLES1() {
		return getCurrent().isGLES1();
	}

	/**
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glOrthof(float, float, float, float, float, float)
	 */
	public void glOrthof(float left, float right, float bottom, float top, float zNear, float zFar) {
		getCurrent().glOrthof(left, right, bottom, top, zNear, zFar);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGLES2()
	 */
	public boolean isGLES2() {
		return getCurrent().isGLES2();
	}

	/**
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.fixedfunc.GLMatrixFunc#glFrustumf(float, float, float, float, float, float)
	 */
	public void glFrustumf(float left, float right, float bottom, float top, float zNear, float zFar) {
		getCurrent().glFrustumf(left, right, bottom, top, zNear, zFar);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGLES3()
	 */
	public boolean isGLES3() {
		return getCurrent().isGLES3();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGLES()
	 */
	public boolean isGLES() {
		return getCurrent().isGLES();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL2ES1()
	 */
	public boolean isGL2ES1() {
		return getCurrent().isGL2ES1();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL2ES2()
	 */
	public boolean isGL2ES2() {
		return getCurrent().isGL2ES2();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL3ES3()
	 */
	public boolean isGL3ES3() {
		return getCurrent().isGL3ES3();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL4ES3()
	 */
	public boolean isGL4ES3() {
		return getCurrent().isGL4ES3();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL2GL3()
	 */
	public boolean isGL2GL3() {
		return getCurrent().isGL2GL3();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL4core()
	 */
	public boolean isGL4core() {
		return getCurrent().isGL4core();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGL3core()
	 */
	public boolean isGL3core() {
		return getCurrent().isGL3core();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGLcore()
	 */
	public boolean isGLcore() {
		return getCurrent().isGLcore();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGLES2Compatible()
	 */
	public boolean isGLES2Compatible() {
		return getCurrent().isGLES2Compatible();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isGLES3Compatible()
	 */
	public boolean isGLES3Compatible() {
		return getCurrent().isGLES3Compatible();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#hasGLSL()
	 */
	public boolean hasGLSL() {
		return getCurrent().hasGLSL();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getDownstreamGL()
	 */
	public GL getDownstreamGL() throws GLException {
		return getCurrent().getDownstreamGL();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getRootGL()
	 */
	public GL getRootGL() throws GLException {
		return getCurrent().getRootGL();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL()
	 */
	public GL getGL() throws GLException {
		return getCurrent().getGL();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL4bc()
	 */
	public GL4bc getGL4bc() throws GLException {
		return getCurrent().getGL4bc();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL4()
	 */
	public GL4 getGL4() throws GLException {
		return getCurrent().getGL4();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL3bc()
	 */
	public GL3bc getGL3bc() throws GLException {
		return getCurrent().getGL3bc();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL3()
	 */
	public GL3 getGL3() throws GLException {
		return getCurrent().getGL3();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL2()
	 */
	public GL2 getGL2() throws GLException {
		return getCurrent().getGL2();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGLES1()
	 */
	public GLES1 getGLES1() throws GLException {
		return getCurrent().getGLES1();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGLES2()
	 */
	public GLES2 getGLES2() throws GLException {
		return getCurrent().getGLES2();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGLES3()
	 */
	public GLES3 getGLES3() throws GLException {
		return getCurrent().getGLES3();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL2ES1()
	 */
	public GL2ES1 getGL2ES1() throws GLException {
		return getCurrent().getGL2ES1();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL2ES2()
	 */
	public GL2ES2 getGL2ES2() throws GLException {
		return getCurrent().getGL2ES2();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL3ES3()
	 */
	public GL3ES3 getGL3ES3() throws GLException {
		return getCurrent().getGL3ES3();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL4ES3()
	 */
	public GL4ES3 getGL4ES3() throws GLException {
		return getCurrent().getGL4ES3();
	}

	/**
	 * @return
	 * @throws GLException
	 * @see javax.media.opengl.GLBase#getGL2GL3()
	 */
	public GL2GL3 getGL2GL3() throws GLException {
		return getCurrent().getGL2GL3();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#getGLProfile()
	 */
	public GLProfile getGLProfile() {
		return getCurrent().getGLProfile();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#getContext()
	 */
	public GLContext getContext() {
		return getCurrent().getContext();
	}

	/**
	 * @param glFunctionName
	 * @return
	 * @see javax.media.opengl.GLBase#isFunctionAvailable(java.lang.String)
	 */
	public boolean isFunctionAvailable(String glFunctionName) {
		return getCurrent().isFunctionAvailable(glFunctionName);
	}

	/**
	 * @param glExtensionName
	 * @return
	 * @see javax.media.opengl.GLBase#isExtensionAvailable(java.lang.String)
	 */
	public boolean isExtensionAvailable(String glExtensionName) {
		return getCurrent().isExtensionAvailable(glExtensionName);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#hasBasicFBOSupport()
	 */
	public boolean hasBasicFBOSupport() {
		return getCurrent().hasBasicFBOSupport();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#hasFullFBOSupport()
	 */
	public boolean hasFullFBOSupport() {
		return getCurrent().hasFullFBOSupport();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#getMaxRenderbufferSamples()
	 */
	public int getMaxRenderbufferSamples() {
		return getCurrent().getMaxRenderbufferSamples();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isNPOTTextureAvailable()
	 */
	public boolean isNPOTTextureAvailable() {
		return getCurrent().isNPOTTextureAvailable();
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#isTextureFormatBGRA8888Available()
	 */
	public boolean isTextureFormatBGRA8888Available() {
		return getCurrent().isTextureFormatBGRA8888Available();
	}

	/**
	 * @param interval
	 * @see javax.media.opengl.GLBase#setSwapInterval(int)
	 */
	public void setSwapInterval(int interval) {
		getCurrent().setSwapInterval(interval);
	}

	/**
	 * @param func
	 * @param ref
	 * @see javax.media.opengl.GL2ES1#glAlphaFunc(int, float)
	 */
	public void glAlphaFunc(int func, float ref) {
		getCurrent().glAlphaFunc(func, ref);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#getSwapInterval()
	 */
	public int getSwapInterval() {
		return getCurrent().getSwapInterval();
	}

	/**
	 * @param texture
	 * @see javax.media.opengl.GL2ES1#glClientActiveTexture(int)
	 */
	public void glClientActiveTexture(int texture) {
		getCurrent().glClientActiveTexture(texture);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#getPlatformGLExtensions()
	 */
	public Object getPlatformGLExtensions() {
		return getCurrent().getPlatformGLExtensions();
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2ES1#glColor4ub(byte, byte, byte, byte)
	 */
	public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
		getCurrent().glColor4ub(red, green, blue, alpha);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2ES1#glFogf(int, float)
	 */
	public void glFogf(int pname, float param) {
		getCurrent().glFogf(pname, param);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glFogfv(int, java.nio.FloatBuffer)
	 */
	public void glFogfv(int pname, FloatBuffer params) {
		getCurrent().glFogfv(pname, params);
	}

	/**
	 * @param extensionName
	 * @return
	 * @see javax.media.opengl.GLBase#getExtension(java.lang.String)
	 */
	public Object getExtension(String extensionName) {
		return getCurrent().getExtension(extensionName);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glFogfv(int, float[], int)
	 */
	public void glFogfv(int pname, float[] params, int params_offset) {
		getCurrent().glFogfv(pname, params, params_offset);
	}

	/**
	 * @param light
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glGetLightfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetLightfv(int light, int pname, FloatBuffer params) {
		getCurrent().glGetLightfv(light, pname, params);
	}

	/**
	 * @param light
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glGetLightfv(int, int, float[], int)
	 */
	public void glGetLightfv(int light, int pname, float[] params, int params_offset) {
		getCurrent().glGetLightfv(light, pname, params, params_offset);
	}

	/**
	 * @param depth
	 * @see javax.media.opengl.GLBase#glClearDepth(double)
	 */
	public void glClearDepth(double depth) {
		getCurrent().glClearDepth(depth);
	}

	/**
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.GLBase#glDepthRange(double, double)
	 */
	public void glDepthRange(double zNear, double zFar) {
		getCurrent().glDepthRange(zNear, zFar);
	}

	/**
	 * @param face
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glGetMaterialfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetMaterialfv(int face, int pname, FloatBuffer params) {
		getCurrent().glGetMaterialfv(face, pname, params);
	}

	/**
	 * @param target
	 * @return
	 * @see javax.media.opengl.GLBase#glGetBoundBuffer(int)
	 */
	public int glGetBoundBuffer(int target) {
		return getCurrent().glGetBoundBuffer(target);
	}

	/**
	 * @param face
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glGetMaterialfv(int, int, float[], int)
	 */
	public void glGetMaterialfv(int face, int pname, float[] params, int params_offset) {
		getCurrent().glGetMaterialfv(face, pname, params, params_offset);
	}

	/**
	 * @param buffer
	 * @return
	 * @see javax.media.opengl.GLBase#glGetBufferSize(int)
	 */
	public long glGetBufferSize(int buffer) {
		return getCurrent().glGetBufferSize(buffer);
	}

	/**
	 * @param tenv
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glGetTexEnvfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetTexEnvfv(int tenv, int pname, FloatBuffer params) {
		getCurrent().glGetTexEnvfv(tenv, pname, params);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#glIsVBOArrayEnabled()
	 */
	public boolean glIsVBOArrayEnabled() {
		return getCurrent().glIsVBOArrayEnabled();
	}

	/**
	 * @param tenv
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glGetTexEnvfv(int, int, float[], int)
	 */
	public void glGetTexEnvfv(int tenv, int pname, float[] params, int params_offset) {
		getCurrent().glGetTexEnvfv(tenv, pname, params, params_offset);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#glIsVBOElementArrayEnabled()
	 */
	public boolean glIsVBOElementArrayEnabled() {
		return getCurrent().glIsVBOElementArrayEnabled();
	}

	/**
	 * @param target
	 * @return
	 * @see javax.media.opengl.GLBase#getBoundFramebuffer(int)
	 */
	public int getBoundFramebuffer(int target) {
		return getCurrent().getBoundFramebuffer(target);
	}

	/**
	 * @param tenv
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glGetTexEnviv(int, int, java.nio.IntBuffer)
	 */
	public void glGetTexEnviv(int tenv, int pname, IntBuffer params) {
		getCurrent().glGetTexEnviv(tenv, pname, params);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#getDefaultDrawFramebuffer()
	 */
	public int getDefaultDrawFramebuffer() {
		return getCurrent().getDefaultDrawFramebuffer();
	}

	/**
	 * @param tenv
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glGetTexEnviv(int, int, int[], int)
	 */
	public void glGetTexEnviv(int tenv, int pname, int[] params, int params_offset) {
		getCurrent().glGetTexEnviv(tenv, pname, params, params_offset);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#getDefaultReadFramebuffer()
	 */
	public int getDefaultReadFramebuffer() {
		return getCurrent().getDefaultReadFramebuffer();
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glGetTexGenfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetTexGenfv(int coord, int pname, FloatBuffer params) {
		getCurrent().glGetTexGenfv(coord, pname, params);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GLBase#getDefaultReadBuffer()
	 */
	public int getDefaultReadBuffer() {
		return getCurrent().getDefaultReadBuffer();
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glGetTexGenfv(int, int, float[], int)
	 */
	public void glGetTexGenfv(int coord, int pname, float[] params, int params_offset) {
		getCurrent().glGetTexGenfv(coord, pname, params, params_offset);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glGetTexGeniv(int, int, java.nio.IntBuffer)
	 */
	public void glGetTexGeniv(int coord, int pname, IntBuffer params) {
		getCurrent().glGetTexGeniv(coord, pname, params);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glGetTexGeniv(int, int, int[], int)
	 */
	public void glGetTexGeniv(int coord, int pname, int[] params, int params_offset) {
		getCurrent().glGetTexGeniv(coord, pname, params, params_offset);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2ES1#glLightModelf(int, float)
	 */
	public void glLightModelf(int pname, float param) {
		getCurrent().glLightModelf(pname, param);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glLightModelfv(int, java.nio.FloatBuffer)
	 */
	public void glLightModelfv(int pname, FloatBuffer params) {
		getCurrent().glLightModelfv(pname, params);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glLightModelfv(int, float[], int)
	 */
	public void glLightModelfv(int pname, float[] params, int params_offset) {
		getCurrent().glLightModelfv(pname, params, params_offset);
	}

	/**
	 * @param light
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2ES1#glLightf(int, int, float)
	 */
	public void glLightf(int light, int pname, float param) {
		getCurrent().glLightf(light, pname, param);
	}

	/**
	 * @param opcode
	 * @see javax.media.opengl.GL2ES1#glLogicOp(int)
	 */
	public void glLogicOp(int opcode) {
		getCurrent().glLogicOp(opcode);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2ES1#glMultiTexCoord4f(int, float, float, float, float)
	 */
	public void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
		getCurrent().glMultiTexCoord4f(target, s, t, r, q);
	}

	/**
	 * @param nx
	 * @param ny
	 * @param nz
	 * @see javax.media.opengl.GL2ES1#glNormal3f(float, float, float)
	 */
	public void glNormal3f(float nx, float ny, float nz) {
		getCurrent().glNormal3f(nx, ny, nz);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2ES1#glPointParameterf(int, float)
	 */
	public void glPointParameterf(int pname, float param) {
		getCurrent().glPointParameterf(pname, param);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glPointParameterfv(int, java.nio.FloatBuffer)
	 */
	public void glPointParameterfv(int pname, FloatBuffer params) {
		getCurrent().glPointParameterfv(pname, params);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glPointParameterfv(int, float[], int)
	 */
	public void glPointParameterfv(int pname, float[] params, int params_offset) {
		getCurrent().glPointParameterfv(pname, params, params_offset);
	}

	/**
	 * @param size
	 * @see javax.media.opengl.GL2ES1#glPointSize(float)
	 */
	public void glPointSize(float size) {
		getCurrent().glPointSize(size);
	}

	/**
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2ES1#glTexEnvf(int, int, float)
	 */
	public void glTexEnvf(int target, int pname, float param) {
		getCurrent().glTexEnvf(target, pname, param);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glTexEnvfv(int, int, java.nio.FloatBuffer)
	 */
	public void glTexEnvfv(int target, int pname, FloatBuffer params) {
		getCurrent().glTexEnvfv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glTexEnvfv(int, int, float[], int)
	 */
	public void glTexEnvfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glTexEnvfv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2ES1#glTexEnvi(int, int, int)
	 */
	public void glTexEnvi(int target, int pname, int param) {
		getCurrent().glTexEnvi(target, pname, param);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glTexEnviv(int, int, java.nio.IntBuffer)
	 */
	public void glTexEnviv(int target, int pname, IntBuffer params) {
		getCurrent().glTexEnviv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glTexEnviv(int, int, int[], int)
	 */
	public void glTexEnviv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glTexEnviv(target, pname, params, params_offset);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2ES1#glTexGenf(int, int, float)
	 */
	public void glTexGenf(int coord, int pname, float param) {
		getCurrent().glTexGenf(coord, pname, param);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glTexGenfv(int, int, java.nio.FloatBuffer)
	 */
	public void glTexGenfv(int coord, int pname, FloatBuffer params) {
		getCurrent().glTexGenfv(coord, pname, params);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glTexGenfv(int, int, float[], int)
	 */
	public void glTexGenfv(int coord, int pname, float[] params, int params_offset) {
		getCurrent().glTexGenfv(coord, pname, params, params_offset);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2ES1#glTexGeni(int, int, int)
	 */
	public void glTexGeni(int coord, int pname, int param) {
		getCurrent().glTexGeni(coord, pname, param);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES1#glTexGeniv(int, int, java.nio.IntBuffer)
	 */
	public void glTexGeniv(int coord, int pname, IntBuffer params) {
		getCurrent().glTexGeniv(coord, pname, params);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES1#glTexGeniv(int, int, int[], int)
	 */
	public void glTexGeniv(int coord, int pname, int[] params, int params_offset) {
		getCurrent().glTexGeniv(coord, pname, params, params_offset);
	}

	/**
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @param near_val
	 * @param far_val
	 * @see javax.media.opengl.GL2ES1#glOrtho(double, double, double, double, double, double)
	 */
	public void glOrtho(double left, double right, double bottom, double top, double near_val, double far_val) {
		getCurrent().glOrtho(left, right, bottom, top, near_val, far_val);
	}

	/**
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.GL2ES1#glFrustum(double, double, double, double, double, double)
	 */
	public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
		getCurrent().glFrustum(left, right, bottom, top, zNear, zFar);
	}

	/**
	 * @param id
	 * @param mode
	 * @see javax.media.opengl.GL2GL3#glBeginConditionalRender(int, int)
	 */
	public void glBeginConditionalRender(int id, int mode) {
		getCurrent().glBeginConditionalRender(id, mode);
	}

	/**
	 * @param program
	 * @param color
	 * @param name
	 * @see javax.media.opengl.GL2GL3#glBindFragDataLocation(int, int, java.lang.String)
	 */
	public void glBindFragDataLocation(int program, int color, String name) {
		getCurrent().glBindFragDataLocation(program, color, name);
	}

	/**
	 * @param pname
	 * @param index
	 * @param address
	 * @param length
	 * @see javax.media.opengl.GL2GL3#glBufferAddressRangeNV(int, int, long, long)
	 */
	public void glBufferAddressRangeNV(int pname, int index, long address, long length) {
		getCurrent().glBufferAddressRangeNV(pname, index, address, length);
	}

	/**
	 * @param target
	 * @param clamp
	 * @see javax.media.opengl.GL2GL3#glClampColor(int, int)
	 */
	public void glClampColor(int target, int clamp) {
		getCurrent().glClampColor(target, clamp);
	}

	/**
	 * @param buffer
	 * @param internalformat
	 * @param format
	 * @param type
	 * @param data
	 * @see javax.media.opengl.GL2GL3#glClearNamedBufferDataEXT(int, int, int, int, java.nio.Buffer)
	 */
	public void glClearNamedBufferDataEXT(int buffer, int internalformat, int format, int type, Buffer data) {
		getCurrent().glClearNamedBufferDataEXT(buffer, internalformat, format, type, data);
	}

	/**
	 * @param program
	 * @param shader
	 * @see javax.media.opengl.GL2ES2#glAttachShader(int, int)
	 */
	public void glAttachShader(int program, int shader) {
		getCurrent().glAttachShader(program, shader);
	}

	/**
	 * @param target
	 * @param id
	 * @see javax.media.opengl.GL2ES2#glBeginQuery(int, int)
	 */
	public void glBeginQuery(int target, int id) {
		getCurrent().glBeginQuery(target, id);
	}

	/**
	 * @param buffer
	 * @param internalformat
	 * @param format
	 * @param type
	 * @param offset
	 * @param size
	 * @param data
	 * @see javax.media.opengl.GL2GL3#glClearNamedBufferSubDataEXT(int, int, int, int, long, long, java.nio.Buffer)
	 */
	public void glClearNamedBufferSubDataEXT(int buffer, int internalformat, int format, int type, long offset, long size, Buffer data) {
		getCurrent().glClearNamedBufferSubDataEXT(buffer, internalformat, format, type, offset, size, data);
	}

	/**
	 * @param program
	 * @param index
	 * @param name
	 * @see javax.media.opengl.GL2ES2#glBindAttribLocation(int, int, java.lang.String)
	 */
	public void glBindAttribLocation(int program, int index, String name) {
		getCurrent().glBindAttribLocation(program, index, name);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glColorFormatNV(int, int, int)
	 */
	public void glColorFormatNV(int size, int type, int stride) {
		getCurrent().glColorFormatNV(size, type, stride);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2ES2#glBlendColor(float, float, float, float)
	 */
	public void glBlendColor(float red, float green, float blue, float alpha) {
		getCurrent().glBlendColor(red, green, blue, alpha);
	}

	/**
	 * @param index
	 * @param r
	 * @param g
	 * @param b
	 * @param a
	 * @see javax.media.opengl.GL2GL3#glColorMaski(int, boolean, boolean, boolean, boolean)
	 */
	public void glColorMaski(int index, boolean r, boolean g, boolean b, boolean a) {
		getCurrent().glColorMaski(index, r, g, b, a);
	}

	/**
	 * @param shader
	 * @see javax.media.opengl.GL2ES2#glCompileShader(int)
	 */
	public void glCompileShader(int shader) {
		getCurrent().glCompileShader(shader);
	}

	/**
	 * @param shader
	 * @param count
	 * @param path
	 * @param length
	 * @see javax.media.opengl.GL2GL3#glCompileShaderIncludeARB(int, int, java.lang.String[], java.nio.IntBuffer)
	 */
	public void glCompileShaderIncludeARB(int shader, int count, String[] path, IntBuffer length) {
		getCurrent().glCompileShaderIncludeARB(shader, count, path, length);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @param border
	 * @param imageSize
	 * @param data
	 * @see javax.media.opengl.GL2ES2#glCompressedTexImage3D(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Buffer data) {
		getCurrent().glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
	}

	/**
	 * @param shader
	 * @param count
	 * @param path
	 * @param length
	 * @param length_offset
	 * @see javax.media.opengl.GL2GL3#glCompileShaderIncludeARB(int, int, java.lang.String[], int[], int)
	 */
	public void glCompileShaderIncludeARB(int shader, int count, String[] path, int[] length, int length_offset) {
		getCurrent().glCompileShaderIncludeARB(shader, count, path, length, length_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @param border
	 * @param imageSize
	 * @param data_buffer_offset
	 * @see javax.media.opengl.GL2ES2#glCompressedTexImage3D(int, int, int, int, int, int, int, int, long)
	 */
	public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, long data_buffer_offset) {
		getCurrent().glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data_buffer_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param border
	 * @param imageSize
	 * @param data
	 * @see javax.media.opengl.GL2GL3#glCompressedTexImage1D(int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, Buffer data) {
		getCurrent().glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param border
	 * @param imageSize
	 * @param data_buffer_offset
	 * @see javax.media.opengl.GL2GL3#glCompressedTexImage1D(int, int, int, int, int, int, long)
	 */
	public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, long data_buffer_offset) {
		getCurrent().glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data_buffer_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param imageSize
	 * @param data
	 * @see javax.media.opengl.GL2ES2#glCompressedTexSubImage3D(int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Buffer data) {
		getCurrent().glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param width
	 * @param format
	 * @param imageSize
	 * @param data
	 * @see javax.media.opengl.GL2GL3#glCompressedTexSubImage1D(int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, Buffer data) {
		getCurrent().glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param imageSize
	 * @param data_buffer_offset
	 * @see javax.media.opengl.GL2ES2#glCompressedTexSubImage3D(int, int, int, int, int, int, int, int, int, int, long)
	 */
	public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data_buffer_offset) {
		getCurrent().glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data_buffer_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param width
	 * @param format
	 * @param imageSize
	 * @param data_buffer_offset
	 * @see javax.media.opengl.GL2GL3#glCompressedTexSubImage1D(int, int, int, int, int, int, long)
	 */
	public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, long data_buffer_offset) {
		getCurrent().glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data_buffer_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2ES2#glCopyTexSubImage3D(int, int, int, int, int, int, int, int, int)
	 */
	public void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
		getCurrent().glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @param border
	 * @see javax.media.opengl.GL2GL3#glCopyTexImage1D(int, int, int, int, int, int, int)
	 */
	public void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border) {
		getCurrent().glCopyTexImage1D(target, level, internalformat, x, y, width, border);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param x
	 * @param y
	 * @param width
	 * @see javax.media.opengl.GL2GL3#glCopyTexSubImage1D(int, int, int, int, int, int)
	 */
	public void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width) {
		getCurrent().glCopyTexSubImage1D(target, level, xoffset, x, y, width);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GL2ES2#glCreateProgram()
	 */
	public int glCreateProgram() {
		return getCurrent().glCreateProgram();
	}

	/**
	 * @param type
	 * @return
	 * @see javax.media.opengl.GL2ES2#glCreateShader(int)
	 */
	public int glCreateShader(int type) {
		return getCurrent().glCreateShader(type);
	}

	/**
	 * @param context
	 * @param event
	 * @param flags
	 * @return
	 * @see javax.media.opengl.GL2GL3#glCreateSyncFromCLeventARB(long, long, int)
	 */
	public long glCreateSyncFromCLeventARB(long context, long event, int flags) {
		return getCurrent().glCreateSyncFromCLeventARB(context, event, flags);
	}

	/**
	 * @param source
	 * @param type
	 * @param severity
	 * @param count
	 * @param ids
	 * @param enabled
	 * @see javax.media.opengl.GL2ES2#glDebugMessageControl(int, int, int, int, java.nio.IntBuffer, boolean)
	 */
	public void glDebugMessageControl(int source, int type, int severity, int count, IntBuffer ids, boolean enabled) {
		getCurrent().glDebugMessageControl(source, type, severity, count, ids, enabled);
	}

	/**
	 * @param category
	 * @param severity
	 * @param count
	 * @param ids
	 * @param enabled
	 * @see javax.media.opengl.GL2GL3#glDebugMessageEnableAMD(int, int, int, java.nio.IntBuffer, boolean)
	 */
	public void glDebugMessageEnableAMD(int category, int severity, int count, IntBuffer ids, boolean enabled) {
		getCurrent().glDebugMessageEnableAMD(category, severity, count, ids, enabled);
	}

	/**
	 * @param source
	 * @param type
	 * @param severity
	 * @param count
	 * @param ids
	 * @param ids_offset
	 * @param enabled
	 * @see javax.media.opengl.GL2ES2#glDebugMessageControl(int, int, int, int, int[], int, boolean)
	 */
	public void glDebugMessageControl(int source, int type, int severity, int count, int[] ids, int ids_offset, boolean enabled) {
		getCurrent().glDebugMessageControl(source, type, severity, count, ids, ids_offset, enabled);
	}

	/**
	 * @param category
	 * @param severity
	 * @param count
	 * @param ids
	 * @param ids_offset
	 * @param enabled
	 * @see javax.media.opengl.GL2GL3#glDebugMessageEnableAMD(int, int, int, int[], int, boolean)
	 */
	public void glDebugMessageEnableAMD(int category, int severity, int count, int[] ids, int ids_offset, boolean enabled) {
		getCurrent().glDebugMessageEnableAMD(category, severity, count, ids, ids_offset, enabled);
	}

	/**
	 * @param category
	 * @param severity
	 * @param id
	 * @param length
	 * @param buf
	 * @see javax.media.opengl.GL2GL3#glDebugMessageInsertAMD(int, int, int, int, java.lang.String)
	 */
	public void glDebugMessageInsertAMD(int category, int severity, int id, int length, String buf) {
		getCurrent().glDebugMessageInsertAMD(category, severity, id, length, buf);
	}

	/**
	 * @param source
	 * @param type
	 * @param id
	 * @param severity
	 * @param length
	 * @param buf
	 * @see javax.media.opengl.GL2ES2#glDebugMessageInsert(int, int, int, int, int, java.lang.String)
	 */
	public void glDebugMessageInsert(int source, int type, int id, int severity, int length, String buf) {
		getCurrent().glDebugMessageInsert(source, type, id, severity, length, buf);
	}

	/**
	 * @param namelen
	 * @param name
	 * @see javax.media.opengl.GL2GL3#glDeleteNamedStringARB(int, java.lang.String)
	 */
	public void glDeleteNamedStringARB(int namelen, String name) {
		getCurrent().glDeleteNamedStringARB(namelen, name);
	}

	/**
	 * @param program
	 * @see javax.media.opengl.GL2ES2#glDeleteProgram(int)
	 */
	public void glDeleteProgram(int program) {
		getCurrent().glDeleteProgram(program);
	}

	/**
	 * @param n
	 * @param ids
	 * @see javax.media.opengl.GL2ES2#glDeleteQueries(int, java.nio.IntBuffer)
	 */
	public void glDeleteQueries(int n, IntBuffer ids) {
		getCurrent().glDeleteQueries(n, ids);
	}

	/**
	 * @param target
	 * @param index
	 * @see javax.media.opengl.GL2GL3#glDisablei(int, int)
	 */
	public void glDisablei(int target, int index) {
		getCurrent().glDisablei(target, index);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2GL3#glDrawBuffer(int)
	 */
	public void glDrawBuffer(int mode) {
		getCurrent().glDrawBuffer(mode);
	}

	/**
	 * @param n
	 * @param ids
	 * @param ids_offset
	 * @see javax.media.opengl.GL2ES2#glDeleteQueries(int, int[], int)
	 */
	public void glDeleteQueries(int n, int[] ids, int ids_offset) {
		getCurrent().glDeleteQueries(n, ids, ids_offset);
	}

	/**
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glEdgeFlagFormatNV(int)
	 */
	public void glEdgeFlagFormatNV(int stride) {
		getCurrent().glEdgeFlagFormatNV(stride);
	}

	/**
	 * @param shader
	 * @see javax.media.opengl.GL2ES2#glDeleteShader(int)
	 */
	public void glDeleteShader(int shader) {
		getCurrent().glDeleteShader(shader);
	}

	/**
	 * @param program
	 * @param shader
	 * @see javax.media.opengl.GL2ES2#glDetachShader(int, int)
	 */
	public void glDetachShader(int program, int shader) {
		getCurrent().glDetachShader(program, shader);
	}

	/**
	 * @param target
	 * @param index
	 * @see javax.media.opengl.GL2GL3#glEnablei(int, int)
	 */
	public void glEnablei(int target, int index) {
		getCurrent().glEnablei(target, index);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2GL3#glEndConditionalRender()
	 */
	public void glEndConditionalRender() {
		getCurrent().glEndConditionalRender();
	}

	/**
	 * @param index
	 * @see javax.media.opengl.GL2ES2#glDisableVertexAttribArray(int)
	 */
	public void glDisableVertexAttribArray(int index) {
		getCurrent().glDisableVertexAttribArray(index);
	}

	/**
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glFogCoordFormatNV(int, int)
	 */
	public void glFogCoordFormatNV(int type, int stride) {
		getCurrent().glFogCoordFormatNV(type, stride);
	}

	/**
	 * @param index
	 * @see javax.media.opengl.GL2ES2#glEnableVertexAttribArray(int)
	 */
	public void glEnableVertexAttribArray(int index) {
		getCurrent().glEnableVertexAttribArray(index);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param textarget
	 * @param texture
	 * @param level
	 * @see javax.media.opengl.GL2GL3#glFramebufferTexture1D(int, int, int, int, int)
	 */
	public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
		getCurrent().glFramebufferTexture1D(target, attachment, textarget, texture, level);
	}

	/**
	 * @param target
	 * @see javax.media.opengl.GL2ES2#glEndQuery(int)
	 */
	public void glEndQuery(int target) {
		getCurrent().glEndQuery(target);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param textarget
	 * @param texture
	 * @param level
	 * @param zoffset
	 * @see javax.media.opengl.GL2ES2#glFramebufferTexture3D(int, int, int, int, int, int)
	 */
	public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
		getCurrent().glFramebufferTexture3D(target, attachment, textarget, texture, level, zoffset);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param texture
	 * @param level
	 * @see javax.media.opengl.GL2GL3#glFramebufferTextureARB(int, int, int, int)
	 */
	public void glFramebufferTextureARB(int target, int attachment, int texture, int level) {
		getCurrent().glFramebufferTextureARB(target, attachment, texture, level);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param texture
	 * @param level
	 * @param face
	 * @see javax.media.opengl.GL2GL3#glFramebufferTextureFaceARB(int, int, int, int, int)
	 */
	public void glFramebufferTextureFaceARB(int target, int attachment, int texture, int level, int face) {
		getCurrent().glFramebufferTextureFaceARB(target, attachment, texture, level, face);
	}

	/**
	 * @param n
	 * @param ids
	 * @see javax.media.opengl.GL2ES2#glGenQueries(int, java.nio.IntBuffer)
	 */
	public void glGenQueries(int n, IntBuffer ids) {
		getCurrent().glGenQueries(n, ids);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param texture
	 * @param level
	 * @param layer
	 * @see javax.media.opengl.GL2GL3#glFramebufferTextureLayerARB(int, int, int, int, int)
	 */
	public void glFramebufferTextureLayerARB(int target, int attachment, int texture, int level, int layer) {
		getCurrent().glFramebufferTextureLayerARB(target, attachment, texture, level, layer);
	}

	/**
	 * @param n
	 * @param ids
	 * @param ids_offset
	 * @see javax.media.opengl.GL2ES2#glGenQueries(int, int[], int)
	 */
	public void glGenQueries(int n, int[] ids, int ids_offset) {
		getCurrent().glGenQueries(n, ids, ids_offset);
	}

	/**
	 * @param program
	 * @param uniformIndex
	 * @param bufSize
	 * @param length
	 * @param uniformName
	 * @see javax.media.opengl.GL2GL3#glGetActiveUniformName(int, int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, IntBuffer length, ByteBuffer uniformName) {
		getCurrent().glGetActiveUniformName(program, uniformIndex, bufSize, length, uniformName);
	}

	/**
	 * @param program
	 * @param index
	 * @param bufsize
	 * @param length
	 * @param size
	 * @param type
	 * @param name
	 * @see javax.media.opengl.GL2ES2#glGetActiveAttrib(int, int, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetActiveAttrib(int program, int index, int bufsize, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		getCurrent().glGetActiveAttrib(program, index, bufsize, length, size, type, name);
	}

	/**
	 * @param program
	 * @param uniformIndex
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param uniformName
	 * @param uniformName_offset
	 * @see javax.media.opengl.GL2GL3#glGetActiveUniformName(int, int, int, int[], int, byte[], int)
	 */
	public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, int[] length, int length_offset, byte[] uniformName, int uniformName_offset) {
		getCurrent().glGetActiveUniformName(program, uniformIndex, bufSize, length, length_offset, uniformName, uniformName_offset);
	}

	/**
	 * @param program
	 * @param index
	 * @param bufsize
	 * @param length
	 * @param length_offset
	 * @param size
	 * @param size_offset
	 * @param type
	 * @param type_offset
	 * @param name
	 * @param name_offset
	 * @see javax.media.opengl.GL2ES2#glGetActiveAttrib(int, int, int, int[], int, int[], int, int[], int, byte[], int)
	 */
	public void glGetActiveAttrib(int program, int index, int bufsize, int[] length, int length_offset, int[] size, int size_offset, int[] type, int type_offset, byte[] name, int name_offset) {
		getCurrent().glGetActiveAttrib(program, index, bufsize, length, length_offset, size, size_offset, type, type_offset, name, name_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @see javax.media.opengl.GL2GL3#glGetBooleani_v(int, int, java.nio.ByteBuffer)
	 */
	public void glGetBooleani_v(int target, int index, ByteBuffer data) {
		getCurrent().glGetBooleani_v(target, index, data);
	}

	/**
	 * @param program
	 * @param index
	 * @param bufsize
	 * @param length
	 * @param size
	 * @param type
	 * @param name
	 * @see javax.media.opengl.GL2ES2#glGetActiveUniform(int, int, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetActiveUniform(int program, int index, int bufsize, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		getCurrent().glGetActiveUniform(program, index, bufsize, length, size, type, name);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2GL3#glGetBooleani_v(int, int, byte[], int)
	 */
	public void glGetBooleani_v(int target, int index, byte[] data, int data_offset) {
		getCurrent().glGetBooleani_v(target, index, data, data_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetBufferParameterui64vNV(int, int, java.nio.LongBuffer)
	 */
	public void glGetBufferParameterui64vNV(int target, int pname, LongBuffer params) {
		getCurrent().glGetBufferParameterui64vNV(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetBufferParameterui64vNV(int, int, long[], int)
	 */
	public void glGetBufferParameterui64vNV(int target, int pname, long[] params, int params_offset) {
		getCurrent().glGetBufferParameterui64vNV(target, pname, params, params_offset);
	}

	/**
	 * @param program
	 * @param index
	 * @param bufsize
	 * @param length
	 * @param length_offset
	 * @param size
	 * @param size_offset
	 * @param type
	 * @param type_offset
	 * @param name
	 * @param name_offset
	 * @see javax.media.opengl.GL2ES2#glGetActiveUniform(int, int, int, int[], int, int[], int, int[], int, byte[], int)
	 */
	public void glGetActiveUniform(int program, int index, int bufsize, int[] length, int length_offset, int[] size, int size_offset, int[] type, int type_offset, byte[] name, int name_offset) {
		getCurrent().glGetActiveUniform(program, index, bufsize, length, length_offset, size, size_offset, type, type_offset, name, name_offset);
	}

	/**
	 * @param target
	 * @param offset
	 * @param size
	 * @param data
	 * @see javax.media.opengl.GL2GL3#glGetBufferSubData(int, long, long, java.nio.Buffer)
	 */
	public void glGetBufferSubData(int target, long offset, long size, Buffer data) {
		getCurrent().glGetBufferSubData(target, offset, size, data);
	}

	/**
	 * @param program
	 * @param maxcount
	 * @param count
	 * @param shaders
	 * @see javax.media.opengl.GL2ES2#glGetAttachedShaders(int, int, java.nio.IntBuffer, java.nio.IntBuffer)
	 */
	public void glGetAttachedShaders(int program, int maxcount, IntBuffer count, IntBuffer shaders) {
		getCurrent().glGetAttachedShaders(program, maxcount, count, shaders);
	}

	/**
	 * @param target
	 * @param level
	 * @param img
	 * @see javax.media.opengl.GL2GL3#glGetCompressedTexImage(int, int, java.nio.Buffer)
	 */
	public void glGetCompressedTexImage(int target, int level, Buffer img) {
		getCurrent().glGetCompressedTexImage(target, level, img);
	}

	/**
	 * @param target
	 * @param level
	 * @param img_buffer_offset
	 * @see javax.media.opengl.GL2GL3#glGetCompressedTexImage(int, int, long)
	 */
	public void glGetCompressedTexImage(int target, int level, long img_buffer_offset) {
		getCurrent().glGetCompressedTexImage(target, level, img_buffer_offset);
	}

	/**
	 * @param program
	 * @param maxcount
	 * @param count
	 * @param count_offset
	 * @param shaders
	 * @param shaders_offset
	 * @see javax.media.opengl.GL2ES2#glGetAttachedShaders(int, int, int[], int, int[], int)
	 */
	public void glGetAttachedShaders(int program, int maxcount, int[] count, int count_offset, int[] shaders, int shaders_offset) {
		getCurrent().glGetAttachedShaders(program, maxcount, count, count_offset, shaders, shaders_offset);
	}

	/**
	 * @param count
	 * @param bufsize
	 * @param categories
	 * @param severities
	 * @param ids
	 * @param lengths
	 * @param message
	 * @return
	 * @see javax.media.opengl.GL2GL3#glGetDebugMessageLogAMD(int, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public int glGetDebugMessageLogAMD(int count, int bufsize, IntBuffer categories, IntBuffer severities, IntBuffer ids, IntBuffer lengths, ByteBuffer message) {
		return getCurrent().glGetDebugMessageLogAMD(count, bufsize, categories, severities, ids, lengths, message);
	}

	/**
	 * @param program
	 * @param name
	 * @return
	 * @see javax.media.opengl.GL2ES2#glGetAttribLocation(int, java.lang.String)
	 */
	public int glGetAttribLocation(int program, String name) {
		return getCurrent().glGetAttribLocation(program, name);
	}

	/**
	 * @param count
	 * @param bufsize
	 * @param sources
	 * @param types
	 * @param ids
	 * @param severities
	 * @param lengths
	 * @param messageLog
	 * @return
	 * @see javax.media.opengl.GL2ES2#glGetDebugMessageLog(int, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public int glGetDebugMessageLog(int count, int bufsize, IntBuffer sources, IntBuffer types, IntBuffer ids, IntBuffer severities, IntBuffer lengths, ByteBuffer messageLog) {
		return getCurrent().glGetDebugMessageLog(count, bufsize, sources, types, ids, severities, lengths, messageLog);
	}

	/**
	 * @param count
	 * @param bufsize
	 * @param categories
	 * @param categories_offset
	 * @param severities
	 * @param severities_offset
	 * @param ids
	 * @param ids_offset
	 * @param lengths
	 * @param lengths_offset
	 * @param message
	 * @param message_offset
	 * @return
	 * @see javax.media.opengl.GL2GL3#glGetDebugMessageLogAMD(int, int, int[], int, int[], int, int[], int, int[], int, byte[], int)
	 */
	public int glGetDebugMessageLogAMD(int count, int bufsize, int[] categories, int categories_offset, int[] severities, int severities_offset, int[] ids, int ids_offset, int[] lengths, int lengths_offset, byte[] message, int message_offset) {
		return getCurrent().glGetDebugMessageLogAMD(count, bufsize, categories, categories_offset, severities, severities_offset, ids, ids_offset, lengths, lengths_offset, message, message_offset);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetDoublev(int, java.nio.DoubleBuffer)
	 */
	public void glGetDoublev(int pname, DoubleBuffer params) {
		getCurrent().glGetDoublev(pname, params);
	}

	/**
	 * @param count
	 * @param bufsize
	 * @param sources
	 * @param sources_offset
	 * @param types
	 * @param types_offset
	 * @param ids
	 * @param ids_offset
	 * @param severities
	 * @param severities_offset
	 * @param lengths
	 * @param lengths_offset
	 * @param messageLog
	 * @param messageLog_offset
	 * @return
	 * @see javax.media.opengl.GL2ES2#glGetDebugMessageLog(int, int, int[], int, int[], int, int[], int, int[], int, int[], int, byte[], int)
	 */
	public int glGetDebugMessageLog(int count, int bufsize, int[] sources, int sources_offset, int[] types, int types_offset, int[] ids, int ids_offset, int[] severities, int severities_offset, int[] lengths, int lengths_offset, byte[] messageLog, int messageLog_offset) {
		return getCurrent().glGetDebugMessageLog(count, bufsize, sources, sources_offset, types, types_offset, ids, ids_offset, severities, severities_offset, lengths, lengths_offset, messageLog, messageLog_offset);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetDoublev(int, double[], int)
	 */
	public void glGetDoublev(int pname, double[] params, int params_offset) {
		getCurrent().glGetDoublev(pname, params, params_offset);
	}

	/**
	 * @param value
	 * @param index
	 * @param result
	 * @see javax.media.opengl.GL2GL3#glGetIntegerui64i_vNV(int, int, java.nio.LongBuffer)
	 */
	public void glGetIntegerui64i_vNV(int value, int index, LongBuffer result) {
		getCurrent().glGetIntegerui64i_vNV(value, index, result);
	}

	/**
	 * @param identifier
	 * @param name
	 * @param bufSize
	 * @param length
	 * @param label
	 * @see javax.media.opengl.GL2ES2#glGetObjectLabel(int, int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetObjectLabel(int identifier, int name, int bufSize, IntBuffer length, ByteBuffer label) {
		getCurrent().glGetObjectLabel(identifier, name, bufSize, length, label);
	}

	/**
	 * @param value
	 * @param index
	 * @param result
	 * @param result_offset
	 * @see javax.media.opengl.GL2GL3#glGetIntegerui64i_vNV(int, int, long[], int)
	 */
	public void glGetIntegerui64i_vNV(int value, int index, long[] result, int result_offset) {
		getCurrent().glGetIntegerui64i_vNV(value, index, result, result_offset);
	}

	/**
	 * @param value
	 * @param result
	 * @see javax.media.opengl.GL2GL3#glGetIntegerui64vNV(int, java.nio.LongBuffer)
	 */
	public void glGetIntegerui64vNV(int value, LongBuffer result) {
		getCurrent().glGetIntegerui64vNV(value, result);
	}

	/**
	 * @param identifier
	 * @param name
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param label
	 * @param label_offset
	 * @see javax.media.opengl.GL2ES2#glGetObjectLabel(int, int, int, int[], int, byte[], int)
	 */
	public void glGetObjectLabel(int identifier, int name, int bufSize, int[] length, int length_offset, byte[] label, int label_offset) {
		getCurrent().glGetObjectLabel(identifier, name, bufSize, length, length_offset, label, label_offset);
	}

	/**
	 * @param value
	 * @param result
	 * @param result_offset
	 * @see javax.media.opengl.GL2GL3#glGetIntegerui64vNV(int, long[], int)
	 */
	public void glGetIntegerui64vNV(int value, long[] result, int result_offset) {
		getCurrent().glGetIntegerui64vNV(value, result, result_offset);
	}

	/**
	 * @param ptr
	 * @param bufSize
	 * @param length
	 * @param label
	 * @see javax.media.opengl.GL2ES2#glGetObjectPtrLabel(java.nio.Buffer, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetObjectPtrLabel(Buffer ptr, int bufSize, IntBuffer length, ByteBuffer label) {
		getCurrent().glGetObjectPtrLabel(ptr, bufSize, length, label);
	}

	/**
	 * @param buffer
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetNamedBufferParameterui64vNV(int, int, java.nio.LongBuffer)
	 */
	public void glGetNamedBufferParameterui64vNV(int buffer, int pname, LongBuffer params) {
		getCurrent().glGetNamedBufferParameterui64vNV(buffer, pname, params);
	}

	/**
	 * @param buffer
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetNamedBufferParameterui64vNV(int, int, long[], int)
	 */
	public void glGetNamedBufferParameterui64vNV(int buffer, int pname, long[] params, int params_offset) {
		getCurrent().glGetNamedBufferParameterui64vNV(buffer, pname, params, params_offset);
	}

	/**
	 * @param ptr
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param label
	 * @param label_offset
	 * @see javax.media.opengl.GL2ES2#glGetObjectPtrLabel(java.nio.Buffer, int, int[], int, byte[], int)
	 */
	public void glGetObjectPtrLabel(Buffer ptr, int bufSize, int[] length, int length_offset, byte[] label, int label_offset) {
		getCurrent().glGetObjectPtrLabel(ptr, bufSize, length, length_offset, label, label_offset);
	}

	/**
	 * @param framebuffer
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetNamedFramebufferParameterivEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetNamedFramebufferParameterivEXT(int framebuffer, int pname, IntBuffer params) {
		getCurrent().glGetNamedFramebufferParameterivEXT(framebuffer, pname, params);
	}

	/**
	 * @param program
	 * @param bufSize
	 * @param length
	 * @param binaryFormat
	 * @param binary
	 * @see javax.media.opengl.GL2ES2#glGetProgramBinary(int, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.Buffer)
	 */
	public void glGetProgramBinary(int program, int bufSize, IntBuffer length, IntBuffer binaryFormat, Buffer binary) {
		getCurrent().glGetProgramBinary(program, bufSize, length, binaryFormat, binary);
	}

	/**
	 * @param framebuffer
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetNamedFramebufferParameterivEXT(int, int, int[], int)
	 */
	public void glGetNamedFramebufferParameterivEXT(int framebuffer, int pname, int[] params, int params_offset) {
		getCurrent().glGetNamedFramebufferParameterivEXT(framebuffer, pname, params, params_offset);
	}

	/**
	 * @param namelen
	 * @param name
	 * @param bufSize
	 * @param stringlen
	 * @param string
	 * @see javax.media.opengl.GL2GL3#glGetNamedStringARB(int, java.lang.String, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetNamedStringARB(int namelen, String name, int bufSize, IntBuffer stringlen, ByteBuffer string) {
		getCurrent().glGetNamedStringARB(namelen, name, bufSize, stringlen, string);
	}

	/**
	 * @param program
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param binaryFormat
	 * @param binaryFormat_offset
	 * @param binary
	 * @see javax.media.opengl.GL2ES2#glGetProgramBinary(int, int, int[], int, int[], int, java.nio.Buffer)
	 */
	public void glGetProgramBinary(int program, int bufSize, int[] length, int length_offset, int[] binaryFormat, int binaryFormat_offset, Buffer binary) {
		getCurrent().glGetProgramBinary(program, bufSize, length, length_offset, binaryFormat, binaryFormat_offset, binary);
	}

	/**
	 * @param namelen
	 * @param name
	 * @param bufSize
	 * @param stringlen
	 * @param stringlen_offset
	 * @param string
	 * @param string_offset
	 * @see javax.media.opengl.GL2GL3#glGetNamedStringARB(int, java.lang.String, int, int[], int, byte[], int)
	 */
	public void glGetNamedStringARB(int namelen, String name, int bufSize, int[] stringlen, int stringlen_offset, byte[] string, int string_offset) {
		getCurrent().glGetNamedStringARB(namelen, name, bufSize, stringlen, stringlen_offset, string, string_offset);
	}

	/**
	 * @param program
	 * @param bufsize
	 * @param length
	 * @param infolog
	 * @see javax.media.opengl.GL2ES2#glGetProgramInfoLog(int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetProgramInfoLog(int program, int bufsize, IntBuffer length, ByteBuffer infolog) {
		getCurrent().glGetProgramInfoLog(program, bufsize, length, infolog);
	}

	/**
	 * @param namelen
	 * @param name
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetNamedStringivARB(int, java.lang.String, int, java.nio.IntBuffer)
	 */
	public void glGetNamedStringivARB(int namelen, String name, int pname, IntBuffer params) {
		getCurrent().glGetNamedStringivARB(namelen, name, pname, params);
	}

	/**
	 * @param program
	 * @param bufsize
	 * @param length
	 * @param length_offset
	 * @param infolog
	 * @param infolog_offset
	 * @see javax.media.opengl.GL2ES2#glGetProgramInfoLog(int, int, int[], int, byte[], int)
	 */
	public void glGetProgramInfoLog(int program, int bufsize, int[] length, int length_offset, byte[] infolog, int infolog_offset) {
		getCurrent().glGetProgramInfoLog(program, bufsize, length, length_offset, infolog, infolog_offset);
	}

	/**
	 * @param namelen
	 * @param name
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetNamedStringivARB(int, java.lang.String, int, int[], int)
	 */
	public void glGetNamedStringivARB(int namelen, String name, int pname, int[] params, int params_offset) {
		getCurrent().glGetNamedStringivARB(namelen, name, pname, params, params_offset);
	}

	/**
	 * @param program
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES2#glGetProgramiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetProgramiv(int program, int pname, IntBuffer params) {
		getCurrent().glGetProgramiv(program, pname, params);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetQueryObjectiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetQueryObjectiv(int id, int pname, IntBuffer params) {
		getCurrent().glGetQueryObjectiv(id, pname, params);
	}

	/**
	 * @param program
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES2#glGetProgramiv(int, int, int[], int)
	 */
	public void glGetProgramiv(int program, int pname, int[] params, int params_offset) {
		getCurrent().glGetProgramiv(program, pname, params, params_offset);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetQueryObjectiv(int, int, int[], int)
	 */
	public void glGetQueryObjectiv(int id, int pname, int[] params, int params_offset) {
		getCurrent().glGetQueryObjectiv(id, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2GL3#glGetTexImage(int, int, int, int, java.nio.Buffer)
	 */
	public void glGetTexImage(int target, int level, int format, int type, Buffer pixels) {
		getCurrent().glGetTexImage(target, level, format, type, pixels);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES2#glGetQueryObjectuiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetQueryObjectuiv(int id, int pname, IntBuffer params) {
		getCurrent().glGetQueryObjectuiv(id, pname, params);
	}

	/**
	 * @param texture
	 * @see javax.media.opengl.GL#glActiveTexture(int)
	 */
	public void glActiveTexture(int texture) {
		getCurrent().glActiveTexture(texture);
	}

	/**
	 * @param target
	 * @param level
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL2GL3#glGetTexImage(int, int, int, int, long)
	 */
	public void glGetTexImage(int target, int level, int format, int type, long pixels_buffer_offset) {
		getCurrent().glGetTexImage(target, level, format, type, pixels_buffer_offset);
	}

	/**
	 * @param target
	 * @param buffer
	 * @see javax.media.opengl.GL#glBindBuffer(int, int)
	 */
	public void glBindBuffer(int target, int buffer) {
		getCurrent().glBindBuffer(target, buffer);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES2#glGetQueryObjectuiv(int, int, int[], int)
	 */
	public void glGetQueryObjectuiv(int id, int pname, int[] params, int params_offset) {
		getCurrent().glGetQueryObjectuiv(id, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param framebuffer
	 * @see javax.media.opengl.GL#glBindFramebuffer(int, int)
	 */
	public void glBindFramebuffer(int target, int framebuffer) {
		getCurrent().glBindFramebuffer(target, framebuffer);
	}

	/**
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetTexLevelParameterfv(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetTexLevelParameterfv(int target, int level, int pname, FloatBuffer params) {
		getCurrent().glGetTexLevelParameterfv(target, level, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES2#glGetQueryiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetQueryiv(int target, int pname, IntBuffer params) {
		getCurrent().glGetQueryiv(target, pname, params);
	}

	/**
	 * @param target
	 * @param renderbuffer
	 * @see javax.media.opengl.GL#glBindRenderbuffer(int, int)
	 */
	public void glBindRenderbuffer(int target, int renderbuffer) {
		getCurrent().glBindRenderbuffer(target, renderbuffer);
	}

	/**
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetTexLevelParameterfv(int, int, int, float[], int)
	 */
	public void glGetTexLevelParameterfv(int target, int level, int pname, float[] params, int params_offset) {
		getCurrent().glGetTexLevelParameterfv(target, level, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES2#glGetQueryiv(int, int, int[], int)
	 */
	public void glGetQueryiv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetQueryiv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param texture
	 * @see javax.media.opengl.GL#glBindTexture(int, int)
	 */
	public void glBindTexture(int target, int texture) {
		getCurrent().glBindTexture(target, texture);
	}

	/**
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetTexLevelParameteriv(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetTexLevelParameteriv(int target, int level, int pname, IntBuffer params) {
		getCurrent().glGetTexLevelParameteriv(target, level, pname, params);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL#glBlendEquation(int)
	 */
	public void glBlendEquation(int mode) {
		getCurrent().glBlendEquation(mode);
	}

	/**
	 * @param shader
	 * @param bufsize
	 * @param length
	 * @param infolog
	 * @see javax.media.opengl.GL2ES2#glGetShaderInfoLog(int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetShaderInfoLog(int shader, int bufsize, IntBuffer length, ByteBuffer infolog) {
		getCurrent().glGetShaderInfoLog(shader, bufsize, length, infolog);
	}

	/**
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetTexLevelParameteriv(int, int, int, int[], int)
	 */
	public void glGetTexLevelParameteriv(int target, int level, int pname, int[] params, int params_offset) {
		getCurrent().glGetTexLevelParameteriv(target, level, pname, params, params_offset);
	}

	/**
	 * @param modeRGB
	 * @param modeAlpha
	 * @see javax.media.opengl.GL#glBlendEquationSeparate(int, int)
	 */
	public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
		getCurrent().glBlendEquationSeparate(modeRGB, modeAlpha);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetTexParameterIiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetTexParameterIiv(int target, int pname, IntBuffer params) {
		getCurrent().glGetTexParameterIiv(target, pname, params);
	}

	/**
	 * @param shader
	 * @param bufsize
	 * @param length
	 * @param length_offset
	 * @param infolog
	 * @param infolog_offset
	 * @see javax.media.opengl.GL2ES2#glGetShaderInfoLog(int, int, int[], int, byte[], int)
	 */
	public void glGetShaderInfoLog(int shader, int bufsize, int[] length, int length_offset, byte[] infolog, int infolog_offset) {
		getCurrent().glGetShaderInfoLog(shader, bufsize, length, length_offset, infolog, infolog_offset);
	}

	/**
	 * @param sfactor
	 * @param dfactor
	 * @see javax.media.opengl.GL#glBlendFunc(int, int)
	 */
	public void glBlendFunc(int sfactor, int dfactor) {
		getCurrent().glBlendFunc(sfactor, dfactor);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetTexParameterIiv(int, int, int[], int)
	 */
	public void glGetTexParameterIiv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetTexParameterIiv(target, pname, params, params_offset);
	}

	/**
	 * @param srcRGB
	 * @param dstRGB
	 * @param srcAlpha
	 * @param dstAlpha
	 * @see javax.media.opengl.GL#glBlendFuncSeparate(int, int, int, int)
	 */
	public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
		getCurrent().glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
	}

	/**
	 * @param shader
	 * @param bufsize
	 * @param length
	 * @param source
	 * @see javax.media.opengl.GL2ES2#glGetShaderSource(int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetShaderSource(int shader, int bufsize, IntBuffer length, ByteBuffer source) {
		getCurrent().glGetShaderSource(shader, bufsize, length, source);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetTexParameterIuiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetTexParameterIuiv(int target, int pname, IntBuffer params) {
		getCurrent().glGetTexParameterIuiv(target, pname, params);
	}

	/**
	 * @param target
	 * @param size
	 * @param data
	 * @param usage
	 * @see javax.media.opengl.GL#glBufferData(int, long, java.nio.Buffer, int)
	 */
	public void glBufferData(int target, long size, Buffer data, int usage) {
		getCurrent().glBufferData(target, size, data, usage);
	}

	/**
	 * @param shader
	 * @param bufsize
	 * @param length
	 * @param length_offset
	 * @param source
	 * @param source_offset
	 * @see javax.media.opengl.GL2ES2#glGetShaderSource(int, int, int[], int, byte[], int)
	 */
	public void glGetShaderSource(int shader, int bufsize, int[] length, int length_offset, byte[] source, int source_offset) {
		getCurrent().glGetShaderSource(shader, bufsize, length, length_offset, source, source_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetTexParameterIuiv(int, int, int[], int)
	 */
	public void glGetTexParameterIuiv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetTexParameterIuiv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param offset
	 * @param size
	 * @param data
	 * @see javax.media.opengl.GL#glBufferSubData(int, long, long, java.nio.Buffer)
	 */
	public void glBufferSubData(int target, long offset, long size, Buffer data) {
		getCurrent().glBufferSubData(target, offset, size, data);
	}

	/**
	 * @param shader
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES2#glGetShaderiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetShaderiv(int shader, int pname, IntBuffer params) {
		getCurrent().glGetShaderiv(shader, pname, params);
	}

	/**
	 * @param program
	 * @param location
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetUniformui64vNV(int, int, java.nio.LongBuffer)
	 */
	public void glGetUniformui64vNV(int program, int location, LongBuffer params) {
		getCurrent().glGetUniformui64vNV(program, location, params);
	}

	/**
	 * @param target
	 * @return
	 * @see javax.media.opengl.GL#glCheckFramebufferStatus(int)
	 */
	public int glCheckFramebufferStatus(int target) {
		return getCurrent().glCheckFramebufferStatus(target);
	}

	/**
	 * @param shader
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES2#glGetShaderiv(int, int, int[], int)
	 */
	public void glGetShaderiv(int shader, int pname, int[] params, int params_offset) {
		getCurrent().glGetShaderiv(shader, pname, params, params_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetUniformui64vNV(int, int, long[], int)
	 */
	public void glGetUniformui64vNV(int program, int location, long[] params, int params_offset) {
		getCurrent().glGetUniformui64vNV(program, location, params, params_offset);
	}

	/**
	 * @param program
	 * @param name
	 * @return
	 * @see javax.media.opengl.GL2ES2#glGetUniformLocation(int, java.lang.String)
	 */
	public int glGetUniformLocation(int program, String name) {
		return getCurrent().glGetUniformLocation(program, name);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL#glClear(int)
	 */
	public void glClear(int mask) {
		getCurrent().glClear(mask);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetVertexAttribdv(int, int, java.nio.DoubleBuffer)
	 */
	public void glGetVertexAttribdv(int index, int pname, DoubleBuffer params) {
		getCurrent().glGetVertexAttribdv(index, pname, params);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL#glClearColor(float, float, float, float)
	 */
	public void glClearColor(float red, float green, float blue, float alpha) {
		getCurrent().glClearColor(red, green, blue, alpha);
	}

	/**
	 * @param program
	 * @param location
	 * @param params
	 * @see javax.media.opengl.GL2ES2#glGetUniformfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetUniformfv(int program, int location, FloatBuffer params) {
		getCurrent().glGetUniformfv(program, location, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetVertexAttribdv(int, int, double[], int)
	 */
	public void glGetVertexAttribdv(int index, int pname, double[] params, int params_offset) {
		getCurrent().glGetVertexAttribdv(index, pname, params, params_offset);
	}

	/**
	 * @param depth
	 * @see javax.media.opengl.GL#glClearDepthf(float)
	 */
	public void glClearDepthf(float depth) {
		getCurrent().glClearDepthf(depth);
	}

	/**
	 * @param program
	 * @param location
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES2#glGetUniformfv(int, int, float[], int)
	 */
	public void glGetUniformfv(int program, int location, float[] params, int params_offset) {
		getCurrent().glGetUniformfv(program, location, params, params_offset);
	}

	/**
	 * @param target
	 * @param lod
	 * @param bufSize
	 * @param img
	 * @see javax.media.opengl.GL2GL3#glGetnCompressedTexImage(int, int, int, java.nio.Buffer)
	 */
	public void glGetnCompressedTexImage(int target, int lod, int bufSize, Buffer img) {
		getCurrent().glGetnCompressedTexImage(target, lod, bufSize, img);
	}

	/**
	 * @param s
	 * @see javax.media.opengl.GL#glClearStencil(int)
	 */
	public void glClearStencil(int s) {
		getCurrent().glClearStencil(s);
	}

	/**
	 * @param program
	 * @param location
	 * @param params
	 * @see javax.media.opengl.GL2ES2#glGetUniformiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetUniformiv(int program, int location, IntBuffer params) {
		getCurrent().glGetUniformiv(program, location, params);
	}

	/**
	 * @param target
	 * @param level
	 * @param format
	 * @param type
	 * @param bufSize
	 * @param img
	 * @see javax.media.opengl.GL2GL3#glGetnTexImage(int, int, int, int, int, java.nio.Buffer)
	 */
	public void glGetnTexImage(int target, int level, int format, int type, int bufSize, Buffer img) {
		getCurrent().glGetnTexImage(target, level, format, type, bufSize, img);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL#glColorMask(boolean, boolean, boolean, boolean)
	 */
	public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) {
		getCurrent().glColorMask(red, green, blue, alpha);
	}

	/**
	 * @param program
	 * @param location
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES2#glGetUniformiv(int, int, int[], int)
	 */
	public void glGetUniformiv(int program, int location, int[] params, int params_offset) {
		getCurrent().glGetUniformiv(program, location, params, params_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param bufSize
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetnUniformdv(int, int, int, java.nio.DoubleBuffer)
	 */
	public void glGetnUniformdv(int program, int location, int bufSize, DoubleBuffer params) {
		getCurrent().glGetnUniformdv(program, location, bufSize, params);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param border
	 * @param imageSize
	 * @param data
	 * @see javax.media.opengl.GL#glCompressedTexImage2D(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, Buffer data) {
		getCurrent().glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES2#glGetVertexAttribfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetVertexAttribfv(int index, int pname, FloatBuffer params) {
		getCurrent().glGetVertexAttribfv(index, pname, params);
	}

	/**
	 * @param program
	 * @param location
	 * @param bufSize
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetnUniformdv(int, int, int, double[], int)
	 */
	public void glGetnUniformdv(int program, int location, int bufSize, double[] params, int params_offset) {
		getCurrent().glGetnUniformdv(program, location, bufSize, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES2#glGetVertexAttribfv(int, int, float[], int)
	 */
	public void glGetVertexAttribfv(int index, int pname, float[] params, int params_offset) {
		getCurrent().glGetVertexAttribfv(index, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param border
	 * @param imageSize
	 * @param data_buffer_offset
	 * @see javax.media.opengl.GL#glCompressedTexImage2D(int, int, int, int, int, int, int, long)
	 */
	public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, long data_buffer_offset) {
		getCurrent().glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data_buffer_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param bufSize
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glGetnUniformuiv(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetnUniformuiv(int program, int location, int bufSize, IntBuffer params) {
		getCurrent().glGetnUniformuiv(program, location, bufSize, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2ES2#glGetVertexAttribiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetVertexAttribiv(int index, int pname, IntBuffer params) {
		getCurrent().glGetVertexAttribiv(index, pname, params);
	}

	/**
	 * @param program
	 * @param location
	 * @param bufSize
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glGetnUniformuiv(int, int, int, int[], int)
	 */
	public void glGetnUniformuiv(int program, int location, int bufSize, int[] params, int params_offset) {
		getCurrent().glGetnUniformuiv(program, location, bufSize, params, params_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param width
	 * @param height
	 * @param format
	 * @param imageSize
	 * @param data
	 * @see javax.media.opengl.GL#glCompressedTexSubImage2D(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Buffer data) {
		getCurrent().glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2ES2#glGetVertexAttribiv(int, int, int[], int)
	 */
	public void glGetVertexAttribiv(int index, int pname, int[] params, int params_offset) {
		getCurrent().glGetVertexAttribiv(index, pname, params, params_offset);
	}

	/**
	 * @param external_sync_type
	 * @param external_sync
	 * @param flags
	 * @return
	 * @see javax.media.opengl.GL2GL3#glImportSyncEXT(int, long, int)
	 */
	public long glImportSyncEXT(int external_sync_type, long external_sync, int flags) {
		return getCurrent().glImportSyncEXT(external_sync_type, external_sync, flags);
	}

	/**
	 * @param program
	 * @return
	 * @see javax.media.opengl.GL2ES2#glIsProgram(int)
	 */
	public boolean glIsProgram(int program) {
		return getCurrent().glIsProgram(program);
	}

	/**
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glIndexFormatNV(int, int)
	 */
	public void glIndexFormatNV(int type, int stride) {
		getCurrent().glIndexFormatNV(type, stride);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param width
	 * @param height
	 * @param format
	 * @param imageSize
	 * @param data_buffer_offset
	 * @see javax.media.opengl.GL#glCompressedTexSubImage2D(int, int, int, int, int, int, int, int, long)
	 */
	public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data_buffer_offset) {
		getCurrent().glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data_buffer_offset);
	}

	/**
	 * @param id
	 * @return
	 * @see javax.media.opengl.GL2ES2#glIsQuery(int)
	 */
	public boolean glIsQuery(int id) {
		return getCurrent().glIsQuery(id);
	}

	/**
	 * @param target
	 * @return
	 * @see javax.media.opengl.GL2GL3#glIsBufferResidentNV(int)
	 */
	public boolean glIsBufferResidentNV(int target) {
		return getCurrent().glIsBufferResidentNV(target);
	}

	/**
	 * @param shader
	 * @return
	 * @see javax.media.opengl.GL2ES2#glIsShader(int)
	 */
	public boolean glIsShader(int shader) {
		return getCurrent().glIsShader(shader);
	}

	/**
	 * @param target
	 * @param index
	 * @return
	 * @see javax.media.opengl.GL2GL3#glIsEnabledi(int, int)
	 */
	public boolean glIsEnabledi(int target, int index) {
		return getCurrent().glIsEnabledi(target, index);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param border
	 * @see javax.media.opengl.GL#glCopyTexImage2D(int, int, int, int, int, int, int, int)
	 */
	public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
		getCurrent().glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
	}

	/**
	 * @param program
	 * @see javax.media.opengl.GL2ES2#glLinkProgram(int)
	 */
	public void glLinkProgram(int program) {
		getCurrent().glLinkProgram(program);
	}

	/**
	 * @param buffer
	 * @return
	 * @see javax.media.opengl.GL2GL3#glIsNamedBufferResidentNV(int)
	 */
	public boolean glIsNamedBufferResidentNV(int buffer) {
		return getCurrent().glIsNamedBufferResidentNV(buffer);
	}

	/**
	 * @param identifier
	 * @param name
	 * @param length
	 * @param label
	 * @see javax.media.opengl.GL2ES2#glObjectLabel(int, int, int, java.nio.ByteBuffer)
	 */
	public void glObjectLabel(int identifier, int name, int length, ByteBuffer label) {
		getCurrent().glObjectLabel(identifier, name, length, label);
	}

	/**
	 * @param namelen
	 * @param name
	 * @return
	 * @see javax.media.opengl.GL2GL3#glIsNamedStringARB(int, java.lang.String)
	 */
	public boolean glIsNamedStringARB(int namelen, String name) {
		return getCurrent().glIsNamedStringARB(namelen, name);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL#glCopyTexSubImage2D(int, int, int, int, int, int, int, int)
	 */
	public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
		getCurrent().glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
	}

	/**
	 * @param identifier
	 * @param name
	 * @param length
	 * @param label
	 * @param label_offset
	 * @see javax.media.opengl.GL2ES2#glObjectLabel(int, int, int, byte[], int)
	 */
	public void glObjectLabel(int identifier, int name, int length, byte[] label, int label_offset) {
		getCurrent().glObjectLabel(identifier, name, length, label, label_offset);
	}

	/**
	 * @param target
	 * @see javax.media.opengl.GL2GL3#glMakeBufferNonResidentNV(int)
	 */
	public void glMakeBufferNonResidentNV(int target) {
		getCurrent().glMakeBufferNonResidentNV(target);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL#glCullFace(int)
	 */
	public void glCullFace(int mode) {
		getCurrent().glCullFace(mode);
	}

	/**
	 * @param ptr
	 * @param length
	 * @param label
	 * @see javax.media.opengl.GL2ES2#glObjectPtrLabel(java.nio.Buffer, int, java.nio.ByteBuffer)
	 */
	public void glObjectPtrLabel(Buffer ptr, int length, ByteBuffer label) {
		getCurrent().glObjectPtrLabel(ptr, length, label);
	}

	/**
	 * @param target
	 * @param access
	 * @see javax.media.opengl.GL2GL3#glMakeBufferResidentNV(int, int)
	 */
	public void glMakeBufferResidentNV(int target, int access) {
		getCurrent().glMakeBufferResidentNV(target, access);
	}

	/**
	 * @param n
	 * @param buffers
	 * @see javax.media.opengl.GL#glDeleteBuffers(int, java.nio.IntBuffer)
	 */
	public void glDeleteBuffers(int n, IntBuffer buffers) {
		getCurrent().glDeleteBuffers(n, buffers);
	}

	/**
	 * @param buffer
	 * @see javax.media.opengl.GL2GL3#glMakeNamedBufferNonResidentNV(int)
	 */
	public void glMakeNamedBufferNonResidentNV(int buffer) {
		getCurrent().glMakeNamedBufferNonResidentNV(buffer);
	}

	/**
	 * @param n
	 * @param buffers
	 * @param buffers_offset
	 * @see javax.media.opengl.GL#glDeleteBuffers(int, int[], int)
	 */
	public void glDeleteBuffers(int n, int[] buffers, int buffers_offset) {
		getCurrent().glDeleteBuffers(n, buffers, buffers_offset);
	}

	/**
	 * @param ptr
	 * @param length
	 * @param label
	 * @param label_offset
	 * @see javax.media.opengl.GL2ES2#glObjectPtrLabel(java.nio.Buffer, int, byte[], int)
	 */
	public void glObjectPtrLabel(Buffer ptr, int length, byte[] label, int label_offset) {
		getCurrent().glObjectPtrLabel(ptr, length, label, label_offset);
	}

	/**
	 * @param buffer
	 * @param access
	 * @see javax.media.opengl.GL2GL3#glMakeNamedBufferResidentNV(int, int)
	 */
	public void glMakeNamedBufferResidentNV(int buffer, int access) {
		getCurrent().glMakeNamedBufferResidentNV(buffer, access);
	}

	/**
	 * @param n
	 * @param framebuffers
	 * @see javax.media.opengl.GL#glDeleteFramebuffers(int, java.nio.IntBuffer)
	 */
	public void glDeleteFramebuffers(int n, IntBuffer framebuffers) {
		getCurrent().glDeleteFramebuffers(n, framebuffers);
	}

	/**
	 * @param mode
	 * @param first
	 * @param count
	 * @param drawcount
	 * @see javax.media.opengl.GL2GL3#glMultiDrawArrays(int, java.nio.IntBuffer, java.nio.IntBuffer, int)
	 */
	public void glMultiDrawArrays(int mode, IntBuffer first, IntBuffer count, int drawcount) {
		getCurrent().glMultiDrawArrays(mode, first, count, drawcount);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2ES2#glPopDebugGroup()
	 */
	public void glPopDebugGroup() {
		getCurrent().glPopDebugGroup();
	}

	/**
	 * @param program
	 * @param binaryFormat
	 * @param binary
	 * @param length
	 * @see javax.media.opengl.GL2ES2#glProgramBinary(int, int, java.nio.Buffer, int)
	 */
	public void glProgramBinary(int program, int binaryFormat, Buffer binary, int length) {
		getCurrent().glProgramBinary(program, binaryFormat, binary, length);
	}

	/**
	 * @param n
	 * @param framebuffers
	 * @param framebuffers_offset
	 * @see javax.media.opengl.GL#glDeleteFramebuffers(int, int[], int)
	 */
	public void glDeleteFramebuffers(int n, int[] framebuffers, int framebuffers_offset) {
		getCurrent().glDeleteFramebuffers(n, framebuffers, framebuffers_offset);
	}

	/**
	 * @param mode
	 * @param first
	 * @param first_offset
	 * @param count
	 * @param count_offset
	 * @param drawcount
	 * @see javax.media.opengl.GL2GL3#glMultiDrawArrays(int, int[], int, int[], int, int)
	 */
	public void glMultiDrawArrays(int mode, int[] first, int first_offset, int[] count, int count_offset, int drawcount) {
		getCurrent().glMultiDrawArrays(mode, first, first_offset, count, count_offset, drawcount);
	}

	/**
	 * @param mode
	 * @param indirect
	 * @param primcount
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glMultiDrawArraysIndirectAMD(int, java.nio.Buffer, int, int)
	 */
	public void glMultiDrawArraysIndirectAMD(int mode, Buffer indirect, int primcount, int stride) {
		getCurrent().glMultiDrawArraysIndirectAMD(mode, indirect, primcount, stride);
	}

	/**
	 * @param n
	 * @param renderbuffers
	 * @see javax.media.opengl.GL#glDeleteRenderbuffers(int, java.nio.IntBuffer)
	 */
	public void glDeleteRenderbuffers(int n, IntBuffer renderbuffers) {
		getCurrent().glDeleteRenderbuffers(n, renderbuffers);
	}

	/**
	 * @param source
	 * @param id
	 * @param length
	 * @param message
	 * @see javax.media.opengl.GL2ES2#glPushDebugGroup(int, int, int, java.nio.ByteBuffer)
	 */
	public void glPushDebugGroup(int source, int id, int length, ByteBuffer message) {
		getCurrent().glPushDebugGroup(source, id, length, message);
	}

	/**
	 * @param mode
	 * @param count
	 * @param type
	 * @param indices
	 * @param drawcount
	 * @see javax.media.opengl.GL2GL3#glMultiDrawElements(int, java.nio.IntBuffer, int, com.jogamp.common.nio.PointerBuffer, int)
	 */
	public void glMultiDrawElements(int mode, IntBuffer count, int type, PointerBuffer indices, int drawcount) {
		getCurrent().glMultiDrawElements(mode, count, type, indices, drawcount);
	}

	/**
	 * @param n
	 * @param renderbuffers
	 * @param renderbuffers_offset
	 * @see javax.media.opengl.GL#glDeleteRenderbuffers(int, int[], int)
	 */
	public void glDeleteRenderbuffers(int n, int[] renderbuffers, int renderbuffers_offset) {
		getCurrent().glDeleteRenderbuffers(n, renderbuffers, renderbuffers_offset);
	}

	/**
	 * @param source
	 * @param id
	 * @param length
	 * @param message
	 * @param message_offset
	 * @see javax.media.opengl.GL2ES2#glPushDebugGroup(int, int, int, byte[], int)
	 */
	public void glPushDebugGroup(int source, int id, int length, byte[] message, int message_offset) {
		getCurrent().glPushDebugGroup(source, id, length, message, message_offset);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GL2ES3#glIsPBOPackEnabled()
	 */
	public boolean glIsPBOPackEnabled() {
		return getCurrent().glIsPBOPackEnabled();
	}

	/**
	 * @param shader
	 * @param count
	 * @param string
	 * @param length
	 * @see javax.media.opengl.GL2ES2#glShaderSource(int, int, java.lang.String[], java.nio.IntBuffer)
	 */
	public void glShaderSource(int shader, int count, String[] string, IntBuffer length) {
		getCurrent().glShaderSource(shader, count, string, length);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GL2ES3#glIsPBOUnpackEnabled()
	 */
	public boolean glIsPBOUnpackEnabled() {
		return getCurrent().glIsPBOUnpackEnabled();
	}

	/**
	 * @param n
	 * @param textures
	 * @see javax.media.opengl.GL#glDeleteTextures(int, java.nio.IntBuffer)
	 */
	public void glDeleteTextures(int n, IntBuffer textures) {
		getCurrent().glDeleteTextures(n, textures);
	}

	/**
	 * @param mode
	 * @param type
	 * @param indirect
	 * @param primcount
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glMultiDrawElementsIndirectAMD(int, int, java.nio.Buffer, int, int)
	 */
	public void glMultiDrawElementsIndirectAMD(int mode, int type, Buffer indirect, int primcount, int stride) {
		getCurrent().glMultiDrawElementsIndirectAMD(mode, type, indirect, primcount, stride);
	}

	/**
	 * @param n
	 * @param textures
	 * @param textures_offset
	 * @see javax.media.opengl.GL#glDeleteTextures(int, int[], int)
	 */
	public void glDeleteTextures(int n, int[] textures, int textures_offset) {
		getCurrent().glDeleteTextures(n, textures, textures_offset);
	}

	/**
	 * @param shader
	 * @param count
	 * @param string
	 * @param length
	 * @param length_offset
	 * @see javax.media.opengl.GL2ES2#glShaderSource(int, int, java.lang.String[], int[], int)
	 */
	public void glShaderSource(int shader, int count, String[] string, int[] length, int length_offset) {
		getCurrent().glShaderSource(shader, count, string, length, length_offset);
	}

	/**
	 * @param framebuffer
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2GL3#glNamedFramebufferParameteriEXT(int, int, int)
	 */
	public void glNamedFramebufferParameteriEXT(int framebuffer, int pname, int param) {
		getCurrent().glNamedFramebufferParameteriEXT(framebuffer, pname, param);
	}

	/**
	 * @param func
	 * @see javax.media.opengl.GL#glDepthFunc(int)
	 */
	public void glDepthFunc(int func) {
		getCurrent().glDepthFunc(func);
	}

	/**
	 * @param face
	 * @param func
	 * @param ref
	 * @param mask
	 * @see javax.media.opengl.GL2ES2#glStencilFuncSeparate(int, int, int, int)
	 */
	public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
		getCurrent().glStencilFuncSeparate(face, func, ref, mask);
	}

	/**
	 * @param type
	 * @param namelen
	 * @param name
	 * @param stringlen
	 * @param string
	 * @see javax.media.opengl.GL2GL3#glNamedStringARB(int, int, java.lang.String, int, java.lang.String)
	 */
	public void glNamedStringARB(int type, int namelen, String name, int stringlen, String string) {
		getCurrent().glNamedStringARB(type, namelen, name, stringlen, string);
	}

	/**
	 * @param flag
	 * @see javax.media.opengl.GL#glDepthMask(boolean)
	 */
	public void glDepthMask(boolean flag) {
		getCurrent().glDepthMask(flag);
	}

	/**
	 * @param face
	 * @param mask
	 * @see javax.media.opengl.GL2ES2#glStencilMaskSeparate(int, int)
	 */
	public void glStencilMaskSeparate(int face, int mask) {
		getCurrent().glStencilMaskSeparate(face, mask);
	}

	/**
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glNormalFormatNV(int, int)
	 */
	public void glNormalFormatNV(int type, int stride) {
		getCurrent().glNormalFormatNV(type, stride);
	}

	/**
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.GL#glDepthRangef(float, float)
	 */
	public void glDepthRangef(float zNear, float zFar) {
		getCurrent().glDepthRangef(zNear, zFar);
	}

	/**
	 * @param face
	 * @param fail
	 * @param zfail
	 * @param zpass
	 * @see javax.media.opengl.GL2ES2#glStencilOpSeparate(int, int, int, int)
	 */
	public void glStencilOpSeparate(int face, int fail, int zfail, int zpass) {
		getCurrent().glStencilOpSeparate(face, fail, zfail, zpass);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2GL3#glPixelStoref(int, float)
	 */
	public void glPixelStoref(int pname, float param) {
		getCurrent().glPixelStoref(pname, param);
	}

	/**
	 * @param cap
	 * @see javax.media.opengl.GL#glDisable(int)
	 */
	public void glDisable(int cap) {
		getCurrent().glDisable(cap);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2ES2#glTexImage3D(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Buffer pixels) {
		getCurrent().glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels);
	}

	/**
	 * @param mode
	 * @param first
	 * @param count
	 * @see javax.media.opengl.GL#glDrawArrays(int, int, int)
	 */
	public void glDrawArrays(int mode, int first, int count) {
		getCurrent().glDrawArrays(mode, first, count);
	}

	/**
	 * @param mode
	 * @param count
	 * @param type
	 * @param indices
	 * @see javax.media.opengl.GL#glDrawElements(int, int, int, java.nio.Buffer)
	 */
	public void glDrawElements(int mode, int count, int type, Buffer indices) {
		getCurrent().glDrawElements(mode, count, type, indices);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL2ES2#glTexImage3D(int, int, int, int, int, int, int, int, int, long)
	 */
	public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, long pixels_buffer_offset) {
		getCurrent().glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels_buffer_offset);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2GL3#glPointParameteri(int, int)
	 */
	public void glPointParameteri(int pname, int param) {
		getCurrent().glPointParameteri(pname, param);
	}

	/**
	 * @param mode
	 * @param count
	 * @param type
	 * @param indices_buffer_offset
	 * @see javax.media.opengl.GL#glDrawElements(int, int, int, long)
	 */
	public void glDrawElements(int mode, int count, int type, long indices_buffer_offset) {
		getCurrent().glDrawElements(mode, count, type, indices_buffer_offset);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glPointParameteriv(int, java.nio.IntBuffer)
	 */
	public void glPointParameteriv(int pname, IntBuffer params) {
		getCurrent().glPointParameteriv(pname, params);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2ES2#glTexSubImage3D(int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Buffer pixels) {
		getCurrent().glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
	}

	/**
	 * @param cap
	 * @see javax.media.opengl.GL#glEnable(int)
	 */
	public void glEnable(int cap) {
		getCurrent().glEnable(cap);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glPointParameteriv(int, int[], int)
	 */
	public void glPointParameteriv(int pname, int[] params, int params_offset) {
		getCurrent().glPointParameteriv(pname, params, params_offset);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL#glFinish()
	 */
	public void glFinish() {
		getCurrent().glFinish();
	}

	/**
	 * 
	 * @see javax.media.opengl.GL#glFlush()
	 */
	public void glFlush() {
		getCurrent().glFlush();
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL2ES2#glTexSubImage3D(int, int, int, int, int, int, int, int, int, int, long)
	 */
	public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels_buffer_offset) {
		getCurrent().glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels_buffer_offset);
	}

	/**
	 * @param face
	 * @param mode
	 * @see javax.media.opengl.GL2GL3#glPolygonMode(int, int)
	 */
	public void glPolygonMode(int face, int mode) {
		getCurrent().glPolygonMode(face, mode);
	}

	/**
	 * @param target
	 * @param offset
	 * @param length
	 * @see javax.media.opengl.GL#glFlushMappedBufferRange(int, long, long)
	 */
	public void glFlushMappedBufferRange(int target, long offset, long length) {
		getCurrent().glFlushMappedBufferRange(target, offset, length);
	}

	/**
	 * @param index
	 * @see javax.media.opengl.GL2GL3#glPrimitiveRestartIndex(int)
	 */
	public void glPrimitiveRestartIndex(int index) {
		getCurrent().glPrimitiveRestartIndex(index);
	}

	/**
	 * @param location
	 * @param x
	 * @see javax.media.opengl.GL2ES2#glUniform1f(int, float)
	 */
	public void glUniform1f(int location, float x) {
		getCurrent().glUniform1f(location, x);
	}

	/**
	 * @param program
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2GL3#glProgramParameteriARB(int, int, int)
	 */
	public void glProgramParameteriARB(int program, int pname, int value) {
		getCurrent().glProgramParameteriARB(program, pname, value);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param renderbuffertarget
	 * @param renderbuffer
	 * @see javax.media.opengl.GL#glFramebufferRenderbuffer(int, int, int, int)
	 */
	public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
		getCurrent().glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @see javax.media.opengl.GL2ES2#glUniform1fv(int, int, java.nio.FloatBuffer)
	 */
	public void glUniform1fv(int location, int count, FloatBuffer v) {
		getCurrent().glUniform1fv(location, count, v);
	}

	/**
	 * @param program
	 * @param location
	 * @param value
	 * @see javax.media.opengl.GL2GL3#glProgramUniformui64NV(int, int, long)
	 */
	public void glProgramUniformui64NV(int program, int location, long value) {
		getCurrent().glProgramUniformui64NV(program, location, value);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param textarget
	 * @param texture
	 * @param level
	 * @see javax.media.opengl.GL#glFramebufferTexture2D(int, int, int, int, int)
	 */
	public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
		getCurrent().glFramebufferTexture2D(target, attachment, textarget, texture, level);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2GL3#glProgramUniformui64vNV(int, int, int, java.nio.LongBuffer)
	 */
	public void glProgramUniformui64vNV(int program, int location, int count, LongBuffer value) {
		getCurrent().glProgramUniformui64vNV(program, location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2ES2#glUniform1fv(int, int, float[], int)
	 */
	public void glUniform1fv(int location, int count, float[] v, int v_offset) {
		getCurrent().glUniform1fv(location, count, v, v_offset);
	}

	/**
	 * @param location
	 * @param x
	 * @see javax.media.opengl.GL2ES2#glUniform1i(int, int)
	 */
	public void glUniform1i(int location, int x) {
		getCurrent().glUniform1i(location, x);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2GL3#glProgramUniformui64vNV(int, int, int, long[], int)
	 */
	public void glProgramUniformui64vNV(int program, int location, int count, long[] value, int value_offset) {
		getCurrent().glProgramUniformui64vNV(program, location, count, value, value_offset);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL#glFrontFace(int)
	 */
	public void glFrontFace(int mode) {
		getCurrent().glFrontFace(mode);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @see javax.media.opengl.GL2ES2#glUniform1iv(int, int, java.nio.IntBuffer)
	 */
	public void glUniform1iv(int location, int count, IntBuffer v) {
		getCurrent().glUniform1iv(location, count, v);
	}

	/**
	 * @param n
	 * @param buffers
	 * @see javax.media.opengl.GL#glGenBuffers(int, java.nio.IntBuffer)
	 */
	public void glGenBuffers(int n, IntBuffer buffers) {
		getCurrent().glGenBuffers(n, buffers);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glSecondaryColorFormatNV(int, int, int)
	 */
	public void glSecondaryColorFormatNV(int size, int type, int stride) {
		getCurrent().glSecondaryColorFormatNV(size, type, stride);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2ES2#glUniform1iv(int, int, int[], int)
	 */
	public void glUniform1iv(int location, int count, int[] v, int v_offset) {
		getCurrent().glUniform1iv(location, count, v, v_offset);
	}

	/**
	 * @param n
	 * @param buffers
	 * @param buffers_offset
	 * @see javax.media.opengl.GL#glGenBuffers(int, int[], int)
	 */
	public void glGenBuffers(int n, int[] buffers, int buffers_offset) {
		getCurrent().glGenBuffers(n, buffers, buffers_offset);
	}

	/**
	 * @param pname
	 * @param index
	 * @param val
	 * @see javax.media.opengl.GL2GL3#glSetMultisamplefvAMD(int, int, java.nio.FloatBuffer)
	 */
	public void glSetMultisamplefvAMD(int pname, int index, FloatBuffer val) {
		getCurrent().glSetMultisamplefvAMD(pname, index, val);
	}

	/**
	 * @param location
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2ES2#glUniform2f(int, float, float)
	 */
	public void glUniform2f(int location, float x, float y) {
		getCurrent().glUniform2f(location, x, y);
	}

	/**
	 * @param n
	 * @param framebuffers
	 * @see javax.media.opengl.GL#glGenFramebuffers(int, java.nio.IntBuffer)
	 */
	public void glGenFramebuffers(int n, IntBuffer framebuffers) {
		getCurrent().glGenFramebuffers(n, framebuffers);
	}

	/**
	 * @param pname
	 * @param index
	 * @param val
	 * @param val_offset
	 * @see javax.media.opengl.GL2GL3#glSetMultisamplefvAMD(int, int, float[], int)
	 */
	public void glSetMultisamplefvAMD(int pname, int index, float[] val, int val_offset) {
		getCurrent().glSetMultisamplefvAMD(pname, index, val, val_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @see javax.media.opengl.GL2ES2#glUniform2fv(int, int, java.nio.FloatBuffer)
	 */
	public void glUniform2fv(int location, int count, FloatBuffer v) {
		getCurrent().glUniform2fv(location, count, v);
	}

	/**
	 * @param face
	 * @param value
	 * @see javax.media.opengl.GL2GL3#glStencilOpValueAMD(int, int)
	 */
	public void glStencilOpValueAMD(int face, int value) {
		getCurrent().glStencilOpValueAMD(face, value);
	}

	/**
	 * @param n
	 * @param framebuffers
	 * @param framebuffers_offset
	 * @see javax.media.opengl.GL#glGenFramebuffers(int, int[], int)
	 */
	public void glGenFramebuffers(int n, int[] framebuffers, int framebuffers_offset) {
		getCurrent().glGenFramebuffers(n, framebuffers, framebuffers_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2ES2#glUniform2fv(int, int, float[], int)
	 */
	public void glUniform2fv(int location, int count, float[] v, int v_offset) {
		getCurrent().glUniform2fv(location, count, v, v_offset);
	}

	/**
	 * @param factor
	 * @see javax.media.opengl.GL2GL3#glTessellationFactorAMD(float)
	 */
	public void glTessellationFactorAMD(float factor) {
		getCurrent().glTessellationFactorAMD(factor);
	}

	/**
	 * @param location
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2ES2#glUniform2i(int, int, int)
	 */
	public void glUniform2i(int location, int x, int y) {
		getCurrent().glUniform2i(location, x, y);
	}

	/**
	 * @param n
	 * @param renderbuffers
	 * @see javax.media.opengl.GL#glGenRenderbuffers(int, java.nio.IntBuffer)
	 */
	public void glGenRenderbuffers(int n, IntBuffer renderbuffers) {
		getCurrent().glGenRenderbuffers(n, renderbuffers);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2GL3#glTessellationModeAMD(int)
	 */
	public void glTessellationModeAMD(int mode) {
		getCurrent().glTessellationModeAMD(mode);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @see javax.media.opengl.GL2ES2#glUniform2iv(int, int, java.nio.IntBuffer)
	 */
	public void glUniform2iv(int location, int count, IntBuffer v) {
		getCurrent().glUniform2iv(location, count, v);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param buffer
	 * @see javax.media.opengl.GL2GL3#glTexBuffer(int, int, int)
	 */
	public void glTexBuffer(int target, int internalformat, int buffer) {
		getCurrent().glTexBuffer(target, internalformat, buffer);
	}

	/**
	 * @param n
	 * @param renderbuffers
	 * @param renderbuffers_offset
	 * @see javax.media.opengl.GL#glGenRenderbuffers(int, int[], int)
	 */
	public void glGenRenderbuffers(int n, int[] renderbuffers, int renderbuffers_offset) {
		getCurrent().glGenRenderbuffers(n, renderbuffers, renderbuffers_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2ES2#glUniform2iv(int, int, int[], int)
	 */
	public void glUniform2iv(int location, int count, int[] v, int v_offset) {
		getCurrent().glUniform2iv(location, count, v, v_offset);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glTexCoordFormatNV(int, int, int)
	 */
	public void glTexCoordFormatNV(int size, int type, int stride) {
		getCurrent().glTexCoordFormatNV(size, type, stride);
	}

	/**
	 * @param n
	 * @param textures
	 * @see javax.media.opengl.GL#glGenTextures(int, java.nio.IntBuffer)
	 */
	public void glGenTextures(int n, IntBuffer textures) {
		getCurrent().glGenTextures(n, textures);
	}

	/**
	 * @param location
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2ES2#glUniform3f(int, float, float, float)
	 */
	public void glUniform3f(int location, float x, float y, float z) {
		getCurrent().glUniform3f(location, x, y, z);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalFormat
	 * @param width
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2GL3#glTexImage1D(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTexImage1D(int target, int level, int internalFormat, int width, int border, int format, int type, Buffer pixels) {
		getCurrent().glTexImage1D(target, level, internalFormat, width, border, format, type, pixels);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @see javax.media.opengl.GL2ES2#glUniform3fv(int, int, java.nio.FloatBuffer)
	 */
	public void glUniform3fv(int location, int count, FloatBuffer v) {
		getCurrent().glUniform3fv(location, count, v);
	}

	/**
	 * @param n
	 * @param textures
	 * @param textures_offset
	 * @see javax.media.opengl.GL#glGenTextures(int, int[], int)
	 */
	public void glGenTextures(int n, int[] textures, int textures_offset) {
		getCurrent().glGenTextures(n, textures, textures_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalFormat
	 * @param width
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL2GL3#glTexImage1D(int, int, int, int, int, int, int, long)
	 */
	public void glTexImage1D(int target, int level, int internalFormat, int width, int border, int format, int type, long pixels_buffer_offset) {
		getCurrent().glTexImage1D(target, level, internalFormat, width, border, format, type, pixels_buffer_offset);
	}

	/**
	 * @param target
	 * @see javax.media.opengl.GL#glGenerateMipmap(int)
	 */
	public void glGenerateMipmap(int target) {
		getCurrent().glGenerateMipmap(target);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2ES2#glUniform3fv(int, int, float[], int)
	 */
	public void glUniform3fv(int location, int count, float[] v, int v_offset) {
		getCurrent().glUniform3fv(location, count, v, v_offset);
	}

	/**
	 * @param target
	 * @param coverageSamples
	 * @param colorSamples
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param fixedSampleLocations
	 * @see javax.media.opengl.GL2GL3#glTexImage2DMultisampleCoverageNV(int, int, int, int, int, int, boolean)
	 */
	public void glTexImage2DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, boolean fixedSampleLocations) {
		getCurrent().glTexImage2DMultisampleCoverageNV(target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glGetBooleanv(int, java.nio.ByteBuffer)
	 */
	public void glGetBooleanv(int pname, ByteBuffer params) {
		getCurrent().glGetBooleanv(pname, params);
	}

	/**
	 * @param location
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2ES2#glUniform3i(int, int, int, int)
	 */
	public void glUniform3i(int location, int x, int y, int z) {
		getCurrent().glUniform3i(location, x, y, z);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @see javax.media.opengl.GL2ES2#glUniform3iv(int, int, java.nio.IntBuffer)
	 */
	public void glUniform3iv(int location, int count, IntBuffer v) {
		getCurrent().glUniform3iv(location, count, v);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetBooleanv(int, byte[], int)
	 */
	public void glGetBooleanv(int pname, byte[] params, int params_offset) {
		getCurrent().glGetBooleanv(pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param coverageSamples
	 * @param colorSamples
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param depth
	 * @param fixedSampleLocations
	 * @see javax.media.opengl.GL2GL3#glTexImage3DMultisampleCoverageNV(int, int, int, int, int, int, int, boolean)
	 */
	public void glTexImage3DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, boolean fixedSampleLocations) {
		getCurrent().glTexImage3DMultisampleCoverageNV(target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2ES2#glUniform3iv(int, int, int[], int)
	 */
	public void glUniform3iv(int location, int count, int[] v, int v_offset) {
		getCurrent().glUniform3iv(location, count, v, v_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glGetBufferParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glGetBufferParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glGetBufferParameteriv(target, pname, params);
	}

	/**
	 * @param location
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2ES2#glUniform4f(int, float, float, float, float)
	 */
	public void glUniform4f(int location, float x, float y, float z, float w) {
		getCurrent().glUniform4f(location, x, y, z, w);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glTexParameterIiv(int, int, java.nio.IntBuffer)
	 */
	public void glTexParameterIiv(int target, int pname, IntBuffer params) {
		getCurrent().glTexParameterIiv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetBufferParameteriv(int, int, int[], int)
	 */
	public void glGetBufferParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetBufferParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @see javax.media.opengl.GL2ES2#glUniform4fv(int, int, java.nio.FloatBuffer)
	 */
	public void glUniform4fv(int location, int count, FloatBuffer v) {
		getCurrent().glUniform4fv(location, count, v);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glTexParameterIiv(int, int, int[], int)
	 */
	public void glTexParameterIiv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glTexParameterIiv(target, pname, params, params_offset);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GL#glGetError()
	 */
	public int glGetError() {
		return getCurrent().glGetError();
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2ES2#glUniform4fv(int, int, float[], int)
	 */
	public void glUniform4fv(int location, int count, float[] v, int v_offset) {
		getCurrent().glUniform4fv(location, count, v, v_offset);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glGetFloatv(int, java.nio.FloatBuffer)
	 */
	public void glGetFloatv(int pname, FloatBuffer params) {
		getCurrent().glGetFloatv(pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2GL3#glTexParameterIuiv(int, int, java.nio.IntBuffer)
	 */
	public void glTexParameterIuiv(int target, int pname, IntBuffer params) {
		getCurrent().glTexParameterIuiv(target, pname, params);
	}

	/**
	 * @param location
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2ES2#glUniform4i(int, int, int, int, int)
	 */
	public void glUniform4i(int location, int x, int y, int z, int w) {
		getCurrent().glUniform4i(location, x, y, z, w);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetFloatv(int, float[], int)
	 */
	public void glGetFloatv(int pname, float[] params, int params_offset) {
		getCurrent().glGetFloatv(pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2GL3#glTexParameterIuiv(int, int, int[], int)
	 */
	public void glTexParameterIuiv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glTexParameterIuiv(target, pname, params, params_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @see javax.media.opengl.GL2ES2#glUniform4iv(int, int, java.nio.IntBuffer)
	 */
	public void glUniform4iv(int location, int count, IntBuffer v) {
		getCurrent().glUniform4iv(location, count, v);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glGetFramebufferAttachmentParameteriv(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, IntBuffer params) {
		getCurrent().glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param width
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2GL3#glTexSubImage1D(int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, Buffer pixels) {
		getCurrent().glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
	}

	/**
	 * @param location
	 * @param count
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2ES2#glUniform4iv(int, int, int[], int)
	 */
	public void glUniform4iv(int location, int count, int[] v, int v_offset) {
		getCurrent().glUniform4iv(location, count, v, v_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2ES2#glUniformMatrix2fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix2fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix2fv(location, count, transpose, value);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param width
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL2GL3#glTexSubImage1D(int, int, int, int, int, int, long)
	 */
	public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels_buffer_offset) {
		getCurrent().glTexSubImage1D(target, level, xoffset, width, format, type, pixels_buffer_offset);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetFramebufferAttachmentParameteriv(int, int, int, int[], int)
	 */
	public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, int[] params, int params_offset) {
		getCurrent().glGetFramebufferAttachmentParameteriv(target, attachment, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param internalformat
	 * @param buffer
	 * @param offset
	 * @param size
	 * @see javax.media.opengl.GL2GL3#glTextureBufferRangeEXT(int, int, int, int, long, long)
	 */
	public void glTextureBufferRangeEXT(int texture, int target, int internalformat, int buffer, long offset, long size) {
		getCurrent().glTextureBufferRangeEXT(texture, target, internalformat, buffer, offset, size);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2ES2#glUniformMatrix2fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix2fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix2fv(location, count, transpose, value, value_offset);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GL#glGetGraphicsResetStatus()
	 */
	public int glGetGraphicsResetStatus() {
		return getCurrent().glGetGraphicsResetStatus();
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glGetIntegerv(int, java.nio.IntBuffer)
	 */
	public void glGetIntegerv(int pname, IntBuffer params) {
		getCurrent().glGetIntegerv(pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param coverageSamples
	 * @param colorSamples
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param fixedSampleLocations
	 * @see javax.media.opengl.GL2GL3#glTextureImage2DMultisampleCoverageNV(int, int, int, int, int, int, int, boolean)
	 */
	public void glTextureImage2DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, boolean fixedSampleLocations) {
		getCurrent().glTextureImage2DMultisampleCoverageNV(texture, target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2ES2#glUniformMatrix3fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix3fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix3fv(location, count, transpose, value);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetIntegerv(int, int[], int)
	 */
	public void glGetIntegerv(int pname, int[] params, int params_offset) {
		getCurrent().glGetIntegerv(pname, params, params_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2ES2#glUniformMatrix3fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix3fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix3fv(location, count, transpose, value, value_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param samples
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param fixedSampleLocations
	 * @see javax.media.opengl.GL2GL3#glTextureImage2DMultisampleNV(int, int, int, int, int, int, boolean)
	 */
	public void glTextureImage2DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, boolean fixedSampleLocations) {
		getCurrent().glTextureImage2DMultisampleNV(texture, target, samples, internalFormat, width, height, fixedSampleLocations);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glGetRenderbufferParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glGetRenderbufferParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glGetRenderbufferParameteriv(target, pname, params);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2ES2#glUniformMatrix4fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix4fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix4fv(location, count, transpose, value);
	}

	/**
	 * @param texture
	 * @param target
	 * @param coverageSamples
	 * @param colorSamples
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param depth
	 * @param fixedSampleLocations
	 * @see javax.media.opengl.GL2GL3#glTextureImage3DMultisampleCoverageNV(int, int, int, int, int, int, int, int, boolean)
	 */
	public void glTextureImage3DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, boolean fixedSampleLocations) {
		getCurrent().glTextureImage3DMultisampleCoverageNV(texture, target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetRenderbufferParameteriv(int, int, int[], int)
	 */
	public void glGetRenderbufferParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetRenderbufferParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2ES2#glUniformMatrix4fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix4fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix4fv(location, count, transpose, value, value_offset);
	}

	/**
	 * @param name
	 * @return
	 * @see javax.media.opengl.GL#glGetString(int)
	 */
	public String glGetString(int name) {
		return getCurrent().glGetString(name);
	}

	/**
	 * @param texture
	 * @param target
	 * @param samples
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param depth
	 * @param fixedSampleLocations
	 * @see javax.media.opengl.GL2GL3#glTextureImage3DMultisampleNV(int, int, int, int, int, int, int, boolean)
	 */
	public void glTextureImage3DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, int depth, boolean fixedSampleLocations) {
		getCurrent().glTextureImage3DMultisampleNV(texture, target, samples, internalFormat, width, height, depth, fixedSampleLocations);
	}

	/**
	 * @param program
	 * @see javax.media.opengl.GL2ES2#glUseProgram(int)
	 */
	public void glUseProgram(int program) {
		getCurrent().glUseProgram(program);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glGetTexParameterfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetTexParameterfv(int target, int pname, FloatBuffer params) {
		getCurrent().glGetTexParameterfv(target, pname, params);
	}

	/**
	 * @param program
	 * @see javax.media.opengl.GL2ES2#glValidateProgram(int)
	 */
	public void glValidateProgram(int program) {
		getCurrent().glValidateProgram(program);
	}

	/**
	 * @param location
	 * @param value
	 * @see javax.media.opengl.GL2GL3#glUniformui64NV(int, long)
	 */
	public void glUniformui64NV(int location, long value) {
		getCurrent().glUniformui64NV(location, value);
	}

	/**
	 * @param indx
	 * @param x
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib1f(int, float)
	 */
	public void glVertexAttrib1f(int indx, float x) {
		getCurrent().glVertexAttrib1f(indx, x);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetTexParameterfv(int, int, float[], int)
	 */
	public void glGetTexParameterfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetTexParameterfv(target, pname, params, params_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2GL3#glUniformui64vNV(int, int, java.nio.LongBuffer)
	 */
	public void glUniformui64vNV(int location, int count, LongBuffer value) {
		getCurrent().glUniformui64vNV(location, count, value);
	}

	/**
	 * @param indx
	 * @param values
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib1fv(int, java.nio.FloatBuffer)
	 */
	public void glVertexAttrib1fv(int indx, FloatBuffer values) {
		getCurrent().glVertexAttrib1fv(indx, values);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glGetTexParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glGetTexParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glGetTexParameteriv(target, pname, params);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2GL3#glUniformui64vNV(int, int, long[], int)
	 */
	public void glUniformui64vNV(int location, int count, long[] value, int value_offset) {
		getCurrent().glUniformui64vNV(location, count, value, value_offset);
	}

	/**
	 * @param indx
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib1fv(int, float[], int)
	 */
	public void glVertexAttrib1fv(int indx, float[] values, int values_offset) {
		getCurrent().glVertexAttrib1fv(indx, values, values_offset);
	}

	/**
	 * @param vaobj
	 * @param bindingindex
	 * @param buffer
	 * @param offset
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glVertexArrayBindVertexBufferEXT(int, int, int, long, int)
	 */
	public void glVertexArrayBindVertexBufferEXT(int vaobj, int bindingindex, int buffer, long offset, int stride) {
		getCurrent().glVertexArrayBindVertexBufferEXT(vaobj, bindingindex, buffer, offset, stride);
	}

	/**
	 * @param indx
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib2f(int, float, float)
	 */
	public void glVertexAttrib2f(int indx, float x, float y) {
		getCurrent().glVertexAttrib2f(indx, x, y);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetTexParameteriv(int, int, int[], int)
	 */
	public void glGetTexParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetTexParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param indx
	 * @param values
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib2fv(int, java.nio.FloatBuffer)
	 */
	public void glVertexAttrib2fv(int indx, FloatBuffer values) {
		getCurrent().glVertexAttrib2fv(indx, values);
	}

	/**
	 * @param vaobj
	 * @param attribindex
	 * @param bindingindex
	 * @see javax.media.opengl.GL2GL3#glVertexArrayVertexAttribBindingEXT(int, int, int)
	 */
	public void glVertexArrayVertexAttribBindingEXT(int vaobj, int attribindex, int bindingindex) {
		getCurrent().glVertexArrayVertexAttribBindingEXT(vaobj, attribindex, bindingindex);
	}

	/**
	 * @param program
	 * @param location
	 * @param bufSize
	 * @param params
	 * @see javax.media.opengl.GL#glGetnUniformfv(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetnUniformfv(int program, int location, int bufSize, FloatBuffer params) {
		getCurrent().glGetnUniformfv(program, location, bufSize, params);
	}

	/**
	 * @param indx
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib2fv(int, float[], int)
	 */
	public void glVertexAttrib2fv(int indx, float[] values, int values_offset) {
		getCurrent().glVertexAttrib2fv(indx, values, values_offset);
	}

	/**
	 * @param vaobj
	 * @param attribindex
	 * @param size
	 * @param type
	 * @param normalized
	 * @param relativeoffset
	 * @see javax.media.opengl.GL2GL3#glVertexArrayVertexAttribFormatEXT(int, int, int, int, boolean, int)
	 */
	public void glVertexArrayVertexAttribFormatEXT(int vaobj, int attribindex, int size, int type, boolean normalized, int relativeoffset) {
		getCurrent().glVertexArrayVertexAttribFormatEXT(vaobj, attribindex, size, type, normalized, relativeoffset);
	}

	/**
	 * @param program
	 * @param location
	 * @param bufSize
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetnUniformfv(int, int, int, float[], int)
	 */
	public void glGetnUniformfv(int program, int location, int bufSize, float[] params, int params_offset) {
		getCurrent().glGetnUniformfv(program, location, bufSize, params, params_offset);
	}

	/**
	 * @param indx
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib3f(int, float, float, float)
	 */
	public void glVertexAttrib3f(int indx, float x, float y, float z) {
		getCurrent().glVertexAttrib3f(indx, x, y, z);
	}

	/**
	 * @param vaobj
	 * @param attribindex
	 * @param size
	 * @param type
	 * @param relativeoffset
	 * @see javax.media.opengl.GL2GL3#glVertexArrayVertexAttribIFormatEXT(int, int, int, int, int)
	 */
	public void glVertexArrayVertexAttribIFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
		getCurrent().glVertexArrayVertexAttribIFormatEXT(vaobj, attribindex, size, type, relativeoffset);
	}

	/**
	 * @param program
	 * @param location
	 * @param bufSize
	 * @param params
	 * @see javax.media.opengl.GL#glGetnUniformiv(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetnUniformiv(int program, int location, int bufSize, IntBuffer params) {
		getCurrent().glGetnUniformiv(program, location, bufSize, params);
	}

	/**
	 * @param indx
	 * @param values
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib3fv(int, java.nio.FloatBuffer)
	 */
	public void glVertexAttrib3fv(int indx, FloatBuffer values) {
		getCurrent().glVertexAttrib3fv(indx, values);
	}

	/**
	 * @param vaobj
	 * @param attribindex
	 * @param size
	 * @param type
	 * @param relativeoffset
	 * @see javax.media.opengl.GL2GL3#glVertexArrayVertexAttribLFormatEXT(int, int, int, int, int)
	 */
	public void glVertexArrayVertexAttribLFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
		getCurrent().glVertexArrayVertexAttribLFormatEXT(vaobj, attribindex, size, type, relativeoffset);
	}

	/**
	 * @param program
	 * @param location
	 * @param bufSize
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glGetnUniformiv(int, int, int, int[], int)
	 */
	public void glGetnUniformiv(int program, int location, int bufSize, int[] params, int params_offset) {
		getCurrent().glGetnUniformiv(program, location, bufSize, params, params_offset);
	}

	/**
	 * @param indx
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib3fv(int, float[], int)
	 */
	public void glVertexAttrib3fv(int indx, float[] values, int values_offset) {
		getCurrent().glVertexAttrib3fv(indx, values, values_offset);
	}

	/**
	 * @param indx
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib4f(int, float, float, float, float)
	 */
	public void glVertexAttrib4f(int indx, float x, float y, float z, float w) {
		getCurrent().glVertexAttrib4f(indx, x, y, z, w);
	}

	/**
	 * @param vaobj
	 * @param bindingindex
	 * @param divisor
	 * @see javax.media.opengl.GL2GL3#glVertexArrayVertexBindingDivisorEXT(int, int, int)
	 */
	public void glVertexArrayVertexBindingDivisorEXT(int vaobj, int bindingindex, int divisor) {
		getCurrent().glVertexArrayVertexBindingDivisorEXT(vaobj, bindingindex, divisor);
	}

	/**
	 * @param target
	 * @param mode
	 * @see javax.media.opengl.GL#glHint(int, int)
	 */
	public void glHint(int target, int mode) {
		getCurrent().glHint(target, mode);
	}

	/**
	 * @param indx
	 * @param values
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib4fv(int, java.nio.FloatBuffer)
	 */
	public void glVertexAttrib4fv(int indx, FloatBuffer values) {
		getCurrent().glVertexAttrib4fv(indx, values);
	}

	/**
	 * @param buffer
	 * @return
	 * @see javax.media.opengl.GL#glIsBuffer(int)
	 */
	public boolean glIsBuffer(int buffer) {
		return getCurrent().glIsBuffer(buffer);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib1d(int, double)
	 */
	public void glVertexAttrib1d(int index, double x) {
		getCurrent().glVertexAttrib1d(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib1dv(int, java.nio.DoubleBuffer)
	 */
	public void glVertexAttrib1dv(int index, DoubleBuffer v) {
		getCurrent().glVertexAttrib1dv(index, v);
	}

	/**
	 * @param cap
	 * @return
	 * @see javax.media.opengl.GL#glIsEnabled(int)
	 */
	public boolean glIsEnabled(int cap) {
		return getCurrent().glIsEnabled(cap);
	}

	/**
	 * @param indx
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2ES2#glVertexAttrib4fv(int, float[], int)
	 */
	public void glVertexAttrib4fv(int indx, float[] values, int values_offset) {
		getCurrent().glVertexAttrib4fv(indx, values, values_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib1dv(int, double[], int)
	 */
	public void glVertexAttrib1dv(int index, double[] v, int v_offset) {
		getCurrent().glVertexAttrib1dv(index, v, v_offset);
	}

	/**
	 * @param framebuffer
	 * @return
	 * @see javax.media.opengl.GL#glIsFramebuffer(int)
	 */
	public boolean glIsFramebuffer(int framebuffer) {
		return getCurrent().glIsFramebuffer(framebuffer);
	}

	/**
	 * @param indx
	 * @param size
	 * @param type
	 * @param normalized
	 * @param stride
	 * @param ptr
	 * @see javax.media.opengl.GL2ES2#glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer)
	 */
	public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, Buffer ptr) {
		getCurrent().glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib1s(int, short)
	 */
	public void glVertexAttrib1s(int index, short x) {
		getCurrent().glVertexAttrib1s(index, x);
	}

	/**
	 * @param renderbuffer
	 * @return
	 * @see javax.media.opengl.GL#glIsRenderbuffer(int)
	 */
	public boolean glIsRenderbuffer(int renderbuffer) {
		return getCurrent().glIsRenderbuffer(renderbuffer);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib1sv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib1sv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib1sv(index, v);
	}

	/**
	 * @param indx
	 * @param size
	 * @param type
	 * @param normalized
	 * @param stride
	 * @param ptr_buffer_offset
	 * @see javax.media.opengl.GL2ES2#glVertexAttribPointer(int, int, int, boolean, int, long)
	 */
	public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, long ptr_buffer_offset) {
		getCurrent().glVertexAttribPointer(indx, size, type, normalized, stride, ptr_buffer_offset);
	}

	/**
	 * @param texture
	 * @return
	 * @see javax.media.opengl.GL#glIsTexture(int)
	 */
	public boolean glIsTexture(int texture) {
		return getCurrent().glIsTexture(texture);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib1sv(int, short[], int)
	 */
	public void glVertexAttrib1sv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib1sv(index, v, v_offset);
	}

	/**
	 * @param width
	 * @see javax.media.opengl.GL#glLineWidth(float)
	 */
	public void glLineWidth(float width) {
		getCurrent().glLineWidth(width);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib2d(int, double, double)
	 */
	public void glVertexAttrib2d(int index, double x, double y) {
		getCurrent().glVertexAttrib2d(index, x, y);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2ES2#glReleaseShaderCompiler()
	 */
	public void glReleaseShaderCompiler() {
		getCurrent().glReleaseShaderCompiler();
	}

	/**
	 * @param target
	 * @param access
	 * @return
	 * @see javax.media.opengl.GL#glMapBuffer(int, int)
	 */
	public ByteBuffer glMapBuffer(int target, int access) {
		return getCurrent().glMapBuffer(target, access);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib2dv(int, java.nio.DoubleBuffer)
	 */
	public void glVertexAttrib2dv(int index, DoubleBuffer v) {
		getCurrent().glVertexAttrib2dv(index, v);
	}

	/**
	 * @param target
	 * @param offset
	 * @param length
	 * @param access
	 * @return
	 * @see javax.media.opengl.GL#glMapBufferRange(int, long, long, int)
	 */
	public ByteBuffer glMapBufferRange(int target, long offset, long length, int access) {
		return getCurrent().glMapBufferRange(target, offset, length, access);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib2dv(int, double[], int)
	 */
	public void glVertexAttrib2dv(int index, double[] v, int v_offset) {
		getCurrent().glVertexAttrib2dv(index, v, v_offset);
	}

	/**
	 * @param n
	 * @param shaders
	 * @param binaryformat
	 * @param binary
	 * @param length
	 * @see javax.media.opengl.GL2ES2#glShaderBinary(int, java.nio.IntBuffer, int, java.nio.Buffer, int)
	 */
	public void glShaderBinary(int n, IntBuffer shaders, int binaryformat, Buffer binary, int length) {
		getCurrent().glShaderBinary(n, shaders, binaryformat, binary, length);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib2s(int, short, short)
	 */
	public void glVertexAttrib2s(int index, short x, short y) {
		getCurrent().glVertexAttrib2s(index, x, y);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL#glPixelStorei(int, int)
	 */
	public void glPixelStorei(int pname, int param) {
		getCurrent().glPixelStorei(pname, param);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib2sv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib2sv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib2sv(index, v);
	}

	/**
	 * @param n
	 * @param shaders
	 * @param shaders_offset
	 * @param binaryformat
	 * @param binary
	 * @param length
	 * @see javax.media.opengl.GL2ES2#glShaderBinary(int, int[], int, int, java.nio.Buffer, int)
	 */
	public void glShaderBinary(int n, int[] shaders, int shaders_offset, int binaryformat, Buffer binary, int length) {
		getCurrent().glShaderBinary(n, shaders, shaders_offset, binaryformat, binary, length);
	}

	/**
	 * @param factor
	 * @param units
	 * @see javax.media.opengl.GL#glPolygonOffset(float, float)
	 */
	public void glPolygonOffset(float factor, float units) {
		getCurrent().glPolygonOffset(factor, units);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib2sv(int, short[], int)
	 */
	public void glVertexAttrib2sv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib2sv(index, v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL#glReadPixels(int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glReadPixels(int x, int y, int width, int height, int format, int type, Buffer pixels) {
		getCurrent().glReadPixels(x, y, width, height, format, type, pixels);
	}

	/**
	 * @param shadertype
	 * @param precisiontype
	 * @param range
	 * @param precision
	 * @see javax.media.opengl.GL2ES2#glGetShaderPrecisionFormat(int, int, java.nio.IntBuffer, java.nio.IntBuffer)
	 */
	public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, IntBuffer range, IntBuffer precision) {
		getCurrent().glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib3d(int, double, double, double)
	 */
	public void glVertexAttrib3d(int index, double x, double y, double z) {
		getCurrent().glVertexAttrib3d(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib3dv(int, java.nio.DoubleBuffer)
	 */
	public void glVertexAttrib3dv(int index, DoubleBuffer v) {
		getCurrent().glVertexAttrib3dv(index, v);
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL#glReadPixels(int, int, int, int, int, int, long)
	 */
	public void glReadPixels(int x, int y, int width, int height, int format, int type, long pixels_buffer_offset) {
		getCurrent().glReadPixels(x, y, width, height, format, type, pixels_buffer_offset);
	}

	/**
	 * @param shadertype
	 * @param precisiontype
	 * @param range
	 * @param range_offset
	 * @param precision
	 * @param precision_offset
	 * @see javax.media.opengl.GL2ES2#glGetShaderPrecisionFormat(int, int, int[], int, int[], int)
	 */
	public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, int[] range, int range_offset, int[] precision, int precision_offset) {
		getCurrent().glGetShaderPrecisionFormat(shadertype, precisiontype, range, range_offset, precision, precision_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib3dv(int, double[], int)
	 */
	public void glVertexAttrib3dv(int index, double[] v, int v_offset) {
		getCurrent().glVertexAttrib3dv(index, v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param bufSize
	 * @param data
	 * @see javax.media.opengl.GL#glReadnPixels(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, Buffer data) {
		getCurrent().glReadnPixels(x, y, width, height, format, type, bufSize, data);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib3s(int, short, short, short)
	 */
	public void glVertexAttrib3s(int index, short x, short y, short z) {
		getCurrent().glVertexAttrib3s(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib3sv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib3sv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib3sv(index, v);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL#glRenderbufferStorage(int, int, int, int)
	 */
	public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
		getCurrent().glRenderbufferStorage(target, internalformat, width, height);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib3sv(int, short[], int)
	 */
	public void glVertexAttrib3sv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib3sv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nbv(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttrib4Nbv(int index, ByteBuffer v) {
		getCurrent().glVertexAttrib4Nbv(index, v);
	}

	/**
	 * @param value
	 * @param invert
	 * @see javax.media.opengl.GL#glSampleCoverage(float, boolean)
	 */
	public void glSampleCoverage(float value, boolean invert) {
		getCurrent().glSampleCoverage(value, invert);
	}

	/**
	 * @param array
	 * @see javax.media.opengl.GL2ES2#glVertexAttribPointer(javax.media.opengl.GLArrayData)
	 */
	public void glVertexAttribPointer(GLArrayData array) {
		getCurrent().glVertexAttribPointer(array);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nbv(int, byte[], int)
	 */
	public void glVertexAttrib4Nbv(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttrib4Nbv(index, v, v_offset);
	}

	/**
	 * @param data
	 * @see javax.media.opengl.GL2ES2#glUniform(javax.media.opengl.GLUniformData)
	 */
	public void glUniform(GLUniformData data) {
		getCurrent().glUniform(data);
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL#glScissor(int, int, int, int)
	 */
	public void glScissor(int x, int y, int width, int height) {
		getCurrent().glScissor(x, y, width, height);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Niv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttrib4Niv(int index, IntBuffer v) {
		getCurrent().glVertexAttrib4Niv(index, v);
	}

	/**
	 * @param func
	 * @param ref
	 * @param mask
	 * @see javax.media.opengl.GL#glStencilFunc(int, int, int)
	 */
	public void glStencilFunc(int func, int ref, int mask) {
		getCurrent().glStencilFunc(func, ref, mask);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Niv(int, int[], int)
	 */
	public void glVertexAttrib4Niv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttrib4Niv(index, v, v_offset);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL#glStencilMask(int)
	 */
	public void glStencilMask(int mask) {
		getCurrent().glStencilMask(mask);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nsv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4Nsv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4Nsv(index, v);
	}

	/**
	 * @param fail
	 * @param zfail
	 * @param zpass
	 * @see javax.media.opengl.GL#glStencilOp(int, int, int)
	 */
	public void glStencilOp(int fail, int zfail, int zpass) {
		getCurrent().glStencilOp(fail, zfail, zpass);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nsv(int, short[], int)
	 */
	public void glVertexAttrib4Nsv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4Nsv(index, v, v_offset);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL#glTexImage2D(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, Buffer pixels) {
		getCurrent().glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nub(int, byte, byte, byte, byte)
	 */
	public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
		getCurrent().glVertexAttrib4Nub(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nubv(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttrib4Nubv(int index, ByteBuffer v) {
		getCurrent().glVertexAttrib4Nubv(index, v);
	}

	/**
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL#glTexImage2D(int, int, int, int, int, int, int, int, long)
	 */
	public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels_buffer_offset) {
		getCurrent().glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels_buffer_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nubv(int, byte[], int)
	 */
	public void glVertexAttrib4Nubv(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttrib4Nubv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nuiv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttrib4Nuiv(int index, IntBuffer v) {
		getCurrent().glVertexAttrib4Nuiv(index, v);
	}

	/**
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL#glTexParameterf(int, int, float)
	 */
	public void glTexParameterf(int target, int pname, float param) {
		getCurrent().glTexParameterf(target, pname, param);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nuiv(int, int[], int)
	 */
	public void glVertexAttrib4Nuiv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttrib4Nuiv(index, v, v_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glTexParameterfv(int, int, java.nio.FloatBuffer)
	 */
	public void glTexParameterfv(int target, int pname, FloatBuffer params) {
		getCurrent().glTexParameterfv(target, pname, params);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nusv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4Nusv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4Nusv(index, v);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glTexParameterfv(int, int, float[], int)
	 */
	public void glTexParameterfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glTexParameterfv(target, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4Nusv(int, short[], int)
	 */
	public void glVertexAttrib4Nusv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4Nusv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4bv(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttrib4bv(int index, ByteBuffer v) {
		getCurrent().glVertexAttrib4bv(index, v);
	}

	/**
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL#glTexParameteri(int, int, int)
	 */
	public void glTexParameteri(int target, int pname, int param) {
		getCurrent().glTexParameteri(target, pname, param);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4bv(int, byte[], int)
	 */
	public void glVertexAttrib4bv(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttrib4bv(index, v, v_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL#glTexParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glTexParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glTexParameteriv(target, pname, params);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4d(int, double, double, double, double)
	 */
	public void glVertexAttrib4d(int index, double x, double y, double z, double w) {
		getCurrent().glVertexAttrib4d(index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL#glTexParameteriv(int, int, int[], int)
	 */
	public void glTexParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glTexParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4dv(int, java.nio.DoubleBuffer)
	 */
	public void glVertexAttrib4dv(int index, DoubleBuffer v) {
		getCurrent().glVertexAttrib4dv(index, v);
	}

	/**
	 * @param target
	 * @param levels
	 * @param internalformat
	 * @param width
	 * @see javax.media.opengl.GL#glTexStorage1D(int, int, int, int)
	 */
	public void glTexStorage1D(int target, int levels, int internalformat, int width) {
		getCurrent().glTexStorage1D(target, levels, internalformat, width);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4dv(int, double[], int)
	 */
	public void glVertexAttrib4dv(int index, double[] v, int v_offset) {
		getCurrent().glVertexAttrib4dv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4iv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttrib4iv(int index, IntBuffer v) {
		getCurrent().glVertexAttrib4iv(index, v);
	}

	/**
	 * @param target
	 * @param levels
	 * @param internalformat
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL#glTexStorage2D(int, int, int, int, int)
	 */
	public void glTexStorage2D(int target, int levels, int internalformat, int width, int height) {
		getCurrent().glTexStorage2D(target, levels, internalformat, width, height);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4iv(int, int[], int)
	 */
	public void glVertexAttrib4iv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttrib4iv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4s(int, short, short, short, short)
	 */
	public void glVertexAttrib4s(int index, short x, short y, short z, short w) {
		getCurrent().glVertexAttrib4s(index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param levels
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @see javax.media.opengl.GL#glTexStorage3D(int, int, int, int, int, int)
	 */
	public void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth) {
		getCurrent().glTexStorage3D(target, levels, internalformat, width, height, depth);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4sv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4sv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4sv(index, v);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL#glTexSubImage2D(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Buffer pixels) {
		getCurrent().glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4sv(int, short[], int)
	 */
	public void glVertexAttrib4sv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4sv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4ubv(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttrib4ubv(int index, ByteBuffer v) {
		getCurrent().glVertexAttrib4ubv(index, v);
	}

	/**
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL#glTexSubImage2D(int, int, int, int, int, int, int, int, long)
	 */
	public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels_buffer_offset) {
		getCurrent().glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels_buffer_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4ubv(int, byte[], int)
	 */
	public void glVertexAttrib4ubv(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttrib4ubv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4uiv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttrib4uiv(int index, IntBuffer v) {
		getCurrent().glVertexAttrib4uiv(index, v);
	}

	/**
	 * @param texture
	 * @param target
	 * @param levels
	 * @param internalformat
	 * @param width
	 * @see javax.media.opengl.GL#glTextureStorage1D(int, int, int, int, int)
	 */
	public void glTextureStorage1D(int texture, int target, int levels, int internalformat, int width) {
		getCurrent().glTextureStorage1D(texture, target, levels, internalformat, width);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4uiv(int, int[], int)
	 */
	public void glVertexAttrib4uiv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttrib4uiv(index, v, v_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param levels
	 * @param internalformat
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL#glTextureStorage2D(int, int, int, int, int, int)
	 */
	public void glTextureStorage2D(int texture, int target, int levels, int internalformat, int width, int height) {
		getCurrent().glTextureStorage2D(texture, target, levels, internalformat, width, height);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4usv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4usv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4usv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttrib4usv(int, short[], int)
	 */
	public void glVertexAttrib4usv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4usv(index, v, v_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param levels
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @see javax.media.opengl.GL#glTextureStorage3D(int, int, int, int, int, int, int)
	 */
	public void glTextureStorage3D(int texture, int target, int levels, int internalformat, int width, int height, int depth) {
		getCurrent().glTextureStorage3D(texture, target, levels, internalformat, width, height, depth);
	}

	/**
	 * @param index
	 * @param size
	 * @param type
	 * @param normalized
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glVertexAttribFormatNV(int, int, int, boolean, int)
	 */
	public void glVertexAttribFormatNV(int index, int size, int type, boolean normalized, int stride) {
		getCurrent().glVertexAttribFormatNV(index, size, type, normalized, stride);
	}

	/**
	 * @param target
	 * @return
	 * @see javax.media.opengl.GL#glUnmapBuffer(int)
	 */
	public boolean glUnmapBuffer(int target) {
		return getCurrent().glUnmapBuffer(target);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI1i(int, int)
	 */
	public void glVertexAttribI1i(int index, int x) {
		getCurrent().glVertexAttribI1i(index, x);
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL#glViewport(int, int, int, int)
	 */
	public void glViewport(int x, int y, int width, int height) {
		getCurrent().glViewport(x, y, width, height);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI1iv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI1iv(int index, IntBuffer v) {
		getCurrent().glVertexAttribI1iv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI1iv(int, int[], int)
	 */
	public void glVertexAttribI1iv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI1iv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI1ui(int, int)
	 */
	public void glVertexAttribI1ui(int index, int x) {
		getCurrent().glVertexAttribI1ui(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI1uiv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI1uiv(int index, IntBuffer v) {
		getCurrent().glVertexAttribI1uiv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI1uiv(int, int[], int)
	 */
	public void glVertexAttribI1uiv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI1uiv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI2i(int, int, int)
	 */
	public void glVertexAttribI2i(int index, int x, int y) {
		getCurrent().glVertexAttribI2i(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI2iv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI2iv(int index, IntBuffer v) {
		getCurrent().glVertexAttribI2iv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI2iv(int, int[], int)
	 */
	public void glVertexAttribI2iv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI2iv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI2ui(int, int, int)
	 */
	public void glVertexAttribI2ui(int index, int x, int y) {
		getCurrent().glVertexAttribI2ui(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI2uiv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI2uiv(int index, IntBuffer v) {
		getCurrent().glVertexAttribI2uiv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI2uiv(int, int[], int)
	 */
	public void glVertexAttribI2uiv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI2uiv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI3i(int, int, int, int)
	 */
	public void glVertexAttribI3i(int index, int x, int y, int z) {
		getCurrent().glVertexAttribI3i(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI3iv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI3iv(int index, IntBuffer v) {
		getCurrent().glVertexAttribI3iv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI3iv(int, int[], int)
	 */
	public void glVertexAttribI3iv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI3iv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI3ui(int, int, int, int)
	 */
	public void glVertexAttribI3ui(int index, int x, int y, int z) {
		getCurrent().glVertexAttribI3ui(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI3uiv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI3uiv(int index, IntBuffer v) {
		getCurrent().glVertexAttribI3uiv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI3uiv(int, int[], int)
	 */
	public void glVertexAttribI3uiv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI3uiv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI4bv(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttribI4bv(int index, ByteBuffer v) {
		getCurrent().glVertexAttribI4bv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI4bv(int, byte[], int)
	 */
	public void glVertexAttribI4bv(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttribI4bv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI4sv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttribI4sv(int index, ShortBuffer v) {
		getCurrent().glVertexAttribI4sv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI4sv(int, short[], int)
	 */
	public void glVertexAttribI4sv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttribI4sv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI4ubv(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttribI4ubv(int index, ByteBuffer v) {
		getCurrent().glVertexAttribI4ubv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI4ubv(int, byte[], int)
	 */
	public void glVertexAttribI4ubv(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttribI4ubv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI4usv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttribI4usv(int index, ShortBuffer v) {
		getCurrent().glVertexAttribI4usv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2GL3#glVertexAttribI4usv(int, short[], int)
	 */
	public void glVertexAttribI4usv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttribI4usv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param size
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glVertexAttribIFormatNV(int, int, int, int)
	 */
	public void glVertexAttribIFormatNV(int index, int size, int type, int stride) {
		getCurrent().glVertexAttribIFormatNV(index, size, type, stride);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2GL3#glVertexFormatNV(int, int, int)
	 */
	public void glVertexFormatNV(int size, int type, int stride) {
		getCurrent().glVertexFormatNV(size, type, stride);
	}

	/**
	 * @param op
	 * @param value
	 * @see javax.media.opengl.GL2#glAccum(int, float)
	 */
	public void glAccum(int op, float value) {
		getCurrent().glAccum(op, value);
	}

	/**
	 * @param face
	 * @see javax.media.opengl.GL2#glActiveStencilFaceEXT(int)
	 */
	public void glActiveStencilFaceEXT(int face) {
		getCurrent().glActiveStencilFaceEXT(face);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2#glApplyTextureEXT(int)
	 */
	public void glApplyTextureEXT(int mode) {
		getCurrent().glApplyTextureEXT(mode);
	}

	/**
	 * @param n
	 * @param textures
	 * @param residences
	 * @return
	 * @see javax.media.opengl.GL2#glAreTexturesResident(int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public boolean glAreTexturesResident(int n, IntBuffer textures, ByteBuffer residences) {
		return getCurrent().glAreTexturesResident(n, textures, residences);
	}

	/**
	 * @param n
	 * @param textures
	 * @param textures_offset
	 * @param residences
	 * @param residences_offset
	 * @return
	 * @see javax.media.opengl.GL2#glAreTexturesResident(int, int[], int, byte[], int)
	 */
	public boolean glAreTexturesResident(int n, int[] textures, int textures_offset, byte[] residences, int residences_offset) {
		return getCurrent().glAreTexturesResident(n, textures, textures_offset, residences, residences_offset);
	}

	/**
	 * @param i
	 * @see javax.media.opengl.GL2#glArrayElement(int)
	 */
	public void glArrayElement(int i) {
		getCurrent().glArrayElement(i);
	}

	/**
	 * @param containerObj
	 * @param obj
	 * @see javax.media.opengl.GL2#glAttachObjectARB(int, int)
	 */
	public void glAttachObjectARB(int containerObj, int obj) {
		getCurrent().glAttachObjectARB(containerObj, obj);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2#glBegin(int)
	 */
	public void glBegin(int mode) {
		getCurrent().glBegin(mode);
	}

	/**
	 * @param id
	 * @see javax.media.opengl.GL2#glBeginConditionalRenderNVX(int)
	 */
	public void glBeginConditionalRenderNVX(int id) {
		getCurrent().glBeginConditionalRenderNVX(id);
	}

	/**
	 * @param id
	 * @see javax.media.opengl.GL2#glBeginOcclusionQueryNV(int)
	 */
	public void glBeginOcclusionQueryNV(int id) {
		getCurrent().glBeginOcclusionQueryNV(id);
	}

	/**
	 * @param monitor
	 * @see javax.media.opengl.GL2#glBeginPerfMonitorAMD(int)
	 */
	public void glBeginPerfMonitorAMD(int monitor) {
		getCurrent().glBeginPerfMonitorAMD(monitor);
	}

	/**
	 * @param primitiveMode
	 * @see javax.media.opengl.GL2#glBeginTransformFeedback(int)
	 */
	public void glBeginTransformFeedback(int primitiveMode) {
		getCurrent().glBeginTransformFeedback(primitiveMode);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glBeginVertexShaderEXT()
	 */
	public void glBeginVertexShaderEXT() {
		getCurrent().glBeginVertexShaderEXT();
	}

	/**
	 * @param video_capture_slot
	 * @see javax.media.opengl.GL2#glBeginVideoCaptureNV(int)
	 */
	public void glBeginVideoCaptureNV(int video_capture_slot) {
		getCurrent().glBeginVideoCaptureNV(video_capture_slot);
	}

	/**
	 * @param target
	 * @param index
	 * @param buffer
	 * @see javax.media.opengl.GL2#glBindBufferBase(int, int, int)
	 */
	public void glBindBufferBase(int target, int index, int buffer) {
		getCurrent().glBindBufferBase(target, index, buffer);
	}

	/**
	 * @param target
	 * @param index
	 * @param buffer
	 * @param offset
	 * @param size
	 * @see javax.media.opengl.GL2#glBindBufferRange(int, int, int, long, long)
	 */
	public void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
		getCurrent().glBindBufferRange(target, index, buffer, offset, size);
	}

	/**
	 * @param light
	 * @param value
	 * @return
	 * @see javax.media.opengl.GL2#glBindLightParameterEXT(int, int)
	 */
	public int glBindLightParameterEXT(int light, int value) {
		return getCurrent().glBindLightParameterEXT(light, value);
	}

	/**
	 * @param face
	 * @param value
	 * @return
	 * @see javax.media.opengl.GL2#glBindMaterialParameterEXT(int, int)
	 */
	public int glBindMaterialParameterEXT(int face, int value) {
		return getCurrent().glBindMaterialParameterEXT(face, value);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param texture
	 * @see javax.media.opengl.GL2#glBindMultiTextureEXT(int, int, int)
	 */
	public void glBindMultiTextureEXT(int texunit, int target, int texture) {
		getCurrent().glBindMultiTextureEXT(texunit, target, texture);
	}

	/**
	 * @param value
	 * @return
	 * @see javax.media.opengl.GL2#glBindParameterEXT(int)
	 */
	public int glBindParameterEXT(int value) {
		return getCurrent().glBindParameterEXT(value);
	}

	/**
	 * @param target
	 * @param program
	 * @see javax.media.opengl.GL2#glBindProgramARB(int, int)
	 */
	public void glBindProgramARB(int target, int program) {
		getCurrent().glBindProgramARB(target, program);
	}

	/**
	 * @param unit
	 * @param coord
	 * @param value
	 * @return
	 * @see javax.media.opengl.GL2#glBindTexGenParameterEXT(int, int, int)
	 */
	public int glBindTexGenParameterEXT(int unit, int coord, int value) {
		return getCurrent().glBindTexGenParameterEXT(unit, coord, value);
	}

	/**
	 * @param unit
	 * @param value
	 * @return
	 * @see javax.media.opengl.GL2#glBindTextureUnitParameterEXT(int, int)
	 */
	public int glBindTextureUnitParameterEXT(int unit, int value) {
		return getCurrent().glBindTextureUnitParameterEXT(unit, value);
	}

	/**
	 * @param target
	 * @param id
	 * @see javax.media.opengl.GL2#glBindTransformFeedbackNV(int, int)
	 */
	public void glBindTransformFeedbackNV(int target, int id) {
		getCurrent().glBindTransformFeedbackNV(target, id);
	}

	/**
	 * @param array
	 * @see javax.media.opengl.GL2#glBindVertexArray(int)
	 */
	public void glBindVertexArray(int array) {
		getCurrent().glBindVertexArray(array);
	}

	/**
	 * @param id
	 * @see javax.media.opengl.GL2#glBindVertexShaderEXT(int)
	 */
	public void glBindVertexShaderEXT(int id) {
		getCurrent().glBindVertexShaderEXT(id);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param frame_region
	 * @param offset
	 * @see javax.media.opengl.GL2#glBindVideoCaptureStreamBufferNV(int, int, int, long)
	 */
	public void glBindVideoCaptureStreamBufferNV(int video_capture_slot, int stream, int frame_region, long offset) {
		getCurrent().glBindVideoCaptureStreamBufferNV(video_capture_slot, stream, frame_region, offset);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param frame_region
	 * @param target
	 * @param texture
	 * @see javax.media.opengl.GL2#glBindVideoCaptureStreamTextureNV(int, int, int, int, int)
	 */
	public void glBindVideoCaptureStreamTextureNV(int video_capture_slot, int stream, int frame_region, int target, int texture) {
		getCurrent().glBindVideoCaptureStreamTextureNV(video_capture_slot, stream, frame_region, target, texture);
	}

	/**
	 * @param width
	 * @param height
	 * @param xorig
	 * @param yorig
	 * @param xmove
	 * @param ymove
	 * @param bitmap
	 * @see javax.media.opengl.GL2#glBitmap(int, int, float, float, float, float, java.nio.ByteBuffer)
	 */
	public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, ByteBuffer bitmap) {
		getCurrent().glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap);
	}

	/**
	 * @param width
	 * @param height
	 * @param xorig
	 * @param yorig
	 * @param xmove
	 * @param ymove
	 * @param bitmap
	 * @param bitmap_offset
	 * @see javax.media.opengl.GL2#glBitmap(int, int, float, float, float, float, byte[], int)
	 */
	public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, byte[] bitmap, int bitmap_offset) {
		getCurrent().glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap, bitmap_offset);
	}

	/**
	 * @param width
	 * @param height
	 * @param xorig
	 * @param yorig
	 * @param xmove
	 * @param ymove
	 * @param bitmap_buffer_offset
	 * @see javax.media.opengl.GL2#glBitmap(int, int, float, float, float, float, long)
	 */
	public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, long bitmap_buffer_offset) {
		getCurrent().glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap_buffer_offset);
	}

	/**
	 * @param buf
	 * @param mode
	 * @see javax.media.opengl.GL2#glBlendEquationIndexedAMD(int, int)
	 */
	public void glBlendEquationIndexedAMD(int buf, int mode) {
		getCurrent().glBlendEquationIndexedAMD(buf, mode);
	}

	/**
	 * @param buf
	 * @param modeRGB
	 * @param modeAlpha
	 * @see javax.media.opengl.GL2#glBlendEquationSeparateIndexedAMD(int, int, int)
	 */
	public void glBlendEquationSeparateIndexedAMD(int buf, int modeRGB, int modeAlpha) {
		getCurrent().glBlendEquationSeparateIndexedAMD(buf, modeRGB, modeAlpha);
	}

	/**
	 * @param buf
	 * @param src
	 * @param dst
	 * @see javax.media.opengl.GL2#glBlendFuncIndexedAMD(int, int, int)
	 */
	public void glBlendFuncIndexedAMD(int buf, int src, int dst) {
		getCurrent().glBlendFuncIndexedAMD(buf, src, dst);
	}

	/**
	 * @param sfactorRGB
	 * @param dfactorRGB
	 * @param sfactorAlpha
	 * @param dfactorAlpha
	 * @see javax.media.opengl.GL2#glBlendFuncSeparateINGR(int, int, int, int)
	 */
	public void glBlendFuncSeparateINGR(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
		getCurrent().glBlendFuncSeparateINGR(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
	}

	/**
	 * @param buf
	 * @param srcRGB
	 * @param dstRGB
	 * @param srcAlpha
	 * @param dstAlpha
	 * @see javax.media.opengl.GL2#glBlendFuncSeparateIndexedAMD(int, int, int, int, int)
	 */
	public void glBlendFuncSeparateIndexedAMD(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
		getCurrent().glBlendFuncSeparateIndexedAMD(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
	}

	/**
	 * @param srcX0
	 * @param srcY0
	 * @param srcX1
	 * @param srcY1
	 * @param dstX0
	 * @param dstY0
	 * @param dstX1
	 * @param dstY1
	 * @param mask
	 * @param filter
	 * @see javax.media.opengl.GL2#glBlitFramebuffer(int, int, int, int, int, int, int, int, int, int)
	 */
	public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
		getCurrent().glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
	}

	/**
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glBufferParameteri(int, int, int)
	 */
	public void glBufferParameteri(int target, int pname, int param) {
		getCurrent().glBufferParameteri(target, pname, param);
	}

	/**
	 * @param list
	 * @see javax.media.opengl.GL2#glCallList(int)
	 */
	public void glCallList(int list) {
		getCurrent().glCallList(list);
	}

	/**
	 * @param n
	 * @param type
	 * @param lists
	 * @see javax.media.opengl.GL2#glCallLists(int, int, java.nio.Buffer)
	 */
	public void glCallLists(int n, int type, Buffer lists) {
		getCurrent().glCallLists(n, type, lists);
	}

	/**
	 * @param framebuffer
	 * @param target
	 * @return
	 * @see javax.media.opengl.GL2#glCheckNamedFramebufferStatusEXT(int, int)
	 */
	public int glCheckNamedFramebufferStatusEXT(int framebuffer, int target) {
		return getCurrent().glCheckNamedFramebufferStatusEXT(framebuffer, target);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glClearAccum(float, float, float, float)
	 */
	public void glClearAccum(float red, float green, float blue, float alpha) {
		getCurrent().glClearAccum(red, green, blue, alpha);
	}

	/**
	 * @param buffer
	 * @param drawbuffer
	 * @param depth
	 * @param stencil
	 * @see javax.media.opengl.GL2#glClearBufferfi(int, int, float, int)
	 */
	public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
		getCurrent().glClearBufferfi(buffer, drawbuffer, depth, stencil);
	}

	/**
	 * @param buffer
	 * @param drawbuffer
	 * @param value
	 * @see javax.media.opengl.GL2#glClearBufferfv(int, int, java.nio.FloatBuffer)
	 */
	public void glClearBufferfv(int buffer, int drawbuffer, FloatBuffer value) {
		getCurrent().glClearBufferfv(buffer, drawbuffer, value);
	}

	/**
	 * @param buffer
	 * @param drawbuffer
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glClearBufferfv(int, int, float[], int)
	 */
	public void glClearBufferfv(int buffer, int drawbuffer, float[] value, int value_offset) {
		getCurrent().glClearBufferfv(buffer, drawbuffer, value, value_offset);
	}

	/**
	 * @param buffer
	 * @param drawbuffer
	 * @param value
	 * @see javax.media.opengl.GL2#glClearBufferiv(int, int, java.nio.IntBuffer)
	 */
	public void glClearBufferiv(int buffer, int drawbuffer, IntBuffer value) {
		getCurrent().glClearBufferiv(buffer, drawbuffer, value);
	}

	/**
	 * @param buffer
	 * @param drawbuffer
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glClearBufferiv(int, int, int[], int)
	 */
	public void glClearBufferiv(int buffer, int drawbuffer, int[] value, int value_offset) {
		getCurrent().glClearBufferiv(buffer, drawbuffer, value, value_offset);
	}

	/**
	 * @param buffer
	 * @param drawbuffer
	 * @param value
	 * @see javax.media.opengl.GL2#glClearBufferuiv(int, int, java.nio.IntBuffer)
	 */
	public void glClearBufferuiv(int buffer, int drawbuffer, IntBuffer value) {
		getCurrent().glClearBufferuiv(buffer, drawbuffer, value);
	}

	/**
	 * @param buffer
	 * @param drawbuffer
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glClearBufferuiv(int, int, int[], int)
	 */
	public void glClearBufferuiv(int buffer, int drawbuffer, int[] value, int value_offset) {
		getCurrent().glClearBufferuiv(buffer, drawbuffer, value, value_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glClearColorIi(int, int, int, int)
	 */
	public void glClearColorIi(int red, int green, int blue, int alpha) {
		getCurrent().glClearColorIi(red, green, blue, alpha);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glClearColorIui(int, int, int, int)
	 */
	public void glClearColorIui(int red, int green, int blue, int alpha) {
		getCurrent().glClearColorIui(red, green, blue, alpha);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glClearIndex(float)
	 */
	public void glClearIndex(float c) {
		getCurrent().glClearIndex(c);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL2#glClientAttribDefaultEXT(int)
	 */
	public void glClientAttribDefaultEXT(int mask) {
		getCurrent().glClientAttribDefaultEXT(mask);
	}

	/**
	 * @param plane
	 * @param equation
	 * @see javax.media.opengl.GL2#glClipPlane(int, java.nio.DoubleBuffer)
	 */
	public void glClipPlane(int plane, DoubleBuffer equation) {
		getCurrent().glClipPlane(plane, equation);
	}

	/**
	 * @param plane
	 * @param equation
	 * @param equation_offset
	 * @see javax.media.opengl.GL2#glClipPlane(int, double[], int)
	 */
	public void glClipPlane(int plane, double[] equation, int equation_offset) {
		getCurrent().glClipPlane(plane, equation, equation_offset);
	}

	/**
	 * @param plane
	 * @param equation
	 * @see javax.media.opengl.GL2#glClipPlanef(int, java.nio.FloatBuffer)
	 */
	public void glClipPlanef(int plane, FloatBuffer equation) {
		getCurrent().glClipPlanef(plane, equation);
	}

	/**
	 * @param plane
	 * @param equation
	 * @param equation_offset
	 * @see javax.media.opengl.GL2#glClipPlanef(int, float[], int)
	 */
	public void glClipPlanef(int plane, float[] equation, int equation_offset) {
		getCurrent().glClipPlanef(plane, equation, equation_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3b(byte, byte, byte)
	 */
	public void glColor3b(byte red, byte green, byte blue) {
		getCurrent().glColor3b(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3bv(java.nio.ByteBuffer)
	 */
	public void glColor3bv(ByteBuffer v) {
		getCurrent().glColor3bv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3bv(byte[], int)
	 */
	public void glColor3bv(byte[] v, int v_offset) {
		getCurrent().glColor3bv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3d(double, double, double)
	 */
	public void glColor3d(double red, double green, double blue) {
		getCurrent().glColor3d(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3dv(java.nio.DoubleBuffer)
	 */
	public void glColor3dv(DoubleBuffer v) {
		getCurrent().glColor3dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3dv(double[], int)
	 */
	public void glColor3dv(double[] v, int v_offset) {
		getCurrent().glColor3dv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3f(float, float, float)
	 */
	public void glColor3f(float red, float green, float blue) {
		getCurrent().glColor3f(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3fv(java.nio.FloatBuffer)
	 */
	public void glColor3fv(FloatBuffer v) {
		getCurrent().glColor3fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3fv(float[], int)
	 */
	public void glColor3fv(float[] v, int v_offset) {
		getCurrent().glColor3fv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3h(short, short, short)
	 */
	public void glColor3h(short red, short green, short blue) {
		getCurrent().glColor3h(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3hv(java.nio.ShortBuffer)
	 */
	public void glColor3hv(ShortBuffer v) {
		getCurrent().glColor3hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3hv(short[], int)
	 */
	public void glColor3hv(short[] v, int v_offset) {
		getCurrent().glColor3hv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3i(int, int, int)
	 */
	public void glColor3i(int red, int green, int blue) {
		getCurrent().glColor3i(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3iv(java.nio.IntBuffer)
	 */
	public void glColor3iv(IntBuffer v) {
		getCurrent().glColor3iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3iv(int[], int)
	 */
	public void glColor3iv(int[] v, int v_offset) {
		getCurrent().glColor3iv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3s(short, short, short)
	 */
	public void glColor3s(short red, short green, short blue) {
		getCurrent().glColor3s(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3sv(java.nio.ShortBuffer)
	 */
	public void glColor3sv(ShortBuffer v) {
		getCurrent().glColor3sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3sv(short[], int)
	 */
	public void glColor3sv(short[] v, int v_offset) {
		getCurrent().glColor3sv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3ub(byte, byte, byte)
	 */
	public void glColor3ub(byte red, byte green, byte blue) {
		getCurrent().glColor3ub(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3ubv(java.nio.ByteBuffer)
	 */
	public void glColor3ubv(ByteBuffer v) {
		getCurrent().glColor3ubv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3ubv(byte[], int)
	 */
	public void glColor3ubv(byte[] v, int v_offset) {
		getCurrent().glColor3ubv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3ui(int, int, int)
	 */
	public void glColor3ui(int red, int green, int blue) {
		getCurrent().glColor3ui(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3uiv(java.nio.IntBuffer)
	 */
	public void glColor3uiv(IntBuffer v) {
		getCurrent().glColor3uiv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3uiv(int[], int)
	 */
	public void glColor3uiv(int[] v, int v_offset) {
		getCurrent().glColor3uiv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glColor3us(short, short, short)
	 */
	public void glColor3us(short red, short green, short blue) {
		getCurrent().glColor3us(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor3usv(java.nio.ShortBuffer)
	 */
	public void glColor3usv(ShortBuffer v) {
		getCurrent().glColor3usv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor3usv(short[], int)
	 */
	public void glColor3usv(short[] v, int v_offset) {
		getCurrent().glColor3usv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glColor4b(byte, byte, byte, byte)
	 */
	public void glColor4b(byte red, byte green, byte blue, byte alpha) {
		getCurrent().glColor4b(red, green, blue, alpha);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4bv(java.nio.ByteBuffer)
	 */
	public void glColor4bv(ByteBuffer v) {
		getCurrent().glColor4bv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4bv(byte[], int)
	 */
	public void glColor4bv(byte[] v, int v_offset) {
		getCurrent().glColor4bv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glColor4d(double, double, double, double)
	 */
	public void glColor4d(double red, double green, double blue, double alpha) {
		getCurrent().glColor4d(red, green, blue, alpha);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4dv(java.nio.DoubleBuffer)
	 */
	public void glColor4dv(DoubleBuffer v) {
		getCurrent().glColor4dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4dv(double[], int)
	 */
	public void glColor4dv(double[] v, int v_offset) {
		getCurrent().glColor4dv(v, v_offset);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4fv(java.nio.FloatBuffer)
	 */
	public void glColor4fv(FloatBuffer v) {
		getCurrent().glColor4fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4fv(float[], int)
	 */
	public void glColor4fv(float[] v, int v_offset) {
		getCurrent().glColor4fv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glColor4h(short, short, short, short)
	 */
	public void glColor4h(short red, short green, short blue, short alpha) {
		getCurrent().glColor4h(red, green, blue, alpha);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4hv(java.nio.ShortBuffer)
	 */
	public void glColor4hv(ShortBuffer v) {
		getCurrent().glColor4hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4hv(short[], int)
	 */
	public void glColor4hv(short[] v, int v_offset) {
		getCurrent().glColor4hv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glColor4i(int, int, int, int)
	 */
	public void glColor4i(int red, int green, int blue, int alpha) {
		getCurrent().glColor4i(red, green, blue, alpha);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4iv(java.nio.IntBuffer)
	 */
	public void glColor4iv(IntBuffer v) {
		getCurrent().glColor4iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4iv(int[], int)
	 */
	public void glColor4iv(int[] v, int v_offset) {
		getCurrent().glColor4iv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glColor4s(short, short, short, short)
	 */
	public void glColor4s(short red, short green, short blue, short alpha) {
		getCurrent().glColor4s(red, green, blue, alpha);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4sv(java.nio.ShortBuffer)
	 */
	public void glColor4sv(ShortBuffer v) {
		getCurrent().glColor4sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4sv(short[], int)
	 */
	public void glColor4sv(short[] v, int v_offset) {
		getCurrent().glColor4sv(v, v_offset);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4ubv(java.nio.ByteBuffer)
	 */
	public void glColor4ubv(ByteBuffer v) {
		getCurrent().glColor4ubv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4ubv(byte[], int)
	 */
	public void glColor4ubv(byte[] v, int v_offset) {
		getCurrent().glColor4ubv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glColor4ui(int, int, int, int)
	 */
	public void glColor4ui(int red, int green, int blue, int alpha) {
		getCurrent().glColor4ui(red, green, blue, alpha);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4uiv(java.nio.IntBuffer)
	 */
	public void glColor4uiv(IntBuffer v) {
		getCurrent().glColor4uiv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4uiv(int[], int)
	 */
	public void glColor4uiv(int[] v, int v_offset) {
		getCurrent().glColor4uiv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @see javax.media.opengl.GL2#glColor4us(short, short, short, short)
	 */
	public void glColor4us(short red, short green, short blue, short alpha) {
		getCurrent().glColor4us(red, green, blue, alpha);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glColor4usv(java.nio.ShortBuffer)
	 */
	public void glColor4usv(ShortBuffer v) {
		getCurrent().glColor4usv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glColor4usv(short[], int)
	 */
	public void glColor4usv(short[] v, int v_offset) {
		getCurrent().glColor4usv(v, v_offset);
	}

	/**
	 * @param index
	 * @param r
	 * @param g
	 * @param b
	 * @param a
	 * @see javax.media.opengl.GL2#glColorMaskIndexed(int, boolean, boolean, boolean, boolean)
	 */
	public void glColorMaskIndexed(int index, boolean r, boolean g, boolean b, boolean a) {
		getCurrent().glColorMaskIndexed(index, r, g, b, a);
	}

	/**
	 * @param face
	 * @param mode
	 * @see javax.media.opengl.GL2#glColorMaterial(int, int)
	 */
	public void glColorMaterial(int face, int mode) {
		getCurrent().glColorMaterial(face, mode);
	}

	/**
	 * @param target
	 * @param start
	 * @param count
	 * @param format
	 * @param type
	 * @param data
	 * @see javax.media.opengl.GL2#glColorSubTable(int, int, int, int, int, java.nio.Buffer)
	 */
	public void glColorSubTable(int target, int start, int count, int format, int type, Buffer data) {
		getCurrent().glColorSubTable(target, start, count, format, type, data);
	}

	/**
	 * @param target
	 * @param start
	 * @param count
	 * @param format
	 * @param type
	 * @param data_buffer_offset
	 * @see javax.media.opengl.GL2#glColorSubTable(int, int, int, int, int, long)
	 */
	public void glColorSubTable(int target, int start, int count, int format, int type, long data_buffer_offset) {
		getCurrent().glColorSubTable(target, start, count, format, type, data_buffer_offset);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param format
	 * @param type
	 * @param table
	 * @see javax.media.opengl.GL2#glColorTable(int, int, int, int, int, java.nio.Buffer)
	 */
	public void glColorTable(int target, int internalformat, int width, int format, int type, Buffer table) {
		getCurrent().glColorTable(target, internalformat, width, format, type, table);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param format
	 * @param type
	 * @param table_buffer_offset
	 * @see javax.media.opengl.GL2#glColorTable(int, int, int, int, int, long)
	 */
	public void glColorTable(int target, int internalformat, int width, int format, int type, long table_buffer_offset) {
		getCurrent().glColorTable(target, internalformat, width, format, type, table_buffer_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glColorTableParameterfv(int, int, java.nio.FloatBuffer)
	 */
	public void glColorTableParameterfv(int target, int pname, FloatBuffer params) {
		getCurrent().glColorTableParameterfv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glColorTableParameterfv(int, int, float[], int)
	 */
	public void glColorTableParameterfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glColorTableParameterfv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glColorTableParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glColorTableParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glColorTableParameteriv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glColorTableParameteriv(int, int, int[], int)
	 */
	public void glColorTableParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glColorTableParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param shaderObj
	 * @see javax.media.opengl.GL2#glCompileShaderARB(int)
	 */
	public void glCompileShaderARB(int shaderObj) {
		getCurrent().glCompileShaderARB(shaderObj);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param border
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedMultiTexImage1DEXT(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int imageSize, Buffer bits) {
		getCurrent().glCompressedMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, imageSize, bits);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param border
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedMultiTexImage2DEXT(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int imageSize, Buffer bits) {
		getCurrent().glCompressedMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, imageSize, bits);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @param border
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedMultiTexImage3DEXT(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Buffer bits) {
		getCurrent().glCompressedMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, imageSize, bits);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param width
	 * @param format
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedMultiTexSubImage1DEXT(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int imageSize, Buffer bits) {
		getCurrent().glCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, imageSize, bits);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param width
	 * @param height
	 * @param format
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedMultiTexSubImage2DEXT(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Buffer bits) {
		getCurrent().glCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedMultiTexSubImage3DEXT(int, int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Buffer bits) {
		getCurrent().glCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param border
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedTextureImage1DEXT(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int imageSize, Buffer bits) {
		getCurrent().glCompressedTextureImage1DEXT(texture, target, level, internalformat, width, border, imageSize, bits);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param border
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedTextureImage2DEXT(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int imageSize, Buffer bits) {
		getCurrent().glCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, imageSize, bits);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @param border
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedTextureImage3DEXT(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Buffer bits) {
		getCurrent().glCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, imageSize, bits);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param width
	 * @param format
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedTextureSubImage1DEXT(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int imageSize, Buffer bits) {
		getCurrent().glCompressedTextureSubImage1DEXT(texture, target, level, xoffset, width, format, imageSize, bits);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param width
	 * @param height
	 * @param format
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedTextureSubImage2DEXT(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Buffer bits) {
		getCurrent().glCompressedTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param imageSize
	 * @param bits
	 * @see javax.media.opengl.GL2#glCompressedTextureSubImage3DEXT(int, int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glCompressedTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Buffer bits) {
		getCurrent().glCompressedTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param format
	 * @param type
	 * @param image
	 * @see javax.media.opengl.GL2#glConvolutionFilter1D(int, int, int, int, int, java.nio.Buffer)
	 */
	public void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, Buffer image) {
		getCurrent().glConvolutionFilter1D(target, internalformat, width, format, type, image);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param format
	 * @param type
	 * @param image_buffer_offset
	 * @see javax.media.opengl.GL2#glConvolutionFilter1D(int, int, int, int, int, long)
	 */
	public void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, long image_buffer_offset) {
		getCurrent().glConvolutionFilter1D(target, internalformat, width, format, type, image_buffer_offset);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param image
	 * @see javax.media.opengl.GL2#glConvolutionFilter2D(int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, Buffer image) {
		getCurrent().glConvolutionFilter2D(target, internalformat, width, height, format, type, image);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param image_buffer_offset
	 * @see javax.media.opengl.GL2#glConvolutionFilter2D(int, int, int, int, int, int, long)
	 */
	public void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, long image_buffer_offset) {
		getCurrent().glConvolutionFilter2D(target, internalformat, width, height, format, type, image_buffer_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glConvolutionParameterf(int, int, float)
	 */
	public void glConvolutionParameterf(int target, int pname, float params) {
		getCurrent().glConvolutionParameterf(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glConvolutionParameterfv(int, int, java.nio.FloatBuffer)
	 */
	public void glConvolutionParameterfv(int target, int pname, FloatBuffer params) {
		getCurrent().glConvolutionParameterfv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glConvolutionParameterfv(int, int, float[], int)
	 */
	public void glConvolutionParameterfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glConvolutionParameterfv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glConvolutionParameteri(int, int, int)
	 */
	public void glConvolutionParameteri(int target, int pname, int params) {
		getCurrent().glConvolutionParameteri(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glConvolutionParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glConvolutionParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glConvolutionParameteriv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glConvolutionParameteriv(int, int, int[], int)
	 */
	public void glConvolutionParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glConvolutionParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param readTarget
	 * @param writeTarget
	 * @param readOffset
	 * @param writeOffset
	 * @param size
	 * @see javax.media.opengl.GL2#glCopyBufferSubData(int, int, long, long, long)
	 */
	public void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
		getCurrent().glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
	}

	/**
	 * @param target
	 * @param start
	 * @param x
	 * @param y
	 * @param width
	 * @see javax.media.opengl.GL2#glCopyColorSubTable(int, int, int, int, int)
	 */
	public void glCopyColorSubTable(int target, int start, int x, int y, int width) {
		getCurrent().glCopyColorSubTable(target, start, x, y, width);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @see javax.media.opengl.GL2#glCopyColorTable(int, int, int, int, int)
	 */
	public void glCopyColorTable(int target, int internalformat, int x, int y, int width) {
		getCurrent().glCopyColorTable(target, internalformat, x, y, width);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @see javax.media.opengl.GL2#glCopyConvolutionFilter1D(int, int, int, int, int)
	 */
	public void glCopyConvolutionFilter1D(int target, int internalformat, int x, int y, int width) {
		getCurrent().glCopyConvolutionFilter1D(target, internalformat, x, y, width);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glCopyConvolutionFilter2D(int, int, int, int, int, int)
	 */
	public void glCopyConvolutionFilter2D(int target, int internalformat, int x, int y, int width, int height) {
		getCurrent().glCopyConvolutionFilter2D(target, internalformat, x, y, width, height);
	}

	/**
	 * @param srcName
	 * @param srcTarget
	 * @param srcLevel
	 * @param srcX
	 * @param srcY
	 * @param srcZ
	 * @param dstName
	 * @param dstTarget
	 * @param dstLevel
	 * @param dstX
	 * @param dstY
	 * @param dstZ
	 * @param width
	 * @param height
	 * @param depth
	 * @see javax.media.opengl.GL2#glCopyImageSubDataNV(int, int, int, int, int, int, int, int, int, int, int, int, int, int, int)
	 */
	public void glCopyImageSubDataNV(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
		getCurrent().glCopyImageSubDataNV(srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @param border
	 * @see javax.media.opengl.GL2#glCopyMultiTexImage1DEXT(int, int, int, int, int, int, int, int)
	 */
	public void glCopyMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int border) {
		getCurrent().glCopyMultiTexImage1DEXT(texunit, target, level, internalformat, x, y, width, border);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param border
	 * @see javax.media.opengl.GL2#glCopyMultiTexImage2DEXT(int, int, int, int, int, int, int, int, int)
	 */
	public void glCopyMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
		getCurrent().glCopyMultiTexImage2DEXT(texunit, target, level, internalformat, x, y, width, height, border);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param x
	 * @param y
	 * @param width
	 * @see javax.media.opengl.GL2#glCopyMultiTexSubImage1DEXT(int, int, int, int, int, int, int)
	 */
	public void glCopyMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int x, int y, int width) {
		getCurrent().glCopyMultiTexSubImage1DEXT(texunit, target, level, xoffset, x, y, width);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glCopyMultiTexSubImage2DEXT(int, int, int, int, int, int, int, int, int)
	 */
	public void glCopyMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
		getCurrent().glCopyMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, x, y, width, height);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glCopyMultiTexSubImage3DEXT(int, int, int, int, int, int, int, int, int, int)
	 */
	public void glCopyMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
		getCurrent().glCopyMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, x, y, width, height);
	}

	/**
	 * @param resultPath
	 * @param srcPath
	 * @see javax.media.opengl.GL2#glCopyPathNV(int, int)
	 */
	public void glCopyPathNV(int resultPath, int srcPath) {
		getCurrent().glCopyPathNV(resultPath, srcPath);
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param type
	 * @see javax.media.opengl.GL2#glCopyPixels(int, int, int, int, int)
	 */
	public void glCopyPixels(int x, int y, int width, int height, int type) {
		getCurrent().glCopyPixels(x, y, width, height, type);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @param border
	 * @see javax.media.opengl.GL2#glCopyTextureImage1DEXT(int, int, int, int, int, int, int, int)
	 */
	public void glCopyTextureImage1DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int border) {
		getCurrent().glCopyTextureImage1DEXT(texture, target, level, internalformat, x, y, width, border);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param border
	 * @see javax.media.opengl.GL2#glCopyTextureImage2DEXT(int, int, int, int, int, int, int, int, int)
	 */
	public void glCopyTextureImage2DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
		getCurrent().glCopyTextureImage2DEXT(texture, target, level, internalformat, x, y, width, height, border);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param x
	 * @param y
	 * @param width
	 * @see javax.media.opengl.GL2#glCopyTextureSubImage1DEXT(int, int, int, int, int, int, int)
	 */
	public void glCopyTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int x, int y, int width) {
		getCurrent().glCopyTextureSubImage1DEXT(texture, target, level, xoffset, x, y, width);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glCopyTextureSubImage2DEXT(int, int, int, int, int, int, int, int, int)
	 */
	public void glCopyTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
		getCurrent().glCopyTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, x, y, width, height);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glCopyTextureSubImage3DEXT(int, int, int, int, int, int, int, int, int, int)
	 */
	public void glCopyTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
		getCurrent().glCopyTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, x, y, width, height);
	}

	/**
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param coverMode
	 * @param transformType
	 * @param transformValues
	 * @see javax.media.opengl.GL2#glCoverFillPathInstancedNV(int, int, java.nio.Buffer, int, int, int, java.nio.FloatBuffer)
	 */
	public void glCoverFillPathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int coverMode, int transformType, FloatBuffer transformValues) {
		getCurrent().glCoverFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
	}

	/**
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param coverMode
	 * @param transformType
	 * @param transformValues
	 * @param transformValues_offset
	 * @see javax.media.opengl.GL2#glCoverFillPathInstancedNV(int, int, java.nio.Buffer, int, int, int, float[], int)
	 */
	public void glCoverFillPathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int coverMode, int transformType, float[] transformValues, int transformValues_offset) {
		getCurrent().glCoverFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues, transformValues_offset);
	}

	/**
	 * @param path
	 * @param coverMode
	 * @see javax.media.opengl.GL2#glCoverFillPathNV(int, int)
	 */
	public void glCoverFillPathNV(int path, int coverMode) {
		getCurrent().glCoverFillPathNV(path, coverMode);
	}

	/**
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param coverMode
	 * @param transformType
	 * @param transformValues
	 * @see javax.media.opengl.GL2#glCoverStrokePathInstancedNV(int, int, java.nio.Buffer, int, int, int, java.nio.FloatBuffer)
	 */
	public void glCoverStrokePathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int coverMode, int transformType, FloatBuffer transformValues) {
		getCurrent().glCoverStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
	}

	/**
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param coverMode
	 * @param transformType
	 * @param transformValues
	 * @param transformValues_offset
	 * @see javax.media.opengl.GL2#glCoverStrokePathInstancedNV(int, int, java.nio.Buffer, int, int, int, float[], int)
	 */
	public void glCoverStrokePathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int coverMode, int transformType, float[] transformValues, int transformValues_offset) {
		getCurrent().glCoverStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues, transformValues_offset);
	}

	/**
	 * @param path
	 * @param coverMode
	 * @see javax.media.opengl.GL2#glCoverStrokePathNV(int, int)
	 */
	public void glCoverStrokePathNV(int path, int coverMode) {
		getCurrent().glCoverStrokePathNV(path, coverMode);
	}

	/**
	 * @return
	 * @see javax.media.opengl.GL2#glCreateProgramObjectARB()
	 */
	public int glCreateProgramObjectARB() {
		return getCurrent().glCreateProgramObjectARB();
	}

	/**
	 * @param shaderType
	 * @return
	 * @see javax.media.opengl.GL2#glCreateShaderObjectARB(int)
	 */
	public int glCreateShaderObjectARB(int shaderType) {
		return getCurrent().glCreateShaderObjectARB(shaderType);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glCullParameterdvEXT(int, java.nio.DoubleBuffer)
	 */
	public void glCullParameterdvEXT(int pname, DoubleBuffer params) {
		getCurrent().glCullParameterdvEXT(pname, params);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glCullParameterdvEXT(int, double[], int)
	 */
	public void glCullParameterdvEXT(int pname, double[] params, int params_offset) {
		getCurrent().glCullParameterdvEXT(pname, params, params_offset);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glCullParameterfvEXT(int, java.nio.FloatBuffer)
	 */
	public void glCullParameterfvEXT(int pname, FloatBuffer params) {
		getCurrent().glCullParameterfvEXT(pname, params);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glCullParameterfvEXT(int, float[], int)
	 */
	public void glCullParameterfvEXT(int pname, float[] params, int params_offset) {
		getCurrent().glCullParameterfvEXT(pname, params, params_offset);
	}

	/**
	 * @param index
	 * @see javax.media.opengl.GL2#glCurrentPaletteMatrix(int)
	 */
	public void glCurrentPaletteMatrix(int index) {
		getCurrent().glCurrentPaletteMatrix(index);
	}

	/**
	 * @param n
	 * @param fences
	 * @see javax.media.opengl.GL2#glDeleteFencesAPPLE(int, java.nio.IntBuffer)
	 */
	public void glDeleteFencesAPPLE(int n, IntBuffer fences) {
		getCurrent().glDeleteFencesAPPLE(n, fences);
	}

	/**
	 * @param n
	 * @param fences
	 * @param fences_offset
	 * @see javax.media.opengl.GL2#glDeleteFencesAPPLE(int, int[], int)
	 */
	public void glDeleteFencesAPPLE(int n, int[] fences, int fences_offset) {
		getCurrent().glDeleteFencesAPPLE(n, fences, fences_offset);
	}

	/**
	 * @param n
	 * @param fences
	 * @see javax.media.opengl.GL2#glDeleteFencesNV(int, java.nio.IntBuffer)
	 */
	public void glDeleteFencesNV(int n, IntBuffer fences) {
		getCurrent().glDeleteFencesNV(n, fences);
	}

	/**
	 * @param n
	 * @param fences
	 * @param fences_offset
	 * @see javax.media.opengl.GL2#glDeleteFencesNV(int, int[], int)
	 */
	public void glDeleteFencesNV(int n, int[] fences, int fences_offset) {
		getCurrent().glDeleteFencesNV(n, fences, fences_offset);
	}

	/**
	 * @param list
	 * @param range
	 * @see javax.media.opengl.GL2#glDeleteLists(int, int)
	 */
	public void glDeleteLists(int list, int range) {
		getCurrent().glDeleteLists(list, range);
	}

	/**
	 * @param identifier
	 * @param num
	 * @param names
	 * @see javax.media.opengl.GL2#glDeleteNamesAMD(int, int, java.nio.IntBuffer)
	 */
	public void glDeleteNamesAMD(int identifier, int num, IntBuffer names) {
		getCurrent().glDeleteNamesAMD(identifier, num, names);
	}

	/**
	 * @param identifier
	 * @param num
	 * @param names
	 * @param names_offset
	 * @see javax.media.opengl.GL2#glDeleteNamesAMD(int, int, int[], int)
	 */
	public void glDeleteNamesAMD(int identifier, int num, int[] names, int names_offset) {
		getCurrent().glDeleteNamesAMD(identifier, num, names, names_offset);
	}

	/**
	 * @param obj
	 * @see javax.media.opengl.GL2#glDeleteObjectARB(int)
	 */
	public void glDeleteObjectARB(int obj) {
		getCurrent().glDeleteObjectARB(obj);
	}

	/**
	 * @param n
	 * @param ids
	 * @see javax.media.opengl.GL2#glDeleteOcclusionQueriesNV(int, java.nio.IntBuffer)
	 */
	public void glDeleteOcclusionQueriesNV(int n, IntBuffer ids) {
		getCurrent().glDeleteOcclusionQueriesNV(n, ids);
	}

	/**
	 * @param n
	 * @param ids
	 * @param ids_offset
	 * @see javax.media.opengl.GL2#glDeleteOcclusionQueriesNV(int, int[], int)
	 */
	public void glDeleteOcclusionQueriesNV(int n, int[] ids, int ids_offset) {
		getCurrent().glDeleteOcclusionQueriesNV(n, ids, ids_offset);
	}

	/**
	 * @param path
	 * @param range
	 * @see javax.media.opengl.GL2#glDeletePathsNV(int, int)
	 */
	public void glDeletePathsNV(int path, int range) {
		getCurrent().glDeletePathsNV(path, range);
	}

	/**
	 * @param n
	 * @param monitors
	 * @see javax.media.opengl.GL2#glDeletePerfMonitorsAMD(int, java.nio.IntBuffer)
	 */
	public void glDeletePerfMonitorsAMD(int n, IntBuffer monitors) {
		getCurrent().glDeletePerfMonitorsAMD(n, monitors);
	}

	/**
	 * @param n
	 * @param monitors
	 * @param monitors_offset
	 * @see javax.media.opengl.GL2#glDeletePerfMonitorsAMD(int, int[], int)
	 */
	public void glDeletePerfMonitorsAMD(int n, int[] monitors, int monitors_offset) {
		getCurrent().glDeletePerfMonitorsAMD(n, monitors, monitors_offset);
	}

	/**
	 * @param n
	 * @param programs
	 * @see javax.media.opengl.GL2#glDeleteProgramsARB(int, java.nio.IntBuffer)
	 */
	public void glDeleteProgramsARB(int n, IntBuffer programs) {
		getCurrent().glDeleteProgramsARB(n, programs);
	}

	/**
	 * @param n
	 * @param programs
	 * @param programs_offset
	 * @see javax.media.opengl.GL2#glDeleteProgramsARB(int, int[], int)
	 */
	public void glDeleteProgramsARB(int n, int[] programs, int programs_offset) {
		getCurrent().glDeleteProgramsARB(n, programs, programs_offset);
	}

	/**
	 * @param n
	 * @param ids
	 * @see javax.media.opengl.GL2#glDeleteTransformFeedbacksNV(int, java.nio.IntBuffer)
	 */
	public void glDeleteTransformFeedbacksNV(int n, IntBuffer ids) {
		getCurrent().glDeleteTransformFeedbacksNV(n, ids);
	}

	/**
	 * @param n
	 * @param ids
	 * @param ids_offset
	 * @see javax.media.opengl.GL2#glDeleteTransformFeedbacksNV(int, int[], int)
	 */
	public void glDeleteTransformFeedbacksNV(int n, int[] ids, int ids_offset) {
		getCurrent().glDeleteTransformFeedbacksNV(n, ids, ids_offset);
	}

	/**
	 * @param n
	 * @param arrays
	 * @see javax.media.opengl.GL2#glDeleteVertexArrays(int, java.nio.IntBuffer)
	 */
	public void glDeleteVertexArrays(int n, IntBuffer arrays) {
		getCurrent().glDeleteVertexArrays(n, arrays);
	}

	/**
	 * @param n
	 * @param arrays
	 * @param arrays_offset
	 * @see javax.media.opengl.GL2#glDeleteVertexArrays(int, int[], int)
	 */
	public void glDeleteVertexArrays(int n, int[] arrays, int arrays_offset) {
		getCurrent().glDeleteVertexArrays(n, arrays, arrays_offset);
	}

	/**
	 * @param id
	 * @see javax.media.opengl.GL2#glDeleteVertexShaderEXT(int)
	 */
	public void glDeleteVertexShaderEXT(int id) {
		getCurrent().glDeleteVertexShaderEXT(id);
	}

	/**
	 * @param zmin
	 * @param zmax
	 * @see javax.media.opengl.GL2#glDepthBoundsEXT(double, double)
	 */
	public void glDepthBoundsEXT(double zmin, double zmax) {
		getCurrent().glDepthBoundsEXT(zmin, zmax);
	}

	/**
	 * @param containerObj
	 * @param attachedObj
	 * @see javax.media.opengl.GL2#glDetachObjectARB(int, int)
	 */
	public void glDetachObjectARB(int containerObj, int attachedObj) {
		getCurrent().glDetachObjectARB(containerObj, attachedObj);
	}

	/**
	 * @param array
	 * @param index
	 * @see javax.media.opengl.GL2#glDisableClientStateIndexedEXT(int, int)
	 */
	public void glDisableClientStateIndexedEXT(int array, int index) {
		getCurrent().glDisableClientStateIndexedEXT(array, index);
	}

	/**
	 * @param array
	 * @param index
	 * @see javax.media.opengl.GL2#glDisableClientStateiEXT(int, int)
	 */
	public void glDisableClientStateiEXT(int array, int index) {
		getCurrent().glDisableClientStateiEXT(array, index);
	}

	/**
	 * @param target
	 * @param index
	 * @see javax.media.opengl.GL2#glDisableIndexed(int, int)
	 */
	public void glDisableIndexed(int target, int index) {
		getCurrent().glDisableIndexed(target, index);
	}

	/**
	 * @param id
	 * @see javax.media.opengl.GL2#glDisableVariantClientStateEXT(int)
	 */
	public void glDisableVariantClientStateEXT(int id) {
		getCurrent().glDisableVariantClientStateEXT(id);
	}

	/**
	 * @param vaobj
	 * @param index
	 * @see javax.media.opengl.GL2#glDisableVertexArrayAttribEXT(int, int)
	 */
	public void glDisableVertexArrayAttribEXT(int vaobj, int index) {
		getCurrent().glDisableVertexArrayAttribEXT(vaobj, index);
	}

	/**
	 * @param vaobj
	 * @param array
	 * @see javax.media.opengl.GL2#glDisableVertexArrayEXT(int, int)
	 */
	public void glDisableVertexArrayEXT(int vaobj, int array) {
		getCurrent().glDisableVertexArrayEXT(vaobj, array);
	}

	/**
	 * @param index
	 * @param pname
	 * @see javax.media.opengl.GL2#glDisableVertexAttribAPPLE(int, int)
	 */
	public void glDisableVertexAttribAPPLE(int index, int pname) {
		getCurrent().glDisableVertexAttribAPPLE(index, pname);
	}

	/**
	 * @param index
	 * @see javax.media.opengl.GL2#glDisableVertexAttribArrayARB(int)
	 */
	public void glDisableVertexAttribArrayARB(int index) {
		getCurrent().glDisableVertexAttribArrayARB(index);
	}

	/**
	 * @param mode
	 * @param first
	 * @param count
	 * @param instancecount
	 * @see javax.media.opengl.GL2#glDrawArraysInstanced(int, int, int, int)
	 */
	public void glDrawArraysInstanced(int mode, int first, int count, int instancecount) {
		getCurrent().glDrawArraysInstanced(mode, first, count, instancecount);
	}

	/**
	 * @param n
	 * @param bufs
	 * @see javax.media.opengl.GL2#glDrawBuffers(int, java.nio.IntBuffer)
	 */
	public void glDrawBuffers(int n, IntBuffer bufs) {
		getCurrent().glDrawBuffers(n, bufs);
	}

	/**
	 * @param n
	 * @param bufs
	 * @param bufs_offset
	 * @see javax.media.opengl.GL2#glDrawBuffers(int, int[], int)
	 */
	public void glDrawBuffers(int n, int[] bufs, int bufs_offset) {
		getCurrent().glDrawBuffers(n, bufs, bufs_offset);
	}

	/**
	 * @param n
	 * @param bufs
	 * @see javax.media.opengl.GL2#glDrawBuffersATI(int, java.nio.IntBuffer)
	 */
	public void glDrawBuffersATI(int n, IntBuffer bufs) {
		getCurrent().glDrawBuffersATI(n, bufs);
	}

	/**
	 * @param n
	 * @param bufs
	 * @param bufs_offset
	 * @see javax.media.opengl.GL2#glDrawBuffersATI(int, int[], int)
	 */
	public void glDrawBuffersATI(int n, int[] bufs, int bufs_offset) {
		getCurrent().glDrawBuffersATI(n, bufs, bufs_offset);
	}

	/**
	 * @param mode
	 * @param count
	 * @param type
	 * @param indices
	 * @param instancecount
	 * @see javax.media.opengl.GL2#glDrawElementsInstanced(int, int, int, java.nio.Buffer, int)
	 */
	public void glDrawElementsInstanced(int mode, int count, int type, Buffer indices, int instancecount) {
		getCurrent().glDrawElementsInstanced(mode, count, type, indices, instancecount);
	}

	/**
	 * @param mode
	 * @param count
	 * @param type
	 * @param indices_buffer_offset
	 * @param instancecount
	 * @see javax.media.opengl.GL2#glDrawElementsInstanced(int, int, int, long, int)
	 */
	public void glDrawElementsInstanced(int mode, int count, int type, long indices_buffer_offset, int instancecount) {
		getCurrent().glDrawElementsInstanced(mode, count, type, indices_buffer_offset, instancecount);
	}

	/**
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glDrawPixels(int, int, int, int, java.nio.Buffer)
	 */
	public void glDrawPixels(int width, int height, int format, int type, Buffer pixels) {
		getCurrent().glDrawPixels(width, height, format, type, pixels);
	}

	/**
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param pixels_buffer_offset
	 * @see javax.media.opengl.GL2#glDrawPixels(int, int, int, int, long)
	 */
	public void glDrawPixels(int width, int height, int format, int type, long pixels_buffer_offset) {
		getCurrent().glDrawPixels(width, height, format, type, pixels_buffer_offset);
	}

	/**
	 * @param mode
	 * @param start
	 * @param end
	 * @param count
	 * @param type
	 * @param indices
	 * @see javax.media.opengl.GL2#glDrawRangeElements(int, int, int, int, int, java.nio.Buffer)
	 */
	public void glDrawRangeElements(int mode, int start, int end, int count, int type, Buffer indices) {
		getCurrent().glDrawRangeElements(mode, start, end, count, type, indices);
	}

	/**
	 * @param mode
	 * @param start
	 * @param end
	 * @param count
	 * @param type
	 * @param indices_buffer_offset
	 * @see javax.media.opengl.GL2#glDrawRangeElements(int, int, int, int, int, long)
	 */
	public void glDrawRangeElements(int mode, int start, int end, int count, int type, long indices_buffer_offset) {
		getCurrent().glDrawRangeElements(mode, start, end, count, type, indices_buffer_offset);
	}

	/**
	 * @param texture
	 * @param sampler
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @param z
	 * @param s0
	 * @param t0
	 * @param s1
	 * @param t1
	 * @see javax.media.opengl.GL2#glDrawTextureNV(int, int, float, float, float, float, float, float, float, float, float)
	 */
	public void glDrawTextureNV(int texture, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
		getCurrent().glDrawTextureNV(texture, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1);
	}

	/**
	 * @param mode
	 * @param id
	 * @see javax.media.opengl.GL2#glDrawTransformFeedbackNV(int, int)
	 */
	public void glDrawTransformFeedbackNV(int mode, int id) {
		getCurrent().glDrawTransformFeedbackNV(mode, id);
	}

	/**
	 * @param flag
	 * @see javax.media.opengl.GL2#glEdgeFlag(boolean)
	 */
	public void glEdgeFlag(boolean flag) {
		getCurrent().glEdgeFlag(flag);
	}

	/**
	 * @param stride
	 * @param ptr
	 * @see javax.media.opengl.GL2#glEdgeFlagPointer(int, java.nio.Buffer)
	 */
	public void glEdgeFlagPointer(int stride, Buffer ptr) {
		getCurrent().glEdgeFlagPointer(stride, ptr);
	}

	/**
	 * @param stride
	 * @param ptr_buffer_offset
	 * @see javax.media.opengl.GL2#glEdgeFlagPointer(int, long)
	 */
	public void glEdgeFlagPointer(int stride, long ptr_buffer_offset) {
		getCurrent().glEdgeFlagPointer(stride, ptr_buffer_offset);
	}

	/**
	 * @param flag
	 * @see javax.media.opengl.GL2#glEdgeFlagv(java.nio.ByteBuffer)
	 */
	public void glEdgeFlagv(ByteBuffer flag) {
		getCurrent().glEdgeFlagv(flag);
	}

	/**
	 * @param flag
	 * @param flag_offset
	 * @see javax.media.opengl.GL2#glEdgeFlagv(byte[], int)
	 */
	public void glEdgeFlagv(byte[] flag, int flag_offset) {
		getCurrent().glEdgeFlagv(flag, flag_offset);
	}

	/**
	 * @param array
	 * @param index
	 * @see javax.media.opengl.GL2#glEnableClientStateIndexedEXT(int, int)
	 */
	public void glEnableClientStateIndexedEXT(int array, int index) {
		getCurrent().glEnableClientStateIndexedEXT(array, index);
	}

	/**
	 * @param array
	 * @param index
	 * @see javax.media.opengl.GL2#glEnableClientStateiEXT(int, int)
	 */
	public void glEnableClientStateiEXT(int array, int index) {
		getCurrent().glEnableClientStateiEXT(array, index);
	}

	/**
	 * @param target
	 * @param index
	 * @see javax.media.opengl.GL2#glEnableIndexed(int, int)
	 */
	public void glEnableIndexed(int target, int index) {
		getCurrent().glEnableIndexed(target, index);
	}

	/**
	 * @param id
	 * @see javax.media.opengl.GL2#glEnableVariantClientStateEXT(int)
	 */
	public void glEnableVariantClientStateEXT(int id) {
		getCurrent().glEnableVariantClientStateEXT(id);
	}

	/**
	 * @param vaobj
	 * @param index
	 * @see javax.media.opengl.GL2#glEnableVertexArrayAttribEXT(int, int)
	 */
	public void glEnableVertexArrayAttribEXT(int vaobj, int index) {
		getCurrent().glEnableVertexArrayAttribEXT(vaobj, index);
	}

	/**
	 * @param vaobj
	 * @param array
	 * @see javax.media.opengl.GL2#glEnableVertexArrayEXT(int, int)
	 */
	public void glEnableVertexArrayEXT(int vaobj, int array) {
		getCurrent().glEnableVertexArrayEXT(vaobj, array);
	}

	/**
	 * @param index
	 * @param pname
	 * @see javax.media.opengl.GL2#glEnableVertexAttribAPPLE(int, int)
	 */
	public void glEnableVertexAttribAPPLE(int index, int pname) {
		getCurrent().glEnableVertexAttribAPPLE(index, pname);
	}

	/**
	 * @param index
	 * @see javax.media.opengl.GL2#glEnableVertexAttribArrayARB(int)
	 */
	public void glEnableVertexAttribArrayARB(int index) {
		getCurrent().glEnableVertexAttribArrayARB(index);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glEnd()
	 */
	public void glEnd() {
		getCurrent().glEnd();
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glEndConditionalRenderNVX()
	 */
	public void glEndConditionalRenderNVX() {
		getCurrent().glEndConditionalRenderNVX();
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glEndList()
	 */
	public void glEndList() {
		getCurrent().glEndList();
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glEndOcclusionQueryNV()
	 */
	public void glEndOcclusionQueryNV() {
		getCurrent().glEndOcclusionQueryNV();
	}

	/**
	 * @param monitor
	 * @see javax.media.opengl.GL2#glEndPerfMonitorAMD(int)
	 */
	public void glEndPerfMonitorAMD(int monitor) {
		getCurrent().glEndPerfMonitorAMD(monitor);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glEndTransformFeedback()
	 */
	public void glEndTransformFeedback() {
		getCurrent().glEndTransformFeedback();
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glEndVertexShaderEXT()
	 */
	public void glEndVertexShaderEXT() {
		getCurrent().glEndVertexShaderEXT();
	}

	/**
	 * @param video_capture_slot
	 * @see javax.media.opengl.GL2#glEndVideoCaptureNV(int)
	 */
	public void glEndVideoCaptureNV(int video_capture_slot) {
		getCurrent().glEndVideoCaptureNV(video_capture_slot);
	}

	/**
	 * @param u
	 * @see javax.media.opengl.GL2#glEvalCoord1d(double)
	 */
	public void glEvalCoord1d(double u) {
		getCurrent().glEvalCoord1d(u);
	}

	/**
	 * @param u
	 * @see javax.media.opengl.GL2#glEvalCoord1dv(java.nio.DoubleBuffer)
	 */
	public void glEvalCoord1dv(DoubleBuffer u) {
		getCurrent().glEvalCoord1dv(u);
	}

	/**
	 * @param u
	 * @param u_offset
	 * @see javax.media.opengl.GL2#glEvalCoord1dv(double[], int)
	 */
	public void glEvalCoord1dv(double[] u, int u_offset) {
		getCurrent().glEvalCoord1dv(u, u_offset);
	}

	/**
	 * @param u
	 * @see javax.media.opengl.GL2#glEvalCoord1f(float)
	 */
	public void glEvalCoord1f(float u) {
		getCurrent().glEvalCoord1f(u);
	}

	/**
	 * @param u
	 * @see javax.media.opengl.GL2#glEvalCoord1fv(java.nio.FloatBuffer)
	 */
	public void glEvalCoord1fv(FloatBuffer u) {
		getCurrent().glEvalCoord1fv(u);
	}

	/**
	 * @param u
	 * @param u_offset
	 * @see javax.media.opengl.GL2#glEvalCoord1fv(float[], int)
	 */
	public void glEvalCoord1fv(float[] u, int u_offset) {
		getCurrent().glEvalCoord1fv(u, u_offset);
	}

	/**
	 * @param u
	 * @param v
	 * @see javax.media.opengl.GL2#glEvalCoord2d(double, double)
	 */
	public void glEvalCoord2d(double u, double v) {
		getCurrent().glEvalCoord2d(u, v);
	}

	/**
	 * @param u
	 * @see javax.media.opengl.GL2#glEvalCoord2dv(java.nio.DoubleBuffer)
	 */
	public void glEvalCoord2dv(DoubleBuffer u) {
		getCurrent().glEvalCoord2dv(u);
	}

	/**
	 * @param u
	 * @param u_offset
	 * @see javax.media.opengl.GL2#glEvalCoord2dv(double[], int)
	 */
	public void glEvalCoord2dv(double[] u, int u_offset) {
		getCurrent().glEvalCoord2dv(u, u_offset);
	}

	/**
	 * @param u
	 * @param v
	 * @see javax.media.opengl.GL2#glEvalCoord2f(float, float)
	 */
	public void glEvalCoord2f(float u, float v) {
		getCurrent().glEvalCoord2f(u, v);
	}

	/**
	 * @param u
	 * @see javax.media.opengl.GL2#glEvalCoord2fv(java.nio.FloatBuffer)
	 */
	public void glEvalCoord2fv(FloatBuffer u) {
		getCurrent().glEvalCoord2fv(u);
	}

	/**
	 * @param u
	 * @param u_offset
	 * @see javax.media.opengl.GL2#glEvalCoord2fv(float[], int)
	 */
	public void glEvalCoord2fv(float[] u, int u_offset) {
		getCurrent().glEvalCoord2fv(u, u_offset);
	}

	/**
	 * @param target
	 * @param mode
	 * @see javax.media.opengl.GL2#glEvalMapsNV(int, int)
	 */
	public void glEvalMapsNV(int target, int mode) {
		getCurrent().glEvalMapsNV(target, mode);
	}

	/**
	 * @param mode
	 * @param i1
	 * @param i2
	 * @see javax.media.opengl.GL2#glEvalMesh1(int, int, int)
	 */
	public void glEvalMesh1(int mode, int i1, int i2) {
		getCurrent().glEvalMesh1(mode, i1, i2);
	}

	/**
	 * @param mode
	 * @param i1
	 * @param i2
	 * @param j1
	 * @param j2
	 * @see javax.media.opengl.GL2#glEvalMesh2(int, int, int, int, int)
	 */
	public void glEvalMesh2(int mode, int i1, int i2, int j1, int j2) {
		getCurrent().glEvalMesh2(mode, i1, i2, j1, j2);
	}

	/**
	 * @param i
	 * @see javax.media.opengl.GL2#glEvalPoint1(int)
	 */
	public void glEvalPoint1(int i) {
		getCurrent().glEvalPoint1(i);
	}

	/**
	 * @param i
	 * @param j
	 * @see javax.media.opengl.GL2#glEvalPoint2(int, int)
	 */
	public void glEvalPoint2(int i, int j) {
		getCurrent().glEvalPoint2(i, j);
	}

	/**
	 * @param res
	 * @param src
	 * @param num
	 * @see javax.media.opengl.GL2#glExtractComponentEXT(int, int, int)
	 */
	public void glExtractComponentEXT(int res, int src, int num) {
		getCurrent().glExtractComponentEXT(res, src, num);
	}

	/**
	 * @param size
	 * @param type
	 * @param buffer
	 * @see javax.media.opengl.GL2#glFeedbackBuffer(int, int, java.nio.FloatBuffer)
	 */
	public void glFeedbackBuffer(int size, int type, FloatBuffer buffer) {
		getCurrent().glFeedbackBuffer(size, type, buffer);
	}

	/**
	 * @param fence
	 * @see javax.media.opengl.GL2#glFinishFenceAPPLE(int)
	 */
	public void glFinishFenceAPPLE(int fence) {
		getCurrent().glFinishFenceAPPLE(fence);
	}

	/**
	 * @param fence
	 * @see javax.media.opengl.GL2#glFinishFenceNV(int)
	 */
	public void glFinishFenceNV(int fence) {
		getCurrent().glFinishFenceNV(fence);
	}

	/**
	 * @param object
	 * @param name
	 * @see javax.media.opengl.GL2#glFinishObjectAPPLE(int, int)
	 */
	public void glFinishObjectAPPLE(int object, int name) {
		getCurrent().glFinishObjectAPPLE(object, name);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glFinishTextureSUNX()
	 */
	public void glFinishTextureSUNX() {
		getCurrent().glFinishTextureSUNX();
	}

	/**
	 * @param buffer
	 * @param offset
	 * @param length
	 * @see javax.media.opengl.GL2#glFlushMappedNamedBufferRangeEXT(int, long, long)
	 */
	public void glFlushMappedNamedBufferRangeEXT(int buffer, long offset, long length) {
		getCurrent().glFlushMappedNamedBufferRangeEXT(buffer, offset, length);
	}

	/**
	 * @param target
	 * @see javax.media.opengl.GL2#glFlushPixelDataRangeNV(int)
	 */
	public void glFlushPixelDataRangeNV(int target) {
		getCurrent().glFlushPixelDataRangeNV(target);
	}

	/**
	 * @param length
	 * @param pointer
	 * @see javax.media.opengl.GL2#glFlushVertexArrayRangeAPPLE(int, java.nio.Buffer)
	 */
	public void glFlushVertexArrayRangeAPPLE(int length, Buffer pointer) {
		getCurrent().glFlushVertexArrayRangeAPPLE(length, pointer);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glFlushVertexArrayRangeNV()
	 */
	public void glFlushVertexArrayRangeNV() {
		getCurrent().glFlushVertexArrayRangeNV();
	}

	/**
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glFogCoordPointer(int, int, java.nio.Buffer)
	 */
	public void glFogCoordPointer(int type, int stride, Buffer pointer) {
		getCurrent().glFogCoordPointer(type, stride, pointer);
	}

	/**
	 * @param type
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.GL2#glFogCoordPointer(int, int, long)
	 */
	public void glFogCoordPointer(int type, int stride, long pointer_buffer_offset) {
		getCurrent().glFogCoordPointer(type, stride, pointer_buffer_offset);
	}

	/**
	 * @param coord
	 * @see javax.media.opengl.GL2#glFogCoordd(double)
	 */
	public void glFogCoordd(double coord) {
		getCurrent().glFogCoordd(coord);
	}

	/**
	 * @param coord
	 * @see javax.media.opengl.GL2#glFogCoorddv(java.nio.DoubleBuffer)
	 */
	public void glFogCoorddv(DoubleBuffer coord) {
		getCurrent().glFogCoorddv(coord);
	}

	/**
	 * @param coord
	 * @param coord_offset
	 * @see javax.media.opengl.GL2#glFogCoorddv(double[], int)
	 */
	public void glFogCoorddv(double[] coord, int coord_offset) {
		getCurrent().glFogCoorddv(coord, coord_offset);
	}

	/**
	 * @param coord
	 * @see javax.media.opengl.GL2#glFogCoordf(float)
	 */
	public void glFogCoordf(float coord) {
		getCurrent().glFogCoordf(coord);
	}

	/**
	 * @param coord
	 * @see javax.media.opengl.GL2#glFogCoordfv(java.nio.FloatBuffer)
	 */
	public void glFogCoordfv(FloatBuffer coord) {
		getCurrent().glFogCoordfv(coord);
	}

	/**
	 * @param coord
	 * @param coord_offset
	 * @see javax.media.opengl.GL2#glFogCoordfv(float[], int)
	 */
	public void glFogCoordfv(float[] coord, int coord_offset) {
		getCurrent().glFogCoordfv(coord, coord_offset);
	}

	/**
	 * @param fog
	 * @see javax.media.opengl.GL2#glFogCoordh(short)
	 */
	public void glFogCoordh(short fog) {
		getCurrent().glFogCoordh(fog);
	}

	/**
	 * @param fog
	 * @see javax.media.opengl.GL2#glFogCoordhv(java.nio.ShortBuffer)
	 */
	public void glFogCoordhv(ShortBuffer fog) {
		getCurrent().glFogCoordhv(fog);
	}

	/**
	 * @param fog
	 * @param fog_offset
	 * @see javax.media.opengl.GL2#glFogCoordhv(short[], int)
	 */
	public void glFogCoordhv(short[] fog, int fog_offset) {
		getCurrent().glFogCoordhv(fog, fog_offset);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glFogi(int, int)
	 */
	public void glFogi(int pname, int param) {
		getCurrent().glFogi(pname, param);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glFogiv(int, java.nio.IntBuffer)
	 */
	public void glFogiv(int pname, IntBuffer params) {
		getCurrent().glFogiv(pname, params);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glFogiv(int, int[], int)
	 */
	public void glFogiv(int pname, int[] params, int params_offset) {
		getCurrent().glFogiv(pname, params, params_offset);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glFrameTerminatorGREMEDY()
	 */
	public void glFrameTerminatorGREMEDY() {
		getCurrent().glFrameTerminatorGREMEDY();
	}

	/**
	 * @param framebuffer
	 * @param mode
	 * @see javax.media.opengl.GL2#glFramebufferDrawBufferEXT(int, int)
	 */
	public void glFramebufferDrawBufferEXT(int framebuffer, int mode) {
		getCurrent().glFramebufferDrawBufferEXT(framebuffer, mode);
	}

	/**
	 * @param framebuffer
	 * @param n
	 * @param bufs
	 * @see javax.media.opengl.GL2#glFramebufferDrawBuffersEXT(int, int, java.nio.IntBuffer)
	 */
	public void glFramebufferDrawBuffersEXT(int framebuffer, int n, IntBuffer bufs) {
		getCurrent().glFramebufferDrawBuffersEXT(framebuffer, n, bufs);
	}

	/**
	 * @param framebuffer
	 * @param n
	 * @param bufs
	 * @param bufs_offset
	 * @see javax.media.opengl.GL2#glFramebufferDrawBuffersEXT(int, int, int[], int)
	 */
	public void glFramebufferDrawBuffersEXT(int framebuffer, int n, int[] bufs, int bufs_offset) {
		getCurrent().glFramebufferDrawBuffersEXT(framebuffer, n, bufs, bufs_offset);
	}

	/**
	 * @param framebuffer
	 * @param mode
	 * @see javax.media.opengl.GL2#glFramebufferReadBufferEXT(int, int)
	 */
	public void glFramebufferReadBufferEXT(int framebuffer, int mode) {
		getCurrent().glFramebufferReadBufferEXT(framebuffer, mode);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param texture
	 * @param level
	 * @see javax.media.opengl.GL2#glFramebufferTextureEXT(int, int, int, int)
	 */
	public void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
		getCurrent().glFramebufferTextureEXT(target, attachment, texture, level);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param texture
	 * @param level
	 * @param face
	 * @see javax.media.opengl.GL2#glFramebufferTextureFaceEXT(int, int, int, int, int)
	 */
	public void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
		getCurrent().glFramebufferTextureFaceEXT(target, attachment, texture, level, face);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param texture
	 * @param level
	 * @param layer
	 * @see javax.media.opengl.GL2#glFramebufferTextureLayer(int, int, int, int, int)
	 */
	public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
		getCurrent().glFramebufferTextureLayer(target, attachment, texture, level, layer);
	}

	/**
	 * @param target
	 * @param attachment
	 * @param texture
	 * @param level
	 * @param layer
	 * @see javax.media.opengl.GL2#glFramebufferTextureLayerEXT(int, int, int, int, int)
	 */
	public void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
		getCurrent().glFramebufferTextureLayerEXT(target, attachment, texture, level, layer);
	}

	/**
	 * @param n
	 * @param fences
	 * @see javax.media.opengl.GL2#glGenFencesAPPLE(int, java.nio.IntBuffer)
	 */
	public void glGenFencesAPPLE(int n, IntBuffer fences) {
		getCurrent().glGenFencesAPPLE(n, fences);
	}

	/**
	 * @param n
	 * @param fences
	 * @param fences_offset
	 * @see javax.media.opengl.GL2#glGenFencesAPPLE(int, int[], int)
	 */
	public void glGenFencesAPPLE(int n, int[] fences, int fences_offset) {
		getCurrent().glGenFencesAPPLE(n, fences, fences_offset);
	}

	/**
	 * @param n
	 * @param fences
	 * @see javax.media.opengl.GL2#glGenFencesNV(int, java.nio.IntBuffer)
	 */
	public void glGenFencesNV(int n, IntBuffer fences) {
		getCurrent().glGenFencesNV(n, fences);
	}

	/**
	 * @param n
	 * @param fences
	 * @param fences_offset
	 * @see javax.media.opengl.GL2#glGenFencesNV(int, int[], int)
	 */
	public void glGenFencesNV(int n, int[] fences, int fences_offset) {
		getCurrent().glGenFencesNV(n, fences, fences_offset);
	}

	/**
	 * @param range
	 * @return
	 * @see javax.media.opengl.GL2#glGenLists(int)
	 */
	public int glGenLists(int range) {
		return getCurrent().glGenLists(range);
	}

	/**
	 * @param identifier
	 * @param num
	 * @param names
	 * @see javax.media.opengl.GL2#glGenNamesAMD(int, int, java.nio.IntBuffer)
	 */
	public void glGenNamesAMD(int identifier, int num, IntBuffer names) {
		getCurrent().glGenNamesAMD(identifier, num, names);
	}

	/**
	 * @param identifier
	 * @param num
	 * @param names
	 * @param names_offset
	 * @see javax.media.opengl.GL2#glGenNamesAMD(int, int, int[], int)
	 */
	public void glGenNamesAMD(int identifier, int num, int[] names, int names_offset) {
		getCurrent().glGenNamesAMD(identifier, num, names, names_offset);
	}

	/**
	 * @param n
	 * @param ids
	 * @see javax.media.opengl.GL2#glGenOcclusionQueriesNV(int, java.nio.IntBuffer)
	 */
	public void glGenOcclusionQueriesNV(int n, IntBuffer ids) {
		getCurrent().glGenOcclusionQueriesNV(n, ids);
	}

	/**
	 * @param n
	 * @param ids
	 * @param ids_offset
	 * @see javax.media.opengl.GL2#glGenOcclusionQueriesNV(int, int[], int)
	 */
	public void glGenOcclusionQueriesNV(int n, int[] ids, int ids_offset) {
		getCurrent().glGenOcclusionQueriesNV(n, ids, ids_offset);
	}

	/**
	 * @param range
	 * @return
	 * @see javax.media.opengl.GL2#glGenPathsNV(int)
	 */
	public int glGenPathsNV(int range) {
		return getCurrent().glGenPathsNV(range);
	}

	/**
	 * @param n
	 * @param monitors
	 * @see javax.media.opengl.GL2#glGenPerfMonitorsAMD(int, java.nio.IntBuffer)
	 */
	public void glGenPerfMonitorsAMD(int n, IntBuffer monitors) {
		getCurrent().glGenPerfMonitorsAMD(n, monitors);
	}

	/**
	 * @param n
	 * @param monitors
	 * @param monitors_offset
	 * @see javax.media.opengl.GL2#glGenPerfMonitorsAMD(int, int[], int)
	 */
	public void glGenPerfMonitorsAMD(int n, int[] monitors, int monitors_offset) {
		getCurrent().glGenPerfMonitorsAMD(n, monitors, monitors_offset);
	}

	/**
	 * @param n
	 * @param programs
	 * @see javax.media.opengl.GL2#glGenProgramsARB(int, java.nio.IntBuffer)
	 */
	public void glGenProgramsARB(int n, IntBuffer programs) {
		getCurrent().glGenProgramsARB(n, programs);
	}

	/**
	 * @param n
	 * @param programs
	 * @param programs_offset
	 * @see javax.media.opengl.GL2#glGenProgramsARB(int, int[], int)
	 */
	public void glGenProgramsARB(int n, int[] programs, int programs_offset) {
		getCurrent().glGenProgramsARB(n, programs, programs_offset);
	}

	/**
	 * @param datatype
	 * @param storagetype
	 * @param range
	 * @param components
	 * @return
	 * @see javax.media.opengl.GL2#glGenSymbolsEXT(int, int, int, int)
	 */
	public int glGenSymbolsEXT(int datatype, int storagetype, int range, int components) {
		return getCurrent().glGenSymbolsEXT(datatype, storagetype, range, components);
	}

	/**
	 * @param n
	 * @param ids
	 * @see javax.media.opengl.GL2#glGenTransformFeedbacksNV(int, java.nio.IntBuffer)
	 */
	public void glGenTransformFeedbacksNV(int n, IntBuffer ids) {
		getCurrent().glGenTransformFeedbacksNV(n, ids);
	}

	/**
	 * @param n
	 * @param ids
	 * @param ids_offset
	 * @see javax.media.opengl.GL2#glGenTransformFeedbacksNV(int, int[], int)
	 */
	public void glGenTransformFeedbacksNV(int n, int[] ids, int ids_offset) {
		getCurrent().glGenTransformFeedbacksNV(n, ids, ids_offset);
	}

	/**
	 * @param n
	 * @param arrays
	 * @see javax.media.opengl.GL2#glGenVertexArrays(int, java.nio.IntBuffer)
	 */
	public void glGenVertexArrays(int n, IntBuffer arrays) {
		getCurrent().glGenVertexArrays(n, arrays);
	}

	/**
	 * @param n
	 * @param arrays
	 * @param arrays_offset
	 * @see javax.media.opengl.GL2#glGenVertexArrays(int, int[], int)
	 */
	public void glGenVertexArrays(int n, int[] arrays, int arrays_offset) {
		getCurrent().glGenVertexArrays(n, arrays, arrays_offset);
	}

	/**
	 * @param range
	 * @return
	 * @see javax.media.opengl.GL2#glGenVertexShadersEXT(int)
	 */
	public int glGenVertexShadersEXT(int range) {
		return getCurrent().glGenVertexShadersEXT(range);
	}

	/**
	 * @param texunit
	 * @param target
	 * @see javax.media.opengl.GL2#glGenerateMultiTexMipmapEXT(int, int)
	 */
	public void glGenerateMultiTexMipmapEXT(int texunit, int target) {
		getCurrent().glGenerateMultiTexMipmapEXT(texunit, target);
	}

	/**
	 * @param texture
	 * @param target
	 * @see javax.media.opengl.GL2#glGenerateTextureMipmapEXT(int, int)
	 */
	public void glGenerateTextureMipmapEXT(int texture, int target) {
		getCurrent().glGenerateTextureMipmapEXT(texture, target);
	}

	/**
	 * @param programObj
	 * @param index
	 * @param maxLength
	 * @param length
	 * @param size
	 * @param type
	 * @param name
	 * @see javax.media.opengl.GL2#glGetActiveUniformARB(int, int, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetActiveUniformARB(int programObj, int index, int maxLength, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		getCurrent().glGetActiveUniformARB(programObj, index, maxLength, length, size, type, name);
	}

	/**
	 * @param programObj
	 * @param index
	 * @param maxLength
	 * @param length
	 * @param length_offset
	 * @param size
	 * @param size_offset
	 * @param type
	 * @param type_offset
	 * @param name
	 * @param name_offset
	 * @see javax.media.opengl.GL2#glGetActiveUniformARB(int, int, int, int[], int, int[], int, int[], int, byte[], int)
	 */
	public void glGetActiveUniformARB(int programObj, int index, int maxLength, int[] length, int length_offset, int[] size, int size_offset, int[] type, int type_offset, byte[] name, int name_offset) {
		getCurrent().glGetActiveUniformARB(programObj, index, maxLength, length, length_offset, size, size_offset, type, type_offset, name, name_offset);
	}

	/**
	 * @param program
	 * @param uniformBlockIndex
	 * @param bufSize
	 * @param length
	 * @param uniformBlockName
	 * @see javax.media.opengl.GL2#glGetActiveUniformBlockName(int, int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, IntBuffer length, ByteBuffer uniformBlockName) {
		getCurrent().glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, length, uniformBlockName);
	}

	/**
	 * @param program
	 * @param uniformBlockIndex
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param uniformBlockName
	 * @param uniformBlockName_offset
	 * @see javax.media.opengl.GL2#glGetActiveUniformBlockName(int, int, int, int[], int, byte[], int)
	 */
	public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, int[] length, int length_offset, byte[] uniformBlockName, int uniformBlockName_offset) {
		getCurrent().glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, length, length_offset, uniformBlockName, uniformBlockName_offset);
	}

	/**
	 * @param program
	 * @param uniformBlockIndex
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetActiveUniformBlockiv(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, IntBuffer params) {
		getCurrent().glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
	}

	/**
	 * @param program
	 * @param uniformBlockIndex
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetActiveUniformBlockiv(int, int, int, int[], int)
	 */
	public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, int[] params, int params_offset) {
		getCurrent().glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params, params_offset);
	}

	/**
	 * @param program
	 * @param uniformCount
	 * @param uniformIndices
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetActiveUniformsiv(int, int, java.nio.IntBuffer, int, java.nio.IntBuffer)
	 */
	public void glGetActiveUniformsiv(int program, int uniformCount, IntBuffer uniformIndices, int pname, IntBuffer params) {
		getCurrent().glGetActiveUniformsiv(program, uniformCount, uniformIndices, pname, params);
	}

	/**
	 * @param program
	 * @param uniformCount
	 * @param uniformIndices
	 * @param uniformIndices_offset
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetActiveUniformsiv(int, int, int[], int, int, int[], int)
	 */
	public void glGetActiveUniformsiv(int program, int uniformCount, int[] uniformIndices, int uniformIndices_offset, int pname, int[] params, int params_offset) {
		getCurrent().glGetActiveUniformsiv(program, uniformCount, uniformIndices, uniformIndices_offset, pname, params, params_offset);
	}

	/**
	 * @param containerObj
	 * @param maxCount
	 * @param count
	 * @param obj
	 * @see javax.media.opengl.GL2#glGetAttachedObjectsARB(int, int, java.nio.IntBuffer, java.nio.IntBuffer)
	 */
	public void glGetAttachedObjectsARB(int containerObj, int maxCount, IntBuffer count, IntBuffer obj) {
		getCurrent().glGetAttachedObjectsARB(containerObj, maxCount, count, obj);
	}

	/**
	 * @param containerObj
	 * @param maxCount
	 * @param count
	 * @param count_offset
	 * @param obj
	 * @param obj_offset
	 * @see javax.media.opengl.GL2#glGetAttachedObjectsARB(int, int, int[], int, int[], int)
	 */
	public void glGetAttachedObjectsARB(int containerObj, int maxCount, int[] count, int count_offset, int[] obj, int obj_offset) {
		getCurrent().glGetAttachedObjectsARB(containerObj, maxCount, count, count_offset, obj, obj_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @see javax.media.opengl.GL2#glGetBooleanIndexedv(int, int, java.nio.ByteBuffer)
	 */
	public void glGetBooleanIndexedv(int target, int index, ByteBuffer data) {
		getCurrent().glGetBooleanIndexedv(target, index, data);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetBooleanIndexedv(int, int, byte[], int)
	 */
	public void glGetBooleanIndexedv(int target, int index, byte[] data, int data_offset) {
		getCurrent().glGetBooleanIndexedv(target, index, data, data_offset);
	}

	/**
	 * @param plane
	 * @param equation
	 * @see javax.media.opengl.GL2#glGetClipPlane(int, java.nio.DoubleBuffer)
	 */
	public void glGetClipPlane(int plane, DoubleBuffer equation) {
		getCurrent().glGetClipPlane(plane, equation);
	}

	/**
	 * @param plane
	 * @param equation
	 * @param equation_offset
	 * @see javax.media.opengl.GL2#glGetClipPlane(int, double[], int)
	 */
	public void glGetClipPlane(int plane, double[] equation, int equation_offset) {
		getCurrent().glGetClipPlane(plane, equation, equation_offset);
	}

	/**
	 * @param plane
	 * @param equation
	 * @see javax.media.opengl.GL2#glGetClipPlanef(int, java.nio.FloatBuffer)
	 */
	public void glGetClipPlanef(int plane, FloatBuffer equation) {
		getCurrent().glGetClipPlanef(plane, equation);
	}

	/**
	 * @param plane
	 * @param equation
	 * @param equation_offset
	 * @see javax.media.opengl.GL2#glGetClipPlanef(int, float[], int)
	 */
	public void glGetClipPlanef(int plane, float[] equation, int equation_offset) {
		getCurrent().glGetClipPlanef(plane, equation, equation_offset);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param table
	 * @see javax.media.opengl.GL2#glGetColorTable(int, int, int, java.nio.Buffer)
	 */
	public void glGetColorTable(int target, int format, int type, Buffer table) {
		getCurrent().glGetColorTable(target, format, type, table);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param table_buffer_offset
	 * @see javax.media.opengl.GL2#glGetColorTable(int, int, int, long)
	 */
	public void glGetColorTable(int target, int format, int type, long table_buffer_offset) {
		getCurrent().glGetColorTable(target, format, type, table_buffer_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetColorTableParameterfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetColorTableParameterfv(int target, int pname, FloatBuffer params) {
		getCurrent().glGetColorTableParameterfv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetColorTableParameterfv(int, int, float[], int)
	 */
	public void glGetColorTableParameterfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetColorTableParameterfv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetColorTableParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glGetColorTableParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glGetColorTableParameteriv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetColorTableParameteriv(int, int, int[], int)
	 */
	public void glGetColorTableParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetColorTableParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param lod
	 * @param img
	 * @see javax.media.opengl.GL2#glGetCompressedMultiTexImageEXT(int, int, int, java.nio.Buffer)
	 */
	public void glGetCompressedMultiTexImageEXT(int texunit, int target, int lod, Buffer img) {
		getCurrent().glGetCompressedMultiTexImageEXT(texunit, target, lod, img);
	}

	/**
	 * @param texture
	 * @param target
	 * @param lod
	 * @param img
	 * @see javax.media.opengl.GL2#glGetCompressedTextureImageEXT(int, int, int, java.nio.Buffer)
	 */
	public void glGetCompressedTextureImageEXT(int texture, int target, int lod, Buffer img) {
		getCurrent().glGetCompressedTextureImageEXT(texture, target, lod, img);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param image
	 * @see javax.media.opengl.GL2#glGetConvolutionFilter(int, int, int, java.nio.Buffer)
	 */
	public void glGetConvolutionFilter(int target, int format, int type, Buffer image) {
		getCurrent().glGetConvolutionFilter(target, format, type, image);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param image_buffer_offset
	 * @see javax.media.opengl.GL2#glGetConvolutionFilter(int, int, int, long)
	 */
	public void glGetConvolutionFilter(int target, int format, int type, long image_buffer_offset) {
		getCurrent().glGetConvolutionFilter(target, format, type, image_buffer_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetConvolutionParameterfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetConvolutionParameterfv(int target, int pname, FloatBuffer params) {
		getCurrent().glGetConvolutionParameterfv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetConvolutionParameterfv(int, int, float[], int)
	 */
	public void glGetConvolutionParameterfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetConvolutionParameterfv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetConvolutionParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glGetConvolutionParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glGetConvolutionParameteriv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetConvolutionParameteriv(int, int, int[], int)
	 */
	public void glGetConvolutionParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetConvolutionParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @see javax.media.opengl.GL2#glGetDoubleIndexedvEXT(int, int, java.nio.DoubleBuffer)
	 */
	public void glGetDoubleIndexedvEXT(int target, int index, DoubleBuffer data) {
		getCurrent().glGetDoubleIndexedvEXT(target, index, data);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetDoubleIndexedvEXT(int, int, double[], int)
	 */
	public void glGetDoubleIndexedvEXT(int target, int index, double[] data, int data_offset) {
		getCurrent().glGetDoubleIndexedvEXT(target, index, data, data_offset);
	}

	/**
	 * @param pname
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetDoublei_vEXT(int, int, java.nio.DoubleBuffer)
	 */
	public void glGetDoublei_vEXT(int pname, int index, DoubleBuffer params) {
		getCurrent().glGetDoublei_vEXT(pname, index, params);
	}

	/**
	 * @param pname
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetDoublei_vEXT(int, int, double[], int)
	 */
	public void glGetDoublei_vEXT(int pname, int index, double[] params, int params_offset) {
		getCurrent().glGetDoublei_vEXT(pname, index, params, params_offset);
	}

	/**
	 * @param fence
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetFenceivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetFenceivNV(int fence, int pname, IntBuffer params) {
		getCurrent().glGetFenceivNV(fence, pname, params);
	}

	/**
	 * @param fence
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetFenceivNV(int, int, int[], int)
	 */
	public void glGetFenceivNV(int fence, int pname, int[] params, int params_offset) {
		getCurrent().glGetFenceivNV(fence, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @see javax.media.opengl.GL2#glGetFloatIndexedvEXT(int, int, java.nio.FloatBuffer)
	 */
	public void glGetFloatIndexedvEXT(int target, int index, FloatBuffer data) {
		getCurrent().glGetFloatIndexedvEXT(target, index, data);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetFloatIndexedvEXT(int, int, float[], int)
	 */
	public void glGetFloatIndexedvEXT(int target, int index, float[] data, int data_offset) {
		getCurrent().glGetFloatIndexedvEXT(target, index, data, data_offset);
	}

	/**
	 * @param pname
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetFloati_vEXT(int, int, java.nio.FloatBuffer)
	 */
	public void glGetFloati_vEXT(int pname, int index, FloatBuffer params) {
		getCurrent().glGetFloati_vEXT(pname, index, params);
	}

	/**
	 * @param pname
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetFloati_vEXT(int, int, float[], int)
	 */
	public void glGetFloati_vEXT(int pname, int index, float[] params, int params_offset) {
		getCurrent().glGetFloati_vEXT(pname, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param name
	 * @return
	 * @see javax.media.opengl.GL2#glGetFragDataLocation(int, java.lang.String)
	 */
	public int glGetFragDataLocation(int program, String name) {
		return getCurrent().glGetFragDataLocation(program, name);
	}

	/**
	 * @param framebuffer
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetFramebufferParameterivEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetFramebufferParameterivEXT(int framebuffer, int pname, IntBuffer params) {
		getCurrent().glGetFramebufferParameterivEXT(framebuffer, pname, params);
	}

	/**
	 * @param framebuffer
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetFramebufferParameterivEXT(int, int, int[], int)
	 */
	public void glGetFramebufferParameterivEXT(int framebuffer, int pname, int[] params, int params_offset) {
		getCurrent().glGetFramebufferParameterivEXT(framebuffer, pname, params, params_offset);
	}

	/**
	 * @param pname
	 * @return
	 * @see javax.media.opengl.GL2#glGetHandleARB(int)
	 */
	public int glGetHandleARB(int pname) {
		return getCurrent().glGetHandleARB(pname);
	}

	/**
	 * @param target
	 * @param reset
	 * @param format
	 * @param type
	 * @param values
	 * @see javax.media.opengl.GL2#glGetHistogram(int, boolean, int, int, java.nio.Buffer)
	 */
	public void glGetHistogram(int target, boolean reset, int format, int type, Buffer values) {
		getCurrent().glGetHistogram(target, reset, format, type, values);
	}

	/**
	 * @param target
	 * @param reset
	 * @param format
	 * @param type
	 * @param values_buffer_offset
	 * @see javax.media.opengl.GL2#glGetHistogram(int, boolean, int, int, long)
	 */
	public void glGetHistogram(int target, boolean reset, int format, int type, long values_buffer_offset) {
		getCurrent().glGetHistogram(target, reset, format, type, values_buffer_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetHistogramParameterfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetHistogramParameterfv(int target, int pname, FloatBuffer params) {
		getCurrent().glGetHistogramParameterfv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetHistogramParameterfv(int, int, float[], int)
	 */
	public void glGetHistogramParameterfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetHistogramParameterfv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetHistogramParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glGetHistogramParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glGetHistogramParameteriv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetHistogramParameteriv(int, int, int[], int)
	 */
	public void glGetHistogramParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetHistogramParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param level
	 * @param layered
	 * @param layer
	 * @param format
	 * @return
	 * @see javax.media.opengl.GL2#glGetImageHandleNV(int, int, boolean, int, int)
	 */
	public long glGetImageHandleNV(int texture, int level, boolean layered, int layer, int format) {
		return getCurrent().glGetImageHandleNV(texture, level, layered, layer, format);
	}

	/**
	 * @param obj
	 * @param maxLength
	 * @param length
	 * @param infoLog
	 * @see javax.media.opengl.GL2#glGetInfoLogARB(int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetInfoLogARB(int obj, int maxLength, IntBuffer length, ByteBuffer infoLog) {
		getCurrent().glGetInfoLogARB(obj, maxLength, length, infoLog);
	}

	/**
	 * @param obj
	 * @param maxLength
	 * @param length
	 * @param length_offset
	 * @param infoLog
	 * @param infoLog_offset
	 * @see javax.media.opengl.GL2#glGetInfoLogARB(int, int, int[], int, byte[], int)
	 */
	public void glGetInfoLogARB(int obj, int maxLength, int[] length, int length_offset, byte[] infoLog, int infoLog_offset) {
		getCurrent().glGetInfoLogARB(obj, maxLength, length, length_offset, infoLog, infoLog_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @see javax.media.opengl.GL2#glGetIntegerIndexedv(int, int, java.nio.IntBuffer)
	 */
	public void glGetIntegerIndexedv(int target, int index, IntBuffer data) {
		getCurrent().glGetIntegerIndexedv(target, index, data);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetIntegerIndexedv(int, int, int[], int)
	 */
	public void glGetIntegerIndexedv(int target, int index, int[] data, int data_offset) {
		getCurrent().glGetIntegerIndexedv(target, index, data, data_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @see javax.media.opengl.GL2#glGetIntegeri_v(int, int, java.nio.IntBuffer)
	 */
	public void glGetIntegeri_v(int target, int index, IntBuffer data) {
		getCurrent().glGetIntegeri_v(target, index, data);
	}

	/**
	 * @param target
	 * @param index
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetIntegeri_v(int, int, int[], int)
	 */
	public void glGetIntegeri_v(int target, int index, int[] data, int data_offset) {
		getCurrent().glGetIntegeri_v(target, index, data, data_offset);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param pname
	 * @param bufSize
	 * @param params
	 * @see javax.media.opengl.GL2#glGetInternalformativ(int, int, int, int, java.nio.IntBuffer)
	 */
	public void glGetInternalformativ(int target, int internalformat, int pname, int bufSize, IntBuffer params) {
		getCurrent().glGetInternalformativ(target, internalformat, pname, bufSize, params);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param pname
	 * @param bufSize
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetInternalformativ(int, int, int, int, int[], int)
	 */
	public void glGetInternalformativ(int target, int internalformat, int pname, int bufSize, int[] params, int params_offset) {
		getCurrent().glGetInternalformativ(target, internalformat, pname, bufSize, params, params_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetInvariantBooleanvEXT(int, int, java.nio.ByteBuffer)
	 */
	public void glGetInvariantBooleanvEXT(int id, int value, ByteBuffer data) {
		getCurrent().glGetInvariantBooleanvEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetInvariantBooleanvEXT(int, int, byte[], int)
	 */
	public void glGetInvariantBooleanvEXT(int id, int value, byte[] data, int data_offset) {
		getCurrent().glGetInvariantBooleanvEXT(id, value, data, data_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetInvariantFloatvEXT(int, int, java.nio.FloatBuffer)
	 */
	public void glGetInvariantFloatvEXT(int id, int value, FloatBuffer data) {
		getCurrent().glGetInvariantFloatvEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetInvariantFloatvEXT(int, int, float[], int)
	 */
	public void glGetInvariantFloatvEXT(int id, int value, float[] data, int data_offset) {
		getCurrent().glGetInvariantFloatvEXT(id, value, data, data_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetInvariantIntegervEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetInvariantIntegervEXT(int id, int value, IntBuffer data) {
		getCurrent().glGetInvariantIntegervEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetInvariantIntegervEXT(int, int, int[], int)
	 */
	public void glGetInvariantIntegervEXT(int id, int value, int[] data, int data_offset) {
		getCurrent().glGetInvariantIntegervEXT(id, value, data, data_offset);
	}

	/**
	 * @param light
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetLightiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetLightiv(int light, int pname, IntBuffer params) {
		getCurrent().glGetLightiv(light, pname, params);
	}

	/**
	 * @param light
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetLightiv(int, int, int[], int)
	 */
	public void glGetLightiv(int light, int pname, int[] params, int params_offset) {
		getCurrent().glGetLightiv(light, pname, params, params_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetLocalConstantBooleanvEXT(int, int, java.nio.ByteBuffer)
	 */
	public void glGetLocalConstantBooleanvEXT(int id, int value, ByteBuffer data) {
		getCurrent().glGetLocalConstantBooleanvEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetLocalConstantBooleanvEXT(int, int, byte[], int)
	 */
	public void glGetLocalConstantBooleanvEXT(int id, int value, byte[] data, int data_offset) {
		getCurrent().glGetLocalConstantBooleanvEXT(id, value, data, data_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetLocalConstantFloatvEXT(int, int, java.nio.FloatBuffer)
	 */
	public void glGetLocalConstantFloatvEXT(int id, int value, FloatBuffer data) {
		getCurrent().glGetLocalConstantFloatvEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetLocalConstantFloatvEXT(int, int, float[], int)
	 */
	public void glGetLocalConstantFloatvEXT(int id, int value, float[] data, int data_offset) {
		getCurrent().glGetLocalConstantFloatvEXT(id, value, data, data_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetLocalConstantIntegervEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetLocalConstantIntegervEXT(int id, int value, IntBuffer data) {
		getCurrent().glGetLocalConstantIntegervEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetLocalConstantIntegervEXT(int, int, int[], int)
	 */
	public void glGetLocalConstantIntegervEXT(int id, int value, int[] data, int data_offset) {
		getCurrent().glGetLocalConstantIntegervEXT(id, value, data, data_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMapAttribParameterfvNV(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetMapAttribParameterfvNV(int target, int index, int pname, FloatBuffer params) {
		getCurrent().glGetMapAttribParameterfvNV(target, index, pname, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMapAttribParameterfvNV(int, int, int, float[], int)
	 */
	public void glGetMapAttribParameterfvNV(int target, int index, int pname, float[] params, int params_offset) {
		getCurrent().glGetMapAttribParameterfvNV(target, index, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMapAttribParameterivNV(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetMapAttribParameterivNV(int target, int index, int pname, IntBuffer params) {
		getCurrent().glGetMapAttribParameterivNV(target, index, pname, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMapAttribParameterivNV(int, int, int, int[], int)
	 */
	public void glGetMapAttribParameterivNV(int target, int index, int pname, int[] params, int params_offset) {
		getCurrent().glGetMapAttribParameterivNV(target, index, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param type
	 * @param ustride
	 * @param vstride
	 * @param packed
	 * @param points
	 * @see javax.media.opengl.GL2#glGetMapControlPointsNV(int, int, int, int, int, boolean, java.nio.Buffer)
	 */
	public void glGetMapControlPointsNV(int target, int index, int type, int ustride, int vstride, boolean packed, Buffer points) {
		getCurrent().glGetMapControlPointsNV(target, index, type, ustride, vstride, packed, points);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMapParameterfvNV(int, int, java.nio.FloatBuffer)
	 */
	public void glGetMapParameterfvNV(int target, int pname, FloatBuffer params) {
		getCurrent().glGetMapParameterfvNV(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMapParameterfvNV(int, int, float[], int)
	 */
	public void glGetMapParameterfvNV(int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetMapParameterfvNV(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMapParameterivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetMapParameterivNV(int target, int pname, IntBuffer params) {
		getCurrent().glGetMapParameterivNV(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMapParameterivNV(int, int, int[], int)
	 */
	public void glGetMapParameterivNV(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetMapParameterivNV(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param query
	 * @param v
	 * @see javax.media.opengl.GL2#glGetMapdv(int, int, java.nio.DoubleBuffer)
	 */
	public void glGetMapdv(int target, int query, DoubleBuffer v) {
		getCurrent().glGetMapdv(target, query, v);
	}

	/**
	 * @param target
	 * @param query
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glGetMapdv(int, int, double[], int)
	 */
	public void glGetMapdv(int target, int query, double[] v, int v_offset) {
		getCurrent().glGetMapdv(target, query, v, v_offset);
	}

	/**
	 * @param target
	 * @param query
	 * @param v
	 * @see javax.media.opengl.GL2#glGetMapfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetMapfv(int target, int query, FloatBuffer v) {
		getCurrent().glGetMapfv(target, query, v);
	}

	/**
	 * @param target
	 * @param query
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glGetMapfv(int, int, float[], int)
	 */
	public void glGetMapfv(int target, int query, float[] v, int v_offset) {
		getCurrent().glGetMapfv(target, query, v, v_offset);
	}

	/**
	 * @param target
	 * @param query
	 * @param v
	 * @see javax.media.opengl.GL2#glGetMapiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetMapiv(int target, int query, IntBuffer v) {
		getCurrent().glGetMapiv(target, query, v);
	}

	/**
	 * @param target
	 * @param query
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glGetMapiv(int, int, int[], int)
	 */
	public void glGetMapiv(int target, int query, int[] v, int v_offset) {
		getCurrent().glGetMapiv(target, query, v, v_offset);
	}

	/**
	 * @param face
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMaterialiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetMaterialiv(int face, int pname, IntBuffer params) {
		getCurrent().glGetMaterialiv(face, pname, params);
	}

	/**
	 * @param face
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMaterialiv(int, int, int[], int)
	 */
	public void glGetMaterialiv(int face, int pname, int[] params, int params_offset) {
		getCurrent().glGetMaterialiv(face, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param reset
	 * @param format
	 * @param type
	 * @param values
	 * @see javax.media.opengl.GL2#glGetMinmax(int, boolean, int, int, java.nio.Buffer)
	 */
	public void glGetMinmax(int target, boolean reset, int format, int type, Buffer values) {
		getCurrent().glGetMinmax(target, reset, format, type, values);
	}

	/**
	 * @param target
	 * @param reset
	 * @param format
	 * @param type
	 * @param values_buffer_offset
	 * @see javax.media.opengl.GL2#glGetMinmax(int, boolean, int, int, long)
	 */
	public void glGetMinmax(int target, boolean reset, int format, int type, long values_buffer_offset) {
		getCurrent().glGetMinmax(target, reset, format, type, values_buffer_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMinmaxParameterfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetMinmaxParameterfv(int target, int pname, FloatBuffer params) {
		getCurrent().glGetMinmaxParameterfv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMinmaxParameterfv(int, int, float[], int)
	 */
	public void glGetMinmaxParameterfv(int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetMinmaxParameterfv(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMinmaxParameteriv(int, int, java.nio.IntBuffer)
	 */
	public void glGetMinmaxParameteriv(int target, int pname, IntBuffer params) {
		getCurrent().glGetMinmaxParameteriv(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMinmaxParameteriv(int, int, int[], int)
	 */
	public void glGetMinmaxParameteriv(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetMinmaxParameteriv(target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexEnvfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetMultiTexEnvfvEXT(int texunit, int target, int pname, FloatBuffer params) {
		getCurrent().glGetMultiTexEnvfvEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexEnvfvEXT(int, int, int, float[], int)
	 */
	public void glGetMultiTexEnvfvEXT(int texunit, int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetMultiTexEnvfvEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexEnvivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetMultiTexEnvivEXT(int texunit, int target, int pname, IntBuffer params) {
		getCurrent().glGetMultiTexEnvivEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexEnvivEXT(int, int, int, int[], int)
	 */
	public void glGetMultiTexEnvivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetMultiTexEnvivEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexGendvEXT(int, int, int, java.nio.DoubleBuffer)
	 */
	public void glGetMultiTexGendvEXT(int texunit, int coord, int pname, DoubleBuffer params) {
		getCurrent().glGetMultiTexGendvEXT(texunit, coord, pname, params);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexGendvEXT(int, int, int, double[], int)
	 */
	public void glGetMultiTexGendvEXT(int texunit, int coord, int pname, double[] params, int params_offset) {
		getCurrent().glGetMultiTexGendvEXT(texunit, coord, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexGenfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetMultiTexGenfvEXT(int texunit, int coord, int pname, FloatBuffer params) {
		getCurrent().glGetMultiTexGenfvEXT(texunit, coord, pname, params);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexGenfvEXT(int, int, int, float[], int)
	 */
	public void glGetMultiTexGenfvEXT(int texunit, int coord, int pname, float[] params, int params_offset) {
		getCurrent().glGetMultiTexGenfvEXT(texunit, coord, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexGenivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetMultiTexGenivEXT(int texunit, int coord, int pname, IntBuffer params) {
		getCurrent().glGetMultiTexGenivEXT(texunit, coord, pname, params);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexGenivEXT(int, int, int, int[], int)
	 */
	public void glGetMultiTexGenivEXT(int texunit, int coord, int pname, int[] params, int params_offset) {
		getCurrent().glGetMultiTexGenivEXT(texunit, coord, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glGetMultiTexImageEXT(int, int, int, int, int, java.nio.Buffer)
	 */
	public void glGetMultiTexImageEXT(int texunit, int target, int level, int format, int type, Buffer pixels) {
		getCurrent().glGetMultiTexImageEXT(texunit, target, level, format, type, pixels);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexLevelParameterfvEXT(int, int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetMultiTexLevelParameterfvEXT(int texunit, int target, int level, int pname, FloatBuffer params) {
		getCurrent().glGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexLevelParameterfvEXT(int, int, int, int, float[], int)
	 */
	public void glGetMultiTexLevelParameterfvEXT(int texunit, int target, int level, int pname, float[] params, int params_offset) {
		getCurrent().glGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexLevelParameterivEXT(int, int, int, int, java.nio.IntBuffer)
	 */
	public void glGetMultiTexLevelParameterivEXT(int texunit, int target, int level, int pname, IntBuffer params) {
		getCurrent().glGetMultiTexLevelParameterivEXT(texunit, target, level, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexLevelParameterivEXT(int, int, int, int, int[], int)
	 */
	public void glGetMultiTexLevelParameterivEXT(int texunit, int target, int level, int pname, int[] params, int params_offset) {
		getCurrent().glGetMultiTexLevelParameterivEXT(texunit, target, level, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexParameterIivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetMultiTexParameterIivEXT(int texunit, int target, int pname, IntBuffer params) {
		getCurrent().glGetMultiTexParameterIivEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexParameterIivEXT(int, int, int, int[], int)
	 */
	public void glGetMultiTexParameterIivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetMultiTexParameterIivEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexParameterIuivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetMultiTexParameterIuivEXT(int texunit, int target, int pname, IntBuffer params) {
		getCurrent().glGetMultiTexParameterIuivEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexParameterIuivEXT(int, int, int, int[], int)
	 */
	public void glGetMultiTexParameterIuivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetMultiTexParameterIuivEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexParameterfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetMultiTexParameterfvEXT(int texunit, int target, int pname, FloatBuffer params) {
		getCurrent().glGetMultiTexParameterfvEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexParameterfvEXT(int, int, int, float[], int)
	 */
	public void glGetMultiTexParameterfvEXT(int texunit, int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetMultiTexParameterfvEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetMultiTexParameterivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetMultiTexParameterivEXT(int texunit, int target, int pname, IntBuffer params) {
		getCurrent().glGetMultiTexParameterivEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetMultiTexParameterivEXT(int, int, int, int[], int)
	 */
	public void glGetMultiTexParameterivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetMultiTexParameterivEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param pname
	 * @param index
	 * @param val
	 * @see javax.media.opengl.GL2#glGetMultisamplefvNV(int, int, java.nio.FloatBuffer)
	 */
	public void glGetMultisamplefvNV(int pname, int index, FloatBuffer val) {
		getCurrent().glGetMultisamplefvNV(pname, index, val);
	}

	/**
	 * @param pname
	 * @param index
	 * @param val
	 * @param val_offset
	 * @see javax.media.opengl.GL2#glGetMultisamplefvNV(int, int, float[], int)
	 */
	public void glGetMultisamplefvNV(int pname, int index, float[] val, int val_offset) {
		getCurrent().glGetMultisamplefvNV(pname, index, val, val_offset);
	}

	/**
	 * @param buffer
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetNamedBufferParameterivEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetNamedBufferParameterivEXT(int buffer, int pname, IntBuffer params) {
		getCurrent().glGetNamedBufferParameterivEXT(buffer, pname, params);
	}

	/**
	 * @param buffer
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetNamedBufferParameterivEXT(int, int, int[], int)
	 */
	public void glGetNamedBufferParameterivEXT(int buffer, int pname, int[] params, int params_offset) {
		getCurrent().glGetNamedBufferParameterivEXT(buffer, pname, params, params_offset);
	}

	/**
	 * @param buffer
	 * @param offset
	 * @param size
	 * @param data
	 * @see javax.media.opengl.GL2#glGetNamedBufferSubDataEXT(int, long, long, java.nio.Buffer)
	 */
	public void glGetNamedBufferSubDataEXT(int buffer, long offset, long size, Buffer data) {
		getCurrent().glGetNamedBufferSubDataEXT(buffer, offset, size, data);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetNamedFramebufferAttachmentParameterivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetNamedFramebufferAttachmentParameterivEXT(int framebuffer, int attachment, int pname, IntBuffer params) {
		getCurrent().glGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, params);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetNamedFramebufferAttachmentParameterivEXT(int, int, int, int[], int)
	 */
	public void glGetNamedFramebufferAttachmentParameterivEXT(int framebuffer, int attachment, int pname, int[] params, int params_offset) {
		getCurrent().glGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetNamedProgramLocalParameterIivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetNamedProgramLocalParameterIivEXT(int program, int target, int index, IntBuffer params) {
		getCurrent().glGetNamedProgramLocalParameterIivEXT(program, target, index, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetNamedProgramLocalParameterIivEXT(int, int, int, int[], int)
	 */
	public void glGetNamedProgramLocalParameterIivEXT(int program, int target, int index, int[] params, int params_offset) {
		getCurrent().glGetNamedProgramLocalParameterIivEXT(program, target, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetNamedProgramLocalParameterIuivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetNamedProgramLocalParameterIuivEXT(int program, int target, int index, IntBuffer params) {
		getCurrent().glGetNamedProgramLocalParameterIuivEXT(program, target, index, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetNamedProgramLocalParameterIuivEXT(int, int, int, int[], int)
	 */
	public void glGetNamedProgramLocalParameterIuivEXT(int program, int target, int index, int[] params, int params_offset) {
		getCurrent().glGetNamedProgramLocalParameterIuivEXT(program, target, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetNamedProgramLocalParameterdvEXT(int, int, int, java.nio.DoubleBuffer)
	 */
	public void glGetNamedProgramLocalParameterdvEXT(int program, int target, int index, DoubleBuffer params) {
		getCurrent().glGetNamedProgramLocalParameterdvEXT(program, target, index, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetNamedProgramLocalParameterdvEXT(int, int, int, double[], int)
	 */
	public void glGetNamedProgramLocalParameterdvEXT(int program, int target, int index, double[] params, int params_offset) {
		getCurrent().glGetNamedProgramLocalParameterdvEXT(program, target, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetNamedProgramLocalParameterfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetNamedProgramLocalParameterfvEXT(int program, int target, int index, FloatBuffer params) {
		getCurrent().glGetNamedProgramLocalParameterfvEXT(program, target, index, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetNamedProgramLocalParameterfvEXT(int, int, int, float[], int)
	 */
	public void glGetNamedProgramLocalParameterfvEXT(int program, int target, int index, float[] params, int params_offset) {
		getCurrent().glGetNamedProgramLocalParameterfvEXT(program, target, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param pname
	 * @param string
	 * @see javax.media.opengl.GL2#glGetNamedProgramStringEXT(int, int, int, java.nio.Buffer)
	 */
	public void glGetNamedProgramStringEXT(int program, int target, int pname, Buffer string) {
		getCurrent().glGetNamedProgramStringEXT(program, target, pname, string);
	}

	/**
	 * @param program
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetNamedProgramivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetNamedProgramivEXT(int program, int target, int pname, IntBuffer params) {
		getCurrent().glGetNamedProgramivEXT(program, target, pname, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetNamedProgramivEXT(int, int, int, int[], int)
	 */
	public void glGetNamedProgramivEXT(int program, int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetNamedProgramivEXT(program, target, pname, params, params_offset);
	}

	/**
	 * @param renderbuffer
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetNamedRenderbufferParameterivEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetNamedRenderbufferParameterivEXT(int renderbuffer, int pname, IntBuffer params) {
		getCurrent().glGetNamedRenderbufferParameterivEXT(renderbuffer, pname, params);
	}

	/**
	 * @param renderbuffer
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetNamedRenderbufferParameterivEXT(int, int, int[], int)
	 */
	public void glGetNamedRenderbufferParameterivEXT(int renderbuffer, int pname, int[] params, int params_offset) {
		getCurrent().glGetNamedRenderbufferParameterivEXT(renderbuffer, pname, params, params_offset);
	}

	/**
	 * @param obj
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetObjectParameterfvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glGetObjectParameterfvARB(int obj, int pname, FloatBuffer params) {
		getCurrent().glGetObjectParameterfvARB(obj, pname, params);
	}

	/**
	 * @param obj
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetObjectParameterfvARB(int, int, float[], int)
	 */
	public void glGetObjectParameterfvARB(int obj, int pname, float[] params, int params_offset) {
		getCurrent().glGetObjectParameterfvARB(obj, pname, params, params_offset);
	}

	/**
	 * @param objectType
	 * @param name
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetObjectParameterivAPPLE(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, IntBuffer params) {
		getCurrent().glGetObjectParameterivAPPLE(objectType, name, pname, params);
	}

	/**
	 * @param objectType
	 * @param name
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetObjectParameterivAPPLE(int, int, int, int[], int)
	 */
	public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, int[] params, int params_offset) {
		getCurrent().glGetObjectParameterivAPPLE(objectType, name, pname, params, params_offset);
	}

	/**
	 * @param obj
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetObjectParameterivARB(int, int, java.nio.IntBuffer)
	 */
	public void glGetObjectParameterivARB(int obj, int pname, IntBuffer params) {
		getCurrent().glGetObjectParameterivARB(obj, pname, params);
	}

	/**
	 * @param obj
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetObjectParameterivARB(int, int, int[], int)
	 */
	public void glGetObjectParameterivARB(int obj, int pname, int[] params, int params_offset) {
		getCurrent().glGetObjectParameterivARB(obj, pname, params, params_offset);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetOcclusionQueryivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetOcclusionQueryivNV(int id, int pname, IntBuffer params) {
		getCurrent().glGetOcclusionQueryivNV(id, pname, params);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetOcclusionQueryivNV(int, int, int[], int)
	 */
	public void glGetOcclusionQueryivNV(int id, int pname, int[] params, int params_offset) {
		getCurrent().glGetOcclusionQueryivNV(id, pname, params, params_offset);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetOcclusionQueryuivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetOcclusionQueryuivNV(int id, int pname, IntBuffer params) {
		getCurrent().glGetOcclusionQueryuivNV(id, pname, params);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetOcclusionQueryuivNV(int, int, int[], int)
	 */
	public void glGetOcclusionQueryuivNV(int id, int pname, int[] params, int params_offset) {
		getCurrent().glGetOcclusionQueryuivNV(id, pname, params, params_offset);
	}

	/**
	 * @param color
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glGetPathColorGenfvNV(int, int, java.nio.FloatBuffer)
	 */
	public void glGetPathColorGenfvNV(int color, int pname, FloatBuffer value) {
		getCurrent().glGetPathColorGenfvNV(color, pname, value);
	}

	/**
	 * @param color
	 * @param pname
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glGetPathColorGenfvNV(int, int, float[], int)
	 */
	public void glGetPathColorGenfvNV(int color, int pname, float[] value, int value_offset) {
		getCurrent().glGetPathColorGenfvNV(color, pname, value, value_offset);
	}

	/**
	 * @param color
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glGetPathColorGenivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetPathColorGenivNV(int color, int pname, IntBuffer value) {
		getCurrent().glGetPathColorGenivNV(color, pname, value);
	}

	/**
	 * @param color
	 * @param pname
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glGetPathColorGenivNV(int, int, int[], int)
	 */
	public void glGetPathColorGenivNV(int color, int pname, int[] value, int value_offset) {
		getCurrent().glGetPathColorGenivNV(color, pname, value, value_offset);
	}

	/**
	 * @param path
	 * @param commands
	 * @see javax.media.opengl.GL2#glGetPathCommandsNV(int, java.nio.ByteBuffer)
	 */
	public void glGetPathCommandsNV(int path, ByteBuffer commands) {
		getCurrent().glGetPathCommandsNV(path, commands);
	}

	/**
	 * @param path
	 * @param commands
	 * @param commands_offset
	 * @see javax.media.opengl.GL2#glGetPathCommandsNV(int, byte[], int)
	 */
	public void glGetPathCommandsNV(int path, byte[] commands, int commands_offset) {
		getCurrent().glGetPathCommandsNV(path, commands, commands_offset);
	}

	/**
	 * @param path
	 * @param coords
	 * @see javax.media.opengl.GL2#glGetPathCoordsNV(int, java.nio.FloatBuffer)
	 */
	public void glGetPathCoordsNV(int path, FloatBuffer coords) {
		getCurrent().glGetPathCoordsNV(path, coords);
	}

	/**
	 * @param path
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glGetPathCoordsNV(int, float[], int)
	 */
	public void glGetPathCoordsNV(int path, float[] coords, int coords_offset) {
		getCurrent().glGetPathCoordsNV(path, coords, coords_offset);
	}

	/**
	 * @param path
	 * @param dashArray
	 * @see javax.media.opengl.GL2#glGetPathDashArrayNV(int, java.nio.FloatBuffer)
	 */
	public void glGetPathDashArrayNV(int path, FloatBuffer dashArray) {
		getCurrent().glGetPathDashArrayNV(path, dashArray);
	}

	/**
	 * @param path
	 * @param dashArray
	 * @param dashArray_offset
	 * @see javax.media.opengl.GL2#glGetPathDashArrayNV(int, float[], int)
	 */
	public void glGetPathDashArrayNV(int path, float[] dashArray, int dashArray_offset) {
		getCurrent().glGetPathDashArrayNV(path, dashArray, dashArray_offset);
	}

	/**
	 * @param path
	 * @param startSegment
	 * @param numSegments
	 * @return
	 * @see javax.media.opengl.GL2#glGetPathLengthNV(int, int, int)
	 */
	public float glGetPathLengthNV(int path, int startSegment, int numSegments) {
		return getCurrent().glGetPathLengthNV(path, startSegment, numSegments);
	}

	/**
	 * @param metricQueryMask
	 * @param firstPathName
	 * @param numPaths
	 * @param stride
	 * @param metrics
	 * @see javax.media.opengl.GL2#glGetPathMetricRangeNV(int, int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetPathMetricRangeNV(int metricQueryMask, int firstPathName, int numPaths, int stride, FloatBuffer metrics) {
		getCurrent().glGetPathMetricRangeNV(metricQueryMask, firstPathName, numPaths, stride, metrics);
	}

	/**
	 * @param metricQueryMask
	 * @param firstPathName
	 * @param numPaths
	 * @param stride
	 * @param metrics
	 * @param metrics_offset
	 * @see javax.media.opengl.GL2#glGetPathMetricRangeNV(int, int, int, int, float[], int)
	 */
	public void glGetPathMetricRangeNV(int metricQueryMask, int firstPathName, int numPaths, int stride, float[] metrics, int metrics_offset) {
		getCurrent().glGetPathMetricRangeNV(metricQueryMask, firstPathName, numPaths, stride, metrics, metrics_offset);
	}

	/**
	 * @param metricQueryMask
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param stride
	 * @param metrics
	 * @see javax.media.opengl.GL2#glGetPathMetricsNV(int, int, int, java.nio.Buffer, int, int, java.nio.FloatBuffer)
	 */
	public void glGetPathMetricsNV(int metricQueryMask, int numPaths, int pathNameType, Buffer paths, int pathBase, int stride, FloatBuffer metrics) {
		getCurrent().glGetPathMetricsNV(metricQueryMask, numPaths, pathNameType, paths, pathBase, stride, metrics);
	}

	/**
	 * @param metricQueryMask
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param stride
	 * @param metrics
	 * @param metrics_offset
	 * @see javax.media.opengl.GL2#glGetPathMetricsNV(int, int, int, java.nio.Buffer, int, int, float[], int)
	 */
	public void glGetPathMetricsNV(int metricQueryMask, int numPaths, int pathNameType, Buffer paths, int pathBase, int stride, float[] metrics, int metrics_offset) {
		getCurrent().glGetPathMetricsNV(metricQueryMask, numPaths, pathNameType, paths, pathBase, stride, metrics, metrics_offset);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glGetPathParameterfvNV(int, int, java.nio.FloatBuffer)
	 */
	public void glGetPathParameterfvNV(int path, int pname, FloatBuffer value) {
		getCurrent().glGetPathParameterfvNV(path, pname, value);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glGetPathParameterfvNV(int, int, float[], int)
	 */
	public void glGetPathParameterfvNV(int path, int pname, float[] value, int value_offset) {
		getCurrent().glGetPathParameterfvNV(path, pname, value, value_offset);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glGetPathParameterivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetPathParameterivNV(int path, int pname, IntBuffer value) {
		getCurrent().glGetPathParameterivNV(path, pname, value);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glGetPathParameterivNV(int, int, int[], int)
	 */
	public void glGetPathParameterivNV(int path, int pname, int[] value, int value_offset) {
		getCurrent().glGetPathParameterivNV(path, pname, value, value_offset);
	}

	/**
	 * @param pathListMode
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param advanceScale
	 * @param kerningScale
	 * @param transformType
	 * @param returnedSpacing
	 * @see javax.media.opengl.GL2#glGetPathSpacingNV(int, int, int, java.nio.Buffer, int, float, float, int, java.nio.FloatBuffer)
	 */
	public void glGetPathSpacingNV(int pathListMode, int numPaths, int pathNameType, Buffer paths, int pathBase, float advanceScale, float kerningScale, int transformType, FloatBuffer returnedSpacing) {
		getCurrent().glGetPathSpacingNV(pathListMode, numPaths, pathNameType, paths, pathBase, advanceScale, kerningScale, transformType, returnedSpacing);
	}

	/**
	 * @param pathListMode
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param advanceScale
	 * @param kerningScale
	 * @param transformType
	 * @param returnedSpacing
	 * @param returnedSpacing_offset
	 * @see javax.media.opengl.GL2#glGetPathSpacingNV(int, int, int, java.nio.Buffer, int, float, float, int, float[], int)
	 */
	public void glGetPathSpacingNV(int pathListMode, int numPaths, int pathNameType, Buffer paths, int pathBase, float advanceScale, float kerningScale, int transformType, float[] returnedSpacing, int returnedSpacing_offset) {
		getCurrent().glGetPathSpacingNV(pathListMode, numPaths, pathNameType, paths, pathBase, advanceScale, kerningScale, transformType, returnedSpacing, returnedSpacing_offset);
	}

	/**
	 * @param texCoordSet
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glGetPathTexGenfvNV(int, int, java.nio.FloatBuffer)
	 */
	public void glGetPathTexGenfvNV(int texCoordSet, int pname, FloatBuffer value) {
		getCurrent().glGetPathTexGenfvNV(texCoordSet, pname, value);
	}

	/**
	 * @param texCoordSet
	 * @param pname
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glGetPathTexGenfvNV(int, int, float[], int)
	 */
	public void glGetPathTexGenfvNV(int texCoordSet, int pname, float[] value, int value_offset) {
		getCurrent().glGetPathTexGenfvNV(texCoordSet, pname, value, value_offset);
	}

	/**
	 * @param texCoordSet
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glGetPathTexGenivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetPathTexGenivNV(int texCoordSet, int pname, IntBuffer value) {
		getCurrent().glGetPathTexGenivNV(texCoordSet, pname, value);
	}

	/**
	 * @param texCoordSet
	 * @param pname
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glGetPathTexGenivNV(int, int, int[], int)
	 */
	public void glGetPathTexGenivNV(int texCoordSet, int pname, int[] value, int value_offset) {
		getCurrent().glGetPathTexGenivNV(texCoordSet, pname, value, value_offset);
	}

	/**
	 * @param monitor
	 * @param pname
	 * @param dataSize
	 * @param data
	 * @param bytesWritten
	 * @see javax.media.opengl.GL2#glGetPerfMonitorCounterDataAMD(int, int, int, java.nio.IntBuffer, java.nio.IntBuffer)
	 */
	public void glGetPerfMonitorCounterDataAMD(int monitor, int pname, int dataSize, IntBuffer data, IntBuffer bytesWritten) {
		getCurrent().glGetPerfMonitorCounterDataAMD(monitor, pname, dataSize, data, bytesWritten);
	}

	/**
	 * @param monitor
	 * @param pname
	 * @param dataSize
	 * @param data
	 * @param data_offset
	 * @param bytesWritten
	 * @param bytesWritten_offset
	 * @see javax.media.opengl.GL2#glGetPerfMonitorCounterDataAMD(int, int, int, int[], int, int[], int)
	 */
	public void glGetPerfMonitorCounterDataAMD(int monitor, int pname, int dataSize, int[] data, int data_offset, int[] bytesWritten, int bytesWritten_offset) {
		getCurrent().glGetPerfMonitorCounterDataAMD(monitor, pname, dataSize, data, data_offset, bytesWritten, bytesWritten_offset);
	}

	/**
	 * @param group
	 * @param counter
	 * @param pname
	 * @param data
	 * @see javax.media.opengl.GL2#glGetPerfMonitorCounterInfoAMD(int, int, int, java.nio.Buffer)
	 */
	public void glGetPerfMonitorCounterInfoAMD(int group, int counter, int pname, Buffer data) {
		getCurrent().glGetPerfMonitorCounterInfoAMD(group, counter, pname, data);
	}

	/**
	 * @param group
	 * @param counter
	 * @param bufSize
	 * @param length
	 * @param counterString
	 * @see javax.media.opengl.GL2#glGetPerfMonitorCounterStringAMD(int, int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize, IntBuffer length, ByteBuffer counterString) {
		getCurrent().glGetPerfMonitorCounterStringAMD(group, counter, bufSize, length, counterString);
	}

	/**
	 * @param group
	 * @param counter
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param counterString
	 * @param counterString_offset
	 * @see javax.media.opengl.GL2#glGetPerfMonitorCounterStringAMD(int, int, int, int[], int, byte[], int)
	 */
	public void glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize, int[] length, int length_offset, byte[] counterString, int counterString_offset) {
		getCurrent().glGetPerfMonitorCounterStringAMD(group, counter, bufSize, length, length_offset, counterString, counterString_offset);
	}

	/**
	 * @param group
	 * @param numCounters
	 * @param maxActiveCounters
	 * @param counterSize
	 * @param counters
	 * @see javax.media.opengl.GL2#glGetPerfMonitorCountersAMD(int, java.nio.IntBuffer, java.nio.IntBuffer, int, java.nio.IntBuffer)
	 */
	public void glGetPerfMonitorCountersAMD(int group, IntBuffer numCounters, IntBuffer maxActiveCounters, int counterSize, IntBuffer counters) {
		getCurrent().glGetPerfMonitorCountersAMD(group, numCounters, maxActiveCounters, counterSize, counters);
	}

	/**
	 * @param group
	 * @param numCounters
	 * @param numCounters_offset
	 * @param maxActiveCounters
	 * @param maxActiveCounters_offset
	 * @param counterSize
	 * @param counters
	 * @param counters_offset
	 * @see javax.media.opengl.GL2#glGetPerfMonitorCountersAMD(int, int[], int, int[], int, int, int[], int)
	 */
	public void glGetPerfMonitorCountersAMD(int group, int[] numCounters, int numCounters_offset, int[] maxActiveCounters, int maxActiveCounters_offset, int counterSize, int[] counters, int counters_offset) {
		getCurrent().glGetPerfMonitorCountersAMD(group, numCounters, numCounters_offset, maxActiveCounters, maxActiveCounters_offset, counterSize, counters, counters_offset);
	}

	/**
	 * @param group
	 * @param bufSize
	 * @param length
	 * @param groupString
	 * @see javax.media.opengl.GL2#glGetPerfMonitorGroupStringAMD(int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetPerfMonitorGroupStringAMD(int group, int bufSize, IntBuffer length, ByteBuffer groupString) {
		getCurrent().glGetPerfMonitorGroupStringAMD(group, bufSize, length, groupString);
	}

	/**
	 * @param group
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param groupString
	 * @param groupString_offset
	 * @see javax.media.opengl.GL2#glGetPerfMonitorGroupStringAMD(int, int, int[], int, byte[], int)
	 */
	public void glGetPerfMonitorGroupStringAMD(int group, int bufSize, int[] length, int length_offset, byte[] groupString, int groupString_offset) {
		getCurrent().glGetPerfMonitorGroupStringAMD(group, bufSize, length, length_offset, groupString, groupString_offset);
	}

	/**
	 * @param numGroups
	 * @param groupsSize
	 * @param groups
	 * @see javax.media.opengl.GL2#glGetPerfMonitorGroupsAMD(java.nio.IntBuffer, int, java.nio.IntBuffer)
	 */
	public void glGetPerfMonitorGroupsAMD(IntBuffer numGroups, int groupsSize, IntBuffer groups) {
		getCurrent().glGetPerfMonitorGroupsAMD(numGroups, groupsSize, groups);
	}

	/**
	 * @param numGroups
	 * @param numGroups_offset
	 * @param groupsSize
	 * @param groups
	 * @param groups_offset
	 * @see javax.media.opengl.GL2#glGetPerfMonitorGroupsAMD(int[], int, int, int[], int)
	 */
	public void glGetPerfMonitorGroupsAMD(int[] numGroups, int numGroups_offset, int groupsSize, int[] groups, int groups_offset) {
		getCurrent().glGetPerfMonitorGroupsAMD(numGroups, numGroups_offset, groupsSize, groups, groups_offset);
	}

	/**
	 * @param map
	 * @param values
	 * @see javax.media.opengl.GL2#glGetPixelMapfv(int, java.nio.FloatBuffer)
	 */
	public void glGetPixelMapfv(int map, FloatBuffer values) {
		getCurrent().glGetPixelMapfv(map, values);
	}

	/**
	 * @param map
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glGetPixelMapfv(int, float[], int)
	 */
	public void glGetPixelMapfv(int map, float[] values, int values_offset) {
		getCurrent().glGetPixelMapfv(map, values, values_offset);
	}

	/**
	 * @param map
	 * @param values_buffer_offset
	 * @see javax.media.opengl.GL2#glGetPixelMapfv(int, long)
	 */
	public void glGetPixelMapfv(int map, long values_buffer_offset) {
		getCurrent().glGetPixelMapfv(map, values_buffer_offset);
	}

	/**
	 * @param map
	 * @param values
	 * @see javax.media.opengl.GL2#glGetPixelMapuiv(int, java.nio.IntBuffer)
	 */
	public void glGetPixelMapuiv(int map, IntBuffer values) {
		getCurrent().glGetPixelMapuiv(map, values);
	}

	/**
	 * @param map
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glGetPixelMapuiv(int, int[], int)
	 */
	public void glGetPixelMapuiv(int map, int[] values, int values_offset) {
		getCurrent().glGetPixelMapuiv(map, values, values_offset);
	}

	/**
	 * @param map
	 * @param values_buffer_offset
	 * @see javax.media.opengl.GL2#glGetPixelMapuiv(int, long)
	 */
	public void glGetPixelMapuiv(int map, long values_buffer_offset) {
		getCurrent().glGetPixelMapuiv(map, values_buffer_offset);
	}

	/**
	 * @param map
	 * @param values
	 * @see javax.media.opengl.GL2#glGetPixelMapusv(int, java.nio.ShortBuffer)
	 */
	public void glGetPixelMapusv(int map, ShortBuffer values) {
		getCurrent().glGetPixelMapusv(map, values);
	}

	/**
	 * @param map
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glGetPixelMapusv(int, short[], int)
	 */
	public void glGetPixelMapusv(int map, short[] values, int values_offset) {
		getCurrent().glGetPixelMapusv(map, values, values_offset);
	}

	/**
	 * @param map
	 * @param values_buffer_offset
	 * @see javax.media.opengl.GL2#glGetPixelMapusv(int, long)
	 */
	public void glGetPixelMapusv(int map, long values_buffer_offset) {
		getCurrent().glGetPixelMapusv(map, values_buffer_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetPixelTransformParameterfvEXT(int, int, java.nio.FloatBuffer)
	 */
	public void glGetPixelTransformParameterfvEXT(int target, int pname, FloatBuffer params) {
		getCurrent().glGetPixelTransformParameterfvEXT(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetPixelTransformParameterfvEXT(int, int, float[], int)
	 */
	public void glGetPixelTransformParameterfvEXT(int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetPixelTransformParameterfvEXT(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetPixelTransformParameterivEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetPixelTransformParameterivEXT(int target, int pname, IntBuffer params) {
		getCurrent().glGetPixelTransformParameterivEXT(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetPixelTransformParameterivEXT(int, int, int[], int)
	 */
	public void glGetPixelTransformParameterivEXT(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetPixelTransformParameterivEXT(target, pname, params, params_offset);
	}

	/**
	 * @param pname
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetPointeri_vEXT(int, int, com.jogamp.common.nio.PointerBuffer)
	 */
	public void glGetPointeri_vEXT(int pname, int index, PointerBuffer params) {
		getCurrent().glGetPointeri_vEXT(pname, index, params);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL2#glGetPolygonStipple(java.nio.ByteBuffer)
	 */
	public void glGetPolygonStipple(ByteBuffer mask) {
		getCurrent().glGetPolygonStipple(mask);
	}

	/**
	 * @param mask
	 * @param mask_offset
	 * @see javax.media.opengl.GL2#glGetPolygonStipple(byte[], int)
	 */
	public void glGetPolygonStipple(byte[] mask, int mask_offset) {
		getCurrent().glGetPolygonStipple(mask, mask_offset);
	}

	/**
	 * @param mask_buffer_offset
	 * @see javax.media.opengl.GL2#glGetPolygonStipple(long)
	 */
	public void glGetPolygonStipple(long mask_buffer_offset) {
		getCurrent().glGetPolygonStipple(mask_buffer_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramEnvParameterIivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetProgramEnvParameterIivNV(int target, int index, IntBuffer params) {
		getCurrent().glGetProgramEnvParameterIivNV(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramEnvParameterIivNV(int, int, int[], int)
	 */
	public void glGetProgramEnvParameterIivNV(int target, int index, int[] params, int params_offset) {
		getCurrent().glGetProgramEnvParameterIivNV(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramEnvParameterIuivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetProgramEnvParameterIuivNV(int target, int index, IntBuffer params) {
		getCurrent().glGetProgramEnvParameterIuivNV(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramEnvParameterIuivNV(int, int, int[], int)
	 */
	public void glGetProgramEnvParameterIuivNV(int target, int index, int[] params, int params_offset) {
		getCurrent().glGetProgramEnvParameterIuivNV(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramEnvParameterdvARB(int, int, java.nio.DoubleBuffer)
	 */
	public void glGetProgramEnvParameterdvARB(int target, int index, DoubleBuffer params) {
		getCurrent().glGetProgramEnvParameterdvARB(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramEnvParameterdvARB(int, int, double[], int)
	 */
	public void glGetProgramEnvParameterdvARB(int target, int index, double[] params, int params_offset) {
		getCurrent().glGetProgramEnvParameterdvARB(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramEnvParameterfvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glGetProgramEnvParameterfvARB(int target, int index, FloatBuffer params) {
		getCurrent().glGetProgramEnvParameterfvARB(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramEnvParameterfvARB(int, int, float[], int)
	 */
	public void glGetProgramEnvParameterfvARB(int target, int index, float[] params, int params_offset) {
		getCurrent().glGetProgramEnvParameterfvARB(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramLocalParameterIivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetProgramLocalParameterIivNV(int target, int index, IntBuffer params) {
		getCurrent().glGetProgramLocalParameterIivNV(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramLocalParameterIivNV(int, int, int[], int)
	 */
	public void glGetProgramLocalParameterIivNV(int target, int index, int[] params, int params_offset) {
		getCurrent().glGetProgramLocalParameterIivNV(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramLocalParameterIuivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetProgramLocalParameterIuivNV(int target, int index, IntBuffer params) {
		getCurrent().glGetProgramLocalParameterIuivNV(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramLocalParameterIuivNV(int, int, int[], int)
	 */
	public void glGetProgramLocalParameterIuivNV(int target, int index, int[] params, int params_offset) {
		getCurrent().glGetProgramLocalParameterIuivNV(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramLocalParameterdvARB(int, int, java.nio.DoubleBuffer)
	 */
	public void glGetProgramLocalParameterdvARB(int target, int index, DoubleBuffer params) {
		getCurrent().glGetProgramLocalParameterdvARB(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramLocalParameterdvARB(int, int, double[], int)
	 */
	public void glGetProgramLocalParameterdvARB(int target, int index, double[] params, int params_offset) {
		getCurrent().glGetProgramLocalParameterdvARB(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramLocalParameterfvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glGetProgramLocalParameterfvARB(int target, int index, FloatBuffer params) {
		getCurrent().glGetProgramLocalParameterfvARB(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramLocalParameterfvARB(int, int, float[], int)
	 */
	public void glGetProgramLocalParameterfvARB(int target, int index, float[] params, int params_offset) {
		getCurrent().glGetProgramLocalParameterfvARB(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param string
	 * @see javax.media.opengl.GL2#glGetProgramStringARB(int, int, java.nio.Buffer)
	 */
	public void glGetProgramStringARB(int target, int pname, Buffer string) {
		getCurrent().glGetProgramStringARB(target, pname, string);
	}

	/**
	 * @param target
	 * @param index
	 * @param param
	 * @see javax.media.opengl.GL2#glGetProgramSubroutineParameteruivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetProgramSubroutineParameteruivNV(int target, int index, IntBuffer param) {
		getCurrent().glGetProgramSubroutineParameteruivNV(target, index, param);
	}

	/**
	 * @param target
	 * @param index
	 * @param param
	 * @param param_offset
	 * @see javax.media.opengl.GL2#glGetProgramSubroutineParameteruivNV(int, int, int[], int)
	 */
	public void glGetProgramSubroutineParameteruivNV(int target, int index, int[] param, int param_offset) {
		getCurrent().glGetProgramSubroutineParameteruivNV(target, index, param, param_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetProgramivARB(int, int, java.nio.IntBuffer)
	 */
	public void glGetProgramivARB(int target, int pname, IntBuffer params) {
		getCurrent().glGetProgramivARB(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetProgramivARB(int, int, int[], int)
	 */
	public void glGetProgramivARB(int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetProgramivARB(target, pname, params, params_offset);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetQueryObjecti64vEXT(int, int, java.nio.LongBuffer)
	 */
	public void glGetQueryObjecti64vEXT(int id, int pname, LongBuffer params) {
		getCurrent().glGetQueryObjecti64vEXT(id, pname, params);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetQueryObjecti64vEXT(int, int, long[], int)
	 */
	public void glGetQueryObjecti64vEXT(int id, int pname, long[] params, int params_offset) {
		getCurrent().glGetQueryObjecti64vEXT(id, pname, params, params_offset);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetQueryObjectui64vEXT(int, int, java.nio.LongBuffer)
	 */
	public void glGetQueryObjectui64vEXT(int id, int pname, LongBuffer params) {
		getCurrent().glGetQueryObjectui64vEXT(id, pname, params);
	}

	/**
	 * @param id
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetQueryObjectui64vEXT(int, int, long[], int)
	 */
	public void glGetQueryObjectui64vEXT(int id, int pname, long[] params, int params_offset) {
		getCurrent().glGetQueryObjectui64vEXT(id, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param row
	 * @param column
	 * @param span
	 * @see javax.media.opengl.GL2#glGetSeparableFilter(int, int, int, java.nio.Buffer, java.nio.Buffer, java.nio.Buffer)
	 */
	public void glGetSeparableFilter(int target, int format, int type, Buffer row, Buffer column, Buffer span) {
		getCurrent().glGetSeparableFilter(target, format, type, row, column, span);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param row_buffer_offset
	 * @param column_buffer_offset
	 * @param span_buffer_offset
	 * @see javax.media.opengl.GL2#glGetSeparableFilter(int, int, int, long, long, long)
	 */
	public void glGetSeparableFilter(int target, int format, int type, long row_buffer_offset, long column_buffer_offset, long span_buffer_offset) {
		getCurrent().glGetSeparableFilter(target, format, type, row_buffer_offset, column_buffer_offset, span_buffer_offset);
	}

	/**
	 * @param obj
	 * @param maxLength
	 * @param length
	 * @param source
	 * @see javax.media.opengl.GL2#glGetShaderSourceARB(int, int, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetShaderSourceARB(int obj, int maxLength, IntBuffer length, ByteBuffer source) {
		getCurrent().glGetShaderSourceARB(obj, maxLength, length, source);
	}

	/**
	 * @param obj
	 * @param maxLength
	 * @param length
	 * @param length_offset
	 * @param source
	 * @param source_offset
	 * @see javax.media.opengl.GL2#glGetShaderSourceARB(int, int, int[], int, byte[], int)
	 */
	public void glGetShaderSourceARB(int obj, int maxLength, int[] length, int length_offset, byte[] source, int source_offset) {
		getCurrent().glGetShaderSourceARB(obj, maxLength, length, length_offset, source, source_offset);
	}

	/**
	 * @param name
	 * @param index
	 * @return
	 * @see javax.media.opengl.GL2#glGetStringi(int, int)
	 */
	public String glGetStringi(int name, int index) {
		return getCurrent().glGetStringi(name, index);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetTexGendv(int, int, java.nio.DoubleBuffer)
	 */
	public void glGetTexGendv(int coord, int pname, DoubleBuffer params) {
		getCurrent().glGetTexGendv(coord, pname, params);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetTexGendv(int, int, double[], int)
	 */
	public void glGetTexGendv(int coord, int pname, double[] params, int params_offset) {
		getCurrent().glGetTexGendv(coord, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @return
	 * @see javax.media.opengl.GL2#glGetTextureHandleNV(int)
	 */
	public long glGetTextureHandleNV(int texture) {
		return getCurrent().glGetTextureHandleNV(texture);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glGetTextureImageEXT(int, int, int, int, int, java.nio.Buffer)
	 */
	public void glGetTextureImageEXT(int texture, int target, int level, int format, int type, Buffer pixels) {
		getCurrent().glGetTextureImageEXT(texture, target, level, format, type, pixels);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetTextureLevelParameterfvEXT(int, int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetTextureLevelParameterfvEXT(int texture, int target, int level, int pname, FloatBuffer params) {
		getCurrent().glGetTextureLevelParameterfvEXT(texture, target, level, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetTextureLevelParameterfvEXT(int, int, int, int, float[], int)
	 */
	public void glGetTextureLevelParameterfvEXT(int texture, int target, int level, int pname, float[] params, int params_offset) {
		getCurrent().glGetTextureLevelParameterfvEXT(texture, target, level, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetTextureLevelParameterivEXT(int, int, int, int, java.nio.IntBuffer)
	 */
	public void glGetTextureLevelParameterivEXT(int texture, int target, int level, int pname, IntBuffer params) {
		getCurrent().glGetTextureLevelParameterivEXT(texture, target, level, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetTextureLevelParameterivEXT(int, int, int, int, int[], int)
	 */
	public void glGetTextureLevelParameterivEXT(int texture, int target, int level, int pname, int[] params, int params_offset) {
		getCurrent().glGetTextureLevelParameterivEXT(texture, target, level, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetTextureParameterIivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetTextureParameterIivEXT(int texture, int target, int pname, IntBuffer params) {
		getCurrent().glGetTextureParameterIivEXT(texture, target, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetTextureParameterIivEXT(int, int, int, int[], int)
	 */
	public void glGetTextureParameterIivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetTextureParameterIivEXT(texture, target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetTextureParameterIuivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetTextureParameterIuivEXT(int texture, int target, int pname, IntBuffer params) {
		getCurrent().glGetTextureParameterIuivEXT(texture, target, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetTextureParameterIuivEXT(int, int, int, int[], int)
	 */
	public void glGetTextureParameterIuivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetTextureParameterIuivEXT(texture, target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetTextureParameterfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetTextureParameterfvEXT(int texture, int target, int pname, FloatBuffer params) {
		getCurrent().glGetTextureParameterfvEXT(texture, target, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetTextureParameterfvEXT(int, int, int, float[], int)
	 */
	public void glGetTextureParameterfvEXT(int texture, int target, int pname, float[] params, int params_offset) {
		getCurrent().glGetTextureParameterfvEXT(texture, target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetTextureParameterivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetTextureParameterivEXT(int texture, int target, int pname, IntBuffer params) {
		getCurrent().glGetTextureParameterivEXT(texture, target, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetTextureParameterivEXT(int, int, int, int[], int)
	 */
	public void glGetTextureParameterivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		getCurrent().glGetTextureParameterivEXT(texture, target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param sampler
	 * @return
	 * @see javax.media.opengl.GL2#glGetTextureSamplerHandleNV(int, int)
	 */
	public long glGetTextureSamplerHandleNV(int texture, int sampler) {
		return getCurrent().glGetTextureSamplerHandleNV(texture, sampler);
	}

	/**
	 * @param program
	 * @param index
	 * @param bufSize
	 * @param length
	 * @param size
	 * @param type
	 * @param name
	 * @see javax.media.opengl.GL2#glGetTransformFeedbackVarying(int, int, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.ByteBuffer)
	 */
	public void glGetTransformFeedbackVarying(int program, int index, int bufSize, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		getCurrent().glGetTransformFeedbackVarying(program, index, bufSize, length, size, type, name);
	}

	/**
	 * @param program
	 * @param index
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param size
	 * @param size_offset
	 * @param type
	 * @param type_offset
	 * @param name
	 * @param name_offset
	 * @see javax.media.opengl.GL2#glGetTransformFeedbackVarying(int, int, int, int[], int, int[], int, int[], int, byte[], int)
	 */
	public void glGetTransformFeedbackVarying(int program, int index, int bufSize, int[] length, int length_offset, int[] size, int size_offset, int[] type, int type_offset, byte[] name, int name_offset) {
		getCurrent().glGetTransformFeedbackVarying(program, index, bufSize, length, length_offset, size, size_offset, type, type_offset, name, name_offset);
	}

	/**
	 * @param program
	 * @param uniformBlockName
	 * @return
	 * @see javax.media.opengl.GL2#glGetUniformBlockIndex(int, java.lang.String)
	 */
	public int glGetUniformBlockIndex(int program, String uniformBlockName) {
		return getCurrent().glGetUniformBlockIndex(program, uniformBlockName);
	}

	/**
	 * @param program
	 * @param location
	 * @return
	 * @see javax.media.opengl.GL2#glGetUniformBufferSizeEXT(int, int)
	 */
	public int glGetUniformBufferSizeEXT(int program, int location) {
		return getCurrent().glGetUniformBufferSizeEXT(program, location);
	}

	/**
	 * @param program
	 * @param uniformCount
	 * @param uniformNames
	 * @param uniformIndices
	 * @see javax.media.opengl.GL2#glGetUniformIndices(int, int, java.lang.String[], java.nio.IntBuffer)
	 */
	public void glGetUniformIndices(int program, int uniformCount, String[] uniformNames, IntBuffer uniformIndices) {
		getCurrent().glGetUniformIndices(program, uniformCount, uniformNames, uniformIndices);
	}

	/**
	 * @param program
	 * @param uniformCount
	 * @param uniformNames
	 * @param uniformIndices
	 * @param uniformIndices_offset
	 * @see javax.media.opengl.GL2#glGetUniformIndices(int, int, java.lang.String[], int[], int)
	 */
	public void glGetUniformIndices(int program, int uniformCount, String[] uniformNames, int[] uniformIndices, int uniformIndices_offset) {
		getCurrent().glGetUniformIndices(program, uniformCount, uniformNames, uniformIndices, uniformIndices_offset);
	}

	/**
	 * @param programObj
	 * @param name
	 * @return
	 * @see javax.media.opengl.GL2#glGetUniformLocationARB(int, java.lang.String)
	 */
	public int glGetUniformLocationARB(int programObj, String name) {
		return getCurrent().glGetUniformLocationARB(programObj, name);
	}

	/**
	 * @param program
	 * @param location
	 * @return
	 * @see javax.media.opengl.GL2#glGetUniformOffsetEXT(int, int)
	 */
	public long glGetUniformOffsetEXT(int program, int location) {
		return getCurrent().glGetUniformOffsetEXT(program, location);
	}

	/**
	 * @param programObj
	 * @param location
	 * @param params
	 * @see javax.media.opengl.GL2#glGetUniformfvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glGetUniformfvARB(int programObj, int location, FloatBuffer params) {
		getCurrent().glGetUniformfvARB(programObj, location, params);
	}

	/**
	 * @param programObj
	 * @param location
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetUniformfvARB(int, int, float[], int)
	 */
	public void glGetUniformfvARB(int programObj, int location, float[] params, int params_offset) {
		getCurrent().glGetUniformfvARB(programObj, location, params, params_offset);
	}

	/**
	 * @param programObj
	 * @param location
	 * @param params
	 * @see javax.media.opengl.GL2#glGetUniformivARB(int, int, java.nio.IntBuffer)
	 */
	public void glGetUniformivARB(int programObj, int location, IntBuffer params) {
		getCurrent().glGetUniformivARB(programObj, location, params);
	}

	/**
	 * @param programObj
	 * @param location
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetUniformivARB(int, int, int[], int)
	 */
	public void glGetUniformivARB(int programObj, int location, int[] params, int params_offset) {
		getCurrent().glGetUniformivARB(programObj, location, params, params_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param params
	 * @see javax.media.opengl.GL2#glGetUniformuiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetUniformuiv(int program, int location, IntBuffer params) {
		getCurrent().glGetUniformuiv(program, location, params);
	}

	/**
	 * @param program
	 * @param location
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetUniformuiv(int, int, int[], int)
	 */
	public void glGetUniformuiv(int program, int location, int[] params, int params_offset) {
		getCurrent().glGetUniformuiv(program, location, params, params_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetVariantBooleanvEXT(int, int, java.nio.ByteBuffer)
	 */
	public void glGetVariantBooleanvEXT(int id, int value, ByteBuffer data) {
		getCurrent().glGetVariantBooleanvEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetVariantBooleanvEXT(int, int, byte[], int)
	 */
	public void glGetVariantBooleanvEXT(int id, int value, byte[] data, int data_offset) {
		getCurrent().glGetVariantBooleanvEXT(id, value, data, data_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetVariantFloatvEXT(int, int, java.nio.FloatBuffer)
	 */
	public void glGetVariantFloatvEXT(int id, int value, FloatBuffer data) {
		getCurrent().glGetVariantFloatvEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetVariantFloatvEXT(int, int, float[], int)
	 */
	public void glGetVariantFloatvEXT(int id, int value, float[] data, int data_offset) {
		getCurrent().glGetVariantFloatvEXT(id, value, data, data_offset);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @see javax.media.opengl.GL2#glGetVariantIntegervEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetVariantIntegervEXT(int id, int value, IntBuffer data) {
		getCurrent().glGetVariantIntegervEXT(id, value, data);
	}

	/**
	 * @param id
	 * @param value
	 * @param data
	 * @param data_offset
	 * @see javax.media.opengl.GL2#glGetVariantIntegervEXT(int, int, int[], int)
	 */
	public void glGetVariantIntegervEXT(int id, int value, int[] data, int data_offset) {
		getCurrent().glGetVariantIntegervEXT(id, value, data, data_offset);
	}

	/**
	 * @param vaobj
	 * @param index
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glGetVertexArrayIntegeri_vEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetVertexArrayIntegeri_vEXT(int vaobj, int index, int pname, IntBuffer param) {
		getCurrent().glGetVertexArrayIntegeri_vEXT(vaobj, index, pname, param);
	}

	/**
	 * @param vaobj
	 * @param index
	 * @param pname
	 * @param param
	 * @param param_offset
	 * @see javax.media.opengl.GL2#glGetVertexArrayIntegeri_vEXT(int, int, int, int[], int)
	 */
	public void glGetVertexArrayIntegeri_vEXT(int vaobj, int index, int pname, int[] param, int param_offset) {
		getCurrent().glGetVertexArrayIntegeri_vEXT(vaobj, index, pname, param, param_offset);
	}

	/**
	 * @param vaobj
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glGetVertexArrayIntegervEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetVertexArrayIntegervEXT(int vaobj, int pname, IntBuffer param) {
		getCurrent().glGetVertexArrayIntegervEXT(vaobj, pname, param);
	}

	/**
	 * @param vaobj
	 * @param pname
	 * @param param
	 * @param param_offset
	 * @see javax.media.opengl.GL2#glGetVertexArrayIntegervEXT(int, int, int[], int)
	 */
	public void glGetVertexArrayIntegervEXT(int vaobj, int pname, int[] param, int param_offset) {
		getCurrent().glGetVertexArrayIntegervEXT(vaobj, pname, param, param_offset);
	}

	/**
	 * @param vaobj
	 * @param index
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glGetVertexArrayPointeri_vEXT(int, int, int, com.jogamp.common.nio.PointerBuffer)
	 */
	public void glGetVertexArrayPointeri_vEXT(int vaobj, int index, int pname, PointerBuffer param) {
		getCurrent().glGetVertexArrayPointeri_vEXT(vaobj, index, pname, param);
	}

	/**
	 * @param vaobj
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glGetVertexArrayPointervEXT(int, int, com.jogamp.common.nio.PointerBuffer)
	 */
	public void glGetVertexArrayPointervEXT(int vaobj, int pname, PointerBuffer param) {
		getCurrent().glGetVertexArrayPointervEXT(vaobj, pname, param);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribIiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetVertexAttribIiv(int index, int pname, IntBuffer params) {
		getCurrent().glGetVertexAttribIiv(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribIiv(int, int, int[], int)
	 */
	public void glGetVertexAttribIiv(int index, int pname, int[] params, int params_offset) {
		getCurrent().glGetVertexAttribIiv(index, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribIivEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetVertexAttribIivEXT(int index, int pname, IntBuffer params) {
		getCurrent().glGetVertexAttribIivEXT(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribIivEXT(int, int, int[], int)
	 */
	public void glGetVertexAttribIivEXT(int index, int pname, int[] params, int params_offset) {
		getCurrent().glGetVertexAttribIivEXT(index, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribIuiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetVertexAttribIuiv(int index, int pname, IntBuffer params) {
		getCurrent().glGetVertexAttribIuiv(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribIuiv(int, int, int[], int)
	 */
	public void glGetVertexAttribIuiv(int index, int pname, int[] params, int params_offset) {
		getCurrent().glGetVertexAttribIuiv(index, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribIuivEXT(int, int, java.nio.IntBuffer)
	 */
	public void glGetVertexAttribIuivEXT(int index, int pname, IntBuffer params) {
		getCurrent().glGetVertexAttribIuivEXT(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribIuivEXT(int, int, int[], int)
	 */
	public void glGetVertexAttribIuivEXT(int index, int pname, int[] params, int params_offset) {
		getCurrent().glGetVertexAttribIuivEXT(index, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribLi64vNV(int, int, java.nio.LongBuffer)
	 */
	public void glGetVertexAttribLi64vNV(int index, int pname, LongBuffer params) {
		getCurrent().glGetVertexAttribLi64vNV(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribLi64vNV(int, int, long[], int)
	 */
	public void glGetVertexAttribLi64vNV(int index, int pname, long[] params, int params_offset) {
		getCurrent().glGetVertexAttribLi64vNV(index, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribLui64vNV(int, int, java.nio.LongBuffer)
	 */
	public void glGetVertexAttribLui64vNV(int index, int pname, LongBuffer params) {
		getCurrent().glGetVertexAttribLui64vNV(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribLui64vNV(int, int, long[], int)
	 */
	public void glGetVertexAttribLui64vNV(int index, int pname, long[] params, int params_offset) {
		getCurrent().glGetVertexAttribLui64vNV(index, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribdvARB(int, int, java.nio.DoubleBuffer)
	 */
	public void glGetVertexAttribdvARB(int index, int pname, DoubleBuffer params) {
		getCurrent().glGetVertexAttribdvARB(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribdvARB(int, int, double[], int)
	 */
	public void glGetVertexAttribdvARB(int index, int pname, double[] params, int params_offset) {
		getCurrent().glGetVertexAttribdvARB(index, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribfvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glGetVertexAttribfvARB(int index, int pname, FloatBuffer params) {
		getCurrent().glGetVertexAttribfvARB(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribfvARB(int, int, float[], int)
	 */
	public void glGetVertexAttribfvARB(int index, int pname, float[] params, int params_offset) {
		getCurrent().glGetVertexAttribfvARB(index, pname, params, params_offset);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVertexAttribivARB(int, int, java.nio.IntBuffer)
	 */
	public void glGetVertexAttribivARB(int index, int pname, IntBuffer params) {
		getCurrent().glGetVertexAttribivARB(index, pname, params);
	}

	/**
	 * @param index
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVertexAttribivARB(int, int, int[], int)
	 */
	public void glGetVertexAttribivARB(int index, int pname, int[] params, int params_offset) {
		getCurrent().glGetVertexAttribivARB(index, pname, params, params_offset);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVideoCaptureStreamdvNV(int, int, int, java.nio.DoubleBuffer)
	 */
	public void glGetVideoCaptureStreamdvNV(int video_capture_slot, int stream, int pname, DoubleBuffer params) {
		getCurrent().glGetVideoCaptureStreamdvNV(video_capture_slot, stream, pname, params);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVideoCaptureStreamdvNV(int, int, int, double[], int)
	 */
	public void glGetVideoCaptureStreamdvNV(int video_capture_slot, int stream, int pname, double[] params, int params_offset) {
		getCurrent().glGetVideoCaptureStreamdvNV(video_capture_slot, stream, pname, params, params_offset);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVideoCaptureStreamfvNV(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetVideoCaptureStreamfvNV(int video_capture_slot, int stream, int pname, FloatBuffer params) {
		getCurrent().glGetVideoCaptureStreamfvNV(video_capture_slot, stream, pname, params);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVideoCaptureStreamfvNV(int, int, int, float[], int)
	 */
	public void glGetVideoCaptureStreamfvNV(int video_capture_slot, int stream, int pname, float[] params, int params_offset) {
		getCurrent().glGetVideoCaptureStreamfvNV(video_capture_slot, stream, pname, params, params_offset);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVideoCaptureStreamivNV(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetVideoCaptureStreamivNV(int video_capture_slot, int stream, int pname, IntBuffer params) {
		getCurrent().glGetVideoCaptureStreamivNV(video_capture_slot, stream, pname, params);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVideoCaptureStreamivNV(int, int, int, int[], int)
	 */
	public void glGetVideoCaptureStreamivNV(int video_capture_slot, int stream, int pname, int[] params, int params_offset) {
		getCurrent().glGetVideoCaptureStreamivNV(video_capture_slot, stream, pname, params, params_offset);
	}

	/**
	 * @param video_capture_slot
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glGetVideoCaptureivNV(int, int, java.nio.IntBuffer)
	 */
	public void glGetVideoCaptureivNV(int video_capture_slot, int pname, IntBuffer params) {
		getCurrent().glGetVideoCaptureivNV(video_capture_slot, pname, params);
	}

	/**
	 * @param video_capture_slot
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glGetVideoCaptureivNV(int, int, int[], int)
	 */
	public void glGetVideoCaptureivNV(int video_capture_slot, int pname, int[] params, int params_offset) {
		getCurrent().glGetVideoCaptureivNV(video_capture_slot, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param bufSize
	 * @param table
	 * @see javax.media.opengl.GL2#glGetnColorTable(int, int, int, int, java.nio.Buffer)
	 */
	public void glGetnColorTable(int target, int format, int type, int bufSize, Buffer table) {
		getCurrent().glGetnColorTable(target, format, type, bufSize, table);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param bufSize
	 * @param image
	 * @see javax.media.opengl.GL2#glGetnConvolutionFilter(int, int, int, int, java.nio.Buffer)
	 */
	public void glGetnConvolutionFilter(int target, int format, int type, int bufSize, Buffer image) {
		getCurrent().glGetnConvolutionFilter(target, format, type, bufSize, image);
	}

	/**
	 * @param target
	 * @param reset
	 * @param format
	 * @param type
	 * @param bufSize
	 * @param values
	 * @see javax.media.opengl.GL2#glGetnHistogram(int, boolean, int, int, int, java.nio.Buffer)
	 */
	public void glGetnHistogram(int target, boolean reset, int format, int type, int bufSize, Buffer values) {
		getCurrent().glGetnHistogram(target, reset, format, type, bufSize, values);
	}

	/**
	 * @param target
	 * @param query
	 * @param bufSize
	 * @param v
	 * @see javax.media.opengl.GL2#glGetnMapdv(int, int, int, java.nio.DoubleBuffer)
	 */
	public void glGetnMapdv(int target, int query, int bufSize, DoubleBuffer v) {
		getCurrent().glGetnMapdv(target, query, bufSize, v);
	}

	/**
	 * @param target
	 * @param query
	 * @param bufSize
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glGetnMapdv(int, int, int, double[], int)
	 */
	public void glGetnMapdv(int target, int query, int bufSize, double[] v, int v_offset) {
		getCurrent().glGetnMapdv(target, query, bufSize, v, v_offset);
	}

	/**
	 * @param target
	 * @param query
	 * @param bufSize
	 * @param v
	 * @see javax.media.opengl.GL2#glGetnMapfv(int, int, int, java.nio.FloatBuffer)
	 */
	public void glGetnMapfv(int target, int query, int bufSize, FloatBuffer v) {
		getCurrent().glGetnMapfv(target, query, bufSize, v);
	}

	/**
	 * @param target
	 * @param query
	 * @param bufSize
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glGetnMapfv(int, int, int, float[], int)
	 */
	public void glGetnMapfv(int target, int query, int bufSize, float[] v, int v_offset) {
		getCurrent().glGetnMapfv(target, query, bufSize, v, v_offset);
	}

	/**
	 * @param target
	 * @param query
	 * @param bufSize
	 * @param v
	 * @see javax.media.opengl.GL2#glGetnMapiv(int, int, int, java.nio.IntBuffer)
	 */
	public void glGetnMapiv(int target, int query, int bufSize, IntBuffer v) {
		getCurrent().glGetnMapiv(target, query, bufSize, v);
	}

	/**
	 * @param target
	 * @param query
	 * @param bufSize
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glGetnMapiv(int, int, int, int[], int)
	 */
	public void glGetnMapiv(int target, int query, int bufSize, int[] v, int v_offset) {
		getCurrent().glGetnMapiv(target, query, bufSize, v, v_offset);
	}

	/**
	 * @param target
	 * @param reset
	 * @param format
	 * @param type
	 * @param bufSize
	 * @param values
	 * @see javax.media.opengl.GL2#glGetnMinmax(int, boolean, int, int, int, java.nio.Buffer)
	 */
	public void glGetnMinmax(int target, boolean reset, int format, int type, int bufSize, Buffer values) {
		getCurrent().glGetnMinmax(target, reset, format, type, bufSize, values);
	}

	/**
	 * @param map
	 * @param bufSize
	 * @param values
	 * @see javax.media.opengl.GL2#glGetnPixelMapfv(int, int, java.nio.FloatBuffer)
	 */
	public void glGetnPixelMapfv(int map, int bufSize, FloatBuffer values) {
		getCurrent().glGetnPixelMapfv(map, bufSize, values);
	}

	/**
	 * @param map
	 * @param bufSize
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glGetnPixelMapfv(int, int, float[], int)
	 */
	public void glGetnPixelMapfv(int map, int bufSize, float[] values, int values_offset) {
		getCurrent().glGetnPixelMapfv(map, bufSize, values, values_offset);
	}

	/**
	 * @param map
	 * @param bufSize
	 * @param values
	 * @see javax.media.opengl.GL2#glGetnPixelMapuiv(int, int, java.nio.IntBuffer)
	 */
	public void glGetnPixelMapuiv(int map, int bufSize, IntBuffer values) {
		getCurrent().glGetnPixelMapuiv(map, bufSize, values);
	}

	/**
	 * @param map
	 * @param bufSize
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glGetnPixelMapuiv(int, int, int[], int)
	 */
	public void glGetnPixelMapuiv(int map, int bufSize, int[] values, int values_offset) {
		getCurrent().glGetnPixelMapuiv(map, bufSize, values, values_offset);
	}

	/**
	 * @param map
	 * @param bufSize
	 * @param values
	 * @see javax.media.opengl.GL2#glGetnPixelMapusv(int, int, java.nio.ShortBuffer)
	 */
	public void glGetnPixelMapusv(int map, int bufSize, ShortBuffer values) {
		getCurrent().glGetnPixelMapusv(map, bufSize, values);
	}

	/**
	 * @param map
	 * @param bufSize
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glGetnPixelMapusv(int, int, short[], int)
	 */
	public void glGetnPixelMapusv(int map, int bufSize, short[] values, int values_offset) {
		getCurrent().glGetnPixelMapusv(map, bufSize, values, values_offset);
	}

	/**
	 * @param bufSize
	 * @param pattern
	 * @see javax.media.opengl.GL2#glGetnPolygonStipple(int, java.nio.ByteBuffer)
	 */
	public void glGetnPolygonStipple(int bufSize, ByteBuffer pattern) {
		getCurrent().glGetnPolygonStipple(bufSize, pattern);
	}

	/**
	 * @param bufSize
	 * @param pattern
	 * @param pattern_offset
	 * @see javax.media.opengl.GL2#glGetnPolygonStipple(int, byte[], int)
	 */
	public void glGetnPolygonStipple(int bufSize, byte[] pattern, int pattern_offset) {
		getCurrent().glGetnPolygonStipple(bufSize, pattern, pattern_offset);
	}

	/**
	 * @param target
	 * @param format
	 * @param type
	 * @param rowBufSize
	 * @param row
	 * @param columnBufSize
	 * @param column
	 * @param span
	 * @see javax.media.opengl.GL2#glGetnSeparableFilter(int, int, int, int, java.nio.Buffer, int, java.nio.Buffer, java.nio.Buffer)
	 */
	public void glGetnSeparableFilter(int target, int format, int type, int rowBufSize, Buffer row, int columnBufSize, Buffer column, Buffer span) {
		getCurrent().glGetnSeparableFilter(target, format, type, rowBufSize, row, columnBufSize, column, span);
	}

	/**
	 * @param target
	 * @param mode
	 * @see javax.media.opengl.GL2#glHintPGI(int, int)
	 */
	public void glHintPGI(int target, int mode) {
		getCurrent().glHintPGI(target, mode);
	}

	/**
	 * @param target
	 * @param width
	 * @param internalformat
	 * @param sink
	 * @see javax.media.opengl.GL2#glHistogram(int, int, int, boolean)
	 */
	public void glHistogram(int target, int width, int internalformat, boolean sink) {
		getCurrent().glHistogram(target, width, internalformat, sink);
	}

	/**
	 * @param func
	 * @param ref
	 * @see javax.media.opengl.GL2#glIndexFuncEXT(int, float)
	 */
	public void glIndexFuncEXT(int func, float ref) {
		getCurrent().glIndexFuncEXT(func, ref);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL2#glIndexMask(int)
	 */
	public void glIndexMask(int mask) {
		getCurrent().glIndexMask(mask);
	}

	/**
	 * @param face
	 * @param mode
	 * @see javax.media.opengl.GL2#glIndexMaterialEXT(int, int)
	 */
	public void glIndexMaterialEXT(int face, int mode) {
		getCurrent().glIndexMaterialEXT(face, mode);
	}

	/**
	 * @param type
	 * @param stride
	 * @param ptr
	 * @see javax.media.opengl.GL2#glIndexPointer(int, int, java.nio.Buffer)
	 */
	public void glIndexPointer(int type, int stride, Buffer ptr) {
		getCurrent().glIndexPointer(type, stride, ptr);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexd(double)
	 */
	public void glIndexd(double c) {
		getCurrent().glIndexd(c);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexdv(java.nio.DoubleBuffer)
	 */
	public void glIndexdv(DoubleBuffer c) {
		getCurrent().glIndexdv(c);
	}

	/**
	 * @param c
	 * @param c_offset
	 * @see javax.media.opengl.GL2#glIndexdv(double[], int)
	 */
	public void glIndexdv(double[] c, int c_offset) {
		getCurrent().glIndexdv(c, c_offset);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexf(float)
	 */
	public void glIndexf(float c) {
		getCurrent().glIndexf(c);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexfv(java.nio.FloatBuffer)
	 */
	public void glIndexfv(FloatBuffer c) {
		getCurrent().glIndexfv(c);
	}

	/**
	 * @param c
	 * @param c_offset
	 * @see javax.media.opengl.GL2#glIndexfv(float[], int)
	 */
	public void glIndexfv(float[] c, int c_offset) {
		getCurrent().glIndexfv(c, c_offset);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexi(int)
	 */
	public void glIndexi(int c) {
		getCurrent().glIndexi(c);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexiv(java.nio.IntBuffer)
	 */
	public void glIndexiv(IntBuffer c) {
		getCurrent().glIndexiv(c);
	}

	/**
	 * @param c
	 * @param c_offset
	 * @see javax.media.opengl.GL2#glIndexiv(int[], int)
	 */
	public void glIndexiv(int[] c, int c_offset) {
		getCurrent().glIndexiv(c, c_offset);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexs(short)
	 */
	public void glIndexs(short c) {
		getCurrent().glIndexs(c);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexsv(java.nio.ShortBuffer)
	 */
	public void glIndexsv(ShortBuffer c) {
		getCurrent().glIndexsv(c);
	}

	/**
	 * @param c
	 * @param c_offset
	 * @see javax.media.opengl.GL2#glIndexsv(short[], int)
	 */
	public void glIndexsv(short[] c, int c_offset) {
		getCurrent().glIndexsv(c, c_offset);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexub(byte)
	 */
	public void glIndexub(byte c) {
		getCurrent().glIndexub(c);
	}

	/**
	 * @param c
	 * @see javax.media.opengl.GL2#glIndexubv(java.nio.ByteBuffer)
	 */
	public void glIndexubv(ByteBuffer c) {
		getCurrent().glIndexubv(c);
	}

	/**
	 * @param c
	 * @param c_offset
	 * @see javax.media.opengl.GL2#glIndexubv(byte[], int)
	 */
	public void glIndexubv(byte[] c, int c_offset) {
		getCurrent().glIndexubv(c, c_offset);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glInitNames()
	 */
	public void glInitNames() {
		getCurrent().glInitNames();
	}

	/**
	 * @param res
	 * @param src
	 * @param num
	 * @see javax.media.opengl.GL2#glInsertComponentEXT(int, int, int)
	 */
	public void glInsertComponentEXT(int res, int src, int num) {
		getCurrent().glInsertComponentEXT(res, src, num);
	}

	/**
	 * @param format
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glInterleavedArrays(int, int, java.nio.Buffer)
	 */
	public void glInterleavedArrays(int format, int stride, Buffer pointer) {
		getCurrent().glInterleavedArrays(format, stride, pointer);
	}

	/**
	 * @param format
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.GL2#glInterleavedArrays(int, int, long)
	 */
	public void glInterleavedArrays(int format, int stride, long pointer_buffer_offset) {
		getCurrent().glInterleavedArrays(format, stride, pointer_buffer_offset);
	}

	/**
	 * @param resultPath
	 * @param pathA
	 * @param pathB
	 * @param weight
	 * @see javax.media.opengl.GL2#glInterpolatePathsNV(int, int, int, float)
	 */
	public void glInterpolatePathsNV(int resultPath, int pathA, int pathB, float weight) {
		getCurrent().glInterpolatePathsNV(resultPath, pathA, pathB, weight);
	}

	/**
	 * @param target
	 * @param index
	 * @return
	 * @see javax.media.opengl.GL2#glIsEnabledIndexed(int, int)
	 */
	public boolean glIsEnabledIndexed(int target, int index) {
		return getCurrent().glIsEnabledIndexed(target, index);
	}

	/**
	 * @param fence
	 * @return
	 * @see javax.media.opengl.GL2#glIsFenceAPPLE(int)
	 */
	public boolean glIsFenceAPPLE(int fence) {
		return getCurrent().glIsFenceAPPLE(fence);
	}

	/**
	 * @param fence
	 * @return
	 * @see javax.media.opengl.GL2#glIsFenceNV(int)
	 */
	public boolean glIsFenceNV(int fence) {
		return getCurrent().glIsFenceNV(fence);
	}

	/**
	 * @param handle
	 * @return
	 * @see javax.media.opengl.GL2#glIsImageHandleResidentNV(long)
	 */
	public boolean glIsImageHandleResidentNV(long handle) {
		return getCurrent().glIsImageHandleResidentNV(handle);
	}

	/**
	 * @param list
	 * @return
	 * @see javax.media.opengl.GL2#glIsList(int)
	 */
	public boolean glIsList(int list) {
		return getCurrent().glIsList(list);
	}

	/**
	 * @param identifier
	 * @param name
	 * @return
	 * @see javax.media.opengl.GL2#glIsNameAMD(int, int)
	 */
	public boolean glIsNameAMD(int identifier, int name) {
		return getCurrent().glIsNameAMD(identifier, name);
	}

	/**
	 * @param id
	 * @return
	 * @see javax.media.opengl.GL2#glIsOcclusionQueryNV(int)
	 */
	public boolean glIsOcclusionQueryNV(int id) {
		return getCurrent().glIsOcclusionQueryNV(id);
	}

	/**
	 * @param path
	 * @return
	 * @see javax.media.opengl.GL2#glIsPathNV(int)
	 */
	public boolean glIsPathNV(int path) {
		return getCurrent().glIsPathNV(path);
	}

	/**
	 * @param path
	 * @param mask
	 * @param x
	 * @param y
	 * @return
	 * @see javax.media.opengl.GL2#glIsPointInFillPathNV(int, int, float, float)
	 */
	public boolean glIsPointInFillPathNV(int path, int mask, float x, float y) {
		return getCurrent().glIsPointInFillPathNV(path, mask, x, y);
	}

	/**
	 * @param path
	 * @param x
	 * @param y
	 * @return
	 * @see javax.media.opengl.GL2#glIsPointInStrokePathNV(int, float, float)
	 */
	public boolean glIsPointInStrokePathNV(int path, float x, float y) {
		return getCurrent().glIsPointInStrokePathNV(path, x, y);
	}

	/**
	 * @param program
	 * @return
	 * @see javax.media.opengl.GL2#glIsProgramARB(int)
	 */
	public boolean glIsProgramARB(int program) {
		return getCurrent().glIsProgramARB(program);
	}

	/**
	 * @param handle
	 * @return
	 * @see javax.media.opengl.GL2#glIsTextureHandleResidentNV(long)
	 */
	public boolean glIsTextureHandleResidentNV(long handle) {
		return getCurrent().glIsTextureHandleResidentNV(handle);
	}

	/**
	 * @param id
	 * @return
	 * @see javax.media.opengl.GL2#glIsTransformFeedbackNV(int)
	 */
	public boolean glIsTransformFeedbackNV(int id) {
		return getCurrent().glIsTransformFeedbackNV(id);
	}

	/**
	 * @param id
	 * @param cap
	 * @return
	 * @see javax.media.opengl.GL2#glIsVariantEnabledEXT(int, int)
	 */
	public boolean glIsVariantEnabledEXT(int id, int cap) {
		return getCurrent().glIsVariantEnabledEXT(id, cap);
	}

	/**
	 * @param array
	 * @return
	 * @see javax.media.opengl.GL2#glIsVertexArray(int)
	 */
	public boolean glIsVertexArray(int array) {
		return getCurrent().glIsVertexArray(array);
	}

	/**
	 * @param index
	 * @param pname
	 * @return
	 * @see javax.media.opengl.GL2#glIsVertexAttribEnabledAPPLE(int, int)
	 */
	public boolean glIsVertexAttribEnabledAPPLE(int index, int pname) {
		return getCurrent().glIsVertexAttribEnabledAPPLE(index, pname);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glLightModeli(int, int)
	 */
	public void glLightModeli(int pname, int param) {
		getCurrent().glLightModeli(pname, param);
	}

	/**
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glLightModeliv(int, java.nio.IntBuffer)
	 */
	public void glLightModeliv(int pname, IntBuffer params) {
		getCurrent().glLightModeliv(pname, params);
	}

	/**
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glLightModeliv(int, int[], int)
	 */
	public void glLightModeliv(int pname, int[] params, int params_offset) {
		getCurrent().glLightModeliv(pname, params, params_offset);
	}

	/**
	 * @param light
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glLighti(int, int, int)
	 */
	public void glLighti(int light, int pname, int param) {
		getCurrent().glLighti(light, pname, param);
	}

	/**
	 * @param light
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glLightiv(int, int, java.nio.IntBuffer)
	 */
	public void glLightiv(int light, int pname, IntBuffer params) {
		getCurrent().glLightiv(light, pname, params);
	}

	/**
	 * @param light
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glLightiv(int, int, int[], int)
	 */
	public void glLightiv(int light, int pname, int[] params, int params_offset) {
		getCurrent().glLightiv(light, pname, params, params_offset);
	}

	/**
	 * @param factor
	 * @param pattern
	 * @see javax.media.opengl.GL2#glLineStipple(int, short)
	 */
	public void glLineStipple(int factor, short pattern) {
		getCurrent().glLineStipple(factor, pattern);
	}

	/**
	 * @param programObj
	 * @see javax.media.opengl.GL2#glLinkProgramARB(int)
	 */
	public void glLinkProgramARB(int programObj) {
		getCurrent().glLinkProgramARB(programObj);
	}

	/**
	 * @param base
	 * @see javax.media.opengl.GL2#glListBase(int)
	 */
	public void glListBase(int base) {
		getCurrent().glListBase(base);
	}

	/**
	 * @param m
	 * @see javax.media.opengl.GL2#glLoadMatrixd(java.nio.DoubleBuffer)
	 */
	public void glLoadMatrixd(DoubleBuffer m) {
		getCurrent().glLoadMatrixd(m);
	}

	/**
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glLoadMatrixd(double[], int)
	 */
	public void glLoadMatrixd(double[] m, int m_offset) {
		getCurrent().glLoadMatrixd(m, m_offset);
	}

	/**
	 * @param name
	 * @see javax.media.opengl.GL2#glLoadName(int)
	 */
	public void glLoadName(int name) {
		getCurrent().glLoadName(name);
	}

	/**
	 * @param m
	 * @see javax.media.opengl.GL2#glLoadTransposeMatrixd(java.nio.DoubleBuffer)
	 */
	public void glLoadTransposeMatrixd(DoubleBuffer m) {
		getCurrent().glLoadTransposeMatrixd(m);
	}

	/**
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glLoadTransposeMatrixd(double[], int)
	 */
	public void glLoadTransposeMatrixd(double[] m, int m_offset) {
		getCurrent().glLoadTransposeMatrixd(m, m_offset);
	}

	/**
	 * @param m
	 * @see javax.media.opengl.GL2#glLoadTransposeMatrixf(java.nio.FloatBuffer)
	 */
	public void glLoadTransposeMatrixf(FloatBuffer m) {
		getCurrent().glLoadTransposeMatrixf(m);
	}

	/**
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glLoadTransposeMatrixf(float[], int)
	 */
	public void glLoadTransposeMatrixf(float[] m, int m_offset) {
		getCurrent().glLoadTransposeMatrixf(m, m_offset);
	}

	/**
	 * @param first
	 * @param count
	 * @see javax.media.opengl.GL2#glLockArraysEXT(int, int)
	 */
	public void glLockArraysEXT(int first, int count) {
		getCurrent().glLockArraysEXT(first, count);
	}

	/**
	 * @param handle
	 * @see javax.media.opengl.GL2#glMakeImageHandleNonResidentNV(long)
	 */
	public void glMakeImageHandleNonResidentNV(long handle) {
		getCurrent().glMakeImageHandleNonResidentNV(handle);
	}

	/**
	 * @param handle
	 * @param access
	 * @see javax.media.opengl.GL2#glMakeImageHandleResidentNV(long, int)
	 */
	public void glMakeImageHandleResidentNV(long handle, int access) {
		getCurrent().glMakeImageHandleResidentNV(handle, access);
	}

	/**
	 * @param handle
	 * @see javax.media.opengl.GL2#glMakeTextureHandleNonResidentNV(long)
	 */
	public void glMakeTextureHandleNonResidentNV(long handle) {
		getCurrent().glMakeTextureHandleNonResidentNV(handle);
	}

	/**
	 * @param handle
	 * @see javax.media.opengl.GL2#glMakeTextureHandleResidentNV(long)
	 */
	public void glMakeTextureHandleResidentNV(long handle) {
		getCurrent().glMakeTextureHandleResidentNV(handle);
	}

	/**
	 * @param target
	 * @param u1
	 * @param u2
	 * @param stride
	 * @param order
	 * @param points
	 * @see javax.media.opengl.GL2#glMap1d(int, double, double, int, int, java.nio.DoubleBuffer)
	 */
	public void glMap1d(int target, double u1, double u2, int stride, int order, DoubleBuffer points) {
		getCurrent().glMap1d(target, u1, u2, stride, order, points);
	}

	/**
	 * @param target
	 * @param u1
	 * @param u2
	 * @param stride
	 * @param order
	 * @param points
	 * @param points_offset
	 * @see javax.media.opengl.GL2#glMap1d(int, double, double, int, int, double[], int)
	 */
	public void glMap1d(int target, double u1, double u2, int stride, int order, double[] points, int points_offset) {
		getCurrent().glMap1d(target, u1, u2, stride, order, points, points_offset);
	}

	/**
	 * @param target
	 * @param u1
	 * @param u2
	 * @param stride
	 * @param order
	 * @param points
	 * @see javax.media.opengl.GL2#glMap1f(int, float, float, int, int, java.nio.FloatBuffer)
	 */
	public void glMap1f(int target, float u1, float u2, int stride, int order, FloatBuffer points) {
		getCurrent().glMap1f(target, u1, u2, stride, order, points);
	}

	/**
	 * @param target
	 * @param u1
	 * @param u2
	 * @param stride
	 * @param order
	 * @param points
	 * @param points_offset
	 * @see javax.media.opengl.GL2#glMap1f(int, float, float, int, int, float[], int)
	 */
	public void glMap1f(int target, float u1, float u2, int stride, int order, float[] points, int points_offset) {
		getCurrent().glMap1f(target, u1, u2, stride, order, points, points_offset);
	}

	/**
	 * @param target
	 * @param u1
	 * @param u2
	 * @param ustride
	 * @param uorder
	 * @param v1
	 * @param v2
	 * @param vstride
	 * @param vorder
	 * @param points
	 * @see javax.media.opengl.GL2#glMap2d(int, double, double, int, int, double, double, int, int, java.nio.DoubleBuffer)
	 */
	public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, DoubleBuffer points) {
		getCurrent().glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
	}

	/**
	 * @param target
	 * @param u1
	 * @param u2
	 * @param ustride
	 * @param uorder
	 * @param v1
	 * @param v2
	 * @param vstride
	 * @param vorder
	 * @param points
	 * @param points_offset
	 * @see javax.media.opengl.GL2#glMap2d(int, double, double, int, int, double, double, int, int, double[], int)
	 */
	public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, double[] points, int points_offset) {
		getCurrent().glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points_offset);
	}

	/**
	 * @param target
	 * @param u1
	 * @param u2
	 * @param ustride
	 * @param uorder
	 * @param v1
	 * @param v2
	 * @param vstride
	 * @param vorder
	 * @param points
	 * @see javax.media.opengl.GL2#glMap2f(int, float, float, int, int, float, float, int, int, java.nio.FloatBuffer)
	 */
	public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, FloatBuffer points) {
		getCurrent().glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
	}

	/**
	 * @param target
	 * @param u1
	 * @param u2
	 * @param ustride
	 * @param uorder
	 * @param v1
	 * @param v2
	 * @param vstride
	 * @param vorder
	 * @param points
	 * @param points_offset
	 * @see javax.media.opengl.GL2#glMap2f(int, float, float, int, int, float, float, int, int, float[], int)
	 */
	public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, float[] points, int points_offset) {
		getCurrent().glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param type
	 * @param ustride
	 * @param vstride
	 * @param uorder
	 * @param vorder
	 * @param packed
	 * @param points
	 * @see javax.media.opengl.GL2#glMapControlPointsNV(int, int, int, int, int, int, int, boolean, java.nio.Buffer)
	 */
	public void glMapControlPointsNV(int target, int index, int type, int ustride, int vstride, int uorder, int vorder, boolean packed, Buffer points) {
		getCurrent().glMapControlPointsNV(target, index, type, ustride, vstride, uorder, vorder, packed, points);
	}

	/**
	 * @param un
	 * @param u1
	 * @param u2
	 * @see javax.media.opengl.GL2#glMapGrid1d(int, double, double)
	 */
	public void glMapGrid1d(int un, double u1, double u2) {
		getCurrent().glMapGrid1d(un, u1, u2);
	}

	/**
	 * @param un
	 * @param u1
	 * @param u2
	 * @see javax.media.opengl.GL2#glMapGrid1f(int, float, float)
	 */
	public void glMapGrid1f(int un, float u1, float u2) {
		getCurrent().glMapGrid1f(un, u1, u2);
	}

	/**
	 * @param un
	 * @param u1
	 * @param u2
	 * @param vn
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glMapGrid2d(int, double, double, int, double, double)
	 */
	public void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2) {
		getCurrent().glMapGrid2d(un, u1, u2, vn, v1, v2);
	}

	/**
	 * @param un
	 * @param u1
	 * @param u2
	 * @param vn
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glMapGrid2f(int, float, float, int, float, float)
	 */
	public void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2) {
		getCurrent().glMapGrid2f(un, u1, u2, vn, v1, v2);
	}

	/**
	 * @param buffer
	 * @param access
	 * @return
	 * @see javax.media.opengl.GL2#glMapNamedBufferEXT(int, int)
	 */
	public ByteBuffer glMapNamedBufferEXT(int buffer, int access) {
		return getCurrent().glMapNamedBufferEXT(buffer, access);
	}

	/**
	 * @param buffer
	 * @param offset
	 * @param length
	 * @param access
	 * @return
	 * @see javax.media.opengl.GL2#glMapNamedBufferRangeEXT(int, long, long, int)
	 */
	public ByteBuffer glMapNamedBufferRangeEXT(int buffer, long offset, long length, int access) {
		return getCurrent().glMapNamedBufferRangeEXT(buffer, offset, length, access);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMapParameterfvNV(int, int, java.nio.FloatBuffer)
	 */
	public void glMapParameterfvNV(int target, int pname, FloatBuffer params) {
		getCurrent().glMapParameterfvNV(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMapParameterfvNV(int, int, float[], int)
	 */
	public void glMapParameterfvNV(int target, int pname, float[] params, int params_offset) {
		getCurrent().glMapParameterfvNV(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMapParameterivNV(int, int, java.nio.IntBuffer)
	 */
	public void glMapParameterivNV(int target, int pname, IntBuffer params) {
		getCurrent().glMapParameterivNV(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMapParameterivNV(int, int, int[], int)
	 */
	public void glMapParameterivNV(int target, int pname, int[] params, int params_offset) {
		getCurrent().glMapParameterivNV(target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param level
	 * @param access
	 * @param stride
	 * @param layout
	 * @return
	 * @see javax.media.opengl.GL2#glMapTexture2DINTEL(int, int, int, java.nio.IntBuffer, java.nio.IntBuffer)
	 */
	public ByteBuffer glMapTexture2DINTEL(int texture, int level, int access, IntBuffer stride, IntBuffer layout) {
		return getCurrent().glMapTexture2DINTEL(texture, level, access, stride, layout);
	}

	/**
	 * @param texture
	 * @param level
	 * @param access
	 * @param stride
	 * @param stride_offset
	 * @param layout
	 * @param layout_offset
	 * @return
	 * @see javax.media.opengl.GL2#glMapTexture2DINTEL(int, int, int, int[], int, int[], int)
	 */
	public ByteBuffer glMapTexture2DINTEL(int texture, int level, int access, int[] stride, int stride_offset, int[] layout, int layout_offset) {
		return getCurrent().glMapTexture2DINTEL(texture, level, access, stride, stride_offset, layout, layout_offset);
	}

	/**
	 * @param index
	 * @param size
	 * @param u1
	 * @param u2
	 * @param stride
	 * @param order
	 * @param points
	 * @see javax.media.opengl.GL2#glMapVertexAttrib1dAPPLE(int, int, double, double, int, int, java.nio.DoubleBuffer)
	 */
	public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, DoubleBuffer points) {
		getCurrent().glMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, points);
	}

	/**
	 * @param index
	 * @param size
	 * @param u1
	 * @param u2
	 * @param stride
	 * @param order
	 * @param points
	 * @param points_offset
	 * @see javax.media.opengl.GL2#glMapVertexAttrib1dAPPLE(int, int, double, double, int, int, double[], int)
	 */
	public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, double[] points, int points_offset) {
		getCurrent().glMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, points, points_offset);
	}

	/**
	 * @param index
	 * @param size
	 * @param u1
	 * @param u2
	 * @param stride
	 * @param order
	 * @param points
	 * @see javax.media.opengl.GL2#glMapVertexAttrib1fAPPLE(int, int, float, float, int, int, java.nio.FloatBuffer)
	 */
	public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, FloatBuffer points) {
		getCurrent().glMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, points);
	}

	/**
	 * @param index
	 * @param size
	 * @param u1
	 * @param u2
	 * @param stride
	 * @param order
	 * @param points
	 * @param points_offset
	 * @see javax.media.opengl.GL2#glMapVertexAttrib1fAPPLE(int, int, float, float, int, int, float[], int)
	 */
	public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, float[] points, int points_offset) {
		getCurrent().glMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, points, points_offset);
	}

	/**
	 * @param index
	 * @param size
	 * @param u1
	 * @param u2
	 * @param ustride
	 * @param uorder
	 * @param v1
	 * @param v2
	 * @param vstride
	 * @param vorder
	 * @param points
	 * @see javax.media.opengl.GL2#glMapVertexAttrib2dAPPLE(int, int, double, double, int, int, double, double, int, int, java.nio.DoubleBuffer)
	 */
	public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, DoubleBuffer points) {
		getCurrent().glMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
	}

	/**
	 * @param index
	 * @param size
	 * @param u1
	 * @param u2
	 * @param ustride
	 * @param uorder
	 * @param v1
	 * @param v2
	 * @param vstride
	 * @param vorder
	 * @param points
	 * @param points_offset
	 * @see javax.media.opengl.GL2#glMapVertexAttrib2dAPPLE(int, int, double, double, int, int, double, double, int, int, double[], int)
	 */
	public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, double[] points, int points_offset) {
		getCurrent().glMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points_offset);
	}

	/**
	 * @param index
	 * @param size
	 * @param u1
	 * @param u2
	 * @param ustride
	 * @param uorder
	 * @param v1
	 * @param v2
	 * @param vstride
	 * @param vorder
	 * @param points
	 * @see javax.media.opengl.GL2#glMapVertexAttrib2fAPPLE(int, int, float, float, int, int, float, float, int, int, java.nio.FloatBuffer)
	 */
	public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, FloatBuffer points) {
		getCurrent().glMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
	}

	/**
	 * @param index
	 * @param size
	 * @param u1
	 * @param u2
	 * @param ustride
	 * @param uorder
	 * @param v1
	 * @param v2
	 * @param vstride
	 * @param vorder
	 * @param points
	 * @param points_offset
	 * @see javax.media.opengl.GL2#glMapVertexAttrib2fAPPLE(int, int, float, float, int, int, float, float, int, int, float[], int)
	 */
	public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, float[] points, int points_offset) {
		getCurrent().glMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points_offset);
	}

	/**
	 * @param face
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glMateriali(int, int, int)
	 */
	public void glMateriali(int face, int pname, int param) {
		getCurrent().glMateriali(face, pname, param);
	}

	/**
	 * @param face
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMaterialiv(int, int, java.nio.IntBuffer)
	 */
	public void glMaterialiv(int face, int pname, IntBuffer params) {
		getCurrent().glMaterialiv(face, pname, params);
	}

	/**
	 * @param face
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMaterialiv(int, int, int[], int)
	 */
	public void glMaterialiv(int face, int pname, int[] params, int params_offset) {
		getCurrent().glMaterialiv(face, pname, params, params_offset);
	}

	/**
	 * @param mode
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.GL2#glMatrixFrustumEXT(int, double, double, double, double, double, double)
	 */
	public void glMatrixFrustumEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
		getCurrent().glMatrixFrustumEXT(mode, left, right, bottom, top, zNear, zFar);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glMatrixIndexPointer(int, int, int, java.nio.Buffer)
	 */
	public void glMatrixIndexPointer(int size, int type, int stride, Buffer pointer) {
		getCurrent().glMatrixIndexPointer(size, type, stride, pointer);
	}

	/**
	 * @param size
	 * @param indices
	 * @see javax.media.opengl.GL2#glMatrixIndexubvARB(int, java.nio.ByteBuffer)
	 */
	public void glMatrixIndexubvARB(int size, ByteBuffer indices) {
		getCurrent().glMatrixIndexubvARB(size, indices);
	}

	/**
	 * @param size
	 * @param indices
	 * @param indices_offset
	 * @see javax.media.opengl.GL2#glMatrixIndexubvARB(int, byte[], int)
	 */
	public void glMatrixIndexubvARB(int size, byte[] indices, int indices_offset) {
		getCurrent().glMatrixIndexubvARB(size, indices, indices_offset);
	}

	/**
	 * @param size
	 * @param indices
	 * @see javax.media.opengl.GL2#glMatrixIndexuivARB(int, java.nio.IntBuffer)
	 */
	public void glMatrixIndexuivARB(int size, IntBuffer indices) {
		getCurrent().glMatrixIndexuivARB(size, indices);
	}

	/**
	 * @param size
	 * @param indices
	 * @param indices_offset
	 * @see javax.media.opengl.GL2#glMatrixIndexuivARB(int, int[], int)
	 */
	public void glMatrixIndexuivARB(int size, int[] indices, int indices_offset) {
		getCurrent().glMatrixIndexuivARB(size, indices, indices_offset);
	}

	/**
	 * @param size
	 * @param indices
	 * @see javax.media.opengl.GL2#glMatrixIndexusvARB(int, java.nio.ShortBuffer)
	 */
	public void glMatrixIndexusvARB(int size, ShortBuffer indices) {
		getCurrent().glMatrixIndexusvARB(size, indices);
	}

	/**
	 * @param size
	 * @param indices
	 * @param indices_offset
	 * @see javax.media.opengl.GL2#glMatrixIndexusvARB(int, short[], int)
	 */
	public void glMatrixIndexusvARB(int size, short[] indices, int indices_offset) {
		getCurrent().glMatrixIndexusvARB(size, indices, indices_offset);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2#glMatrixLoadIdentityEXT(int)
	 */
	public void glMatrixLoadIdentityEXT(int mode) {
		getCurrent().glMatrixLoadIdentityEXT(mode);
	}

	/**
	 * @param mode
	 * @param m
	 * @see javax.media.opengl.GL2#glMatrixLoadTransposedEXT(int, java.nio.DoubleBuffer)
	 */
	public void glMatrixLoadTransposedEXT(int mode, DoubleBuffer m) {
		getCurrent().glMatrixLoadTransposedEXT(mode, m);
	}

	/**
	 * @param mode
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMatrixLoadTransposedEXT(int, double[], int)
	 */
	public void glMatrixLoadTransposedEXT(int mode, double[] m, int m_offset) {
		getCurrent().glMatrixLoadTransposedEXT(mode, m, m_offset);
	}

	/**
	 * @param mode
	 * @param m
	 * @see javax.media.opengl.GL2#glMatrixLoadTransposefEXT(int, java.nio.FloatBuffer)
	 */
	public void glMatrixLoadTransposefEXT(int mode, FloatBuffer m) {
		getCurrent().glMatrixLoadTransposefEXT(mode, m);
	}

	/**
	 * @param mode
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMatrixLoadTransposefEXT(int, float[], int)
	 */
	public void glMatrixLoadTransposefEXT(int mode, float[] m, int m_offset) {
		getCurrent().glMatrixLoadTransposefEXT(mode, m, m_offset);
	}

	/**
	 * @param mode
	 * @param m
	 * @see javax.media.opengl.GL2#glMatrixLoaddEXT(int, java.nio.DoubleBuffer)
	 */
	public void glMatrixLoaddEXT(int mode, DoubleBuffer m) {
		getCurrent().glMatrixLoaddEXT(mode, m);
	}

	/**
	 * @param mode
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMatrixLoaddEXT(int, double[], int)
	 */
	public void glMatrixLoaddEXT(int mode, double[] m, int m_offset) {
		getCurrent().glMatrixLoaddEXT(mode, m, m_offset);
	}

	/**
	 * @param mode
	 * @param m
	 * @see javax.media.opengl.GL2#glMatrixLoadfEXT(int, java.nio.FloatBuffer)
	 */
	public void glMatrixLoadfEXT(int mode, FloatBuffer m) {
		getCurrent().glMatrixLoadfEXT(mode, m);
	}

	/**
	 * @param mode
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMatrixLoadfEXT(int, float[], int)
	 */
	public void glMatrixLoadfEXT(int mode, float[] m, int m_offset) {
		getCurrent().glMatrixLoadfEXT(mode, m, m_offset);
	}

	/**
	 * @param mode
	 * @param m
	 * @see javax.media.opengl.GL2#glMatrixMultTransposedEXT(int, java.nio.DoubleBuffer)
	 */
	public void glMatrixMultTransposedEXT(int mode, DoubleBuffer m) {
		getCurrent().glMatrixMultTransposedEXT(mode, m);
	}

	/**
	 * @param mode
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMatrixMultTransposedEXT(int, double[], int)
	 */
	public void glMatrixMultTransposedEXT(int mode, double[] m, int m_offset) {
		getCurrent().glMatrixMultTransposedEXT(mode, m, m_offset);
	}

	/**
	 * @param mode
	 * @param m
	 * @see javax.media.opengl.GL2#glMatrixMultTransposefEXT(int, java.nio.FloatBuffer)
	 */
	public void glMatrixMultTransposefEXT(int mode, FloatBuffer m) {
		getCurrent().glMatrixMultTransposefEXT(mode, m);
	}

	/**
	 * @param mode
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMatrixMultTransposefEXT(int, float[], int)
	 */
	public void glMatrixMultTransposefEXT(int mode, float[] m, int m_offset) {
		getCurrent().glMatrixMultTransposefEXT(mode, m, m_offset);
	}

	/**
	 * @param mode
	 * @param m
	 * @see javax.media.opengl.GL2#glMatrixMultdEXT(int, java.nio.DoubleBuffer)
	 */
	public void glMatrixMultdEXT(int mode, DoubleBuffer m) {
		getCurrent().glMatrixMultdEXT(mode, m);
	}

	/**
	 * @param mode
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMatrixMultdEXT(int, double[], int)
	 */
	public void glMatrixMultdEXT(int mode, double[] m, int m_offset) {
		getCurrent().glMatrixMultdEXT(mode, m, m_offset);
	}

	/**
	 * @param mode
	 * @param m
	 * @see javax.media.opengl.GL2#glMatrixMultfEXT(int, java.nio.FloatBuffer)
	 */
	public void glMatrixMultfEXT(int mode, FloatBuffer m) {
		getCurrent().glMatrixMultfEXT(mode, m);
	}

	/**
	 * @param mode
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMatrixMultfEXT(int, float[], int)
	 */
	public void glMatrixMultfEXT(int mode, float[] m, int m_offset) {
		getCurrent().glMatrixMultfEXT(mode, m, m_offset);
	}

	/**
	 * @param mode
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @param zNear
	 * @param zFar
	 * @see javax.media.opengl.GL2#glMatrixOrthoEXT(int, double, double, double, double, double, double)
	 */
	public void glMatrixOrthoEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
		getCurrent().glMatrixOrthoEXT(mode, left, right, bottom, top, zNear, zFar);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2#glMatrixPopEXT(int)
	 */
	public void glMatrixPopEXT(int mode) {
		getCurrent().glMatrixPopEXT(mode);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2#glMatrixPushEXT(int)
	 */
	public void glMatrixPushEXT(int mode) {
		getCurrent().glMatrixPushEXT(mode);
	}

	/**
	 * @param mode
	 * @param angle
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glMatrixRotatedEXT(int, double, double, double, double)
	 */
	public void glMatrixRotatedEXT(int mode, double angle, double x, double y, double z) {
		getCurrent().glMatrixRotatedEXT(mode, angle, x, y, z);
	}

	/**
	 * @param mode
	 * @param angle
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glMatrixRotatefEXT(int, float, float, float, float)
	 */
	public void glMatrixRotatefEXT(int mode, float angle, float x, float y, float z) {
		getCurrent().glMatrixRotatefEXT(mode, angle, x, y, z);
	}

	/**
	 * @param mode
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glMatrixScaledEXT(int, double, double, double)
	 */
	public void glMatrixScaledEXT(int mode, double x, double y, double z) {
		getCurrent().glMatrixScaledEXT(mode, x, y, z);
	}

	/**
	 * @param mode
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glMatrixScalefEXT(int, float, float, float)
	 */
	public void glMatrixScalefEXT(int mode, float x, float y, float z) {
		getCurrent().glMatrixScalefEXT(mode, x, y, z);
	}

	/**
	 * @param mode
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glMatrixTranslatedEXT(int, double, double, double)
	 */
	public void glMatrixTranslatedEXT(int mode, double x, double y, double z) {
		getCurrent().glMatrixTranslatedEXT(mode, x, y, z);
	}

	/**
	 * @param mode
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glMatrixTranslatefEXT(int, float, float, float)
	 */
	public void glMatrixTranslatefEXT(int mode, float x, float y, float z) {
		getCurrent().glMatrixTranslatefEXT(mode, x, y, z);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param sink
	 * @see javax.media.opengl.GL2#glMinmax(int, int, boolean)
	 */
	public void glMinmax(int target, int internalformat, boolean sink) {
		getCurrent().glMinmax(target, internalformat, sink);
	}

	/**
	 * @param m
	 * @see javax.media.opengl.GL2#glMultMatrixd(java.nio.DoubleBuffer)
	 */
	public void glMultMatrixd(DoubleBuffer m) {
		getCurrent().glMultMatrixd(m);
	}

	/**
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMultMatrixd(double[], int)
	 */
	public void glMultMatrixd(double[] m, int m_offset) {
		getCurrent().glMultMatrixd(m, m_offset);
	}

	/**
	 * @param m
	 * @see javax.media.opengl.GL2#glMultTransposeMatrixd(java.nio.DoubleBuffer)
	 */
	public void glMultTransposeMatrixd(DoubleBuffer m) {
		getCurrent().glMultTransposeMatrixd(m);
	}

	/**
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMultTransposeMatrixd(double[], int)
	 */
	public void glMultTransposeMatrixd(double[] m, int m_offset) {
		getCurrent().glMultTransposeMatrixd(m, m_offset);
	}

	/**
	 * @param m
	 * @see javax.media.opengl.GL2#glMultTransposeMatrixf(java.nio.FloatBuffer)
	 */
	public void glMultTransposeMatrixf(FloatBuffer m) {
		getCurrent().glMultTransposeMatrixf(m);
	}

	/**
	 * @param m
	 * @param m_offset
	 * @see javax.media.opengl.GL2#glMultTransposeMatrixf(float[], int)
	 */
	public void glMultTransposeMatrixf(float[] m, int m_offset) {
		getCurrent().glMultTransposeMatrixf(m, m_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param internalformat
	 * @param buffer
	 * @see javax.media.opengl.GL2#glMultiTexBufferEXT(int, int, int, int)
	 */
	public void glMultiTexBufferEXT(int texunit, int target, int internalformat, int buffer) {
		getCurrent().glMultiTexBufferEXT(texunit, target, internalformat, buffer);
	}

	/**
	 * @param texture
	 * @param s
	 * @see javax.media.opengl.GL2#glMultiTexCoord1bOES(int, byte)
	 */
	public void glMultiTexCoord1bOES(int texture, byte s) {
		getCurrent().glMultiTexCoord1bOES(texture, s);
	}

	/**
	 * @param texture
	 * @param coords
	 * @see javax.media.opengl.GL2#glMultiTexCoord1bvOES(int, java.nio.ByteBuffer)
	 */
	public void glMultiTexCoord1bvOES(int texture, ByteBuffer coords) {
		getCurrent().glMultiTexCoord1bvOES(texture, coords);
	}

	/**
	 * @param texture
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord1bvOES(int, byte[], int)
	 */
	public void glMultiTexCoord1bvOES(int texture, byte[] coords, int coords_offset) {
		getCurrent().glMultiTexCoord1bvOES(texture, coords, coords_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @see javax.media.opengl.GL2#glMultiTexCoord1d(int, double)
	 */
	public void glMultiTexCoord1d(int target, double s) {
		getCurrent().glMultiTexCoord1d(target, s);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord1dv(int, java.nio.DoubleBuffer)
	 */
	public void glMultiTexCoord1dv(int target, DoubleBuffer v) {
		getCurrent().glMultiTexCoord1dv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord1dv(int, double[], int)
	 */
	public void glMultiTexCoord1dv(int target, double[] v, int v_offset) {
		getCurrent().glMultiTexCoord1dv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @see javax.media.opengl.GL2#glMultiTexCoord1f(int, float)
	 */
	public void glMultiTexCoord1f(int target, float s) {
		getCurrent().glMultiTexCoord1f(target, s);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord1fv(int, java.nio.FloatBuffer)
	 */
	public void glMultiTexCoord1fv(int target, FloatBuffer v) {
		getCurrent().glMultiTexCoord1fv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord1fv(int, float[], int)
	 */
	public void glMultiTexCoord1fv(int target, float[] v, int v_offset) {
		getCurrent().glMultiTexCoord1fv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @see javax.media.opengl.GL2#glMultiTexCoord1h(int, short)
	 */
	public void glMultiTexCoord1h(int target, short s) {
		getCurrent().glMultiTexCoord1h(target, s);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord1hv(int, java.nio.ShortBuffer)
	 */
	public void glMultiTexCoord1hv(int target, ShortBuffer v) {
		getCurrent().glMultiTexCoord1hv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord1hv(int, short[], int)
	 */
	public void glMultiTexCoord1hv(int target, short[] v, int v_offset) {
		getCurrent().glMultiTexCoord1hv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @see javax.media.opengl.GL2#glMultiTexCoord1i(int, int)
	 */
	public void glMultiTexCoord1i(int target, int s) {
		getCurrent().glMultiTexCoord1i(target, s);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord1iv(int, java.nio.IntBuffer)
	 */
	public void glMultiTexCoord1iv(int target, IntBuffer v) {
		getCurrent().glMultiTexCoord1iv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord1iv(int, int[], int)
	 */
	public void glMultiTexCoord1iv(int target, int[] v, int v_offset) {
		getCurrent().glMultiTexCoord1iv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @see javax.media.opengl.GL2#glMultiTexCoord1s(int, short)
	 */
	public void glMultiTexCoord1s(int target, short s) {
		getCurrent().glMultiTexCoord1s(target, s);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord1sv(int, java.nio.ShortBuffer)
	 */
	public void glMultiTexCoord1sv(int target, ShortBuffer v) {
		getCurrent().glMultiTexCoord1sv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord1sv(int, short[], int)
	 */
	public void glMultiTexCoord1sv(int target, short[] v, int v_offset) {
		getCurrent().glMultiTexCoord1sv(target, v, v_offset);
	}

	/**
	 * @param texture
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glMultiTexCoord2bOES(int, byte, byte)
	 */
	public void glMultiTexCoord2bOES(int texture, byte s, byte t) {
		getCurrent().glMultiTexCoord2bOES(texture, s, t);
	}

	/**
	 * @param texture
	 * @param coords
	 * @see javax.media.opengl.GL2#glMultiTexCoord2bvOES(int, java.nio.ByteBuffer)
	 */
	public void glMultiTexCoord2bvOES(int texture, ByteBuffer coords) {
		getCurrent().glMultiTexCoord2bvOES(texture, coords);
	}

	/**
	 * @param texture
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord2bvOES(int, byte[], int)
	 */
	public void glMultiTexCoord2bvOES(int texture, byte[] coords, int coords_offset) {
		getCurrent().glMultiTexCoord2bvOES(texture, coords, coords_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glMultiTexCoord2d(int, double, double)
	 */
	public void glMultiTexCoord2d(int target, double s, double t) {
		getCurrent().glMultiTexCoord2d(target, s, t);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord2dv(int, java.nio.DoubleBuffer)
	 */
	public void glMultiTexCoord2dv(int target, DoubleBuffer v) {
		getCurrent().glMultiTexCoord2dv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord2dv(int, double[], int)
	 */
	public void glMultiTexCoord2dv(int target, double[] v, int v_offset) {
		getCurrent().glMultiTexCoord2dv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glMultiTexCoord2f(int, float, float)
	 */
	public void glMultiTexCoord2f(int target, float s, float t) {
		getCurrent().glMultiTexCoord2f(target, s, t);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord2fv(int, java.nio.FloatBuffer)
	 */
	public void glMultiTexCoord2fv(int target, FloatBuffer v) {
		getCurrent().glMultiTexCoord2fv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord2fv(int, float[], int)
	 */
	public void glMultiTexCoord2fv(int target, float[] v, int v_offset) {
		getCurrent().glMultiTexCoord2fv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glMultiTexCoord2h(int, short, short)
	 */
	public void glMultiTexCoord2h(int target, short s, short t) {
		getCurrent().glMultiTexCoord2h(target, s, t);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord2hv(int, java.nio.ShortBuffer)
	 */
	public void glMultiTexCoord2hv(int target, ShortBuffer v) {
		getCurrent().glMultiTexCoord2hv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord2hv(int, short[], int)
	 */
	public void glMultiTexCoord2hv(int target, short[] v, int v_offset) {
		getCurrent().glMultiTexCoord2hv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glMultiTexCoord2i(int, int, int)
	 */
	public void glMultiTexCoord2i(int target, int s, int t) {
		getCurrent().glMultiTexCoord2i(target, s, t);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord2iv(int, java.nio.IntBuffer)
	 */
	public void glMultiTexCoord2iv(int target, IntBuffer v) {
		getCurrent().glMultiTexCoord2iv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord2iv(int, int[], int)
	 */
	public void glMultiTexCoord2iv(int target, int[] v, int v_offset) {
		getCurrent().glMultiTexCoord2iv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glMultiTexCoord2s(int, short, short)
	 */
	public void glMultiTexCoord2s(int target, short s, short t) {
		getCurrent().glMultiTexCoord2s(target, s, t);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord2sv(int, java.nio.ShortBuffer)
	 */
	public void glMultiTexCoord2sv(int target, ShortBuffer v) {
		getCurrent().glMultiTexCoord2sv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord2sv(int, short[], int)
	 */
	public void glMultiTexCoord2sv(int target, short[] v, int v_offset) {
		getCurrent().glMultiTexCoord2sv(target, v, v_offset);
	}

	/**
	 * @param texture
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glMultiTexCoord3bOES(int, byte, byte, byte)
	 */
	public void glMultiTexCoord3bOES(int texture, byte s, byte t, byte r) {
		getCurrent().glMultiTexCoord3bOES(texture, s, t, r);
	}

	/**
	 * @param texture
	 * @param coords
	 * @see javax.media.opengl.GL2#glMultiTexCoord3bvOES(int, java.nio.ByteBuffer)
	 */
	public void glMultiTexCoord3bvOES(int texture, ByteBuffer coords) {
		getCurrent().glMultiTexCoord3bvOES(texture, coords);
	}

	/**
	 * @param texture
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord3bvOES(int, byte[], int)
	 */
	public void glMultiTexCoord3bvOES(int texture, byte[] coords, int coords_offset) {
		getCurrent().glMultiTexCoord3bvOES(texture, coords, coords_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glMultiTexCoord3d(int, double, double, double)
	 */
	public void glMultiTexCoord3d(int target, double s, double t, double r) {
		getCurrent().glMultiTexCoord3d(target, s, t, r);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord3dv(int, java.nio.DoubleBuffer)
	 */
	public void glMultiTexCoord3dv(int target, DoubleBuffer v) {
		getCurrent().glMultiTexCoord3dv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord3dv(int, double[], int)
	 */
	public void glMultiTexCoord3dv(int target, double[] v, int v_offset) {
		getCurrent().glMultiTexCoord3dv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glMultiTexCoord3f(int, float, float, float)
	 */
	public void glMultiTexCoord3f(int target, float s, float t, float r) {
		getCurrent().glMultiTexCoord3f(target, s, t, r);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord3fv(int, java.nio.FloatBuffer)
	 */
	public void glMultiTexCoord3fv(int target, FloatBuffer v) {
		getCurrent().glMultiTexCoord3fv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord3fv(int, float[], int)
	 */
	public void glMultiTexCoord3fv(int target, float[] v, int v_offset) {
		getCurrent().glMultiTexCoord3fv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glMultiTexCoord3h(int, short, short, short)
	 */
	public void glMultiTexCoord3h(int target, short s, short t, short r) {
		getCurrent().glMultiTexCoord3h(target, s, t, r);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord3hv(int, java.nio.ShortBuffer)
	 */
	public void glMultiTexCoord3hv(int target, ShortBuffer v) {
		getCurrent().glMultiTexCoord3hv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord3hv(int, short[], int)
	 */
	public void glMultiTexCoord3hv(int target, short[] v, int v_offset) {
		getCurrent().glMultiTexCoord3hv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glMultiTexCoord3i(int, int, int, int)
	 */
	public void glMultiTexCoord3i(int target, int s, int t, int r) {
		getCurrent().glMultiTexCoord3i(target, s, t, r);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord3iv(int, java.nio.IntBuffer)
	 */
	public void glMultiTexCoord3iv(int target, IntBuffer v) {
		getCurrent().glMultiTexCoord3iv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord3iv(int, int[], int)
	 */
	public void glMultiTexCoord3iv(int target, int[] v, int v_offset) {
		getCurrent().glMultiTexCoord3iv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glMultiTexCoord3s(int, short, short, short)
	 */
	public void glMultiTexCoord3s(int target, short s, short t, short r) {
		getCurrent().glMultiTexCoord3s(target, s, t, r);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord3sv(int, java.nio.ShortBuffer)
	 */
	public void glMultiTexCoord3sv(int target, ShortBuffer v) {
		getCurrent().glMultiTexCoord3sv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord3sv(int, short[], int)
	 */
	public void glMultiTexCoord3sv(int target, short[] v, int v_offset) {
		getCurrent().glMultiTexCoord3sv(target, v, v_offset);
	}

	/**
	 * @param texture
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glMultiTexCoord4bOES(int, byte, byte, byte, byte)
	 */
	public void glMultiTexCoord4bOES(int texture, byte s, byte t, byte r, byte q) {
		getCurrent().glMultiTexCoord4bOES(texture, s, t, r, q);
	}

	/**
	 * @param texture
	 * @param coords
	 * @see javax.media.opengl.GL2#glMultiTexCoord4bvOES(int, java.nio.ByteBuffer)
	 */
	public void glMultiTexCoord4bvOES(int texture, ByteBuffer coords) {
		getCurrent().glMultiTexCoord4bvOES(texture, coords);
	}

	/**
	 * @param texture
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord4bvOES(int, byte[], int)
	 */
	public void glMultiTexCoord4bvOES(int texture, byte[] coords, int coords_offset) {
		getCurrent().glMultiTexCoord4bvOES(texture, coords, coords_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glMultiTexCoord4d(int, double, double, double, double)
	 */
	public void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
		getCurrent().glMultiTexCoord4d(target, s, t, r, q);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord4dv(int, java.nio.DoubleBuffer)
	 */
	public void glMultiTexCoord4dv(int target, DoubleBuffer v) {
		getCurrent().glMultiTexCoord4dv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord4dv(int, double[], int)
	 */
	public void glMultiTexCoord4dv(int target, double[] v, int v_offset) {
		getCurrent().glMultiTexCoord4dv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord4fv(int, java.nio.FloatBuffer)
	 */
	public void glMultiTexCoord4fv(int target, FloatBuffer v) {
		getCurrent().glMultiTexCoord4fv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord4fv(int, float[], int)
	 */
	public void glMultiTexCoord4fv(int target, float[] v, int v_offset) {
		getCurrent().glMultiTexCoord4fv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glMultiTexCoord4h(int, short, short, short, short)
	 */
	public void glMultiTexCoord4h(int target, short s, short t, short r, short q) {
		getCurrent().glMultiTexCoord4h(target, s, t, r, q);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord4hv(int, java.nio.ShortBuffer)
	 */
	public void glMultiTexCoord4hv(int target, ShortBuffer v) {
		getCurrent().glMultiTexCoord4hv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord4hv(int, short[], int)
	 */
	public void glMultiTexCoord4hv(int target, short[] v, int v_offset) {
		getCurrent().glMultiTexCoord4hv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glMultiTexCoord4i(int, int, int, int, int)
	 */
	public void glMultiTexCoord4i(int target, int s, int t, int r, int q) {
		getCurrent().glMultiTexCoord4i(target, s, t, r, q);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord4iv(int, java.nio.IntBuffer)
	 */
	public void glMultiTexCoord4iv(int target, IntBuffer v) {
		getCurrent().glMultiTexCoord4iv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord4iv(int, int[], int)
	 */
	public void glMultiTexCoord4iv(int target, int[] v, int v_offset) {
		getCurrent().glMultiTexCoord4iv(target, v, v_offset);
	}

	/**
	 * @param target
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glMultiTexCoord4s(int, short, short, short, short)
	 */
	public void glMultiTexCoord4s(int target, short s, short t, short r, short q) {
		getCurrent().glMultiTexCoord4s(target, s, t, r, q);
	}

	/**
	 * @param target
	 * @param v
	 * @see javax.media.opengl.GL2#glMultiTexCoord4sv(int, java.nio.ShortBuffer)
	 */
	public void glMultiTexCoord4sv(int target, ShortBuffer v) {
		getCurrent().glMultiTexCoord4sv(target, v);
	}

	/**
	 * @param target
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glMultiTexCoord4sv(int, short[], int)
	 */
	public void glMultiTexCoord4sv(int target, short[] v, int v_offset) {
		getCurrent().glMultiTexCoord4sv(target, v, v_offset);
	}

	/**
	 * @param texunit
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glMultiTexCoordPointerEXT(int, int, int, int, java.nio.Buffer)
	 */
	public void glMultiTexCoordPointerEXT(int texunit, int size, int type, int stride, Buffer pointer) {
		getCurrent().glMultiTexCoordPointerEXT(texunit, size, type, stride, pointer);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glMultiTexEnvfEXT(int, int, int, float)
	 */
	public void glMultiTexEnvfEXT(int texunit, int target, int pname, float param) {
		getCurrent().glMultiTexEnvfEXT(texunit, target, pname, param);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexEnvfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glMultiTexEnvfvEXT(int texunit, int target, int pname, FloatBuffer params) {
		getCurrent().glMultiTexEnvfvEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexEnvfvEXT(int, int, int, float[], int)
	 */
	public void glMultiTexEnvfvEXT(int texunit, int target, int pname, float[] params, int params_offset) {
		getCurrent().glMultiTexEnvfvEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glMultiTexEnviEXT(int, int, int, int)
	 */
	public void glMultiTexEnviEXT(int texunit, int target, int pname, int param) {
		getCurrent().glMultiTexEnviEXT(texunit, target, pname, param);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexEnvivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glMultiTexEnvivEXT(int texunit, int target, int pname, IntBuffer params) {
		getCurrent().glMultiTexEnvivEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexEnvivEXT(int, int, int, int[], int)
	 */
	public void glMultiTexEnvivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		getCurrent().glMultiTexEnvivEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glMultiTexGendEXT(int, int, int, double)
	 */
	public void glMultiTexGendEXT(int texunit, int coord, int pname, double param) {
		getCurrent().glMultiTexGendEXT(texunit, coord, pname, param);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexGendvEXT(int, int, int, java.nio.DoubleBuffer)
	 */
	public void glMultiTexGendvEXT(int texunit, int coord, int pname, DoubleBuffer params) {
		getCurrent().glMultiTexGendvEXT(texunit, coord, pname, params);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexGendvEXT(int, int, int, double[], int)
	 */
	public void glMultiTexGendvEXT(int texunit, int coord, int pname, double[] params, int params_offset) {
		getCurrent().glMultiTexGendvEXT(texunit, coord, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glMultiTexGenfEXT(int, int, int, float)
	 */
	public void glMultiTexGenfEXT(int texunit, int coord, int pname, float param) {
		getCurrent().glMultiTexGenfEXT(texunit, coord, pname, param);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexGenfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glMultiTexGenfvEXT(int texunit, int coord, int pname, FloatBuffer params) {
		getCurrent().glMultiTexGenfvEXT(texunit, coord, pname, params);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexGenfvEXT(int, int, int, float[], int)
	 */
	public void glMultiTexGenfvEXT(int texunit, int coord, int pname, float[] params, int params_offset) {
		getCurrent().glMultiTexGenfvEXT(texunit, coord, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glMultiTexGeniEXT(int, int, int, int)
	 */
	public void glMultiTexGeniEXT(int texunit, int coord, int pname, int param) {
		getCurrent().glMultiTexGeniEXT(texunit, coord, pname, param);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexGenivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glMultiTexGenivEXT(int texunit, int coord, int pname, IntBuffer params) {
		getCurrent().glMultiTexGenivEXT(texunit, coord, pname, params);
	}

	/**
	 * @param texunit
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexGenivEXT(int, int, int, int[], int)
	 */
	public void glMultiTexGenivEXT(int texunit, int coord, int pname, int[] params, int params_offset) {
		getCurrent().glMultiTexGenivEXT(texunit, coord, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glMultiTexImage1DEXT(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int format, int type, Buffer pixels) {
		getCurrent().glMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, pixels);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glMultiTexImage2DEXT(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int format, int type, Buffer pixels) {
		getCurrent().glMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, pixels);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glMultiTexImage3DEXT(int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Buffer pixels) {
		getCurrent().glMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexParameterIivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glMultiTexParameterIivEXT(int texunit, int target, int pname, IntBuffer params) {
		getCurrent().glMultiTexParameterIivEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexParameterIivEXT(int, int, int, int[], int)
	 */
	public void glMultiTexParameterIivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		getCurrent().glMultiTexParameterIivEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexParameterIuivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glMultiTexParameterIuivEXT(int texunit, int target, int pname, IntBuffer params) {
		getCurrent().glMultiTexParameterIuivEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexParameterIuivEXT(int, int, int, int[], int)
	 */
	public void glMultiTexParameterIuivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		getCurrent().glMultiTexParameterIuivEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glMultiTexParameterfEXT(int, int, int, float)
	 */
	public void glMultiTexParameterfEXT(int texunit, int target, int pname, float param) {
		getCurrent().glMultiTexParameterfEXT(texunit, target, pname, param);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexParameterfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glMultiTexParameterfvEXT(int texunit, int target, int pname, FloatBuffer params) {
		getCurrent().glMultiTexParameterfvEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexParameterfvEXT(int, int, int, float[], int)
	 */
	public void glMultiTexParameterfvEXT(int texunit, int target, int pname, float[] params, int params_offset) {
		getCurrent().glMultiTexParameterfvEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glMultiTexParameteriEXT(int, int, int, int)
	 */
	public void glMultiTexParameteriEXT(int texunit, int target, int pname, int param) {
		getCurrent().glMultiTexParameteriEXT(texunit, target, pname, param);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glMultiTexParameterivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glMultiTexParameterivEXT(int texunit, int target, int pname, IntBuffer params) {
		getCurrent().glMultiTexParameterivEXT(texunit, target, pname, params);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glMultiTexParameterivEXT(int, int, int, int[], int)
	 */
	public void glMultiTexParameterivEXT(int texunit, int target, int pname, int[] params, int params_offset) {
		getCurrent().glMultiTexParameterivEXT(texunit, target, pname, params, params_offset);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param renderbuffer
	 * @see javax.media.opengl.GL2#glMultiTexRenderbufferEXT(int, int, int)
	 */
	public void glMultiTexRenderbufferEXT(int texunit, int target, int renderbuffer) {
		getCurrent().glMultiTexRenderbufferEXT(texunit, target, renderbuffer);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param width
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glMultiTexSubImage1DEXT(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int type, Buffer pixels) {
		getCurrent().glMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, pixels);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glMultiTexSubImage2DEXT(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Buffer pixels) {
		getCurrent().glMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels);
	}

	/**
	 * @param texunit
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glMultiTexSubImage3DEXT(int, int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Buffer pixels) {
		getCurrent().glMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
	}

	/**
	 * @param buffer
	 * @param size
	 * @param data
	 * @param usage
	 * @see javax.media.opengl.GL2#glNamedBufferDataEXT(int, long, java.nio.Buffer, int)
	 */
	public void glNamedBufferDataEXT(int buffer, long size, Buffer data, int usage) {
		getCurrent().glNamedBufferDataEXT(buffer, size, data, usage);
	}

	/**
	 * @param buffer
	 * @param offset
	 * @param size
	 * @param data
	 * @see javax.media.opengl.GL2#glNamedBufferSubDataEXT(int, long, long, java.nio.Buffer)
	 */
	public void glNamedBufferSubDataEXT(int buffer, long offset, long size, Buffer data) {
		getCurrent().glNamedBufferSubDataEXT(buffer, offset, size, data);
	}

	/**
	 * @param readBuffer
	 * @param writeBuffer
	 * @param readOffset
	 * @param writeOffset
	 * @param size
	 * @see javax.media.opengl.GL2#glNamedCopyBufferSubDataEXT(int, int, long, long, long)
	 */
	public void glNamedCopyBufferSubDataEXT(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
		getCurrent().glNamedCopyBufferSubDataEXT(readBuffer, writeBuffer, readOffset, writeOffset, size);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param renderbuffertarget
	 * @param renderbuffer
	 * @see javax.media.opengl.GL2#glNamedFramebufferRenderbufferEXT(int, int, int, int)
	 */
	public void glNamedFramebufferRenderbufferEXT(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
		getCurrent().glNamedFramebufferRenderbufferEXT(framebuffer, attachment, renderbuffertarget, renderbuffer);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param textarget
	 * @param texture
	 * @param level
	 * @see javax.media.opengl.GL2#glNamedFramebufferTexture1DEXT(int, int, int, int, int)
	 */
	public void glNamedFramebufferTexture1DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
		getCurrent().glNamedFramebufferTexture1DEXT(framebuffer, attachment, textarget, texture, level);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param textarget
	 * @param texture
	 * @param level
	 * @see javax.media.opengl.GL2#glNamedFramebufferTexture2DEXT(int, int, int, int, int)
	 */
	public void glNamedFramebufferTexture2DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
		getCurrent().glNamedFramebufferTexture2DEXT(framebuffer, attachment, textarget, texture, level);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param textarget
	 * @param texture
	 * @param level
	 * @param zoffset
	 * @see javax.media.opengl.GL2#glNamedFramebufferTexture3DEXT(int, int, int, int, int, int)
	 */
	public void glNamedFramebufferTexture3DEXT(int framebuffer, int attachment, int textarget, int texture, int level, int zoffset) {
		getCurrent().glNamedFramebufferTexture3DEXT(framebuffer, attachment, textarget, texture, level, zoffset);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param texture
	 * @param level
	 * @see javax.media.opengl.GL2#glNamedFramebufferTextureEXT(int, int, int, int)
	 */
	public void glNamedFramebufferTextureEXT(int framebuffer, int attachment, int texture, int level) {
		getCurrent().glNamedFramebufferTextureEXT(framebuffer, attachment, texture, level);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param texture
	 * @param level
	 * @param face
	 * @see javax.media.opengl.GL2#glNamedFramebufferTextureFaceEXT(int, int, int, int, int)
	 */
	public void glNamedFramebufferTextureFaceEXT(int framebuffer, int attachment, int texture, int level, int face) {
		getCurrent().glNamedFramebufferTextureFaceEXT(framebuffer, attachment, texture, level, face);
	}

	/**
	 * @param framebuffer
	 * @param attachment
	 * @param texture
	 * @param level
	 * @param layer
	 * @see javax.media.opengl.GL2#glNamedFramebufferTextureLayerEXT(int, int, int, int, int)
	 */
	public void glNamedFramebufferTextureLayerEXT(int framebuffer, int attachment, int texture, int level, int layer) {
		getCurrent().glNamedFramebufferTextureLayerEXT(framebuffer, attachment, texture, level, layer);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameter4dEXT(int, int, int, double, double, double, double)
	 */
	public void glNamedProgramLocalParameter4dEXT(int program, int target, int index, double x, double y, double z, double w) {
		getCurrent().glNamedProgramLocalParameter4dEXT(program, target, index, x, y, z, w);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameter4dvEXT(int, int, int, java.nio.DoubleBuffer)
	 */
	public void glNamedProgramLocalParameter4dvEXT(int program, int target, int index, DoubleBuffer params) {
		getCurrent().glNamedProgramLocalParameter4dvEXT(program, target, index, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameter4dvEXT(int, int, int, double[], int)
	 */
	public void glNamedProgramLocalParameter4dvEXT(int program, int target, int index, double[] params, int params_offset) {
		getCurrent().glNamedProgramLocalParameter4dvEXT(program, target, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameter4fEXT(int, int, int, float, float, float, float)
	 */
	public void glNamedProgramLocalParameter4fEXT(int program, int target, int index, float x, float y, float z, float w) {
		getCurrent().glNamedProgramLocalParameter4fEXT(program, target, index, x, y, z, w);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameter4fvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glNamedProgramLocalParameter4fvEXT(int program, int target, int index, FloatBuffer params) {
		getCurrent().glNamedProgramLocalParameter4fvEXT(program, target, index, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameter4fvEXT(int, int, int, float[], int)
	 */
	public void glNamedProgramLocalParameter4fvEXT(int program, int target, int index, float[] params, int params_offset) {
		getCurrent().glNamedProgramLocalParameter4fvEXT(program, target, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameterI4iEXT(int, int, int, int, int, int, int)
	 */
	public void glNamedProgramLocalParameterI4iEXT(int program, int target, int index, int x, int y, int z, int w) {
		getCurrent().glNamedProgramLocalParameterI4iEXT(program, target, index, x, y, z, w);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameterI4ivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glNamedProgramLocalParameterI4ivEXT(int program, int target, int index, IntBuffer params) {
		getCurrent().glNamedProgramLocalParameterI4ivEXT(program, target, index, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameterI4ivEXT(int, int, int, int[], int)
	 */
	public void glNamedProgramLocalParameterI4ivEXT(int program, int target, int index, int[] params, int params_offset) {
		getCurrent().glNamedProgramLocalParameterI4ivEXT(program, target, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameterI4uiEXT(int, int, int, int, int, int, int)
	 */
	public void glNamedProgramLocalParameterI4uiEXT(int program, int target, int index, int x, int y, int z, int w) {
		getCurrent().glNamedProgramLocalParameterI4uiEXT(program, target, index, x, y, z, w);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameterI4uivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glNamedProgramLocalParameterI4uivEXT(int program, int target, int index, IntBuffer params) {
		getCurrent().glNamedProgramLocalParameterI4uivEXT(program, target, index, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameterI4uivEXT(int, int, int, int[], int)
	 */
	public void glNamedProgramLocalParameterI4uivEXT(int program, int target, int index, int[] params, int params_offset) {
		getCurrent().glNamedProgramLocalParameterI4uivEXT(program, target, index, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameters4fvEXT(int, int, int, int, java.nio.FloatBuffer)
	 */
	public void glNamedProgramLocalParameters4fvEXT(int program, int target, int index, int count, FloatBuffer params) {
		getCurrent().glNamedProgramLocalParameters4fvEXT(program, target, index, count, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParameters4fvEXT(int, int, int, int, float[], int)
	 */
	public void glNamedProgramLocalParameters4fvEXT(int program, int target, int index, int count, float[] params, int params_offset) {
		getCurrent().glNamedProgramLocalParameters4fvEXT(program, target, index, count, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParametersI4ivEXT(int, int, int, int, java.nio.IntBuffer)
	 */
	public void glNamedProgramLocalParametersI4ivEXT(int program, int target, int index, int count, IntBuffer params) {
		getCurrent().glNamedProgramLocalParametersI4ivEXT(program, target, index, count, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParametersI4ivEXT(int, int, int, int, int[], int)
	 */
	public void glNamedProgramLocalParametersI4ivEXT(int program, int target, int index, int count, int[] params, int params_offset) {
		getCurrent().glNamedProgramLocalParametersI4ivEXT(program, target, index, count, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParametersI4uivEXT(int, int, int, int, java.nio.IntBuffer)
	 */
	public void glNamedProgramLocalParametersI4uivEXT(int program, int target, int index, int count, IntBuffer params) {
		getCurrent().glNamedProgramLocalParametersI4uivEXT(program, target, index, count, params);
	}

	/**
	 * @param program
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glNamedProgramLocalParametersI4uivEXT(int, int, int, int, int[], int)
	 */
	public void glNamedProgramLocalParametersI4uivEXT(int program, int target, int index, int count, int[] params, int params_offset) {
		getCurrent().glNamedProgramLocalParametersI4uivEXT(program, target, index, count, params, params_offset);
	}

	/**
	 * @param program
	 * @param target
	 * @param format
	 * @param len
	 * @param string
	 * @see javax.media.opengl.GL2#glNamedProgramStringEXT(int, int, int, int, java.nio.Buffer)
	 */
	public void glNamedProgramStringEXT(int program, int target, int format, int len, Buffer string) {
		getCurrent().glNamedProgramStringEXT(program, target, format, len, string);
	}

	/**
	 * @param renderbuffer
	 * @param internalformat
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glNamedRenderbufferStorageEXT(int, int, int, int)
	 */
	public void glNamedRenderbufferStorageEXT(int renderbuffer, int internalformat, int width, int height) {
		getCurrent().glNamedRenderbufferStorageEXT(renderbuffer, internalformat, width, height);
	}

	/**
	 * @param renderbuffer
	 * @param coverageSamples
	 * @param colorSamples
	 * @param internalformat
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glNamedRenderbufferStorageMultisampleCoverageEXT(int, int, int, int, int, int)
	 */
	public void glNamedRenderbufferStorageMultisampleCoverageEXT(int renderbuffer, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
		getCurrent().glNamedRenderbufferStorageMultisampleCoverageEXT(renderbuffer, coverageSamples, colorSamples, internalformat, width, height);
	}

	/**
	 * @param renderbuffer
	 * @param samples
	 * @param internalformat
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glNamedRenderbufferStorageMultisampleEXT(int, int, int, int, int)
	 */
	public void glNamedRenderbufferStorageMultisampleEXT(int renderbuffer, int samples, int internalformat, int width, int height) {
		getCurrent().glNamedRenderbufferStorageMultisampleEXT(renderbuffer, samples, internalformat, width, height);
	}

	/**
	 * @param list
	 * @param mode
	 * @see javax.media.opengl.GL2#glNewList(int, int)
	 */
	public void glNewList(int list, int mode) {
		getCurrent().glNewList(list, mode);
	}

	/**
	 * @param nx
	 * @param ny
	 * @param nz
	 * @see javax.media.opengl.GL2#glNormal3b(byte, byte, byte)
	 */
	public void glNormal3b(byte nx, byte ny, byte nz) {
		getCurrent().glNormal3b(nx, ny, nz);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glNormal3bv(java.nio.ByteBuffer)
	 */
	public void glNormal3bv(ByteBuffer v) {
		getCurrent().glNormal3bv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glNormal3bv(byte[], int)
	 */
	public void glNormal3bv(byte[] v, int v_offset) {
		getCurrent().glNormal3bv(v, v_offset);
	}

	/**
	 * @param nx
	 * @param ny
	 * @param nz
	 * @see javax.media.opengl.GL2#glNormal3d(double, double, double)
	 */
	public void glNormal3d(double nx, double ny, double nz) {
		getCurrent().glNormal3d(nx, ny, nz);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glNormal3dv(java.nio.DoubleBuffer)
	 */
	public void glNormal3dv(DoubleBuffer v) {
		getCurrent().glNormal3dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glNormal3dv(double[], int)
	 */
	public void glNormal3dv(double[] v, int v_offset) {
		getCurrent().glNormal3dv(v, v_offset);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glNormal3fv(java.nio.FloatBuffer)
	 */
	public void glNormal3fv(FloatBuffer v) {
		getCurrent().glNormal3fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glNormal3fv(float[], int)
	 */
	public void glNormal3fv(float[] v, int v_offset) {
		getCurrent().glNormal3fv(v, v_offset);
	}

	/**
	 * @param nx
	 * @param ny
	 * @param nz
	 * @see javax.media.opengl.GL2#glNormal3h(short, short, short)
	 */
	public void glNormal3h(short nx, short ny, short nz) {
		getCurrent().glNormal3h(nx, ny, nz);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glNormal3hv(java.nio.ShortBuffer)
	 */
	public void glNormal3hv(ShortBuffer v) {
		getCurrent().glNormal3hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glNormal3hv(short[], int)
	 */
	public void glNormal3hv(short[] v, int v_offset) {
		getCurrent().glNormal3hv(v, v_offset);
	}

	/**
	 * @param nx
	 * @param ny
	 * @param nz
	 * @see javax.media.opengl.GL2#glNormal3i(int, int, int)
	 */
	public void glNormal3i(int nx, int ny, int nz) {
		getCurrent().glNormal3i(nx, ny, nz);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glNormal3iv(java.nio.IntBuffer)
	 */
	public void glNormal3iv(IntBuffer v) {
		getCurrent().glNormal3iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glNormal3iv(int[], int)
	 */
	public void glNormal3iv(int[] v, int v_offset) {
		getCurrent().glNormal3iv(v, v_offset);
	}

	/**
	 * @param nx
	 * @param ny
	 * @param nz
	 * @see javax.media.opengl.GL2#glNormal3s(short, short, short)
	 */
	public void glNormal3s(short nx, short ny, short nz) {
		getCurrent().glNormal3s(nx, ny, nz);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glNormal3sv(java.nio.ShortBuffer)
	 */
	public void glNormal3sv(ShortBuffer v) {
		getCurrent().glNormal3sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glNormal3sv(short[], int)
	 */
	public void glNormal3sv(short[] v, int v_offset) {
		getCurrent().glNormal3sv(v, v_offset);
	}

	/**
	 * @param objectType
	 * @param name
	 * @param option
	 * @return
	 * @see javax.media.opengl.GL2#glObjectPurgeableAPPLE(int, int, int)
	 */
	public int glObjectPurgeableAPPLE(int objectType, int name, int option) {
		return getCurrent().glObjectPurgeableAPPLE(objectType, name, option);
	}

	/**
	 * @param objectType
	 * @param name
	 * @param option
	 * @return
	 * @see javax.media.opengl.GL2#glObjectUnpurgeableAPPLE(int, int, int)
	 */
	public int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
		return getCurrent().glObjectUnpurgeableAPPLE(objectType, name, option);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glPNTrianglesfATI(int, float)
	 */
	public void glPNTrianglesfATI(int pname, float param) {
		getCurrent().glPNTrianglesfATI(pname, param);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glPNTrianglesiATI(int, int)
	 */
	public void glPNTrianglesiATI(int pname, int param) {
		getCurrent().glPNTrianglesiATI(pname, param);
	}

	/**
	 * @param token
	 * @see javax.media.opengl.GL2#glPassThrough(float)
	 */
	public void glPassThrough(float token) {
		getCurrent().glPassThrough(token);
	}

	/**
	 * @param color
	 * @param genMode
	 * @param colorFormat
	 * @param coeffs
	 * @see javax.media.opengl.GL2#glPathColorGenNV(int, int, int, java.nio.FloatBuffer)
	 */
	public void glPathColorGenNV(int color, int genMode, int colorFormat, FloatBuffer coeffs) {
		getCurrent().glPathColorGenNV(color, genMode, colorFormat, coeffs);
	}

	/**
	 * @param color
	 * @param genMode
	 * @param colorFormat
	 * @param coeffs
	 * @param coeffs_offset
	 * @see javax.media.opengl.GL2#glPathColorGenNV(int, int, int, float[], int)
	 */
	public void glPathColorGenNV(int color, int genMode, int colorFormat, float[] coeffs, int coeffs_offset) {
		getCurrent().glPathColorGenNV(color, genMode, colorFormat, coeffs, coeffs_offset);
	}

	/**
	 * @param path
	 * @param numCommands
	 * @param commands
	 * @param numCoords
	 * @param coordType
	 * @param coords
	 * @see javax.media.opengl.GL2#glPathCommandsNV(int, int, java.nio.ByteBuffer, int, int, java.nio.Buffer)
	 */
	public void glPathCommandsNV(int path, int numCommands, ByteBuffer commands, int numCoords, int coordType, Buffer coords) {
		getCurrent().glPathCommandsNV(path, numCommands, commands, numCoords, coordType, coords);
	}

	/**
	 * @param path
	 * @param numCommands
	 * @param commands
	 * @param commands_offset
	 * @param numCoords
	 * @param coordType
	 * @param coords
	 * @see javax.media.opengl.GL2#glPathCommandsNV(int, int, byte[], int, int, int, java.nio.Buffer)
	 */
	public void glPathCommandsNV(int path, int numCommands, byte[] commands, int commands_offset, int numCoords, int coordType, Buffer coords) {
		getCurrent().glPathCommandsNV(path, numCommands, commands, commands_offset, numCoords, coordType, coords);
	}

	/**
	 * @param path
	 * @param numCoords
	 * @param coordType
	 * @param coords
	 * @see javax.media.opengl.GL2#glPathCoordsNV(int, int, int, java.nio.Buffer)
	 */
	public void glPathCoordsNV(int path, int numCoords, int coordType, Buffer coords) {
		getCurrent().glPathCoordsNV(path, numCoords, coordType, coords);
	}

	/**
	 * @param func
	 * @see javax.media.opengl.GL2#glPathCoverDepthFuncNV(int)
	 */
	public void glPathCoverDepthFuncNV(int func) {
		getCurrent().glPathCoverDepthFuncNV(func);
	}

	/**
	 * @param path
	 * @param dashCount
	 * @param dashArray
	 * @see javax.media.opengl.GL2#glPathDashArrayNV(int, int, java.nio.FloatBuffer)
	 */
	public void glPathDashArrayNV(int path, int dashCount, FloatBuffer dashArray) {
		getCurrent().glPathDashArrayNV(path, dashCount, dashArray);
	}

	/**
	 * @param path
	 * @param dashCount
	 * @param dashArray
	 * @param dashArray_offset
	 * @see javax.media.opengl.GL2#glPathDashArrayNV(int, int, float[], int)
	 */
	public void glPathDashArrayNV(int path, int dashCount, float[] dashArray, int dashArray_offset) {
		getCurrent().glPathDashArrayNV(path, dashCount, dashArray, dashArray_offset);
	}

	/**
	 * @param genMode
	 * @see javax.media.opengl.GL2#glPathFogGenNV(int)
	 */
	public void glPathFogGenNV(int genMode) {
		getCurrent().glPathFogGenNV(genMode);
	}

	/**
	 * @param firstPathName
	 * @param fontTarget
	 * @param fontName
	 * @param fontStyle
	 * @param firstGlyph
	 * @param numGlyphs
	 * @param handleMissingGlyphs
	 * @param pathParameterTemplate
	 * @param emScale
	 * @see javax.media.opengl.GL2#glPathGlyphRangeNV(int, int, java.nio.Buffer, int, int, int, int, int, float)
	 */
	public void glPathGlyphRangeNV(int firstPathName, int fontTarget, Buffer fontName, int fontStyle, int firstGlyph, int numGlyphs, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
		getCurrent().glPathGlyphRangeNV(firstPathName, fontTarget, fontName, fontStyle, firstGlyph, numGlyphs, handleMissingGlyphs, pathParameterTemplate, emScale);
	}

	/**
	 * @param firstPathName
	 * @param fontTarget
	 * @param fontName
	 * @param fontStyle
	 * @param numGlyphs
	 * @param type
	 * @param charcodes
	 * @param handleMissingGlyphs
	 * @param pathParameterTemplate
	 * @param emScale
	 * @see javax.media.opengl.GL2#glPathGlyphsNV(int, int, java.nio.Buffer, int, int, int, java.nio.Buffer, int, int, float)
	 */
	public void glPathGlyphsNV(int firstPathName, int fontTarget, Buffer fontName, int fontStyle, int numGlyphs, int type, Buffer charcodes, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
		getCurrent().glPathGlyphsNV(firstPathName, fontTarget, fontName, fontStyle, numGlyphs, type, charcodes, handleMissingGlyphs, pathParameterTemplate, emScale);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glPathParameterfNV(int, int, float)
	 */
	public void glPathParameterfNV(int path, int pname, float value) {
		getCurrent().glPathParameterfNV(path, pname, value);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glPathParameterfvNV(int, int, java.nio.FloatBuffer)
	 */
	public void glPathParameterfvNV(int path, int pname, FloatBuffer value) {
		getCurrent().glPathParameterfvNV(path, pname, value);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glPathParameterfvNV(int, int, float[], int)
	 */
	public void glPathParameterfvNV(int path, int pname, float[] value, int value_offset) {
		getCurrent().glPathParameterfvNV(path, pname, value, value_offset);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glPathParameteriNV(int, int, int)
	 */
	public void glPathParameteriNV(int path, int pname, int value) {
		getCurrent().glPathParameteriNV(path, pname, value);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @see javax.media.opengl.GL2#glPathParameterivNV(int, int, java.nio.IntBuffer)
	 */
	public void glPathParameterivNV(int path, int pname, IntBuffer value) {
		getCurrent().glPathParameterivNV(path, pname, value);
	}

	/**
	 * @param path
	 * @param pname
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glPathParameterivNV(int, int, int[], int)
	 */
	public void glPathParameterivNV(int path, int pname, int[] value, int value_offset) {
		getCurrent().glPathParameterivNV(path, pname, value, value_offset);
	}

	/**
	 * @param factor
	 * @param units
	 * @see javax.media.opengl.GL2#glPathStencilDepthOffsetNV(float, float)
	 */
	public void glPathStencilDepthOffsetNV(float factor, float units) {
		getCurrent().glPathStencilDepthOffsetNV(factor, units);
	}

	/**
	 * @param func
	 * @param ref
	 * @param mask
	 * @see javax.media.opengl.GL2#glPathStencilFuncNV(int, int, int)
	 */
	public void glPathStencilFuncNV(int func, int ref, int mask) {
		getCurrent().glPathStencilFuncNV(func, ref, mask);
	}

	/**
	 * @param path
	 * @param format
	 * @param length
	 * @param pathString
	 * @see javax.media.opengl.GL2#glPathStringNV(int, int, int, java.nio.Buffer)
	 */
	public void glPathStringNV(int path, int format, int length, Buffer pathString) {
		getCurrent().glPathStringNV(path, format, length, pathString);
	}

	/**
	 * @param path
	 * @param commandStart
	 * @param commandsToDelete
	 * @param numCommands
	 * @param commands
	 * @param numCoords
	 * @param coordType
	 * @param coords
	 * @see javax.media.opengl.GL2#glPathSubCommandsNV(int, int, int, int, java.nio.ByteBuffer, int, int, java.nio.Buffer)
	 */
	public void glPathSubCommandsNV(int path, int commandStart, int commandsToDelete, int numCommands, ByteBuffer commands, int numCoords, int coordType, Buffer coords) {
		getCurrent().glPathSubCommandsNV(path, commandStart, commandsToDelete, numCommands, commands, numCoords, coordType, coords);
	}

	/**
	 * @param path
	 * @param commandStart
	 * @param commandsToDelete
	 * @param numCommands
	 * @param commands
	 * @param commands_offset
	 * @param numCoords
	 * @param coordType
	 * @param coords
	 * @see javax.media.opengl.GL2#glPathSubCommandsNV(int, int, int, int, byte[], int, int, int, java.nio.Buffer)
	 */
	public void glPathSubCommandsNV(int path, int commandStart, int commandsToDelete, int numCommands, byte[] commands, int commands_offset, int numCoords, int coordType, Buffer coords) {
		getCurrent().glPathSubCommandsNV(path, commandStart, commandsToDelete, numCommands, commands, commands_offset, numCoords, coordType, coords);
	}

	/**
	 * @param path
	 * @param coordStart
	 * @param numCoords
	 * @param coordType
	 * @param coords
	 * @see javax.media.opengl.GL2#glPathSubCoordsNV(int, int, int, int, java.nio.Buffer)
	 */
	public void glPathSubCoordsNV(int path, int coordStart, int numCoords, int coordType, Buffer coords) {
		getCurrent().glPathSubCoordsNV(path, coordStart, numCoords, coordType, coords);
	}

	/**
	 * @param texCoordSet
	 * @param genMode
	 * @param components
	 * @param coeffs
	 * @see javax.media.opengl.GL2#glPathTexGenNV(int, int, int, java.nio.FloatBuffer)
	 */
	public void glPathTexGenNV(int texCoordSet, int genMode, int components, FloatBuffer coeffs) {
		getCurrent().glPathTexGenNV(texCoordSet, genMode, components, coeffs);
	}

	/**
	 * @param texCoordSet
	 * @param genMode
	 * @param components
	 * @param coeffs
	 * @param coeffs_offset
	 * @see javax.media.opengl.GL2#glPathTexGenNV(int, int, int, float[], int)
	 */
	public void glPathTexGenNV(int texCoordSet, int genMode, int components, float[] coeffs, int coeffs_offset) {
		getCurrent().glPathTexGenNV(texCoordSet, genMode, components, coeffs, coeffs_offset);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glPauseTransformFeedbackNV()
	 */
	public void glPauseTransformFeedbackNV() {
		getCurrent().glPauseTransformFeedbackNV();
	}

	/**
	 * @param target
	 * @param length
	 * @param pointer
	 * @see javax.media.opengl.GL2#glPixelDataRangeNV(int, int, java.nio.Buffer)
	 */
	public void glPixelDataRangeNV(int target, int length, Buffer pointer) {
		getCurrent().glPixelDataRangeNV(target, length, pointer);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values
	 * @see javax.media.opengl.GL2#glPixelMapfv(int, int, java.nio.FloatBuffer)
	 */
	public void glPixelMapfv(int map, int mapsize, FloatBuffer values) {
		getCurrent().glPixelMapfv(map, mapsize, values);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glPixelMapfv(int, int, float[], int)
	 */
	public void glPixelMapfv(int map, int mapsize, float[] values, int values_offset) {
		getCurrent().glPixelMapfv(map, mapsize, values, values_offset);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values_buffer_offset
	 * @see javax.media.opengl.GL2#glPixelMapfv(int, int, long)
	 */
	public void glPixelMapfv(int map, int mapsize, long values_buffer_offset) {
		getCurrent().glPixelMapfv(map, mapsize, values_buffer_offset);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values
	 * @see javax.media.opengl.GL2#glPixelMapuiv(int, int, java.nio.IntBuffer)
	 */
	public void glPixelMapuiv(int map, int mapsize, IntBuffer values) {
		getCurrent().glPixelMapuiv(map, mapsize, values);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glPixelMapuiv(int, int, int[], int)
	 */
	public void glPixelMapuiv(int map, int mapsize, int[] values, int values_offset) {
		getCurrent().glPixelMapuiv(map, mapsize, values, values_offset);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values_buffer_offset
	 * @see javax.media.opengl.GL2#glPixelMapuiv(int, int, long)
	 */
	public void glPixelMapuiv(int map, int mapsize, long values_buffer_offset) {
		getCurrent().glPixelMapuiv(map, mapsize, values_buffer_offset);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values
	 * @see javax.media.opengl.GL2#glPixelMapusv(int, int, java.nio.ShortBuffer)
	 */
	public void glPixelMapusv(int map, int mapsize, ShortBuffer values) {
		getCurrent().glPixelMapusv(map, mapsize, values);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glPixelMapusv(int, int, short[], int)
	 */
	public void glPixelMapusv(int map, int mapsize, short[] values, int values_offset) {
		getCurrent().glPixelMapusv(map, mapsize, values, values_offset);
	}

	/**
	 * @param map
	 * @param mapsize
	 * @param values_buffer_offset
	 * @see javax.media.opengl.GL2#glPixelMapusv(int, int, long)
	 */
	public void glPixelMapusv(int map, int mapsize, long values_buffer_offset) {
		getCurrent().glPixelMapusv(map, mapsize, values_buffer_offset);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glPixelTransferf(int, float)
	 */
	public void glPixelTransferf(int pname, float param) {
		getCurrent().glPixelTransferf(pname, param);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glPixelTransferi(int, int)
	 */
	public void glPixelTransferi(int pname, int param) {
		getCurrent().glPixelTransferi(pname, param);
	}

	/**
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glPixelTransformParameterfEXT(int, int, float)
	 */
	public void glPixelTransformParameterfEXT(int target, int pname, float param) {
		getCurrent().glPixelTransformParameterfEXT(target, pname, param);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glPixelTransformParameterfvEXT(int, int, java.nio.FloatBuffer)
	 */
	public void glPixelTransformParameterfvEXT(int target, int pname, FloatBuffer params) {
		getCurrent().glPixelTransformParameterfvEXT(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glPixelTransformParameterfvEXT(int, int, float[], int)
	 */
	public void glPixelTransformParameterfvEXT(int target, int pname, float[] params, int params_offset) {
		getCurrent().glPixelTransformParameterfvEXT(target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glPixelTransformParameteriEXT(int, int, int)
	 */
	public void glPixelTransformParameteriEXT(int target, int pname, int param) {
		getCurrent().glPixelTransformParameteriEXT(target, pname, param);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glPixelTransformParameterivEXT(int, int, java.nio.IntBuffer)
	 */
	public void glPixelTransformParameterivEXT(int target, int pname, IntBuffer params) {
		getCurrent().glPixelTransformParameterivEXT(target, pname, params);
	}

	/**
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glPixelTransformParameterivEXT(int, int, int[], int)
	 */
	public void glPixelTransformParameterivEXT(int target, int pname, int[] params, int params_offset) {
		getCurrent().glPixelTransformParameterivEXT(target, pname, params, params_offset);
	}

	/**
	 * @param xfactor
	 * @param yfactor
	 * @see javax.media.opengl.GL2#glPixelZoom(float, float)
	 */
	public void glPixelZoom(float xfactor, float yfactor) {
		getCurrent().glPixelZoom(xfactor, yfactor);
	}

	/**
	 * @param path
	 * @param startSegment
	 * @param numSegments
	 * @param distance
	 * @param x
	 * @param y
	 * @param tangentX
	 * @param tangentY
	 * @return
	 * @see javax.media.opengl.GL2#glPointAlongPathNV(int, int, int, float, java.nio.FloatBuffer, java.nio.FloatBuffer, java.nio.FloatBuffer, java.nio.FloatBuffer)
	 */
	public boolean glPointAlongPathNV(int path, int startSegment, int numSegments, float distance, FloatBuffer x, FloatBuffer y, FloatBuffer tangentX, FloatBuffer tangentY) {
		return getCurrent().glPointAlongPathNV(path, startSegment, numSegments, distance, x, y, tangentX, tangentY);
	}

	/**
	 * @param path
	 * @param startSegment
	 * @param numSegments
	 * @param distance
	 * @param x
	 * @param x_offset
	 * @param y
	 * @param y_offset
	 * @param tangentX
	 * @param tangentX_offset
	 * @param tangentY
	 * @param tangentY_offset
	 * @return
	 * @see javax.media.opengl.GL2#glPointAlongPathNV(int, int, int, float, float[], int, float[], int, float[], int, float[], int)
	 */
	public boolean glPointAlongPathNV(int path, int startSegment, int numSegments, float distance, float[] x, int x_offset, float[] y, int y_offset, float[] tangentX, int tangentX_offset, float[] tangentY, int tangentY_offset) {
		return getCurrent().glPointAlongPathNV(path, startSegment, numSegments, distance, x, x_offset, y, y_offset, tangentX, tangentX_offset, tangentY, tangentY_offset);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL2#glPolygonStipple(java.nio.ByteBuffer)
	 */
	public void glPolygonStipple(ByteBuffer mask) {
		getCurrent().glPolygonStipple(mask);
	}

	/**
	 * @param mask
	 * @param mask_offset
	 * @see javax.media.opengl.GL2#glPolygonStipple(byte[], int)
	 */
	public void glPolygonStipple(byte[] mask, int mask_offset) {
		getCurrent().glPolygonStipple(mask, mask_offset);
	}

	/**
	 * @param mask_buffer_offset
	 * @see javax.media.opengl.GL2#glPolygonStipple(long)
	 */
	public void glPolygonStipple(long mask_buffer_offset) {
		getCurrent().glPolygonStipple(mask_buffer_offset);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glPopAttrib()
	 */
	public void glPopAttrib() {
		getCurrent().glPopAttrib();
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glPopClientAttrib()
	 */
	public void glPopClientAttrib() {
		getCurrent().glPopClientAttrib();
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glPopName()
	 */
	public void glPopName() {
		getCurrent().glPopName();
	}

	/**
	 * @param index
	 * @see javax.media.opengl.GL2#glPrimitiveRestartIndexNV(int)
	 */
	public void glPrimitiveRestartIndexNV(int index) {
		getCurrent().glPrimitiveRestartIndexNV(index);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glPrimitiveRestartNV()
	 */
	public void glPrimitiveRestartNV() {
		getCurrent().glPrimitiveRestartNV();
	}

	/**
	 * @param n
	 * @param textures
	 * @param priorities
	 * @see javax.media.opengl.GL2#glPrioritizeTextures(int, java.nio.IntBuffer, java.nio.FloatBuffer)
	 */
	public void glPrioritizeTextures(int n, IntBuffer textures, FloatBuffer priorities) {
		getCurrent().glPrioritizeTextures(n, textures, priorities);
	}

	/**
	 * @param n
	 * @param textures
	 * @param textures_offset
	 * @param priorities
	 * @param priorities_offset
	 * @see javax.media.opengl.GL2#glPrioritizeTextures(int, int[], int, float[], int)
	 */
	public void glPrioritizeTextures(int n, int[] textures, int textures_offset, float[] priorities, int priorities_offset) {
		getCurrent().glPrioritizeTextures(n, textures, textures_offset, priorities, priorities_offset);
	}

	/**
	 * @param target
	 * @param bindingIndex
	 * @param wordIndex
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramBufferParametersIivNV(int, int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramBufferParametersIivNV(int target, int bindingIndex, int wordIndex, int count, IntBuffer params) {
		getCurrent().glProgramBufferParametersIivNV(target, bindingIndex, wordIndex, count, params);
	}

	/**
	 * @param target
	 * @param bindingIndex
	 * @param wordIndex
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramBufferParametersIivNV(int, int, int, int, int[], int)
	 */
	public void glProgramBufferParametersIivNV(int target, int bindingIndex, int wordIndex, int count, int[] params, int params_offset) {
		getCurrent().glProgramBufferParametersIivNV(target, bindingIndex, wordIndex, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param bindingIndex
	 * @param wordIndex
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramBufferParametersIuivNV(int, int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramBufferParametersIuivNV(int target, int bindingIndex, int wordIndex, int count, IntBuffer params) {
		getCurrent().glProgramBufferParametersIuivNV(target, bindingIndex, wordIndex, count, params);
	}

	/**
	 * @param target
	 * @param bindingIndex
	 * @param wordIndex
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramBufferParametersIuivNV(int, int, int, int, int[], int)
	 */
	public void glProgramBufferParametersIuivNV(int target, int bindingIndex, int wordIndex, int count, int[] params, int params_offset) {
		getCurrent().glProgramBufferParametersIuivNV(target, bindingIndex, wordIndex, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param bindingIndex
	 * @param wordIndex
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramBufferParametersfvNV(int, int, int, int, java.nio.FloatBuffer)
	 */
	public void glProgramBufferParametersfvNV(int target, int bindingIndex, int wordIndex, int count, FloatBuffer params) {
		getCurrent().glProgramBufferParametersfvNV(target, bindingIndex, wordIndex, count, params);
	}

	/**
	 * @param target
	 * @param bindingIndex
	 * @param wordIndex
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramBufferParametersfvNV(int, int, int, int, float[], int)
	 */
	public void glProgramBufferParametersfvNV(int target, int bindingIndex, int wordIndex, int count, float[] params, int params_offset) {
		getCurrent().glProgramBufferParametersfvNV(target, bindingIndex, wordIndex, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glProgramEnvParameter4dARB(int, int, double, double, double, double)
	 */
	public void glProgramEnvParameter4dARB(int target, int index, double x, double y, double z, double w) {
		getCurrent().glProgramEnvParameter4dARB(target, index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramEnvParameter4dvARB(int, int, java.nio.DoubleBuffer)
	 */
	public void glProgramEnvParameter4dvARB(int target, int index, DoubleBuffer params) {
		getCurrent().glProgramEnvParameter4dvARB(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramEnvParameter4dvARB(int, int, double[], int)
	 */
	public void glProgramEnvParameter4dvARB(int target, int index, double[] params, int params_offset) {
		getCurrent().glProgramEnvParameter4dvARB(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glProgramEnvParameter4fARB(int, int, float, float, float, float)
	 */
	public void glProgramEnvParameter4fARB(int target, int index, float x, float y, float z, float w) {
		getCurrent().glProgramEnvParameter4fARB(target, index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramEnvParameter4fvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glProgramEnvParameter4fvARB(int target, int index, FloatBuffer params) {
		getCurrent().glProgramEnvParameter4fvARB(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramEnvParameter4fvARB(int, int, float[], int)
	 */
	public void glProgramEnvParameter4fvARB(int target, int index, float[] params, int params_offset) {
		getCurrent().glProgramEnvParameter4fvARB(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glProgramEnvParameterI4iNV(int, int, int, int, int, int)
	 */
	public void glProgramEnvParameterI4iNV(int target, int index, int x, int y, int z, int w) {
		getCurrent().glProgramEnvParameterI4iNV(target, index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramEnvParameterI4ivNV(int, int, java.nio.IntBuffer)
	 */
	public void glProgramEnvParameterI4ivNV(int target, int index, IntBuffer params) {
		getCurrent().glProgramEnvParameterI4ivNV(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramEnvParameterI4ivNV(int, int, int[], int)
	 */
	public void glProgramEnvParameterI4ivNV(int target, int index, int[] params, int params_offset) {
		getCurrent().glProgramEnvParameterI4ivNV(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glProgramEnvParameterI4uiNV(int, int, int, int, int, int)
	 */
	public void glProgramEnvParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
		getCurrent().glProgramEnvParameterI4uiNV(target, index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramEnvParameterI4uivNV(int, int, java.nio.IntBuffer)
	 */
	public void glProgramEnvParameterI4uivNV(int target, int index, IntBuffer params) {
		getCurrent().glProgramEnvParameterI4uivNV(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramEnvParameterI4uivNV(int, int, int[], int)
	 */
	public void glProgramEnvParameterI4uivNV(int target, int index, int[] params, int params_offset) {
		getCurrent().glProgramEnvParameterI4uivNV(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramEnvParameters4fvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glProgramEnvParameters4fvEXT(int target, int index, int count, FloatBuffer params) {
		getCurrent().glProgramEnvParameters4fvEXT(target, index, count, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramEnvParameters4fvEXT(int, int, int, float[], int)
	 */
	public void glProgramEnvParameters4fvEXT(int target, int index, int count, float[] params, int params_offset) {
		getCurrent().glProgramEnvParameters4fvEXT(target, index, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramEnvParametersI4ivNV(int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramEnvParametersI4ivNV(int target, int index, int count, IntBuffer params) {
		getCurrent().glProgramEnvParametersI4ivNV(target, index, count, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramEnvParametersI4ivNV(int, int, int, int[], int)
	 */
	public void glProgramEnvParametersI4ivNV(int target, int index, int count, int[] params, int params_offset) {
		getCurrent().glProgramEnvParametersI4ivNV(target, index, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramEnvParametersI4uivNV(int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramEnvParametersI4uivNV(int target, int index, int count, IntBuffer params) {
		getCurrent().glProgramEnvParametersI4uivNV(target, index, count, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramEnvParametersI4uivNV(int, int, int, int[], int)
	 */
	public void glProgramEnvParametersI4uivNV(int target, int index, int count, int[] params, int params_offset) {
		getCurrent().glProgramEnvParametersI4uivNV(target, index, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glProgramLocalParameter4dARB(int, int, double, double, double, double)
	 */
	public void glProgramLocalParameter4dARB(int target, int index, double x, double y, double z, double w) {
		getCurrent().glProgramLocalParameter4dARB(target, index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramLocalParameter4dvARB(int, int, java.nio.DoubleBuffer)
	 */
	public void glProgramLocalParameter4dvARB(int target, int index, DoubleBuffer params) {
		getCurrent().glProgramLocalParameter4dvARB(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramLocalParameter4dvARB(int, int, double[], int)
	 */
	public void glProgramLocalParameter4dvARB(int target, int index, double[] params, int params_offset) {
		getCurrent().glProgramLocalParameter4dvARB(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glProgramLocalParameter4fARB(int, int, float, float, float, float)
	 */
	public void glProgramLocalParameter4fARB(int target, int index, float x, float y, float z, float w) {
		getCurrent().glProgramLocalParameter4fARB(target, index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramLocalParameter4fvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glProgramLocalParameter4fvARB(int target, int index, FloatBuffer params) {
		getCurrent().glProgramLocalParameter4fvARB(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramLocalParameter4fvARB(int, int, float[], int)
	 */
	public void glProgramLocalParameter4fvARB(int target, int index, float[] params, int params_offset) {
		getCurrent().glProgramLocalParameter4fvARB(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glProgramLocalParameterI4iNV(int, int, int, int, int, int)
	 */
	public void glProgramLocalParameterI4iNV(int target, int index, int x, int y, int z, int w) {
		getCurrent().glProgramLocalParameterI4iNV(target, index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramLocalParameterI4ivNV(int, int, java.nio.IntBuffer)
	 */
	public void glProgramLocalParameterI4ivNV(int target, int index, IntBuffer params) {
		getCurrent().glProgramLocalParameterI4ivNV(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramLocalParameterI4ivNV(int, int, int[], int)
	 */
	public void glProgramLocalParameterI4ivNV(int target, int index, int[] params, int params_offset) {
		getCurrent().glProgramLocalParameterI4ivNV(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glProgramLocalParameterI4uiNV(int, int, int, int, int, int)
	 */
	public void glProgramLocalParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
		getCurrent().glProgramLocalParameterI4uiNV(target, index, x, y, z, w);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramLocalParameterI4uivNV(int, int, java.nio.IntBuffer)
	 */
	public void glProgramLocalParameterI4uivNV(int target, int index, IntBuffer params) {
		getCurrent().glProgramLocalParameterI4uivNV(target, index, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramLocalParameterI4uivNV(int, int, int[], int)
	 */
	public void glProgramLocalParameterI4uivNV(int target, int index, int[] params, int params_offset) {
		getCurrent().glProgramLocalParameterI4uivNV(target, index, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramLocalParameters4fvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glProgramLocalParameters4fvEXT(int target, int index, int count, FloatBuffer params) {
		getCurrent().glProgramLocalParameters4fvEXT(target, index, count, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramLocalParameters4fvEXT(int, int, int, float[], int)
	 */
	public void glProgramLocalParameters4fvEXT(int target, int index, int count, float[] params, int params_offset) {
		getCurrent().glProgramLocalParameters4fvEXT(target, index, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramLocalParametersI4ivNV(int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramLocalParametersI4ivNV(int target, int index, int count, IntBuffer params) {
		getCurrent().glProgramLocalParametersI4ivNV(target, index, count, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramLocalParametersI4ivNV(int, int, int, int[], int)
	 */
	public void glProgramLocalParametersI4ivNV(int target, int index, int count, int[] params, int params_offset) {
		getCurrent().glProgramLocalParametersI4ivNV(target, index, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramLocalParametersI4uivNV(int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramLocalParametersI4uivNV(int target, int index, int count, IntBuffer params) {
		getCurrent().glProgramLocalParametersI4uivNV(target, index, count, params);
	}

	/**
	 * @param target
	 * @param index
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramLocalParametersI4uivNV(int, int, int, int[], int)
	 */
	public void glProgramLocalParametersI4uivNV(int target, int index, int count, int[] params, int params_offset) {
		getCurrent().glProgramLocalParametersI4uivNV(target, index, count, params, params_offset);
	}

	/**
	 * @param target
	 * @param format
	 * @param len
	 * @param string
	 * @see javax.media.opengl.GL2#glProgramStringARB(int, int, int, java.lang.String)
	 */
	public void glProgramStringARB(int target, int format, int len, String string) {
		getCurrent().glProgramStringARB(target, format, len, string);
	}

	/**
	 * @param target
	 * @param count
	 * @param params
	 * @see javax.media.opengl.GL2#glProgramSubroutineParametersuivNV(int, int, java.nio.IntBuffer)
	 */
	public void glProgramSubroutineParametersuivNV(int target, int count, IntBuffer params) {
		getCurrent().glProgramSubroutineParametersuivNV(target, count, params);
	}

	/**
	 * @param target
	 * @param count
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glProgramSubroutineParametersuivNV(int, int, int[], int)
	 */
	public void glProgramSubroutineParametersuivNV(int target, int count, int[] params, int params_offset) {
		getCurrent().glProgramSubroutineParametersuivNV(target, count, params, params_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param v0
	 * @see javax.media.opengl.GL2#glProgramUniform1uiEXT(int, int, int)
	 */
	public void glProgramUniform1uiEXT(int program, int location, int v0) {
		getCurrent().glProgramUniform1uiEXT(program, location, v0);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniform1uivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramUniform1uivEXT(int program, int location, int count, IntBuffer value) {
		getCurrent().glProgramUniform1uivEXT(program, location, count, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniform1uivEXT(int, int, int, int[], int)
	 */
	public void glProgramUniform1uivEXT(int program, int location, int count, int[] value, int value_offset) {
		getCurrent().glProgramUniform1uivEXT(program, location, count, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param v0
	 * @param v1
	 * @see javax.media.opengl.GL2#glProgramUniform2uiEXT(int, int, int, int)
	 */
	public void glProgramUniform2uiEXT(int program, int location, int v0, int v1) {
		getCurrent().glProgramUniform2uiEXT(program, location, v0, v1);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniform2uivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramUniform2uivEXT(int program, int location, int count, IntBuffer value) {
		getCurrent().glProgramUniform2uivEXT(program, location, count, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniform2uivEXT(int, int, int, int[], int)
	 */
	public void glProgramUniform2uivEXT(int program, int location, int count, int[] value, int value_offset) {
		getCurrent().glProgramUniform2uivEXT(program, location, count, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param v0
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glProgramUniform3uiEXT(int, int, int, int, int)
	 */
	public void glProgramUniform3uiEXT(int program, int location, int v0, int v1, int v2) {
		getCurrent().glProgramUniform3uiEXT(program, location, v0, v1, v2);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniform3uivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramUniform3uivEXT(int program, int location, int count, IntBuffer value) {
		getCurrent().glProgramUniform3uivEXT(program, location, count, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniform3uivEXT(int, int, int, int[], int)
	 */
	public void glProgramUniform3uivEXT(int program, int location, int count, int[] value, int value_offset) {
		getCurrent().glProgramUniform3uivEXT(program, location, count, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param v0
	 * @param v1
	 * @param v2
	 * @param v3
	 * @see javax.media.opengl.GL2#glProgramUniform4uiEXT(int, int, int, int, int, int)
	 */
	public void glProgramUniform4uiEXT(int program, int location, int v0, int v1, int v2, int v3) {
		getCurrent().glProgramUniform4uiEXT(program, location, v0, v1, v2, v3);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniform4uivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glProgramUniform4uivEXT(int program, int location, int count, IntBuffer value) {
		getCurrent().glProgramUniform4uivEXT(program, location, count, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniform4uivEXT(int, int, int, int[], int)
	 */
	public void glProgramUniform4uivEXT(int program, int location, int count, int[] value, int value_offset) {
		getCurrent().glProgramUniform4uivEXT(program, location, count, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniformHandleui64NV(int, int, long)
	 */
	public void glProgramUniformHandleui64NV(int program, int location, long value) {
		getCurrent().glProgramUniformHandleui64NV(program, location, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param values
	 * @see javax.media.opengl.GL2#glProgramUniformHandleui64vNV(int, int, int, java.nio.LongBuffer)
	 */
	public void glProgramUniformHandleui64vNV(int program, int location, int count, LongBuffer values) {
		getCurrent().glProgramUniformHandleui64vNV(program, location, count, values);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glProgramUniformHandleui64vNV(int, int, int, long[], int)
	 */
	public void glProgramUniformHandleui64vNV(int program, int location, int count, long[] values, int values_offset) {
		getCurrent().glProgramUniformHandleui64vNV(program, location, count, values, values_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix2x3fvEXT(int, int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glProgramUniformMatrix2x3fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glProgramUniformMatrix2x3fvEXT(program, location, count, transpose, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix2x3fvEXT(int, int, int, boolean, float[], int)
	 */
	public void glProgramUniformMatrix2x3fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glProgramUniformMatrix2x3fvEXT(program, location, count, transpose, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix2x4fvEXT(int, int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glProgramUniformMatrix2x4fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glProgramUniformMatrix2x4fvEXT(program, location, count, transpose, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix2x4fvEXT(int, int, int, boolean, float[], int)
	 */
	public void glProgramUniformMatrix2x4fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glProgramUniformMatrix2x4fvEXT(program, location, count, transpose, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix3x2fvEXT(int, int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glProgramUniformMatrix3x2fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glProgramUniformMatrix3x2fvEXT(program, location, count, transpose, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix3x2fvEXT(int, int, int, boolean, float[], int)
	 */
	public void glProgramUniformMatrix3x2fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glProgramUniformMatrix3x2fvEXT(program, location, count, transpose, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix3x4fvEXT(int, int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glProgramUniformMatrix3x4fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glProgramUniformMatrix3x4fvEXT(program, location, count, transpose, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix3x4fvEXT(int, int, int, boolean, float[], int)
	 */
	public void glProgramUniformMatrix3x4fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glProgramUniformMatrix3x4fvEXT(program, location, count, transpose, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix4x2fvEXT(int, int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glProgramUniformMatrix4x2fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glProgramUniformMatrix4x2fvEXT(program, location, count, transpose, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix4x2fvEXT(int, int, int, boolean, float[], int)
	 */
	public void glProgramUniformMatrix4x2fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glProgramUniformMatrix4x2fvEXT(program, location, count, transpose, value, value_offset);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix4x3fvEXT(int, int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glProgramUniformMatrix4x3fvEXT(int program, int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glProgramUniformMatrix4x3fvEXT(program, location, count, transpose, value);
	}

	/**
	 * @param program
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glProgramUniformMatrix4x3fvEXT(int, int, int, boolean, float[], int)
	 */
	public void glProgramUniformMatrix4x3fvEXT(int program, int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glProgramUniformMatrix4x3fvEXT(program, location, count, transpose, value, value_offset);
	}

	/**
	 * @param target
	 * @param limit
	 * @see javax.media.opengl.GL2#glProgramVertexLimitNV(int, int)
	 */
	public void glProgramVertexLimitNV(int target, int limit) {
		getCurrent().glProgramVertexLimitNV(target, limit);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2#glProvokingVertexEXT(int)
	 */
	public void glProvokingVertexEXT(int mode) {
		getCurrent().glProvokingVertexEXT(mode);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL2#glPushAttrib(int)
	 */
	public void glPushAttrib(int mask) {
		getCurrent().glPushAttrib(mask);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL2#glPushClientAttrib(int)
	 */
	public void glPushClientAttrib(int mask) {
		getCurrent().glPushClientAttrib(mask);
	}

	/**
	 * @param mask
	 * @see javax.media.opengl.GL2#glPushClientAttribDefaultEXT(int)
	 */
	public void glPushClientAttribDefaultEXT(int mask) {
		getCurrent().glPushClientAttribDefaultEXT(mask);
	}

	/**
	 * @param name
	 * @see javax.media.opengl.GL2#glPushName(int)
	 */
	public void glPushName(int name) {
		getCurrent().glPushName(name);
	}

	/**
	 * @param mantissa
	 * @param exponent
	 * @return
	 * @see javax.media.opengl.GL2#glQueryMatrixxOES(java.nio.IntBuffer, java.nio.IntBuffer)
	 */
	public int glQueryMatrixxOES(IntBuffer mantissa, IntBuffer exponent) {
		return getCurrent().glQueryMatrixxOES(mantissa, exponent);
	}

	/**
	 * @param mantissa
	 * @param mantissa_offset
	 * @param exponent
	 * @param exponent_offset
	 * @return
	 * @see javax.media.opengl.GL2#glQueryMatrixxOES(int[], int, int[], int)
	 */
	public int glQueryMatrixxOES(int[] mantissa, int mantissa_offset, int[] exponent, int exponent_offset) {
		return getCurrent().glQueryMatrixxOES(mantissa, mantissa_offset, exponent, exponent_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glRasterPos2d(double, double)
	 */
	public void glRasterPos2d(double x, double y) {
		getCurrent().glRasterPos2d(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos2dv(java.nio.DoubleBuffer)
	 */
	public void glRasterPos2dv(DoubleBuffer v) {
		getCurrent().glRasterPos2dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos2dv(double[], int)
	 */
	public void glRasterPos2dv(double[] v, int v_offset) {
		getCurrent().glRasterPos2dv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glRasterPos2f(float, float)
	 */
	public void glRasterPos2f(float x, float y) {
		getCurrent().glRasterPos2f(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos2fv(java.nio.FloatBuffer)
	 */
	public void glRasterPos2fv(FloatBuffer v) {
		getCurrent().glRasterPos2fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos2fv(float[], int)
	 */
	public void glRasterPos2fv(float[] v, int v_offset) {
		getCurrent().glRasterPos2fv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glRasterPos2i(int, int)
	 */
	public void glRasterPos2i(int x, int y) {
		getCurrent().glRasterPos2i(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos2iv(java.nio.IntBuffer)
	 */
	public void glRasterPos2iv(IntBuffer v) {
		getCurrent().glRasterPos2iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos2iv(int[], int)
	 */
	public void glRasterPos2iv(int[] v, int v_offset) {
		getCurrent().glRasterPos2iv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glRasterPos2s(short, short)
	 */
	public void glRasterPos2s(short x, short y) {
		getCurrent().glRasterPos2s(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos2sv(java.nio.ShortBuffer)
	 */
	public void glRasterPos2sv(ShortBuffer v) {
		getCurrent().glRasterPos2sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos2sv(short[], int)
	 */
	public void glRasterPos2sv(short[] v, int v_offset) {
		getCurrent().glRasterPos2sv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glRasterPos3d(double, double, double)
	 */
	public void glRasterPos3d(double x, double y, double z) {
		getCurrent().glRasterPos3d(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos3dv(java.nio.DoubleBuffer)
	 */
	public void glRasterPos3dv(DoubleBuffer v) {
		getCurrent().glRasterPos3dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos3dv(double[], int)
	 */
	public void glRasterPos3dv(double[] v, int v_offset) {
		getCurrent().glRasterPos3dv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glRasterPos3f(float, float, float)
	 */
	public void glRasterPos3f(float x, float y, float z) {
		getCurrent().glRasterPos3f(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos3fv(java.nio.FloatBuffer)
	 */
	public void glRasterPos3fv(FloatBuffer v) {
		getCurrent().glRasterPos3fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos3fv(float[], int)
	 */
	public void glRasterPos3fv(float[] v, int v_offset) {
		getCurrent().glRasterPos3fv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glRasterPos3i(int, int, int)
	 */
	public void glRasterPos3i(int x, int y, int z) {
		getCurrent().glRasterPos3i(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos3iv(java.nio.IntBuffer)
	 */
	public void glRasterPos3iv(IntBuffer v) {
		getCurrent().glRasterPos3iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos3iv(int[], int)
	 */
	public void glRasterPos3iv(int[] v, int v_offset) {
		getCurrent().glRasterPos3iv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glRasterPos3s(short, short, short)
	 */
	public void glRasterPos3s(short x, short y, short z) {
		getCurrent().glRasterPos3s(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos3sv(java.nio.ShortBuffer)
	 */
	public void glRasterPos3sv(ShortBuffer v) {
		getCurrent().glRasterPos3sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos3sv(short[], int)
	 */
	public void glRasterPos3sv(short[] v, int v_offset) {
		getCurrent().glRasterPos3sv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glRasterPos4d(double, double, double, double)
	 */
	public void glRasterPos4d(double x, double y, double z, double w) {
		getCurrent().glRasterPos4d(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos4dv(java.nio.DoubleBuffer)
	 */
	public void glRasterPos4dv(DoubleBuffer v) {
		getCurrent().glRasterPos4dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos4dv(double[], int)
	 */
	public void glRasterPos4dv(double[] v, int v_offset) {
		getCurrent().glRasterPos4dv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glRasterPos4f(float, float, float, float)
	 */
	public void glRasterPos4f(float x, float y, float z, float w) {
		getCurrent().glRasterPos4f(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos4fv(java.nio.FloatBuffer)
	 */
	public void glRasterPos4fv(FloatBuffer v) {
		getCurrent().glRasterPos4fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos4fv(float[], int)
	 */
	public void glRasterPos4fv(float[] v, int v_offset) {
		getCurrent().glRasterPos4fv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glRasterPos4i(int, int, int, int)
	 */
	public void glRasterPos4i(int x, int y, int z, int w) {
		getCurrent().glRasterPos4i(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos4iv(java.nio.IntBuffer)
	 */
	public void glRasterPos4iv(IntBuffer v) {
		getCurrent().glRasterPos4iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos4iv(int[], int)
	 */
	public void glRasterPos4iv(int[] v, int v_offset) {
		getCurrent().glRasterPos4iv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glRasterPos4s(short, short, short, short)
	 */
	public void glRasterPos4s(short x, short y, short z, short w) {
		getCurrent().glRasterPos4s(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glRasterPos4sv(java.nio.ShortBuffer)
	 */
	public void glRasterPos4sv(ShortBuffer v) {
		getCurrent().glRasterPos4sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glRasterPos4sv(short[], int)
	 */
	public void glRasterPos4sv(short[] v, int v_offset) {
		getCurrent().glRasterPos4sv(v, v_offset);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2#glReadBuffer(int)
	 */
	public void glReadBuffer(int mode) {
		getCurrent().glReadBuffer(mode);
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @see javax.media.opengl.GL2#glRectd(double, double, double, double)
	 */
	public void glRectd(double x1, double y1, double x2, double y2) {
		getCurrent().glRectd(x1, y1, x2, y2);
	}

	/**
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glRectdv(java.nio.DoubleBuffer, java.nio.DoubleBuffer)
	 */
	public void glRectdv(DoubleBuffer v1, DoubleBuffer v2) {
		getCurrent().glRectdv(v1, v2);
	}

	/**
	 * @param v1
	 * @param v1_offset
	 * @param v2
	 * @param v2_offset
	 * @see javax.media.opengl.GL2#glRectdv(double[], int, double[], int)
	 */
	public void glRectdv(double[] v1, int v1_offset, double[] v2, int v2_offset) {
		getCurrent().glRectdv(v1, v1_offset, v2, v2_offset);
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @see javax.media.opengl.GL2#glRectf(float, float, float, float)
	 */
	public void glRectf(float x1, float y1, float x2, float y2) {
		getCurrent().glRectf(x1, y1, x2, y2);
	}

	/**
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glRectfv(java.nio.FloatBuffer, java.nio.FloatBuffer)
	 */
	public void glRectfv(FloatBuffer v1, FloatBuffer v2) {
		getCurrent().glRectfv(v1, v2);
	}

	/**
	 * @param v1
	 * @param v1_offset
	 * @param v2
	 * @param v2_offset
	 * @see javax.media.opengl.GL2#glRectfv(float[], int, float[], int)
	 */
	public void glRectfv(float[] v1, int v1_offset, float[] v2, int v2_offset) {
		getCurrent().glRectfv(v1, v1_offset, v2, v2_offset);
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @see javax.media.opengl.GL2#glRecti(int, int, int, int)
	 */
	public void glRecti(int x1, int y1, int x2, int y2) {
		getCurrent().glRecti(x1, y1, x2, y2);
	}

	/**
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glRectiv(java.nio.IntBuffer, java.nio.IntBuffer)
	 */
	public void glRectiv(IntBuffer v1, IntBuffer v2) {
		getCurrent().glRectiv(v1, v2);
	}

	/**
	 * @param v1
	 * @param v1_offset
	 * @param v2
	 * @param v2_offset
	 * @see javax.media.opengl.GL2#glRectiv(int[], int, int[], int)
	 */
	public void glRectiv(int[] v1, int v1_offset, int[] v2, int v2_offset) {
		getCurrent().glRectiv(v1, v1_offset, v2, v2_offset);
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @see javax.media.opengl.GL2#glRects(short, short, short, short)
	 */
	public void glRects(short x1, short y1, short x2, short y2) {
		getCurrent().glRects(x1, y1, x2, y2);
	}

	/**
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glRectsv(java.nio.ShortBuffer, java.nio.ShortBuffer)
	 */
	public void glRectsv(ShortBuffer v1, ShortBuffer v2) {
		getCurrent().glRectsv(v1, v2);
	}

	/**
	 * @param v1
	 * @param v1_offset
	 * @param v2
	 * @param v2_offset
	 * @see javax.media.opengl.GL2#glRectsv(short[], int, short[], int)
	 */
	public void glRectsv(short[] v1, int v1_offset, short[] v2, int v2_offset) {
		getCurrent().glRectsv(v1, v1_offset, v2, v2_offset);
	}

	/**
	 * @param mode
	 * @return
	 * @see javax.media.opengl.GL2#glRenderMode(int)
	 */
	public int glRenderMode(int mode) {
		return getCurrent().glRenderMode(mode);
	}

	/**
	 * @param target
	 * @param samples
	 * @param internalformat
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glRenderbufferStorageMultisample(int, int, int, int, int)
	 */
	public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
		getCurrent().glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
	}

	/**
	 * @param target
	 * @param coverageSamples
	 * @param colorSamples
	 * @param internalformat
	 * @param width
	 * @param height
	 * @see javax.media.opengl.GL2#glRenderbufferStorageMultisampleCoverageNV(int, int, int, int, int, int)
	 */
	public void glRenderbufferStorageMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
		getCurrent().glRenderbufferStorageMultisampleCoverageNV(target, coverageSamples, colorSamples, internalformat, width, height);
	}

	/**
	 * @param target
	 * @see javax.media.opengl.GL2#glResetHistogram(int)
	 */
	public void glResetHistogram(int target) {
		getCurrent().glResetHistogram(target);
	}

	/**
	 * @param target
	 * @see javax.media.opengl.GL2#glResetMinmax(int)
	 */
	public void glResetMinmax(int target) {
		getCurrent().glResetMinmax(target);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glResumeTransformFeedbackNV()
	 */
	public void glResumeTransformFeedbackNV() {
		getCurrent().glResumeTransformFeedbackNV();
	}

	/**
	 * @param angle
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glRotated(double, double, double, double)
	 */
	public void glRotated(double angle, double x, double y, double z) {
		getCurrent().glRotated(angle, x, y, z);
	}

	/**
	 * @param index
	 * @param mask
	 * @see javax.media.opengl.GL2#glSampleMaskIndexedNV(int, int)
	 */
	public void glSampleMaskIndexedNV(int index, int mask) {
		getCurrent().glSampleMaskIndexedNV(index, mask);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glScaled(double, double, double)
	 */
	public void glScaled(double x, double y, double z) {
		getCurrent().glScaled(x, y, z);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3b(byte, byte, byte)
	 */
	public void glSecondaryColor3b(byte red, byte green, byte blue) {
		getCurrent().glSecondaryColor3b(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3bv(java.nio.ByteBuffer)
	 */
	public void glSecondaryColor3bv(ByteBuffer v) {
		getCurrent().glSecondaryColor3bv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3bv(byte[], int)
	 */
	public void glSecondaryColor3bv(byte[] v, int v_offset) {
		getCurrent().glSecondaryColor3bv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3d(double, double, double)
	 */
	public void glSecondaryColor3d(double red, double green, double blue) {
		getCurrent().glSecondaryColor3d(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3dv(java.nio.DoubleBuffer)
	 */
	public void glSecondaryColor3dv(DoubleBuffer v) {
		getCurrent().glSecondaryColor3dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3dv(double[], int)
	 */
	public void glSecondaryColor3dv(double[] v, int v_offset) {
		getCurrent().glSecondaryColor3dv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3f(float, float, float)
	 */
	public void glSecondaryColor3f(float red, float green, float blue) {
		getCurrent().glSecondaryColor3f(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3fv(java.nio.FloatBuffer)
	 */
	public void glSecondaryColor3fv(FloatBuffer v) {
		getCurrent().glSecondaryColor3fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3fv(float[], int)
	 */
	public void glSecondaryColor3fv(float[] v, int v_offset) {
		getCurrent().glSecondaryColor3fv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3h(short, short, short)
	 */
	public void glSecondaryColor3h(short red, short green, short blue) {
		getCurrent().glSecondaryColor3h(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3hv(java.nio.ShortBuffer)
	 */
	public void glSecondaryColor3hv(ShortBuffer v) {
		getCurrent().glSecondaryColor3hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3hv(short[], int)
	 */
	public void glSecondaryColor3hv(short[] v, int v_offset) {
		getCurrent().glSecondaryColor3hv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3i(int, int, int)
	 */
	public void glSecondaryColor3i(int red, int green, int blue) {
		getCurrent().glSecondaryColor3i(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3iv(java.nio.IntBuffer)
	 */
	public void glSecondaryColor3iv(IntBuffer v) {
		getCurrent().glSecondaryColor3iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3iv(int[], int)
	 */
	public void glSecondaryColor3iv(int[] v, int v_offset) {
		getCurrent().glSecondaryColor3iv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3s(short, short, short)
	 */
	public void glSecondaryColor3s(short red, short green, short blue) {
		getCurrent().glSecondaryColor3s(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3sv(java.nio.ShortBuffer)
	 */
	public void glSecondaryColor3sv(ShortBuffer v) {
		getCurrent().glSecondaryColor3sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3sv(short[], int)
	 */
	public void glSecondaryColor3sv(short[] v, int v_offset) {
		getCurrent().glSecondaryColor3sv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3ub(byte, byte, byte)
	 */
	public void glSecondaryColor3ub(byte red, byte green, byte blue) {
		getCurrent().glSecondaryColor3ub(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3ubv(java.nio.ByteBuffer)
	 */
	public void glSecondaryColor3ubv(ByteBuffer v) {
		getCurrent().glSecondaryColor3ubv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3ubv(byte[], int)
	 */
	public void glSecondaryColor3ubv(byte[] v, int v_offset) {
		getCurrent().glSecondaryColor3ubv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3ui(int, int, int)
	 */
	public void glSecondaryColor3ui(int red, int green, int blue) {
		getCurrent().glSecondaryColor3ui(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3uiv(java.nio.IntBuffer)
	 */
	public void glSecondaryColor3uiv(IntBuffer v) {
		getCurrent().glSecondaryColor3uiv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3uiv(int[], int)
	 */
	public void glSecondaryColor3uiv(int[] v, int v_offset) {
		getCurrent().glSecondaryColor3uiv(v, v_offset);
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 * @see javax.media.opengl.GL2#glSecondaryColor3us(short, short, short)
	 */
	public void glSecondaryColor3us(short red, short green, short blue) {
		getCurrent().glSecondaryColor3us(red, green, blue);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glSecondaryColor3usv(java.nio.ShortBuffer)
	 */
	public void glSecondaryColor3usv(ShortBuffer v) {
		getCurrent().glSecondaryColor3usv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glSecondaryColor3usv(short[], int)
	 */
	public void glSecondaryColor3usv(short[] v, int v_offset) {
		getCurrent().glSecondaryColor3usv(v, v_offset);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glSecondaryColorPointer(int, int, int, java.nio.Buffer)
	 */
	public void glSecondaryColorPointer(int size, int type, int stride, Buffer pointer) {
		getCurrent().glSecondaryColorPointer(size, type, stride, pointer);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.GL2#glSecondaryColorPointer(int, int, int, long)
	 */
	public void glSecondaryColorPointer(int size, int type, int stride, long pointer_buffer_offset) {
		getCurrent().glSecondaryColorPointer(size, type, stride, pointer_buffer_offset);
	}

	/**
	 * @param size
	 * @param buffer
	 * @see javax.media.opengl.GL2#glSelectBuffer(int, java.nio.IntBuffer)
	 */
	public void glSelectBuffer(int size, IntBuffer buffer) {
		getCurrent().glSelectBuffer(size, buffer);
	}

	/**
	 * @param monitor
	 * @param enable
	 * @param group
	 * @param numCounters
	 * @param counterList
	 * @see javax.media.opengl.GL2#glSelectPerfMonitorCountersAMD(int, boolean, int, int, java.nio.IntBuffer)
	 */
	public void glSelectPerfMonitorCountersAMD(int monitor, boolean enable, int group, int numCounters, IntBuffer counterList) {
		getCurrent().glSelectPerfMonitorCountersAMD(monitor, enable, group, numCounters, counterList);
	}

	/**
	 * @param monitor
	 * @param enable
	 * @param group
	 * @param numCounters
	 * @param counterList
	 * @param counterList_offset
	 * @see javax.media.opengl.GL2#glSelectPerfMonitorCountersAMD(int, boolean, int, int, int[], int)
	 */
	public void glSelectPerfMonitorCountersAMD(int monitor, boolean enable, int group, int numCounters, int[] counterList, int counterList_offset) {
		getCurrent().glSelectPerfMonitorCountersAMD(monitor, enable, group, numCounters, counterList, counterList_offset);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param row
	 * @param column
	 * @see javax.media.opengl.GL2#glSeparableFilter2D(int, int, int, int, int, int, java.nio.Buffer, java.nio.Buffer)
	 */
	public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, Buffer row, Buffer column) {
		getCurrent().glSeparableFilter2D(target, internalformat, width, height, format, type, row, column);
	}

	/**
	 * @param target
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param row_buffer_offset
	 * @param column_buffer_offset
	 * @see javax.media.opengl.GL2#glSeparableFilter2D(int, int, int, int, int, int, long, long)
	 */
	public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, long row_buffer_offset, long column_buffer_offset) {
		getCurrent().glSeparableFilter2D(target, internalformat, width, height, format, type, row_buffer_offset, column_buffer_offset);
	}

	/**
	 * @param fence
	 * @see javax.media.opengl.GL2#glSetFenceAPPLE(int)
	 */
	public void glSetFenceAPPLE(int fence) {
		getCurrent().glSetFenceAPPLE(fence);
	}

	/**
	 * @param fence
	 * @param condition
	 * @see javax.media.opengl.GL2#glSetFenceNV(int, int)
	 */
	public void glSetFenceNV(int fence, int condition) {
		getCurrent().glSetFenceNV(fence, condition);
	}

	/**
	 * @param id
	 * @param type
	 * @param addr
	 * @see javax.media.opengl.GL2#glSetInvariantEXT(int, int, java.nio.Buffer)
	 */
	public void glSetInvariantEXT(int id, int type, Buffer addr) {
		getCurrent().glSetInvariantEXT(id, type, addr);
	}

	/**
	 * @param id
	 * @param type
	 * @param addr
	 * @see javax.media.opengl.GL2#glSetLocalConstantEXT(int, int, java.nio.Buffer)
	 */
	public void glSetLocalConstantEXT(int id, int type, Buffer addr) {
		getCurrent().glSetLocalConstantEXT(id, type, addr);
	}

	/**
	 * @param op
	 * @param res
	 * @param arg1
	 * @see javax.media.opengl.GL2#glShaderOp1EXT(int, int, int)
	 */
	public void glShaderOp1EXT(int op, int res, int arg1) {
		getCurrent().glShaderOp1EXT(op, res, arg1);
	}

	/**
	 * @param op
	 * @param res
	 * @param arg1
	 * @param arg2
	 * @see javax.media.opengl.GL2#glShaderOp2EXT(int, int, int, int)
	 */
	public void glShaderOp2EXT(int op, int res, int arg1, int arg2) {
		getCurrent().glShaderOp2EXT(op, res, arg1, arg2);
	}

	/**
	 * @param op
	 * @param res
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @see javax.media.opengl.GL2#glShaderOp3EXT(int, int, int, int, int)
	 */
	public void glShaderOp3EXT(int op, int res, int arg1, int arg2, int arg3) {
		getCurrent().glShaderOp3EXT(op, res, arg1, arg2, arg3);
	}

	/**
	 * @param shaderObj
	 * @param count
	 * @param string
	 * @param length
	 * @see javax.media.opengl.GL2#glShaderSourceARB(int, int, java.lang.String[], java.nio.IntBuffer)
	 */
	public void glShaderSourceARB(int shaderObj, int count, String[] string, IntBuffer length) {
		getCurrent().glShaderSourceARB(shaderObj, count, string, length);
	}

	/**
	 * @param shaderObj
	 * @param count
	 * @param string
	 * @param length
	 * @param length_offset
	 * @see javax.media.opengl.GL2#glShaderSourceARB(int, int, java.lang.String[], int[], int)
	 */
	public void glShaderSourceARB(int shaderObj, int count, String[] string, int[] length, int length_offset) {
		getCurrent().glShaderSourceARB(shaderObj, count, string, length, length_offset);
	}

	/**
	 * @param stencilTagBits
	 * @param stencilClearTag
	 * @see javax.media.opengl.GL2#glStencilClearTagEXT(int, int)
	 */
	public void glStencilClearTagEXT(int stencilTagBits, int stencilClearTag) {
		getCurrent().glStencilClearTagEXT(stencilTagBits, stencilClearTag);
	}

	/**
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param fillMode
	 * @param mask
	 * @param transformType
	 * @param transformValues
	 * @see javax.media.opengl.GL2#glStencilFillPathInstancedNV(int, int, java.nio.Buffer, int, int, int, int, java.nio.FloatBuffer)
	 */
	public void glStencilFillPathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int fillMode, int mask, int transformType, FloatBuffer transformValues) {
		getCurrent().glStencilFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, fillMode, mask, transformType, transformValues);
	}

	/**
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param fillMode
	 * @param mask
	 * @param transformType
	 * @param transformValues
	 * @param transformValues_offset
	 * @see javax.media.opengl.GL2#glStencilFillPathInstancedNV(int, int, java.nio.Buffer, int, int, int, int, float[], int)
	 */
	public void glStencilFillPathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int fillMode, int mask, int transformType, float[] transformValues, int transformValues_offset) {
		getCurrent().glStencilFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, fillMode, mask, transformType, transformValues, transformValues_offset);
	}

	/**
	 * @param path
	 * @param fillMode
	 * @param mask
	 * @see javax.media.opengl.GL2#glStencilFillPathNV(int, int, int)
	 */
	public void glStencilFillPathNV(int path, int fillMode, int mask) {
		getCurrent().glStencilFillPathNV(path, fillMode, mask);
	}

	/**
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param reference
	 * @param mask
	 * @param transformType
	 * @param transformValues
	 * @see javax.media.opengl.GL2#glStencilStrokePathInstancedNV(int, int, java.nio.Buffer, int, int, int, int, java.nio.FloatBuffer)
	 */
	public void glStencilStrokePathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int reference, int mask, int transformType, FloatBuffer transformValues) {
		getCurrent().glStencilStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, reference, mask, transformType, transformValues);
	}

	/**
	 * @param numPaths
	 * @param pathNameType
	 * @param paths
	 * @param pathBase
	 * @param reference
	 * @param mask
	 * @param transformType
	 * @param transformValues
	 * @param transformValues_offset
	 * @see javax.media.opengl.GL2#glStencilStrokePathInstancedNV(int, int, java.nio.Buffer, int, int, int, int, float[], int)
	 */
	public void glStencilStrokePathInstancedNV(int numPaths, int pathNameType, Buffer paths, int pathBase, int reference, int mask, int transformType, float[] transformValues, int transformValues_offset) {
		getCurrent().glStencilStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, reference, mask, transformType, transformValues, transformValues_offset);
	}

	/**
	 * @param path
	 * @param reference
	 * @param mask
	 * @see javax.media.opengl.GL2#glStencilStrokePathNV(int, int, int)
	 */
	public void glStencilStrokePathNV(int path, int reference, int mask) {
		getCurrent().glStencilStrokePathNV(path, reference, mask);
	}

	/**
	 * @param len
	 * @param string
	 * @see javax.media.opengl.GL2#glStringMarkerGREMEDY(int, java.nio.Buffer)
	 */
	public void glStringMarkerGREMEDY(int len, Buffer string) {
		getCurrent().glStringMarkerGREMEDY(len, string);
	}

	/**
	 * @param res
	 * @param in
	 * @param outX
	 * @param outY
	 * @param outZ
	 * @param outW
	 * @see javax.media.opengl.GL2#glSwizzleEXT(int, int, int, int, int, int)
	 */
	public void glSwizzleEXT(int res, int in, int outX, int outY, int outZ, int outW) {
		getCurrent().glSwizzleEXT(res, in, outX, outY, outZ, outW);
	}

	/**
	 * @param texture
	 * @see javax.media.opengl.GL2#glSyncTextureINTEL(int)
	 */
	public void glSyncTextureINTEL(int texture) {
		getCurrent().glSyncTextureINTEL(texture);
	}

	/**
	 * @param fence
	 * @return
	 * @see javax.media.opengl.GL2#glTestFenceAPPLE(int)
	 */
	public boolean glTestFenceAPPLE(int fence) {
		return getCurrent().glTestFenceAPPLE(fence);
	}

	/**
	 * @param fence
	 * @return
	 * @see javax.media.opengl.GL2#glTestFenceNV(int)
	 */
	public boolean glTestFenceNV(int fence) {
		return getCurrent().glTestFenceNV(fence);
	}

	/**
	 * @param object
	 * @param name
	 * @return
	 * @see javax.media.opengl.GL2#glTestObjectAPPLE(int, int)
	 */
	public boolean glTestObjectAPPLE(int object, int name) {
		return getCurrent().glTestObjectAPPLE(object, name);
	}

	/**
	 * @param s
	 * @see javax.media.opengl.GL2#glTexCoord1bOES(byte)
	 */
	public void glTexCoord1bOES(byte s) {
		getCurrent().glTexCoord1bOES(s);
	}

	/**
	 * @param coords
	 * @see javax.media.opengl.GL2#glTexCoord1bvOES(java.nio.ByteBuffer)
	 */
	public void glTexCoord1bvOES(ByteBuffer coords) {
		getCurrent().glTexCoord1bvOES(coords);
	}

	/**
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glTexCoord1bvOES(byte[], int)
	 */
	public void glTexCoord1bvOES(byte[] coords, int coords_offset) {
		getCurrent().glTexCoord1bvOES(coords, coords_offset);
	}

	/**
	 * @param s
	 * @see javax.media.opengl.GL2#glTexCoord1d(double)
	 */
	public void glTexCoord1d(double s) {
		getCurrent().glTexCoord1d(s);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord1dv(java.nio.DoubleBuffer)
	 */
	public void glTexCoord1dv(DoubleBuffer v) {
		getCurrent().glTexCoord1dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord1dv(double[], int)
	 */
	public void glTexCoord1dv(double[] v, int v_offset) {
		getCurrent().glTexCoord1dv(v, v_offset);
	}

	/**
	 * @param s
	 * @see javax.media.opengl.GL2#glTexCoord1f(float)
	 */
	public void glTexCoord1f(float s) {
		getCurrent().glTexCoord1f(s);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord1fv(java.nio.FloatBuffer)
	 */
	public void glTexCoord1fv(FloatBuffer v) {
		getCurrent().glTexCoord1fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord1fv(float[], int)
	 */
	public void glTexCoord1fv(float[] v, int v_offset) {
		getCurrent().glTexCoord1fv(v, v_offset);
	}

	/**
	 * @param s
	 * @see javax.media.opengl.GL2#glTexCoord1h(short)
	 */
	public void glTexCoord1h(short s) {
		getCurrent().glTexCoord1h(s);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord1hv(java.nio.ShortBuffer)
	 */
	public void glTexCoord1hv(ShortBuffer v) {
		getCurrent().glTexCoord1hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord1hv(short[], int)
	 */
	public void glTexCoord1hv(short[] v, int v_offset) {
		getCurrent().glTexCoord1hv(v, v_offset);
	}

	/**
	 * @param s
	 * @see javax.media.opengl.GL2#glTexCoord1i(int)
	 */
	public void glTexCoord1i(int s) {
		getCurrent().glTexCoord1i(s);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord1iv(java.nio.IntBuffer)
	 */
	public void glTexCoord1iv(IntBuffer v) {
		getCurrent().glTexCoord1iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord1iv(int[], int)
	 */
	public void glTexCoord1iv(int[] v, int v_offset) {
		getCurrent().glTexCoord1iv(v, v_offset);
	}

	/**
	 * @param s
	 * @see javax.media.opengl.GL2#glTexCoord1s(short)
	 */
	public void glTexCoord1s(short s) {
		getCurrent().glTexCoord1s(s);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord1sv(java.nio.ShortBuffer)
	 */
	public void glTexCoord1sv(ShortBuffer v) {
		getCurrent().glTexCoord1sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord1sv(short[], int)
	 */
	public void glTexCoord1sv(short[] v, int v_offset) {
		getCurrent().glTexCoord1sv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glTexCoord2bOES(byte, byte)
	 */
	public void glTexCoord2bOES(byte s, byte t) {
		getCurrent().glTexCoord2bOES(s, t);
	}

	/**
	 * @param coords
	 * @see javax.media.opengl.GL2#glTexCoord2bvOES(java.nio.ByteBuffer)
	 */
	public void glTexCoord2bvOES(ByteBuffer coords) {
		getCurrent().glTexCoord2bvOES(coords);
	}

	/**
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glTexCoord2bvOES(byte[], int)
	 */
	public void glTexCoord2bvOES(byte[] coords, int coords_offset) {
		getCurrent().glTexCoord2bvOES(coords, coords_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glTexCoord2d(double, double)
	 */
	public void glTexCoord2d(double s, double t) {
		getCurrent().glTexCoord2d(s, t);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord2dv(java.nio.DoubleBuffer)
	 */
	public void glTexCoord2dv(DoubleBuffer v) {
		getCurrent().glTexCoord2dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord2dv(double[], int)
	 */
	public void glTexCoord2dv(double[] v, int v_offset) {
		getCurrent().glTexCoord2dv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glTexCoord2f(float, float)
	 */
	public void glTexCoord2f(float s, float t) {
		getCurrent().glTexCoord2f(s, t);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord2fv(java.nio.FloatBuffer)
	 */
	public void glTexCoord2fv(FloatBuffer v) {
		getCurrent().glTexCoord2fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord2fv(float[], int)
	 */
	public void glTexCoord2fv(float[] v, int v_offset) {
		getCurrent().glTexCoord2fv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glTexCoord2h(short, short)
	 */
	public void glTexCoord2h(short s, short t) {
		getCurrent().glTexCoord2h(s, t);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord2hv(java.nio.ShortBuffer)
	 */
	public void glTexCoord2hv(ShortBuffer v) {
		getCurrent().glTexCoord2hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord2hv(short[], int)
	 */
	public void glTexCoord2hv(short[] v, int v_offset) {
		getCurrent().glTexCoord2hv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glTexCoord2i(int, int)
	 */
	public void glTexCoord2i(int s, int t) {
		getCurrent().glTexCoord2i(s, t);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord2iv(java.nio.IntBuffer)
	 */
	public void glTexCoord2iv(IntBuffer v) {
		getCurrent().glTexCoord2iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord2iv(int[], int)
	 */
	public void glTexCoord2iv(int[] v, int v_offset) {
		getCurrent().glTexCoord2iv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @see javax.media.opengl.GL2#glTexCoord2s(short, short)
	 */
	public void glTexCoord2s(short s, short t) {
		getCurrent().glTexCoord2s(s, t);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord2sv(java.nio.ShortBuffer)
	 */
	public void glTexCoord2sv(ShortBuffer v) {
		getCurrent().glTexCoord2sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord2sv(short[], int)
	 */
	public void glTexCoord2sv(short[] v, int v_offset) {
		getCurrent().glTexCoord2sv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glTexCoord3bOES(byte, byte, byte)
	 */
	public void glTexCoord3bOES(byte s, byte t, byte r) {
		getCurrent().glTexCoord3bOES(s, t, r);
	}

	/**
	 * @param coords
	 * @see javax.media.opengl.GL2#glTexCoord3bvOES(java.nio.ByteBuffer)
	 */
	public void glTexCoord3bvOES(ByteBuffer coords) {
		getCurrent().glTexCoord3bvOES(coords);
	}

	/**
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glTexCoord3bvOES(byte[], int)
	 */
	public void glTexCoord3bvOES(byte[] coords, int coords_offset) {
		getCurrent().glTexCoord3bvOES(coords, coords_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glTexCoord3d(double, double, double)
	 */
	public void glTexCoord3d(double s, double t, double r) {
		getCurrent().glTexCoord3d(s, t, r);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord3dv(java.nio.DoubleBuffer)
	 */
	public void glTexCoord3dv(DoubleBuffer v) {
		getCurrent().glTexCoord3dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord3dv(double[], int)
	 */
	public void glTexCoord3dv(double[] v, int v_offset) {
		getCurrent().glTexCoord3dv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glTexCoord3f(float, float, float)
	 */
	public void glTexCoord3f(float s, float t, float r) {
		getCurrent().glTexCoord3f(s, t, r);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord3fv(java.nio.FloatBuffer)
	 */
	public void glTexCoord3fv(FloatBuffer v) {
		getCurrent().glTexCoord3fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord3fv(float[], int)
	 */
	public void glTexCoord3fv(float[] v, int v_offset) {
		getCurrent().glTexCoord3fv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glTexCoord3h(short, short, short)
	 */
	public void glTexCoord3h(short s, short t, short r) {
		getCurrent().glTexCoord3h(s, t, r);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord3hv(java.nio.ShortBuffer)
	 */
	public void glTexCoord3hv(ShortBuffer v) {
		getCurrent().glTexCoord3hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord3hv(short[], int)
	 */
	public void glTexCoord3hv(short[] v, int v_offset) {
		getCurrent().glTexCoord3hv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glTexCoord3i(int, int, int)
	 */
	public void glTexCoord3i(int s, int t, int r) {
		getCurrent().glTexCoord3i(s, t, r);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord3iv(java.nio.IntBuffer)
	 */
	public void glTexCoord3iv(IntBuffer v) {
		getCurrent().glTexCoord3iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord3iv(int[], int)
	 */
	public void glTexCoord3iv(int[] v, int v_offset) {
		getCurrent().glTexCoord3iv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @see javax.media.opengl.GL2#glTexCoord3s(short, short, short)
	 */
	public void glTexCoord3s(short s, short t, short r) {
		getCurrent().glTexCoord3s(s, t, r);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord3sv(java.nio.ShortBuffer)
	 */
	public void glTexCoord3sv(ShortBuffer v) {
		getCurrent().glTexCoord3sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord3sv(short[], int)
	 */
	public void glTexCoord3sv(short[] v, int v_offset) {
		getCurrent().glTexCoord3sv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glTexCoord4bOES(byte, byte, byte, byte)
	 */
	public void glTexCoord4bOES(byte s, byte t, byte r, byte q) {
		getCurrent().glTexCoord4bOES(s, t, r, q);
	}

	/**
	 * @param coords
	 * @see javax.media.opengl.GL2#glTexCoord4bvOES(java.nio.ByteBuffer)
	 */
	public void glTexCoord4bvOES(ByteBuffer coords) {
		getCurrent().glTexCoord4bvOES(coords);
	}

	/**
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glTexCoord4bvOES(byte[], int)
	 */
	public void glTexCoord4bvOES(byte[] coords, int coords_offset) {
		getCurrent().glTexCoord4bvOES(coords, coords_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glTexCoord4d(double, double, double, double)
	 */
	public void glTexCoord4d(double s, double t, double r, double q) {
		getCurrent().glTexCoord4d(s, t, r, q);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord4dv(java.nio.DoubleBuffer)
	 */
	public void glTexCoord4dv(DoubleBuffer v) {
		getCurrent().glTexCoord4dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord4dv(double[], int)
	 */
	public void glTexCoord4dv(double[] v, int v_offset) {
		getCurrent().glTexCoord4dv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glTexCoord4f(float, float, float, float)
	 */
	public void glTexCoord4f(float s, float t, float r, float q) {
		getCurrent().glTexCoord4f(s, t, r, q);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord4fv(java.nio.FloatBuffer)
	 */
	public void glTexCoord4fv(FloatBuffer v) {
		getCurrent().glTexCoord4fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord4fv(float[], int)
	 */
	public void glTexCoord4fv(float[] v, int v_offset) {
		getCurrent().glTexCoord4fv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glTexCoord4h(short, short, short, short)
	 */
	public void glTexCoord4h(short s, short t, short r, short q) {
		getCurrent().glTexCoord4h(s, t, r, q);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord4hv(java.nio.ShortBuffer)
	 */
	public void glTexCoord4hv(ShortBuffer v) {
		getCurrent().glTexCoord4hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord4hv(short[], int)
	 */
	public void glTexCoord4hv(short[] v, int v_offset) {
		getCurrent().glTexCoord4hv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glTexCoord4i(int, int, int, int)
	 */
	public void glTexCoord4i(int s, int t, int r, int q) {
		getCurrent().glTexCoord4i(s, t, r, q);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord4iv(java.nio.IntBuffer)
	 */
	public void glTexCoord4iv(IntBuffer v) {
		getCurrent().glTexCoord4iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord4iv(int[], int)
	 */
	public void glTexCoord4iv(int[] v, int v_offset) {
		getCurrent().glTexCoord4iv(v, v_offset);
	}

	/**
	 * @param s
	 * @param t
	 * @param r
	 * @param q
	 * @see javax.media.opengl.GL2#glTexCoord4s(short, short, short, short)
	 */
	public void glTexCoord4s(short s, short t, short r, short q) {
		getCurrent().glTexCoord4s(s, t, r, q);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glTexCoord4sv(java.nio.ShortBuffer)
	 */
	public void glTexCoord4sv(ShortBuffer v) {
		getCurrent().glTexCoord4sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glTexCoord4sv(short[], int)
	 */
	public void glTexCoord4sv(short[] v, int v_offset) {
		getCurrent().glTexCoord4sv(v, v_offset);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glTexGend(int, int, double)
	 */
	public void glTexGend(int coord, int pname, double param) {
		getCurrent().glTexGend(coord, pname, param);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glTexGendv(int, int, java.nio.DoubleBuffer)
	 */
	public void glTexGendv(int coord, int pname, DoubleBuffer params) {
		getCurrent().glTexGendv(coord, pname, params);
	}

	/**
	 * @param coord
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glTexGendv(int, int, double[], int)
	 */
	public void glTexGendv(int coord, int pname, double[] params, int params_offset) {
		getCurrent().glTexGendv(coord, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param renderbuffer
	 * @see javax.media.opengl.GL2#glTexRenderbufferNV(int, int)
	 */
	public void glTexRenderbufferNV(int target, int renderbuffer) {
		getCurrent().glTexRenderbufferNV(target, renderbuffer);
	}

	/**
	 * @param target
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param depth
	 * @param layers
	 * @param flags
	 * @see javax.media.opengl.GL2#glTexStorageSparseAMD(int, int, int, int, int, int, int)
	 */
	public void glTexStorageSparseAMD(int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
		getCurrent().glTexStorageSparseAMD(target, internalFormat, width, height, depth, layers, flags);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glTextureBarrierNV()
	 */
	public void glTextureBarrierNV() {
		getCurrent().glTextureBarrierNV();
	}

	/**
	 * @param texture
	 * @param target
	 * @param internalformat
	 * @param buffer
	 * @see javax.media.opengl.GL2#glTextureBufferEXT(int, int, int, int)
	 */
	public void glTextureBufferEXT(int texture, int target, int internalformat, int buffer) {
		getCurrent().glTextureBufferEXT(texture, target, internalformat, buffer);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glTextureImage1DEXT(int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int format, int type, Buffer pixels) {
		getCurrent().glTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, pixels);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glTextureImage2DEXT(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int format, int type, Buffer pixels) {
		getCurrent().glTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, pixels);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param internalformat
	 * @param width
	 * @param height
	 * @param depth
	 * @param border
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glTextureImage3DEXT(int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Buffer pixels) {
		getCurrent().glTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, pixels);
	}

	/**
	 * @param pname
	 * @see javax.media.opengl.GL2#glTextureLightEXT(int)
	 */
	public void glTextureLightEXT(int pname) {
		getCurrent().glTextureLightEXT(pname);
	}

	/**
	 * @param face
	 * @param mode
	 * @see javax.media.opengl.GL2#glTextureMaterialEXT(int, int)
	 */
	public void glTextureMaterialEXT(int face, int mode) {
		getCurrent().glTextureMaterialEXT(face, mode);
	}

	/**
	 * @param mode
	 * @see javax.media.opengl.GL2#glTextureNormalEXT(int)
	 */
	public void glTextureNormalEXT(int mode) {
		getCurrent().glTextureNormalEXT(mode);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glTextureParameterIivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glTextureParameterIivEXT(int texture, int target, int pname, IntBuffer params) {
		getCurrent().glTextureParameterIivEXT(texture, target, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glTextureParameterIivEXT(int, int, int, int[], int)
	 */
	public void glTextureParameterIivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		getCurrent().glTextureParameterIivEXT(texture, target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glTextureParameterIuivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glTextureParameterIuivEXT(int texture, int target, int pname, IntBuffer params) {
		getCurrent().glTextureParameterIuivEXT(texture, target, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glTextureParameterIuivEXT(int, int, int, int[], int)
	 */
	public void glTextureParameterIuivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		getCurrent().glTextureParameterIuivEXT(texture, target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glTextureParameterfEXT(int, int, int, float)
	 */
	public void glTextureParameterfEXT(int texture, int target, int pname, float param) {
		getCurrent().glTextureParameterfEXT(texture, target, pname, param);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glTextureParameterfvEXT(int, int, int, java.nio.FloatBuffer)
	 */
	public void glTextureParameterfvEXT(int texture, int target, int pname, FloatBuffer params) {
		getCurrent().glTextureParameterfvEXT(texture, target, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glTextureParameterfvEXT(int, int, int, float[], int)
	 */
	public void glTextureParameterfvEXT(int texture, int target, int pname, float[] params, int params_offset) {
		getCurrent().glTextureParameterfvEXT(texture, target, pname, params, params_offset);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glTextureParameteriEXT(int, int, int, int)
	 */
	public void glTextureParameteriEXT(int texture, int target, int pname, int param) {
		getCurrent().glTextureParameteriEXT(texture, target, pname, param);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glTextureParameterivEXT(int, int, int, java.nio.IntBuffer)
	 */
	public void glTextureParameterivEXT(int texture, int target, int pname, IntBuffer params) {
		getCurrent().glTextureParameterivEXT(texture, target, pname, params);
	}

	/**
	 * @param texture
	 * @param target
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glTextureParameterivEXT(int, int, int, int[], int)
	 */
	public void glTextureParameterivEXT(int texture, int target, int pname, int[] params, int params_offset) {
		getCurrent().glTextureParameterivEXT(texture, target, pname, params, params_offset);
	}

	/**
	 * @param target
	 * @param length
	 * @param pointer
	 * @see javax.media.opengl.GL2#glTextureRangeAPPLE(int, int, java.nio.Buffer)
	 */
	public void glTextureRangeAPPLE(int target, int length, Buffer pointer) {
		getCurrent().glTextureRangeAPPLE(target, length, pointer);
	}

	/**
	 * @param texture
	 * @param target
	 * @param renderbuffer
	 * @see javax.media.opengl.GL2#glTextureRenderbufferEXT(int, int, int)
	 */
	public void glTextureRenderbufferEXT(int texture, int target, int renderbuffer) {
		getCurrent().glTextureRenderbufferEXT(texture, target, renderbuffer);
	}

	/**
	 * @param texture
	 * @param target
	 * @param internalFormat
	 * @param width
	 * @param height
	 * @param depth
	 * @param layers
	 * @param flags
	 * @see javax.media.opengl.GL2#glTextureStorageSparseAMD(int, int, int, int, int, int, int, int)
	 */
	public void glTextureStorageSparseAMD(int texture, int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
		getCurrent().glTextureStorageSparseAMD(texture, target, internalFormat, width, height, depth, layers, flags);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param width
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glTextureSubImage1DEXT(int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int type, Buffer pixels) {
		getCurrent().glTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, pixels);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param width
	 * @param height
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glTextureSubImage2DEXT(int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Buffer pixels) {
		getCurrent().glTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, pixels);
	}

	/**
	 * @param texture
	 * @param target
	 * @param level
	 * @param xoffset
	 * @param yoffset
	 * @param zoffset
	 * @param width
	 * @param height
	 * @param depth
	 * @param format
	 * @param type
	 * @param pixels
	 * @see javax.media.opengl.GL2#glTextureSubImage3DEXT(int, int, int, int, int, int, int, int, int, int, int, java.nio.Buffer)
	 */
	public void glTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Buffer pixels) {
		getCurrent().glTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
	}

	/**
	 * @param program
	 * @param count
	 * @param varyings
	 * @param bufferMode
	 * @see javax.media.opengl.GL2#glTransformFeedbackVaryings(int, int, java.lang.String[], int)
	 */
	public void glTransformFeedbackVaryings(int program, int count, String[] varyings, int bufferMode) {
		getCurrent().glTransformFeedbackVaryings(program, count, varyings, bufferMode);
	}

	/**
	 * @param resultPath
	 * @param srcPath
	 * @param transformType
	 * @param transformValues
	 * @see javax.media.opengl.GL2#glTransformPathNV(int, int, int, java.nio.FloatBuffer)
	 */
	public void glTransformPathNV(int resultPath, int srcPath, int transformType, FloatBuffer transformValues) {
		getCurrent().glTransformPathNV(resultPath, srcPath, transformType, transformValues);
	}

	/**
	 * @param resultPath
	 * @param srcPath
	 * @param transformType
	 * @param transformValues
	 * @param transformValues_offset
	 * @see javax.media.opengl.GL2#glTransformPathNV(int, int, int, float[], int)
	 */
	public void glTransformPathNV(int resultPath, int srcPath, int transformType, float[] transformValues, int transformValues_offset) {
		getCurrent().glTransformPathNV(resultPath, srcPath, transformType, transformValues, transformValues_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glTranslated(double, double, double)
	 */
	public void glTranslated(double x, double y, double z) {
		getCurrent().glTranslated(x, y, z);
	}

	/**
	 * @param location
	 * @param v0
	 * @see javax.media.opengl.GL2#glUniform1fARB(int, float)
	 */
	public void glUniform1fARB(int location, float v0) {
		getCurrent().glUniform1fARB(location, v0);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform1fvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glUniform1fvARB(int location, int count, FloatBuffer value) {
		getCurrent().glUniform1fvARB(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform1fvARB(int, int, float[], int)
	 */
	public void glUniform1fvARB(int location, int count, float[] value, int value_offset) {
		getCurrent().glUniform1fvARB(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @see javax.media.opengl.GL2#glUniform1iARB(int, int)
	 */
	public void glUniform1iARB(int location, int v0) {
		getCurrent().glUniform1iARB(location, v0);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform1ivARB(int, int, java.nio.IntBuffer)
	 */
	public void glUniform1ivARB(int location, int count, IntBuffer value) {
		getCurrent().glUniform1ivARB(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform1ivARB(int, int, int[], int)
	 */
	public void glUniform1ivARB(int location, int count, int[] value, int value_offset) {
		getCurrent().glUniform1ivARB(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @see javax.media.opengl.GL2#glUniform1ui(int, int)
	 */
	public void glUniform1ui(int location, int v0) {
		getCurrent().glUniform1ui(location, v0);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform1uiv(int, int, java.nio.IntBuffer)
	 */
	public void glUniform1uiv(int location, int count, IntBuffer value) {
		getCurrent().glUniform1uiv(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform1uiv(int, int, int[], int)
	 */
	public void glUniform1uiv(int location, int count, int[] value, int value_offset) {
		getCurrent().glUniform1uiv(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @see javax.media.opengl.GL2#glUniform2fARB(int, float, float)
	 */
	public void glUniform2fARB(int location, float v0, float v1) {
		getCurrent().glUniform2fARB(location, v0, v1);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform2fvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glUniform2fvARB(int location, int count, FloatBuffer value) {
		getCurrent().glUniform2fvARB(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform2fvARB(int, int, float[], int)
	 */
	public void glUniform2fvARB(int location, int count, float[] value, int value_offset) {
		getCurrent().glUniform2fvARB(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @see javax.media.opengl.GL2#glUniform2iARB(int, int, int)
	 */
	public void glUniform2iARB(int location, int v0, int v1) {
		getCurrent().glUniform2iARB(location, v0, v1);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform2ivARB(int, int, java.nio.IntBuffer)
	 */
	public void glUniform2ivARB(int location, int count, IntBuffer value) {
		getCurrent().glUniform2ivARB(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform2ivARB(int, int, int[], int)
	 */
	public void glUniform2ivARB(int location, int count, int[] value, int value_offset) {
		getCurrent().glUniform2ivARB(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @see javax.media.opengl.GL2#glUniform2ui(int, int, int)
	 */
	public void glUniform2ui(int location, int v0, int v1) {
		getCurrent().glUniform2ui(location, v0, v1);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform2uiv(int, int, java.nio.IntBuffer)
	 */
	public void glUniform2uiv(int location, int count, IntBuffer value) {
		getCurrent().glUniform2uiv(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform2uiv(int, int, int[], int)
	 */
	public void glUniform2uiv(int location, int count, int[] value, int value_offset) {
		getCurrent().glUniform2uiv(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glUniform3fARB(int, float, float, float)
	 */
	public void glUniform3fARB(int location, float v0, float v1, float v2) {
		getCurrent().glUniform3fARB(location, v0, v1, v2);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform3fvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glUniform3fvARB(int location, int count, FloatBuffer value) {
		getCurrent().glUniform3fvARB(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform3fvARB(int, int, float[], int)
	 */
	public void glUniform3fvARB(int location, int count, float[] value, int value_offset) {
		getCurrent().glUniform3fvARB(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glUniform3iARB(int, int, int, int)
	 */
	public void glUniform3iARB(int location, int v0, int v1, int v2) {
		getCurrent().glUniform3iARB(location, v0, v1, v2);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform3ivARB(int, int, java.nio.IntBuffer)
	 */
	public void glUniform3ivARB(int location, int count, IntBuffer value) {
		getCurrent().glUniform3ivARB(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform3ivARB(int, int, int[], int)
	 */
	public void glUniform3ivARB(int location, int count, int[] value, int value_offset) {
		getCurrent().glUniform3ivARB(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @param v2
	 * @see javax.media.opengl.GL2#glUniform3ui(int, int, int, int)
	 */
	public void glUniform3ui(int location, int v0, int v1, int v2) {
		getCurrent().glUniform3ui(location, v0, v1, v2);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform3uiv(int, int, java.nio.IntBuffer)
	 */
	public void glUniform3uiv(int location, int count, IntBuffer value) {
		getCurrent().glUniform3uiv(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform3uiv(int, int, int[], int)
	 */
	public void glUniform3uiv(int location, int count, int[] value, int value_offset) {
		getCurrent().glUniform3uiv(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @param v2
	 * @param v3
	 * @see javax.media.opengl.GL2#glUniform4fARB(int, float, float, float, float)
	 */
	public void glUniform4fARB(int location, float v0, float v1, float v2, float v3) {
		getCurrent().glUniform4fARB(location, v0, v1, v2, v3);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform4fvARB(int, int, java.nio.FloatBuffer)
	 */
	public void glUniform4fvARB(int location, int count, FloatBuffer value) {
		getCurrent().glUniform4fvARB(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform4fvARB(int, int, float[], int)
	 */
	public void glUniform4fvARB(int location, int count, float[] value, int value_offset) {
		getCurrent().glUniform4fvARB(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @param v2
	 * @param v3
	 * @see javax.media.opengl.GL2#glUniform4iARB(int, int, int, int, int)
	 */
	public void glUniform4iARB(int location, int v0, int v1, int v2, int v3) {
		getCurrent().glUniform4iARB(location, v0, v1, v2, v3);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform4ivARB(int, int, java.nio.IntBuffer)
	 */
	public void glUniform4ivARB(int location, int count, IntBuffer value) {
		getCurrent().glUniform4ivARB(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform4ivARB(int, int, int[], int)
	 */
	public void glUniform4ivARB(int location, int count, int[] value, int value_offset) {
		getCurrent().glUniform4ivARB(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param v0
	 * @param v1
	 * @param v2
	 * @param v3
	 * @see javax.media.opengl.GL2#glUniform4ui(int, int, int, int, int)
	 */
	public void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
		getCurrent().glUniform4ui(location, v0, v1, v2, v3);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniform4uiv(int, int, java.nio.IntBuffer)
	 */
	public void glUniform4uiv(int location, int count, IntBuffer value) {
		getCurrent().glUniform4uiv(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniform4uiv(int, int, int[], int)
	 */
	public void glUniform4uiv(int location, int count, int[] value, int value_offset) {
		getCurrent().glUniform4uiv(location, count, value, value_offset);
	}

	/**
	 * @param program
	 * @param uniformBlockIndex
	 * @param uniformBlockBinding
	 * @see javax.media.opengl.GL2#glUniformBlockBinding(int, int, int)
	 */
	public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
		getCurrent().glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
	}

	/**
	 * @param program
	 * @param location
	 * @param buffer
	 * @see javax.media.opengl.GL2#glUniformBufferEXT(int, int, int)
	 */
	public void glUniformBufferEXT(int program, int location, int buffer) {
		getCurrent().glUniformBufferEXT(program, location, buffer);
	}

	/**
	 * @param location
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformHandleui64NV(int, long)
	 */
	public void glUniformHandleui64NV(int location, long value) {
		getCurrent().glUniformHandleui64NV(location, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformHandleui64vNV(int, int, java.nio.LongBuffer)
	 */
	public void glUniformHandleui64vNV(int location, int count, LongBuffer value) {
		getCurrent().glUniformHandleui64vNV(location, count, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformHandleui64vNV(int, int, long[], int)
	 */
	public void glUniformHandleui64vNV(int location, int count, long[] value, int value_offset) {
		getCurrent().glUniformHandleui64vNV(location, count, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix2fvARB(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix2fvARB(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix2fvARB(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix2fvARB(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix2fvARB(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix2fvARB(location, count, transpose, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix2x3fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix2x3fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix2x3fv(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix2x3fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix2x3fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix2x3fv(location, count, transpose, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix2x4fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix2x4fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix2x4fv(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix2x4fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix2x4fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix2x4fv(location, count, transpose, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix3fvARB(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix3fvARB(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix3fvARB(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix3fvARB(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix3fvARB(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix3fvARB(location, count, transpose, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix3x2fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix3x2fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix3x2fv(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix3x2fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix3x2fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix3x2fv(location, count, transpose, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix3x4fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix3x4fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix3x4fv(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix3x4fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix3x4fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix3x4fv(location, count, transpose, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix4fvARB(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix4fvARB(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix4fvARB(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix4fvARB(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix4fvARB(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix4fvARB(location, count, transpose, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix4x2fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix4x2fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix4x2fv(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix4x2fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix4x2fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix4x2fv(location, count, transpose, value, value_offset);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @see javax.media.opengl.GL2#glUniformMatrix4x3fv(int, int, boolean, java.nio.FloatBuffer)
	 */
	public void glUniformMatrix4x3fv(int location, int count, boolean transpose, FloatBuffer value) {
		getCurrent().glUniformMatrix4x3fv(location, count, transpose, value);
	}

	/**
	 * @param location
	 * @param count
	 * @param transpose
	 * @param value
	 * @param value_offset
	 * @see javax.media.opengl.GL2#glUniformMatrix4x3fv(int, int, boolean, float[], int)
	 */
	public void glUniformMatrix4x3fv(int location, int count, boolean transpose, float[] value, int value_offset) {
		getCurrent().glUniformMatrix4x3fv(location, count, transpose, value, value_offset);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glUnlockArraysEXT()
	 */
	public void glUnlockArraysEXT() {
		getCurrent().glUnlockArraysEXT();
	}

	/**
	 * @param buffer
	 * @return
	 * @see javax.media.opengl.GL2#glUnmapNamedBufferEXT(int)
	 */
	public boolean glUnmapNamedBufferEXT(int buffer) {
		return getCurrent().glUnmapNamedBufferEXT(buffer);
	}

	/**
	 * @param texture
	 * @param level
	 * @see javax.media.opengl.GL2#glUnmapTexture2DINTEL(int, int)
	 */
	public void glUnmapTexture2DINTEL(int texture, int level) {
		getCurrent().glUnmapTexture2DINTEL(texture, level);
	}

	/**
	 * @param programObj
	 * @see javax.media.opengl.GL2#glUseProgramObjectARB(int)
	 */
	public void glUseProgramObjectARB(int programObj) {
		getCurrent().glUseProgramObjectARB(programObj);
	}

	/**
	 * 
	 * @see javax.media.opengl.GL2#glVDPAUFiniNV()
	 */
	public void glVDPAUFiniNV() {
		getCurrent().glVDPAUFiniNV();
	}

	/**
	 * @param surface
	 * @param pname
	 * @param bufSize
	 * @param length
	 * @param values
	 * @see javax.media.opengl.GL2#glVDPAUGetSurfaceivNV(long, int, int, java.nio.IntBuffer, java.nio.IntBuffer)
	 */
	public void glVDPAUGetSurfaceivNV(long surface, int pname, int bufSize, IntBuffer length, IntBuffer values) {
		getCurrent().glVDPAUGetSurfaceivNV(surface, pname, bufSize, length, values);
	}

	/**
	 * @param surface
	 * @param pname
	 * @param bufSize
	 * @param length
	 * @param length_offset
	 * @param values
	 * @param values_offset
	 * @see javax.media.opengl.GL2#glVDPAUGetSurfaceivNV(long, int, int, int[], int, int[], int)
	 */
	public void glVDPAUGetSurfaceivNV(long surface, int pname, int bufSize, int[] length, int length_offset, int[] values, int values_offset) {
		getCurrent().glVDPAUGetSurfaceivNV(surface, pname, bufSize, length, length_offset, values, values_offset);
	}

	/**
	 * @param vdpDevice
	 * @param getProcAddress
	 * @see javax.media.opengl.GL2#glVDPAUInitNV(java.nio.Buffer, java.nio.Buffer)
	 */
	public void glVDPAUInitNV(Buffer vdpDevice, Buffer getProcAddress) {
		getCurrent().glVDPAUInitNV(vdpDevice, getProcAddress);
	}

	/**
	 * @param surface
	 * @see javax.media.opengl.GL2#glVDPAUIsSurfaceNV(long)
	 */
	public void glVDPAUIsSurfaceNV(long surface) {
		getCurrent().glVDPAUIsSurfaceNV(surface);
	}

	/**
	 * @param numSurfaces
	 * @param surfaces
	 * @see javax.media.opengl.GL2#glVDPAUMapSurfacesNV(int, com.jogamp.common.nio.PointerBuffer)
	 */
	public void glVDPAUMapSurfacesNV(int numSurfaces, PointerBuffer surfaces) {
		getCurrent().glVDPAUMapSurfacesNV(numSurfaces, surfaces);
	}

	/**
	 * @param vdpSurface
	 * @param target
	 * @param numTextureNames
	 * @param textureNames
	 * @return
	 * @see javax.media.opengl.GL2#glVDPAURegisterOutputSurfaceNV(java.nio.Buffer, int, int, java.nio.IntBuffer)
	 */
	public long glVDPAURegisterOutputSurfaceNV(Buffer vdpSurface, int target, int numTextureNames, IntBuffer textureNames) {
		return getCurrent().glVDPAURegisterOutputSurfaceNV(vdpSurface, target, numTextureNames, textureNames);
	}

	/**
	 * @param vdpSurface
	 * @param target
	 * @param numTextureNames
	 * @param textureNames
	 * @param textureNames_offset
	 * @return
	 * @see javax.media.opengl.GL2#glVDPAURegisterOutputSurfaceNV(java.nio.Buffer, int, int, int[], int)
	 */
	public long glVDPAURegisterOutputSurfaceNV(Buffer vdpSurface, int target, int numTextureNames, int[] textureNames, int textureNames_offset) {
		return getCurrent().glVDPAURegisterOutputSurfaceNV(vdpSurface, target, numTextureNames, textureNames, textureNames_offset);
	}

	/**
	 * @param vdpSurface
	 * @param target
	 * @param numTextureNames
	 * @param textureNames
	 * @return
	 * @see javax.media.opengl.GL2#glVDPAURegisterVideoSurfaceNV(java.nio.Buffer, int, int, java.nio.IntBuffer)
	 */
	public long glVDPAURegisterVideoSurfaceNV(Buffer vdpSurface, int target, int numTextureNames, IntBuffer textureNames) {
		return getCurrent().glVDPAURegisterVideoSurfaceNV(vdpSurface, target, numTextureNames, textureNames);
	}

	/**
	 * @param vdpSurface
	 * @param target
	 * @param numTextureNames
	 * @param textureNames
	 * @param textureNames_offset
	 * @return
	 * @see javax.media.opengl.GL2#glVDPAURegisterVideoSurfaceNV(java.nio.Buffer, int, int, int[], int)
	 */
	public long glVDPAURegisterVideoSurfaceNV(Buffer vdpSurface, int target, int numTextureNames, int[] textureNames, int textureNames_offset) {
		return getCurrent().glVDPAURegisterVideoSurfaceNV(vdpSurface, target, numTextureNames, textureNames, textureNames_offset);
	}

	/**
	 * @param surface
	 * @param access
	 * @see javax.media.opengl.GL2#glVDPAUSurfaceAccessNV(long, int)
	 */
	public void glVDPAUSurfaceAccessNV(long surface, int access) {
		getCurrent().glVDPAUSurfaceAccessNV(surface, access);
	}

	/**
	 * @param numSurface
	 * @param surfaces
	 * @see javax.media.opengl.GL2#glVDPAUUnmapSurfacesNV(int, com.jogamp.common.nio.PointerBuffer)
	 */
	public void glVDPAUUnmapSurfacesNV(int numSurface, PointerBuffer surfaces) {
		getCurrent().glVDPAUUnmapSurfacesNV(numSurface, surfaces);
	}

	/**
	 * @param surface
	 * @see javax.media.opengl.GL2#glVDPAUUnregisterSurfaceNV(long)
	 */
	public void glVDPAUUnregisterSurfaceNV(long surface) {
		getCurrent().glVDPAUUnregisterSurfaceNV(surface);
	}

	/**
	 * @param programObj
	 * @see javax.media.opengl.GL2#glValidateProgramARB(int)
	 */
	public void glValidateProgramARB(int programObj) {
		getCurrent().glValidateProgramARB(programObj);
	}

	/**
	 * @param id
	 * @param type
	 * @param stride
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantPointerEXT(int, int, int, java.nio.Buffer)
	 */
	public void glVariantPointerEXT(int id, int type, int stride, Buffer addr) {
		getCurrent().glVariantPointerEXT(id, type, stride, addr);
	}

	/**
	 * @param id
	 * @param type
	 * @param stride
	 * @param addr_buffer_offset
	 * @see javax.media.opengl.GL2#glVariantPointerEXT(int, int, int, long)
	 */
	public void glVariantPointerEXT(int id, int type, int stride, long addr_buffer_offset) {
		getCurrent().glVariantPointerEXT(id, type, stride, addr_buffer_offset);
	}

	/**
	 * @param id
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantbvEXT(int, java.nio.ByteBuffer)
	 */
	public void glVariantbvEXT(int id, ByteBuffer addr) {
		getCurrent().glVariantbvEXT(id, addr);
	}

	/**
	 * @param id
	 * @param addr
	 * @param addr_offset
	 * @see javax.media.opengl.GL2#glVariantbvEXT(int, byte[], int)
	 */
	public void glVariantbvEXT(int id, byte[] addr, int addr_offset) {
		getCurrent().glVariantbvEXT(id, addr, addr_offset);
	}

	/**
	 * @param id
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantdvEXT(int, java.nio.DoubleBuffer)
	 */
	public void glVariantdvEXT(int id, DoubleBuffer addr) {
		getCurrent().glVariantdvEXT(id, addr);
	}

	/**
	 * @param id
	 * @param addr
	 * @param addr_offset
	 * @see javax.media.opengl.GL2#glVariantdvEXT(int, double[], int)
	 */
	public void glVariantdvEXT(int id, double[] addr, int addr_offset) {
		getCurrent().glVariantdvEXT(id, addr, addr_offset);
	}

	/**
	 * @param id
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantfvEXT(int, java.nio.FloatBuffer)
	 */
	public void glVariantfvEXT(int id, FloatBuffer addr) {
		getCurrent().glVariantfvEXT(id, addr);
	}

	/**
	 * @param id
	 * @param addr
	 * @param addr_offset
	 * @see javax.media.opengl.GL2#glVariantfvEXT(int, float[], int)
	 */
	public void glVariantfvEXT(int id, float[] addr, int addr_offset) {
		getCurrent().glVariantfvEXT(id, addr, addr_offset);
	}

	/**
	 * @param id
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantivEXT(int, java.nio.IntBuffer)
	 */
	public void glVariantivEXT(int id, IntBuffer addr) {
		getCurrent().glVariantivEXT(id, addr);
	}

	/**
	 * @param id
	 * @param addr
	 * @param addr_offset
	 * @see javax.media.opengl.GL2#glVariantivEXT(int, int[], int)
	 */
	public void glVariantivEXT(int id, int[] addr, int addr_offset) {
		getCurrent().glVariantivEXT(id, addr, addr_offset);
	}

	/**
	 * @param id
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantsvEXT(int, java.nio.ShortBuffer)
	 */
	public void glVariantsvEXT(int id, ShortBuffer addr) {
		getCurrent().glVariantsvEXT(id, addr);
	}

	/**
	 * @param id
	 * @param addr
	 * @param addr_offset
	 * @see javax.media.opengl.GL2#glVariantsvEXT(int, short[], int)
	 */
	public void glVariantsvEXT(int id, short[] addr, int addr_offset) {
		getCurrent().glVariantsvEXT(id, addr, addr_offset);
	}

	/**
	 * @param id
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantubvEXT(int, java.nio.ByteBuffer)
	 */
	public void glVariantubvEXT(int id, ByteBuffer addr) {
		getCurrent().glVariantubvEXT(id, addr);
	}

	/**
	 * @param id
	 * @param addr
	 * @param addr_offset
	 * @see javax.media.opengl.GL2#glVariantubvEXT(int, byte[], int)
	 */
	public void glVariantubvEXT(int id, byte[] addr, int addr_offset) {
		getCurrent().glVariantubvEXT(id, addr, addr_offset);
	}

	/**
	 * @param id
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantuivEXT(int, java.nio.IntBuffer)
	 */
	public void glVariantuivEXT(int id, IntBuffer addr) {
		getCurrent().glVariantuivEXT(id, addr);
	}

	/**
	 * @param id
	 * @param addr
	 * @param addr_offset
	 * @see javax.media.opengl.GL2#glVariantuivEXT(int, int[], int)
	 */
	public void glVariantuivEXT(int id, int[] addr, int addr_offset) {
		getCurrent().glVariantuivEXT(id, addr, addr_offset);
	}

	/**
	 * @param id
	 * @param addr
	 * @see javax.media.opengl.GL2#glVariantusvEXT(int, java.nio.ShortBuffer)
	 */
	public void glVariantusvEXT(int id, ShortBuffer addr) {
		getCurrent().glVariantusvEXT(id, addr);
	}

	/**
	 * @param id
	 * @param addr
	 * @param addr_offset
	 * @see javax.media.opengl.GL2#glVariantusvEXT(int, short[], int)
	 */
	public void glVariantusvEXT(int id, short[] addr, int addr_offset) {
		getCurrent().glVariantusvEXT(id, addr, addr_offset);
	}

	/**
	 * @param x
	 * @see javax.media.opengl.GL2#glVertex2bOES(byte)
	 */
	public void glVertex2bOES(byte x) {
		getCurrent().glVertex2bOES(x);
	}

	/**
	 * @param coords
	 * @see javax.media.opengl.GL2#glVertex2bvOES(java.nio.ByteBuffer)
	 */
	public void glVertex2bvOES(ByteBuffer coords) {
		getCurrent().glVertex2bvOES(coords);
	}

	/**
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glVertex2bvOES(byte[], int)
	 */
	public void glVertex2bvOES(byte[] coords, int coords_offset) {
		getCurrent().glVertex2bvOES(coords, coords_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertex2d(double, double)
	 */
	public void glVertex2d(double x, double y) {
		getCurrent().glVertex2d(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex2dv(java.nio.DoubleBuffer)
	 */
	public void glVertex2dv(DoubleBuffer v) {
		getCurrent().glVertex2dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex2dv(double[], int)
	 */
	public void glVertex2dv(double[] v, int v_offset) {
		getCurrent().glVertex2dv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertex2f(float, float)
	 */
	public void glVertex2f(float x, float y) {
		getCurrent().glVertex2f(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex2fv(java.nio.FloatBuffer)
	 */
	public void glVertex2fv(FloatBuffer v) {
		getCurrent().glVertex2fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex2fv(float[], int)
	 */
	public void glVertex2fv(float[] v, int v_offset) {
		getCurrent().glVertex2fv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertex2h(short, short)
	 */
	public void glVertex2h(short x, short y) {
		getCurrent().glVertex2h(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex2hv(java.nio.ShortBuffer)
	 */
	public void glVertex2hv(ShortBuffer v) {
		getCurrent().glVertex2hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex2hv(short[], int)
	 */
	public void glVertex2hv(short[] v, int v_offset) {
		getCurrent().glVertex2hv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertex2i(int, int)
	 */
	public void glVertex2i(int x, int y) {
		getCurrent().glVertex2i(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex2iv(java.nio.IntBuffer)
	 */
	public void glVertex2iv(IntBuffer v) {
		getCurrent().glVertex2iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex2iv(int[], int)
	 */
	public void glVertex2iv(int[] v, int v_offset) {
		getCurrent().glVertex2iv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertex2s(short, short)
	 */
	public void glVertex2s(short x, short y) {
		getCurrent().glVertex2s(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex2sv(java.nio.ShortBuffer)
	 */
	public void glVertex2sv(ShortBuffer v) {
		getCurrent().glVertex2sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex2sv(short[], int)
	 */
	public void glVertex2sv(short[] v, int v_offset) {
		getCurrent().glVertex2sv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertex3bOES(byte, byte)
	 */
	public void glVertex3bOES(byte x, byte y) {
		getCurrent().glVertex3bOES(x, y);
	}

	/**
	 * @param coords
	 * @see javax.media.opengl.GL2#glVertex3bvOES(java.nio.ByteBuffer)
	 */
	public void glVertex3bvOES(ByteBuffer coords) {
		getCurrent().glVertex3bvOES(coords);
	}

	/**
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glVertex3bvOES(byte[], int)
	 */
	public void glVertex3bvOES(byte[] coords, int coords_offset) {
		getCurrent().glVertex3bvOES(coords, coords_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertex3d(double, double, double)
	 */
	public void glVertex3d(double x, double y, double z) {
		getCurrent().glVertex3d(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex3dv(java.nio.DoubleBuffer)
	 */
	public void glVertex3dv(DoubleBuffer v) {
		getCurrent().glVertex3dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex3dv(double[], int)
	 */
	public void glVertex3dv(double[] v, int v_offset) {
		getCurrent().glVertex3dv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertex3f(float, float, float)
	 */
	public void glVertex3f(float x, float y, float z) {
		getCurrent().glVertex3f(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex3fv(java.nio.FloatBuffer)
	 */
	public void glVertex3fv(FloatBuffer v) {
		getCurrent().glVertex3fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex3fv(float[], int)
	 */
	public void glVertex3fv(float[] v, int v_offset) {
		getCurrent().glVertex3fv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertex3h(short, short, short)
	 */
	public void glVertex3h(short x, short y, short z) {
		getCurrent().glVertex3h(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex3hv(java.nio.ShortBuffer)
	 */
	public void glVertex3hv(ShortBuffer v) {
		getCurrent().glVertex3hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex3hv(short[], int)
	 */
	public void glVertex3hv(short[] v, int v_offset) {
		getCurrent().glVertex3hv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertex3i(int, int, int)
	 */
	public void glVertex3i(int x, int y, int z) {
		getCurrent().glVertex3i(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex3iv(java.nio.IntBuffer)
	 */
	public void glVertex3iv(IntBuffer v) {
		getCurrent().glVertex3iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex3iv(int[], int)
	 */
	public void glVertex3iv(int[] v, int v_offset) {
		getCurrent().glVertex3iv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertex3s(short, short, short)
	 */
	public void glVertex3s(short x, short y, short z) {
		getCurrent().glVertex3s(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex3sv(java.nio.ShortBuffer)
	 */
	public void glVertex3sv(ShortBuffer v) {
		getCurrent().glVertex3sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex3sv(short[], int)
	 */
	public void glVertex3sv(short[] v, int v_offset) {
		getCurrent().glVertex3sv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertex4bOES(byte, byte, byte)
	 */
	public void glVertex4bOES(byte x, byte y, byte z) {
		getCurrent().glVertex4bOES(x, y, z);
	}

	/**
	 * @param coords
	 * @see javax.media.opengl.GL2#glVertex4bvOES(java.nio.ByteBuffer)
	 */
	public void glVertex4bvOES(ByteBuffer coords) {
		getCurrent().glVertex4bvOES(coords);
	}

	/**
	 * @param coords
	 * @param coords_offset
	 * @see javax.media.opengl.GL2#glVertex4bvOES(byte[], int)
	 */
	public void glVertex4bvOES(byte[] coords, int coords_offset) {
		getCurrent().glVertex4bvOES(coords, coords_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertex4d(double, double, double, double)
	 */
	public void glVertex4d(double x, double y, double z, double w) {
		getCurrent().glVertex4d(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex4dv(java.nio.DoubleBuffer)
	 */
	public void glVertex4dv(DoubleBuffer v) {
		getCurrent().glVertex4dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex4dv(double[], int)
	 */
	public void glVertex4dv(double[] v, int v_offset) {
		getCurrent().glVertex4dv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertex4f(float, float, float, float)
	 */
	public void glVertex4f(float x, float y, float z, float w) {
		getCurrent().glVertex4f(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex4fv(java.nio.FloatBuffer)
	 */
	public void glVertex4fv(FloatBuffer v) {
		getCurrent().glVertex4fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex4fv(float[], int)
	 */
	public void glVertex4fv(float[] v, int v_offset) {
		getCurrent().glVertex4fv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertex4h(short, short, short, short)
	 */
	public void glVertex4h(short x, short y, short z, short w) {
		getCurrent().glVertex4h(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex4hv(java.nio.ShortBuffer)
	 */
	public void glVertex4hv(ShortBuffer v) {
		getCurrent().glVertex4hv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex4hv(short[], int)
	 */
	public void glVertex4hv(short[] v, int v_offset) {
		getCurrent().glVertex4hv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertex4i(int, int, int, int)
	 */
	public void glVertex4i(int x, int y, int z, int w) {
		getCurrent().glVertex4i(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex4iv(java.nio.IntBuffer)
	 */
	public void glVertex4iv(IntBuffer v) {
		getCurrent().glVertex4iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex4iv(int[], int)
	 */
	public void glVertex4iv(int[] v, int v_offset) {
		getCurrent().glVertex4iv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertex4s(short, short, short, short)
	 */
	public void glVertex4s(short x, short y, short z, short w) {
		getCurrent().glVertex4s(x, y, z, w);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glVertex4sv(java.nio.ShortBuffer)
	 */
	public void glVertex4sv(ShortBuffer v) {
		getCurrent().glVertex4sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertex4sv(short[], int)
	 */
	public void glVertex4sv(short[] v, int v_offset) {
		getCurrent().glVertex4sv(v, v_offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param size
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayColorOffsetEXT(int, int, int, int, int, long)
	 */
	public void glVertexArrayColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
		getCurrent().glVertexArrayColorOffsetEXT(vaobj, buffer, size, type, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayEdgeFlagOffsetEXT(int, int, int, long)
	 */
	public void glVertexArrayEdgeFlagOffsetEXT(int vaobj, int buffer, int stride, long offset) {
		getCurrent().glVertexArrayEdgeFlagOffsetEXT(vaobj, buffer, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayFogCoordOffsetEXT(int, int, int, int, long)
	 */
	public void glVertexArrayFogCoordOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
		getCurrent().glVertexArrayFogCoordOffsetEXT(vaobj, buffer, type, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayIndexOffsetEXT(int, int, int, int, long)
	 */
	public void glVertexArrayIndexOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
		getCurrent().glVertexArrayIndexOffsetEXT(vaobj, buffer, type, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param texunit
	 * @param size
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayMultiTexCoordOffsetEXT(int, int, int, int, int, int, long)
	 */
	public void glVertexArrayMultiTexCoordOffsetEXT(int vaobj, int buffer, int texunit, int size, int type, int stride, long offset) {
		getCurrent().glVertexArrayMultiTexCoordOffsetEXT(vaobj, buffer, texunit, size, type, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayNormalOffsetEXT(int, int, int, int, long)
	 */
	public void glVertexArrayNormalOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
		getCurrent().glVertexArrayNormalOffsetEXT(vaobj, buffer, type, stride, offset);
	}

	/**
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glVertexArrayParameteriAPPLE(int, int)
	 */
	public void glVertexArrayParameteriAPPLE(int pname, int param) {
		getCurrent().glVertexArrayParameteriAPPLE(pname, param);
	}

	/**
	 * @param length
	 * @param pointer
	 * @see javax.media.opengl.GL2#glVertexArrayRangeAPPLE(int, java.nio.Buffer)
	 */
	public void glVertexArrayRangeAPPLE(int length, Buffer pointer) {
		getCurrent().glVertexArrayRangeAPPLE(length, pointer);
	}

	/**
	 * @param length
	 * @param pointer
	 * @see javax.media.opengl.GL2#glVertexArrayRangeNV(int, java.nio.Buffer)
	 */
	public void glVertexArrayRangeNV(int length, Buffer pointer) {
		getCurrent().glVertexArrayRangeNV(length, pointer);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param size
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArraySecondaryColorOffsetEXT(int, int, int, int, int, long)
	 */
	public void glVertexArraySecondaryColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
		getCurrent().glVertexArraySecondaryColorOffsetEXT(vaobj, buffer, size, type, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param size
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayTexCoordOffsetEXT(int, int, int, int, int, long)
	 */
	public void glVertexArrayTexCoordOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
		getCurrent().glVertexArrayTexCoordOffsetEXT(vaobj, buffer, size, type, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param index
	 * @param size
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayVertexAttribIOffsetEXT(int, int, int, int, int, int, long)
	 */
	public void glVertexArrayVertexAttribIOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
		getCurrent().glVertexArrayVertexAttribIOffsetEXT(vaobj, buffer, index, size, type, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param index
	 * @param size
	 * @param type
	 * @param normalized
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayVertexAttribOffsetEXT(int, int, int, int, int, boolean, int, long)
	 */
	public void glVertexArrayVertexAttribOffsetEXT(int vaobj, int buffer, int index, int size, int type, boolean normalized, int stride, long offset) {
		getCurrent().glVertexArrayVertexAttribOffsetEXT(vaobj, buffer, index, size, type, normalized, stride, offset);
	}

	/**
	 * @param vaobj
	 * @param buffer
	 * @param size
	 * @param type
	 * @param stride
	 * @param offset
	 * @see javax.media.opengl.GL2#glVertexArrayVertexOffsetEXT(int, int, int, int, int, long)
	 */
	public void glVertexArrayVertexOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
		getCurrent().glVertexArrayVertexOffsetEXT(vaobj, buffer, size, type, stride, offset);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2#glVertexAttrib1dARB(int, double)
	 */
	public void glVertexAttrib1dARB(int index, double x) {
		getCurrent().glVertexAttrib1dARB(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib1dvARB(int, java.nio.DoubleBuffer)
	 */
	public void glVertexAttrib1dvARB(int index, DoubleBuffer v) {
		getCurrent().glVertexAttrib1dvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib1dvARB(int, double[], int)
	 */
	public void glVertexAttrib1dvARB(int index, double[] v, int v_offset) {
		getCurrent().glVertexAttrib1dvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2#glVertexAttrib1fARB(int, float)
	 */
	public void glVertexAttrib1fARB(int index, float x) {
		getCurrent().glVertexAttrib1fARB(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib1fvARB(int, java.nio.FloatBuffer)
	 */
	public void glVertexAttrib1fvARB(int index, FloatBuffer v) {
		getCurrent().glVertexAttrib1fvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib1fvARB(int, float[], int)
	 */
	public void glVertexAttrib1fvARB(int index, float[] v, int v_offset) {
		getCurrent().glVertexAttrib1fvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2#glVertexAttrib1h(int, short)
	 */
	public void glVertexAttrib1h(int index, short x) {
		getCurrent().glVertexAttrib1h(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib1hv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib1hv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib1hv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib1hv(int, short[], int)
	 */
	public void glVertexAttrib1hv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib1hv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2#glVertexAttrib1sARB(int, short)
	 */
	public void glVertexAttrib1sARB(int index, short x) {
		getCurrent().glVertexAttrib1sARB(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib1svARB(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib1svARB(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib1svARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib1svARB(int, short[], int)
	 */
	public void glVertexAttrib1svARB(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib1svARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertexAttrib2dARB(int, double, double)
	 */
	public void glVertexAttrib2dARB(int index, double x, double y) {
		getCurrent().glVertexAttrib2dARB(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib2dvARB(int, java.nio.DoubleBuffer)
	 */
	public void glVertexAttrib2dvARB(int index, DoubleBuffer v) {
		getCurrent().glVertexAttrib2dvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib2dvARB(int, double[], int)
	 */
	public void glVertexAttrib2dvARB(int index, double[] v, int v_offset) {
		getCurrent().glVertexAttrib2dvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertexAttrib2fARB(int, float, float)
	 */
	public void glVertexAttrib2fARB(int index, float x, float y) {
		getCurrent().glVertexAttrib2fARB(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib2fvARB(int, java.nio.FloatBuffer)
	 */
	public void glVertexAttrib2fvARB(int index, FloatBuffer v) {
		getCurrent().glVertexAttrib2fvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib2fvARB(int, float[], int)
	 */
	public void glVertexAttrib2fvARB(int index, float[] v, int v_offset) {
		getCurrent().glVertexAttrib2fvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertexAttrib2h(int, short, short)
	 */
	public void glVertexAttrib2h(int index, short x, short y) {
		getCurrent().glVertexAttrib2h(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib2hv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib2hv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib2hv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib2hv(int, short[], int)
	 */
	public void glVertexAttrib2hv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib2hv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertexAttrib2sARB(int, short, short)
	 */
	public void glVertexAttrib2sARB(int index, short x, short y) {
		getCurrent().glVertexAttrib2sARB(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib2svARB(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib2svARB(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib2svARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib2svARB(int, short[], int)
	 */
	public void glVertexAttrib2svARB(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib2svARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertexAttrib3dARB(int, double, double, double)
	 */
	public void glVertexAttrib3dARB(int index, double x, double y, double z) {
		getCurrent().glVertexAttrib3dARB(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib3dvARB(int, java.nio.DoubleBuffer)
	 */
	public void glVertexAttrib3dvARB(int index, DoubleBuffer v) {
		getCurrent().glVertexAttrib3dvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib3dvARB(int, double[], int)
	 */
	public void glVertexAttrib3dvARB(int index, double[] v, int v_offset) {
		getCurrent().glVertexAttrib3dvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertexAttrib3fARB(int, float, float, float)
	 */
	public void glVertexAttrib3fARB(int index, float x, float y, float z) {
		getCurrent().glVertexAttrib3fARB(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib3fvARB(int, java.nio.FloatBuffer)
	 */
	public void glVertexAttrib3fvARB(int index, FloatBuffer v) {
		getCurrent().glVertexAttrib3fvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib3fvARB(int, float[], int)
	 */
	public void glVertexAttrib3fvARB(int index, float[] v, int v_offset) {
		getCurrent().glVertexAttrib3fvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertexAttrib3h(int, short, short, short)
	 */
	public void glVertexAttrib3h(int index, short x, short y, short z) {
		getCurrent().glVertexAttrib3h(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib3hv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib3hv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib3hv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib3hv(int, short[], int)
	 */
	public void glVertexAttrib3hv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib3hv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertexAttrib3sARB(int, short, short, short)
	 */
	public void glVertexAttrib3sARB(int index, short x, short y, short z) {
		getCurrent().glVertexAttrib3sARB(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib3svARB(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib3svARB(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib3svARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib3svARB(int, short[], int)
	 */
	public void glVertexAttrib3svARB(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib3svARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4NbvARB(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttrib4NbvARB(int index, ByteBuffer v) {
		getCurrent().glVertexAttrib4NbvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4NbvARB(int, byte[], int)
	 */
	public void glVertexAttrib4NbvARB(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttrib4NbvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4NivARB(int, java.nio.IntBuffer)
	 */
	public void glVertexAttrib4NivARB(int index, IntBuffer v) {
		getCurrent().glVertexAttrib4NivARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4NivARB(int, int[], int)
	 */
	public void glVertexAttrib4NivARB(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttrib4NivARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4NsvARB(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4NsvARB(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4NsvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4NsvARB(int, short[], int)
	 */
	public void glVertexAttrib4NsvARB(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4NsvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttrib4NubARB(int, byte, byte, byte, byte)
	 */
	public void glVertexAttrib4NubARB(int index, byte x, byte y, byte z, byte w) {
		getCurrent().glVertexAttrib4NubARB(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4NubvARB(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttrib4NubvARB(int index, ByteBuffer v) {
		getCurrent().glVertexAttrib4NubvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4NubvARB(int, byte[], int)
	 */
	public void glVertexAttrib4NubvARB(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttrib4NubvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4NuivARB(int, java.nio.IntBuffer)
	 */
	public void glVertexAttrib4NuivARB(int index, IntBuffer v) {
		getCurrent().glVertexAttrib4NuivARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4NuivARB(int, int[], int)
	 */
	public void glVertexAttrib4NuivARB(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttrib4NuivARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4NusvARB(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4NusvARB(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4NusvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4NusvARB(int, short[], int)
	 */
	public void glVertexAttrib4NusvARB(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4NusvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4bvARB(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttrib4bvARB(int index, ByteBuffer v) {
		getCurrent().glVertexAttrib4bvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4bvARB(int, byte[], int)
	 */
	public void glVertexAttrib4bvARB(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttrib4bvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttrib4dARB(int, double, double, double, double)
	 */
	public void glVertexAttrib4dARB(int index, double x, double y, double z, double w) {
		getCurrent().glVertexAttrib4dARB(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4dvARB(int, java.nio.DoubleBuffer)
	 */
	public void glVertexAttrib4dvARB(int index, DoubleBuffer v) {
		getCurrent().glVertexAttrib4dvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4dvARB(int, double[], int)
	 */
	public void glVertexAttrib4dvARB(int index, double[] v, int v_offset) {
		getCurrent().glVertexAttrib4dvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttrib4fARB(int, float, float, float, float)
	 */
	public void glVertexAttrib4fARB(int index, float x, float y, float z, float w) {
		getCurrent().glVertexAttrib4fARB(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4fvARB(int, java.nio.FloatBuffer)
	 */
	public void glVertexAttrib4fvARB(int index, FloatBuffer v) {
		getCurrent().glVertexAttrib4fvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4fvARB(int, float[], int)
	 */
	public void glVertexAttrib4fvARB(int index, float[] v, int v_offset) {
		getCurrent().glVertexAttrib4fvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttrib4h(int, short, short, short, short)
	 */
	public void glVertexAttrib4h(int index, short x, short y, short z, short w) {
		getCurrent().glVertexAttrib4h(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4hv(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4hv(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4hv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4hv(int, short[], int)
	 */
	public void glVertexAttrib4hv(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4hv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4ivARB(int, java.nio.IntBuffer)
	 */
	public void glVertexAttrib4ivARB(int index, IntBuffer v) {
		getCurrent().glVertexAttrib4ivARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4ivARB(int, int[], int)
	 */
	public void glVertexAttrib4ivARB(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttrib4ivARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttrib4sARB(int, short, short, short, short)
	 */
	public void glVertexAttrib4sARB(int index, short x, short y, short z, short w) {
		getCurrent().glVertexAttrib4sARB(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4svARB(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4svARB(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4svARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4svARB(int, short[], int)
	 */
	public void glVertexAttrib4svARB(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4svARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4ubvARB(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttrib4ubvARB(int index, ByteBuffer v) {
		getCurrent().glVertexAttrib4ubvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4ubvARB(int, byte[], int)
	 */
	public void glVertexAttrib4ubvARB(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttrib4ubvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4uivARB(int, java.nio.IntBuffer)
	 */
	public void glVertexAttrib4uivARB(int index, IntBuffer v) {
		getCurrent().glVertexAttrib4uivARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4uivARB(int, int[], int)
	 */
	public void glVertexAttrib4uivARB(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttrib4uivARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttrib4usvARB(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttrib4usvARB(int index, ShortBuffer v) {
		getCurrent().glVertexAttrib4usvARB(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttrib4usvARB(int, short[], int)
	 */
	public void glVertexAttrib4usvARB(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttrib4usvARB(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2#glVertexAttribI1iEXT(int, int)
	 */
	public void glVertexAttribI1iEXT(int index, int x) {
		getCurrent().glVertexAttribI1iEXT(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI1ivEXT(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI1ivEXT(int index, IntBuffer v) {
		getCurrent().glVertexAttribI1ivEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI1ivEXT(int, int[], int)
	 */
	public void glVertexAttribI1ivEXT(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI1ivEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2#glVertexAttribI1uiEXT(int, int)
	 */
	public void glVertexAttribI1uiEXT(int index, int x) {
		getCurrent().glVertexAttribI1uiEXT(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI1uivEXT(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI1uivEXT(int index, IntBuffer v) {
		getCurrent().glVertexAttribI1uivEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI1uivEXT(int, int[], int)
	 */
	public void glVertexAttribI1uivEXT(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI1uivEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertexAttribI2iEXT(int, int, int)
	 */
	public void glVertexAttribI2iEXT(int index, int x, int y) {
		getCurrent().glVertexAttribI2iEXT(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI2ivEXT(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI2ivEXT(int index, IntBuffer v) {
		getCurrent().glVertexAttribI2ivEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI2ivEXT(int, int[], int)
	 */
	public void glVertexAttribI2ivEXT(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI2ivEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertexAttribI2uiEXT(int, int, int)
	 */
	public void glVertexAttribI2uiEXT(int index, int x, int y) {
		getCurrent().glVertexAttribI2uiEXT(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI2uivEXT(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI2uivEXT(int index, IntBuffer v) {
		getCurrent().glVertexAttribI2uivEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI2uivEXT(int, int[], int)
	 */
	public void glVertexAttribI2uivEXT(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI2uivEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertexAttribI3iEXT(int, int, int, int)
	 */
	public void glVertexAttribI3iEXT(int index, int x, int y, int z) {
		getCurrent().glVertexAttribI3iEXT(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI3ivEXT(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI3ivEXT(int index, IntBuffer v) {
		getCurrent().glVertexAttribI3ivEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI3ivEXT(int, int[], int)
	 */
	public void glVertexAttribI3ivEXT(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI3ivEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertexAttribI3uiEXT(int, int, int, int)
	 */
	public void glVertexAttribI3uiEXT(int index, int x, int y, int z) {
		getCurrent().glVertexAttribI3uiEXT(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI3uivEXT(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI3uivEXT(int index, IntBuffer v) {
		getCurrent().glVertexAttribI3uivEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI3uivEXT(int, int[], int)
	 */
	public void glVertexAttribI3uivEXT(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI3uivEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI4bvEXT(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttribI4bvEXT(int index, ByteBuffer v) {
		getCurrent().glVertexAttribI4bvEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI4bvEXT(int, byte[], int)
	 */
	public void glVertexAttribI4bvEXT(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttribI4bvEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttribI4i(int, int, int, int, int)
	 */
	public void glVertexAttribI4i(int index, int x, int y, int z, int w) {
		getCurrent().glVertexAttribI4i(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttribI4iEXT(int, int, int, int, int)
	 */
	public void glVertexAttribI4iEXT(int index, int x, int y, int z, int w) {
		getCurrent().glVertexAttribI4iEXT(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI4iv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI4iv(int index, IntBuffer v) {
		getCurrent().glVertexAttribI4iv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI4iv(int, int[], int)
	 */
	public void glVertexAttribI4iv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI4iv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI4ivEXT(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI4ivEXT(int index, IntBuffer v) {
		getCurrent().glVertexAttribI4ivEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI4ivEXT(int, int[], int)
	 */
	public void glVertexAttribI4ivEXT(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI4ivEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI4svEXT(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttribI4svEXT(int index, ShortBuffer v) {
		getCurrent().glVertexAttribI4svEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI4svEXT(int, short[], int)
	 */
	public void glVertexAttribI4svEXT(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttribI4svEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI4ubvEXT(int, java.nio.ByteBuffer)
	 */
	public void glVertexAttribI4ubvEXT(int index, ByteBuffer v) {
		getCurrent().glVertexAttribI4ubvEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI4ubvEXT(int, byte[], int)
	 */
	public void glVertexAttribI4ubvEXT(int index, byte[] v, int v_offset) {
		getCurrent().glVertexAttribI4ubvEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttribI4ui(int, int, int, int, int)
	 */
	public void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
		getCurrent().glVertexAttribI4ui(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttribI4uiEXT(int, int, int, int, int)
	 */
	public void glVertexAttribI4uiEXT(int index, int x, int y, int z, int w) {
		getCurrent().glVertexAttribI4uiEXT(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI4uiv(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI4uiv(int index, IntBuffer v) {
		getCurrent().glVertexAttribI4uiv(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI4uiv(int, int[], int)
	 */
	public void glVertexAttribI4uiv(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI4uiv(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI4uivEXT(int, java.nio.IntBuffer)
	 */
	public void glVertexAttribI4uivEXT(int index, IntBuffer v) {
		getCurrent().glVertexAttribI4uivEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI4uivEXT(int, int[], int)
	 */
	public void glVertexAttribI4uivEXT(int index, int[] v, int v_offset) {
		getCurrent().glVertexAttribI4uivEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribI4usvEXT(int, java.nio.ShortBuffer)
	 */
	public void glVertexAttribI4usvEXT(int index, ShortBuffer v) {
		getCurrent().glVertexAttribI4usvEXT(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribI4usvEXT(int, short[], int)
	 */
	public void glVertexAttribI4usvEXT(int index, short[] v, int v_offset) {
		getCurrent().glVertexAttribI4usvEXT(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glVertexAttribIPointer(int, int, int, int, java.nio.Buffer)
	 */
	public void glVertexAttribIPointer(int index, int size, int type, int stride, Buffer pointer) {
		getCurrent().glVertexAttribIPointer(index, size, type, stride, pointer);
	}

	/**
	 * @param index
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.GL2#glVertexAttribIPointer(int, int, int, int, long)
	 */
	public void glVertexAttribIPointer(int index, int size, int type, int stride, long pointer_buffer_offset) {
		getCurrent().glVertexAttribIPointer(index, size, type, stride, pointer_buffer_offset);
	}

	/**
	 * @param index
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glVertexAttribIPointerEXT(int, int, int, int, java.nio.Buffer)
	 */
	public void glVertexAttribIPointerEXT(int index, int size, int type, int stride, Buffer pointer) {
		getCurrent().glVertexAttribIPointerEXT(index, size, type, stride, pointer);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2#glVertexAttribL1i64NV(int, long)
	 */
	public void glVertexAttribL1i64NV(int index, long x) {
		getCurrent().glVertexAttribL1i64NV(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribL1i64vNV(int, java.nio.LongBuffer)
	 */
	public void glVertexAttribL1i64vNV(int index, LongBuffer v) {
		getCurrent().glVertexAttribL1i64vNV(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribL1i64vNV(int, long[], int)
	 */
	public void glVertexAttribL1i64vNV(int index, long[] v, int v_offset) {
		getCurrent().glVertexAttribL1i64vNV(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @see javax.media.opengl.GL2#glVertexAttribL1ui64NV(int, long)
	 */
	public void glVertexAttribL1ui64NV(int index, long x) {
		getCurrent().glVertexAttribL1ui64NV(index, x);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribL1ui64vNV(int, java.nio.LongBuffer)
	 */
	public void glVertexAttribL1ui64vNV(int index, LongBuffer v) {
		getCurrent().glVertexAttribL1ui64vNV(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribL1ui64vNV(int, long[], int)
	 */
	public void glVertexAttribL1ui64vNV(int index, long[] v, int v_offset) {
		getCurrent().glVertexAttribL1ui64vNV(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertexAttribL2i64NV(int, long, long)
	 */
	public void glVertexAttribL2i64NV(int index, long x, long y) {
		getCurrent().glVertexAttribL2i64NV(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribL2i64vNV(int, java.nio.LongBuffer)
	 */
	public void glVertexAttribL2i64vNV(int index, LongBuffer v) {
		getCurrent().glVertexAttribL2i64vNV(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribL2i64vNV(int, long[], int)
	 */
	public void glVertexAttribL2i64vNV(int index, long[] v, int v_offset) {
		getCurrent().glVertexAttribL2i64vNV(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glVertexAttribL2ui64NV(int, long, long)
	 */
	public void glVertexAttribL2ui64NV(int index, long x, long y) {
		getCurrent().glVertexAttribL2ui64NV(index, x, y);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribL2ui64vNV(int, java.nio.LongBuffer)
	 */
	public void glVertexAttribL2ui64vNV(int index, LongBuffer v) {
		getCurrent().glVertexAttribL2ui64vNV(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribL2ui64vNV(int, long[], int)
	 */
	public void glVertexAttribL2ui64vNV(int index, long[] v, int v_offset) {
		getCurrent().glVertexAttribL2ui64vNV(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertexAttribL3i64NV(int, long, long, long)
	 */
	public void glVertexAttribL3i64NV(int index, long x, long y, long z) {
		getCurrent().glVertexAttribL3i64NV(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribL3i64vNV(int, java.nio.LongBuffer)
	 */
	public void glVertexAttribL3i64vNV(int index, LongBuffer v) {
		getCurrent().glVertexAttribL3i64vNV(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribL3i64vNV(int, long[], int)
	 */
	public void glVertexAttribL3i64vNV(int index, long[] v, int v_offset) {
		getCurrent().glVertexAttribL3i64vNV(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glVertexAttribL3ui64NV(int, long, long, long)
	 */
	public void glVertexAttribL3ui64NV(int index, long x, long y, long z) {
		getCurrent().glVertexAttribL3ui64NV(index, x, y, z);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribL3ui64vNV(int, java.nio.LongBuffer)
	 */
	public void glVertexAttribL3ui64vNV(int index, LongBuffer v) {
		getCurrent().glVertexAttribL3ui64vNV(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribL3ui64vNV(int, long[], int)
	 */
	public void glVertexAttribL3ui64vNV(int index, long[] v, int v_offset) {
		getCurrent().glVertexAttribL3ui64vNV(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttribL4i64NV(int, long, long, long, long)
	 */
	public void glVertexAttribL4i64NV(int index, long x, long y, long z, long w) {
		getCurrent().glVertexAttribL4i64NV(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribL4i64vNV(int, java.nio.LongBuffer)
	 */
	public void glVertexAttribL4i64vNV(int index, LongBuffer v) {
		getCurrent().glVertexAttribL4i64vNV(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribL4i64vNV(int, long[], int)
	 */
	public void glVertexAttribL4i64vNV(int index, long[] v, int v_offset) {
		getCurrent().glVertexAttribL4i64vNV(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @see javax.media.opengl.GL2#glVertexAttribL4ui64NV(int, long, long, long, long)
	 */
	public void glVertexAttribL4ui64NV(int index, long x, long y, long z, long w) {
		getCurrent().glVertexAttribL4ui64NV(index, x, y, z, w);
	}

	/**
	 * @param index
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribL4ui64vNV(int, java.nio.LongBuffer)
	 */
	public void glVertexAttribL4ui64vNV(int index, LongBuffer v) {
		getCurrent().glVertexAttribL4ui64vNV(index, v);
	}

	/**
	 * @param index
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribL4ui64vNV(int, long[], int)
	 */
	public void glVertexAttribL4ui64vNV(int index, long[] v, int v_offset) {
		getCurrent().glVertexAttribL4ui64vNV(index, v, v_offset);
	}

	/**
	 * @param index
	 * @param size
	 * @param type
	 * @param stride
	 * @see javax.media.opengl.GL2#glVertexAttribLFormatNV(int, int, int, int)
	 */
	public void glVertexAttribLFormatNV(int index, int size, int type, int stride) {
		getCurrent().glVertexAttribLFormatNV(index, size, type, stride);
	}

	/**
	 * @param index
	 * @param pname
	 * @param param
	 * @see javax.media.opengl.GL2#glVertexAttribParameteriAMD(int, int, int)
	 */
	public void glVertexAttribParameteriAMD(int index, int pname, int param) {
		getCurrent().glVertexAttribParameteriAMD(index, pname, param);
	}

	/**
	 * @param index
	 * @param size
	 * @param type
	 * @param normalized
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glVertexAttribPointerARB(int, int, int, boolean, int, java.nio.Buffer)
	 */
	public void glVertexAttribPointerARB(int index, int size, int type, boolean normalized, int stride, Buffer pointer) {
		getCurrent().glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
	}

	/**
	 * @param index
	 * @param size
	 * @param type
	 * @param normalized
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.GL2#glVertexAttribPointerARB(int, int, int, boolean, int, long)
	 */
	public void glVertexAttribPointerARB(int index, int size, int type, boolean normalized, int stride, long pointer_buffer_offset) {
		getCurrent().glVertexAttribPointerARB(index, size, type, normalized, stride, pointer_buffer_offset);
	}

	/**
	 * @param index
	 * @param n
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribs1hv(int, int, java.nio.ShortBuffer)
	 */
	public void glVertexAttribs1hv(int index, int n, ShortBuffer v) {
		getCurrent().glVertexAttribs1hv(index, n, v);
	}

	/**
	 * @param index
	 * @param n
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribs1hv(int, int, short[], int)
	 */
	public void glVertexAttribs1hv(int index, int n, short[] v, int v_offset) {
		getCurrent().glVertexAttribs1hv(index, n, v, v_offset);
	}

	/**
	 * @param index
	 * @param n
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribs2hv(int, int, java.nio.ShortBuffer)
	 */
	public void glVertexAttribs2hv(int index, int n, ShortBuffer v) {
		getCurrent().glVertexAttribs2hv(index, n, v);
	}

	/**
	 * @param index
	 * @param n
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribs2hv(int, int, short[], int)
	 */
	public void glVertexAttribs2hv(int index, int n, short[] v, int v_offset) {
		getCurrent().glVertexAttribs2hv(index, n, v, v_offset);
	}

	/**
	 * @param index
	 * @param n
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribs3hv(int, int, java.nio.ShortBuffer)
	 */
	public void glVertexAttribs3hv(int index, int n, ShortBuffer v) {
		getCurrent().glVertexAttribs3hv(index, n, v);
	}

	/**
	 * @param index
	 * @param n
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribs3hv(int, int, short[], int)
	 */
	public void glVertexAttribs3hv(int index, int n, short[] v, int v_offset) {
		getCurrent().glVertexAttribs3hv(index, n, v, v_offset);
	}

	/**
	 * @param index
	 * @param n
	 * @param v
	 * @see javax.media.opengl.GL2#glVertexAttribs4hv(int, int, java.nio.ShortBuffer)
	 */
	public void glVertexAttribs4hv(int index, int n, ShortBuffer v) {
		getCurrent().glVertexAttribs4hv(index, n, v);
	}

	/**
	 * @param index
	 * @param n
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glVertexAttribs4hv(int, int, short[], int)
	 */
	public void glVertexAttribs4hv(int index, int n, short[] v, int v_offset) {
		getCurrent().glVertexAttribs4hv(index, n, v, v_offset);
	}

	/**
	 * @param count
	 * @see javax.media.opengl.GL2#glVertexBlendARB(int)
	 */
	public void glVertexBlendARB(int count) {
		getCurrent().glVertexBlendARB(count);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glVertexWeightPointerEXT(int, int, int, java.nio.Buffer)
	 */
	public void glVertexWeightPointerEXT(int size, int type, int stride, Buffer pointer) {
		getCurrent().glVertexWeightPointerEXT(size, type, stride, pointer);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer_buffer_offset
	 * @see javax.media.opengl.GL2#glVertexWeightPointerEXT(int, int, int, long)
	 */
	public void glVertexWeightPointerEXT(int size, int type, int stride, long pointer_buffer_offset) {
		getCurrent().glVertexWeightPointerEXT(size, type, stride, pointer_buffer_offset);
	}

	/**
	 * @param weight
	 * @see javax.media.opengl.GL2#glVertexWeightfEXT(float)
	 */
	public void glVertexWeightfEXT(float weight) {
		getCurrent().glVertexWeightfEXT(weight);
	}

	/**
	 * @param weight
	 * @see javax.media.opengl.GL2#glVertexWeightfvEXT(java.nio.FloatBuffer)
	 */
	public void glVertexWeightfvEXT(FloatBuffer weight) {
		getCurrent().glVertexWeightfvEXT(weight);
	}

	/**
	 * @param weight
	 * @param weight_offset
	 * @see javax.media.opengl.GL2#glVertexWeightfvEXT(float[], int)
	 */
	public void glVertexWeightfvEXT(float[] weight, int weight_offset) {
		getCurrent().glVertexWeightfvEXT(weight, weight_offset);
	}

	/**
	 * @param weight
	 * @see javax.media.opengl.GL2#glVertexWeighth(short)
	 */
	public void glVertexWeighth(short weight) {
		getCurrent().glVertexWeighth(weight);
	}

	/**
	 * @param weight
	 * @see javax.media.opengl.GL2#glVertexWeighthv(java.nio.ShortBuffer)
	 */
	public void glVertexWeighthv(ShortBuffer weight) {
		getCurrent().glVertexWeighthv(weight);
	}

	/**
	 * @param weight
	 * @param weight_offset
	 * @see javax.media.opengl.GL2#glVertexWeighthv(short[], int)
	 */
	public void glVertexWeighthv(short[] weight, int weight_offset) {
		getCurrent().glVertexWeighthv(weight, weight_offset);
	}

	/**
	 * @param video_capture_slot
	 * @param sequence_num
	 * @param capture_time
	 * @return
	 * @see javax.media.opengl.GL2#glVideoCaptureNV(int, java.nio.IntBuffer, java.nio.LongBuffer)
	 */
	public int glVideoCaptureNV(int video_capture_slot, IntBuffer sequence_num, LongBuffer capture_time) {
		return getCurrent().glVideoCaptureNV(video_capture_slot, sequence_num, capture_time);
	}

	/**
	 * @param video_capture_slot
	 * @param sequence_num
	 * @param sequence_num_offset
	 * @param capture_time
	 * @param capture_time_offset
	 * @return
	 * @see javax.media.opengl.GL2#glVideoCaptureNV(int, int[], int, long[], int)
	 */
	public int glVideoCaptureNV(int video_capture_slot, int[] sequence_num, int sequence_num_offset, long[] capture_time, int capture_time_offset) {
		return getCurrent().glVideoCaptureNV(video_capture_slot, sequence_num, sequence_num_offset, capture_time, capture_time_offset);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glVideoCaptureStreamParameterdvNV(int, int, int, java.nio.DoubleBuffer)
	 */
	public void glVideoCaptureStreamParameterdvNV(int video_capture_slot, int stream, int pname, DoubleBuffer params) {
		getCurrent().glVideoCaptureStreamParameterdvNV(video_capture_slot, stream, pname, params);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glVideoCaptureStreamParameterdvNV(int, int, int, double[], int)
	 */
	public void glVideoCaptureStreamParameterdvNV(int video_capture_slot, int stream, int pname, double[] params, int params_offset) {
		getCurrent().glVideoCaptureStreamParameterdvNV(video_capture_slot, stream, pname, params, params_offset);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glVideoCaptureStreamParameterfvNV(int, int, int, java.nio.FloatBuffer)
	 */
	public void glVideoCaptureStreamParameterfvNV(int video_capture_slot, int stream, int pname, FloatBuffer params) {
		getCurrent().glVideoCaptureStreamParameterfvNV(video_capture_slot, stream, pname, params);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glVideoCaptureStreamParameterfvNV(int, int, int, float[], int)
	 */
	public void glVideoCaptureStreamParameterfvNV(int video_capture_slot, int stream, int pname, float[] params, int params_offset) {
		getCurrent().glVideoCaptureStreamParameterfvNV(video_capture_slot, stream, pname, params, params_offset);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @see javax.media.opengl.GL2#glVideoCaptureStreamParameterivNV(int, int, int, java.nio.IntBuffer)
	 */
	public void glVideoCaptureStreamParameterivNV(int video_capture_slot, int stream, int pname, IntBuffer params) {
		getCurrent().glVideoCaptureStreamParameterivNV(video_capture_slot, stream, pname, params);
	}

	/**
	 * @param video_capture_slot
	 * @param stream
	 * @param pname
	 * @param params
	 * @param params_offset
	 * @see javax.media.opengl.GL2#glVideoCaptureStreamParameterivNV(int, int, int, int[], int)
	 */
	public void glVideoCaptureStreamParameterivNV(int video_capture_slot, int stream, int pname, int[] params, int params_offset) {
		getCurrent().glVideoCaptureStreamParameterivNV(video_capture_slot, stream, pname, params, params_offset);
	}

	/**
	 * @param resultPath
	 * @param numPaths
	 * @param paths
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightPathsNV(int, int, java.nio.IntBuffer, java.nio.FloatBuffer)
	 */
	public void glWeightPathsNV(int resultPath, int numPaths, IntBuffer paths, FloatBuffer weights) {
		getCurrent().glWeightPathsNV(resultPath, numPaths, paths, weights);
	}

	/**
	 * @param resultPath
	 * @param numPaths
	 * @param paths
	 * @param paths_offset
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightPathsNV(int, int, int[], int, float[], int)
	 */
	public void glWeightPathsNV(int resultPath, int numPaths, int[] paths, int paths_offset, float[] weights, int weights_offset) {
		getCurrent().glWeightPathsNV(resultPath, numPaths, paths, paths_offset, weights, weights_offset);
	}

	/**
	 * @param size
	 * @param type
	 * @param stride
	 * @param pointer
	 * @see javax.media.opengl.GL2#glWeightPointer(int, int, int, java.nio.Buffer)
	 */
	public void glWeightPointer(int size, int type, int stride, Buffer pointer) {
		getCurrent().glWeightPointer(size, type, stride, pointer);
	}

	/**
	 * @param size
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightbvARB(int, java.nio.ByteBuffer)
	 */
	public void glWeightbvARB(int size, ByteBuffer weights) {
		getCurrent().glWeightbvARB(size, weights);
	}

	/**
	 * @param size
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightbvARB(int, byte[], int)
	 */
	public void glWeightbvARB(int size, byte[] weights, int weights_offset) {
		getCurrent().glWeightbvARB(size, weights, weights_offset);
	}

	/**
	 * @param size
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightdvARB(int, java.nio.DoubleBuffer)
	 */
	public void glWeightdvARB(int size, DoubleBuffer weights) {
		getCurrent().glWeightdvARB(size, weights);
	}

	/**
	 * @param size
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightdvARB(int, double[], int)
	 */
	public void glWeightdvARB(int size, double[] weights, int weights_offset) {
		getCurrent().glWeightdvARB(size, weights, weights_offset);
	}

	/**
	 * @param size
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightfvARB(int, java.nio.FloatBuffer)
	 */
	public void glWeightfvARB(int size, FloatBuffer weights) {
		getCurrent().glWeightfvARB(size, weights);
	}

	/**
	 * @param size
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightfvARB(int, float[], int)
	 */
	public void glWeightfvARB(int size, float[] weights, int weights_offset) {
		getCurrent().glWeightfvARB(size, weights, weights_offset);
	}

	/**
	 * @param size
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightivARB(int, java.nio.IntBuffer)
	 */
	public void glWeightivARB(int size, IntBuffer weights) {
		getCurrent().glWeightivARB(size, weights);
	}

	/**
	 * @param size
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightivARB(int, int[], int)
	 */
	public void glWeightivARB(int size, int[] weights, int weights_offset) {
		getCurrent().glWeightivARB(size, weights, weights_offset);
	}

	/**
	 * @param size
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightsvARB(int, java.nio.ShortBuffer)
	 */
	public void glWeightsvARB(int size, ShortBuffer weights) {
		getCurrent().glWeightsvARB(size, weights);
	}

	/**
	 * @param size
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightsvARB(int, short[], int)
	 */
	public void glWeightsvARB(int size, short[] weights, int weights_offset) {
		getCurrent().glWeightsvARB(size, weights, weights_offset);
	}

	/**
	 * @param size
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightubvARB(int, java.nio.ByteBuffer)
	 */
	public void glWeightubvARB(int size, ByteBuffer weights) {
		getCurrent().glWeightubvARB(size, weights);
	}

	/**
	 * @param size
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightubvARB(int, byte[], int)
	 */
	public void glWeightubvARB(int size, byte[] weights, int weights_offset) {
		getCurrent().glWeightubvARB(size, weights, weights_offset);
	}

	/**
	 * @param size
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightuivARB(int, java.nio.IntBuffer)
	 */
	public void glWeightuivARB(int size, IntBuffer weights) {
		getCurrent().glWeightuivARB(size, weights);
	}

	/**
	 * @param size
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightuivARB(int, int[], int)
	 */
	public void glWeightuivARB(int size, int[] weights, int weights_offset) {
		getCurrent().glWeightuivARB(size, weights, weights_offset);
	}

	/**
	 * @param size
	 * @param weights
	 * @see javax.media.opengl.GL2#glWeightusvARB(int, java.nio.ShortBuffer)
	 */
	public void glWeightusvARB(int size, ShortBuffer weights) {
		getCurrent().glWeightusvARB(size, weights);
	}

	/**
	 * @param size
	 * @param weights
	 * @param weights_offset
	 * @see javax.media.opengl.GL2#glWeightusvARB(int, short[], int)
	 */
	public void glWeightusvARB(int size, short[] weights, int weights_offset) {
		getCurrent().glWeightusvARB(size, weights, weights_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glWindowPos2d(double, double)
	 */
	public void glWindowPos2d(double x, double y) {
		getCurrent().glWindowPos2d(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glWindowPos2dv(java.nio.DoubleBuffer)
	 */
	public void glWindowPos2dv(DoubleBuffer v) {
		getCurrent().glWindowPos2dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glWindowPos2dv(double[], int)
	 */
	public void glWindowPos2dv(double[] v, int v_offset) {
		getCurrent().glWindowPos2dv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glWindowPos2f(float, float)
	 */
	public void glWindowPos2f(float x, float y) {
		getCurrent().glWindowPos2f(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glWindowPos2fv(java.nio.FloatBuffer)
	 */
	public void glWindowPos2fv(FloatBuffer v) {
		getCurrent().glWindowPos2fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glWindowPos2fv(float[], int)
	 */
	public void glWindowPos2fv(float[] v, int v_offset) {
		getCurrent().glWindowPos2fv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glWindowPos2i(int, int)
	 */
	public void glWindowPos2i(int x, int y) {
		getCurrent().glWindowPos2i(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glWindowPos2iv(java.nio.IntBuffer)
	 */
	public void glWindowPos2iv(IntBuffer v) {
		getCurrent().glWindowPos2iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glWindowPos2iv(int[], int)
	 */
	public void glWindowPos2iv(int[] v, int v_offset) {
		getCurrent().glWindowPos2iv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @see javax.media.opengl.GL2#glWindowPos2s(short, short)
	 */
	public void glWindowPos2s(short x, short y) {
		getCurrent().glWindowPos2s(x, y);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glWindowPos2sv(java.nio.ShortBuffer)
	 */
	public void glWindowPos2sv(ShortBuffer v) {
		getCurrent().glWindowPos2sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glWindowPos2sv(short[], int)
	 */
	public void glWindowPos2sv(short[] v, int v_offset) {
		getCurrent().glWindowPos2sv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glWindowPos3d(double, double, double)
	 */
	public void glWindowPos3d(double x, double y, double z) {
		getCurrent().glWindowPos3d(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glWindowPos3dv(java.nio.DoubleBuffer)
	 */
	public void glWindowPos3dv(DoubleBuffer v) {
		getCurrent().glWindowPos3dv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glWindowPos3dv(double[], int)
	 */
	public void glWindowPos3dv(double[] v, int v_offset) {
		getCurrent().glWindowPos3dv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glWindowPos3f(float, float, float)
	 */
	public void glWindowPos3f(float x, float y, float z) {
		getCurrent().glWindowPos3f(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glWindowPos3fv(java.nio.FloatBuffer)
	 */
	public void glWindowPos3fv(FloatBuffer v) {
		getCurrent().glWindowPos3fv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glWindowPos3fv(float[], int)
	 */
	public void glWindowPos3fv(float[] v, int v_offset) {
		getCurrent().glWindowPos3fv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glWindowPos3i(int, int, int)
	 */
	public void glWindowPos3i(int x, int y, int z) {
		getCurrent().glWindowPos3i(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glWindowPos3iv(java.nio.IntBuffer)
	 */
	public void glWindowPos3iv(IntBuffer v) {
		getCurrent().glWindowPos3iv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glWindowPos3iv(int[], int)
	 */
	public void glWindowPos3iv(int[] v, int v_offset) {
		getCurrent().glWindowPos3iv(v, v_offset);
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 * @see javax.media.opengl.GL2#glWindowPos3s(short, short, short)
	 */
	public void glWindowPos3s(short x, short y, short z) {
		getCurrent().glWindowPos3s(x, y, z);
	}

	/**
	 * @param v
	 * @see javax.media.opengl.GL2#glWindowPos3sv(java.nio.ShortBuffer)
	 */
	public void glWindowPos3sv(ShortBuffer v) {
		getCurrent().glWindowPos3sv(v);
	}

	/**
	 * @param v
	 * @param v_offset
	 * @see javax.media.opengl.GL2#glWindowPos3sv(short[], int)
	 */
	public void glWindowPos3sv(short[] v, int v_offset) {
		getCurrent().glWindowPos3sv(v, v_offset);
	}

	/**
	 * @param res
	 * @param in
	 * @param outX
	 * @param outY
	 * @param outZ
	 * @param outW
	 * @see javax.media.opengl.GL2#glWriteMaskEXT(int, int, int, int, int, int)
	 */
	public void glWriteMaskEXT(int res, int in, int outX, int outY, int outZ, int outW) {
		getCurrent().glWriteMaskEXT(res, in, outX, outY, outZ, outW);
	}

	/**
	 * @param size
	 * @param readFrequency
	 * @param writeFrequency
	 * @param priority
	 * @return
	 * @see javax.media.opengl.GL2#glAllocateMemoryNV(int, float, float, float)
	 */
	public ByteBuffer glAllocateMemoryNV(int size, float readFrequency, float writeFrequency, float priority) {
		return getCurrent().glAllocateMemoryNV(size, readFrequency, writeFrequency, priority);
	}

	/**
	 * @param pointer
	 * @see javax.media.opengl.GL2#glFreeMemoryNV(java.nio.ByteBuffer)
	 */
	public void glFreeMemoryNV(ByteBuffer pointer) {
		getCurrent().glFreeMemoryNV(pointer);
	}
	
	
	
}
