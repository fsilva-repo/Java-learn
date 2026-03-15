package poo.base.writingReading;

import java.io.IOException;
import java.util.Scanner;

import  poo.base.writingReading.writing.Writing;
import  poo.base.writingReading.reading.Reading;
public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		IO.print("json data: ");
		String json = sc.nextLine();
		
		Writing.bufferedWriter(json);
		
		Reading.jsonFile();
		
		
		sc.close();
		
	}
	//  { "dominio":"https://formaearte.com.br", "data":"2026-01-07", "autor": "Flavio Silva" }

}
