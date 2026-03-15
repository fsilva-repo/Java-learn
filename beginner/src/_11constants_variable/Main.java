package _11constants_variable;

public class Main {
  public static void main(String[] args) {
    /*
     * declarando uma variavel:
     * variaveis segundo a convensao devem comecar com letras minusculas ou
     * underscore,
     * o compilador do java tambem aceita o sifrao, mas isso nao segue a convencao,
     * ainda nos padroes da convencao do java, os nomes de variaveis compostos devem
     * seguir o formato camelCase.
     */
    String name = "Silva";

    /*
     * declaracao de uma constante
     * segundo a convensão no java, as constants devem ser definidas em caixa alta
     * antecedida pela keyword final
     */
    final String GREETING = "Hello, World!";

    System.out.println(GREETING.replace("World!", name));

  }
}
