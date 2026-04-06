package poo.intermediate.functionalProgramming.lambda.arowFunction;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Product p4 = new Product("Smartphone", 800.00, 4);
		Product p1 = new Product("TV", 900.00, 1);
		Product p3 = new Product("Tablet", 450.00, 3);
		Product p2 = new Product("Notebook", 1200.00, 2);
		Product p5 = new Product("Headphones", 150.00, 5);
		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		
		// arow function ou funcao anonima para ordenar por nome
		products.sort((product1, product2) -> product1.getName().toUpperCase().compareTo(product2.getName().toUpperCase()));
		products.forEach(System.out::println);
		
		System.out.println("-------------------------");
		
		// para ordenar por id
		products.sort((product1, product2) -> Integer.compare(product1.getId(), product2.getId()));
		products.forEach(System.out::println);
	}

}









