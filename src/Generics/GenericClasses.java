
package Generics;

public class GenericClasses {
	Animal animal = new Animal(213, "asdf");
}

class Animal{
	// Constructor that takes generic type
	public <C> Animal(C c, String s){	}
	
	// for generics that implement interfaces need to use EXTEND keyword
	// this method will only accept classes that implement interface Walkable
	public <T extends Walkable> void processWalkable(T t){
		t.walk();
	}

}

// Declare generic variable in class to use it in methods
class Dot<T>{
	public void foo(T t){
		System.out.println(t);
	}
}

class Mouse implements Walkable{
	@Override
	public void walk(){System.out.println("walking mouse");}
}

class Cat{
	// when used with method, has to be declared before return type
	public <T> void foo(T t){
		System.out.println(t);
	}
}

interface Walkable{
	public void walk();
}