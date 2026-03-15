package _04thrusty_table;

public class Main {
  public static void main(String[] args) {
    System.out.println("\nTabela verdade E (AND)\n");
		System.out.println("true && true = true");
		System.out.println("true && false = false");
		System.out.println("false && true = false");
		System.out.println("false && false = false");

		System.out.println("\nTabela verdade OU (OR)\n");
		System.out.println("true || true = true");
		System.out.println("true || false = true");
		System.out.println("false || true = true");
		System.out.println("false || false = false");

		System.out.println("\nTabela veradde OU Exclusivo (XOR)\n");
		System.out.println("true ^ true = false");
		System.out.println("true ^ false = true");
		System.out.println("false ^ true = true");
		System.out.println("false ^ false = false");

  }
}
