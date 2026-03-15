import java.util.function.Consumer;
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

		Consumer<Product> extractor = p -> System.out.println(p.getName());

		list.forEach(extractor::accept);

		System.out.println("\n");

		Consumer<Product> extractorPrice = p -> System.out.println(p.getPrice());

		Consumer<Product> combined = extractor.andThen(extractorPrice);

		list.forEach(p -> combined.accept(p));



	}
}
















