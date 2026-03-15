package poo.base.application.carRentalCompany.entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Contract {

	private LocalDateTime locationDate;
	private Client client;
	private Vehicle vehicle;
	
	private Contract(Builder builder) {
		this.locationDate = builder.locationDate;
		this.client = builder.client;
		this.vehicle = builder.vehicle;
	}

	public static class Builder {

		private LocalDateTime locationDate;
		private Client client;
		private Vehicle vehicle;
		
		public Builder client(Client client) {this.client = client;return this;}
		public Builder vehicle(Vehicle vehicle) {this.vehicle = vehicle;return this;}
		public Builder locationDate(String locationDate) {
			LocalDateTime date = LocalDateTime.parse(locationDate);
			this.locationDate = date;return this;
			}
		
		public Contract buid() {
			return new Contract(this);
		}
	}
	
	public LocalDateTime getLocationDate() {return locationDate;}
	public Client getClient() {return client;}
	public Vehicle getVehicle() {return vehicle;}
	public double calculator() {
		LocalDateTime rentalCompleted = LocalDateTime.now();
		long chargePerDay = ChronoUnit.DAYS.between(getLocationDate(), rentalCompleted);
		Long hourlyBilling = ChronoUnit.HOURS.between(getLocationDate(), rentalCompleted);
		
		return 0;
	}
	
	// hora 25 reais
	// diaria 300 rais
	// tolerancia 10 minutos
	// acima de 10 minutos arredondar para cima
	// acima de 12 horas cobrar uma diaria
}













