package _14dot_notation;

public class Mian {
  public static void main(String[] args) {
    // notacao de ponto quando se quer chamar o metodo do objeto
    // tudo o que nao e primitivo tem metodos

    // ex:
    String s = " Ola x";
    s = s.replace("x", "Senhor");
    System.out.println(s);

    s = s.toUpperCase();
    System.out.println(s);

    s = s.repeat(3).concat(" fim.");
    System.out.println("[" + s + "]");

    Integer n = 123;
    System.out.println(n.hashCode());

    Double d = 123.45;
    System.out.println(d.floatValue());

    Boolean b = true;
    System.out.println(b.booleanValue());
  }
}
