varying vec3 v_Norm;
varying vec3 v_ToLight;

void main()
{
	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
	v_Norm = gl_NormalMatrix * gl_Normal;
	v_ToLight = vec3(gl_LightSource[0].position - (gl_ModelViewMatrix * gl_Vertex));
}