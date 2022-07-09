package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.ReceitaDTO;
import com.publica.desafio_pub.dto.insert.ReceitaInsertDTO;
import com.publica.desafio_pub.dto.update.ReceitaUpdateDTO;
import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.exception.ResourceNotFoundException;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.services.ContaService;
import com.publica.desafio_pub.services.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    private final ContaService contaService;

    public ReceitaController(ReceitaService receitaService, ContaService contaService) {
        this.receitaService = receitaService;
        this.contaService = contaService;
    }

    @GetMapping
    public List<ReceitaDTO> listarTodos(){
        return receitaService.findAll();
    }

    @GetMapping("/{id}")
    public ReceitaDTO listarPorId(@PathVariable Long id){
        Receita receita = receitaService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return new ReceitaDTO(receita);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ReceitaDTO inserir(@RequestBody ReceitaInsertDTO receitaInsertDTO, @PathVariable  Long id, UriComponentsBuilder uriBuilder) {
        Receita receita = receitaService.save(receitaInsertDTO, id);
        return new ReceitaDTO(receita);
    }

    @PutMapping("/{id}")
    @Transactional
    public ReceitaDTO alterar(@PathVariable Long id, @RequestBody ReceitaUpdateDTO updateDTO){
        if(receitaService.findById(id).isPresent()){
            Receita receita = updateDTO.update(id, receitaService);
            return new ReceitaDTO(receita);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public Map<String, Boolean> deletar(@PathVariable Long id) {
        Receita receita = receitaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receita não existe com o id :" + id));
        receitaService.delete(receita);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return response;
    }

    @GetMapping("/filtro/data")
    public List<ReceitaDTO> filtroPorData(@RequestParam(defaultValue = "1900-01-01") String dataInicial,
                                          @RequestParam(defaultValue = "2100-01-01") String dataFinal) {
        return receitaService.filtroPorData(dataInicial, dataFinal);
    }

    @GetMapping("/filtro/tipo")
    public List<ReceitaDTO> filtroPorTipo(TipoReceita tipoReceita) {
        return receitaService.filtroPorTipo(tipoReceita);
    }

    @GetMapping("/receita_total/{id}")
    public Double receitaTotalPorConta(@PathVariable Long id){
        Conta conta = contaService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return receitaService.getReceitaTotal(conta);
    }

}