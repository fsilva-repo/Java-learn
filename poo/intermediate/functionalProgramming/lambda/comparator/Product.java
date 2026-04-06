package poo.intermediate.functionalProgramming.lambda.comparator;

import java.util.Objects;

public class Product {
	private String name;
	private double price;
	private int id;

	public Product(String name, double price, int id) {
		this.name = name;
		this.price = price;
		this.id = id;
	}
	
	public String getName() {return name;}
	public double getPrice() {return price;}
	public int getId() {return id;}

	// o conjunto que utilizam a arvore rubbro-negra precisam do compareTo para ordenar os elementos
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}
	
	
}
