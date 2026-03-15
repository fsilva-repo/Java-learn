package poo.base.repetitionStructure.doWhileStructure;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char respUser;

		do {
			IO.print("Digite os graus em celsius: ");

			double C = sc.nextDouble();

			double convertForFahrenheit = (C * 9) / 5 + 32;

			IO.println("\nTemperatura em Fahrenheit: " + convertForFahrenheit);

			IO.println("deseja tentar novamente s/n");
			respUser = sc.next().charAt(0);

		} while (respUser != 'n');
		sc.close();
	}

}
