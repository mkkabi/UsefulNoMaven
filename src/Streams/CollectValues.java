
package Streams;

import java.util.*;
import java.util.stream.Collectors;
import Resources.Person;
import static Resources.Person.persons;

public class CollectValues {

	public static void main(String[] args) {
		// .toList method does not guarantee what type of collection you get, for ArrayList use toCollection
		List<Person> list2 = persons.stream().filter(s->s.name.contains("vasia")).collect(Collectors.toList());
		list2.forEach(System.out::println);
		
		
		System.out.println("\nArray List examples ");
		// to collect stream into ArrayList use toCollection method
		
		@myAnn
		ArrayList<Person> alPersons = persons.stream().collect(Collectors.toCollection(ArrayList::new));
		alPersons.forEach(p->System.out.println(p));
	
	}
}

@interface myAnn{
	int i() default 1;
}
