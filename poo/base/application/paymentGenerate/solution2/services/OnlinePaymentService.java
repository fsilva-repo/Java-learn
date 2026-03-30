package poo.base.application.paymentGenerate.solution2.services;

public interface OnlinePaymentService {
	public double paymentFee(double amount, double percentage);
	public double interestOnPayment(double amount, double percentage);
	
} 
