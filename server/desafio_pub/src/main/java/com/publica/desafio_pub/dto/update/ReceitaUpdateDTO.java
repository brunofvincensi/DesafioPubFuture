package com.publica.desafio_pub.dto.update;

import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.services.ReceitaService;

import java.util.Date;

public class ReceitaUpdateDTO {private Double valor;
    private Date dataRecebimento;
    private Date dataRecebimentoEsperado;
    private String descricao;
    private String tipoReceita;

    public ReceitaUpdateDTO() {
    }

    public ReceitaUpdateDTO(Long id, Double valor, Date dataRecebimento, Date dataRecebimentoEsperado, String descricao, String tipoReceita) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
    }

    public Receita update(Long id, ReceitaService receitaService) {

        Receita receita = receitaService.findById(id).get();

        receita.setValor(this.valor);
        receita.setDataRecebimento(this.dataRecebimento);
        receita.setDataRecebimentoEsperado(this.dataRecebimentoEsperado);
        receita.setDescricao(this.descricao);
        receita.setTipoReceita(this.tipoReceita);

        return receita;
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
