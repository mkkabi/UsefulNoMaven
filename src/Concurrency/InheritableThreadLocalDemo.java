package Concurrency;

//You can pass a value from a parent thread, a thread that creates another thread, to a child thread, 
//the created thread with InheritableThreadLocal. InheritableThreadLocal is a subclass of ThreadLocal. 
//As well as declaring an InheritableThreadLocal() constructor, 
//this class declares the following protected method:
//• T childValue(T parentValue): Calculate the child’s initial value
//as a function of the parent’s value at the time the child thread is
//created. This method is called from the parent thread before the
//child thread is started. The method returns the argument passed
//to parentValue and should be overridden when another value is desired.

public class InheritableThreadLocalDemo {

	private static final InheritableThreadLocal<Integer> intVal
			  = new InheritableThreadLocal<Integer>();

	public static void main(String[] args) {
		Runnable rP = ()
				  -> {
			intVal.set(new Integer(10));
			Runnable rC = ()
					  -> {
				Thread thd = Thread.currentThread();
				String name = thd.getName();
				System.out.printf("%s %d%n", name,
						  intVal.get());
			};
			Thread thdChild = new Thread(rC);
			thdChild.setName("Child");
			thdChild.start();
		};
		new Thread(rP).start();
	}
}
