package poo.intermediate.genericTypes.useT;

public class Main {

	void main() {
		Program<String> name = new Program<>();
		name.add("Maria");
		name.add("João");
		name.add("Pedro");

		Program<Integer> age = new Program<>();
		age.add(20);
		age.add(30);
		age.add(40);

		Program<Double> height = new Program<>();
		height.add(1.70);
		height.add(1.80);
		height.add(1.90);

		for (int i = 0; i < 3; i++) {
			System.out.println("name: " + name.get(i) + " age: " + age.get(i) + " height: " + height.get(i));
		}
		
		System.out.println(name.get(8));
	}
}
