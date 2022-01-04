package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.ContaDTO;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.services.ContaService;
import com.publica.desafio_pub.services.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/curso")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<ContaDTO>> listarTodos(){

        List<ContaDTO> contaList = contaService.findAll();
        return ResponseEntity.ok().body(contaList);
    }

    @PostMapping
    public ResponseEntity<Conta> inserir(@RequestBody Conta conta, UriComponentsBuilder uriBuilder){

        try {
            Conta obj = contaService.save(conta);

            URI uri = uriBuilder.path("/contas/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(obj);

        }catch (ServiceException e){

            return ResponseEntity.unprocessableEntity().build();
        }


    }



}
