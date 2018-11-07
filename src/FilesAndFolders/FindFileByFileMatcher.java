
package FilesAndFolders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class FindFileByFileMatcher extends SimpleFileVisitor<Path>{
	
	private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**pass*.txt");
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
		//System.out.println(file);
		if (matcher.matches(file)){
			System.out.println(file);
		}
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {
		FindFileByFileMatcher dirs = new FindFileByFileMatcher();


		Files.walkFileTree(Paths.get("C:\\Users\\matt\\Desktop\\DOWNLOAD"), dirs);
		
		
		
		
	}
}