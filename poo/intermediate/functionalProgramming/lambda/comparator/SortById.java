package poo.intermediate.functionalProgramming.lambda.comparator;

import java.util.Comparator;
import java.util.List;

public class SortById<T> implements Comparator<T> {

	@Override
	public int compare(T t1, T t2) {
		return Integer.compare(((Product) t1).getId(), ((Product) t2).getId());
	}

	public void comparator(List<T> list) {
		list.sort(this);
		list.forEach(System.out::println);
	}

}
