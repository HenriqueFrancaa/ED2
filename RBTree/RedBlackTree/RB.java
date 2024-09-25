package RedBlackTree;

public class RB<T extends Comparable<T>>{
    private RBNode<T> root;
    public boolean isEmpty(){
        if(this.root == null){
            return true;
        }
        return false;
    }

    private void CorrigeInsert(RBNode<T> k){

        RBNode<T> p = k.getPai();
        //RBNode<T> g = p.getPai();


    }

    public void insert(T value){
        RBNode<T> novo = new RBNode<T>(value);
        if(this.isEmpty()){
            novo.setColor('p');
            this.root = novo;
        }
        else{
            RBNode<T> aux = this.root;
            RBNode<T> pai = aux; // pai de aux
            int result;
            while(aux != null){
                pai = aux;
                result = value.compareTo(aux.getInfo());
                if(result < 0){
                    aux = aux.getLeft();
                }
                else if(result > 0){
                    aux = aux.getRight();
                }
                else{
                    System.out.println("Valor repetido!");
                    return;
                }

            }
            novo.setPai(pai); // colocando o pai do novo nó
            if(novo.getInfo().compareTo(pai.getInfo()) < 0){
                pai.setLeft(novo);
            }
            else{
                pai.setRight(novo);
            }
            CorrigeInsert(novo);
        }

    }

}
