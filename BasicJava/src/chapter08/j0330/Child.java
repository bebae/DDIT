package chapter08.j0330;

public class Child extends Parent {
	String name;
	
	void run() {
		System.out.println(name+"?");
	}
	public void setName(String name) {
		this.name = name;
	}
}
