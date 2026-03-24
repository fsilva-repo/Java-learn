package poo.base.readFiles.bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {

	public static void reader(String path) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				IO.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			IO.println(e.getMessage());
		}
	}
}
