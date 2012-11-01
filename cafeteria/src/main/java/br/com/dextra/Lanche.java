package br.com.dextra;

import java.util.ArrayList;
import java.util.List;

public abstract class Lanche {

	private String nome;

	// FIXME - dependencia nas classes filhas
	protected List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

	public Lanche(String nome){
		this.nome=nome;
	}

	public Lanche(String nome, List<Ingrediente> ingredientes){
		this.nome=nome;
		this.ingredientes = ingredientes;
	}

	public double preco(){
		double calc = 0.0;

		for (Ingrediente ingredientes : this.ingredientes) {
			calc += ingredientes.preco();
		}

		return calc;
	}


}
