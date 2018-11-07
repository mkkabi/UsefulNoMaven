
package AnonymousClasses;

public class AnonymousInner2 {

	Callable c = new Callable(){
		@Override
		public void call() {
			System.out.println("inside anonymous inner class that implements Callable");
		}
	};
	
	Callable c2 = ()->System.out.println("asdf");
	
}

interface Callable{
	public void call();
}