
package FunctionalInterfaces;

import Resources.Dog;
import java.util.Comparator; 
import java.util.function.Predicate; 

public class PredicateExample {
	
	public static void main(String[] args) {
		Dog bobik = new Dog("Bobik", 17);
		
		Predicate<Dog> byAge = d->d.getAge() > 5;
		Predicate<Dog> byName = d->d.getName().contains("bob");
		byAge.test(bobik);
	}
}
