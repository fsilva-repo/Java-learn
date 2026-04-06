package poo.intermediate.functionalProgramming.lambda.anonymousClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import poo.intermediate.functionalProgramming.lambda.comparator.Product;

public class Main {

	public static void main(String[] args) {
	
		List<Product> list = new ArrayList<>();
		Product p1 = new Product("TV", 900.00, 1);
		Product p2 = new Product("Notebook", 1200.00, 2);
		Product p3 = new Product("Tablet", 450.00, 3);
		Product p4 = new Product("Smartphone", 700.00, 4);
		Product p5 = new Product("Headphone", 200.00, 5);
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		// classe anonima
		Comparator<Product> compareToName = new Comparator<Product>() {
			@Override
			public int compare(Product pA, Product pB) {
				return pA.getName().toUpperCase().compareTo(pB.getName().toUpperCase());
			}
		};
		
		
		list.sort(compareToName);
		list.forEach(System.out::println);
		
		System.out.println("-------------------------");
		
		
		Comparator<Product> compareToId = new Comparator<Product>() {
			@Override
			public int compare(Product pA, Product pB) {
				return Integer.compare(pA.getId(), pB.getId());
			}
		};
		
		list.sort(compareToId);
		list.forEach(System.out::println);
	}

}





















