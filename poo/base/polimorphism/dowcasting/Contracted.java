package poo.base.polimorphism.dowcasting;

public class Contracted {
	@Override
	public String toString() {
		return "Contracted [name=" + name + ", departament=" + departament + ", id=" + id + "]";
	}
	private String name;
	private String departament;
	private int id;
	public Contracted(String name, String departament, int id) {
		super();
		this.name = name;
		this.departament = departament;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getDepartament() {
		return departament;
	}
	public int getId() {
		return id;
	}
	
}
