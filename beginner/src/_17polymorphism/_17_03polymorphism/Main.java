package _17polymorphism._17_03polymorphism;

abstract interface InnerMain {
  void calculator();
}

class Sum implements InnerMain {
  private int a;
  private int b;

  Sum(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public void calculator() {
    System.out.println(a + b);
  }

}

class Div implements InnerMain {
  private double a;
  private double b;

  Div(double a, double b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public void calculator() {
    System.out.println(a + b);
  }

}

class Mult implements InnerMain {
  private int a;
  private int b;

  Mult(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public void calculator() {
    System.out.println(a * b);
  }

}

public class Main {
  public static void main(String[] args) {

    /*
     * a interface sera implementada por tres classes diferentes
     * onde o polimorfismo fica evidente no uso do metodo calculator
     */
    Sum sum = new Sum(16, 12);

    Div div = new Div(15.20, 11.8);

    Mult mult = new Mult(8, 03);

    sum.calculator();
    div.calculator();
    mult.calculator();

  }
}
