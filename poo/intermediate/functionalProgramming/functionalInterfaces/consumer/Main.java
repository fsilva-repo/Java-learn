package poo.intermediate.functionalProgramming.functionalInterfaces.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		
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
		
		// interface funcional Consumer
		Consumer<Person> userLogad = user -> System.out.println("Usuario logado: " + user.getName());
		users.forEach(userLogad);
		
		System.out.println("-----------------------");
		// utilizando a expressao lambda diretamente no forEach para filtrar os usuários com idade menor ou igual a 30 anos
		users.stream().filter(user -> user.getAge() <= 30).forEach(userLogad);
		
		System.out.println("-----------------------");
		
		// utilizando a classe ClassConsumer para extrair os nomes dos usuários com id par e imprimir na tela
		ClassConsumer.printUsers(users).forEach(System.out::println);
		
	}

}













