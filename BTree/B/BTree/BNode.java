package BTree;

class BNode<T extends Comparable<T>> {
    private BNode<T> pai; // pai
    private T[] infos; // chaves
    private BNode<T>[] filhos; // filhos
    private boolean folha; // folha
    private int n;

    BNode(int m) {
        this.pai = null;
        this.infos = (T[]) new Comparable[m];
        this.filhos = new BNode[m+1];
        this.folha = true;
        this.n = 0;
    }

    void setPai(BNode<T> pai) {
        this.pai = pai;
    }

    BNode<T> getPai() {
        return this.pai;
    }

    void setInfo(int pos, T k) {
        this.infos[pos] = k;
    }

    T getInfo(int pos) {
        return this.infos[pos];
    }

    void setFilho(int pos, BNode<T> filho) {
        this.filhos[pos] = filho;
    }

    BNode<T> getFilho(int pos) {
        return this.filhos[pos];
    }

    void setFolha(boolean val) {
        this.folha = val;
    }

    boolean getFolha() {
        return this.folha;
    }

    void setN(int n) {
        this.n = n;
    }

    int getN() {
        return this.n;
    }

}
