package DesignPatterns_Vaaskaran;

import java.util.*;

interface IObserver3_3 {
	void update(String s, int i);
}

class Observer1_3 implements IObserver3_3 {
	@Override
	public void update(String s, int i) {
		System.out.println("Observer1_3: myValue in " + s + " is now: " + i);
	}
}

class Observer2_3 implements IObserver3_3 {

	@Override
	public void update(String s, int i) {
		System.out.println("Observer2_3: observes ->myValue is changed in " + s + " to :" + i);
	}
}

class Observer3_3 implements IObserver3_3 {

	@Override
	public void update(String s, int i) {
		System.out.println("Observer3_3 is observing:myValue is changed in " + s + " to :" + i);
	}
}

interface ISubject_3 {
	void register(IObserver3_3 o);
	void unregister(IObserver3_3 o);
	void notifyObservers(int i);
}

class Subject1 implements ISubject_3 {
	private int myValue;
	public int getMyValue() {
		return myValue;
	}

	public void setMyValue(int myValue) {
		this.myValue = myValue;
		//Notify observers 
		notifyObservers(myValue);
	}
	List<IObserver3_3> observersList = new ArrayList<IObserver3_3>();

	@Override
	public void register(IObserver3_3 o) {
		observersList.add(o);
	}

	@Override
	public void unregister(IObserver3_3 o) {
		observersList.remove(o);
	}

	@Override
	public void notifyObservers(int updatedValue) {
		for (int i = 0; i < observersList.size(); i++) {
			observersList.get(i).update(this.getClass().getSimpleName(), updatedValue);
		}
	}
}

class Subject2 implements ISubject_3 {
	private int myValue;
	public int getMyValue() {
		return myValue;
	}

	public void setMyValue(int myValue) {
		this.myValue = myValue;
		//Notify observers 
		notifyObservers(myValue);
	}
	List<IObserver3_3> observersList = new ArrayList<IObserver3_3>();

	@Override
	public void register(IObserver3_3 o) {
		observersList.add(o);
	}

	@Override
	public void unregister(IObserver3_3 o) {
		observersList.remove(o);
	}

	@Override
	public void notifyObservers(int updatedValue) {
		for (int i = 0; i < observersList.size(); i++) {
			observersList.get(i).update(this.getClass().getSimpleName(), updatedValue);
		}
	}
}

class ObserverPatternDemo3Ex {

	public static void main(String[] args) {
		System.out.println("*** Observer Pattern Demo3***\n");
		Subject1 sub1 = new Subject1();
		Subject2 sub2 = new Subject2();
		Observer1_3 ob1 = new Observer1_3();
		Observer2_3 ob2 = new Observer2_3();
		Observer3_3 ob3 = new Observer3_3();
		//Observer1_3 and Observer2_3 registers to //Subject 1 
		sub1.register(ob1);
		sub1.register(ob2);
		//Observer2_3 and Observer3_3 registers to //Subject 2 
		sub2.register(ob2);
		sub2.register(ob3);
		//Set new value to Subject 1 
		//Observer1_3 and Observer2_3 get //notification 
		sub1.setMyValue(50);
		System.out.println();
		//Set new value to Subject 2 
		//Observer2_3 and Observer3_3 get //notification 
		sub2.setMyValue(250);
		System.out.println();
		//unregister Observer2_3 from Subject 1 
		sub1.unregister(ob2);
		//Set new value to Subject & only //Observer1_3 is notified 
		sub1.setMyValue(550);
		System.out.println();
		//ob2 can still notice change in //Subject 2 
		sub2.setMyValue(750);
	}
}
