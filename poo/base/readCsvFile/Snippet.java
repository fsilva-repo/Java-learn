package poo.base.readCsvFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Snippet {

	public static void main(String[] args) {
//	String wordList = "Ola boa noite desenvolvedores em java no Brasil.";

		String path = "/home/arcade/Workstation/JavaLearning/src/poo/base/readCsvFile/src";
		String file = "summary.csv";
		if (path.length() != path.lastIndexOf("/")) {
			path = path + "/";
		}
		boolean overwrite = false;
		LocalDate march = LocalDate.now();

		Product product = new Product("TVsmart Philco 43p 4k", 2870.45, 6, march);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + file, overwrite))) {
			String totalFormatted = String.format("%.2f", product.sum());
			bw.write("product_name;price;quantitly;total;date");
			bw.newLine();
			bw.write(product.getNameProduct() + ";");
  		bw.write(String.valueOf(product.getPrice()) + ";");
  		bw.write(product.getQuantity() + ";");
  		bw.write(totalFormatted + ";"); // String.valueOf(product.sum())
  		bw.write(product.getDate() + ";");
  		bw.newLine();
		} catch (IOException e) {
			System.out.println("Falha ao escrever o arquivo " + e.getMessage());
		}// cristian brakeman
	}
}