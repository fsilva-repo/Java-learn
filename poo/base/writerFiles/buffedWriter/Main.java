package poo.base.writerFiles.buffedWriter;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		IO.print("name file: ");
		Writer.fileName = sc.nextLine();
		IO.print("path: ");
		Writer.path = sc.nextLine();
		IO.print("new file: ");
		Writer.newFile = sc.nextBoolean();
		IO.print("digite text: ");
		String text = sc.nextLine();
		Writer.bufferedWriter(text); 
		
		sc.close();
	}
	//  { "dominio":"https://formaearte.com.br", "data":"2026-01-07", "autor": "Flavio Silva" }
}
