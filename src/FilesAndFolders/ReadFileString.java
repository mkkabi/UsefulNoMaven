package FilesAndFolders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileString {

	public static void main(String[] args) {

		ReadFileString readTxt = new ReadFileString();
		String filePath = "readme.txt";

		readTxt.readFileString(filePath);
	}

	private void readFileString(String filePath) {
		BufferedReader reader;
		String line;
		try {
			reader = new BufferedReader(
					new FileReader(new File(filePath)));
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException ex) {
			//Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("File was not found");
		} catch (IOException e) {
			System.out.println("IO Exception happened");
		}
	}
}
