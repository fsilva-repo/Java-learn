package poo.base.bitwise;

public class Main {

	public static void main(String[] args) {

		int s = 32;
		int n = 23;

		System.out.println(n & s);
		System.out.println(s & n);

		System.out.println(s ^ n);
		System.out.println(n ^ s);

		System.out.println(n | s);
		System.out.println(s | n);

		System.out.println('a' ^ 'A');
	}

}
