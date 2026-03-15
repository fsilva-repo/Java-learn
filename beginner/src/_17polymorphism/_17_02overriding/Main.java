package _17polymorphism._17_02overriding;

class Animal {
  void fazerSom() {
    System.out.println("Algum som...");
  }
}

class Cachorro extends Animal {
  @Override
  void fazerSom() {
    System.out.println("Latido");
  }
}

class Gato extends Animal {
  @Override
  void fazerSom() {
    System.out.println("Miado");
  }
}

public class Main {
  public static void main(String[] args) {

    /*
     * o polimorfismo overriding ocorre quando ha sobrescrita de metodo
     * para atender a logica da instancia.
     */
    Animal meuAnimal = new Cachorro();
    meuAnimal.fazerSom(); // Saída: Latido

    meuAnimal = new Gato();
    meuAnimal.fazerSom(); // Saída: Miado
  }
}
