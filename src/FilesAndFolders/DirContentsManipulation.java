package FilesAndFolders;

import java.io.File;
import java.io.FileFilter;

public class DirContentsManipulation {

	public static void main(String args[]) {
		String dirPath = "c:";
		File[] hiddenFiles = fileterHiddenFiles(dirPath);
		System.out.println("======");
		for (File file : hiddenFiles) {
			System.out.println(file.getName());
		}

	}

	public static void listFilesInDir(String dirPath) {
		File dir = new File(dirPath);
		if (dir.isDirectory()) {
			String[] dirContents = dir.list();
			for (int i = 0; i < dirContents.length; i++) {
				System.out.println(dirContents[i]);
			}
		}
	}

	public static File[] fileterHiddenFiles(String dirPath) {
		File[] hiddenFiles = new File(dirPath).listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isHidden();
			}
		});
		return hiddenFiles;
	}

}
