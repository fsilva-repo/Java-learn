package poo.base.writerFiles.buffedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	public static String fileName;
	public static boolean newFile;
	public static String path;

	public static void bufferedWriter(String text) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path+fileName, newFile))) {
				bw.write(text);
				bw.newLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
