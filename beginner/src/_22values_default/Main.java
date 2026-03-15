package _22values_default;

class Person {
  private String name;
  private String lastname;

  public Person(String name, String lastname) {
    this.name = name;
    this.lastname = lastname;
  }

  // dando um valor default aos atributos privados da classe.
  Person() {
    this("Desconhecido", "Desconhecido");
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

}

public class Main {
  public static void main(String[] args) {
    /*
     * VALOR PADRAO, no java uma variavel nao pode simplismente serem criadas sem um
     * valor atribuido a elas, por isso as variaveis do tipo primitivo sao
     * inicializadas com um valor padrao (byte, short, int, long -> 0) o (float,
     * double -> 0.0) ate que sejao modificados, o (boolean -> false) o (char ->
     * '\u0000'), e os objetos recebem null.
     * 
     * OBS: valor null quer dizer que o objeto nao aponta para nenhum local de
     * memoria. Em casos de variaveis de escopo de metodo e preciso ser inicializada
     * atribuindo um valor
     */

    Person p1 = new Person();
    System.out.println(p1.getName());
    System.out.println(p1.getLastname());
  }

}
