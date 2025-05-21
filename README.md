# Sistema de Gestão Finançeira

## Sobre
- Projeto para gerir finanças pessoais
- API REST criada pelo Spring Boot(Java) na parte servidor e consumida pela tecnologia front-end ReactJS na parte do cliente

## [Documentação](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/DesafioPubFuture_doc.docx)

![GIF_TELAS](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/imagens/financas_pessoais_gif.gif)

## Tecnologias utilizadas

- Spring Boot (Java)
- MySQL
- ReactJS (Java Script, HTML, CSS)
- Bootstrap
- GIT | GitHub
- Intellij - IDE
- Postman | banco H2 | JUnit - para testes

# Instruções para rodar o projeto

OBS.: O projeto foi feito com o banco de dados MySQL, mas para facilitar a instalação do projeto foi mantido a ligação do java com o banco H2
rota do arquivo com o banco de dados e tabelas no MySQL: DesafioPubFuture/data_base/DDL_Financas_Pessoais.sql

## Back end
Pré-requisitos: 
 - Java 11
 - Intellij IDE
 - MySQL

```bash

# clonar repositório
git clone https://github.com/Bruno-ferrariv/desafiopubfuture.git


# entrar na pasta do projeto back end pelo terminal
cd desafiopubfuture/server/desafio_pub

# executar o projeto
./mvnw spring-boot:run
```

## Front end
Pré-requisitos: 
- NodeJS
- npm

```bash
# entrar na pasta do projeto front end pelo terminal
cd desafiopubfuture/client

# instalar dependências
npm i

# executar o projeto
npm start
```
## 

## Diagrama UML (Linguagem Unificada de Modelagem)

![UML](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/imagens/UML.PNG)

## Padrão de desenvolvimento
- padrão camadas

![UML](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/imagens/padr%C3%A3o%20camadas.png)

## Funcionalidades

Despesas
- métodos CRUD
- filtro por período (dataIncial - dataFinal)
- filtro por tipo de despesa
- listar despesa total por conta

Receitas
- métodos CRUD
- filtro por período (dataIncial - dataFinal)
- filtro por tipo de receita
- listar receita total por conta

Contas
- métodos CRUD
- transferir saldo entre contas
- listar saldo total
