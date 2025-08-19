# API de Produtos

Este projeto é uma API RESTful construída em Spring Boot para gerenciar produtos da loja LeroyMarcel, com suporte a paginação, validação de dados, HATEOAS e operações CRUD completas.

## Link do Deploy

https://exerciciorevisao-spring.onrender.com/ferramentas

## 🚀 Tecnologias Utilizadas

- Java 17+

- Spring Boot 3

- Spring Data JPA

- Spring HATEOAS

- Jakarta Validation

- Lombok

## 📌 Endpoints da API
🔹 Criar Produto

### POST /ferramentas
Request body:
```json
{
  "nome": "Furadeira Bosch",
  "tipo": "FERRAMENTA",
  "classificacao": "PROFISSIONAL",
  "tamanho": 30.5,
  "preco": 499.90
}
```


Response:
201 Created + objeto do produto criado.

🔹 Listar Produtos (paginação)

### GET /ferramentas?pagina=0&tamanho=5
Parâmetros:

pagina (default: 0)

tamanho (default: 5)

Response:
200 OK + lista paginada de produtos.

🔹 Obter Produto por ID

### GET /ferramentas/{id}
Response:
200 OK + detalhes do produto.

🔹 Atualizar Produto (parcial)

### PATCH /ferramentas/{id}
Request body:
```json
{
  "nome": "Furadeira Bosch 900W",
  "tipo": "FERRAMENTA",
  "classificacao": "AVANCADO",
  "tamanho": 32.0,
  "preco": 599.90
}
```


Response:
200 OK + produto atualizado.

🔹 Deletar Produto

### DELETE /ferramentas/{id}
Response:
204 No Content

## 🛠️ Exemplos de Links HATEOAS

Ao consultar um produto, a resposta contém links de ações possíveis:
```json
{
  "id": "123e4567-e89b-12d3-a456-426614174000",
  "nome": "Furadeira Bosch",
  "tipo": "FERRAMENTA",
  "classificacao": "PROFISSIONAL",
  "tamanho": 30.5,
  "preco": 499.90,
  "_links": {
    "self": {
      "href": "http://localhost:8080/ferramentas/123e4567-e89b-12d3-a456-426614174000",
      "type": "GET"
    },
    "excluir": {
      "href": "http://localhost:8080/ferramentas/123e4567-e89b-12d3-a456-426614174000",
      "type": "DELETE"
    },
    "atualizar": {
      "href": "http://localhost:8080/ferramentas/123e4567-e89b-12d3-a456-426614174000",
      "type": "PATCH"
    }
  }
}
```
