package poo.intermediate.genericTypes.useE;

import java.util.ArrayList;
import java.util.List;

public class ElementList<E> {

	private List<E> elements = new ArrayList<>();

	public void add(E e) {
		elements.add(e);
	}

	public E getIndex(int index) {
		if (elements.isEmpty()) {
			throw new IllegalStateException("The list is empty");
		} else if (index < 0 || index >= elements.size()) {
			throw new IndexOutOfBoundsException("index: " + index + ", The list size is: " + elements.size());
		}
		return elements.get(index);
	}

	public List<E> getElement() {
		if (elements.isEmpty()) {
			throw new IllegalStateException("The list is empty");
		}
		return elements;
	}

	public void clear(int index) {
		elements.remove(index);
	}
	
	
	@Override
	public String toString() {
		return elements.toString();
	}

}
