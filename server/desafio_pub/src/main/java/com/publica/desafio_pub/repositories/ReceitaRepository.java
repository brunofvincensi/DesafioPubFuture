package com.publica.desafio_pub.repositories;

import com.publica.desafio_pub.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query(value = "select * from tb_receitas where data_recebimento between ?1 and ?2", nativeQuery = true)
    List<Receita> filtroPorData(LocalDate localDate1, LocalDate localDate2);

    @Query(value = "select * from tb_receitas where tipo_receita = ?1", nativeQuery = true)
    List<Receita> filtroPorTipo(Integer tipoReceitaId);

    @Query(value = "select * from tb_receitas order by conta_id", nativeQuery = true)
    List<Receita> findAllOrderByContaId();
}
