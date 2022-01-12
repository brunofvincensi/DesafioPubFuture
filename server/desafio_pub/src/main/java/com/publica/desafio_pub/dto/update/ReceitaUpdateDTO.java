package com.publica.desafio_pub.dto.update;

import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.services.ReceitaService;

import java.time.LocalDate;


public class ReceitaUpdateDTO {
    private Double valor;
    private LocalDate dataRecebimento;
    private LocalDate dataRecebimentoEsperado;
    private String descricao;
    private TipoReceita tipoReceita;

    public ReceitaUpdateDTO() {
    }

    public ReceitaUpdateDTO(Double valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado, String descricao, TipoReceita tipoReceita) {
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
}
