package poo.intermediate.interfaces.compareble;

public class Employee implements Comparable<Employee> {
	
	private String name;
	private double salary;
	
	public Employee() {}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public void setName(String name) {this.name = name;}
	public void setSalary(double salary) {this.salary = salary;}
	public String getName() {return name;}
	public Double getSalary() {return salary;}
	@Override
	public int compareTo(Employee o) {
		return name.compareTo(o.getName());
	}
	
}
