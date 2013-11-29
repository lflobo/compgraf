package pt.ipb.esact.compgraf.aulas.a09;

import pt.ipb.esact.compgraf.engine.obj.ObjLoader;

public class Test {

	public Test() {
		ObjLoader obj = new ObjLoader();
		obj.load(this, "jarvis/jarvis.obj", "jarvis/jarvis.mtl");
	}
	
	public static void main(String[] args) {
		new Test();
	}
	
}
