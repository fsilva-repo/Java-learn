package poo.base.repetitionStructure.whileStructure;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * O WHILE E UTIL QUANDO NAO SE SABE A QUANTIDADE DE VEZES QUE O CODIGO
		 * PRECISARA SE REPETIR
		 */

		Scanner sc = new Scanner(System.in);

		IO.println("Digite um numero: ");
		double num = sc.nextDouble();
		double soma = 0;
		double power = 0;

		while (num != 0) {
			num = sc.nextDouble();
			soma += num;
		}

		power = soma * soma;
		IO.println(soma);
		IO.println(power);

		sc.close();

	}

}
