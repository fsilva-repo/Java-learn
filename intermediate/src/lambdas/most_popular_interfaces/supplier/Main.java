package lambdas.most_popular_interfaces.supplier;

import java.util.function.Supplier;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		/*
		 * Supplier é uma interface funcional, o que significa que
		 * ela tem apenas um método abstrato. Isso permite que seja usada com expressões
		 * lambda ou referências de métodos.
		 * 
		 * O único método da interface Supplier é o get(), que não recebe
		 * parâmetros e retorna um valor do tipo especificado.
		 * 
		 * Genérica: A interface Supplier é genérica, ou seja, você pode especificar o
		 * tipo de dado que ela retorna. Por exemplo, Supplier<String> retorna uma
		 * String, e Supplier<Integer> retorna um Integer
		 */

		/* assinatura do interface
		 * @FunctionalInterface public interface Supplier<T> { T get(); }
		 */
		
		/*
		 * aqui a interface Supplier fornecera um numero aleatorio de 0 a 100,
		 * com isso chamaremos a interface para gerar 30 numeros e 
		 * preencher uma lista de numeros
		 */
		Supplier<Double> supplierRandom = () -> (Math.random() * 100);
		

		List<Integer> numberList = new ArrayList<>();
		int i = 0;
		while(i < 30) {
			int randNumber = supplierRandom.get().intValue();
			numberList.add(randNumber);
			i++;
		}
	
		numberList.forEach(System.out::println);
	}

}























