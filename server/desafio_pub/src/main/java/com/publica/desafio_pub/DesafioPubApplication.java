package com.publica.desafio_pub;

import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DesafioPubApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPubApplication.class, args);
	}

	@Autowired
	private ContaRepository contaRepository;

	@Override
	public void run(String... args) throws Exception {

		Conta conta1 = new Conta(1540.44, "poupança", "Itau");
		Conta conta2 = new Conta(430.00, "salario", "Viacredi");
		Conta conta3 = new Conta(20560.20, "corrente", "Banco do Brasil");
		Conta conta4 = new Conta(10550.50, "poupança", "Bradesco");
		Conta conta5 = new Conta(766.88, "poupança", "Viacredi");

		contaRepository.saveAll(Arrays.asList(conta1, conta2, conta3, conta4, conta5));



	}
}
