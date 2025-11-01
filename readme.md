<p align="center">
  <img width="30%" src="images/backendbr-logo.png" alt="Magazine Luiza Logo">
</p>

<h3 align="center">Desafio Backend - Encurtador de URLs</h3>

<p align="center">
  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-Java%2025-blue">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">
</p>

---

## 🧭 Visão Geral
Este projeto implementa um **serviço backend de encurtador de url** para o desafio técnico do **Back-End Brasil**.  
A aplicação permite **encurtar url**  via API REST, utilizando **Spring Boot 3**, **Mongo** e **Springdoc OpenAPI**.

---

## 📚 Sumário
- [🧭 Visão Geral](#-visão-geral)
- [📚 Sumário](#-sumário)
- [⚙️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
- [🏗️ Arquitetura da Solução](#️-arquitetura-da-solução)
- [🚀 Execução do Projeto](#-execução-do-projeto)
  - [✅ Pré-requisitos](#-pré-requisitos)
  - [📥 Clonar o repositório](#-clonar-o-repositório)
  - [🐳 Subir containers](#-subir-containers)
  - [▶️ Rodar a aplicação](#️-rodar-a-aplicação)
  - [📦 Banco de Dados](#-banco-de-dados)
- [💬 Interagindo com a API](#-interagindo-com-a-api)
- [📬 Endpoints e Exemplos](#-endpoints-e-exemplos)
  - [1️⃣ Encurtar URL — POST `/shorten-url`](#1️⃣-encurtar-url--post-shorten-url)
  - [2️⃣ Redirecionamento URL original — GET `/shorten-url/{notificationId}`](#2️⃣-redirecionamento-url-original--get-shorten-urlnotificationid)
- [🤝 Contribuições](#-contribuições)
- [🔗 Referências e Créditos](#-referências-e-créditos)

---

## ⚙️ Tecnologias Utilizadas
| Tecnologia | Finalidade |
|-------------|-------------|
| ☕ **Java 25** | Linguagem principal |
| 🍃 **Spring Boot 3.x** | Framework de aplicação |
| 📦 **Spring Data MongoDB** | Persistência de dados NoSQL |
| 🩺 **Spring Boot Actuator** | Monitoramento e métricas da aplicação |
| ⚡ **Spring Boot DevTools** | Hot reload para desenvolvimento |
| 🌐 **Spring Web (Spring MVC)** | Criação das rotas REST |
| 📘 **Springdoc OpenAPI (Swagger UI)** | Documentação interativa da API |
| 🍁 **Commons Lang** | Gerar sequências aleatórias |
| ※ **RFC 9457 Problem Details** | Tratamento de erros |
| 🧰 **Lombok** | Redução de boilerplate |
| 🐳 **Docker** | Containerização do ambiente |

---

## 🏗️ Arquitetura da Solução
```bash
[Cliente / Postman]
↓
REST API (Spring Boot)
↓
[NotificationController]
├── POST /shorten-url → encurtar url
├── GET /shorten-url/{id} → redirecionamento para a URL original
↓
[Serviços]
└── UrlService (camada de negócio)
↓
[Banco de Dados Mongo]
```

---

## 🚀 Execução do Projeto
### ✅ Pré-requisitos
- **Java 25+**
- **Maven 3.9+**
- **Mongo**
- **Docker (opcional)**

### 📥 Clonar o repositório
```bash
git clone https://github.com/erichiroshi/desafio-backend-backendbrasil-url-shortener.git
cd desafio-backend-urlshortner
```

### 🐳 Subir containers
Na pasta `docker/`, execute:
```bash
docker-compose up -d
```

### ▶️ Rodar a aplicação
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:
👉 http://localhost:8080

Acessar a documentação Swagger
👉 http://localhost:8080/swagger-ui.html

### 📦 Banco de Dados
Por padrão, a aplicação utiliza o **mongodb + mongo-express**.  
Para acessar o console:  👉 [http://localhost:8081/](http://localhost:8081/)

---

## 💬 Interagindo com a API
As requisições podem ser testadas via Postman, Insomnia ou via Swagger UI.

---

## 📬 Endpoints e Exemplos
### 1️⃣ Encurtar URL — POST `/shorten-url`
Exemplo de Request

POST `/shorten-url`

Request Body

```bash
{
    "url": "https://backendbrasil.com.br"
}
```

Response

```bash
HTTP/1.1 200 OK

{
    "url": "https://xxx.com/DXB6V"
}
```

### 2️⃣ Redirecionamento URL original — GET `/shorten-url/{notificationId}`
Exemplo de Request 

GET `/shorten-url/DXB6V`

---

## 🤝 Contribuições
Contribuições são sempre bem-vindas!  
Para contribuir:

1. Crie um fork do repositório.  
2. Crie uma branch de feature:  
   ```bash
   git checkout -b feature/nome-da-feature
   ```
3. Commit suas mudanças:  
   ```bash
   git commit -m "feat: nova funcionalidade"
   ```
4. Envie um Pull Request. 

📜 **Boas práticas**
- Adicione testes unitários.  
- Documente suas alterações no código.  
- Use mensagens de commit seguindo o padrão **Conventional Commits**.

---

## 🔗 Referências e Créditos
- Desafio original: [Backend Brasil - url-shortener](https://github.com/backend-br/desafios/blob/master/url-shortener/PROBLEM.md)
- Baseado no conteúdo do canal [Build & Run](https://www.youtube.com/watch?v=BcatW6OAcp4&list=PLxCh3SsamNs7y1Y-QaVdWx0MUh0wvo7TV&index=6)
- Repositório do projeto: [desafio-backend-url-shortener](https://github.com/erichiroshi/desafio-backend-backendbrasil-url-shortener)
- Desenvolvido por [**Eric Hiroshi**](https://github.com/erichiroshi)
- Licença: [MIT](LICENSE)

---

<p align="center"> <em>“Software limpo é aquele que expressa a ideia do domínio com clareza e simplicidade.”</em> </p>