package RedBlackTree;

class RBNode<T extends Comparable<T>>{
    private T info;
    private RBNode<T> left;
    private RBNode<T> right;
    private RBNode<T> pai;
    private int status;
    private char color;

    RBNode(T value){
        this.info = value;
        this.color = 'v';
    }

    void setInfo(T value){
        this.info = value;
    }
    T getInfo(){
        return this.info;
    }
    void setLeft(RBNode<T> novo_esq){
        this.left = novo_esq;
    }
    RBNode<T> getLeft(){
        return this.left;
    }

    void setRight(RBNode<T> novo){
        this.right = novo;
    }
    RBNode<T> getRight(){
        return this.right;
    }

    void setColor(char c){
        this.color = c;
    }
    char getColor(){
        return this.color;
    }
    void setStatus(int s){
        this.status = s;
    }
    int getStatus(){
        return this.status;
    }

    void setInfo(RBNode<T> novo_pai){
        this.pai = novo_pai;
    }
    RBNode<T> getPai(){
        return this.pai;
    }
    void setPai(RBNode<T> novop){
        this.pai = novop;
    }
}