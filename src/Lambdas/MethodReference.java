
package Lambdas;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {
	
	public   <T> void fooF(T t){
		System.out.println(t.toString());
	}

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("Vasia");
		names.add("Petia");
		names.add("Kolia");
		names.add("Andrew");
		names.add("Pupok");
		
		MethodReference m = new MethodReference();
		
		names.stream().forEach(m::fooF);
	}
}
