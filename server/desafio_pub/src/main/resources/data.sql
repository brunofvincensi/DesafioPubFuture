INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(550, 'carteira', 'Itau')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(1000, 'poupanca', 'Viacred')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'salario', 'Banco do Brasil')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'poupanca', 'Bradesco')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'carteira', 'Itau')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'carteira', 'Ailos')


INSERT INTO tb_receitas(valor, data_recebimento, data_recebimento_esperado, descricao, tipo_receita, conta_id) VALUES(2000,'2018-09-10', '2016-08-10', 'salario do mes', 'tipo 3', 4)
INSERT INTO tb_receitas(valor, data_recebimento, data_recebimento_esperado, descricao, tipo_receita, conta_id) VALUES(150,'2017-08-10', '2016-08-10', 'ganhou na loteria', 'tipo 1', 2)
INSERT INTO tb_receitas(valor, data_recebimento, data_recebimento_esperado, descricao, tipo_receita, conta_id) VALUES(444,'2015-08-10', '2016-08-10', 'ganhou na loteria','tipo 2', 1)


INSERT INTO tb_despesas(valor, data_pagamento, data_pagamento_esperado, tipo_despesa, conta_id) VALUES(150,'2018-12-23', '2019-02-07', 'compras no mercado',  2)
INSERT INTO tb_despesas(valor, data_pagamento, data_pagamento_esperado, tipo_despesa, conta_id) VALUES(50,'2020-04-08', '2019-11-08', 'carro',  2)
INSERT INTO tb_despesas(valor, data_pagamento, data_pagamento_esperado, tipo_despesa, conta_id) VALUES(455,'2020-04-08', '2019-11-08', 'casa',  4)