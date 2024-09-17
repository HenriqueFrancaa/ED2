package TADQueue;

public class Queue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    public boolean isEmpty() {
        if (this.first == null && this.last == null) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public T head() {
        return this.first.getInfo();
    }

    public void enQueue(T value) {
        QueueNode<T> novo;
        novo = new QueueNode(value);
        if (this.isEmpty()) {
            this.first = novo;
            this.last = novo;
        } else {
            this.last.setProx(novo);
            this.last = novo;
        }
    }

    public T deQueue() {
        QueueNode<T> aux = this.first;
        this.first = aux.getProx();

        if (this.first == null) {
            this.last = null;
        }
        return aux.getInfo();
    }

}