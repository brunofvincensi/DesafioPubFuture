package com.publica.desafio_pub.dto.update;

import com.publica.desafio_pub.enums.TipoConta;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.services.ContaService;

public class ContaUpdateDTO {


    private TipoConta tipoConta;
    private String instituicao;

    public ContaUpdateDTO() {
    }

    public ContaUpdateDTO(TipoConta tipoConta, String instituicao) {

        this.tipoConta = tipoConta;
        this.instituicao = instituicao;
    }

    public Conta update(Long id, ContaService contaService) {

        Conta conta = contaService.findById(id).get();

        conta.setTipoConta(this.tipoConta);
        conta.setInstituicao(this.instituicao);

        return conta;
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
