package lambdas.class_no_lambda;

public class Main {
	public static void main(String[] args) {
		// usando a interface funcional mas sem as expressoes lambda

		/*
		 * aqui temos tambem o polimorfismo essa instancia ira somar
		 */
		Calculator calc = new Sum();
		System.out.println(calc.exec(23, 32));

		/*
		 * em quanto essa instancia ira multiplicar
		 */
		calc = new Mult();
		System.out.println(calc.exec(2, 6));

		/* e esta divide */
		calc = new Div();
		System.out.println(calc.exec(84, 2));
	}
}
