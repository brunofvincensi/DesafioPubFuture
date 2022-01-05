package com.publica.desafio_pub.dto.update;

import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.services.DespesaService;

import java.util.Date;

public class DespesaUpdateDTO {
    private Double valor;
    private Date dataRecebimento;
    private Date dataRecebimentoEsperado;
    private String tipoDespesa;

    public DespesaUpdateDTO() {
    }

    public DespesaUpdateDTO(Long id, Double valor, Date dataRecebimento, Date dataRecebimentoEsperado, String tipoDespesa) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.tipoDespesa = tipoDespesa;
    }

    public Despesa update(Long id, DespesaService despesaService) {

        Despesa despesa = despesaService.findById(id).get();

        despesa.setValor(this.valor);
        despesa.setDataRecebimento(this.dataRecebimento);
        despesa.setDataRecebimentoEsperado(this.dataRecebimentoEsperado);
        despesa.setTipoDespesa(this.tipoDespesa);

        return despesa;
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

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }


}
