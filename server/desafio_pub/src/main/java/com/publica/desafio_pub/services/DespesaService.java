package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.dto.insert.DespesaInserDTO;
import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.repositories.ContaRepository;
import com.publica.desafio_pub.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;

    private final ContaRepository contaRepository;

    public DespesaService(DespesaRepository despesaRepository, ContaRepository contaRepository) {
        this.despesaRepository = despesaRepository;
        this.contaRepository = contaRepository;
    }

    // busca todas as despesas ordenadas por id da conta
    public List<DespesaDTO> findAll() {
        List<Despesa> despesaList = despesaRepository.findAllOrderByContaId();
        return despesaList.stream().map(DespesaDTO::new).collect(Collectors.toList());
    }

    // salva uma despesa em uma conta selecionada
    public Despesa save(DespesaInserDTO despesaInserDTO, Long id) {

        despesaInserDTO.setContaId(id);
        Despesa despesa = despesaInserDTO.converter(contaRepository);

        return despesaRepository.save(despesa);
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
        return list.stream().map(DespesaDTO::new).collect(Collectors.toList());
    }

    // busca as despesas do tipo requerido
    public List<DespesaDTO> filtroPorTipo(TipoDespesa tipoDespesa) {
        List<Despesa> list = despesaRepository.
                filtroPorTipo(
                        Arrays.asList(TipoDespesa.values()).indexOf(tipoDespesa)
                );
        return list.stream().map(DespesaDTO::new).collect(Collectors.toList());
    }

    // busca a despesa total por conta
    public Double getDespesaTotal(Conta conta) {
        return conta.getDespesas().stream().mapToDouble(Despesa::getValor).sum();
    }
}
