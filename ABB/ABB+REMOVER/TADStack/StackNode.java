package TADStack;

class StackNode<T> {
    private T info;
    private StackNode<T> next;

    StackNode(T value){
        this.info = value;
    }
    T getInfo(){
        return this.info;
    }
    void setInfo(T value){
        this.info = value;
    }
    
    StackNode<T> getNext(){
        return this.next;
    }
    void setNext(StackNode<T> novoprox){
        this.next = novoprox;
    }

}
