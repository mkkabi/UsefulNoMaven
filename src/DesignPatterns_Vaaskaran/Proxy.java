package DesignPatterns_Vaaskaran;

abstract class Subject_1 {
	public abstract void doSomeWork();
}

class ConcreteSubject_1 extends Subject_1 {
	@Override
	public void doSomeWork() {
		System.out.println(" I am from concrete subject");
	}
}

public class Proxy extends Subject_1 {
	ConcreteSubject_1 cs;

	@Override
	public void doSomeWork() {
		System.out.println("Proxy call happening now");
		//Lazy initialization 
		if (cs == null) {
			cs = new ConcreteSubject_1();
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
