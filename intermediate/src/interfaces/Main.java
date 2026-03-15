package interfaces;

interface Motor {
	/*
	 * esse metodo abstrato define o fator de injecao de combustival no motor
	 */
	double fuelInjection();

	/*
	 * metodo e default porque todo motor e criado na espectativa de algum momento
	 * ser ligado
	 */
	default boolean StartEngine() {
		boolean engine = false;
		if (this.fuelInjection() > 0)
			engine = true;
		return engine;
	}
}

interface Vehicle {
	boolean startVehicle();
}

class Car implements Vehicle, Motor {

	@Override
	public double fuelInjection() {
		return 2.0;
	}

	@Override
	public boolean startVehicle() {
		boolean engine = Motor.super.StartEngine();
		return engine;
	}

}

public class Main {

	public static void main(String[] args) {

		Car car = new Car();
		System.out.println(car.startVehicle());
	}

}
