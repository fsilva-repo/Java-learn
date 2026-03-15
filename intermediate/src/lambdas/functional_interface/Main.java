package lambdas.functional_interface;

public class Main {

	public static void main(String[] args) {
		/*
		 * Com a interface funcional, torna os metodos mais faceis de acessar, pois nao
		 * precisa criar uma classe implementar a interface instanciar a classe e apois
		 * usar seus metodos
		 */
		Calculator mult = (a, b) -> {
			return a * b;
		};

		System.out.println(mult.exec(3, 32));

		Calculator div = (a, b) -> {
			return a / b;
		};

		double result = mult.exec(3, 32);
		System.out.println(div.exec(result, 8));

	}

}
