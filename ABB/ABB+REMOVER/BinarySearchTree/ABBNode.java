package BinarySearchTree;


class ABBNode<T extends Comparable<T>> {
    private ABBNode<T> left;
    private ABBNode<T> right;
    T info;

    ABBNode(T value){
        this.info = value;
    }

    void setInfo(T value){
        this.info = value;
    }
    T getInfo(){
        return this.info;
    }

    void setLeft(ABBNode<T> novo){
        this.left = novo;
    }

    ABBNode<T> getLeft(){
        return this.left;
    }

    void setRight(ABBNode<T> novo){
        this.right = novo;
    }

    ABBNode<T> getRight(){
        return this.right;
    }
    
}
