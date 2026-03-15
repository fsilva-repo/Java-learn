package poo.base.application.hotel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Renter[] renter = new Renter[5];
		
		String name = "null";
		int cpf = 0;
		int phone = 0;
		int position = 0;
		char respUser;

		do {
			IO.println("Dados do inquilino");
			IO.print("Nome: ");
			name = sc.next();

			IO.print("Cpf: ");
			cpf = sc.nextInt();

			IO.print("Tel: ");
			phone = sc.nextInt();

			renter[position] = new Renter(name, cpf, phone);
			position++;

			IO.println("Novo cadastro? [s/n]");
			respUser = sc.next().charAt(0);
		} while (respUser != 'n');

		int count = 0;
		for (Renter r : renter) {
			if(renter[count] != null) {
				IO.println(r.toString());	
			}
			count++;
		}
		sc.close();

	}

}
