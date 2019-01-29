package Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class StreamOfStreams {

	public static void main(String[] args) throws IOException {
//		What can we do with a stream of streams? Well, it turns out there’s a
//method just for this situation in the Stream API: flatMap() .
//The flatMap() method is similar to map() in that it maps a stream of one
//type into a stream of another type, but it does something extra; flatMap()
//“flattens” out the streams, essentially concatenating them into one stream. It
//replaces each stream with its contents, creating one stream from many.

		long i = Files.lines(Paths.get("src/Resources/text")).
				flatMap(s -> Arrays.stream(s.split(" "))).distinct().count();

		List<String> list1 = Arrays.asList("item 1, list1", "item 2, list1", "item 3, list1");
		List<String> list2 = Arrays.asList("item 1, list2", "item 2, list2", "item 3, list2");
		List<String> result = list1.stream().flatMap(t -> list2.stream().map(j -> j.toUpperCase() + " " + t)).collect(toList());

		Stream<String> a = Stream.of("one", "two");
		Stream<String> b = Stream.of("three", "four");
		Stream<String> out = Stream.concat(a, b);
		out.forEach(System.out::println);

		Stream<String> a1 = Stream.of("one", "two");
		Stream<String> b1 = Stream.of("three", "four");
		Stream<String> c1 = Stream.of("five", "six");
		Stream<String> out1 = Stream.of(a1, b1, c1).flatMap(s -> s);
		out1.forEach(System.out::println);

		
	}

}
