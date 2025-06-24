# TechJobs API

TechJobs é uma API REST desenvolvida em Spring Boot para gerenciamento de vagas de emprego, empresas e candidatos. O projeto permite o cadastro, autenticação e gerenciamento de vagas, empresas e candidatos, além de possibilitar a aplicação de candidatos em vagas e o acompanhamento de dashboards.

## URL do Serviço em Produção

Acesse a API em produção: [https://apitechjobs.onrender.com/](https://apitechjobs.onrender.com/)

## Funcionalidades

- **Cadastro e autenticação** de candidatos e empresas
- **CRUD de vagas**, empresas e candidatos
- **Aplicação de candidatos** em vagas
- **Aprovação/recusa de aplicações** por empresas
- **Dashboards** para empresas e candidatos
- **Filtros de busca** para vagas, empresas e candidatos
- **Documentação automática** via Swagger/OpenAPI

## Endpoints principais

- `/candidato`: Gerenciamento de candidatos
- `/empresa`: Gerenciamento de empresas
- `/vaga`: Gerenciamento de vagas
- `/login`: Autenticação de usuários (candidato ou empresa)

Consulte a documentação Swagger em `/swagger-ui.html` após rodar o projeto.

## Tecnologias Utilizadas

- Java 24
- Spring Boot 3
- Spring Data JPA
- H2 Database (em memória)
- Maven
- Docker
- Swagger/OpenAPI (springdoc-openapi)

## Como rodar o projeto

### Pré-requisitos

- Java 24+
- Maven 3.9+
- Docker (opcional, para rodar em container)

### Rodando localmente

1. Clone o repositório:
    ```sh
    git clone <url-do-repo>
    cd SpringApiTechJobs
    ```

2. Compile e execute:
    ```sh
    ./mvnw spring-boot:run
    ```

3. Acesse a API em: [http://localhost:8080](http://localhost:8080)

4. Acesse o banco H2 em: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Usuário: `sa`
   - Senha: (em branco)

### Rodando com Docker

1. Gere o JAR:
    ```sh
    ./mvnw clean package
    ```

2. Construa a imagem Docker:
    ```sh
    docker build -t techjobs-api .
    ```

3. Rode o container:
    ```sh
    docker run -p 8080:8080 techjobs-api
    ```

### Deploy automatizado

O projeto possui workflow GitHub Actions para build e publicação automática da imagem Docker no Docker Hub a cada push na branch `main`.

## Estrutura do Projeto

- `src/main/java/br/com/techjobs/api/techjobs/controllers`: Controllers REST da aplicação
- `src/main/java/br/com/techjobs/api/techjobs/models`: Entidades JPA
- `src/main/java/br/com/techjobs/api/techjobs/repositories`: Repositórios JPA
- `src/main/java/br/com/techjobs/api/techjobs/models/dtos`: DTOs para comunicação
- `src/main/resources`: Configurações e scripts SQL

## Dados de exemplo

Ao iniciar, o banco H2 é populado automaticamente com dados de exemplo definidos em [`src/main/resources/import.sql`](src/main/resources/import.sql).

## Documentação da API

Acesse a documentação interativa em:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

Projeto para fins didáticos.