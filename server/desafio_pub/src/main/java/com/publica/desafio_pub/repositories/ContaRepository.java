package com.publica.desafio_pub.repositories;

import com.publica.desafio_pub.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
