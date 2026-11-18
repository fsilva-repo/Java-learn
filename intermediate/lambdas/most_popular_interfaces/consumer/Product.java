package lambdas.most_popular_interfaces.consumer;

public class Product {
	private String name;
	private double price;

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

}
