public class Queue{
    private QueueNode first;
    private QueueNode last;
    private int size;

    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        else return false;
    }

    public void Enqueue(ABBNode aux){
        if(this.isEmpty()){
            this.last = new QueueNode(aux);
            this.first = new QueueNode(aux);
        }
        else{
            QueueNode node = new QueueNode(aux);
            if(this.size == 1){
                this.first.setnext(node);
            }
            this.last.setnext(node);
            this.last = node;
        }
    }

    public ABBNode Dequeue(){
        if(this.isEmpty()){
            System.out.println("A fila está vázia");
            return null;
        }
        ABBNode aux = this.first.getinfo();
        if(this.size == 1){
            //this.first.setnext(null);
            this.first = null;
            this.last = null;
        }
        else{
            this.first = this.first.getnext();
        }
        this.size--;
        return aux;
    }

}

class QueueNode{
    private ABBNode info;
    private QueueNode next;
    private int size;

    public QueueNode(ABBNode value) {
        this.info = value;
    }

    ABBNode getinfo(){
        return this.info;
    }
    void setinfo(ABBNode value){
        this.info = value;
    }

    QueueNode getnext(){
        return this.next;
    }

    void setnext(QueueNode value){
        this.next = value;
    }

    int getsize(){
        return this.size;
    }
    
}