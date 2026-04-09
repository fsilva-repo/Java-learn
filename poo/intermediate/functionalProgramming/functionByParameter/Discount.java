package poo.intermediate.functionalProgramming.functionByParameter;

import java.util.function.Predicate;

public class Discount {
	
	// o metodo recebe um producto um predicado e um valor de desconto, então verificar se o desconto pode ser aplicado
	public static double applyDiscount(Product p, Predicate<Product> predicate, Double percentage) {
		double discountValue = 0.0;
		if (predicate.test(p)) {
			discountValue =  p.getPrice() * percentage / 100;
		} 
			return p.getPrice() - discountValue;
	}
}
