package poo.base.application.paymentGenerate.solution2.services;

import java.util.ArrayList;
import java.util.List;

public class PaymentService implements OnlinePaymentService {

	private int months;
	
	public int getMonths() {return months;}
	public void setMonths(int months) {this.months = months;}

	@Override
	public double paymentFee(double amount, double percentage) {
		return amount * percentage / 100;
	}

	@Override
	public double interestOnPayment(double amount, double percentage) {
		return amount * percentage / 100;
	}

	public List<Double> processPayment(double amount, int months) {
		List<Double> payments = new ArrayList<>();
		double installmentAmount = amount / months;
		for (int i = 1; i <= months; i++) {
			double updatedAmount = amount + interestOnPayment(installmentAmount, 2) + paymentFee(installmentAmount, i);
			payments.add(updatedAmount);
		}
		return payments;
	}
}
