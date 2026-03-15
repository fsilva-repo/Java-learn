package poo.base.application.enterprise;

import java.util.Scanner;

import poo.base.application.enterprise.entities.Departament;
import poo.base.application.enterprise.entities.HourContract;
import poo.base.application.enterprise.entities.Worker;
import poo.base.application.enterprise.entities.WorkerLevel;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		IO.print("worker's name: ");
		String workesName = sc.nextLine();
		IO.println("-------------------------");
		
		IO.print(
				"Worker's level"
				+ "\n junio     [1]"
				+ "\n mid level [2]"
				+ "\n senior    [3]"
				+ "\n : ");
		int entrie = sc.nextInt();
		WorkerLevel level;
		switch(entrie) {
		case 1:
			level = WorkerLevel.JUNIOR;
			break;
			
		case 2:
			level = WorkerLevel.MID_LEVEL;
			break;
			
		case 3:
			level = WorkerLevel.SENIOR;
			break;
			
			default:
				level = WorkerLevel.TRAINEE;
		}
		IO.println("-------------------------");
		
		IO.print("Salary base: $");
		double baseSalary = sc.nextDouble();
		IO.println("-------------------------");
		
		IO.print("Departament name: ");
		String departamentName = sc.next();
		IO.println("-------------------------");
		
		
		Worker milton = new Worker(workesName, level
									,baseSalary, new Departament(departamentName).getName());
		
		IO.print("Has active contracts [y/n] ");
		String hasActiveContracts = sc.next();
		Character chose = hasActiveContracts.charAt(0);
		
		@SuppressWarnings("unused")
		String voidNull = sc.nextLine();
		
		if(chose == 'y' || chose == 'Y') {
			
			IO.print("\nContract name: ");
			String name = sc.nextLine();
			IO.println("-------------------------");
			
			IO.print("Value per hour: ");
			double valuePerhour = sc.nextDouble();
			IO.println("-------------------------");
			
			IO.print("Set hours: ");
			int setHours = sc.nextInt();
			IO.println("-------------------------");
			
			
			HourContract hourContract = new HourContract(name, valuePerhour, setHours);
			
			IO.println(hourContract);
			IO.print(milton);
			
		} else {
			
			IO.print(milton);
			
			sc.close();
		}
		
		sc.close();
		
	
		
	}

}




























