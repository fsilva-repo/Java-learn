package _10imports;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    /*
     * se precisamos de uma classe nativa do java ou qualque outra classe criada
     * pelo programador, podemos usar o import
     */

    // exemplo: importaremos duas classe do java
    List<String> names = new ArrayList<>();
    names.add("Silva");
    names.add("marcos");
    names.add("Boston");
    names.add("Maya");

    for (String n : names) {
      System.out.println(n);
    }

  }
}
