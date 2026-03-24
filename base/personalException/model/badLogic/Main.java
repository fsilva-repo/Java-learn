package poo.base.personalException.model.badLogic;

import java.io.IOException;
import java.util.Scanner;
import poo.base.personalException.model.entities.Reservation;

public class Main {
	
	/* CODIGO RUIM PROPAGANDO ERROS DIFICEIS DE TRATAR*/

	public static void main(String[] args) throws IOException, NullPointerException {
		Scanner sc = new Scanner(System.in);
		int room;
		String checkin = null;
		String checkout = null;
		
		Reservation r = null;
		try {

			 r = new Reservation();
			System.out.print("Room: ");
			room = sc.nextInt();
			r.setRoomNUmber(room);

			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkin = sc.next();

			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkout = sc.next();

			r.dateReservation(checkin, checkout);
		} catch (Exception e) {
			System.out.println("Error on set date " + e.getMessage());
		}
		
		System.out.println(r.toString());

		System.out.print("\nCheck-in date (dd/mm/yyyy): ");
		checkin = sc.next();
		
		System.out.print("Check-out date (dd/mm/yyyy): ");
		checkout = sc.next();
		
		r.dateReservation(checkin, checkout);
		String update = r.updateDate(checkin,checkout);
		
		System.out.println(update);

		sc.close();
	}

}
