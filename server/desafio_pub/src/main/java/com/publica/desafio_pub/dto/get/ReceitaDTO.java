package com.publica.desafio_pub.dto.get;

import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.models.Receita;
import java.time.LocalDate;

public class ReceitaDTO {

    private Long id;
    private Double valor;
    private LocalDate dataRecebimento;
    private LocalDate dataRecebimentoEsperado;
    private String descricao;
    private TipoReceita tipoReceita;
    private Long contaId;

    public ReceitaDTO() {
    }

    public ReceitaDTO(Long id, Double valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado,
                      String descricao, TipoReceita tipoReceita, Long contaId) {
        this.id = id;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
        this.contaId = contaId;
    }

    public ReceitaDTO(Receita receita){
        this.id = receita.getId();
        this.valor = receita.getValor();
        this.dataRecebimento = receita.getDataRecebimento();
        this.dataRecebimentoEsperado = receita.getDataRecebimentoEsperado();
        this.descricao = receita.getDescricao();
        this.tipoReceita = receita.getTipoReceita();
        this.contaId = receita.getConta().getId();

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
