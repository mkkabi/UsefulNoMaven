package DesignPatterns;
 
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

class PeopleObserver implements Observer {

	private String name;

	public PeopleObserver() {
		super();
	}

	public PeopleObserver(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(name + " got "
				+ ((Integer) arg).intValue() + " winks");
	}
}

class PeopleObservable extends Observable {

	private String name;

	public PeopleObservable() {
		super();
	}

	public PeopleObservable(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void wink(int count) {
		setChanged();
		notifyObservers(count);
	}
}

 public class Observable_Observer_Java_1{
	 public static void main(String[] args) {

      PeopleObservable damsel = new PeopleObservable("Minnie");

      PeopleObserver mickey = new PeopleObserver("Mickey");

      PeopleObserver donald = new PeopleObserver("Donald");

      PeopleObserver guffy = new PeopleObserver("Goofy");

      damsel.addObserver(mickey);
      damsel.addObserver(donald);
      damsel.addObserver(guffy);

      System.out.println("There are " + damsel.countObservers()
                                      + " observers of "
                                      + damsel.getName());

      Random r = new Random();
      damsel.wink(r.nextInt(10));
   }
 }