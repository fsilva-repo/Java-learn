package _20static_nested_class;

public class Utilities {

  /**
   * classe statica com alguns metodos
   * para somar e dividir
   */
  static class Calculator {
    static int sum(int a, int b) {
      return a + b;
    }

    static double sum(double a, double b) {
      return a + b;
    }

    static int div(int a, int b) {
      return a / b;
    }

    static double div(double a, double b) {
      return a / b;
    }

  }

  static class SyntaxCase {

    /**
     * trocando a primeira letra de cada palavra em uma tring para maiuscula
     */
    static String capitalizeLetter(String str) {
      if (str == null || str.isEmpty()) {
        return str;
      }

      String[] words = str.toLowerCase().split("\\s+"); // Divide a string por espaços
      StringBuilder result = new StringBuilder();

      for (String word : words) {
        if (!word.isEmpty()) {
          // Converte a primeira letra para maiúscula e mantém o restante minúsculo
          result.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1))
              .append(" ");
        }
      }

      return result.toString().trim(); // Remove espaços extras no final
    }

  }
}
