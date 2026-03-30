package poo.base.application.paymentGenerate.solution2.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contract {
	
	private int number;
	private LocalDate date;
	private double totalValue;
	
	private Contract(Builder builder) {
		this.number = builder.number;
		this.date = builder.date;
		this.totalValue = builder.totalValue;

	}
	
	public static class Builder {

		private int number;
		private LocalDate date;
		private double totalValue;

		public Builder withDate(String date) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(date, formatter);
			this.date = localDate;return this;}
		public Builder withNumber(int number) {this.number = number;return this;}
		public Builder withTotalValue(double totalValue) {this.totalValue = totalValue;return this;}
		public Contract build() {return new Contract(this);}
}

	public int getNumber() {return number;}
	public LocalDate getDate() {return date;}
	public double getTotalValue() {return totalValue;}
	
	
}





