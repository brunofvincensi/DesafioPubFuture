package com.publica.desafio_pub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;
 //   @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_pagamento_esperado")
    private LocalDate dataPagamentoEsperado;

    @Column(name = "tipo_despesa")
    private String tipoDespesa;

    @JsonIgnore
    @JoinColumn(name = "conta_id")
    @ManyToOne
    private Conta conta;

    public Despesa() {
    }

    public Despesa(Long id, Double valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, String tipoDespesa,
                   Conta conta) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }

    public Despesa( Double valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, String tipoDespesa,
                   Conta conta) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }

    public Despesa(Double valor, LocalDate dataPagamento, String tipoDespesa, Conta conta) {
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

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
