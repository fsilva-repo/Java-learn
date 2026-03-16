package poo.base.application.carRentalCompany.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Contract {

	private LocalDateTime locationDate;
	private double rentalPerHour;
	private double rentalPerDay;
	private String amountToPay;
	private String total;
	private String warning;
	private String durationTime;
	private long durationDays;
	
	private Client client;
	private Vehicle vehicle;

	private Contract(Builder builder) {
		this.rentalPerHour = builder.rentalPerHour;
		this.rentalPerDay = builder.rentalPerDay;
		this.locationDate = builder.locationDate;
		this.client = builder.client;
		this.vehicle = builder.vehicle;
	}

	public static class Builder {
		private double rentalPerDay;
		private double rentalPerHour;
		private LocalDateTime locationDate;
		private Client client;
		private Vehicle vehicle;

		public Builder rentalPerDay(double rentalPerDay) {this.rentalPerDay = rentalPerDay;return this;}
		public Builder rentalPerHour(double rentalPerHour) {this.rentalPerHour = rentalPerHour;return this;}
		public Builder client(Client client) {this.client = client;return this;}
		public Builder vehicle(Vehicle vehicle) {this.vehicle = vehicle;return this;}
		public Builder locationDate(String locationDate) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(locationDate, formatter);
			this.locationDate = dateTime;return this;}
		public Contract buid() {return new Contract(this);}
	}

	public double getRentalPerDay() {return rentalPerDay;}
	public double getRentalPerHour() {return rentalPerHour;}
	public LocalDateTime getLocationDate() {return locationDate;}
	public Client getClient() {return client;}
	public Vehicle getVehicle() {return vehicle;}
	public String getAmountToPay() {return amountToPay;}
	public String getTotal() {return total;}
	public String getWarning() {return warning;}
	public String getDurationTime() {return durationTime;}
	public long getDurationDays() {return durationDays;}

	public void calculator() {

		LocalDateTime rentalCompleted = LocalDateTime.now();
		long days = ChronoUnit.DAYS.between(getLocationDate(), rentalCompleted);
		Duration duration = Duration.between(getLocationDate(), rentalCompleted);
		long hours = duration.toHoursPart();
		long minutes = duration.toMinutesPart();

		double valuePerHour = hours * getRentalPerHour();
		double valuePerDay = days * getRentalPerDay();
		
		if (hours < 12) {
			if (minutes > 10) {
				valuePerHour += getRentalPerHour();
				this.durationTime = hours + ":" + minutes;
				this.durationDays = days;
				this.warning = "Ultrapassou a tolerancia de 10min";
				this.amountToPay = "valor por hora R$ " + valuePerHour;
				double value =  valuePerHour + valuePerDay;
				String totalValueStr = String.format("Total R$ %.2f", value);
				this.total = totalValueStr;

			} else {
				this.durationTime = hours + ":" + minutes;
				this.durationDays = days;
				this.amountToPay = "valor por hora R$ " + valuePerHour;
				double value =  valuePerHour + valuePerDay;
				String totalValueStr = String.format("Total R$ %.2f", value);
				this.total = totalValueStr;
			}
			
		} else {
			if (minutes > 10) {
				valuePerHour += getRentalPerHour();
				this.durationTime = hours + ":" + minutes;
				this.durationDays = days;
				this.warning = "Ultrapassou a tolerancia de 10min";
				this.amountToPay = "valor por hora R$ " + valuePerHour;
				double value =  valuePerHour + valuePerDay;
				String totalValueStr = String.format("Total R$ %.2f", value);
				this.total = totalValueStr;

			} else {
				this.durationTime = hours + ":" + minutes;
				this.durationDays = days;
				this.amountToPay = "valor por hora R$ " + valuePerHour;
				double value =  valuePerHour + valuePerDay;
				String totalValueStr = String.format("Total R$ %.2f", value);
				this.total = totalValueStr;
			}
		}
	}

	// hora 22 reais
	// diaria 300 rais
	// tolerancia 10 minutos apos multa de mais uma hora
	// acima de 12 horas cobrar uma diaria
}
