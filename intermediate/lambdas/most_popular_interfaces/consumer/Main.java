package lambdas.most_popular_interfaces.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
public class Main {

	public static void main(String[] args) {

		/*
		 * a interface consumer e comumente usada para modificar valores por ela nao
		 * retorna nenhum dado
		 */

		Product p1 = new Product("prestobarba", 7.25);
		Product p2 = new Product("cafe", 17.15);
		Product p3 = new Product("margarina", 13.55);
		Product p4 = new Product("bife alcatra", 37.75);
		
		Consumer<Product> products = p -> System.out.println(p.getPrice());
		
		products.accept(p1);
		products.accept(p2);
		products.accept(p3);
		products.accept(p4);
		
		System.out.println("\n passando o consumer para o metodo forEach\n");
		List<Product> listP = Arrays.asList(p1, p2, p3, p4);
		listP.forEach(products);
		
		/*
		 * Vamos encadear interfaces para se obter os precos abaixo de 18
		 * - Predicate para fazer o teste booleano e retornar os precos
		 * segundo a logica definida
		 * - encadeado pelo metodo toList da api stream formando uma nova lista
		 * com os precos retornados pelo filter que usa o predicate,
		 * em seguida encadeamos com o forEach para imprimir os valores dassa lista */
		System.out.println("\n encadeando interfaces \n");
		
		Predicate<Product> LowestPriceProducts = p -> p.getPrice() <= 18.0;
		listP.stream().filter(LowestPriceProducts).toList().forEach(products);
	}

}
