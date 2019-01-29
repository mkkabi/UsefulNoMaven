package Streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class FlatMapExamples {

//	If path is the path to a file, then the following produces a stream of the words contained in that file:
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("src/Resources/text");
		Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
		Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
		words.forEach(t -> System.out.println(t + " "));
		
		
		List<String> list1 = Arrays.asList("item 1, list1", "item 2, list1", "item 3, list1");
		List<String> list2 = Arrays.asList("item 1, list2", "item 2, list2", "item 3, list2");
		List<String> result = list1.stream().flatMap(t->list2.stream().map(j->j.toUpperCase()+" "+t)).collect(toList());
		result.forEach(t->System.out.print(t+"  =====   \n"));
	}

}
