package poo.base.readingFolder.createFolder;

import java.io.File;

public class CreateDir {
	public boolean makeDir(String path) {
		File dir  = new File(path);
		if(!dir.isFile() && !dir.exists()) {
			new File(path+"/Subdir").mkdir();			
		}
		return false;
	}
}
