package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    @GetMapping("/contas")
    String getConta(Model model){

        model.addAttribute("listaConta", contaRepository.findAll());
        return "conta";
    }

    @GetMapping("/contas/nova")
    public String novaConta(@ModelAttribute("conta") Conta conta)
    {
      return "form";
    }

    @PostMapping("/contas/salvar")
    public String salvarConta(@ModelAttribute("conta") Conta conta){

        contaRepository.save(conta);
        return "redirect:/contas";
    }


}
