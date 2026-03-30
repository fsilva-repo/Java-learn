package poo.base.heritage;

public class Main {

	public static void main(String[] args) {
		Sub calc = new Sub();
		
		IO.println(calc.sum(23, 32));
		IO.println(calc.sub(32, 23));
		IO.println(calc.div(32, 23));
		IO.println(calc.mult(23, 32));
		
	}

}
