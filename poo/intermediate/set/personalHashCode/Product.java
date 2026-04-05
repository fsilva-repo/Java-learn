package poo.intermediate.set.personalHashCode;

public class Product implements Comparable<Product> {
	private String name;
	private double price;
	private int id;

	public Product(String name, double price, int id) {
		this.name = name;
		this.price = price;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Product o) {
		return Integer.compare(this.id, o.id);
	}
}
