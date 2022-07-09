package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.dto.insert.DespesaInserDTO;
import com.publica.desafio_pub.dto.update.DespesaUpdateDTO;
import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.exception.ResourceNotFoundException;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.services.ContaService;
import com.publica.desafio_pub.services.DespesaService;
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
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService despesaService;

    private final ContaService contaService;

    public DespesaController(DespesaService despesaService, ContaService contaService) {
        this.despesaService = despesaService;
        this.contaService = contaService;
    }

    @GetMapping
    public List<DespesaDTO> listarTodos(){
        return despesaService.findAll();
    }

    @GetMapping("/{id}")
    public DespesaDTO listarPorId(@PathVariable Long id){
        Despesa despesa = despesaService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return new DespesaDTO(despesa);
    }

    @GetMapping("/despesa_total/{id}")
    public Double despesaTotalPorConta(@PathVariable Long id){
        Conta conta = contaService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        return despesaService.getDespesaTotal(conta);
    }


    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DespesaDTO inserir(@RequestBody DespesaInserDTO despesaInserDTO, @PathVariable  Long id, UriComponentsBuilder uriBuilder) {
        return new DespesaDTO(despesaService.save(despesaInserDTO, id));
    }

    @PutMapping("/{id}")
    @Transactional
    public DespesaDTO alterar(@PathVariable Long id, @RequestBody DespesaUpdateDTO updateDTO){

        if(despesaService.findById(id).isPresent()){
            Despesa despesa = updateDTO.update(id, despesaService);
            return new DespesaDTO(despesa);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public Map<String, Boolean> deletar(@PathVariable Long id){
        Despesa despesa = despesaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Despesa não existe com o id :" + id));
        despesaService.delete(despesa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return response;
    }

    @GetMapping("/filtro/data")
    public List<DespesaDTO> filtroPorData(@RequestParam(defaultValue = "1900-01-01") String dataInicial,
                                          @RequestParam(defaultValue = "2100-01-01") String dataFinal) {
        return despesaService.filtroPorData(dataInicial, dataFinal);
    }

    @GetMapping("/filtro/tipo")
    public List<DespesaDTO> filtroPorTipo(TipoDespesa tipoDespesa) {
        return despesaService.filtroPorTipo(tipoDespesa);
    }

}