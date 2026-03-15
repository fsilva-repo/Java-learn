package poo.base.readCsvFile;

import java.time.LocalDate;

public class Product {

	private String nameProduct = null;
	private double price = 0;
	private int quantity = 0;
	private LocalDate date = null;

	public Product() {}

	public Product(String nameProduct, double price, int quantity, LocalDate date) {
		this.nameProduct = nameProduct;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
	}

	public String getNameProduct() {return nameProduct;}
	public double getPrice() {return price;}
	public int getQuantity() {return quantity;}
	public LocalDate getDate() {return date;}
	
	public double sum() {return (getQuantity() * getPrice());}

}
