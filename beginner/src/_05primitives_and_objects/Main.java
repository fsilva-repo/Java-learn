package _05primitives_and_objects;

public class Main {
  public static void main(String[] args) {

    /*
     * primitivos vs objetos
     * primitivos não possuem metodos ah não ser que use a class wrapper,
     * no java tirando os primitivos todo o resto sao objetos.
     */
    int i = 32;

    // objetos podem posuir diversos metodos
    String s = "Hello, World";

    System.out.println(i);

    System.out.println(s.toUpperCase());
    System.out.println(s.concat("!"));

  }
}
