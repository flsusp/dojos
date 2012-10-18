package br.com.dojo.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dojo.Boleto;
import br.com.dojo.Empresa;
import br.com.dojo.MensageriaMDB;
import br.com.dojo.OperaCambioBean;
import br.com.dojo.Operacao;
import br.com.dojo.OperacaoCambio;
import br.com.dojo.TipoCliente;

public class MensageriaBacenTest {

	@Test
	public void requisito1() {
		OperacaoCambio operacao = new OperaCambioBean(1L, Empresa.Banco,
				Operacao.Compra, "Joao", TipoCliente.PessoaJuridica,100003.0);

		Boleto resultado = new MensageriaMDB().onMessage(operacao);

		Assert.assertEquals("ABC01", resultado.getTipo());
		Assert.assertEquals("Compra PJ", resultado.getDescricaoEvento());
		Assert.assertEquals(100003.0, resultado.getValor(), 0.01);
	}


	@Test
	public void requisito2() {
		OperacaoCambio operacao = new OperaCambioBean(1L, Empresa.Banco,
				Operacao.Compra, "Joao", TipoCliente.PessoaJuridica,1000.0);

		Boleto resultado = new MensageriaMDB().onMessage(operacao);

		Assert.assertEquals("ABC07", resultado.getTipo());
		Assert.assertEquals("Compra PJ simples", resultado.getDescricaoEvento());
		Assert.assertEquals(1000.0, resultado.getValor(), 0.01);
	}

	@Test
	public void requisito3() {
		OperacaoCambio operacao = new OperaCambioBean(1L, Empresa.Corretora,
				Operacao.Compra, "Joao", TipoCliente.PessoaFisica,1000.0);
		Boleto resultado = new MensageriaMDB().onMessage(operacao);
		Assert.assertEquals("ABC09", resultado.getTipo());
		Assert.assertEquals("Compra PF", resultado.getDescricaoEvento());
		Assert.assertEquals(1000.0, resultado.getValor(), 0.01);


		operacao = new OperaCambioBean(1L, Empresa.Corretora,
				Operacao.Compra, "Joao", TipoCliente.PessoaJuridica,1000.0);
		resultado = new MensageriaMDB().onMessage(operacao);
		Assert.assertEquals("ABC07", resultado.getTipo());
		Assert.assertEquals("Compra PJ", resultado.getDescricaoEvento());
		Assert.assertEquals(1000.0, resultado.getValor(), 0.01);


		operacao = new OperaCambioBean(1L, Empresa.Corretora,
				Operacao.Venda, "Joao", TipoCliente.PessoaFisica,1000.0);
		resultado = new MensageriaMDB().onMessage(operacao);
		Assert.assertEquals("ABC09", resultado.getTipo());
		Assert.assertEquals("Venda PF", resultado.getDescricaoEvento());
		Assert.assertEquals(1000.0, resultado.getValor(), 0.01);


		operacao = new OperaCambioBean(1L, Empresa.Corretora,
				Operacao.Venda, "Joao", TipoCliente.PessoaJuridica,1000.0);
		resultado = new MensageriaMDB().onMessage(operacao);
		Assert.assertEquals("ABC07", resultado.getTipo());
		Assert.assertEquals("Venda PJ", resultado.getDescricaoEvento());
		Assert.assertEquals(1000.0, resultado.getValor(), 0.01);

	}

	@Test
	public void requisito4() {
		OperacaoCambio operacao = new OperaCambioBean(1L, Empresa.Corretora,
				Operacao.Compra, "Joao", TipoCliente.Estrangeiro, 10005.0);
		Boleto resultado = new MensageriaMDB().onMessage(operacao);
		Assert.assertEquals("ABC07", resultado.getTipo());
		Assert.assertEquals("Compra PF", resultado.getDescricaoEvento());
		Assert.assertEquals(10005.0, resultado.getValor(), 0.01);

	}
}
