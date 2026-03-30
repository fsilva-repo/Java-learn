package poo.base.polimorphism.upcasting;

public class Manager extends Employee {
	
	private double monthlySummary;

	public Manager(int id, String name, String departament) {
		super(id, name, departament);
	}
	// account management  purchasing manager
	
	public double getMonthlySummary() {
		return monthlySummary;
	}

	public void setMonthlySummary(double monthlySummary) {
		this.monthlySummary = monthlySummary;
	}
	
}
