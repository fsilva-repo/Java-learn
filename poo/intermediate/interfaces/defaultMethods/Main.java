package poo.intermediate.interfaces.defaultMethods;

public class Main {

	public static void main(String[] args) {

		BrazilianInterestService brService = new BrazilianInterestService();
		IO.println(brService.paymentFee(200.0, 2.05, 3));
		
		IO.println("-----------------------------");
		
		UsaInterestService usService = new UsaInterestService();
		IO.println(usService.paymentFee(200.0, 1.25, 3));
	}

}
