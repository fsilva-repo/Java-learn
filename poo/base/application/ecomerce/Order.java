package poo.base.application.ecomerce;

import java.time.LocalDate;
import java.util.*;

public class Order {
	private LocalDate moment;
	private OrderStatus status;
	private int statusNumber;
	private Client client;

 public Order() {
	 this.moment = LocalDate.now();
 }

	public LocalDate getMoment() {
		return moment;
	}

	public void setStatus(int number) {
		this.statusNumber = number;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	List<OrderItem> orderItens = new ArrayList<>();

	public void addOrder(OrderItem item) {
		orderItens.add(item);
	}

	public void removeItem(int id) {
		for (OrderItem item : orderItens) {
			if (id == item.getId()) {
				orderItens.remove(id);
			}
		}
	}

	public Client customer() {
		return client;
	}

	private OrderStatus statusOrder() {
		switch (statusNumber) {
		case 1:
			this.status = OrderStatus.PENDING_PAYMENT;
			break;

		case 2:
			this.status = OrderStatus.PROCESSSING;
			break;

		case 3:
			this.status = OrderStatus.SHIPPED;
			break;

		case 4:
			this.status = OrderStatus.DELIVERED;
			break;
		}
		
		return status;
	}

	public double total() {
		double sum = 0;
		for (OrderItem item : orderItens) {
			sum += item.subTotal();
		}
		return sum;
	}

	public int item() {
		int quant = 0;
		for (OrderItem item : orderItens) {
			quant += item.getQuantily();
		}
		return quant;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Costumer: " + client.getName() + "\n");
		sb.append("Date: " + moment + "\n");
		sb.append("Items: " + item() + "\n");
		sb.append("Total: " + total() + "\n");
		sb.append("Status: " + statusOrder() + "\n");

		return sb.toString();
	}

}
