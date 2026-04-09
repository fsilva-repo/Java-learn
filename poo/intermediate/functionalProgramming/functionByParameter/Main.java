package poo.intermediate.functionalProgramming.functionByParameter;

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
		
		
		// utilizando uma interface funcional para filtrar o preco dos produtos
		Predicate<Product> priceGreaterThan500 = p -> p.getPrice() > 500.0;
		
		
		for(Product p : products) {
			IO.println(Discount.applyDiscount(p, priceGreaterThan500 ,5.0));
		}
		
	}

	
	
}
