package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.ReceitaDTO;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public List<ReceitaDTO> findAll() {

        List<Receita> receitaList = receitaRepository.findAll();
        return receitaList.stream().map(x -> new ReceitaDTO(x)).collect(Collectors.toList());
    }
}
