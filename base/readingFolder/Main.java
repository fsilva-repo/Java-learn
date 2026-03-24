package poo.base.readingFolder;

import java.util.Scanner;

import poo.base.readingFolder.createFolder.CreateDir;
import poo.base.readingFolder.findFile.FindFile;
import poo.base.readingFolder.findFolder.FindFolder;
import poo.base.writerFiles.buffedWriter.Writer;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CreateDir createDir = new CreateDir();
		
		IO.print("path: ");
		String path = sc.nextLine();
		
		IO.println("\n--------- Directories --------");
		FindFolder findFolder = new FindFolder(path);
		findFolder.find();
		
		IO.println("");
		IO.print("path: ");
		path = sc.nextLine();
		
		IO.println("\n--------- Files ---------");
		FindFile findFile = new FindFile(path);
		findFile.find();
		
		IO.println("");
		IO.print("make dir on path: ");
		path = sc.nextLine();
		createDir.makeDir(path);
		
		IO.print("file name: ");
		Writer.fileName = sc.next();
		
		IO.print("is new file?: ");
		Writer.newFile = sc.nextBoolean();
		
		IO.print("path: ");
		Writer.path = sc.nextLine();
		path = sc.nextLine();
		
		IO.print("text: ");
		String text = sc.nextLine();
		Writer.bufferedWriter(text);
		
		
		sc.close();
	}

}
