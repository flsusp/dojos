package br.com.dextra;

import java.math.BigDecimal;

public class XFrango extends Lanche{

	public XFrango() {
		super("XFrango");
	}

	@Override
	public BigDecimal preco() {
		return new BigDecimal(5.0);
	}

}
