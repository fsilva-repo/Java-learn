package _07inference;

public class Main {
  public static void main(String[] args) {
    // declaracao literal de uma variavel do tipo string
    String a = "string aqui";
    System.out.println(a);

    // declaracao literal de uma variavel do tipo double
    double n = 5.7;
    System.out.println(n);

    // inferencia de tipo string
    var s = "string por inferencia";

    System.out.println(s);

    // inferencia de tipo double
    var d = 9.2;

    System.out.println(d + "double por inferencia");

    /*
     * lembre-se que o java nao mistura os tipos.
     * uma vez declarado um tipo,seja literal ou por inferencia
     * essa variavel nao pode mudar o seu tipo
     */

  }
}
