package poo.base.writingReading.writing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writing {

	public static void bufferedWriter(String json) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
				"/home/arcade/Workstation/JavaLearning/src/poo/base/writingReading/resouce/output.json", true))) {

			bw.write(json);
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
