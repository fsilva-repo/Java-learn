package poo.base.dataEntrie;


import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
	void main() {
		
		Scanner sc = new Scanner(System.in);
		IO.println("Entre com um numero");
		int n = sc.nextInt();
		double result = n*n;
		Locale localeBR = Locale.forLanguageTag("pt-BR");
		NumberFormat nf = NumberFormat.getCurrencyInstance(localeBR);
		
		IO.println(n + " ^ 2 = " + nf.format(result) + "\n");
	
		// lendo mais de um dado de entrata
		String str = sc.next();
		int number = sc.nextInt();
		double decimal = sc.nextDouble();
		
		IO.print(str + " " + number + " " + decimal);
		
		
		sc.close();
	}
}
