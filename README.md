# Fórum Hub API

API REST desenvolvida em **Java + Spring Boot** como projeto de conclusão de um curso da **Alura**. O projeto simula o backend de um fórum, permitindo o gerenciamento de tópicos com autenticação via token.

---

## Funcionalidades

A API permite a **manipulação de tópicos** de um fórum, incluindo:

*  Criar um tópico
*  Listar todos os tópicos
*  Buscar detalhes de um tópico por ID
*  Editar um tópico existente
*  Deletar um tópico por ID

###  Dados de um tópico

* Título
* Mensagem
* Autor
* Nome do curso
* Data de criação (gerada automaticamente)
* Status (ativo/inativo)

---

##  Segurança

Usamos **Spring Security** para:

* Autenticação de usuários
* Geração de **token JWT** no login
* Proteção dos endpoints, permitindo acesso apenas a usuários autenticados

---

##  Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* MySQL
* Flyway (versionamento do banco de dados)
* Maven

---

##  Banco de Dados

* Banco: **MySQL**
* As migrações de banco são gerenciadas com **Flyway**
* As configurações de acesso ao banco são feitas via **Variáveis de Ambiente**, utilizando o arquivo `application.properties`

### Exemplo de variáveis de ambiente:

```bash
DB_HOST=(servidor local ou na nuvem)
DB_USER=(Seu usuário de banco)
DB_PASSWORD=(Sua senha de banco)
DB_NAME=(Nome do banco de dados)
```

---

##  Como executar o projeto

### Pré-requisitos

* Java 17+
* Maven
* MySQL

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/luizzlh/Forum-Hub.git
```

2. Configure as variáveis de ambiente do banco de dados

3. Execute o projeto:

```bash
mvn spring-boot:run
```

4. A API estará disponível em:

```
http://localhost:8080
```

---

##  Endpoints Principais

### Autenticação

* `POST /login` → Realiza login e retorna o token JWT

### Tópicos

* `POST /topicos` → Criar tópico
* `GET /topicos` → Listar tópicos
* `GET /topicos/{id}` → Detalhar tópico
* `PUT /topicos/{id}` → Atualizar tópico
* `DELETE /topicos/{id}` → Deletar tópico

>  Todos os endpoints (exceto login) exigem autenticação via token

---

##  Contexto Acadêmico

Este projeto foi desenvolvido como parte de um **curso da Alura**, com foco em:

* Construção de APIs REST
* Boas práticas com Spring Boot
* Segurança com Spring Security
* Persistência de dados com JPA

---

##  Autor

Luiz
