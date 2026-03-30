package poo.base.createCsvFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileCsv {
	private String file = "summary.txt";
	private String path;
	private boolean overwrite;
	
	public WriteFileCsv(String path, boolean overwrite) {
		this.path = path;
		this.overwrite = overwrite;
	}
	
	public void writer(String text) {
		
		if(path.length() != path.lastIndexOf("/")) {
			path = path + "/";
		}
		
		// TERMINAR AA IMPLEMENTACAO DA ESCRITA DO ARQUIVO
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path + file, overwrite))) {
			
			bw.write(text);
			bw.newLine();
		} catch(IOException e) {
			System.out.println("Falha ao escrever o arquivo " + e.getMessage());
		}
	}
}
















