package poo.base.abstractClass;

public class Rectangle extends Shape {

	/*
	 * multiplicar a medida da sua base (comprimento) pela medida da sua altura
	 * (largura). A fórmula é (Área = base * altura) (a=b*h).
	 */

	private double base;
	private double height;

	public Rectangle(double base, double height) {
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
		return a * b;
	}

}
