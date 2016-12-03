void main()
{
    /* use material color */
	gl_FrontColor = gl_Color;
    gl_FrontSecondaryColor = gl_SecondaryColor;
    gl_BackColor = gl_Color;
    gl_BackSecondaryColor = gl_SecondaryColor;

    /* transform vector to display coordinates */
    vec4 myVertex = gl_Vertex;
	gl_Position = gl_ModelViewProjectionMatrix * myVertex;
}