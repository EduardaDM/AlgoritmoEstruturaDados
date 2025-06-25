package Fila;

import Fila.ExeptionsPersonalizadas.FilaCheiaException;
import Fila.ExeptionsPersonalizadas.FilaVaziaException;

public class FilaVetor<T> {

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.info = new Object[limite]; // ⚠️ Inicialização correta
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }
        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return (T) info[inicio];
    }

    public T retirar() {
        T valor = peek();
        inicio = (inicio + 1) % limite;
        tamanho--; // ✅ Corrigido: diminuir o tamanho corretamente
        return valor;
    }

    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public FilaVetor<T> criarFilaConcatenada(FilaVetor f2) {
        FilaVetor<T> f3 = new FilaVetor<T>(this.tamanho + f2.tamanho);

        for (int i = 0; i < this.tamanho; i++) {
            int indice = (this.inicio + i) % this.limite;
            f3.inserir((T) this.info[indice]);
        }

        for (int i = 0; i < f2.tamanho; i++) {
            int indice = (f2.inicio + i) % f2.limite;
            f3.inserir((T) f2.info[indice]);
        }

        return f3;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "[]";
        }

        StringBuilder dados = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % limite;
            dados.append(info[indice]);
            if (i < tamanho - 1) {
                dados.append(", ");
            }
        }
        dados.append("]");
        return dados.toString();
    }

    public int getLimite() {
        return limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    // o método encolher vai trazer todos os elementos para o inicio da fila, para
    // não ficar espaços
    // sobrando "na frente", assim como uma fila de banco, mas neste caso aconteceu
    // de ficar varios
    // espaços em branco, então temos que mandar todas as informações que ficaram no
    // final para a frente
    // por meio da criação de um novo vetor
    public void encolher() {
        // Devido a ser uma Fila, é necessário fazer um vetor com tamanho mínimo para
        // passarmos as informações do anterior para esse
        Object[] info2 = new Object[tamanho];

        // Dentro do for, vamos percorrer o vetor e os elementos da fila atual (com
        // vetor circular)
        // incluindo eles no novo vetor linear,
        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % limite; //neste calculo conseguimos o valor real do vetor circular
            info2[i] = info[indice];
            // Aqui copiamos o valor da posição real do vetor circular para a nova posição do linear.
            // info2 é o novo vetor de fila que está redimensionado, e que começa do índice 0.
        }

        // Depois de conseguir mover os elementos então devemos atualizar os atributos
        // com seus respectivos valores, para poder executar da forma correta
        info = info2; //o vetor  anterior passa a ser o novo
        limite = tamanho; //o limite agora tem um novo valor, sendo o valor do tamanho
        inicio = 0;
    }
}
