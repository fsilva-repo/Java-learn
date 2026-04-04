package poo.intermediate.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// incersão desordenada o conjunto mais rapido O(1), e não aceita duplicatas
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(8);
		set.add(9);
		set.add(10);
		set.add(1);

		// consultar
		System.out.println(set.contains(5)); // true
		System.out.println(set.contains(11)); // false

		// remover
		set.remove(5);
		System.out.println(set.contains(5)); // false

		// iterar
		set.forEach(System.out::println);

		System.out.println("_________________________");

		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);

		// união entre os conjuntos;
		set.addAll(list);
		// System.out.println(set.retainAll(list));
		System.out.println(set);

		System.out.println("_________________________");

		// mantem a ordem de incersão, rapido mas perde para o HasSet O(1) também não
		// aceita duplicatas
		Set<Integer> linkedSet = new LinkedHashSet<>();

		linkedSet.addAll(set);

		List<Integer> list2 = new ArrayList<>();
		list2.add(34);
		list2.add(21);
		list2.add(17);
		list2.add(11);

		linkedSet.addAll(list2);
		// System.out.println(linkedSet.retainAll(list2));
		System.out.println(linkedSet);

		/*
		 * o mais lento entre os três O(log n), os elementos incerido sarão ordenados
		 * por ordem natural ou especificado não aceitará duplicatas nem null
		 */
		Set<String> a = new TreeSet<>();

		a.add("Maçã");
		a.add("Banana");
		a.add("Maçã");// não sera adicionado
		a.add("Melão");
		a.add("Uva");
		a.add("Pera");

		a.forEach(System.out::println);
		
		System.out.println("_________________________");
		
		a.stream().filter(p -> p.length() <= 4)// filtra
		.collect(Collectors.toCollection(TreeSet::new))// coleta para uma nova coleção
		.forEach(System.out::println);// imprime
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
