package poo.intermediate.map;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		Map<Integer, Product> products = new HashMap<>();
		
		products.put(1, new Product("Laptop", 999.99, 1));
		products.put(2, new Product("Smartphone", 499.99, 2));
		products.put(3, new Product("Tablet", 299.99, 3));
		products.put(4, new Product("Headphones", 199.99, 4));
		
		products.forEach((id, product) -> System.out.println("ID: " + id + ", Product: " + product));
		System.out.println(products.containsKey(2));
		System.out.println(products.containsValue(new Product("Smartphone", 499.99, 2)));
		
		// sobrescrevendo o valor da chave 2
		products.put(2, new Product("Smartphone Pro", 699.99, 5));
		
		products.forEach((id, product) -> System.out.println("ID: " + id + ", Product: " + product));
		
		System.out.println("__________________________");
		
		products.forEach((id, product) -> {
			if (product.getPrice() < 300.0) {
				System.out.println("ID: " + id + ", Product: " + product);
			}
		});
		
		System.out.println("__________________________");
		
		products.entrySet().stream().filter(entry -> entry.getValue().getPrice() > 300.0)
				.forEach(entry -> System.out.println("ID: " + entry.getKey() + ", Product: " + entry.getValue()));
	}

}





















