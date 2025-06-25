package Fila;

public class TesteEncolher {
    public static void main(String[] args) {
        FilaVetor<String> fila = new FilaVetor<>(10);

        // Enfileira 4 elementos
        fila.inserir("A");
        fila.inserir("B");
        fila.inserir("C");
        fila.inserir("D");

        // Remove dois (simula uso circular)
        fila.retirar(); // remove A
        fila.retirar(); // remove B

        // Enfileira mais dois para testar circularidade
        fila.inserir("E");
        fila.inserir("F");

        System.out.println("Antes de encolher:");
        System.out.println("Fila: " + fila);
        System.out.println("Tamanho: " + fila.getTamanho());
        System.out.println("Limite: " + fila.getLimite());

        fila.encolher();

        System.out.println("\nDepois de encolher:");
        System.out.println("Fila: " + fila);
        System.out.println("Tamanho: " + fila.getTamanho());
        System.out.println("Limite: " + fila.getLimite());
    }
}
