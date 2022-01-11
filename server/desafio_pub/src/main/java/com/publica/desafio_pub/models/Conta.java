package com.publica.desafio_pub.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tipo_conta")
    private String tipoConta;

    @NotNull
    @Column(name = "instituicao")
    private String instituicao;

    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "conta")
    private List<Receita> receitas = new ArrayList<>();

    @OneToMany(cascade =  CascadeType.ALL,  mappedBy = "conta")
    private List<Despesa> despesas = new ArrayList<>();

    public Conta() {
    }

    public Conta(Long id, String tipoConta, String instituicao, List<Receita> receitas, List<Despesa> despesas) {
        this.id = id;
        this.tipoConta = tipoConta;
        this.instituicao = instituicao;
        this.receitas = receitas;
        this.despesas = despesas;
    }

    public Conta(String tipoConta, String instituicao) {
        this.tipoConta = tipoConta;
        this.instituicao = instituicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id);
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

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public Double getSaldoo(){
        Double valorReceitas = 0.0;
        Double valorDespesass = 0.0;
        Double saldo;
        for (Receita receita : this.receitas) {

            valorReceitas += receita.getValor();

        }
        for (Despesa despesa : this.despesas) {

            valorDespesass += despesa.getValor();

        }
        saldo = valorReceitas - valorDespesass;

        return saldo;
    }

}
