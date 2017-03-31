**Como Executar o Projeto com Gradle**

**Linha de comando:** ./gradlew bootRun


**Como Executar os Testes Unitários**

**Linha de Comando:** ./gradlew test

**IDE's Recomendadas**

- Eclipse
- Intellij


Desafio Dasa

O desafio consiste em criar uma API Rest com dados da participação em eventos de prevenção do Câncer de Mama e Câncer de Próstata.

Objetivos Gerais (Entregável):

1. Fornecer uma API com a população geral e a proporção percentual entre homens e mulheres para um determinado ano.
    
    1.1 Retorne o resultado para o ano de 2010. OK
    
    1.2 Retorne o resultado para o ano de 2017 considerando a formula de projeção Geométrica de crescimento. populacional

    As estimativas de crescimento da população são realizadas pelo método geométrico. Em termos técnicos, para se obter a taxa de crescimento (r), subtrai-se 1 da raiz enésima do quociente entre a população final (Pt) e a população no começo do período considerado (P0), sendo "n" igual ao número de anos no período.

    No caso, taxa de crescimento da população entre 2000 e 2010:

Inline image 2

     2. Fornecer uma API onde um usuário possa notificar que participou de uma das campanhas. Importante que na resposta da participação contenha o Sexo, a Campanha e o ano.
     
    2.1 Fornecer uma API com dos dados de participação por Campanha, realizando o filtro por Ano.
    2.2 Fornecer uma API com a proporção de participação entre Homens X Mulheres X Campanha filtrando pelo ano.

Estrutura do Projeto

A estrutura do projeto foi construída sobre o framework Spring Boot, utilizando Spring MVC e Spring Data JPA.

O projeto inicial contém uma entidade que representa o dados populacional de um determinado ano. Esse modelo é representado pela classe DadoPopulacional.

Na inicialização do projeto, é criada uma tabela no H2, com o nome dados_populacionais, e a aplicação popula essa tabela com dos dados contidos no dataset dados_populacionais.csv, localizado em dasa-handson/src/main/resources/