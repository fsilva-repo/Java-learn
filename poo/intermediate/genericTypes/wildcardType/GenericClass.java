package poo.intermediate.genericTypes.wildcardType;

import java.util.List;

public class GenericClass<T> {

	public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("The list is empty");
		}

		T max = list.get(0);
		for (T item : list) {
			if (item == null || max == null) {
				throw new IllegalArgumentException("Null elements not allowed");
			} else if (item.compareTo(max) > 0) {
				max = item;

			}
		}

		return max;
	}

}
