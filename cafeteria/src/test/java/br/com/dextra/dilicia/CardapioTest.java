package br.com.dextra.dilicia;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.dextra.Ingrediente;
import br.com.dextra.XBacon;
import br.com.dextra.XEgg;
import br.com.dextra.LanchePersonalizado;
import br.com.dextra.XFrango;
import br.com.dextra.XTudo;

public class CardapioTest {

	@Test
	public void testPrecosCardapio() {
		Assert.assertEquals(3.2, new XBacon().preco(), 0.01);
		Assert.assertEquals(2.7, new XEgg().preco(), 0.01);
		Assert.assertEquals(2.1, new XFrango().preco(), 0.01);
		Assert.assertEquals(4.9, new XTudo().preco(), 0.01);
	}

	@Test
	public void testCarneOvoAlface(){
		LanchePersonalizado lancheNovo = new LanchePersonalizado();
		lancheNovo.add(Ingrediente.Ovo);
		lancheNovo.add(Ingrediente.Alface);
		lancheNovo.add(Ingrediente.HamburguerCarne);
		Assert.assertEquals(1.9, lancheNovo.preco(), 0.01);
	}


}
