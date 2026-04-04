package poo.intermediate.covariance_contravariance.principleGetPut;

import java.util.ArrayList;
import java.util.List;

public class Main {

	void main() {

		/* a copia sera do tipo Double para o super tipo Number */

		List<Number> listNum = new ArrayList<>();
		List<Double> listDouble = new ArrayList<>();
		List<Object> listObj = new ArrayList<>();

		listNum.add(1);
		listNum.add(2);
		listNum.add(3);

		listDouble.add(1.0);
		listDouble.add(2.0);
		listDouble.add(3.0);

		PrintList.copy(listNum, listObj);
		PrintList.copy(listDouble, listObj);

		for (Object number : listObj) {
			System.out.println(number);
		}

		@SuppressWarnings("unused")
		List<? extends Number> listNum2 = new ArrayList<>();
		List<? super Number> listNum3 = new ArrayList<>();

		/*
		 * listNum2.add(1); nao é permitido adicionar um elemento a uma lista do tipo
		 * extends exceto null listNum2.add(null); pos o tipo de elemento da lista é
		 * desconhecido, ou seja, poderia ser qualquer subtipo de Number e isso poderia
		 * gerar um erro de tipo em tempo de execução
		 */

		listNum3.add(1);

		listNum3.get(0); // o tipo de elemento da lista é desconhecido, ou seja, poderia ser qualquer
											// subtipo de Number e isso poderia gerar um erro de tipo em tempo de execução
		
		System.out.println(listNum3.get(0));
	}

}












