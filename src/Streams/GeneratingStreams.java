package Streams;

import java.util.stream.Stream;
import Resources.Sensor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratingStreams {

	public static void main(String[] args) {
//		To work safely with infinite streams, you need a short-circuiting
//operation. That could be limit() , like we used above, or it can also be an
//operation like findFirst() , findAny() , or anyMatch() .
//		Stream.iterate(1, s->s+1).limit(25);
//		
//		Sensor sensor = new Sensor();
//		Stream.generate(()->sensor.next()).forEach(System.out::println);

		List<Item> items;
		items = Stream.iterate(1, s -> s + 1).limit(25).map(t -> new Item("name" + t)).collect(Collectors.toList());
		
		items.stream().forEach(t->t.toString());
	}
}

class Item {

	String name;

	public Item(String s) {
		name = s;

	}

	@Override
	public String toString() {
		return "Item{" + "name=" + name + '}';
	}
}
