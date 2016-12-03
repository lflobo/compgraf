varying vec3 v_Norm;
varying vec3 v_ToLight;

void main()
{
    // use color determined in vertex shader
    gl_FragColor = gl_Color;
}