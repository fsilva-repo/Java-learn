package poo.base.writingReading.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reading {

	public static void jsonFile() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(
				new FileReader("/home/arcade/Workstation/JavaLearning/src/poo/base/writingReading/resouce/output.json"))) {
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
