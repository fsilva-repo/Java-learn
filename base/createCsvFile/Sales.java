package poo.base.createCsvFile;

public class Sales {
	private String product;
	private double price;
	private int amount;
	private String date;
	private double total;

	public Sales(String product, double price, int amount, String date) {
		this.product = product;
		this.price = price;
		this.amount = amount;
		this.date = date;
		// O total é calculado no construtor
		this.total = price * amount;
	}

	// Getters (acessadores) para acessar os dados externamente
	public String getProduto() {
		return product;
	}

	public double getPreco() {
		return price;
	}

	public int getQuantidade() {
		return amount;
	}

	public String getData() {
		return date;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return String.format("%s;%.2f;%d;%s;%.2f", product, price, amount, date, total);
	}
}
