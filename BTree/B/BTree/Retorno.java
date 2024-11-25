package BTree;

class Retorno<T extends Comparable<T>> {
    private int pos;
    private BNode<T> node;

    Retorno(int pos, BNode<T> node){
        this.pos = pos;
        this.node = node;
    }
    
    BNode<T> getNode(){
        return this.node;
    }
    void setNode(BNode<T>node){
        this.node = node;
    }

    int getPos(){
        return this.pos;
    }
    void setPos(int pos){
        this.pos = pos;
    }
}
