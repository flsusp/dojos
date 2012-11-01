package br.com.dextra;

import java.math.BigDecimal;

public abstract class Lanche {
	
	private String nome;
	
	public abstract BigDecimal preco();
	
	public Lanche(String nome){
		this.nome=nome;
	}

}
