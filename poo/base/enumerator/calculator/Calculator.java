package poo.base.enumerator.calculator;

public enum Calculator implements Operations {

	CUBO {
		public double exec(double x) {
			return x * x;
		}
	},

	SOMAR {
		public double exec(double a, double b) {
			return a + b;
		}
	},

	DIVIDIR {
		public double exec(double a, double b) {
			if (a != 0) {
				return a / b;
			}
			return 0;
		}
	},

	RAIZ_Q {
		public double exec(double x) {
			double result = Math.sqrt(x);
			return result;
		}
	},
	
	QUADRADO {
		public double exec(double x) {
			return x * x * x;
		}
	},
	
	SUBTRACAO {
		public double exec(double a, double b) {
			return a - b;
		}
	},
	
	MULTIPLICACAO {
		public double exec(double a, double b) {
			return a * b;
		}
	};

}
