package _06wrappers;

public class Main {
  public static void main(String[] args) {
    /*
     * O java possue as versões de primitivos
     * orientado a objetos
     */

    // exemplo

    Byte a = 127;
    System.out.println(a.byteValue());

    Short b = 235;
    System.out.println(b.toString().equals("235"));

    Integer c = 23;
    System.out.println(c.toString());

    Float d = 123.18F;
    System.out.println(d.toString().length());

    Double e = 54367.89;
    System.out.println(e.toString().hashCode());

    Boolean f = true;
    System.out.println(f.toString().concat("***"));

    Character g = 'G';
    System.out.println(g.toString().concat("ato").toUpperCase());

  }
}
