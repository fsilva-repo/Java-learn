package poo.base.application.enterprise.entities;

import java.util.*;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();


	public Worker(String name, WorkerLevel level, double baseSalary, String departamentName) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = new Departament(departamentName);
	}
	// *** getter *** //
	public String getName() {
		return name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public Departament getDepartament() {
		return departament;
	}

	
	// *** METHODS ** //
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	public void removeContract(HourContract contract) {
		for(HourContract cont : contracts) {
			if(contract == cont) {
				contracts.remove(cont);
			}
		}
	}

	
	public double income(int year, int month) {
		double sum = baseSalary;
		
		for(HourContract c : contracts) {
			if( c.date().getYear() == year && c.date().getMonthValue() == month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	@Override
	public String toString() {
		return "Worker [name: " + name + ", level: " + 
				level + ", base salary: " + baseSalary + 
				", departament: " + departament.getName()
				+ "]";
	}
	
	
}




















