
package Resources;

import java.util.ArrayList;
import java.util.List;

public class Person {
	public String name;
	public int age;
	public static List<Person> persons;
	
	static {
		persons = new ArrayList();
		Person vasia = new Person("vasia", 26);
		Person kolia = new Person("kolia", 17);
		Person ania = new Person("Ania", 30);
		Person max = new Person("Max", 10);
		persons.add(vasia); persons.add(kolia); persons.add(ania);
		persons.add(max);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "name=" + name + ", age=" + age + '}';
	}
	
	
	
}
