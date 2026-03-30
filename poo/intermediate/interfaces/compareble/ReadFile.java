package poo.intermediate.interfaces.compareble;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	public List<String> path(String filePath) {
		List<String> lines = new ArrayList<>();
		try {
      lines = Files.readAllLines(Paths.get(filePath));
		} catch (IOException e) {
			System.err.println("Erro ao ler arquivo: " + e.getMessage());
		}
		return lines;
	}
	
}