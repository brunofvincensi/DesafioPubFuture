package com.publica.desafio_pub.repositories;

import com.publica.desafio_pub.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {


    @Query(value = "select * from tb_despesas where data_pagamento > ?1 and data_pagamento < ?2", nativeQuery = true)
    List<Despesa> findByDataPagamentoBetween(LocalDate min, LocalDate max);

}
