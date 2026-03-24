package poo.base.personalException.personal;

public class NewReservation {
	private Integer room;
	private String checkin;
	private String checkout;

	public void setRoom(int room) {
		this.room = InstantValidation.validatePositive(room);
	}

	public void setDate(String checkin, String checkout) {
		if (!InstantValidation.chronology(checkin, checkout)) {
			throw new IllegalArgumentException("Datas com problema: ");
		}
		this.checkout = InstantValidation.formatter(checkout);
		this.checkin = InstantValidation.formatter(checkin);
	}

	public Integer getRoom() {
		return room;
	}

	public String getCheckin() {
		return checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	@Override
	public String toString() {
		return "NewReservation [room=" + room + ", checkin=" + checkin + ", checkout=" + checkout + "]";
	}



}
