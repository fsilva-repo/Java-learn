package _12constructors;

public class InplicitConstructor {
  private String name;
  private int age;

  /*
   * quando omitimos o construtor, o java se encarrega de
   *  adicionar um contrutor padrao
  */
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
}
