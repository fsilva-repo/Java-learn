package poo.intermediate.interfaces.defaultMethods;

public interface PaymentService {

	default Double paymentFee(Double amount, double interestRate, int months) {
		if (months < 1) {
			throw new IllegalArgumentException("Months must be greater than zero");
		} 
			double fee = (1.0 + interestRate / 100.0);
			return amount * Math.pow(fee, months);	
	}

}
