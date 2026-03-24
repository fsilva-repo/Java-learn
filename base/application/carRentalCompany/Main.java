package poo.base.application.carRentalCompany;

import java.time.LocalDate;
import poo.base.application.carRentalCompany.entities.Client;
import poo.base.application.carRentalCompany.entities.Contract;
import poo.base.application.carRentalCompany.entities.Vehicle;
import poo.base.application.carRentalCompany.util.CreateCsvFile;

public class Main {

	public static void main(String[] args) {
		Client client = new Client.Builder().name("Flavio Silva").cnh(123456789).address("Rua nijia de fatima, 10").build();
		Vehicle vehicle = new Vehicle.Builder().model("Chevrolet onix").age(LocalDate.of(2021, 05, 23)).color("red")
				.chassis("x90w904344-ktmmk23").build();
		Contract contract = new Contract.Builder().client(client).vehicle(vehicle)
				//		padrão   "dd/MM/yyyy HH:mm"
				.locationDate("14/03/2026 13:45").rentalPerHour(22.0).rentalPerDay(300.0).buid();
		contract.calculator();
		CreateCsvFile createFile = new CreateCsvFile.Builder().contract(contract)
				.file("contrato2.csv").path("/home/arcade/Workstation/JavaLearning/src/poo/base/application/carRentalCompany/out")
				.overwrite(false)
				.build();
		createFile.write();

		System.out.println("processo concluido");
	}

}



