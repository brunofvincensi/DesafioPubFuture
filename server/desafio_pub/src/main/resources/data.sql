INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(550, 'carteira', 'Itau')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(1000, 'carteira', 'Viacred')
INSERT INTO tb_conta(saldo, tipo_conta, instituicao) VALUES(4000, 'carteira', 'Itau')

INSERT INTO tb_receita(valor, descricao, conta_id) VALUES(44, 'descricao qualquer', 2)
INSERT INTO tb_despesa(valor, conta_id) VALUES(30, 2)

INSERT INTO tb_receita(valor, descricao, conta_id) VALUES(150, 'ganhou na loteria', 2)
INSERT INTO tb_despesa(valor, conta_id) VALUES(50, 2)

INSERT INTO tb_receita(valor, descricao, conta_id) VALUES(1500, 'recebimento salario', 3)
INSERT INTO tb_despesa(valor, conta_id) VALUES(100, 3)