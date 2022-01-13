package com.publica.desafio_pub.dto.insert;

import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.repositories.ContaRepository;

import java.time.LocalDate;

public class ReceitaInsertDTO {


    private Double valor;
    private LocalDate dataRecebimento;
    private LocalDate dataRecebimentoEsperado;
    private String descricao;
    private TipoReceita tipoReceita;
    private Long contaId;

    public ReceitaInsertDTO() {
    }

    public ReceitaInsertDTO(Double valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado,
                      String descricao, TipoReceita tipoReceita, Long contaId) {

        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
        this.contaId = contaId;
    }

    public Receita converter(ContaRepository contaRepository) {


        Conta conta = contaRepository.findById(contaId).get();

        return new Receita(valor, dataRecebimento, dataRecebimentoEsperado, descricao, tipoReceita, conta);

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

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

}
