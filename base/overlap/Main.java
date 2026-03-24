package poo.base.overlap;

public class Main {

	public static void main(String[] args) {

		IO.println(new Sum().exec(13, 22));

		IO.println(new Mult().exec(13, 6));

		IO.println(new Div().exec(76, 13));
	}

}
