package poo.base.ternary;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		boolean is;
		is = (4 >= 6) ? true : false;
		System.out.println(is);

		is = ('a' == 'A') ? true : false;
		System.out.println(is);

		String status = "Closed";
		int i = 1;

		status = (i > 0) ? status = "Open" : status;
		System.out.println(status);
		
		double price = 79.90;
		double discount = 0;
		
		discount = (price <= 50) ? price * 0.1 : price * 0.5;
		double rest = price - discount;
		
		IO.println("Preco: " + price + " desconto: " + discount + " Total: " + rest);
	}

}
