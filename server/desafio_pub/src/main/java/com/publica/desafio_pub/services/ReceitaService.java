package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.dto.get.ReceitaDTO;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.repositories.ContaRepository;
import com.publica.desafio_pub.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private ContaRepository contaRepository;

    public List<ReceitaDTO> findAll() {

        List<Receita> receitaList = receitaRepository.findAll();
        return receitaList.stream().map(x -> new ReceitaDTO(x)).collect(Collectors.toList());
    }

    public Optional<Receita> findById(Long id) {
        return receitaRepository.findById(id);
    }

    public void delete(Receita receita) {
        receitaRepository.delete(receita);
    }

    public void save(Receita receita, Conta conta, UriComponentsBuilder uriBuilder) {

        Double saldo = conta.getSaldo();

        receita.setValor(Math.abs(receita.getValor()));

        receitaRepository.save(receita);
        saldo += receita.getValor();
        conta.setSaldo(saldo);
        contaRepository.save(conta);

    }

    public List<ReceitaDTO> filtroPorData(String dataInicial, String dataFinal) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(dataInicial, format);
        LocalDate localDate2 = LocalDate.parse(dataFinal, format);

        List<Receita> list = receitaRepository.filtroPorData(localDate1, localDate2);
        return list.stream().map(x -> new ReceitaDTO(x)).collect(Collectors.toList());
    }

    public List<ReceitaDTO> filtroPorTipo(String tipoReceita) {
        List<Receita> list = receitaRepository.filtroPorTipo(tipoReceita);
        return list.stream().map(x -> new ReceitaDTO(x)).collect(Collectors.toList());

    }
}
