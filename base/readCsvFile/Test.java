package poo.base.readCsvFile;


//por que ao iterer um array da forma que esta sendo feita abaixo
//apenas o nome Abner sera mostrado no console, qual a razão disso

public class Test {
	public static void main(String[] args) {
		
		String[] names = {"Maria", "Pedro", "Julia", "Abner"};
		String allNames = null;
		for (String name : names) {
			allNames = name;
		}
		System.out.println(allNames);
	}
}

// resultado: Abner