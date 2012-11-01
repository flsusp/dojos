package br.com.dextra;

import java.math.BigDecimal;

public class XTudo extends Lanche{

	public XTudo() {
		super("XTudo");
	}

	@Override
	public BigDecimal preco() {
		return new BigDecimal(4.0);
	}

}
