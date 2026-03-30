package poo.intermediate.genericTypes.useE;

import java.util.List;

public class Main {
	void main() {
		Processing<List<String>> p1 = new Processing<>();
		List<String> listStr1 = List.of("Maria", "Marcos", "Paulo");

		Processing<List<String>> p2 = new Processing<>();
		List<String> listStr2 = List.of("Manoel", "Felipe", "Gilberto");

		Processing<List<String>> p7 = new Processing<>();
		List<String> listStr3 = List.of("Maria", "Marcos", "Paulo");

		Processing<List<Integer>> p3 = new Processing<>();
		List<Integer> listInt1 = List.of(55, 16, 72);

		Processing<List<Integer>> p4 = new Processing<>();
		List<Integer> listInt2 = List.of(555, 416, 372);

		Processing<List<Double>> p5 = new Processing<>();
		List<Double> listDoule1 = List.of(553.0, 106.35, 72.44);

		Processing<List<Double>> p6 = new Processing<>();
		List<Double> listDoule2 = List.of(563.0, 176.85, 172.74);

		p1.setProcessing(listStr1);
		p2.setProcessing(listStr2);

		p3.setProcessing(listInt1);
		p4.setProcessing(listInt2);

		p5.setProcessing(listDoule1);
		p6.setProcessing(listDoule2);

		p7.setProcessing(listStr3);

		ElementList<List<String>> el1 = new ElementList<>();
		el1.add(listStr1);
		el1.add(listStr2);
		el1.add(listStr3);

		ElementList<List<Integer>> el2 = new ElementList<>();
		el2.add(listInt1);
		el2.add(listInt2);

		ElementList<List<Double>> el3 = new ElementList<>();
		el3.add(listDoule1);
		el3.add(listDoule2);

		IO.println(p1.getValue().equals(p2.getValue()));

		el1.getIndex(0).forEach(IO::println);
		el1.getIndex(1).forEach(IO::println);

	}
}
