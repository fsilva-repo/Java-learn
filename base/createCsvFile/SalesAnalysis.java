package poo.base.createCsvFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesAnalysis {

	public static List<Sales> readFile(String  filePath) {
		List<Sales> sales = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			// Pula o cabeçalho
			if (br.readLine() == null) {
				System.out.println("O arquivo está vazio.");
				return sales;
			}

			String line;
			while ((line = br.readLine()) != null) {
				String[] field = line.split(";");

				if (field.length >= 4) {
					try {
						String product = field[0].trim();
						// Garante que o separador decimal seja ponto
						String priceStr = field[1].trim().replace(',', '.');
						double price = Double.parseDouble(priceStr);
						int amount = Integer.parseInt(field[2].trim());
						String date = field[3].trim();

						sales.add(new Sales(product, price, amount, date));
					} catch (NumberFormatException e) {
						System.err.println("Erro ao converter dados na linha: " + line);
						// Continua processando o restante do arquivo
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}

		return sales;
	}
}
