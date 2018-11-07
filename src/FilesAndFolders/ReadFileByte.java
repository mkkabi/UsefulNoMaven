package FilesAndFolders;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileByte {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		ReadFileByte readTxt = new ReadFileByte();
		String filePath = "readme.txt";
		byte[] b = readTxt.read(filePath);
	}

	private byte[] read(String fileName) {
		ByteArrayOutputStream bos = null;
		try {
			File f = new File(fileName);
			FileInputStream fis = new FileInputStream(f);
			byte[] buffer = new byte[1024];
			bos = new ByteArrayOutputStream();
			for (int len; (len = fis.read(buffer)) != -1;) {
				bos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e2) {
			System.err.println(e2.getMessage());
		}
		return bos != null ? bos.toByteArray() : null;
	}

}
