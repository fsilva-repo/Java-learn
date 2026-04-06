package poo.intermediate.functionalProgramming.lambda.comparator;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Product p1 = new Product("TV", 900.00, 1);
		Product p2 = new Product("Notebook", 1200.00, 2);
		Product p3 = new Product("Tablet", 450.00, 3);
		Product p4 = new Product("Smartphone", 700.00, 4);
		
		List<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		SortByName<Product> compareName = new SortByName<>();

		compareName.comparator(list);
	
		System.out.println("-----------------------------");
		
		List<Product> list2 = new ArrayList<>();
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		list2.add(p4);
		
		SortById<Product> compare2 = new SortById<>();
		compare2.comparator(list2);
	}

}
