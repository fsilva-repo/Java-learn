package poo.base.writingReading.createFolder;

import java.io.File;

public class CreateDir {
	// public String path;

	private void makeDir(String path) {
		boolean success = new File(path + "/SubDir").mkdirs();
		System.out.println(success);
	}

	public void isExitsDir(String path) {
		File dir = new File(path);
		File[] dirs = dir.listFiles(File::isDirectory);
	

		if (dirs.length == 0) {
			makeDir(path);
			System.out.println("Diretorio criado");
		
		} else
			
		if (dirs != null && !dir.isFile()) {
			for (File d : dirs) {
				System.out.println(d);
			}
		}
	}
}
