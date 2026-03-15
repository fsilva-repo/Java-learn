package lambdas.ready_functional;

import java.util.function.BinaryOperator;

public class Main {

	public static void main(String[] args) {
		/*
		 * Dê preferencia as interfaces funcionais ja prontas do java.util facilitando o
		 * trabalho de desenvolvimento
		 */

		/*
		 * substituindo a nossa interface Calculator pela BinaryOperator
		 */

		BinaryOperator<Double> mult = (a, b) -> {
			return a * b;
		};
		
		System.out.println(mult.apply(3.0, 32.0));
	}

}
