package poo.intermediate.genericTypes.useGeneric;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	void main() {
		String path = "/home/arcade/Workstation/JavaLearning/src/poo/intermediate/genericTypes/useGeneric/src/employee.csv";
		List<Employee> employees = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// 1. Ler e descartar o cabeçalho ANTES do loop
			String header = br.readLine();
			if (header == null) {
				System.out.println("Arquivo vazio.");
				return;
			}

			String line;

			while ((line = br.readLine()) != null) {
				// Ignora linhas vazias se houver
				if (line.trim().isEmpty())
					continue;

				String[] data = line.split(",");

				// Validação básica para evitar ArrayIndexOutOfBoundsException
				if (data.length >= 3) {
					String name = data[0].trim();
					int age = Integer.parseInt(data[1].trim());
					double salary = Double.parseDouble(data[2].trim());

					employees.add(new Employee(name, age, salary));
				}
			}

			System.out.println("Employees: " + employees);

		} catch (IOException e) {
			System.err.println("Erro de IO: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println("Erro de formatação numérica: " + e.getMessage());
		}
	
	
	
		IO.println("--------------------");	
	
	
	
		String filePath = "/home/arcade/Workstation/JavaLearning/src/poo/intermediate/genericTypes/useGeneric/src/products.csv";
		List<Product> products = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			// 1. Ler e descartar o cabeçalho ANTES do loop
			String header = br.readLine();
			if (header == null) {
				System.out.println("Arquivo vazio.");
				return;
			}

			String line;

			while ((line = br.readLine()) != null) {
				// Ignora linhas vazias se houver
				if (line.trim().isEmpty())
					continue;

				String[] data = line.split(",");

				// Validação básica para evitar ArrayIndexOutOfBoundsException
				if (data.length >= 3) {
					String name = data[0].trim();
					double price = Double.parseDouble(data[1].trim());
					int quantily = Integer.parseInt(data[2].trim());

					products.add(new Product(name, price, quantily));
				}
			}

			System.out.println("Product: " + products);

		} catch (IOException e) {
			System.err.println("Erro de IO: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println("Erro de formatação numérica: " + e.getMessage());
		}
	
	
	
	
	
	
	
	
	
	
	
	}	
}















