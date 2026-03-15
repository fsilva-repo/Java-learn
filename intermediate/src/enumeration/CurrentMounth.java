package enumeration;

public class CurrentMounth {
	int n;

	CurrentMounth(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "Current Mounth [" + showMounth() + "]";
	}

	String showMounth() {
		String localVar = null;

		switch (this.n) {
		case 1:
			localVar = MonthsOfTheYear.JANUARY.infoMounth();
			break;
		case 2:
			localVar = MonthsOfTheYear.FEBRUARY.infoMounth();
			break;
		case 3:
			localVar = MonthsOfTheYear.MARCH.infoMounth();
			break;
		case 4:
			localVar = MonthsOfTheYear.BRIL.infoMounth();
			break;
		case 5:
			localVar = MonthsOfTheYear.MAY.infoMounth();
			break;
		case 6:
			localVar = MonthsOfTheYear.JUNE.infoMounth();
			break;
		case 7:
			localVar = MonthsOfTheYear.JULY.infoMounth();
			break;
		case 8:
			localVar = MonthsOfTheYear.AUGUST.infoMounth();
			break;
		case 9:
			localVar = MonthsOfTheYear.SEPTEMBER.infoMounth();
			break;
		case 10:
			localVar = MonthsOfTheYear.OCTOBER.infoMounth();
			break;
		case 11:
			localVar = MonthsOfTheYear.NOVEMBER.infoMounth();
			break;
		case 12:
			localVar = MonthsOfTheYear.DECEMBER.infoMounth();

		}

		return localVar;
	}

}
