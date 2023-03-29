package chapter08.exam01;

public class AnimalExample {
	public static void main(String[] args) {
		
		Animal dog = new Dog();
		Animal cat = new Cat();
		
		System.out.println(dog.sound());
		System.out.println(cat.sound());
		System.out.println("-------");
		
		
		ainmalSound(new Dog());
		ainmalSound(new Cat());
	}
	
	public static void ainmalSound(Animal animal) {
		System.out.println(animal.sound());
	}
}
