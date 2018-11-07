package FilesAndFolders;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReadFileStream {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		ReadFileStream readTxt = new ReadFileStream();
		String filePath = "readme.txt";
		readTxt.readFileStream(filePath);

	}

	private void readFileStream(String filePath) {
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get(filePath),
				Charset.defaultCharset())) {
//				uniqueWords = lines.flatMap(line->Arrays.stream(line.split(" ")))
//						.distinct().count();
			lines.flatMap(line -> Arrays.stream(line.split(" ")))
					.distinct().forEach(System.out::println);
		} catch (Exception e) {
		}
//		System.out.println("unique qords number: "+uniqueWords);
	}

}
