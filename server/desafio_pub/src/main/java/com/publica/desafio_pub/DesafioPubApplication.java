package com.publica.desafio_pub;

import com.publica.desafio_pub.enums.TipoConta;
import com.publica.desafio_pub.enums.TipoDespesa;
import com.publica.desafio_pub.enums.TipoReceita;
import com.publica.desafio_pub.models.Conta;
import com.publica.desafio_pub.models.Despesa;
import com.publica.desafio_pub.models.Receita;
import com.publica.desafio_pub.repositories.ContaRepository;
import com.publica.desafio_pub.repositories.DespesaRepository;
import com.publica.desafio_pub.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class DesafioPubApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPubApplication.class, args);
	}

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private DespesaRepository despesaRepository;

	@Autowired
	private ReceitaRepository receitaRepository;

	@Override
	public void run(String... args) throws Exception {


		Conta conta1 = new Conta(TipoConta.CONTA_CORRENTE, "Itau");
		Conta conta2 = new Conta(TipoConta.CARTEIRA, "Viacredi");
		Conta conta3 = new Conta(TipoConta.POUPANCA, "Banco do Brasil");

		contaRepository.saveAll(Arrays.asList(conta1, conta2, conta3));


		Receita receita1 = new Receita(500.0, LocalDate.parse("2017-12-22"),LocalDate.parse("2017-10-20"),
				"deposito",  TipoReceita.SALARIO, conta1 );

		Receita receita2 = new Receita(750.0, LocalDate.parse("2019-02-05"),LocalDate.parse("2020-10-07"),
				"salario mensal", TipoReceita.PRESENTE, conta2 );

		Receita receita3 = new Receita(645.50, LocalDate.parse("2021-06-11"),LocalDate.parse("2021-03-20"),
				" ganho na loteria pela mega sena", TipoReceita.PREMIO, conta3 );

		receitaRepository.saveAll(Arrays.asList(receita1, receita2, receita3));


		Despesa despesa1 = new Despesa(350.0, LocalDate.parse("1999-01-01"), LocalDate.parse("2000-01-01"),
				TipoDespesa.ALIMENTACAO, conta1 );

		Despesa despesa2 = new Despesa(200.75, LocalDate.parse("2000-11-01"), LocalDate.parse("2012-01-01"),
				TipoDespesa.ROUPA, conta2 );

		Despesa despesa3 = new Despesa(350.0, LocalDate.parse("2015-08-03"), LocalDate.parse("2016-01-01"),
				TipoDespesa.TRANSPORTE, conta3 );


        despesaRepository.saveAll(Arrays.asList(despesa1, despesa2, despesa3));

	}
}
