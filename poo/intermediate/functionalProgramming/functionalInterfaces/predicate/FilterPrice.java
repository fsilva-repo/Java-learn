package poo.intermediate.functionalProgramming.functionalInterfaces.predicate;

public class FilterPrice {

	public static boolean testPrice(Product product) {
		return product.getPrice() >= 1000.00;
	}
}
