package poo.intermediate.functionalProgramming.functionalInterfaces.stream.createStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Program {

 void main() {
	/*
	* Tipos de operações
	* Intermediárias (lazy)
	* Retornam outro Stream
	* Só executam quando há uma operação terminal
	*/

	List<Integer> numbers = Arrays.asList(23, 42, 13, 8, 10, 12, 76);

	// aqui temos duas operacoes intermediarias e uma terminal que e a forEach.
	numbers.stream().filter(i -> i >10).map(i -> i * 10).forEach(System.out::println);

	IO.println("---------------------------------------");

 // O flatMap transforma cada elemento de um Stream em outro Stream
List<Integer> l1 = Arrays.asList(23, 42, 13, 8, 10, 12, 76);
List<Integer> l2 = Arrays.asList(53, 47, 16, 81, 10, 22, 7);

 List<List<Integer>> listNumbers = Arrays.asList(l1, l2);

 List<Integer> newList = listNumbers.stream()
    .flatMap(list -> list.stream())
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());

 newList.forEach(System.out::println);

IO.println("---------------------------------------");


 // distinct Remove duplicados
 List.of('A', 'c','f', 'F', 'A', 'a', 'b', 'f').stream().distinct().forEach(System.out::println);


IO.println("---------------------------------------");
// sorted operação utilizada para ordenar elementos
List.of("Flavio", "Beatriz", "Lucas", "Ana", "Deborah", "Caleb", "Elem")
		.stream()
		.sorted((a, b) -> a.compareTo(b))
		.forEach(System.out::println);

IO.println("---------------------------------------");

List<Integer> l3 = l1.stream().filter(item -> item != null).collect(Collectors.toList());
l3.forEach(System.out::println);


IO.println("---------------------------------------");

 //skip() na Stream API é usado para ignorar os primeiros elementos de um fluxo de dados
 Path path = Path.of("/home/arcade/Workstation/JavaLearning/src/poo/base/readCsvFile/src/index.csv");
 try (Stream<String> line = Files.lines(path)) {
	line.filter(l -> !l.trim().isEmpty())
	.skip(1)// pula o cabecalho
  .forEach(System.out::println);
} catch (IOException e) {
	IO.println(e.getMessage());
}

IO.println("---------------------------------------");

// criando uma lista com os dados do arquivo
 try (Stream<String> line = Files.lines(path)) {
	List<String> data =
	 line.flatMap(l -> Arrays.stream(l.split(";")))
	.filter(l -> !l.trim().isEmpty())
	.skip(4)// pula os quatro primeiros indices
  .collect(Collectors.toList());

 data.forEach(System.out::println);
} catch (IOException e) {
	IO.println(e.getMessage());
}


 }
}




















