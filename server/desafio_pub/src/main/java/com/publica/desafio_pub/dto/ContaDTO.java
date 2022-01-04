package com.publica.desafio_pub.dto;

import javax.persistence.Column;

public class ContaDTO {

    private Long id;
    private Double saldo;
    private String tipoConta;
    private String instituicao;

    public ContaDTO() {
    }

    public ContaDTO(Long id, Double saldo, String tipoConta, String instituicao) {
        this.id = id;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.instituicao = instituicao;
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
}
