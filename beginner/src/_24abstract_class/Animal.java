package _24abstract_class;

public abstract class Animal {
  /*
   * classes abstratas são classes que não podem ser instanciadas diretamente e
   * servem como modelos para outras classes.
   */
  String name;

  Animal(String name) {
    this.name = name;
  }

  // metodo abstrato sem corpo
  abstract String sleep();

  // metodo concreto deve ser implementado
  String makesTheSound() {
    return "";
  }
}
