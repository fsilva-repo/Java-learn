package _21equals_hashcode;

import java.util.Objects;

class Car {
  private String model;
  private String make;
  private long age;

  public Car(String model, String make, long age) {
    this.model = model;
    this.make = make;
    this.age = age;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result + ((make == null) ? 0 : make.hashCode());
    result = prime * result + (int) (age ^ (age >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    // se esta instancia e igual ao objeto do parametro retorne verdade.
    if (this == obj) {
      return true;
    }
    /*
     * se o objeto recebido por parametro e nulo ou o retorno do metodo getClass
     * das duas instancias sao diferentes retorne falso
     */
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    /*
     * ja que o obj passou nos testes acima
     * sera feito um casting para o tipo Car
     * e retornar um boolena se todos os seus atributos
     * forem iguais.
     */
    Car car = (Car) obj;
    return age == car.age && model == car.model && Objects.equals(make, car.make);
  }

}

public class Main {
  public static void main(String[] args) {
    Car c1 = new Car("Palio", "Fiat", 23052001);
    Car c3 = new Car("Palio", "Fiat", 23052001);
    Car c2 = new Car("Uno", "Fiat", 05012012);
    Car c4 = c2;
    System.out.println(c1.equals(c2));// false
    System.out.println(c1.equals(c3));// true
    System.out.println(c4.equals(c2));// true
  }
}
