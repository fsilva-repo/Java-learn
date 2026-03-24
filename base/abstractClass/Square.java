package poo.base.abstractClass;

public class Square extends Shape{
/*
 * multiplique a medida de um lado por ele mesmo,
 * utilizando a fórmula (Área = Lado * Lado) (A=l^2).
 * */
	
	
	private double side;

	public Square(double side) {
		this.side= side;
	}
	public double getSide() {
		return side;
	}

	@Override
	public double areaCalculation(double a, double b) {
		return a * b;
	}
}
