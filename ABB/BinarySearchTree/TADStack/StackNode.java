package TADStack;

class StackNode <T> {
    private T info;
    private StackNode<T> prox;

    StackNode(T value) {
        this.info = value;
    }

    T getInfo(){
        return this.info;
    }

    void setInfo(T value){
        this.info = value;
    }

    StackNode<T> getProx(){
        return this.prox;
    }
    
    void setProx(StackNode<T> novoprox){
        this.prox = novoprox;
    }
    

}
