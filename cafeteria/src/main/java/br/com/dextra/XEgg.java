package br.com.dextra;

import java.math.BigDecimal;

public class XEgg extends Lanche{

	public XEgg() {
		super("XEgg");
	}

	@Override
	public BigDecimal preco() {
		return new BigDecimal(2.0);
	}

}
