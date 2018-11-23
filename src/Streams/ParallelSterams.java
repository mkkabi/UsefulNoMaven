
package Streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ParallelSterams {
	public static void main(String[] args) throws IOException {
		Path longListOFNumbers = Paths.get("src/Resources/longListOFNumbers.txt");
		
		Stream lines = Files.lines(longListOFNumbers);
		
		// Make Stream parallel with .parallel() method
		long l = lines.mapToInt(r->Integer.parseInt((String) r)).parallel().count();
		System.out.println(l);
	}
	
}
