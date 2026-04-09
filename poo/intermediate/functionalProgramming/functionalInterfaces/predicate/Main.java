package poo.intermediate.functionalProgramming.functionalInterfaces.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
		
		// utilizando uma interface funcional Predicate para filtrar o preco dos produtos
		Predicate<Product> isExpensive = product -> product.getPrice() <= 500.00;
		products.stream().filter(isExpensive).forEach(System.out::println);

		System.out.println("-------------------");
		
		// uitlizando arow function para filtrar o preco dos produtos
		products.stream().filter(prod -> prod.getPrice() >= 500).forEach(System.out::println);

		System.out.println("-------------------");
		
		// utilizando uma classe filtrar o preco dos produtos <= 1000.00
		products.stream().filter(FilterPrice::testPrice).forEach(System.out::println);
	}

}



















