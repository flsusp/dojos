package br.com.dojo;

public interface OperacaoCambioVenda {

    Long getId();
    Empresa getEmpresa();
    Operacao getOperacao();
    String getCliente();
    TipoCliente getTipoCliente();
    double getValor();
}
