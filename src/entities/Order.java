package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enuns.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItems() {
		return items;
	}
	
	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		items.remove(orderItem);
	}
	
	public double total() {
		double sum = 0;
		for(OrderItem o : items) {
			sum += o.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order Status: " + status + "\n");
		sb.append("Cliente: " + client + "\n");
		sb.append("Order itens: \n");
		for(OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
}
