package br.com.dojo;

public class Boleto {

    private String tipo;
    private String numeroControleInstituicaoFinanceira;
    private String descricaoEvento;
    private double valor;
    private String cliente;

    public Boleto(TipoCliente cliente, String tipo, String descricaoEvento, double valor) {
		this.cliente= cliente.name();
		this.tipo = tipo;
		this.descricaoEvento=descricaoEvento;
		this.valor=valor;
	}

    public Boleto(OperacaoCambioWrapper op) {
		this.cliente= op.getTipoCliente().name();
		this.tipo = op.getTipo();
		this.descricaoEvento= op.getDescricaoEvento();
		this.valor=op.getValor();
	}

	public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroControleInstituicaoFinanceira() {
        return numeroControleInstituicaoFinanceira;
    }

    public void setNumeroControleInstituicaoFinanceira(String numeroControleInstituicaoFinanceira) {
        this.numeroControleInstituicaoFinanceira = numeroControleInstituicaoFinanceira;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
