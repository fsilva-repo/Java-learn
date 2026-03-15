package poo.base.exeptions.entitie;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = 1;
		int quant = 0;
		List<String> list = new ArrayList<>();

		try {
			IO.print("Quantidade: ");
			quant = sc.nextInt();
			int i = 0;
			while (i < quant) {
				IO.print(count + " - name: ");
				String name = sc.next();
				list.add(name);
				count++;
				i++;
			}

			IO.print("obter indice: ");
			int index = sc.nextInt();
			IO.print(list.get(index));

			// tratando exeption de indice fora do range
		} catch (IndexOutOfBoundsException e) {
			String msg = String.format("indice de '0' a \'%d\'", quant - 1);
			IO.println(msg + ", reinicie o programa");
			
			// entrada não compaativel
		} catch (InputMismatchException e) {
			IO.println("entrada apena numero inteiro, reinicie o programa");

		} finally {
			IO.println("finally program");
		}

		sc.close();
	}

}
