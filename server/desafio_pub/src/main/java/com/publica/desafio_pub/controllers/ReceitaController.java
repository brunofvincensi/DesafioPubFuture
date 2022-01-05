package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.dto.get.ReceitaDTO;
import com.publica.desafio_pub.dto.update.DespesaUpdateDTO;
import com.publica.desafio_pub.dto.update.ReceitaUpdateDTO;
import com.publica.desafio_pub.exception.ResourceNotFoundException;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> listarTodos(){

        List<ReceitaDTO> receitaList = receitaService.findAll();
        return ResponseEntity.ok().body(receitaList);

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
                .orElseThrow(() -> new ResourceNotFoundException("Conta não existe com o id :" + id));
        receitaService.delete(receita);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
