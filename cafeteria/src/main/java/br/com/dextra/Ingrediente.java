package br.com.dextra;

public enum Ingrediente {

	HamburguerCarne {
		@Override
		public double preco() {
			return 1.3;
		}
	},
	HamburguerFrango {
		@Override
		public double preco() {
			return 1.2;
		}
	},
	Bacon {
		@Override
		public double preco() {
			return 1.0;
		}
	},
	Queijo {
		@Override
		public double preco() {
			return 0.8;
		}
	},
	Ovo {
		@Override
		public double preco() {
			return 0.5;
		}
	},
	Alface {
		@Override
		public double preco() {
			return 0.1;
		}
	};

	public abstract double preco();
}
