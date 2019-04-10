package DesignPatterns_Pluralsight.Behavioral.CommandPattern;

//invoker
public class Switch {

	public Switch() {
	}

	public void storeAndExecute(Command command) {
		command.execute();
	}

}
