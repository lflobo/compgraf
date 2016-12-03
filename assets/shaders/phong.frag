varying vec3 v_Norm;
varying vec3 v_ToLight;

void main()
{
	vec4 DiffuseColor = gl_Color;
	float diff = clamp(dot(normalize(v_Norm), normalize(v_ToLight)), 0.0, 1.0);
	gl_FragColor = DiffuseColor * diff;
}