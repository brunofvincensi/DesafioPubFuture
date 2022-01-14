package com.publica.desafio_pub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publica.desafio_pub.enums.TipoDespesa;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "valor")
    private Double valor;

    @NotNull
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "data_pagamento_esperado")
    private LocalDate dataPagamentoEsperado;

    @NotNull
    @Column(name = "tipo_despesa")
    private TipoDespesa tipoDespesa;

    @JsonIgnore
    @JoinColumn(name = "conta_id", nullable = false)
    @ManyToOne
    private Conta conta;

    public Despesa() {
    }

    public Despesa(Long id, Double valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, TipoDespesa tipoDespesa,
                   Conta conta) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }

    public Despesa( Double valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, TipoDespesa tipoDespesa,
                   Conta conta) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }

    public Despesa(Double valor, LocalDate dataPagamento, TipoDespesa tipoDespesa, Conta conta) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return Objects.equals(id, despesa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
