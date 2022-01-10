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

    public void transferirSaldo(Long id1, Long id2, Double valor) {

        Conta conta1 = contaRepository.findById(id1).get();

        Conta conta2 = contaRepository.findById(id2).get();

        Double saldo1 = conta1.getSaldo();

        Double saldo2 = conta2.getSaldo();

        if(saldo1 > valor){

            saldo1 -= valor;
            conta1.setSaldo(saldo1);

            saldo2 += valor;
            conta2.setSaldo(saldo2);


            contaRepository.findById(id1)
                    .map(conta -> {
                        conta.setSaldo(conta1.getSaldo());
                        contaRepository.save(conta);
                        return true;
                    });

            contaRepository.findById(id2)
                    .map(conta -> {
                        conta.setSaldo(conta2.getSaldo());
                        contaRepository.save(conta);
                        return true;
                    });

        }

    }

    public Double getSaldoTotal(List<ContaDTO> contaList) {

        Double saldoTotal = 0.0;
        for (ContaDTO conta: contaList
        ) {
            saldoTotal += conta.getSaldo();

        }

        return saldoTotal;
    }


}
