# java-streams

Exemplos simples utilizando java list normal e list streams

Java Streams é uma API inicialmente introduzida no Java 8 e vem tendo atualizações interessantes para melhorar seu uso.
Java Streams tem como principio fazer a manipulação de `Collections` de forma mais simples juntamente alinhada com uma programação mais funcional
utilizando as `functions lambda`.

**Lembrete**: Se você não sabe como fazer com `for normal` talvez streams não seja para você, então cuidado
ao utilizar essa API poderosa;

> Com grandes poderes vem grandes responsabilidade ~ Ben Parker

Mais sobre: https://www.devmedia.com.br/java-streams-api-manipulando-colecoes-de-forma-eficiente/37630


#### Você encontra exemplos em: [Main.java](https://github.com/DeividFrancis/java-streams/blob/main/src/com/github/deividfrancis/Main.java)


### Para treinar sobre faça a seguinte atividade:

1. Faça um `fork` desse projeto;
1. Crie uma classe `Produto` com os seguintes atributos (`id`, `nome`, `valor`, `categoria`, `temEstoque`);
3. _Na classe que for fazer a atividade cria uma list com no min 10 Produtos_

| Número     | Id  | Nome                     | Valor     | Estoque | Categoria    |
| :--------- | :-: | :----------------------- | :-------- | :-----: | :----------- |
| Produto 1  | 744 | Redragon Kumara          | R$243,35  |   SIM   | Tecnologia   |
| Produto 2  | 850 | Redragon Cobra           | R$190,20  |   SIM   | Tecnologia   |
| Produto 3  | 022 | SSD M.2                  | R$102,02  |   SIM   | Tecnologia   |
| Produto 4  | 848 | Monitor 24p 165hz        | R$1153,00 |   NAO   | Tecnologia   |
| Produto 5  | 254 | Oculos de ciclismo       | R$104,02  |   SIM   | Esporte      |
| Produto 6  | 078 | Molinete de pesca        | R$175,00  |   NAO   | Esporte      |
| Produto 7  | 415 | Tenis allstar            | R$167,00  |   SIM   | Vestuario    |
| Produto 8  | 403 | Luva de motociclista     | R$134,00  |   NAO   | Vestuario    |
| Produto 9  | 625 | chave de fenda magnética | R$55,00   |   SIM   | Equipamentos |
| Produto 10 | 573 | Tapete Geometrico        | R$114,00  |   SIM   | Lazer        |

5. Crie uma classe `Carrinho` com o metodo `main` para rodar os seguintes objetivos;

- 1. Crie uma lista somente com os produtos da categoria `Tecnologia`;
- 2. Crie uma lista contendo todos os produtos com estoque e com valor maior de 200 reais;
- 3. Crie uma lista somente com os nomes dos produto com estoque;
- 4. Faz a soma de todos os produtos da categoria `Esporte`;
- 5. Busca o primeiro produto da categoria `Equipamentos`;
- 6. Ordera a lista de produto por ordem alfabetica;
- 7. Agrupa todos produtos por categoria;
- 8. Mostra a categoria onde com os produtos mais caro;
- 9. Crie uma lista que contem somente os ids: `850`, `403`, `625`;
