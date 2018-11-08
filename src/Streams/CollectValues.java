
package Streams;

import java.util.*;
import java.util.stream.Collectors;
import Resources.Person;
import static Resources.Person.persons;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CollectValues {

	public static void main(String[] args) {
            
		// .toList method does not guarantee what type of collection you get, for ArrayList use toCollection
		List<Person> list2 = persons.stream().filter(s->s.name.contains("vasia")).collect(Collectors.toList());
		
		// to collect stream into a particular type of List, use toCollection method
		ArrayList<Person> alPersons = persons.stream().collect(Collectors.toCollection(ArrayList::new));
		LinkedList<Person> linkedPerson = persons.stream().collect(Collectors.toCollection(LinkedList::new));
	
		try {
			//using collect() with Files.lines
			ArrayList<Person> personsFromFile = new ArrayList();
			Files.lines(Paths.get("src/Resources/persons")).
					  forEach(t->{String [] s = t.split(","); 
					  personsFromFile.add(new Person(s[0], Integer.parseInt(s[1])));
			});
		} catch (IOException ex) {}
		
		//Grouping and Partitioning - create Maps
		// this will mapp people into lists by hteir age
		Map<Integer, List<Person>> peopleMapByAge = persons.stream().
				  collect(Collectors.groupingBy(Person::getAge));
		//get number of people of particular age
		Map<Integer, Long> numPeopleWithAge = persons.stream().
				  collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
		
		
	}
}

