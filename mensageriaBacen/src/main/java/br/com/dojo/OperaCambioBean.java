package br.com.dojo;

public class OperaCambioBean implements OperacaoCambio{

	private Long id;
	private Empresa empresa;
	private Operacao operacao;
	private String cliente;
    private TipoCliente tipoCliente;
    private double valor;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Operacao getOperacao() {
		return operacao;
	}
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	
	public double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public OperaCambioBean(Long id, Empresa empresa, Operacao operacao,
			String cliente, TipoCliente tipoCliente, Double valor) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.operacao = operacao;
		this.cliente = cliente;
		this.tipoCliente = tipoCliente;
		this.valor = valor;
	}
	
}
