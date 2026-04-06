package poo.intermediate.functionalProgramming.lambda.comparator;

import java.util.Comparator;
import java.util.List;

public class SortByName<T> implements Comparator<T> {

	@Override
	public int compare(T t1, T t2) {
		return t1.toString().toUpperCase().compareTo(t2.toString().toUpperCase());
	}

	public void comparator(List<T> list) {
		list.sort(this);
		list.forEach(System.out::println);
	}

}
