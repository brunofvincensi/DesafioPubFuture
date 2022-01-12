package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.dto.update.DespesaUpdateDTO;
import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.exception.ResourceNotFoundException;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.services.ContaService;
import com.publica.desafio_pub.services.DespesaService;
import com.publica.desafio_pub.services.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<DespesaDTO>> listarTodos(){

        List<DespesaDTO> despesaList = despesaService.findAll();
        return ResponseEntity.ok().body(despesaList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDTO> listarPorId(@PathVariable Long id){

        Despesa despesa = despesaService.findById(id).get();
        return ResponseEntity.ok().body(new DespesaDTO(despesa));

    }

    @GetMapping("/despesa_total/{id}")
    public Double despesaTotalPorConta(@PathVariable Long id){

        Conta conta = contaService.findById(id).get();
        Double despesaTotal = despesaService.getDespesaTotal(conta);

        return despesaTotal;
    }


    @PostMapping("/{id}")
    public ResponseEntity<DespesaDTO> inserir(@RequestBody Despesa despesa, @PathVariable  Long id, UriComponentsBuilder uriBuilder) {


        Conta conta = contaService.findById(id).get();

        try {

            despesa.setConta(conta);
            boolean isValid = despesaService.save(despesa, conta);

            if (isValid) {

                URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(despesa.getId()).toUri();
                return ResponseEntity.created(uri).body(new DespesaDTO(despesa));
            }

            else {
                return ResponseEntity.badRequest().body(new DespesaDTO(despesa));
            }

        } catch (ServiceException e) {

            return ResponseEntity.unprocessableEntity().build();
        }

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DespesaDTO> alterar(@PathVariable Long id, @RequestBody DespesaUpdateDTO updateDTO){

        Optional<Despesa> despesaOpt = despesaService.findById(id);

        if(despesaOpt.isPresent()){

            Despesa despesa = updateDTO.update(id, despesaService);

            return ResponseEntity.ok(new DespesaDTO(despesa));

        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Map<String, Boolean>> deletar(@PathVariable Long id){
        Despesa despesa = despesaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Despesa não existe com o id :" + id));
        despesaService.delete(despesa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filtro/data")
    public ResponseEntity<List<DespesaDTO>> filtroPorData(@RequestParam(defaultValue = "1900-01-01") String dataInicial,
                                                          @RequestParam(defaultValue = "2100-01-01") String dataFinal) {

        List<DespesaDTO> list = despesaService.filtroPorData(dataInicial, dataFinal);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/filtro/tipo")
    public ResponseEntity<List<DespesaDTO>> filtroPorTipo(TipoDespesa tipoDespesa) {

        List<DespesaDTO> list = despesaService.filtroPorTipo(tipoDespesa);
        return ResponseEntity.ok().body(list);
    }



}
