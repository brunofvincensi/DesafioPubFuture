package com.publica.desafio_pub.controllers;


import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.dto.update.DespesaUpdateDTO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/despesa")
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

    @PostMapping
    public ResponseEntity<DespesaDTO> inserir(@RequestBody Despesa despesa, Long id, UriComponentsBuilder uriBuilder){


        Conta conta = contaService.findById(id).get();


        try {
            Despesa obj = despesaService.save(despesa);

            URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(new DespesaDTO(obj));

        }catch (ServiceException e){

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
                .orElseThrow(() -> new ResourceNotFoundException("Conta não existe com o id :" + id));
        despesaService.delete(despesa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
