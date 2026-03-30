package poo.base.createCsvFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Summary {

	public static void saveFileCsv(List<Sales> sales, String pathOutput) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(pathOutput))) {
			// Escreve o cabeçalho
			pw.println("nome_produto;preco_unitario;quantidade_vendida;data_venda;valor_total");

			// Escreve cada linha
			for (Sales s : sales) {
				pw.println(s.toString());
			}

			System.out.println("Sucesso! Arquivo '" + pathOutput
					+ "' gerado com " + sales.size() + " registros.");

			// Calcula e exibe o total geral
			double totalGeral = sales.stream().mapToDouble(Sales::getTotal).sum();
			System.out.printf("Valor total geral das vendas: R$ %.2f%n", totalGeral);

		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo de saída: " + e.getMessage());
		}
	}
}
