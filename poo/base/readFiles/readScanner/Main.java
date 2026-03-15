package poo.base.readFiles.readScanner;

import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = null;
		File file = new File("/home/arcade/Documents/hierarquia-de-excecoes.txt");
		
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch(FileNotFoundException e) {
			System.out.println("Erro open file: " + e.getMessage());
			
		} finally {
			/*quando o sc.hasNextLine() nao encontra mais linhas
			 * no arquivo para ser lidas o sc volta a receber o
			 * valor null ai entao sera fechado o programa*/
			if(sc != null) sc.close();
		}
		
		
		
		
	}

}
