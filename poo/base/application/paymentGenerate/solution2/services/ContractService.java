package poo.base.application.paymentGenerate.solution2.services;

import poo.base.application.paymentGenerate.solution2.entities.Contract;
import poo.base.application.paymentGenerate.solution2.entities.Installment;

public class ContractService {
	private Installment installment;
	private PaymentService paymentService;
	private Contract contract;
	private int months;

	private ContractService(Builder builder) {
		this.months = builder.months;
		this.installment = builder.installment;
		this.contract = builder.contract;
		this.paymentService = builder.paymentService;
	}
	
	public static class Builder {
		private Installment installment;
		private PaymentService paymentService;
		private Contract contract;
		private int months;

		public Builder withInstallment(Installment installment) {
			this.installment = installment;return this;}
		public Builder withPaymentService(PaymentService paymentService) {
			this.paymentService = paymentService;return this;}
		public Builder withContract(Contract contract) {this.contract = contract;return this;}
		public Builder withMonths(int months) {this.months = months;return this;}
		public ContractService build() {return new ContractService(this);}
	}

	public Installment getInstallment() {return installment;}
	public PaymentService getPaymentService() {return paymentService;}
	public Contract getContract() {return contract;}
	public int getMonths() {return months;}

	public void processContract() {
		Installment installment = new Installment(contract.getDate(), contract.getTotalValue());
		Installment updatedInstallment = null;

		IO.println("");
		StringBuilder sb = new StringBuilder();
		sb.append("numero: " + contract.getNumber() + "\n");
		sb.append("data: " + contract.getDate() + "\n");
		sb.append("valor: " + contract.getTotalValue() + "\n");
		sb.append("parcelas: " + paymentService.getMonths() + "\n");
		
		for (int i = 1; i <= paymentService.getMonths(); i++) {
			//DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				updatedInstallment = new Installment(installment.getDueDate().plusMonths(i),
					paymentService.processPayment(installment.getAmount(), paymentService.getMonths()).get(i - 1));
				
				sb.append("\n");
				sb.append("parcela " + i + ": \n");
				sb.append("data da parcela: " + updatedInstallment.getDueDate() + "\n");
				sb.append("valor da parcela: " + updatedInstallment.getAmount() + "\n");
		}
		
		
		System.out.println(sb.toString());
	}


}















