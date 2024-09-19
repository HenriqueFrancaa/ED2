package TADStack;

public class Stack<T> {
    private StackNode<T> topo;
    public boolean isEmpty(){
        if(this.topo == null){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        return false;
    }

    public T top(){
        return this.topo.getInfo();
    }

    public void Push(T value){
        StackNode<T> novo = new StackNode<T>(value);
        novo.setProx(this.topo);
        this.topo = novo;
    }
    public T Pop(){
        StackNode<T> aux = this.topo;
        this.topo = this.topo.getProx();
        return aux.getInfo();
    }


}
