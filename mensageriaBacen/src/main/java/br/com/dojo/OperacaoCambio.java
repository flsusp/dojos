package br.com.dojo;

public interface OperacaoCambio {

    Long getId();
    Empresa getEmpresa();
    Operacao getOperacao();
    String getCliente();
    TipoCliente getTipoCliente();
    double getValor();
}
