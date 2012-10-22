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

	public boolean isPessoaJuridica(){
		return   operacaoCambio.getTipoCliente() == TipoCliente.PessoaJuridica;
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
		if (isPessoaJuridica()) {
			return decideDescricaoQuandoPJ();
		} else {
			return decideDescricaoQuandoPessoaFisicaOuEstrangeiro();
		}
	}

	private String decideDescricaoQuandoPJ() {
		String descricao = COMPRA_PJ;

		if (operacaoCambio.getEmpresa() == Empresa.Corretora)
			descricao = decideDescricaoQuandoCorretoraEPJ();
		else if (operacaoCambio.getValor() <= 10000.0)
			descricao = COMPRA_PJ_SIMPLES;

		if (getTipo().equals("ABC01"))
			descricao += "**";

		return descricao;
	}

	private String decideDescricaoQuandoCorretoraEPJ() {
		String descricao;
		if (operacaoCambio.getOperacao() == Operacao.Venda) {
			descricao = VENDA_PJ;
		} else  {
			descricao = COMPRA_PJ;
		}
		return descricao;
	}

	private String decideDescricaoQuandoPessoaFisicaOuEstrangeiro() {
		String descricao;
		if (operacaoCambio.getOperacao() == Operacao.Venda) {
			descricao = VENDA_PF;
		} else {
			descricao =  COMPRA_PF;
		}
		return descricao;
	}

}
