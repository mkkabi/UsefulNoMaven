
package InnerClasses;

/*
Member Modifiers Applied to Inner Classes
A regular inner class is a member of the outer class just as instance variables
and methods are, so the following modifiers can be applied to an inner class:
final
abstract
public
private
protected
static but static turns it into a static nested class, not an inner class
strictfp
*/

public class InnerClassExample {
	
	
	public static void main(String[] args) {
		//create instance of inner class from another class
		//first need to get a reference to outer class
		OuterClass outer = new OuterClass("outerclassName");
		OuterClass.InnerClass inner = outer.new InnerClass("name");
		// or a shorter version
		OuterClass.InnerClass inner2 = new OuterClass("name").new InnerClass("name");
		//now we can access inner class methods and variables
		inner.printOuterName();
	}
}


class OuterClass{
	private String name;
	public OuterClass(String s){name = s;}
	
	public void useInner(){
		InnerClass inner = new InnerClass("innerClassName");
		inner.printOuterName();
	}
	
	class InnerClass{
		String name;
		public InnerClass(String s){name=s;}
		public void printOuterName(){
			// Inner classes have access to all methods and instance variables of outer class even private
			System.out.println("Outer name is "+name);
			//a reference to the instance of outer class
			System.out.println("Outer class reference is "+OuterClass.this);
		}
	}
}
