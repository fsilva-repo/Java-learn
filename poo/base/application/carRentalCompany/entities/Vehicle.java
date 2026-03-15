package poo.base.application.carRentalCompany.entities;

import java.time.LocalDate;

public class Vehicle {

	private String model;
	private LocalDate age;
	private String color;
	private String chassis;
	
	private Vehicle(Builder builder) {
		this.model = builder.model;
		this.age = builder.age;
		this.color = builder.color;
		this.chassis = builder.chassis;
	}
	
	
	public static class Builder {
		private String model;
		private LocalDate age;
		private String color;
		private String chassis;
		
		public Builder model(String model) {this.model = model; return this;}
		public Builder age(LocalDate age) {this.age = age; return this;}
		public Builder color(String color) {this.color = color; return this;}
		public Builder chassis(String chassis) {this.chassis = chassis; return this;}
		
		public Vehicle build() {
			return new Vehicle(this);
		}
	}
	
	
	public String getModel() {return model;}
	public LocalDate getAge() {return age;}
	public String getColor() {return color;}
	public String getChassis() {return chassis;}
	
	
}
