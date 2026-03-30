package poo.base.enumerator;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		Order order = new Order(1804, date,  OrderStatus.PENDING_PAYMENT);
		IO.println(order.toString());

	}

}
