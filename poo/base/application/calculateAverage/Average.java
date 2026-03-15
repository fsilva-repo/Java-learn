package poo.base.application.calculateAverage;

public class Average {
	static double calculate(double... list) {
		double count = 0;
		double heap = 0;
		
		for(double d: list) {
			count ++;
			heap += d;
		}
		return heap / count;
	}
}
