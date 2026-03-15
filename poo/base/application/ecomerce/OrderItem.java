package poo.base.application.ecomerce;

import java.util.*;

public class OrderItem {
	private int id;
	private List<Product> products = new ArrayList<>();

	public OrderItem(int id) {
		this.id = id;
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public int getId() {
		return id;
	}

	public int getQuantily() {
		int quant = 0;
		while (quant < products.size()) {
			quant++;
		}

		return quant;
	}

	public double subTotal() {
		double sum = 0;
		for (Product p : products) {
			sum += p.getPrice();
		}
		return sum;
	}
}
