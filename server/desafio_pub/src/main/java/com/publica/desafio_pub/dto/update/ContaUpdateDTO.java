package com.publica.desafio_pub.dto.update;

import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.services.ContaService;

public class ContaUpdateDTO {

    private Double saldo;
    private String tipoConta;
    private String instituicao;

    public ContaUpdateDTO() {
    }

    public ContaUpdateDTO(Double saldo, String tipoConta, String instituicao) {
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.instituicao = instituicao;
    }

    public Conta update(Long id, ContaService contaService) {

        Conta conta = contaService.getById(id);

        conta.setSaldo(this.saldo);
        conta.setTipoConta(this.tipoConta);
        conta.setInstituicao(this.instituicao);

        return conta;
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
