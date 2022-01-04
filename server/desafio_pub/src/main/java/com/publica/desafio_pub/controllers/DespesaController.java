package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping
    public ResponseEntity<List<DespesaDTO>> listarTodos(){

        List<DespesaDTO> despesaList = despesaService.findAll();
        return ResponseEntity.ok().body(despesaList);

    }
}
