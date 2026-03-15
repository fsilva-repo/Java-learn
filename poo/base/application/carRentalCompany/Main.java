package poo.base.application.carRentalCompany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import poo.base.application.carRentalCompany.entities.Client;
import poo.base.application.carRentalCompany.entities.Vehicle;

public class Main {

	public static void main(String[] args) {
		Client c = new Client.Builder().name("Flavio Silva").cnh(123456789).address("Rua nijia de fatima, 10").build();
		
		System.out.println(
				c.getName() + "\n"
				+ c.getCnh() + "\n"
				+ c.getAddress());

		System.out.println("");
		
		Vehicle v = new Vehicle.Builder().model("Chevrolet onix").age(LocalDate.of(2021, 05, 23)).color("red").build();
	
		System.out.println(
				v.getModel() + "\n"
				+ v.getAge() + "\n"
				+ v.getColor()
				);
		


					LocalDateTime dt1 = LocalDateTime.now();
	        LocalDateTime dt2 = LocalDateTime.of(2026, 3, 14, 23, 55);

	        long localDateTime = ChronoUnit.DAYS.between(dt2, dt1);
	        Long deliveryDate = ChronoUnit.HOURS.between(dt2, dt1);
	        Long delivery = ChronoUnit.MINUTES.between(dt2, dt1);

	        System.out.println("Diferença em dias: " + localDateTime); // Saída: 2
	        System.out.println("Diferença em horas: " + deliveryDate);
	        System.out.println(delivery);
	     
	       
		
		
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
		
	}
	
}
