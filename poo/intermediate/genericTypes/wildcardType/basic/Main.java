package poo.intermediate.genericTypes.wildcardType.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	void main() {
		
		/*
		 * Object é o super tipo de qualquer objeto
		 * porem uma lista de String por exemplo
		 * não pode ser um subtipo de Object.
		 * 
		 * o super tpo de uma lista é o wildcard: List<?>
		 *  */
		

		
		/*
		 *  pode comprometer o type safety ao longo do programa,
		 *  pois a lista pode conter qualquer tipo de objeto,
		 *  e isso pode levar a erros em tempo de execução
		 */
	
		List<Object> list5 = new ArrayList<>();
		
		list5.add(new Double[] {1.0, 2.0, 3.0});
		list5.add(new Double[] {4.0, 5.0, 6.0});
		
		PrintService.printList(list5);
		 System.out.println("-----------------------------");
		 
		List<String> list3 = Arrays.asList("Hello", "World");
		List<Integer> list4 = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6});
		
		PrintService.printList(list3);
		 System.out.println("-----------------------------");
		PrintService.printList(list4);
		
	}
}
















