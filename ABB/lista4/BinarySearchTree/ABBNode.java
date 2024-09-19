package BinarySearchTree;


class ABBNode<T extends Comparable<T>>{
    private ABBNode<T> esq;
    private T info;
    private ABBNode<T> dir;

    ABBNode(T value){
        this.info = value;
    }

    void setInfo(T value){
        this.info = value;
    }
    T getinfo(){
        return this.info;
    }

    ABBNode<T> getEsq(){
        return this.esq;
    }
    ABBNode<T> getDir(){
        return this.dir;
    }

    void setEsq(ABBNode<T> novoesq){
        this.esq = novoesq;
    }

    void setDir(ABBNode<T> novodir){
        this.dir = novodir;
    }
    
}
