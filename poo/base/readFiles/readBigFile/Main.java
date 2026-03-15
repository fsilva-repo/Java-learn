package poo.base.readFiles.readBigFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Path file = Path.of("/home/arcade/Documents/hierarquia-de-excecoes.txt");

    try (Stream<String> l = Files.lines(file)) {
        l.filter(linha -> !linha.trim().isEmpty())
         .forEach(System.out::println);
        
    } catch (IOException e) {
        System.err.println("Falha: " + e.getMessage());
    }

				

	}

}
