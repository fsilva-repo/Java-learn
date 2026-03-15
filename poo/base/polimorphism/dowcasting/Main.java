package poo.base.polimorphism.dowcasting;

public class Main {

	public static void main(String[] args) {
		
		Contracted m1 = new Contracted("Osmar Leme", "gerencia 1", 901);
	//	Outsourced m2 = (Outsourced) m1;
		System.out.println(m1.getId());
		
		Contracted a1 = new Outsourced("Julho Monteiro", "açogue", 902);
		
		Outsourced a2 = (Outsourced) a1; //new Contracted("Maria Santos", "gerente compras", 905);
		
		System.out.println(a1.getName());
		
		
		System.out.println(a2.getName());

		
	}

}
