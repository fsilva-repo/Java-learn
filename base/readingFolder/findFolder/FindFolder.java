package poo.base.readingFolder.findFolder;

import java.io.File;

public class FindFolder {
	private String pathDir;

	public FindFolder(String pathDir) {
		this.pathDir = pathDir;
	}

	public void find() {
		File path = new File(pathDir);
		File[] directories = path.listFiles(File::isDirectory);

		if (directories != null) {
			for (File dir : directories) {
				IO.println(dir);
			}

		} else {
			IO.println("Directory not found");
		}
	}
}
