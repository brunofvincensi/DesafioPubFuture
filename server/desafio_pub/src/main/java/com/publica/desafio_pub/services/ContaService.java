package com.publica.desafio_pub.services;

import com.publica.desafio_pub.dto.get.ContaDTO;
import com.publica.desafio_pub.dto.insert.ContaInsertDTO;
import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.repositories.ContaRepository;
import com.publica.desafio_pub.repositories.DespesaRepository;
import com.publica.desafio_pub.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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

    // busca todas as contas
    public List<ContaDTO> findAll() {
        List<Conta> contaList = contaRepository.findAll();
        return contaList.stream().map(x -> new ContaDTO(x)).collect(Collectors.toList());
    }

    // salva uma conta
    public Conta save(ContaInsertDTO contaInsertDTO) {

        Conta conta = contaInsertDTO.converter(contaRepository);
        contaRepository.save(conta);
        return conta;
    }

    // busca uma conta por id
    public Optional<Conta> findById(Long id) {

        return contaRepository.findById(id);
    }

    // deleta uma conta e todas as despesas e receitas relacionadas a ela
    public void delete(Conta conta) throws ServiceException{

        for (int i = 0; i < conta.getDespesas().size(); i++) {
            despesaRepository.delete(conta.getDespesas().get(i));
        }
        for (int i = 0; i < conta.getReceitas().size(); i++) {
            receitaRepository.delete(conta.getReceitas().get(i));
        }

        contaRepository.delete(conta);

    }

    // transfere o saldo entre contas gerando uma despesa na primeira conta e receita na segunda
    public Boolean transferirSaldo(Long id1, Long id2, Double valor) throws ServiceException{

            Conta conta1 = contaRepository.findById(id1).get();

            Conta conta2 = contaRepository.findById(id2).get();

            Double saldo1 = conta1.getSaldo();

           if(valor <= saldo1){

               Despesa despesa = new Despesa(valor, LocalDate.now(), TipoDespesa.TRANSFERENCIA, conta1);

               Receita receita = new Receita(valor, LocalDate.now(), "valor transferido pela conta " + id1,
                       TipoReceita.TRANSFERENCIA, conta2);

               despesaRepository.save(despesa);
               receitaRepository.save(receita);

               return true;
           }
           else {
               return false;

        }

    }

    // busca o saldo total
    public Double getSaldoTotal(List<ContaDTO> contaList) {

        Double saldoTotal = 0.0;

        for (ContaDTO conta: contaList) {

            saldoTotal += conta.getSaldo();

        }

        return saldoTotal;
    }


}
