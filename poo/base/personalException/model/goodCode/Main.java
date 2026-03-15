package poo.base.personalException.model.goodCode;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import poo.base.personalException.model.entities.Reservation;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int room = 0;
		String checkin = null;
		String checkout = null;

		Reservation r = new Reservation();
		try {

			System.out.print("Room: ");
			room = sc.nextInt();
			r.setRoomNUmber(room);

			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkin = sc.next();

			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkout = sc.next();

			r.dateReservation(checkin, checkout);

			System.out.println(r.toString());

			System.out.print("\nCheck-in date (dd/mm/yyyy): ");
			checkin = sc.next();

			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkout = sc.next();

			r.dateReservation(checkin, checkout);
			String update = r.updateDate(checkin, checkout);

			System.out.println(update);

		} catch (DateTimeParseException e) {
			System.out.println("Error on set date " + e.getMessage());
			
		} catch(NullPointerException e) {
			System.out.print("Error on set date ");
			e.printStackTrace();
		}

		sc.close();

	}

}
