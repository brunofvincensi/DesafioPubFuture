package com.publica.desafio_pub.servicesTest;

import com.publica.desafio_pub.dto.get.ReceitaDTO;
import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.services.ReceitaService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ReceitaServiceTest {

    @Autowired
    private ReceitaService receitaService;

    @Test
    public void findByIdTest(){

        Receita receita = receitaService.findById(2L).get();

        Assertions.assertEquals(750.0, receita.getValor());
        Assertions.assertEquals(LocalDate.parse("2019-02-05"), receita.getDataRecebimento());
        Assertions.assertEquals(LocalDate.parse("2020-10-07"), receita.getDataRecebimentoEsperado());
        Assertions.assertEquals(TipoReceita.PRESENTE, receita.getTipoReceita());
    }


    @Test
    public void filtroPorDataTest(){

        List<ReceitaDTO> list = receitaService.filtroPorData("2002-01-01", "2018-02-01");

        Assertions.assertEquals(list.get(0).getDataRecebimento(), LocalDate.parse("2017-12-22") );
    }

    @Test
    public void filtroPorTipoTest(){

        List<ReceitaDTO> list = receitaService.filtroPorTipo(TipoReceita.SALARIO);

        Assertions.assertEquals(list.get(0).getValor(), 500.0);
        Assertions.assertEquals(list.get(0).getDataRecebimento(), LocalDate.parse("2017-12-22"));
        Assertions.assertEquals(list.get(0).getDescricao(), "deposito");
    }
}
