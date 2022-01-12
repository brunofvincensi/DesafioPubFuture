package com.publica.desafio_pub;

public enum TipoDespesa {

    MANHA("manhã"),
    TARDE("tarde"),
    NOITE("noite");

    private String descricao;

    TipoDespesa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
