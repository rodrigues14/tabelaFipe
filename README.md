# Tabela Fipe

## Sobre
O projeto **Tabela Fipe** é uma aplicação de linha de comando que permite aos usuários consultar o valor de veículos de acordo com a Tabela Fipe. A Tabela Fipe é uma referência nacional para avaliação de veículos no Brasil.

Aqui estão algumas características principais do projeto:

- **Seleção de Veículo:** Os usuários podem escolher entre Carros, Motos ou Caminhões.
- **Consulta de Marcas e Modelos:** Após selecionar o tipo de veículo, são exibidas todas as opções de marcas disponíveis com seus respectivos códigos. Os usuários podem então selecionar uma marca.
- **Filtragem de Modelos:** Todos os modelos disponíveis da marca selecionada são listados, e os usuários podem filtrar o resultado através de palavras-chave.
- **Consulta de Valores:** Os usuários inserem o código do modelo desejado, e o sistema retorna o valor do veículo para cada ano de acordo com a Tabela Fipe. Isso proporciona uma visão das variações de preço ao longo do tempo.

## Tecnologias Utilizadas
O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java:**
- **Spring Boot:**
- **Linha de Comando:**
- **Jackson:** Biblioteca utilizada para a serialização e desserialização de objetos Java em formato JSON.
- **API da Tabela Fipe:** A aplicação consome dados da API disponibilizada em https://deividfortuna.github.io/fipe/, que fornece informações atualizadas sobre veículos conforme a Tabela Fipe.

## Como Utilizar
Para utilizar a aplicação, siga estas etapas:

1. Clone este repositório para o seu ambiente local.
2. Certifique-se de ter o Java instalado em seu sistema.
3. Navegue até o diretório do projeto e execute a aplicação.
4. Siga as instruções exibidas na linha de comando para selecionar o tipo de veículo, a marca, o modelo e visualizar os valores conforme necessário.

