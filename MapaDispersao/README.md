## Lista de Exercício 9 

Questão 1 - sobre Mapas de Dispersão com Tratamento de Colisões por Encadeamento Separado.

# Questão 1

> Implemente um mapa de dispersão que utilize tratamento de colisões por endereçamento separado (listas encadeadas), conforme diagrama.

• O construtor MapaDispersao(int) deve criar uma mapa com vetor encapsulado igual ao fornecido como
argumento;
• O método calcularHash(int) deve obter o hash para uma determinada chave de busca. Utilizar a função de resto
de divisão para compactar o valor;
• O método inserir(int, T) deve armazenar o objeto fornecido como argumento no mapa de dispersão,
considerando a chave informada;
• O método remover(int) deve remover do mapa de dispersão o objeto que possui a mesma chave de busca do
objeto fornecido como argumento.
• O método buscar(int) deve procurar no mapa de dispersão um objeto que possua chave de busca igual à
fornecido como argumento. Como resultado do seu processamento, o método deve retornar o objeto localizado.

## Explicando o Código

> Classes implementadas:

NoMapa<T>: representa um par chave/valor.

MapaDispersao<T>: estrutura de hash com vetor de listas (LinkedList[]), contendo:

inserir(int chave, T dado)

remover(int chave)

buscar(int chave)

calcularHash(int chave)

Construtor que recebe o tamanho da tabela

>  Funcionamento:

O calcularHash() usa o resto da divisão (%) da chave pelo tamanho do vetor, como hashing básico.

O vetor usa listas encadeadas (LinkedList) para tratar colisões.

A chave é usada como identificador único (via equals() em NoMapa).
