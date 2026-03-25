package poo.base.application.paymentGenerate.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerate {

	private int installmentQuantity;
	private double contractValue;
	
	public int getInstallmentQuantity() {return installmentQuantity;}
	public void setInstallmentQuantity(int installmentQuantity) {this.installmentQuantity = installmentQuantity;}
	public double getContractValue() {return contractValue;}
	public void setContractValue(double contractValue) {this.contractValue = contractValue;}

	private double valueOfInstallment;
	private double simpleRate;
	private double interestOnPayment;
	private double taxGenerated;
	
	public List<Double> installments = new ArrayList<>();
	public List<String> billings = new ArrayList<>();
	
	public List<Double> toGenerate() {
		valueOfInstallment = getContractValue() / getInstallmentQuantity();
	
		for (int i = 0; i <= this.installmentQuantity; i++) {
			simpleRate = valueOfInstallment * i / 100;// extrai o juros simples
			interestOnPayment = valueOfInstallment * 2 / 100;// extrai o juros sobre o valor da parcela
			taxGenerated = simpleRate + interestOnPayment;// gera o valor do imposto a ser pago
			installments.add(valueOfInstallment + taxGenerated);// adiciona a lista o imposto somado ao valor da parcela
		}
		return installments;
	}
	
	public List<String> toGenerateBilling() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.now();
		
		for (int i = 0; i < this.installmentQuantity; i++) {
			LocalDate nextInvoice = date.plusMonths(i + 1);
			billings.add(nextInvoice.format(formatter));
		}
		return billings;
	}
}













