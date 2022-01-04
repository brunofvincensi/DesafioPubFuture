package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.ReceitaDTO;
import com.publica.desafio_pub.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
