package poo.base.application.calculateArea;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * formula de herão:
		 * 
		 * perimetro = (a+b+c / 2)
		 * area = √ p*(p-a) * (p-b) * (p-c)
		 */

		Scanner sc = new Scanner(System.in);
		char resp;

		do {
			IO.println("\nCalculo da area do triangulo\nEntre com os tres valores");
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();
			IO.println("=========================");
			IO.println("Area: " + Triangle.area(a, b, c));
			
			IO.print("\nDeseja fazer novo calculo [s/n]: ");
			resp = sc.next().charAt(0);
		} while (resp != 'n');
		sc.close();
	}

}
