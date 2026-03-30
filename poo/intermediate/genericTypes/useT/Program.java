package poo.intermediate.genericTypes.useT;

import java.util.ArrayList;
import java.util.List;

public class Program<T> {
	
	private List<T> list = new ArrayList<>();
	
	public void add(T element) {
		list.add(element);
	}

	public T get(int index) {
		if (list.isEmpty()) {
			throw new IllegalStateException("The list is empty.");
		} else if (index < 0 || index >= list.size()) {
			throw new IndexOutOfBoundsException("index: " + index + ", The list size is: " + list.size());
		}
		return list.get(index);
	}
	
	public String toString() {
		return list.toString();
	}


}
