package poo.base.polimorphism.upcasting;

public class Main {

	public static void main(String[] args) {
		
		// upcasting
		Manager m3 = new Manager(456, "João hugo", "gerencia 3");
		Employee e1 = m3;
		
		IO.println(e1.getDepartament());
		
		Employee am1 = new Manager(789, "Claudia Mila", "gernte de contas");
		
		IO.println(am1.getName());
	}

}
