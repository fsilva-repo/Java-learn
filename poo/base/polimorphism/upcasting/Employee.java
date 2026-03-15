package poo.base.polimorphism.upcasting;

public class Employee {
	private int id;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepartament() {
		return departament;
	}
	public Employee(int id, String name, String departament) {
		super();
		this.id = id;
		this.name = name;
		this.departament = departament;
	}
	private String name;
	private String departament;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", departament=" + departament + "]";
	}
	
	
}
