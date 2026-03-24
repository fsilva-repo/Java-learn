package poo.base.application.paymentGenerate.entities;

import java.time.LocalDate;
import java.util.List;

import poo.base.application.paymentGenerate.services.InvoiceGenerate;

public class Invoice {
	private LocalDate invoiceDueDate;
	private InvoiceGenerate invoiceGenerate;
	
	public Invoice(InvoiceGenerate invoiceGenerate, LocalDate invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
		this.invoiceGenerate = invoiceGenerate;
	}

	public LocalDate getInvoiceDueDate() {
		return invoiceDueDate;
	}


	public List<Double> getInvoiceGenerate(double contractValue, int installmentQuantity) {
		return invoiceGenerate.toGenerate(contractValue, installmentQuantity);
	}

	
}
