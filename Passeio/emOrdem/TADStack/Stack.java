package TADStack;

public class Stack <T>{
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
        return this.topo.getinfo();
    }

    public void push(T value){
        StackNode novo = new StackNode<T>(value);
        novo.setprox(this.topo);
        this.topo = novo;
    }

    public T pop(){
        StackNode <T> aux;
        aux = this.topo;
        this.topo = this.topo.getprox();
        return aux.getinfo();
    }
}
