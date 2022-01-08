INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(550, 'carteira', 'Itau')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(1000, 'carteira', 'Viacred')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'carteira', 'Itau')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'carteira', 'Itau')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'carteira', 'Itau')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'carteira', 'Itau')

INSERT INTO tb_receitas(valor, descricao, conta_id) VALUES(44, 'descricao qualquer', 2)
INSERT INTO tb_despesas(valor, conta_id) VALUES(30, 2)

INSERT INTO tb_receitas(valor, data_recebimento, descricao, conta_id) VALUES(150,'2017-08-10', 'ganhou na loteria', 2)
INSERT INTO tb_despesas(valor, data_pagamento, conta_id) VALUES(50,'2020-04-08', 2)

INSERT INTO tb_receitas(valor, descricao, conta_id) VALUES(1500, 'recebimento salario', 3)
INSERT INTO tb_despesas(valor, conta_id) VALUES(100, 3)