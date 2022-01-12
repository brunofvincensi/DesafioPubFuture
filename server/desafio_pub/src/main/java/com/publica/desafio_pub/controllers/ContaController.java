package com.publica.desafio_pub.controllers;

import com.publica.desafio_pub.dto.get.ContaDTO;
import com.publica.desafio_pub.dto.update.ContaUpdateDTO;
import com.publica.desafio_pub.exception.ResourceNotFoundException;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.services.ContaService;
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
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<ContaDTO>> listarTodos(){

        List<ContaDTO> contaList = contaService.findAll();
        return ResponseEntity.ok().body(contaList);
    }

    @GetMapping("/saldo_total")
    public Double getSaldoTotal(){

        List<ContaDTO> contaList = contaService.findAll();

        Double saldoTotal = contaService.getSaldoTotal(contaList);

       return saldoTotal;
    }

    @PostMapping
    public ResponseEntity<ContaDTO> inserir(@RequestBody Conta conta, UriComponentsBuilder uriBuilder){

        try {
            Conta obj = contaService.save(conta);

            URI uri = uriBuilder.path("/contas/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(new ContaDTO(obj));

        }catch (ServiceException e){

            return ResponseEntity.unprocessableEntity().build();
        }

    }

    /**
     *
     * @param id
     * id da conta na qual será alterada
     * @param updateDTO
     * @return
     * cdcdcdcdcd
     *
     */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ContaDTO> alterar(@PathVariable Long id, @RequestBody ContaUpdateDTO updateDTO){

        Optional<Conta> contaOpt = contaService.findById(id);

        if(contaOpt.isPresent()){

            Conta conta = updateDTO.update(id, contaService);
            return ResponseEntity.ok(new ContaDTO(conta));

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Map<String, Boolean>> deletar(@PathVariable Long id){
        Conta conta = contaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não existe com o id :" + id));
        contaService.delete(conta);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping ("/{id}")
    public ResponseEntity <ContaDTO> redirecionamento (@PathVariable Long id) {
        Optional<Conta> contaOptional = contaService.findById(id) ;
        if (contaOptional.isPresent ()) {

            return ResponseEntity.ok( new ContaDTO(contaOptional.get())) ;
        }
        return ResponseEntity. notFound () .build () ;
    }

    @PatchMapping ("/transferir_saldo")
    public ResponseEntity<Boolean>  transferirSaldo( Long id1, Long id2, Double valor){

          Boolean foiTranferido = contaService.transferirSaldo(id1, id2, valor);

          if(foiTranferido){
              return ResponseEntity.ok().body(true);
          }
          else{
              return ResponseEntity.badRequest().body(false);
          }
    }

}
