package poo.base.repetitionStructure.forStructure;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * O FOR E PARA QUANDO SE TEM UMA QUANTIDADE DETERMINADA DE REPETICOES DE UMA
		 * PARTE DE CODIGO
		 */

		Scanner sc = new Scanner(System.in);

		IO.println("Digite a quantidade de entradas: ");
		int loop = sc.nextInt();

		IO.println("Digite um numero: ");

		int soma = 0;

		for (int i = 0; i < loop; i++) {
			int num = sc.nextInt();
			soma += num;
		}
		IO.println("=======================");
		IO.println("   Total: " + soma);
		sc.close();
	}

}
