package poo.base.personalException.personal;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		NewReservation r = new NewReservation();

		int room = 0;
		String checkin = null;
		String checkout = null;

		try {
			System.out.print("room number: ");
			room = sc.nextInt();
			r.setRoom(room);

			System.out.print("checkin (dd/mm/yyyy): ");
			checkin = sc.next();

			System.out.print("checkout (dd/mm/yyyy): ");
			checkout = sc.next();

			r.setDate(checkin, checkout);
			
			IO.println(r.toString());
		} catch (DateTimeParseException e) {
			System.err.println("Erro: " + e.getMessage());
			System.err.println("Erro no indice: " + e.getErrorIndex());
			System.err.println("Valor problematico " + e.getParsedString());

		} catch (IllegalArgumentException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();

		}

		sc.close();
	}

}
