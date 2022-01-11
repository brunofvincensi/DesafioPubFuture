CREATE TABLE IF NOT EXISTS tb_despesas (
    id INTEGER AUTO_INCREMENT NOT NULL,
    valor DECIMAL(8,2) NOT NULL,
    data_pagamento DATE NOT NULL,
    data_pagamento_esperado DATE ,
    tipo_despesa VARCHAR(50) NOT NULL,
    conta_id INTEGER NOT NULL,
    
    CONSTRAINT tb_despesas_id_pk PRIMARY KEY (id),
    FOREIGN KEY (conta_id) REFERENCES tb_conta(id)
);