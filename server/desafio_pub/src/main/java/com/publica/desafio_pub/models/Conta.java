package com.publica.desafio_pub.models;

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
    @Column(name = "saldo")
    private Double saldo;
    @Column(name = "tipo_conta")
    private String tipoConta;
    @Column(name = "instituicao")
    private String instituicao;

    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "conta")
    private List<Receita> receitas = new ArrayList<>();

    @OneToMany(cascade =  CascadeType.ALL,  mappedBy = "conta")
    private List<Despesa> despesas = new ArrayList<>();

    public Conta() {
    }

    public Conta(Long id, Double saldo, String tipoConta, String instituicao, List<Receita> receitas, List<Despesa> despesas) {
        this.id = id;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.instituicao = instituicao;
        this.receitas = receitas;
        this.despesas = despesas;
    }

    public Conta(Double saldo, String tipoConta, String instituicao) {
        this.saldo = saldo;
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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
    
}
