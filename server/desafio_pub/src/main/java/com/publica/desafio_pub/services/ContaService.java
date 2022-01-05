package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.ContaDTO;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.repositories.ContaRepository;
import com.publica.desafio_pub.repositories.DespesaRepository;
import com.publica.desafio_pub.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private ReceitaRepository receitaRepository;

    public List<ContaDTO> findAll() {
        List<Conta> contaList = contaRepository.findAll();
        return contaList.stream().map(x -> new ContaDTO(x)).collect(Collectors.toList());
    }


    public Conta save(Conta conta) {
        contaRepository.save(conta);
        return conta;
    }

    public Optional<Conta> findById(Long id) {

        return contaRepository.findById(id);
    }


    public void delete(Conta conta) {

        for (int i = 0; i < conta.getDespesas().size(); i++) {
            despesaRepository.delete(conta.getDespesas().get(i));
        }
        for (int i = 0; i < conta.getReceitas().size(); i++) {
            receitaRepository.delete(conta.getReceitas().get(i));
        }

        contaRepository.delete(conta);

    }
}
