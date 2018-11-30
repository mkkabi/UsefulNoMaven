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

//For more insight into ThreadLocal and how it’s implemented, check out
//patson luk’s “a painless introduction to Java’s threadlocal storage” blog post
//http://java.dzone.com/articles/painless-introduction-javas-threadlocalstorage
public class InheritableThreadLocalDemo {

	private static final InheritableThreadLocal<Integer> intVal
			= new InheritableThreadLocal<Integer>();

	public static void main(String[] args) {
		Runnable rP = ()
				-> {
					intVal.set(new Integer(10));
					System.out.printf("%s %d%n", Thread.currentThread().getName(), intVal.get());
					Runnable rC = ()
					-> {
						Thread thd = Thread.currentThread();
						String name = thd.getName();
						intVal.set(new Integer(33));
						System.out.printf("%s %d%n", name, intVal.get());
					};
					Thread thdChild = new Thread(rC);
					thdChild.setName("Child");
					thdChild.start();
				};
		Thread thd1 = new Thread(rP);
		thd1.setName("parent");
		thd1.start();
	}
}
