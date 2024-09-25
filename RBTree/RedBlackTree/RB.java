package RedBlackTree;

import java.awt.Paint;

public class RB<T extends Comparable<T>>{
    private RBNode<T> root;
    public boolean isEmpty(){
        if(this.root == null){
            return true;
        }
        return false;
    }

    private void CorrigeInsert(RBNode<T> k){

        RBNode<T> p = k.getPai(); //pai de k
        RBNode<T>g; // avô de k
        RBNode<T>s; // tio de k
        while(p.getColor() == 'v'){
            g = p.getPai();
            if(p == g.getLeft()){// pai de K é filho esquerdo
                s = g.getRight();
                if(s.getColor() == 'v'){ // pai e tio de K são vermelhos?
                    p.setColor('p');
                    s.setColor('p');
                    g.setColor('p');
                    k = g;
                }
                else{
                    if(k == p.getRight()){
                        //RotacionaEsquerda(T,P);
                    }
                    p.setColor('p');
                    g.setColor('v');
                    //RotacionaDireita(T,g);
                }
            }
            else{
                s = g.getLeft();
                if(s.getColor() == 'v'){
                    p.setColor('p');
                    s.setColor('p');
                    g.setColor('v');
                    k = g;
                }
                if(k == p.getLeft())
            }                  
                
                
        }


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
