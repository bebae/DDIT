package chapter07.exam03;

public class AnimalExample {
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		System.out.println("-------");
		
		Animal animal = null;
		animal = dog;
		animal.sound();
		animal.breathe();
		animal = cat;
		animal.sound();
		System.out.println("-------");
		
		ainmalSound(new Dog());
		ainmalSound(new Cat());
	}
	
	public static void ainmalSound(Animal animal) {
		animal.sound();
	}
}
