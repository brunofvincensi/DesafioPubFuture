package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<DespesaDTO> findAll() {
        List<Despesa> despesaList = despesaRepository.findAll();
        return despesaList.stream().map(x -> new DespesaDTO(x)).collect(Collectors.toList());
    }

    public Despesa save(Despesa despesa) {

        despesaRepository.save(despesa);
        return despesa;
    }

    public Optional<Despesa> findById(Long id) {

        return despesaRepository.findById(id);
    }


    public void delete(Despesa despesa) {

        despesaRepository.delete(despesa);
    }
}
