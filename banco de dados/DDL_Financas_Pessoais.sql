DROP TABLE IF EXISTS tb_receitas;
DROP TABLE IF EXISTS tb_despesas;
DROP TABLE IF EXISTS tb_conta;

DROP database db_financas_pessoais;
CREATE DATABASE IF NOT EXISTS db_financas_pessoais;
USE db_financas_pessoais;


CREATE TABLE IF NOT EXISTS tb_conta (
    id INTEGER NOT NULL AUTO_INCREMENT,
    saldo DECIMAL(10,2),
    tipo_conta VARCHAR(50),
    instituicao VARCHAR(50),
    
    CONSTRAINT tb_conta_id_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_receitas (
    id INTEGER NOT NULL AUTO_INCREMENT,
    valor DECIMAL(8,2),
    data_recebimento DATE,
    data_recebimento_esperado DATE,
    descricao VARCHAR(255),
    tipo_receita VARCHAR(50),
    conta_id INTEGER,
    
    CONSTRAINT tb_receitas_id_pk PRIMARY KEY (id),
    FOREIGN KEY (conta_id) REFERENCES tb_conta(id)
);

CREATE TABLE IF NOT EXISTS tb_despesas (
    id INTEGER AUTO_INCREMENT,
    valor DECIMAL(8,2) ,
    data_pagamento DATE ,
    data_pagamento_esperado DATE ,
    tipo_despesa VARCHAR(50) ,
    conta_id INTEGER ,
    
    CONSTRAINT tb_despesas_id_pk PRIMARY KEY (id),
    FOREIGN KEY (conta_id) REFERENCES tb_conta(id)
);
