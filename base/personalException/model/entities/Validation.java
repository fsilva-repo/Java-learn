package poo.base.personalException.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validation {
	public static DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static boolean isDateValid(String checkin, String checkout) {
		LocalDate entrance = LocalDate.parse(checkin, datePattern); 
		LocalDate exit = LocalDate.parse(checkout, datePattern);
		
		if (entrance.isBefore(exit)) {
			if(entrance.isAfter(LocalDate.now()) && exit.isAfter(LocalDate.now())) {				
				return true;
			}
		}
		
		return false;
	}

	public static String formatter(String checkin) {
		LocalDate date = LocalDate.parse(checkin, datePattern);
		return date.format(datePattern);
	}
	
}





















