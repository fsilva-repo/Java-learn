package poo.base.readCsvFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateCsvFile {
	private String file = "summary.txt";
	private String path;
	private boolean overwrite;

	public CreateCsvFile(String path, boolean overwrite) {
		this.path = path;
		this.overwrite = overwrite;
	}

	public void writer(Product p) {

		if (path.length() != path.lastIndexOf("/")) {
			path = path + "/";
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + file, overwrite))) {
			String totalFormatted = String.format("%.2f", p.sum());
			bw.write("product_name;price;quantitly;total;date");
			bw.newLine();
			bw.write(p.getNameProduct() + ";");
			bw.write(String.valueOf(p.getPrice()) + ";");
			bw.write(p.getQuantity() + ";");
			bw.write(totalFormatted + ";");
			bw.write(p.getDate() + ";");
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Falha ao escrever o arquivo " + e.getMessage());
		}

	}
}
