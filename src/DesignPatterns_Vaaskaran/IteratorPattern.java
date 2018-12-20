package DesignPatterns_Vaaskaran;

import java.util.LinkedList;

interface ISubject_Iterator {
	public IIterator CreateIterator();
}

interface IIterator {
	void First();//Reset to first element 
	String Next();//get next element 
	Boolean IsDone();//End of collection check 
	String CurrentItem();//Retrieve Current Item 
}

class Arts implements ISubject_Iterator {

	private String[] subjects;
	public Arts() {
		subjects = new String[2];
		subjects[0] = "Bengali";
		subjects[1] = "English";
	}

	public IIterator CreateIterator() {
		return new ArtsIterator(subjects);
	}

	public class ArtsIterator implements IIterator {

		private String[] subjects;
		private int position;

		public ArtsIterator(String[] subjects) {
			this.subjects = subjects;
			position = 0;
		}

		public void First() {
			position = 0;
		}

		public String Next() {
			return subjects[position++];
		}

		public Boolean IsDone() {
			return position >= subjects.length;
		}

		public String CurrentItem() {
			return subjects[position];
		}
	}
}

class Science implements ISubject_Iterator {
	private LinkedList<String> subjects;

	public Science() {
		subjects = new LinkedList<String>();
		subjects.addLast("Maths");
		subjects.addLast("Comp. Sc.");
		subjects.addLast("Physics");
	}

	@Override
	public IIterator CreateIterator() {
		return new ScienceIterator(subjects);
	}

	public class ScienceIterator implements IIterator {

		private LinkedList<String> subjects;
		private int position;

		public ScienceIterator(LinkedList<String> subjects) {
			this.subjects = subjects;
			position = 0;
		}

		public void First() {
			position = 0;
		}

		public String Next() {
			return subjects.get(position++);
		}

		public Boolean IsDone() {
			return position >= subjects.size();
		}

		public String CurrentItem() {
			return subjects.get(position);
		}
	}
}

class IteratorPatternEx {

	public static void main(String[] args) {
		System.out.println("***Iterator Pattern Demo***\n");
		ISubject_Iterator Sc_subject = new Science();
		ISubject_Iterator Ar_subjects = new Arts();
		IIterator Sc_iterator = Sc_subject.CreateIterator();
		IIterator Ar_iterator = Ar_subjects.CreateIterator();
		System.out.println("\nScience subjects :");
		Print(Sc_iterator);
		System.out.println("\nArts subjects :");
		Print(Ar_iterator);
	}

	public static void Print(IIterator iterator) {
		while (!iterator.IsDone()) {
			System.out.println(iterator.Next());
		}
	}
}
