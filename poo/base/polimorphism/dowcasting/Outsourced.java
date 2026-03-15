package poo.base.polimorphism.dowcasting;

import java.time.*;
public class Outsourced extends Contracted {

	private LocalDate contractExpiration;
	
	public Outsourced(String name, String departament, int id) {
		super(name, departament, id);
	}

	public LocalDate getContractExpiration() {
		return contractExpiration;
	}

	public void setContractExpiration(int y, int m, int d) {
		this.contractExpiration = LocalDate.of(y, m, d);
	}
}
