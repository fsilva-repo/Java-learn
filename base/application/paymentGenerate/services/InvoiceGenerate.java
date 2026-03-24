package poo.base.application.paymentGenerate.services;

import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerate implements ServiceFee {

	private double valueOfInstallment;
	private double simpleRate;
	private double interestOnPayment;
	private double interestTotal;
	public List<Double> installments = new ArrayList<>();
	
	@Override
	public List<Double> toGenerate(double contractValue, int installmentQuantity) {
		valueOfInstallment = contractValue / installmentQuantity;
	
		for (int i = 0; i <= installmentQuantity; i++) {
			simpleRate = valueOfInstallment * i / 100;
			interestOnPayment = valueOfInstallment * 2 / 100;
			interestTotal = simpleRate + interestOnPayment;
			
			installments.add(valueOfInstallment + interestTotal);
		}
		
		return installments;
	}
	
}













