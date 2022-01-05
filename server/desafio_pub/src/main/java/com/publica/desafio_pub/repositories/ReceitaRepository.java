package com.publica.desafio_pub.repositories;

import com.publica.desafio_pub.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query(value = "select * from tb_receitas where data_recebimento > ?1 and data_recebimento < ?2", nativeQuery = true)
    List<Receita> findByDataRecebimentoBetween(LocalDate localDate, LocalDate localDate2);
}
