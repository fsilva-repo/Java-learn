package poo.base.enumerator;

import java.time.LocalDate;

public class Order {
	private Integer id;
	private LocalDate moment;
	private OrderStatus status;
	public Order(Integer id, LocalDate moment, OrderStatus status) {
		super();
		this.id = id;
		this.moment = moment;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public LocalDate getMoment() {
		return moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "Order [id: " + id + ", moment: " + moment + ", status: " + status + "]";
	}
	
}
