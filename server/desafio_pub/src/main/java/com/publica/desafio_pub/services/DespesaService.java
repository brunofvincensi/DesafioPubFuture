package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.DespesaDTO;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<DespesaDTO> findAll() {
        List<Despesa> despesaList = despesaRepository.findAll();
        return despesaList.stream().map(x -> new DespesaDTO(x)).collect(Collectors.toList());
    }

}
