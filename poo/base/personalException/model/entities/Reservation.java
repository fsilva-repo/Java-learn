package poo.base.personalException.model.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
	private int roomNUmber;
	private String checkin;
	private String checkout;

	public Reservation() {
	}

	public void setRoomNUmber(int roomNUmber) {
		this.roomNUmber = roomNUmber;
	}

	public void dateReservation(String checkin, String checkout) {
		if (Validation.isDateValid(checkin, checkout)) {
			this.checkin = Validation.formatter(checkin);
			this.checkout = Validation.formatter(checkout);
		} else {
			this.checkin = null;
			this.checkout = null;
		}
	}

	public int getRoomNUmber() {
		return roomNUmber;
	}

	public String getCheckin() {
		return checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = ChronoUnit.DAYS.between(LocalDate.parse(getCheckin(), Validation.datePattern),
				LocalDate.parse(getCheckout(), Validation.datePattern));
		return diff;
	}

	public String updateDate(String checkin, String checkout) {
		if (Validation.isDateValid(checkin, checkout)) {
			return "Data reservada com sucesso, de " + checkin + " á " + checkout;
		}
		return null;
	}

	@Override
	public String toString() {

		return "Reservation \n" + "Room number: " + roomNUmber + "\nCheck-in: " + checkin + "\nCheck-out: " + checkout
				+ "\nDuration nights: " + duration();
	}

}
