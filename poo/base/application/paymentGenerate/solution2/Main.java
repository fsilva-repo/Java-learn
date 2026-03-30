package poo.base.application.paymentGenerate.solution2;

import poo.base.application.paymentGenerate.solution2.entities.Contract;
import poo.base.application.paymentGenerate.solution2.services.ContractService;
import poo.base.application.paymentGenerate.solution2.services.PaymentService;

public class Main {

	void main() {
		PaymentService paymentService = new PaymentService();
		paymentService.setMonths(3);
		paymentService.processPayment(600, paymentService.getMonths());
				
		Contract contract = new Contract.Builder().withDate("28/03/2026")
				.withNumber(8291).withTotalValue(600).build();
		
		ContractService contractService = new ContractService.Builder()
				.withMonths(paymentService.getMonths()).withContract(contract).withPaymentService(paymentService).build();
		contractService.processContract();

	}

	
	
	
	
}
