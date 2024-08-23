package TADStack;

class StackNode <T>{
    private T info;
    private StackNode<T> prox;

    StackNode(T value){
        this.info = value;
    }
    void setinfo(T value){
        this.info = value;
    }
    T getinfo(){
        return this.info;
    }
    void setprox(StackNode<T> novoprox){
        this.prox = novoprox;
    }
    StackNode<T> getprox(){
        return this.prox;
    }

}