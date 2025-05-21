# Financial Management System

## About
- A project to manage personal finances
- REST API built with Java/Spring Boot on the server side, consumed by a ReactJS front-end client

## [Documentation PT](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/FinancialManagementSystem_doc.docx)
## [Documentation EN](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/FinancialManagementSystem_doc_EN.docx)

![GIF_TELAS](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/images/financas_pessoais_gif.gif)

## Technologies Used
- Java
- Spring Boot
- JUnit
- Hibernate
- JUnit
- MySQL
- ReactJS (JavaScript, HTML, CSS)
- Bootstrap
- GIT | GitHub

# How to Run the Project

OBS.: Note: The project was originally built with MySQL, but for easier setup, the Java backend is connected to the H2 in-memory database.
SQL file with database and tables for MySQL: DesafioPubFuture/data_base/DDL_Financas_Pessoais.sql

## Back end
Prerequisites: 
 - Java 11
 - Intellij IDE
 - MySQL

```bash

# clone the repository
git clone https://github.com/Bruno-ferrariv/desafiopubfuture.git


# navigate to the backend project directory
cd desafiopubfuture/server/desafio_pub

# run the project
./mvnw spring-boot:run
```

## Front end
Prerequisites: 
- NodeJS
- npm

```bash
# navigate to the frontend project directory
cd desafiopubfuture/client

# install dependencies
npm i

# run the project
npm start
```
## 

## UML Diagram (Unified Modeling Language)

![UML](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/images/UML.PNG)

## Development Pattern
- Layered architecture

![UML](https://github.com/Bruno-ferrariv/desafiopubfuture/blob/main/images/padr%C3%A3o%20camadas.png)

## Funcionalidades

Features
- CRUD operations
- Filter by period (startDate - endDate)
- Filter by expense type
- List total expenses by account

Revenues
- CRUD operations
- Filter by period (startDate - endDate)
- Filter by revenue type
- List total revenues by account

Accounts
- CRUD operations
- Transfer balance between accounts
- List total balance
