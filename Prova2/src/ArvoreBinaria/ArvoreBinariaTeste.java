package ArvoreBinaria;
public class ArvoreBinariaTeste {
    public static void main(String[] args) {

        // Teste se conta os nós da arvore
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no4, no5);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        System.out.println("Folhas: " + arvore.contarFolhas()); // Esperado: 3 (2, 4, 5)
    } 
    }