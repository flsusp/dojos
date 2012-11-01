package br.com.dextra;


public class LanchePersonalizado extends Lanche {

	public LanchePersonalizado() {
		super("XFernando");
	}

	public void add(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}

}
