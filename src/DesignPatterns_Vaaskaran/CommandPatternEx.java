package DesignPatterns_Vaaskaran;

/*Here requests are encapsulated as objects. In general, four terms are associated—invoker, client, 
command, and receiver. A command object is capable of calling a particular method in the receiver. 
It stores the parameters of the methods in receiver. An invoker only knows about the command interface, 
but it is totally unware about the concrete commands. The client object holds the invoker object and the 
command object(s). The client decides which of these commands needs to execute at a particular point in time. 
To do that, he/she passes the command object to the invoker to execute that particular command.*/

interface ICommand {
	void Do();
}

class MyUndoCommand implements ICommand {

	private Receiver receiver;

	MyUndoCommand(Receiver recv) {
		receiver = recv;
	}

	@Override
	public void Do() {
		//Call undo in receiver 
		receiver.performUndo();
	}
}

class MyRedoCommand implements ICommand {

	private Receiver receiver;

	MyRedoCommand(Receiver recv) {
		receiver = recv;
	}

	@Override
	public void Do() {
		//Call redo in receiver 
		receiver.performRedo();
	}
}
//Receiver Class 

class Receiver {

	public void performUndo() {
		System.out.println("Executing -MyUndoCommand");
	}

	public void performRedo() {
		System.out.println("Executing -MyRedoCommand");
	}
}
//Invoker Class 

class Invoke {

	ICommand cmd;

	public void ExecuteCommand(ICommand cmd) {
		this.cmd = cmd;
		cmd.Do();
	}
}
//Client Class 

class CommandPatternEx {

	public static void main(String[] args) {
		System.out.println("***Command Pattern Demo***\n");
		Receiver intendedreceiver = new Receiver();
		/*Client holds Invoker and Command Objects*/
		Invoke inv = new Invoke();
		MyUndoCommand unCmd = new MyUndoCommand(intendedreceiver);
		MyRedoCommand reCmd = new MyRedoCommand(intendedreceiver);
		inv.ExecuteCommand(unCmd);
		inv.ExecuteCommand(reCmd);
	}
}
