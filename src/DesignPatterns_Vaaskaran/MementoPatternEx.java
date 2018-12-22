package DesignPatterns_Vaaskaran;

/*
1.We are advised to treat the memento object as an opaque object (i.e., ideally, 
caretakers should not be allowed to change them).
2.We should pay special attention so that other objects are not affected by the 
change made in the originator to the memento.
3.Sometimes, use of this pattern can cost more (e.g., if we want to store and 
restore large amount of data frequently). Also, from a caretaker point of view, 
the caretaker has no idea about how much state is kept in the memento that it wants to delete.
*/

class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}

class Originator {

	private String state;
	Memento m;

	public void setState(String state) {
		this.state = state;
		System.out.println("State at present : " + state);
	}

	public Memento OriginatorMemento() {
		m = new Memento(state);
		return m;
	}
	// Back to old state 

	public void Revert(Memento memento) {
		System.out.println("Restoring to previous state...");
		state = memento.getState();
		System.out.println("State at present :" + state);
	}
}
//Caretaker Class 

class Caretaker {

	private Memento _memento;

	public void SaveMemento(Memento m) {
		_memento = m;
	}

	public Memento RetrieveMemento() {
		return _memento;
	}
}

class MementoPatternEx {

	public static void main(String[] args) {
		System.out.println("***Memento Pattern Demo***\n");
		Originator o = new Originator();
		o.setState("First state");
		// Holding old state 
		Caretaker c = new Caretaker();
		c.SaveMemento(o.OriginatorMemento());
		//Changing state 
		o.setState("Second state");
		// Restore saved state 
		o.Revert(c.RetrieveMemento());
	}
}
