
package FilesAndFolders;

import java.io.File;

public class ViewDirContents{

	  public static void main(String args[]) {
         
				 for(File file:ViewDirContents.showHiddenFilesInDir("C:"))
					 System.out.println(file.toString());
    }
		
		public static void showFilesInDir(){
			File dir = new File("c:\\Users\\matt\\Desktop\\");
			if (dir.isDirectory()){
					 String[] dirContents = dir.list();
					 for (int i=0; i<dirContents.length; i++){
						 System.out.println(dirContents[i]);
					 }
				 }
		}
		
		public static File[] showHiddenFilesInDir(String dir){
			return new File(dir).listFiles(File::isHidden);
		}
}
