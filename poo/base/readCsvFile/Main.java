package poo.base.readCsvFile;

public class Main {

	public static void main(String[] args) {

		String pathReader = "/home/arcade/Workstation/JavaLearning/src/poo/base/readCsvFile/src/index.csv";
		String pathWriter = "/home/arcade/Workstation/JavaLearning/src/poo/base/readCsvFile/out";
		Summary summary = new Summary("summary.csv", pathReader, pathWriter, false);
		summary.function();
	}
}