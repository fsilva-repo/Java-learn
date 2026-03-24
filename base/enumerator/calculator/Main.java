package poo.base.enumerator.calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		IO.print("Operações" + " \nCudo [1]" + " \nAdição [2]" + " \nRaiz Q.[3]" + " \nDivisão [4]" + " \nQuadrado [5]"
				+ " \nSubtração [6]" + " \nMUltiplicação [7]" + " \nOpção: ");
		String chosen = sc.next();

		int value = Character.getNumericValue(chosen.charAt(0));

		switch (value) {

		case 1:
			IO.print("\n^2: ");
			double entrie1 = sc.nextDouble();
			IO.println("==================");
			IO.println(" " + Calculator.CUBO.exec(entrie1));
			break;

		case 2:
			IO.print("\n: ");
			double entrieA = sc.nextDouble();
			IO.print("+ ");
			double entrieB = sc.nextDouble();
			IO.println("==================");
			IO.println(" " + Calculator.SOMAR.exec(entrieA, entrieB));
			break;

		case 3:
			IO.print("\n√: ");
			double entrie2 = sc.nextDouble();
			IO.println("==================");
			IO.println(" " + Calculator.RAIZ_Q.exec(entrie2));
			break;

		case 4:
			IO.print("\n: ");
			double entrieC = sc.nextDouble();
			IO.print("÷ ");
			double entrieD = sc.nextDouble();
			IO.println("==================");
			IO.println(" " + Calculator.DIVIDIR.exec(entrieC, entrieD));
			break;

		case 5:
			IO.print("\n^3: ");
			double entrie3 = sc.nextDouble();
			IO.println("==================");
			IO.println(" " + Calculator.QUADRADO.exec(entrie3));
			break;

		case 6:
			IO.print("\n: ");
			double entrieE = sc.nextDouble();
			IO.print("- ");
			double entrieF = sc.nextDouble();
			IO.println("==================");
			IO.println(" " + Calculator.SUBTRACAO.exec(entrieE, entrieF));
			break;

		case 7:
			IO.print("\n: ");
			double entrieG = sc.nextDouble();
			IO.print("* ");
			double entrieH = sc.nextDouble();
			IO.println("==================");
			IO.println(" " + Calculator.MULTIPLICACAO.exec(entrieG, entrieH));
			break;

		}

		sc.close();
	}

}
