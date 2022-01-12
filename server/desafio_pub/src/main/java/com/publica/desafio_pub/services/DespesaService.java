package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.repositories.ContaRepository;
import com.publica.desafio_pub.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private ContaRepository contaRepository;

    // busca todas as despesas
    public List<DespesaDTO> findAll() {
        List<Despesa> despesaList = despesaRepository.findAllOrderByContaId();
        return despesaList.stream().map(x -> new DespesaDTO(x)).collect(Collectors.toList());
    }

    // salva uma despesa em uma conta selecionada se o valor for menor que o saldo desta conta
    public boolean save(Despesa despesa, Conta conta) {

        Double saldo = conta.getSaldo();
        if(saldo > despesa.getValor()){

            despesa.setConta(conta);
            despesaRepository.save(despesa);

            return true;
        }

        else{

            System.out.println("valor da despesa maior que o saldo na conta");
            return false;
        }

    }

    // busca uma despesa por id
    public Optional<Despesa> findById(Long id) {

        return despesaRepository.findById(id);
    }

    // deleta uma despesa
    public void delete(Despesa despesa) {

        despesaRepository.delete(despesa);
    }


    // busca as despesas entre as datas requeridas
    public List<DespesaDTO> filtroPorData(String dataInicial, String dataFinal) {

       DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate localDate1 = LocalDate.parse(dataInicial, format);
       LocalDate localDate2 = LocalDate.parse(dataFinal, format);

       List<Despesa> list = despesaRepository.filtroPorData(localDate1, localDate2);
        return list.stream().map(x -> new DespesaDTO(x)).collect(Collectors.toList());
    }

    // busca as despesas do tipo requerido
    public List<DespesaDTO> filtroPorTipo(TipoDespesa tipoDespesa) {

        Integer tipoDespesaId = null;

        switch (tipoDespesa){
            case ALIMENTACAO: tipoDespesaId = 0;
                break;
            case EDUCACAO: tipoDespesaId = 1;
                break;
            case LAZER: tipoDespesaId = 2;
                break;
            case MORADIA: tipoDespesaId = 3;
                break;
            case ROUPA: tipoDespesaId = 4;
                break;
            case SAUDE: tipoDespesaId = 5;
                break;
            case TRANSPORTE: tipoDespesaId = 6;
                break;
            case TRANSFERENCIA: tipoDespesaId = 7;
                break;
            case OUTROS: tipoDespesaId = 8;
                break;
        }

        List<Despesa> list = despesaRepository.filtroPorTipo(tipoDespesaId);

        return list.stream().map(x -> new DespesaDTO(x)).collect(Collectors.toList());
    }

    // busca a receita total por conta
    public Double getDespesaTotal(Conta conta) {

        Double cont = 0.0;
        List<Despesa> despesas = conta.getDespesas();

        for (Despesa despesa: despesas) {

            cont += despesa.getValor();
        }
        return cont;
    }
}
