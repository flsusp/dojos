package br.com.dojo;

public class MensageriaMDB {

    public Boleto onMessage(OperacaoCambio op) {
    		OperacaoCambioWrapper operacaoCambio = new OperacaoCambioWrapper(op);

    		return new Boleto(operacaoCambio);
    }
}
