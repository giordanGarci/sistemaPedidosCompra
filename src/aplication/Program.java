package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = scan.nextLine();
		Date date = sdf.parse(birthDate);

		Client client = new Client(name, email, date);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(scan.nextLine());

		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order: ");
		int quantity = scan.nextInt();
		System.out.println();

		for (int i = 1; i <= quantity; i++) {
			System.out.println("Enter #" + i + " item data:	");
			System.out.print("Name: ");
			scan.nextLine();
			String nameProduct = scan.nextLine();
			System.out.println("Price: ");
			int priceProduct = scan.nextInt();
			System.out.println("Quantity: ");
			int quantityProduct = scan.nextInt();

			Product product = new Product(nameProduct, priceProduct);
			OrderItem item = new OrderItem(quantity, priceProduct, product);
			order.addItem(item);
		}

		System.out.println();
		System.out.println("ORDER SUMMARY:  ");
		System.out.println(order);

	}
}
