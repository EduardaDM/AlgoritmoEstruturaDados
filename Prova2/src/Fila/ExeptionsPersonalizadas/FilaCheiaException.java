package Fila.ExeptionsPersonalizadas;

public class FilaCheiaException extends RuntimeException {
    public FilaCheiaException(){
        super("Fila está cheia");
    } 
}