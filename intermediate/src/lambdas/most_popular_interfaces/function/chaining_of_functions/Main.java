package lambdas.most_popular_interfaces.function.chaining_of_functions;
import java.util.*;
import java.util.function.*;
public class Main {

	public static void main(String[] args) {

		Person p1 = new Person("Ana", 18);
		Person p2 = new Person("Gustavo", 32);
		Person p3 = new Person("Leticia", 24);
		Person p4 = new Person("Gilvan", 48);
		Person p5 = new Person("Abel", 22);

		// lista imutavel
		List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);

		/*
		 * encadeamento de metodos com o compose.
		 * o compose aplica um metodo ao resultado
		 * do primeiro
		*/
		Function<Person, String> personName = p -> p.getName();
		Function<String, Integer> lenghtName = p -> p.length();

		String resultAString = personName.apply(p2);
		int resultComposition = lenghtName.compose(personName).apply(p2);

		String printMsg = String.format("Nome: %s composto por %d letras", resultAString, resultComposition);
		System.out.println(printMsg);

		System.out.println("");
		/*
		 * encadeando metodos com o andThen.
		 * esse metodo retorna o resultado de um compose.
		 * lendo o metodo abaixo podemo dizer que:
		 * personName retorna uma string andThen (e entao)
		 * chama o metodo lenghtName resultando em um numero inteiro
		*/

		System.out.println(personName.andThen(lenghtName).apply(p3));
		int result = personName.andThen(lenghtName).apply(p3);
		String name = personName.apply(p3);
		String msg = String.format("nome: %s composto por %d letras", name, result);
		System.out.println(msg);
	}
}