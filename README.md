# 🚗 Cadastro de Veículos

API RESTful desenvolvida em Java utilizando o framework Spring Boot, com o objetivo de gerenciar o cadastro de veículos.

---

## 🛠 Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot 3.x**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Módulo do Spring para interagir com bancos de dados relacionais.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.
- **Docker**: Plataforma para desenvolvimento, envio e execução de aplicações em containers.

---

## 📂 Estrutura do Projeto

```bash
cadastro-veiculo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── cadastro/
│       │           └── veiculo/
│       │               ├── controller/   # Camada de controle (endpoints)
│       │               ├── model/        # Entidades do domínio
│       │               ├── repository/   # Interfaces de acesso ao banco
│       │               └── service/      # Regras de negócio
│       └── resources/
│           ├── application.yml           # Configurações da aplicação
│           └── data.sql                  # Script de carga inicial (opcional)
├── .gitignore
├── docker-compose.yml                    # Configuração do banco via Docker
├── mvnw
├── mvnw.cmd
└── pom.xml                               # Gerenciador de dependências Maven
```

---

## 🚀 Como Executar o Projeto

### ✅ Pré-requisitos

- Java 17 ou superior
- Maven
- PostgreSQL ou Docker (opcional)

### 🧭 Passos para Execução

1. **Clonar o Repositório**

```bash
git clone https://github.com/douglasmoreira/cadastro-veiculo.git
cd cadastro-veiculo
```

2. **Configurar o Banco de Dados**

- **Com Docker**:

```bash
docker-compose up -d
```

- **Sem Docker**:
  - Instale o PostgreSQL
  - Crie um banco chamado `cadastro_veiculo`
  - Atualize `application.yml` com suas credenciais

3. **Instalar as Dependências**

```bash
./mvnw clean install
```

4. **Executar a Aplicação**

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
📍 `http://localhost:8080`

---

## 📖 Documentação da API

A documentação é gerada automaticamente com o Springdoc OpenAPI:

- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🧪 Executando Testes

```bash
./mvnw test
```

---

## 📄 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👤 Autor

- **Douglas Moreira** - [https://github.com/douglasmoreira](https://github.com/douglasmoreira)
