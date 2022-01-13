package com.publica.desafio_pub.dto.insert;

import com.publica.desafio_pub.enums.TipoConta;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.repositories.ContaRepository;

public class ContaInsertDTO {

        private TipoConta tipoConta;
        private String instituicao;

        public ContaInsertDTO() {
        }

        public ContaInsertDTO(TipoConta tipoConta, String instituicao) {
            this.tipoConta = tipoConta;
            this.instituicao = instituicao;
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


    public Conta converter(ContaRepository contaRepository) {
            return new Conta(tipoConta, instituicao);
    }
}
