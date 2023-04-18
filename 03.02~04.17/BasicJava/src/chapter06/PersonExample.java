package chapter06;

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

public class PersonExample {
	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 20);
//		p1.setName("홍길동");
//		p1.setAge(20);
		System.out.println(p1.getName()+" "+p1.getAge());
		Person p2 = new Person("신용권", 25);
//		p2.setName("신용권");
//		p2.setAge(25);
		System.out.println(p2.getName()+" "+p2.getAge());
		
	}
}
