package enumeration;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {

		System.out.println("");
		int i = 1;
		for (MonthsOfTheYear s : MonthsOfTheYear.values()) {

			System.out.println(i + " - " + s.infoMounth());
			i++;
		}

		System.out.println("");

		CurrentMounth cm = new CurrentMounth(Calendar.MONTH);
		System.out.println(cm);
	}
}
