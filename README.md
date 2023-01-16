
## Índice
- [Dojo 3](#dojo-3)
    - Exercício 1
    - Exercício 2
    - Exercício 3
- [Dojo 4](#dojo-4)
    - Exercício 1

<br>

## Dojo 3

### [Exercício 1][dojo3-1]

Implemente a classe Aluno, com os atributos “matricula”, “nome”, e “idade”.

Em seguida, escreva um programa que permita que:
- Um usuário crie novos Alunos;
- Liste todos os alunos existentes;
- Exiba todos os atributos de um aluno específico;
- Delete um aluno específico;
- Altere a idade de um aluno específico.

Implemente esse sistema através de um menu de opções numéricas, selecionadas
pelo input do usuário no teclado.

Adicione uma classe Prova no exercício anterior. A Prova tem três atributos
chamados tipo (ex: “Avaliação 1”, “Avaliação 2” e “Prova Final) do tipo enum, nota
do tipo float e conteudoProva que deve ser do tipo ConteudoProva com um atributo
chamado texto do tipo String.

Um Aluno deve ter uma lista (vetor) de avaliações do tipo Prova. O Aluno deve ser
capaz de calcular a sua média e saber se está em prova final.

Seu programa deve interagir com o usuário para informar as notas de todos os
alunos cadastrados. Considerando quem ficou em prova final ou não.

### [Exercício 2][dojo3-2]

Implemente a classe “Album”, que representa um CD, possuindo um título, artista,
quantidade de músicas e lista de músicas*. Para que um novo álbum seja criado,
ele precisa receber todas essas informações necessárias. Além dessas
características, implemente também métodos para:

- Checar se uma música está no álbum;
- Verificar o nome da n-ésima música do álbum;
- Imprimir os dados do álbum (título, artista e lista de músicas);
- Alterar a posição de uma música na lista;

Desafios adicionais:

- Ao invés de uma música ser apenas uma string, transformá-la em uma outra
classe, com características próprias (nome, artista, duração...);
- Implementar métodos para adicionar e remover músicas ao Album.

### [Exercício 3][dojo3-3]

Implemente as classes “Biblioteca”, “Livro”, “Cliente” e
“Aluguel”. Um livro possui título, autor, editora e data de
publicação, um cliente possui nome e CPF, e um Aluguel
representa o evento de um Cliente alugando um Livro.
Uma biblioteca possui livros em sua coleção, que pode ser
de até 1000 livros, e a mesma permite que seus clientes os
aluguem, de acordo com as seguintes regras:

- Um cliente só pode alugar 2 livros por vez;
- Um cliente só pode alugar um livro caso ele não seja
um dos 3 últimos livros que ele alugou;
- A biblioteca só possui 1 exemplar de cada livro em sua
coleção

Além da lista de livros em sua coleção, uma biblioteca também deve manter uma lista
atualizada de seus clientes.

Implemente os métodos cadastrar/remover livro, cadastrar/remover cliente, alugar
livro, devolver livro, e outros que achar necessário para que representar corretamente o
cenário descrito, e sinta-se a vontade pra criar os atributos que você achar necessário.

A sua biblioteca deve ser também capaz de emitir um relatório dos aluguéis realizados
na biblioteca. Para isto deve receber um filtro por data (min. e max.) e livro ou cliente.

No final, tente identificar os relacionamentos existentes no cenário descrito, e
classifique-os com relação a sua cardinalidade.

<br>

## Dojo 4

### Exercício 1
Instruções
Descrição geral: As regras do Bingo são simples, já que quatros princípios básicos, de fácil entendimento, estabelecem as
normas do jogo. São eles:
- Cada jogador pode usar de 1 a 4 cartelas (com 5 linhas e 5 colunas) de 24 números aleatórios de 1 a 75.
- A cada rodada um número é sorteado e o jogador verifica se ele está na sua cartela.
- O jogador completa sua(s) cartela(s) marcando os números sorteados.
- O objetivo é completar linhas, colunas ou a cartela inteira. Vence o jogador que completar a cartela.
Implementação
- Crie as classes Sorteador, Sacola, Jogador, Cartela
- O Sorteador sorteará os números a partir da sacola. Dica: tenha como atributo uma instância do tipo Set para
armazenar as “bolas” (números) do bingo
- A Sacola deve conter 75 números
- Sorteador é quem sorteia as bolas a partir da Sacola.
- Jogador “ouve” os números sorteados pelo Sorteador e marca a pontuação na Cartela
- A Cartela é uma matriz de números (linhas e colunas)
- O Bingo termina quando alguém completar uma cartela. Os jogadores que fizerem linhas e colunas devem ser
registrados também e apresentados ao final
- Também devem ser apresentadas as cartelas finais (preenchidas) de cada jogador
- A cada sorteio o programa deve exibir se alguma cartela continha o número sorteado e também o estado atual das
cartelas dos jogadores
- Utilize a biblioteca no link para imprimir as cartelas como tabela. Baixe o jar e adicione no seu projeto.



[dojo3-1]: <https://github.com/davilimabr/dojos-tp2/tree/main/Dojo3-1>
[dojo3-2]: <https://github.com/davilimabr/dojos-tp2/tree/main/Dojo3-2>
[dojo3-3]: <https://github.com/davilimabr/dojos-tp2/tree/main/Dojo3-3>

