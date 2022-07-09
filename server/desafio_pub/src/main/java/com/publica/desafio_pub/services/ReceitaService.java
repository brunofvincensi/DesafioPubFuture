package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.ReceitaDTO;
import com.publica.desafio_pub.dto.insert.ReceitaInsertDTO;
import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.repositories.ContaRepository;
import com.publica.desafio_pub.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private ContaRepository contaRepository;

    // busca todas as receitas ordenadas por id da conta
    public List<ReceitaDTO> findAll() {
        List<Receita> receitaList = receitaRepository.findAllOrderByContaId();
        return receitaList.stream().map(ReceitaDTO::new).collect(Collectors.toList());
    }

    //busca uma receita por id
    public Optional<Receita> findById(Long id) {
        return receitaRepository.findById(id);
    }

    // deleta uma receita
    public void delete(Receita receita) {
        receitaRepository.delete(receita);
    }

    // salva uma receita em uma conta selecionada
    public Receita save(ReceitaInsertDTO receitaInsertDTO, Long id) {

        receitaInsertDTO.setContaId(id);

        Receita receita = receitaInsertDTO.converter(contaRepository);

        receitaRepository.save(receita);
        return receita;
    }

    // busca as receitas entre as datas requeridas
    public List<ReceitaDTO> filtroPorData(String dataInicial, String dataFinal) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(dataInicial, format);
        LocalDate localDate2 = LocalDate.parse(dataFinal, format);

        List<Receita> list = receitaRepository.filtroPorData(localDate1, localDate2);
        return list.stream().map(ReceitaDTO::new).collect(Collectors.toList());
    }

    // busca as receitas do tipo requerido
    public List<ReceitaDTO> filtroPorTipo(TipoReceita tipoReceita) { 

        List<Receita> list = receitaRepository.filtroPorTipo(
                Arrays.asList(TipoReceita.values()).indexOf(tipoReceita)
        );

        return list.stream()
                .map(ReceitaDTO::new)
                .collect(Collectors.toList());
    }

    // busca a receita total por conta
    public Double getReceitaTotal(Conta conta) {
        return conta.getReceitas().stream().mapToDouble(Receita::getValor).sum();
    }
}
