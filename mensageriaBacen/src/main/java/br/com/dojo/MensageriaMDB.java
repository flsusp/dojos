package br.com.dojo;

public class MensageriaMDB {

	private static final String ABC01 = "ABC01";
	private static final String COMPRA_PF = "Compra PF";
	private static final String COMPRA_PJ = "Compra PJ";
	private static final String VENDA_PJ = "Venda PJ";
	private static final String VENDA_PF = "Venda PF";
	private static final String COMPRA_PJ_SIMPLES = "Compra PJ simples";
	public static final String ABC07 = "ABC07";
	private static final String ABC09 = "ABC09";
    public Boleto onMessage(OperacaoCambio operacaoCambio) {
    		
    		if(operacaoCambio.getTipoCliente() == TipoCliente.Estrangeiro || operacaoCambio.getTipoCliente()  == TipoCliente.PessoaFisica)
    		{
    			if(operacaoCambio.getOperacao() == Operacao.Venda)
    				return new Boleto(operacaoCambio.getTipoCliente(), ABC09, VENDA_PF,
    					operacaoCambio.getValor());
    			else if(operacaoCambio.getOperacao() == Operacao.Compra)
    				return new Boleto(operacaoCambio.getTipoCliente(), ABC09, COMPRA_PF,
        					operacaoCambio.getValor());
    		}
    	
    		if(operacaoCambio.getValor()<= 10000.0){
    			return new Boleto(operacaoCambio.getTipoCliente(), ABC07, COMPRA_PJ_SIMPLES, operacaoCambio.getValor());
    		}
    		return new Boleto(operacaoCambio.getTipoCliente(), ABC01, COMPRA_PJ, operacaoCambio.getValor());
    }
}
