package _12constructors;

public class ExplicitConstructor {

  private String name;
  private int age;

  /* construtor explicito, toda instacia dessa classe devera
  * ser criada com uma String e um int
  */
  public ExplicitConstructor(String name, int age) {
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
