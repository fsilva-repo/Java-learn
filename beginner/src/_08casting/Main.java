package _08casting;

public class Main {
  public static void main(String[] args) {
    /*
     * entendendo que o java nao analiza valores e sim tipos
     * se tentar clocar um tipo maior dentro de um tipo menor
     * o compilador vai reclamar, para isso usamos o cast
     * assim dizemos para o compilador; faca ainda que haja
     * perda de dados
     */

    // conversao explicita
    // saindo de um literal double para um float
    float a = (float) 1.0; // cast
    System.out.println(a);
    // ou
    float b = 2.0F;
    System.out.println(b);

    // conversao implicita
    // saindo de um literal inteiro para um double
    double d = 1;
    System.out.println(d);

    int c = 4;
    byte f = (byte) c;
    System.out.println(f);

  }
}
