package DesignPatterns;

abstract class Subject {
	public abstract void doSomeWork();
}

class ConcreteSubject extends Subject {
	@Override
	public void doSomeWork() {
		System.out.println(" I am from concrete subject");
	}
}

public class Proxy extends Subject {
	ConcreteSubject cs;

	@Override
	public void doSomeWork() {
		System.out.println("Proxy call happening now");
		//Lazy initialization 
		if (cs == null) {
			cs = new ConcreteSubject();
		}
		cs.doSomeWork();
	}
}

class ProxyPatternEx {

	public static void main(String[] args) {
		System.out.println("***Proxy Pattern Demo***\n");
		Proxy px = new Proxy();
		px.doSomeWork();
	}
}
