package BTree;

public class BTree<T extends Comparable<T>> {
    private int m;
    private BNode<T> root;

    BTree(){
        this.m = 5;
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    


    public void insert(T k){
        if(this.isEmpty()){
            BNode<T> novo = new BNode<T>(m);
            novo.setInfo(0, k);
            novo.setN(novo.getN()+1);
            this.root = novo;
        }
        else{
            BNode<T> aux = root;
            int i = 0;
            while(true){
                if(k.compareTo(aux.getInfo(i)) < 0){

                }
                else if(k.compareTo(aux.getInfo(i)) == 0){
                    System.out.println("Valor repetido!");
                }
            }
        }

    }

    
}
