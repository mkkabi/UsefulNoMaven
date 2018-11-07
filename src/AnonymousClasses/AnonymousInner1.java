
package AnonymousClasses;

public class AnonymousInner1 {
	
	Test test = new Test(){
		@Override
		String foo(){
			return "anonymous test foo";
		}
	};
	
	public static void main(String[] args) {
		System.out.println(new AnonymousInner1(){}.test.foo());
	}
}


class Test{
	String foo(){
		return "Test foo";
	}
}