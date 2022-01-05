package com.publica.desafio_pub.repositories;

import com.publica.desafio_pub.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findByDataPagamentoBetween(Date min, Date max);
}
