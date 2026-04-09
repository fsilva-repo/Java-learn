package poo.intermediate.functionalProgramming.functionalInterfaces.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

	void main() {
		
		List<Person> users = new ArrayList<>();
		
		Person person1 = new Person("Alice", 30, 1);
		Person person2 = new Person("Bob", 25, 2);
		Person person3 = new Person("Charlie", 35, 3);
		Person person4 = new Person("Diana", 28, 4);
		Person person5 = new Person("Eve", 22, 5);
		
		users.add(person1);
		users.add(person2);
		users.add(person3);
		users.add(person4);
		users.add(person5);
		
		// extraindo o nome dos usuários com id par utilizando a interface funcional Function
		Function<Person, String> extractName = user -> user.getName();
		
		// filtrando os primeiros 50 usuários e extraindo seus nomes utilizando o método map da Stream API
		users.stream().filter(user -> user.getId() <= 50).map(extractName).forEach(System.out::println);
		
	}

}























