import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.*;
public class Main {
	public static void main(String[] args) {


		Product p1 = new Product("vasoura", 13.75);
		Product p2 = new Product("vaso com flor", 16.50);
		Product p3 = new Product("Patins", 75.0);
		Product p4 = new Product("Patinete", 123.0);
		Product p5 = new Product("Escova de Cabelos", 7.80);
		Product p6 = new Product("Secador de cabelos", 89.90);

		List<Product> list = Arrays.asList(p1, p2, p3, p4, p5, p6);

		UnaryOperator<Double> discount = n -> n = n - (n * 15) / 100;
		Predicate<Product> priceGreaterThan = p -> p.getPrice() >= 50.0;
		Consumer<Product> productName = p -> System.out.println(p.getName());
		Supplier<String> supplier = () -> "Esta lista esta vazia!";
		Function<List<Product>, List<String>> newList = l -> l.stream()
																										.map(p -> p.getName())
																										.toList();

		try {

			if (list.isEmpty()) {
        throw new IllegalArgumentException(supplier.get());
    	}

    	list.stream()
    			.filter(p -> priceGreaterThan.test(p))
    			.map(p -> discount.apply(p.getPrice()))
    			.toList()
    			.forEach(System.out::println);




		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		}

		
	}
}