package DesignPatterns_Pluralsight.behavioral.Command;

//invoker
public class Switch {

	public Switch() {
	}

	public void storeAndExecute(Command command) {
		command.execute();
	}

}
