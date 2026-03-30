package poo.base.readFiles.bufferedReader;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		try {
			ReaderFile.reader("/home/arcade/Documents/atalhos-no-eclipse");

		} catch (IOException e) {
			IO.println(e.getMessage());
		}

	}

}
