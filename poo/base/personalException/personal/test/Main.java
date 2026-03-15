package poo.base.personalException.personal.test;

import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Date: ");
			String date = sc.next();
			
			//DateTimeFormatter patternISO = DateTimeFormatter.ISO_LOCAL_DATE;
			DateTimeFormatter customPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate getDate = LocalDate.parse(date, customPattern);
			LocalDate currentDate = LocalDate.now();
			String parse = currentDate.format(customPattern);
			LocalDate DateNow = LocalDate.parse(parse, customPattern);
			
			if(getDate.isAfter(DateNow)) {
				System.out.println(getDate);				
			} else {
				throw new DateTimeParseException("Data deve ser apos o dia de hoje", date, 0);
			}
			
			
		} catch(DateTimeParseException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorIndex());
			System.out.println(e.getParsedString());
		}
		sc.close();
	}

}
