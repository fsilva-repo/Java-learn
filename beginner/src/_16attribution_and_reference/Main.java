package _16attribution_and_reference;

class Studant {
  private String name;
  private int age;

  Studant(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

}

public class Main {
  public static void main(String[] args) {
    /*
     * Diferenca de copia para a referencia, quando se trabalha com primitivos e for
     * preciso atribuir o mesmo valos a outra variavel, uma copia desse valor
     * primitivo sera escrita na memoria. Diferente dos objetos, que quando este e
     * atribuido a outra variavel entao as duas variaveis apontarao para o mesmo
     * objeto pois o que sera clonado sera a referencia (endereco) da variavel e nao
     * o objeto.
     */

    Studant marcos = new Studant("Marcos", 32);
    Studant gabriel = new Studant("Gabriel", 25);
    Studant marcelo = marcos;

    System.out.println(marcos.equals(gabriel));
    System.out.println(marcos.hashCode());
    System.out.println(gabriel.hashCode());
    System.out.println(marcelo.hashCode());
    System.out.println(marcelo.equals(marcos));
    
  }

}
