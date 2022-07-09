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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    private final DespesaRepository despesaRepository;

    private final ReceitaRepository receitaRepository;

    public ContaService(ContaRepository contaRepository, DespesaRepository despesaRepository, ReceitaRepository receitaRepository) {
        this.contaRepository = contaRepository;
        this.despesaRepository = despesaRepository;
        this.receitaRepository = receitaRepository;
    }

    // busca todas as contas
    public List<ContaDTO> findAll() {
        return contaRepository.findAll()
                .stream()
                .map(ContaDTO::new)
                .collect(Collectors.toList());
    }

    // salva uma conta
    public Conta save(ContaInsertDTO contaInsertDTO) {
        Conta conta = contaInsertDTO.converter(contaRepository);
        return contaRepository.save(conta);
    }

    // busca uma conta por id
    public Optional<Conta> findById(Long id) {
        return contaRepository.findById(id);
    }

    // deleta uma conta e todas as despesas e receitas relacionadas a ela
    @Transactional
    public void delete(Conta conta) throws ServiceException{
        despesaRepository.deleteAll(conta.getDespesas());
        receitaRepository.deleteAll(conta.getReceitas());
        contaRepository.delete(conta);
    }

    // transfere o saldo entre contas gerando uma despesa na primeira conta e receita na segunda
    public Boolean transferirSaldo(Long id1, Long id2, Double valor) throws ServiceException{

            Conta contaTransferencia = contaRepository
                    .findById(id1)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

            Conta contaDeposito = contaRepository
                    .findById(id2)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

           if(valor <= contaTransferencia.getSaldo()) {

               Despesa despesa = new Despesa(valor, LocalDate.now(), TipoDespesa.TRANSFERENCIA, contaTransferencia);

               Receita receita = new Receita(valor, LocalDate.now(), "valor transferido pela conta " + id1,
                       TipoReceita.TRANSFERENCIA, contaDeposito);

               despesaRepository.save(despesa);
               receitaRepository.save(receita);

               return true;
           }
               return false;
    }

    // busca o saldo total
    public Double getSaldoTotal(List<ContaDTO> contaList) {
        return contaList.stream().mapToDouble(ContaDTO::getSaldo).sum();
    }
}
