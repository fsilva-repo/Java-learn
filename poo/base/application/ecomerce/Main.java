package poo.base.application.ecomerce;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ** SET CLIENT ** //
		Client client = new Client();
		IO.print("Client name: ");
		String name = sc.nextLine();
		IO.print("email: ");
		String email = sc.next();
		IO.print("birthday: ");
		String inputDate = sc.next();
		client.setName(name);
		client.setEmail(email);
		try {
			LocalDate birthday = LocalDate.parse(inputDate);
			client.setBirtDate(birthday);

		} catch (DateTimeParseException e) {
			String error = String.valueOf(e);
			if (error.length() != 0) {
				IO.print("corrija a data de nascimento para o padão (ano-mes-dia)\n");
				IO.print("birthday: ");
				inputDate = sc.next();
			}
		}

		// ** SET PRODUCT ** //
		IO.print("product name: ");
		String productName = sc.nextLine();
		productName = sc.nextLine();
		IO.print("product price: ");
		double productPrice = sc.nextDouble();
		Product newProduct1 = new Product(productName, productPrice);

		IO.print("product name: ");
		String productName2 = sc.nextLine();
		productName2 = sc.nextLine();
		IO.print("product price: ");
		double productPrice2 = sc.nextDouble();
		Product newProduct2 = new Product(productName2, productPrice2);

		// ** ORDER ITEMS ** //
		OrderItem orderItem = new OrderItem(123);
		orderItem.addProduct(newProduct1);
		orderItem.addProduct(newProduct2);

		// ** SET ORDER ** //
		Order order = new Order();
		order.setClient(client);
		order.addOrder(orderItem);
		order.setStatus(1);

		IO.println("-------------------------");
		IO.println(order);
		sc.close();

	}

}
