package com.publica.desafio_pub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publica.desafio_pub.enums.TipoReceita;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_receitas")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "valor")
    private Double valor;

    @NotNull
    @Column(name = "data_recebimento")
    private LocalDate dataRecebimento;

    @Column(name = "data_recebimento_esperado")
    private LocalDate dataRecebimentoEsperado;

    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "tipo_receita")
    private TipoReceita tipoReceita;

    @JsonIgnore
    @JoinColumn(name = "conta_id", nullable = false)
    @ManyToOne
    private Conta conta;

    public Receita() {
    }

    public Receita(Long id, Double valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado, String descricao,
                   TipoReceita tipoReceita, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
        this.conta = conta;
    }

    public Receita(Double valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado, String descricao,
                   TipoReceita tipoReceita, Conta conta) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
        this.conta = conta;
    }

    public Receita(Double valor, LocalDate dataRecebimento, String descricao, TipoReceita tipoReceita, Conta conta) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return Objects.equals(id, receita.id);
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

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public LocalDate getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(LocalDate dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
