package poo.base.application.carRentalCompany.entities;

public class Client {

	private String name;
	private int cnh;
	private String address;
	private Contract contract;
	
	private Client(Builder builder) {
		this.name = builder.name;
		this.cnh = builder.cnh;
		this.address = builder.address;
		this.contract = builder.contract;
	}
	
	public static class Builder {
		private String name;
		private int cnh;
		private String address;
		private Contract contract;
		
		public Builder name(String name) {this.name = name; return this;}
		public Builder cnh(int cnh) {this.cnh = cnh; return this;}
		public Builder address(String address) {this.address = address; return this;}
		public Builder contract(Contract contract) {this.contract = contract; return this;}
		
		public Client build() {
			return new Client(this);
		}
	}

	public String getName() {return name;}
	public int getCnh() {return cnh;}
	public String getAddress() {return address;}
	public Contract getContract() {return contract;}
	
	
}
