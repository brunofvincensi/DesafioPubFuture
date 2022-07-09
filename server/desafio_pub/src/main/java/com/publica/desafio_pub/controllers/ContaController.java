package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.ContaDTO;
import com.publica.desafio_pub.dto.insert.ContaInsertDTO;
import com.publica.desafio_pub.dto.update.ContaUpdateDTO;
import com.publica.desafio_pub.exception.ResourceNotFoundException;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.services.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public List<ContaDTO> listarTodos(){
        return contaService.findAll();
    }

    @GetMapping("/saldo_total")
    public Double getSaldoTotal(){
        List<ContaDTO> contaList = contaService.findAll();
        return contaService.getSaldoTotal(contaList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaDTO inserir(@RequestBody ContaInsertDTO contaInsertDTO){
        Conta obj = contaService.save(contaInsertDTO);
        return new ContaDTO(obj);
    }

    @PutMapping("/{id}")
    @Transactional
    public ContaDTO alterar(@PathVariable Long id, @RequestBody ContaUpdateDTO updateDTO){
        if(contaService.findById(id).isPresent()){
            Conta conta = updateDTO.update(id, contaService);
            return new ContaDTO(conta);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deletar(@PathVariable Long id){
        Conta conta = contaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não existe com o id :" + id));
        contaService.delete(conta);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping ("/{id}")
    public ContaDTO redirecionamento (@PathVariable Long id) {
        Conta conta = contaService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return new ContaDTO(conta);
    }

    @PatchMapping ("/transferir_saldo")
    public Boolean transferirSaldo( Long id1, Long id2, Double valor){
        return contaService.transferirSaldo(id1, id2, valor);
    }

}