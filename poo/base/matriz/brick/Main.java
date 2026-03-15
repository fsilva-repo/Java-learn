package poo.base.matriz.brick;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		IO.print("Tamanho da Matriz: ");
		int n = sc.nextInt();
		int[][] brick = new int[n][n];


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				brick[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			IO.println("--------------");
			for (int j = 0; j < n; j++) {
				IO.println(brick[i][j]);
			}
		}

		sc.close();
	}

}
