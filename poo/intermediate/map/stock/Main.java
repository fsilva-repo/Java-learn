package poo.intermediate.map.stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<Integer, Product> stock = new HashMap<>();
		// TreeMap - ordena os elementos pela chave, LinkedHashMap - ordena os elementos pela ordem de inserção, HashMap - não tem ordenação
		
		String path = "/home/arcade/Workstation/JavaLearning/src/poo/intermediate/map/stock/src/electronics-inventory.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] data = line.split(",");
				Product p = new Product(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]));
				stock.put(p.getId(), p);
				line = br.readLine();
			}
       
			stock.forEach((k, v) -> System.out.println(k + " - " + v));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
