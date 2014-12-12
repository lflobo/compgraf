varying vec3 v_Norm;
varying vec3 v_ToLight;

void main()
{
	const vec3 DiffuseColor = vec3(0.2, 0.6, 0.8);
	float diff = clamp(dot(normalize(v_Norm), normalize(v_ToLight)), 0.0, 1.0);
	gl_FragColor = vec4(DiffuseColor * diff, 1.0);
}