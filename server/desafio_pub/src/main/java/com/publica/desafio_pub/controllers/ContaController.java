package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.repositories.ContaRepository;
import com.publica.desafio_pub.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;


@RestController
@RequestMapping("/curso")
public class ContaController {

    @Autowired
    private ContaService contaService;



}
