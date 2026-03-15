package _09variables;

public class Main {
  // classes staticas podem ser aninhadas
  static class InnerMain {
    // Variavel de classe
    static String msg = "Hello, I am a static variable.";

    static void method(String args) {
      // variaveis local sao as definidas dentro de metodos
      String greetings = "Hello I am a method variable";
      System.out.println(args + ", " + greetings);
    }

  }

  public static void main(String[] args) {

    // variaveis de instancia sao variaveis definida no corpo da classe
    String greetings = "Hello I am an instance variable";

    /*
     * Variavel de classe:
     * são variaveis definidas como static.
     * 
     * Variaveis de instância:
     * são variaveis deinidas no corpo da classe com qualquer modificador e que não
     * seja statica.
     * 
     * Variaveis local:
     * são variaveis definidas dentro dos metodos, onde terão sua
     * visibilidade apenas dentro do escopo do metodo onde fora definida.
     */
    InnerMain.method("Silva");
    System.out.println(InnerMain.msg);
    System.out.println(greetings);
  }
}