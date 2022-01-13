CREATE TABLE IF NOT EXISTS tb_conta (
    id INTEGER NOT NULL AUTO_INCREMENT NOT NULL,
    tipo_conta INTEGER NOT NULL,
    instituicao VARCHAR(50) NOT NULL,
    
    CONSTRAINT tb_conta_id_pk PRIMARY KEY (id)
);