package poo.base.functions;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		char userResponse;
		
		do {
			
			double x = 0;
			double y = 0;
			
			IO.print("\nQual operação você deseja executar\n"
					+ "\nMultiplicação digite [1] "
					+ "\nDivisão digite       [2] "
					+ "\nSubtração digite     [3] \n"
					+ "Opção: ");
			
			int chosen = sc.nextInt();
			
			switch(chosen) {
			case 1:
				IO.print("\nMultiplicando: ");
				x = sc.nextDouble();
				IO.print("Multiplicador: ");
				y = sc.nextDouble();
				IO.print("Produto: ");
				IO.print(Mult.run(x, y) + "\n");
				break;
				
			case 2:
				IO.print("\nDividendo: ");
				x = sc.nextDouble();
				IO.print("Divisor: ");
				y = sc.nextDouble();
				IO.print("Resto: ");
				IO.print(Div.run(x, y) + "\n");
				break;
				
			case 3:
				IO.print("\nMinuendo: ");
				x = sc.nextDouble();
				IO.print("Subtraendo: ");
				y = sc.nextDouble();
				IO.print("Diferença: ");
				IO.print(Sub.run(x, y) + "\n");
			break;
			}
			
			IO.print("\nContinuar [s/n]: ");
			userResponse = sc.next().charAt(0);
		} while(userResponse != 'n');
		
		sc.close();
	}

	
	
	
	
	
	
	
	
	
	
	
}
