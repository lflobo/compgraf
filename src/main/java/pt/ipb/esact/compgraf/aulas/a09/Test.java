package pt.ipb.esact.compgraf.aulas.a09;

import pt.ipb.esact.compgraf.engine.obj.Obj;

public class Test {

	public Test() {
		Obj obj = new Obj();
		obj.load(this, "jarvis/jarvis.obj", "jarvis/jarvis.mtl");
	}
	
	public static void main(String[] args) {
		new Test();
	}
	
}
