package poo.base.application.paymentGenerate;

import poo.base.application.paymentGenerate.services.InvoiceGenerate;

public class Main {

	void main() {
		
		InvoiceGenerate i = new InvoiceGenerate();
		IO.println(i.toGenerate(600, 3));
		
	
	}

}
