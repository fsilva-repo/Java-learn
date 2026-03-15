package _19static_methods;

public class Main {
  public static void main(String[] args) {
    Calculator calc = new Calculator();

    // a istancia tem herda apenas os dois metodos publicos da class
    System.out.println(calc.div(24.8, 4.0));
    System.out.println(calc.sum(18, 8));

    // chamando o metodo statico 
    boolean isResultZero = Calculator.resultZero(calc.sum(23, 18));
    System.out.println(isResultZero);

  }
}
