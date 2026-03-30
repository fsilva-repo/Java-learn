package poo.base.abstractClass;

public class Triangle extends Shape{
	/*
	 * A área de um triângulo é calculada multiplicando a base pela altura e
	 * dividindo o resultado por 2 (a=b*a/2) A altura deve ser perpendicular à base.
	 */

	private double base;
	private double height;

	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public double areaCalculation(double a, double b) {
		return a * b / 2;
	}

}
