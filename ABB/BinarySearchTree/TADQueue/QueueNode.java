package TADQueue;

public class QueueNode<T> {
    private T info;
    private QueueNode<T> prox;

    QueueNode(T value){
        this.info = value;
    }

    T getInfo(){
        return this.info;
    }
    void setInfo(T value){
        this.info = value;
    }

    QueueNode<T> getProx(){
        return this.prox;
    }
    void setProx(QueueNode<T> novoprox){
        this.prox = novoprox;
    }

}
