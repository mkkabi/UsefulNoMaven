package Java8inAction;

import Streams.*;
import java.util.stream.Stream;

public class StreamsFromFunctions {

	public static void main(String[] args) {
		Stream.iterate(0, n -> n + 2)
				.limit(10)
				.forEach(System.out::println);

		Stream.iterate(new int[]{0, 1},
				t -> new int[]{t[1], t[0] + t[1]})
				.limit(20)
				.forEach(t -> System.out.print("(" + t[0] + ") "));

		Stream.generate(Math::random)
				.limit(5)
				.forEach(System.out::println);
	}
}
