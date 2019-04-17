package br.com.etechoracio.etec_boaviagem;

public enum TipoGastoEnum {
    ALIMENTACAO("Alimentação"),
    COMBUSTIVEL("Combustível"),
    TRANSPORTE ("Transporte"),
    HOSPEDAGEM ("Hospedagem"),
    OUTROS ("Outros");


    TipoGastoEnum(String descrição) {
        this.descrição = descrição;
    }

    private  String descrição;

    public String toString() {
        return descrição;
    }
}
