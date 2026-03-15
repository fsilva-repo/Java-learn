package _23reader_and_writing._23_1scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {

    InputStream is = new FileInputStream("./file.txt");
    Scanner sc = new Scanner(is);

    while (sc.hasNextLine()) {
      System.out.println(sc.nextLine());
    }
    sc.close();
  }
}
