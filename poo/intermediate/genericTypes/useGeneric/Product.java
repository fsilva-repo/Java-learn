package poo.intermediate.genericTypes.useGeneric;

import java.util.Comparator;

public class Product implements Comparator<Product> {

	private String name;
	private double price;
	private int quantity;
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o1.price, o2.price);
	}
	
	
}
