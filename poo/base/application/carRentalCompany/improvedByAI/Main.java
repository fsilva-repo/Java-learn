package poo.base.application.carRentalCompany.improvedByAI;

import java.time.LocalDate;

import poo.base.application.carRentalCompany.entities.Client;
import poo.base.application.carRentalCompany.entities.Contract;
import poo.base.application.carRentalCompany.entities.Vehicle;
import poo.base.application.carRentalCompany.util.CreateCsvFile;


public class Main {
    public static void main(String[] args) {
    	Client client = new Client.Builder().name("Flavio Silva").cnh(24564656).address("Rua Nijia de Fatima").build();
    	
    	Vehicle vehicle = new Vehicle.Builder().model("Chevrolet Onix").age(LocalDate.of(2021, 3, 12)).color("Branco")
    			.chassis("23445jfih45ih6").build();
    	
    	Contract contract = new Contract.Builder().client(client).vehicle(vehicle).locationDate("14/03/2026 09:25")
    			.rentalPerHour(22).rentalPerDay(300).buid();
    	
    	CreateCsvFile createFile = new CreateCsvFile.Builder().contract(contract).file("contrato4.csv")
    			.path("/home/arcade/Workstation/JavaLearning/src/poo/base/application/carRentalCompany/out/").overwrite(false).build();

    	contract.calculator();
    	createFile.write();
    }
  }