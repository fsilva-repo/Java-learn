package poo.intermediate.set.personalHashCode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
	
		Set<? super Object> set = new HashSet<>();
		
		Person p1 = new Person("Jack", 30, 6);
		set.add(new Person("Silva", 30, 5));
		set.add(new Person("John", 30, 1));
		set.add(new Person("Mike", 30, 3));
		set.add(new Person("John", 30, 2));
		set.add(new Person("Lauren", 30, 4));
		set.add(new Person("Carlos", 30, 5));// não será adicionado, pois tem o mesmo id do Silva
		
		set.add(p1);
		
		set.forEach(System.out::println);
		System.out.println(set.contains(new Person("Jack", 30, 6)));

		System.out.println("_________________________");
		
		
		
		
		Set<? super Object> set2 = new LinkedHashSet<>();
		
		set2.add(new Person("Jhonson", 30, 5));
		set2.add(new Person("Silva", 30, 3));
		set2.add(new Person("John", 30, 1));
		set2.add(new Person("Lauren", 30, 4));
		set2.add(new Person("Mike", 30, 2));
		set2.add(new Person("Michael", 30, 6));
	
	
		set2.forEach(System.out::println);
	
		
		
		System.out.println("_________________________");
	
	
		Set<Product> set3 = new TreeSet<>();
		
	// o TreeSet usa o compareTo para comparar os objetos, e nesse caso ele compara pelo id, então não aceita produtos com o mesmo id
		set3.add(new Product("Tablet", 1500, 4));
		set3.add(new Product("TV", 2000, 1));
		set3.add(new Product("Smartphone", 3000, 3));
		set3.add(new Product("Monitor", 500, 5));
		set3.add(new Product("Notebook", 4000, 2));
	
		set3.forEach(System.out::println);
		
	}

}
















