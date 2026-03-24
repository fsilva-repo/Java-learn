package poo.base.flowControl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	void main() {

		Scanner sc = new Scanner(System.in);

		IO.print("\nFaça seu pedido\n");

		IO.print("\nNúmero - 1 ");
		IO.print("R$ 22,90 (combo - Chicken Jr. ou Cheeseburger, McFritas pequena)");
		double price1 = 22.90;
		String order1 = "combo - Chicken Jr. ou Cheeseburger, McFritas pequena";

		IO.print("\nNúmero - 2 ");
		IO.print("R$ 12,90 (Cheddar McMelt.)");
		double price2 = 12.90;
		String order2 = "Cheddar McMelt";

		IO.print("\nNúmero - 3 ");
		IO.print("R$ 18,90 (Duplo Cheddar McMelt.)");
		double price3 = 18.90;
		String order3 = "Duplo Cheddar McMelt";

		IO.print("\nNúmero - 4 ");
		IO.print("R$ 19,90 (Stranger Burguer Sandwich.)");
		double price4 = 19.90;
		String order4 = "Stranger Burguer Sandwich";

		IO.print("\nNúmero - 5 ");
		IO.print("R$ 28,90 (Duplo Quarterão.)");
		double price5 = 28.90;
		String order5 = "Duplo Quarterão";

		IO.print("\nNúmero - 6 ");
		IO.print("R$ 28,90 (Quarterão com Queijo.)\n");
		double price6 = 28.90;
		String order6 = "Quarterão com Queijo";

		System.out.print("\nNúmero do pedido: ");
		int foodNumber = sc.nextInt();

		List<Double> listPriceFood = Arrays.asList(price1, price2, price3, price4, price5, price6);
		List<String> listOrderFood = Arrays.asList(order1, order2, order3, order4, order5, order6);

		// double chosenFood =

		System.out.print("\nGostaria de uma bebida: ");
		// seria dois botoes sim ou nao
		//boolean isDrink = sc.nextBoolean();

		IO.println("\nEscolha sua bebida");
		
		IO.print("\nNúmero - 1 ");
		IO.print("R$ 5,50 (Cocacola 350ml)");
		double priceDrink1 = 5.50;
		String orderDrink1 = "Cocacola 350ml";

		IO.print("\nNúmero - 2 ");
		IO.print("R$ 5,50 (fanta laranja 350ml)");
		double priceDrink2 = 5.50;
		String orderDrink2 = "fanta laranja 350ml";

		IO.print("\nNúmero - 3 ");
		IO.print("R$ 3,50 (mate 350ml)");
		double priceDrink3 = 3.50;
		String orderDrink3 = "mate 350ml";

		IO.print("\nNúmero - 4 ");
		IO.print("R$ 8,50 (suco uva 350ml)\n");
		double priceDrink4 = 8.50;
		String orderDrink4 = "suco uva 350ml";

		System.out.print("\nNúmero da bebida: ");

		int drinkNumber = sc.nextInt();

		List<Double> listPriceDrink = Arrays.asList(priceDrink1, priceDrink2, priceDrink3, priceDrink4);
		List<String> listOrderDrink = Arrays.asList(orderDrink1, orderDrink2, orderDrink3, orderDrink4);

		String orderDrink = listOrderDrink.get(drinkNumber - 1);
		double priceDrink = listPriceDrink.get(drinkNumber - 1);

		String orderFood = listOrderFood.get(foodNumber - 1);
		double priceFood = listPriceFood.get(foodNumber - 1);

		IO.println("\n" + priceFood + ", " + orderFood);
		IO.println(priceDrink + ", " + orderDrink);

		double total = priceDrink + priceFood;
		IO.println("-------------------------------------------");
		IO.println(total);

		sc.close();

	}
}