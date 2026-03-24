package poo.base.binaryaToDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		IO.print("Binario: ");
		String entrie = sc.next();

		List<Integer> dataStarage = new ArrayList<>();

		for (int i = 0; i < entrie.length(); i++) {
			int x = Character.getNumericValue(entrie.charAt(i));
			dataStarage.add(x);
		}
		IO.println(dataStarage);

		List<Integer> listCalculations = new ArrayList<>();
		listCalculations.add(1);

		for (int i = 0; i < entrie.length() - 1; i++) {
			int next = listCalculations.get(i) * 2;
			listCalculations.add(next);
		}

		Collections.reverse(listCalculations);
		IO.println(listCalculations);
		
		int total = 0;
		for (int i = 0; i < entrie.length(); i++) {
			if(dataStarage.get(i) > 0) {
				total += listCalculations.get(i);
			}
		}
		
		IO.println(total);
		
		sc.close();

	}

}
