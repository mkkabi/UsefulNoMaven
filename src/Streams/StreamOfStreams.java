
package Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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
				  flatMap(s->Arrays.stream(s.split(" "))).distinct().count();
		
	}
	
}
