package _20static_nested_class;

import _20static_nested_class.Utilities.*;

public class Main {
  public static void main(String[] args) {
    int num = Calculator.sum(22, 37);
    double resp = Calculator.div(num, 2);

    System.out.println(num);
    System.out.println(resp);

    String str = "a capiTal do perNamBuco E recife";
    String capitalized = SyntaxCase.capitalizeLetter(str);
    System.out.println(capitalized);
  }
}
