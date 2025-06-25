package Fila.ExeptionsPersonalizadas;

public class FilaVaziaException extends RuntimeException{
    public FilaVaziaException(){
        super("Fila vazia");
    }
}
