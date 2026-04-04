package poo.intermediate.genericTypes.wildcardType.basic;

import java.util.List;

public class PrintService {

	// ? = wildcard type
	public static void printList(List<?> list) {
		if (list.isEmpty()) {
			System.out.println("The list is empty");
			return ;
		}
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

}
