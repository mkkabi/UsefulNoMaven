package DesignPatterns_Vaaskaran;

abstract class BasicEngineering {

	// Papers() in the template method
	public void Papers() {
		//Common Papers:
		Math();
		SoftSkills();
		//Specialized Paper:
		SpecialPaper();
	}

	//Non-Abstract method Math(), SoftSkills() are already implemented by Template class
	private void Math() {
		System.out.println("Mathematics");
	}

	private void SoftSkills() {
		System.out.println("SoftSkills");
	}

	//Abstract method SpecialPaper() must be implemented in derived classes
	public abstract void SpecialPaper();
	
}

class ComputerScience extends BasicEngineering {

	@Override
	public void SpecialPaper() {
		System.out.println("Object Oriented Programming");
	}
}

class Electronics extends BasicEngineering {

	@Override
	public void SpecialPaper() {
		System.out.println("Digital Logic and Circuit Theory");
	}
}
// TemplateMethodPatternEx.java 

public class TemplateMethod {

	public static void main(String[] args) {
		System.out.println("***Template Method Pattern Demo***\n");
		BasicEngineering bs = new ComputerScience();
		System.out.println("Computer Sc Papers:");
		bs.Papers();
		System.out.println();
		bs = new Electronics();
		System.out.println("Electronics Papers:");
		bs.Papers();
	}
}
