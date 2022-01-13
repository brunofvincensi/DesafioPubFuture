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