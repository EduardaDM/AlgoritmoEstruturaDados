package ArvoreBinaria;
/*
 * A partir da lista de exercícios 7, acrescente o seguinte 
 * método na classe ArvoreBinaria:
 * public int contarFolhas(NoArvoreBinaria<T> sa)
 * Este método deverá contar a quantidade de folhas que existem 
 * numa árvore cuja raiz seja sa. Será avaliada a eficiência do código.
 */

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    // ESTA VAZIA
    public boolean estaVazia() {
        return raiz == null;
    }

    // CONTAR NOS
    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    /**
     * o método public ContarFolhas ulitiza de recursividade para realizar sua
     * finção, vai visitar
     * toda a altura da árvore binária até chegar em suas folhas, que são nós que
     * não possuem
     * nenhum flho (na esq e dir), também pode ser considerado aqule que fica no
     * exterior da árvore,
     * quando encontramos algum nó que se encaixa nestes parâmetros, então ele é
     * somado como uma folha
     * 
     * @return
     */
    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(NoArvoreBinaria<T> sa) {
        //nesta condição se sa for nula, significa que a 
        //árvore não existe e não tem raiz ou folhas para serem visitadas/contabilizadas, sendo a resposta
        // 0 folhas
        if (sa == null) return 0;

        //passando para a segunda condição, que se "sa" que é o nó que estamos visitando
        //não ter filhos em sua esquerda E na direita também, então contabiliza +1, e se ele tiver apenas
        //raiz, vai informar ao usuário que é apenas 1 folha existente, que é a própria raiz
        if ((sa.getEsquerda() == null) && (sa.getDireita() == null)) {
            //realizei esta impressão para me certificar de que não estava dando erro e para informar ao usuário quais 
            System.out.println("Folha encontrada: " + sa.getInfo());
            return 1;
        }

        //neste return ele vai trabalhar recursivamente, no caso, ele vai voltar ao método com um novo
        //parametro, agora da direita e da esquerda do nó que estamos visitando, e se encontrar um nó
        //sem direita e esquerda, ele soma um, mas se não acontecer isso significa que este nó tem filhos
        //então ele vai fazer o mesmo processo, e apenas somar um quando o nó que estamos visitando 
        //estar conforme a condição de não ter direita nem esquerda.
        return contarFolhas(sa.getEsquerda()) + contarFolhas(sa.getDireita());

    }

}