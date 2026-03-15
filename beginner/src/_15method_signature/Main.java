package _15method_signature;

class Calculator {
	/*
	 * assinatura dos metodos sao definidas pelo (nome tipo de retorno e os tipo de
	 * parametro que ele ira receber.
	 */

	
	public int calc(int a, int b) {
		return a + b;
	}
	/*
	 * observe as assinaturas desses dois metodos
	 * nomes iguais mas assinatutras diferentes
	 */
	public double calc(double a, double b) {
		return a / b;
	}

	/*
	 * apesar dos nomes serem iguais, quando o metodo e chamado
	 * com os devidos parametros, o java entende qual metodo usar
	*/
}

public class Main {
	public static void main(String[] args) {

		Calculator method = new Calculator();

		System.out.println(method.calc(23, 32));// inteiro
		System.out.println("");
		System.out.println(method.calc(32.5, 23.5));// double


	}
}
