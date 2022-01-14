package com.publica.desafio_pub.dto.insert;

import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.repositories.ContaRepository;
import java.time.LocalDate;

public class DespesaInserDTO {


    private Double valor;
    private LocalDate dataPagamento;
    private LocalDate dataPagamentoEsperado;
    private TipoDespesa tipoDespesa;
    private Long contaId;

    public DespesaInserDTO() {
    }

    public DespesaInserDTO( Double valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, TipoDespesa tipoDespesa,
                      Long contaId) {

        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.contaId = contaId;
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

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Despesa converter(ContaRepository contaRepository) {

        Conta conta = contaRepository.findById(contaId).get();

        return new Despesa(valor, dataPagamento, dataPagamentoEsperado, tipoDespesa, conta);
    }
}
