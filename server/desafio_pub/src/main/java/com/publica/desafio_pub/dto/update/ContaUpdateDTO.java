package com.publica.desafio_pub.dto.update;

import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.services.ContaService;

public class ContaUpdateDTO {


    private String tipoConta;
    private String instituicao;

    public ContaUpdateDTO() {
    }

    public ContaUpdateDTO(String tipoConta, String instituicao) {

        this.tipoConta = tipoConta;
        this.instituicao = instituicao;
    }

    public Conta update(Long id, ContaService contaService) {

        Conta conta = contaService.findById(id).get();

        conta.setTipoConta(this.tipoConta);
        conta.setInstituicao(this.instituicao);

        return conta;
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
