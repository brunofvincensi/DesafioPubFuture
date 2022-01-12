package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.dto.get.ReceitaDTO;
import com.publica.desafio_pub.dto.update.ReceitaUpdateDTO;
import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.exception.ResourceNotFoundException;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.services.ContaService;
import com.publica.desafio_pub.services.ReceitaService;
import com.publica.desafio_pub.services.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> listarTodos(){

        List<ReceitaDTO> receitaList = receitaService.findAll();
        return ResponseEntity.ok().body(receitaList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> listarPorId(@PathVariable Long id){

        Receita receita = receitaService.findById(id).get();
        return ResponseEntity.ok().body(new ReceitaDTO(receita));

    }

    @PostMapping("/{id}")
    public ResponseEntity<ReceitaDTO> inserir(@RequestBody Receita receita, @PathVariable  Long id, UriComponentsBuilder uriBuilder) {


        Conta conta = contaService.findById(id).get();

        try {

            receita.setConta(conta);
            receitaService.save(receita, conta);

            URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(receita.getId()).toUri();
            return ResponseEntity.created(uri).body(new ReceitaDTO(receita));

        } catch (ServiceException e) {

            return ResponseEntity.unprocessableEntity().build();
        }

    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReceitaDTO> alterar(@PathVariable Long id, @RequestBody ReceitaUpdateDTO updateDTO){

        Optional<Receita> receitaOpt = receitaService.findById(id);

        if(receitaOpt.isPresent()){

            Receita receita = updateDTO.update(id, receitaService);

            return ResponseEntity.ok(new ReceitaDTO(receita));

        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Map<String, Boolean>> deletar(@PathVariable Long id){
        Receita receita = receitaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receita não existe com o id :" + id));
        receitaService.delete(receita);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filtro/data")
    public ResponseEntity<List<ReceitaDTO>> filtroPorData(@RequestParam(defaultValue = "1900-01-01") String dataInicial,
                                                          @RequestParam(defaultValue = "2100-01-01") String dataFinal) {

        List<ReceitaDTO> list = receitaService.filtroPorData(dataInicial, dataFinal);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/filtro/tipo")
    public ResponseEntity<List<ReceitaDTO>> filtroPorTipo(TipoReceita tipoReceita) {

        List<ReceitaDTO> list = receitaService.filtroPorTipo(tipoReceita);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/receita_total/{id}")
    public Double receitaTotalPorConta(@PathVariable Long id){

        Conta conta = contaService.findById(id).get();
        Double receitaTotal = receitaService.getReceitaTotal(conta);

        return receitaTotal;
    }

}
