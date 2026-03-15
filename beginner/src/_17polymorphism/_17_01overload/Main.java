package _17polymorphism._17_01overload;

class Calculator {
  int sum(int a, int b) {
    return a + b;
  }

  double sum(double a, double b) {
    return a * b;
  }
}

public class Main {
  public static void main(String[] args) {

    /*
     * polimorfismo overload
     * ocorre quando temos uma sobrecarga no nome de metodo por exemplo
     */
    Calculator calc = new Calculator();
    System.out.println(calc.sum(32, 45)); // inteiros 
    System.out.println(calc.sum(32.25, 45.20)); // double

  }
}
