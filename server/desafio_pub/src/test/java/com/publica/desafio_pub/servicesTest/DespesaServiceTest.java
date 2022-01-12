package com.publica.desafio_pub.servicesTest;

import com.publica.desafio_pub.dto.get.DespesaDTO;
import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.services.DespesaService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class DespesaServiceTest {

    @Autowired
    private DespesaService despesaService;

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test
    public void findByIdTest(){

        Despesa despesa = despesaService.findById(1L).get();

        Assertions.assertEquals(350.0, despesa.getValor());
        Assertions.assertEquals(LocalDate.parse("1999-01-01", format), despesa.getDataPagamento());
        Assertions.assertEquals(LocalDate.parse("2000-01-01", format), despesa.getDataPagamentoEsperado());
        Assertions.assertEquals("comida", despesa.getTipoDespesa());

    }

    @Test
    public void filtroPorDataTest(){

      List<DespesaDTO> list = despesaService.filtroPorData("2002-01-01", "2016-01-01");

      Assertions.assertEquals(list.get(0).getDataPagamento(), LocalDate.parse("2015-08-03", format) );

    }

    @Test
    public void filtroPorTipoTest(){

        List<DespesaDTO> list = despesaService.filtroPorTipo(TipoDespesa.ALIMENTACAO);

        Assertions.assertEquals(list.get(0).getValor(), 350.0);
        Assertions.assertEquals(list.get(0).getDataPagamento(), LocalDate.parse("1999-01-01", format));
    }




}
