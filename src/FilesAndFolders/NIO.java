
package FilesAndFolders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class NIO {

	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("c:/sample.scv");
		Files.createFile(path);
		
	}
}