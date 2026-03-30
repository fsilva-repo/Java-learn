package poo.base.application.hotel;

public class Renter {
	private String name;
	private int cpf;
	private int phone;
	public Renter(String name, int cpf, int phone) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public int getCpf() {
		return cpf;
	}
	public int getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "Inquilino [ Nome: " + name + ", CPF: " + cpf + ", Tel: " + phone + " ]";
	}
	

	
}
