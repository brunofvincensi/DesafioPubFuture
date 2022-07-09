package com.publica.desafio_pub.dto.update;

import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.services.DespesaService;

import java.time.LocalDate;

public class DespesaUpdateDTO {
    private Double valor;
    private LocalDate dataPagamento;
    private LocalDate dataPagamentoEsperado;
    private TipoDespesa tipoDespesa;

    public DespesaUpdateDTO() {
    }

    public Despesa update(Long id, DespesaService despesaService) {

        Despesa despesa = despesaService.findById(id).get();

        despesa.setValor(this.valor);
        despesa.setDataPagamento(this.dataPagamento);
        despesa.setDataPagamentoEsperado(this.dataPagamentoEsperado);
        despesa.setTipoDespesa(this.tipoDespesa);

        return despesa;

    }

    public DespesaUpdateDTO(Double valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, TipoDespesa tipoDespesa) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
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

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

}
