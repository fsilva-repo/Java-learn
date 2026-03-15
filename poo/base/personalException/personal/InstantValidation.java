package poo.base.personalException.personal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InstantValidation {
	public static String formatter(String date) throws DateTimeParseException {
		DateTimeFormatter formating = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parseDaate = LocalDate.parse(date, formating);
		return parseDaate.format(formating);
	}

	public static boolean chronology(String checkin, String checkout) throws IllegalArgumentException {
		DateTimeFormatter formatting = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate today = LocalDate.now();

		LocalDate entranceDate = LocalDate.parse(checkin, formatting);
		LocalDate exitDate = LocalDate.parse(checkout, formatting);

		return !entranceDate.isBefore(today) && exitDate.isAfter(entranceDate);
	}

	public static Integer validatePositive(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("O número deve ser positivo: ");
    }
    return n;
}

	/*
	 * DateTimeFormatter formating = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 * LocalDate currentDate = LocalDate.now(); String date =
	 * currentDate.format(formating);
	 * 
	 * LocalDate dateNow = LocalDate.parse(date, formating); LocalDate entrace =
	 * LocalDate.parse(checkin, formating); LocalDate exit =
	 * LocalDate.parse(checkout, formating);
	 * 
	 * 
	 * LocalDate currentDate = LocalDate.now(); String parse =
	 * currentDate.format(formatting); LocalDate date = LocalDate.parse(parse,
	 * formatting);
	 * 
	 * LocalDate entrace = LocalDate.parse(checkin, formatting); LocalDate exit =
	 * LocalDate.parse(checkout, formatting);
	 * 
	 * if (entrace.isBefore(exit) && exit.isAfter(entrace) && entrace.isAfter(date)
	 * && exit.isAfter(date)) { return true; } return false;
	 * 
	 */

}
