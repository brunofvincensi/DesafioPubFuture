package com.publica.desafio_pub.repositories;

import com.publica.desafio_pub.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
