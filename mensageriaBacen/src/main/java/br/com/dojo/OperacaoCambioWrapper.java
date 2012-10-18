package br.com.dojo;

public class OperacaoCambioWrapper implements OperacaoCambio{

	private static final String ABC01 = "ABC01";
	private static final String ABC07 = "ABC07";
	private static final String ABC09 = "ABC09";

	private OperacaoCambio operacaoCambio;

	public OperacaoCambioWrapper(OperacaoCambio op){
		this.operacaoCambio = op;
	}

	public boolean isPessoaFisica(){
		return   operacaoCambio.getTipoCliente()  == TipoCliente.PessoaFisica;
	}

	@Override
	public Long getId() {
		return operacaoCambio.getId();
	}

	@Override
	public Empresa getEmpresa() {
		return operacaoCambio.getEmpresa();
	}

	@Override
	public Operacao getOperacao() {
		return operacaoCambio.getOperacao();
	}

	@Override
	public String getCliente() {
		return operacaoCambio.getCliente();
	}

	@Override
	public TipoCliente getTipoCliente() {
		return operacaoCambio.getTipoCliente();
	}

	@Override
	public double getValor() {
		return operacaoCambio.getValor();
	}

	public String getTipo() {
		if(isPessoaFisica() || (isEstrangeiro() && operacaoCambio.getValor() <= 10000.0))
			return ABC09;

		if (operacaoCambio.getEmpresa() == Empresa.Corretora)
			return ABC07;

		if (operacaoCambio.getValor()<= 10000.0 || (isEstrangeiro() && operacaoCambio.getValor() > 10000.0))
			return ABC07;

		return ABC01;
	}

	private boolean isEstrangeiro() {
		return TipoCliente.Estrangeiro == getTipoCliente();
	}

	private static final String COMPRA_PF = "Compra PF";
	private static final String COMPRA_PJ = "Compra PJ";
	private static final String VENDA_PJ = "Venda PJ";
	private static final String VENDA_PF = "Venda PF";
	private static final String COMPRA_PJ_SIMPLES = "Compra PJ simples";

	public String getDescricaoEvento() {
		if(isPessoaFisica()||isEstrangeiro())
			return (operacaoCambio.getOperacao() == Operacao.Venda) ? VENDA_PF : COMPRA_PF;

		if (operacaoCambio.getEmpresa() == Empresa.Corretora)
			return (operacaoCambio.getOperacao() == Operacao.Venda) ? VENDA_PJ : COMPRA_PJ;

		if (operacaoCambio.getValor()<= 10000.0)
			return COMPRA_PJ_SIMPLES;


		return COMPRA_PJ;
	}

}
