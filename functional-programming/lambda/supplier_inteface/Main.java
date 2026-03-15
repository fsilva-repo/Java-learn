import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.*;
public class Main {
	public static void main(String[] args) {


		Product p1 = new Product("vasoura", 13.75);
		Product p2 = new Product("vaso com flor", 16.50);
		Product p3 = new Product("Patins", 75.0);
		Product p4 = new Product("Patinete", 123.0);
		Product p5 = new Product("Escova de Cabelos", 7.80);
		Product p6 = new Product("Secador de cabelos", 89.90);

		List<Product> list = Arrays.asList();

		Predicate<Product> highestPrice = p -> p.getPrice() >= 70.0;
		Consumer<Product> productName = p -> System.out.println(p.getName());
		Supplier<String> supplier = () -> "Esta lista esta vazia!";
		Function<List<Product>, List<String>> newList = l -> l.stream()
																										.map(p -> p.getName())
																										.toList();

		try {

			if (!list.isEmpty()) {
				System.out.println(newList.apply(list));
			} else {
				throw new IllegalArgumentException(supplier.get());
			}

			// if (list.isEmpty()) {
      //   throw new IllegalArgumentException(supplier.get());
    	// }
    	// System.out.println(newList.apply(list));

		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		}

		
	}
}