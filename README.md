# Sistema de Rastreabilidade de Lotes Industriais

Sistema sendo desenvolvido em **Java** com foco em **rastreabilidade de matérias-primas e produtos acabados em ambientes industriais**.

O projeto tem como objetivo modelar um processo de rastreabilidade capaz de acompanhar a origem dos materiais utilizados na produção, permitindo realizar uma **rastreabilidade reversa**, partindo de um produto acabado e chegando até os respectivos lotes de matéria-prima e fornecedores.

## 🎯 Objetivo

Em um ambiente industrial, é importante saber não apenas quais matérias-primas foram utilizadas na fabricação de um produto, mas também:

* Qual lote de matéria-prima foi utilizado;
* Qual fornecedor forneceu esse lote;
* Qual era a validade do material;
* Quanto material ainda está disponível;
* Em quais produtos um determinado lote foi utilizado;
* Quais produtos podem ter sido afetados por um determinado lote.

O sistema busca representar essas relações por meio de um **modelo de dados coerente**, permitindo consultar o histórico de utilização dos materiais.

---

📌 Rastreabilidade Reversa

A rastreabilidade reversa é o principal conceito do projeto.

A partir de um produto acabado, o sistema deve conseguir responder perguntas como:

"Quais matérias-primas foram utilizadas para produzir este produto?"

E, posteriormente:

"De quais fornecedores vieram essas matérias-primas?"

Isso permite construir uma cadeia de rastreabilidade:

Produto Acabado
       ↓
Produção
       ↓
Consumos
       ↓
Lotes de Matéria-Prima
       ↓
Lotes do Fornecedor
       ↓
Fornecedor

Esse modelo pode ser utilizado como base para cenários industriais como controle de qualidade, investigação de não conformidades, recall de produtos e análise do histórico de materiais.

## 🧩 Principais Funcionalidades Pensadas

### Controle de lotes

Cadastro e gerenciamento de lotes de matéria-prima, incluindo:

* Identificação do lote;
* Matéria-prima;
* Fornecedor;
* Código do fornecedor;
* Data de validade;
* Quantidade disponível.

### Controle de validade

O sistema permite verificar se um lote está vencido através do método:

```java
isExpired()
```

Exemplo:

```java
if (batch.isExpired()) {
    // Lote vencido
}
```

### Controle de consumo

A quantidade disponível de um lote pode ser reduzida conforme sua utilização na produção.

```java
batch.consumeQuantity(100);
```

O sistema também impede o consumo de uma quantidade superior ao estoque disponível, evitando que o lote fique com quantidade negativa.

### Rastreabilidade reversa

A principal funcionalidade do projeto é permitir partir de um **produto acabado** e percorrer suas relações de produção até chegar às matérias-primas utilizadas e seus respectivos fornecedores.

Exemplo:

```text
Produto P001
    │
    ├── Lote de Borracha RB-001
    │       └── Fornecedor: Fornecedor A
    │
    ├── Lote de Aditivo AD-025
    │       └── Fornecedor: Fornecedor B
    │
    └── Lote de Enxofre EN-010
            └── Fornecedor: Fornecedor C
```

---

## 🗂️ Modelo Conceitual

O modelo do sistema é baseado no relacionamento entre os principais elementos do processo industrial:

```text
┌──────────────┐
│  Fornecedor  │
└──────┬───────┘
       │
       │ fornece
       ▼
┌──────────────────┐
│ Lote de Material │
└────────┬─────────┘
         │
         │ utilizado na
         ▼
┌──────────────────────┐
│ Processo de Produção │
└──────────┬───────────┘
           │
           │ gera
           ▼
┌──────────────────┐
│ Produto Acabado  │
└──────────────────┘
```

A relação entre essas entidades permite preservar o histórico necessário para realizar a rastreabilidade.

---



## 💻 Tecnologias utilizadas

* **Java**

## 🚀 Possíveis Evoluções

O projeto pode ser expandido para incluir:

* Persistência dos dados em banco de dados;
* API REST;
* Spring Boot;
* Interface web;
* Autenticação de usuários;
* Histórico completo de movimentações;
* Rastreabilidade direta e reversa;
* Controle de estoque;
* Ordens de produção;
* Controle de qualidade;
* Registro de não conformidades;
* Sistema de alertas para lotes próximos do vencimento;
* Relatórios de rastreabilidade;
* Exportação de dados;
* Testes automatizados com JUnit.

---

## 📚 Objetivo Educacional

Este projeto também tem como objetivo aplicar conceitos de **Programação Orientada a Objetos, modelagem de domínio, regras de negócio e desenvolvimento de sistemas** em um problema inspirado em um ambiente industrial real.

A proposta é demonstrar como conceitos de desenvolvimento de software podem ser utilizados para solucionar problemas relacionados à **rastreabilidade e controle de materiais na indústria**.

---

## 👨‍💻 Autor

**Pedro de Oliveira**

Projeto desenvolvido para fins de estudo, portfólio e prática de desenvolvimento de sistemas em Java.
