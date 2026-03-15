package poo.base.application.calculatePercentage;

public class Percentage {
	/*
	 * diferenca entre argumentos de funao e paramatros
	 * 
	 * ARGUMENTO: e o que a funcao exige ou precisa para realiza sua tarefa
	 * PARAMETRO: e o que informamos ou passamos para a funcao para que ela
	 * realize seu trabalho */
	static double calculate(double condition, double... list) {
		double count = 0;
		double heap = 0;
		
		for(double d: list) {
			
			heap ++;
			if(condition > d) {
				count ++;
			}
		}
		/* extraindo a porcentagem de uma quantidade e
		 * multiplicar o quantidade obtida segundo a regra
		 * estabelecida e dividir pela quantidade total*/
		return count * 100 / heap;
	}
}
