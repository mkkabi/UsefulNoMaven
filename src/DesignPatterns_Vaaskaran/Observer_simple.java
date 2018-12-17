package DesignPatterns_Vaaskaran;

import java.util.*;

class Observer_simple {

	public void update() {
		System.out.println("flag value changed in Subject");
	}
}

interface ISubject_s {

	void register(Observer_simple o);

	void unregister(Observer_simple o);

	void notifyObservers();
}

class Subject_s implements ISubject_s {

	List<Observer_simple> observerList = new ArrayList<Observer_simple>();
	private int _flag;

	public int getFlag() {
		return _flag;
	}

	public void setFlag(int _flag) {
		this._flag = _flag;
		//flag value changed .So notify observer(s) 
		notifyObservers();
	}

	@Override
	public void register(Observer_simple o) {
		observerList.add(o);
	}

	@Override
	public void unregister(Observer_simple o) {
		observerList.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observerList.size(); i++) {
			observerList.get(i).update();
		}
	}
}

class ObserverPatternEx {

	public static void main(String[] args) {
		System.out.println("***Observer Pattern Demo***\n");
		Observer_simple o1 = new Observer_simple();
		Subject_s sub1 = new Subject_s();
		sub1.register(o1);
		System.out.println("Setting Flag = 5 ");
		sub1.setFlag(5);
		System.out.println("Setting Flag = 25 ");
		sub1.setFlag(25);
		sub1.unregister(o1);
		//No notification this time to o1 .Since it is unregistered. 
		System.out.println("Setting Flag = 50 ");
		sub1.setFlag(50);
	}
}
