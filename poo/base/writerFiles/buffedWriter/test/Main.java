package poo.base.writerFiles.buffedWriter.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		if(str == "") {
			System.out.println("null");
		}
		else {
			System.out.println(str);
		}
		sc.close();
	}// { "dominio":"https://formaearte.com.br", "data":"2026-01-07", "autor": "Flavio Silva" }

}
