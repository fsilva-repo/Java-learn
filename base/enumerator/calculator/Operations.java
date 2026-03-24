package poo.base.enumerator.calculator;

public interface Operations {
	public default double exec(double x, double y) {
		return 0;
	}

	public default double exec(double x) {
		return 0;
	}
}
