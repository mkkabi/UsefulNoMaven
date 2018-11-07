
package Lambdas;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("Vasia");
		names.add("Petia");
		names.add("Kolia");
		names.add("Andrew");
		names.add("Pupok");
		
		names.stream().forEach(System.out::println);
	}
}
