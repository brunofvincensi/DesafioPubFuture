package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.ContaDTO;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<ContaDTO> findAll() {
        List<Conta> contaList = contaRepository.findAll();
        return contaList.stream().map(x -> new ContaDTO(x)).collect(Collectors.toList());
    }


    public Conta save(Conta conta) {
        contaRepository.save(conta);
        return conta;
    }
}
