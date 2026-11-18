package lambdas.class_no_lambda;

public class Sum implements Calculator {

	@Override
	public double exec(double a, double b) {
		return a + b;
	}

}
