package _24abstract_class;

public class Dog extends Animal {

  Dog(String name) {
    super(name);
  }

  // Implementação do método abstrato
  @Override
  String sleep() {
    return name + " is sleeping";
  }

  // implementacao do metodo concreto
  String makesTheSound() {
    return name + " makes the sound: Au au au";
  }
}
