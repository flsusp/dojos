package br.com.dextra;

import java.math.BigDecimal;

public class XBacon extends Lanche{

	public XBacon() {
		super("XBacon");
	}

	@Override
	public BigDecimal preco() {
		return new BigDecimal(3.0);
	}

}
