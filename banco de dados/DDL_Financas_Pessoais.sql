DROP TABLE IF EXISTS tb_receitas;
DROP TABLE IF EXISTS tb_despesas;
DROP TABLE IF EXISTS tb_conta;

CREATE DATABASE IF NOT EXISTS db_financas_pessoais;
USE db_financas_pessoais;

CREATE TABLE IF NOT EXISTS tb_conta (
    id INTEGER NOT NULL AUTO_INCREMENT NOT NULL,
    tipo_conta INTEGER NOT NULL,
    instituicao VARCHAR(50) NOT NULL,
    
    CONSTRAINT tb_conta_id_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_receitas (
    id INTEGER NOT NULL AUTO_INCREMENT,
    valor DECIMAL(8,2) NOT NULL,
    data_recebimento DATE NOT NULL,
    data_recebimento_esperado DATE,
    descricao VARCHAR(255),
    tipo_receita INTEGER NOT NULL,
    conta_id INTEGER NOT NULL,
    
    CONSTRAINT tb_receitas_id_pk PRIMARY KEY (id),
    FOREIGN KEY (conta_id) REFERENCES tb_conta(id)
);

CREATE TABLE IF NOT EXISTS tb_despesas (
    id INTEGER AUTO_INCREMENT NOT NULL,
    valor DECIMAL(8,2) NOT NULL,
    data_pagamento DATE NOT NULL,
    data_pagamento_esperado DATE ,
    tipo_despesa INTEGER NOT NULL,
    conta_id INTEGER NOT NULL,
    
    CONSTRAINT tb_despesas_id_pk PRIMARY KEY (id),
    FOREIGN KEY (conta_id) REFERENCES tb_conta(id)
);
