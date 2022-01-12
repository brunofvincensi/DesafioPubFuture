package com.publica.desafio_pub.servicesTest;

import com.publica.desafio_pub.enums.TipoConta;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.services.ContaService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ContaServiceTest {

    @Autowired
    private ContaService contaService;

    @Test
    public void findByIdTest(){

        Conta conta = contaService.findById(1L).get();

        Assertions.assertEquals(TipoConta.CONTA_CORRENTE, conta.getTipoConta());
        Assertions.assertEquals("Itau", conta.getInstituicao());
    }


}
