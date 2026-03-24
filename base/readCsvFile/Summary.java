package poo.base.readCsvFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Summary {
	private String file;
	private String pathReader;
	private String pathWrite;
	private boolean overwrite;


	public Summary(String file, String pathReader, String pathWrite, boolean overwrite) {
		this.file = file;
		this.pathReader = pathReader;
		this.pathWrite = pathWrite;
		this.overwrite = overwrite;
	}

	public void function() {
		if (pathWrite.length() != pathWrite.lastIndexOf("/")) {
  		this.pathWrite = pathWrite + "/";
  	}
		
		try (BufferedReader br = new BufferedReader(new FileReader(pathReader));
					BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite + file, overwrite))) {
				
			bw.write("product_name;price;quantily;total;date");
			br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				String[] fild = line.split(";");

				String nameProduct = fild[0];
				double price = Double.parseDouble(fild[1].trim());
				int qt = Integer.parseInt(fild[2].trim());
				LocalDate date = DateExtractor.function(fild[3].trim());
				
				double total = price * qt;

				bw.newLine();
				bw.write(nameProduct + ";");
				bw.write(price + ";");
				bw.write(qt + ";");
				bw.write(total + ";");
				bw.write(date + ";");
			}
			
		} catch (IOException e) {
			System.err.println("Erro ao ler arquivo: " + e.getMessage());
		} finally {
			System.out.println("fim do processo");
		}
	}

	
}



















