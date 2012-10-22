package br.com.dojo;

public class MensageriaMDB {

	public Boleto onMessage(OperacaoCambio op) {
		OperacaoCambioWrapper operacaoCambio = new OperacaoCambioWrapper(op);

	    // FIXME fabio
		Boleto boleto = new Boleto(operacaoCambio.getTipoCliente(),
				operacaoCambio.getTipo(), operacaoCambio.getDescricaoEvento(),
				operacaoCambio.getValor());
		return boleto;
	}
}
