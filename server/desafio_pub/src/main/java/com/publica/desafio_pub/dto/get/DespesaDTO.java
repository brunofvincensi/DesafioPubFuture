package com.publica.desafio_pub.dto.get;

import com.publica.desafio_pub.models.Despesa;

import java.time.LocalDate;


public class DespesaDTO {

    private Long id;
    private Double valor;
    private LocalDate dataPagamento;
    private LocalDate dataPagamentoEsperado;
    private String tipoDespesa;

    public DespesaDTO() {
    }

    public DespesaDTO(Long id, Double valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, String tipoDespesa) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
    }

    public DespesaDTO(Despesa despesa){
        this.id = despesa.getId();
        this.valor = despesa.getValor();
        this.dataPagamento = despesa.getDataPagamento();
        this.dataPagamentoEsperado = despesa.getDataPagamentoEsperado();
        this.tipoDespesa = despesa.getTipoDespesa();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(LocalDate dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
}
