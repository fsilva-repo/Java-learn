package poo.base.application.paymentGenerate;

import java.util.List;

import poo.base.application.paymentGenerate.services.InvoiceGenerate;

public class Main {

	void main() {
		
		InvoiceGenerate invoice = new InvoiceGenerate();
		invoice.setContractDate("28/04/2026");
		invoice.setContractValue(600);
		invoice.setInstallmentQuantity(3);
		invoice.toGenerateBilling();
		invoice.toGenerate();
		
		List<Double> installments = invoice.toGenerate();
		List<String> billings = invoice.toGenerateBilling();
		
			for (int i = 0; i < invoice.getInstallmentQuantity(); i++) {
				System.out.println(billings.get(i) + " - " + installments.get(i));
			}
		
	}

}
