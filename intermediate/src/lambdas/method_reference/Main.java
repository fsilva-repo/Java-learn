package lambdas.method_reference;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> aprovadList = Arrays.asList("Ana", "Caleb", "Deborah", "Jonas", "Marcos");

		System.out.println("ForEach sem o reference");
		aprovadList.forEach((name) -> {
			System.out.println(name);
		});

		System.out.println("\nForEach com o reference");
		aprovadList.forEach(System.out::println);

		System.out.println("");

		/*
		 * passaremos o metodo da class Main como metodo de referencia, que recebe como
		 * argumento os nomes da lista de aprovados em seguida o imprime
		 */
		aprovadList.forEach(Main::printAprovads);
	}

	static void printAprovads(String name) {
		System.out.println("Aprovado(a): " + name);
	}
}
