package poo.base.exeptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		try {
			
			IO.print("Names: ");
			String[] vect = sc.nextLine().split(" ");
			
			IO.print("informe o indice: ");
			int index = sc.nextInt();
			IO.print(vect[index]);

			// tratando exeption de indice fora do range
		} catch(IndexOutOfBoundsException e) {
			IO.println("indice não encontrado, reinicie o programa");
		
			// entrada não compaativel
		} catch(InputMismatchException e) {
			IO.print("opção inválida, reinicie o programa");
		
		} finally {
	    System.out.println("\nExecução finalizada.");
		}
		
		sc.close();
	}

}
