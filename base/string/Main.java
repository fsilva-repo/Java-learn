package poo.base.string;

public class Main {

	public static void main(String[] args) {
		/*
		 * Metodos mais utilizados de String*/
		
		String book = "Livros são fundamentais na educação";
		
		String formatUp = book.toUpperCase();
		System.out.println(formatUp);
		
		String formatDown = book.toLowerCase();
		System.out.println(formatDown);
		
		String[] splited = book.split(" ");
		for(String i : splited) {
		System.out.print(i + "/ " + "\n");
		}
		
		System.out.println(book.length());
		String sub = book.substring(0, 6);
		sub = book.substring(23);
		System.out.println(sub);
	}

}
