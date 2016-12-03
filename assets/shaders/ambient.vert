void main()
{
    /* use material color */
	gl_FrontColor = gl_Color;
    gl_FrontSecondaryColor = gl_SecondaryColor;
    gl_BackColor = gl_Color;
    gl_BackSecondaryColor = gl_SecondaryColor;

    /* transform vector to display coordinates */
	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
}