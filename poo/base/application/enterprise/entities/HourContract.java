package poo.base.application.enterprise.entities;

import java.time.LocalDate;

public class HourContract {
	@Override
	public String toString() {
		return "Contract [name: " + name + ", value per hour: " + valuePerHours +
				", hours: " + hours + ", date: " + date + "]";
	}

	private String name;
	private double valuePerHours;
	private Integer hours;
	private LocalDate date;
	
	public LocalDate date() {
		return date;
	}

	public double getValuePerHours() {
		return valuePerHours;
	}

	public int getHours() {
		return hours;
	}
	
	public String getName() {
		return name;
	}

	public HourContract(String name, double valuePerHours, Integer hours) {
		this.name = name;
		this.date = LocalDate.now();
		this.valuePerHours = valuePerHours;
		this.hours = hours;
	}

	public double totalValue() {
		double valuePerHour = getValuePerHours();
		double total = valuePerHour * getHours();
		return total;
	}
}
