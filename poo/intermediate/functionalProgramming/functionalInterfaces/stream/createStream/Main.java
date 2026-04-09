package poo.intermediate.functionalProgramming.functionalInterfaces.stream.createStream;

//import java.util.stream.Stream;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.function.*;

public class Main {
  void main() {
  /* 1. Stream.of()
     2. Collection.stream()
     3. Arrays.stream()
     4. Stream.generate()
     5. Stream.iterate() */


  // Stream.of quando deseja construir um stream dieto
  Stream<Integer> numbers = Stream.of(23, 44, 32, 25, 13, 9, 16, 12);
  //numbers.forEach(System.out::println);

  /*
   * Collection.stream faz parte do pacote da API stream no java.util
   * quem implementa essa interface como List, Set, Arrays,etc
   * podem utilizar os recursos da API
  */
  Function<Integer, Integer> mult = n -> n * 2;
  numbers.map(mult).forEach(System.out::println);


 System.out.println("--------------------------");

  List<String> names = new ArrayList<>();
  names.add("Maria");
  names.add("Carlos");
  names.add("Neemias");
  names.add("Flavio");
  names.add("Ana");

  names.stream().filter(name -> name.length() < 6).forEach(System.out::println);

  System.out.println("--------------------------");


  List<Double> listDouble = new ArrayList<>();
  listDouble.add(8.16);
  listDouble.add(20.14);
  listDouble.add(3.4);
  listDouble.add(9.16);
  listDouble.add(18.6);

  //double total = listDouble.stream().mapToDouble(n -> Double.valueOf(n)).sum();
  double total = listDouble.stream().mapToDouble(Double::valueOf).sum();
  System.out.println("Total: " + total);


  }
}













