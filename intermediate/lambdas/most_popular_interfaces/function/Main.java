package lambdas.most_popular_interfaces.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {

		Person p1 = new Person("Maria", 32);
		Person p2 = new Person("Roger", 45);
		Person p3 = new Person("Joas", 42);
		Person p4 = new Person("Brito", 36);

		List<Person> persons = Arrays.asList(p1, p2, p3, p4);

		/*
		 * A interface Function e muito util nas operacaoes onde se recebe um argumento
		 * e retorna um resultado
		 */

		Function<Person, String> person = p -> {
			/*
			 * Aqui a interface recebe um objeto e retorna uma string conforme a sua logica
			 */
			String persoName = null;
			if (p.getAge() <= 40)
				persoName = p.getName();
			return persoName;
		};

		Consumer<String> name = str -> System.out.println(str);

		persons.forEach(p -> name.accept(person.apply(p)));
	}

}
