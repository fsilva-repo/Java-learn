package poo.base.application.paymentGenerate.test;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		
		LocalDate nextInvoice = date.plusMonths(1);
		
		System.out.println("Hoje" + date + "Proximo mes" +  nextInvoice);
		
	}

}
