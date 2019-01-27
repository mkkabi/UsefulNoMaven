
package FilesAndFolders;

import java.io.File;

public class HiddenFiles {

	File[] hiddenFiles = new File(".").listFiles(File::isHidden);
}
