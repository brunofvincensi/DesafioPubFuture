package com.publica.desafio_pub.dto.insert;

import java.util.Date;

public class DespesaInsertDTO {

    private Double valor;
    private Date dataRecebimento;
    private Date dataRecebimentoEsperado;
    private String tipoDespesa;

    public DespesaInsertDTO() {
    }

    public DespesaInsertDTO(Double valor, Date dataRecebimento, Date dataRecebimentoEsperado, String tipoDespesa) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.tipoDespesa = tipoDespesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
}
