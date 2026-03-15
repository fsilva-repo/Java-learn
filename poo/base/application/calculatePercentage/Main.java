package poo.base.application.calculatePercentage;

public class Main {

	public static void main(String[] args) {
	
	// quantos sao menores que o primeiro numero do parametro
		IO.println(Percentage.calculate(10, 2, 5, 9, 13, 4, 1, 6, 9, 5));
		
		IO.println(Percentage.calculate(10, 9, 13, 4));
		
		IO.println(Percentage.calculate(10, 9, 13));

	}

}
