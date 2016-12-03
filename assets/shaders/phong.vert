varying vec3 v_Norm;
varying vec3 v_ToLight;

void main()
{
    /* use material color */
	gl_FrontColor = gl_Color;
    gl_FrontSecondaryColor = gl_SecondaryColor;
    gl_BackColor = gl_Color;
    gl_BackSecondaryColor = gl_SecondaryColor;

    /* determine position, normal and light vector */
	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
	v_Norm = gl_NormalMatrix * gl_Normal;
	v_ToLight = vec3(gl_LightSource[0].position - (gl_ModelViewMatrix * gl_Vertex));
}