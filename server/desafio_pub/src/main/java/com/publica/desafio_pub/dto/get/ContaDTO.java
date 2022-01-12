package com.publica.desafio_pub.dto.get;

import com.publica.desafio_pub.enums.TipoConta;
import com.publica.desafio_pub.models.Conta;

import javax.persistence.Column;

public class ContaDTO {

    private Long id;
    private Double saldo;
    private TipoConta tipoConta;
    private String instituicao;

    public ContaDTO() {
    }

    public ContaDTO(Long id, Double saldo, TipoConta tipoConta, String instituicao) {
        this.id = id;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.instituicao = instituicao;
    }

    public ContaDTO(Conta conta){
        this.id = conta.getId();
        this.saldo = conta.getSaldo();
        this.tipoConta = conta.getTipoConta();
        this.instituicao = conta.getInstituicao();
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

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
