package enumeration;

public enum MonthsOfTheYear {
	JANUARY {
		@Override
		public String infoMounth() {
			return "janeiro";
		}
	},

	FEBRUARY {
		@Override
		public String infoMounth() {
			return "fevereiro";
		}
	},
	MARCH {
		@Override
		public String infoMounth() {
			return "marco";
		}
	},
	BRIL {
		@Override
		public String infoMounth() {
			return "abril";
		}
	},
	MAY {
		@Override
		public String infoMounth() {
			return "maio";
		}
	},
	JUNE {
		@Override
		public String infoMounth() {
			return "junho";
		}
	},
	JULY {
		@Override
		public String infoMounth() {
			return "julho";
		}
	},
	AUGUST {
		@Override
		public String infoMounth() {
			return "agosto";
		}
	},
	SEPTEMBER {
		@Override
		public String infoMounth() {
			return "setembro";
		}
	},
	OCTOBER {
		@Override
		public String infoMounth() {
			return "outubro";
		}
	},
	NOVEMBER {
		@Override
		public String infoMounth() {
			return "novembro";
		}
	},
	DECEMBER {
		@Override
		public String infoMounth() {
			return "dezembro";
		}
	};

	public abstract String infoMounth();
}
