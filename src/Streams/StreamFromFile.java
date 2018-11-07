package Streams;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromFile {

	public static void main(String[] args) {

		String filePath = "src\\Resources\\readme.txt";

		try (Stream<String> lines = Files.lines(Paths.get(filePath),
				Charset.defaultCharset())) {
//				uniqueWords = lines.flatMap(line->Arrays.stream(line.split(" ")))
//						.distinct().count();
			lines.flatMap(line -> Arrays.stream(line.split(" ")))
					.distinct().forEach(System.out::println);
		} catch (Exception e) {
		}
	}
}
