
package InnerClasses;

public class MethodLocalInnerClass {
	int x;
	
	public void foo(){
		String z;
		class Inner{
			void doStuff(){
				
				System.out.println("inner dostuff");
				// this will not change outer class x
				x = 23;
				//z = "asdf"; cannot change method local var, can only change constans 
			}
		}
	}
	
	public static void main(String[] args) {
		MethodLocalInnerClass m = new MethodLocalInnerClass();
		m.foo();
		System.out.println(m.x);
	}
}
