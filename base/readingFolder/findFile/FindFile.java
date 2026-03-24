package poo.base.readingFolder.findFile;

import java.io.File;

public class FindFile {
	private String filePath;

	public FindFile(String filePath) {
		this.filePath = filePath;
	}

	public void find() {
		File path = new File(filePath);
		File[] directories = path.listFiles(File::isFile);

		if (directories != null) {
			for (File f : directories) {
				IO.println(f);
			}
		} else {
			IO.println("file not found");
		}
	}
}
