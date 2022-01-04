package com.publica.desafio_pub.dto.get;

import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Receita;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ReceitaDTO {

    private Long id;
    private Double valor;
    private Date dataRecebimento;
    private Date dataRecebimentoEsperado;
    private String descricao;
    private String tipoReceita;

    public ReceitaDTO() {
    }

    public ReceitaDTO(Long id, Double valor, Date dataRecebimento, Date dataRecebimentoEsperado, String descricao, String tipoReceita) {
        this.id = id;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
    }

    public ReceitaDTO(Receita receita){
        this.id = receita.getId();
        this.valor = receita.getValor();
        this.dataRecebimento = receita.getDataRecebimento();
        this.dataRecebimentoEsperado = receita.getDataRecebimentoEsperado();
        this.descricao = receita.getDescricao();
        this.tipoReceita = receita.getTipoReceita();


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

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }
}
