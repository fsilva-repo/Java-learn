package lambdas.most_popular_interfaces.predicate.predicate_example2;

import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * O predicate e ideal quando se
		 * precisa realizar um teste booleano  */
		Predicate<Double> rand = n -> n % 2 == 0;
		
		System.out.println(rand.test(23.0));
		System.out.println(rand.test(10.0));
		System.out.println(rand.test(32.50));
	}

}
