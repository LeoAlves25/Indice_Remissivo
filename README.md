# Indice_Remissivo
 
Programa capaz de produzir um índice remissivo. O programa lê um
número arbitrário de palavras-chave que deverão constituir o índice remissivo,
seguido da leitura de um texto de tamanho arbitrário, que deverá ser esquadrinhado
à procura de palavras que pertençam ao índice remissivo.
Para resolver esse problema, foi utilizado duas estruturas de dados
distintas: árvore binária de busca (ABB) e tabela de dispersão (Hash).
Observe que, apesar de o Hash ser mais eficiente do que a ABB, existe uma
desvantagem na sua utilização: após atualizado todo o índice remissivo, é
necessário imprimir suas palavras em ordem alfabética. Isso é imediato em árvores
de busca, mas, quando se usa hashing, isso é problemático, sendo necessário
ordenar a tabela de dispersão que contém o índice remissivo.
