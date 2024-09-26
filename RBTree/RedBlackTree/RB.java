package RedBlackTree;

import TADQueue.Queue;

public class RB<T extends Comparable<T>>{
    private RBNode<T> root;
    private RBNode<T> tnil;

    public RB(){
        tnil = new RBNode<T>(); //nó de null com os atributos de um nó normal, folha da cor PRETA
        root = tnil;
    }


    public boolean isEmpty(){
        if(this.root == tnil){
            return true;
        }
        return false;
    }


    private void leftRotate(RBNode<T> a){
        RBNode<T> b;
        b = a.getRight();
        
        a.setRight(b.getLeft());
        if(b.getLeft() != tnil){
            b.getLeft().setPai(a);
        }
        b.setPai(a.getPai()); // liga o pai de A para B
        if(a.getPai() == tnil){
            this.root = b;
        }
        else if(a == a.getPai().getLeft()){
            a.getPai().setLeft(b);
        }
        else{
            a.getPai().setRight(b);
        }
        b.setLeft(a);
        a.setPai(b);

    }

    private void rightRotate(RBNode<T> a){
        RBNode<T> b;
        b = a.getLeft();
        
        a.setLeft(b.getRight());
        if(b.getRight() != tnil){
            b.getRight().setPai(a);
        }
        b.setPai(a.getPai());
        if(a.getPai() == tnil){
            this.root = b;
        }
        else if(a == a.getPai().getRight()){
            a.getPai().setRight(b);
        }
        else{
            a.getPai().setLeft(b);
        }
        b.setRight(a);
        a.setPai(b);

    }

    private void CorrigeInsert(RBNode<T> k){
        RBNode<T>s; // tio
        RBNode<T>p = k.getPai();
        RBNode<T>g = p.getPai();
        while(p.getColor() == 1){
            
            if(p == g.getLeft()){ // p é o filho a esquerda
                s = g.getRight(); // y é o tio de Z, filho da direita do avô de Z
                if(s.getColor() == 1){ // se o tio for vermelho -> recolorir
                    p.setColor(0);
                    s.setColor(0);
                    g.setColor(1);
                    k = g; // novo k vai ser onde estava o avo;
                    p = k.getPai();
                    g = p.getPai();
                }
                else { // k é o filho da direita, p é filho da esq e k da direita
                    if(k == p.getRight()){
                        k = k.getPai(); //ROTAÇÃO DUPLA
                        leftRotate(k);
                    }
                    p = k.getPai();
                    g = p.getPai();
                    p.setColor(0);
                    g.setColor(1);
                    rightRotate(g);
                }
            }
            else{
                s = g.getLeft(); // s é o filho da esquerda do avô;
                if(s.getColor() == 1){
                    p.setColor(0);
                    s.setColor(0);
                    g.setColor(1);
                    k = g;
                    p = k.getPai();
                    g = p.getPai();
                }
                else{
                    if(k == p.getLeft()){
                        k = k.getPai();
                        rightRotate(k);
                    }
                    
                    p = k.getPai();
                    g = p.getPai();
                    p.setColor(0);
                    g.setColor(1);
                    leftRotate(g);
                }
            }
        }
        this.root.setColor(0);
    }

    public void insert(T value){
        RBNode<T>aux = this.root;
        RBNode<T>p = tnil;
        RBNode<T>k = new RBNode<T>(value);
        while(aux != tnil){
            p = aux;
            if(k.getInfo().compareTo(aux.getInfo()) == 0){ //valor repetido
                System.out.println("Esse valor já está inserido!");
                return;
            }
            if(k.getInfo().compareTo(aux.getInfo()) < 0){ //indo pra esquerda
                aux = aux.getLeft();
            }
            else{
                aux = aux.getRight(); //pegando a direita
            }
        }

        k.setPai(p); //setando o pai do K para o P;
        
        if(p == tnil){ // arvore esta vazia...posso chamar a função isEmpty() mas o livro adota assim
            this.root = k;
        }
        else if(k.getInfo().compareTo(p.getInfo()) < 0){
            p.setLeft(k);
        }
        else{
            p.setRight(k);
        }
        k.setLeft(tnil);
        k.setRight(tnil);
        k.setColor(1); // novo nó começa com vermelho
        CorrigeInsert(k); // corrige qualquer violação das propriedades vermelho-preto
    }

    private void passeioEmOrdem(RBNode<T> r) {
        if (r != tnil) {
            passeioEmOrdem(r.getLeft());
            if(r.getStatus() == 1){

                if(r.getColor() == 1){
                    System.out.print("\u001B[31m" + r.getInfo() + "\u001B[0m" + ' ');
                }
                else{
                    System.out.print("\u001B[30m" + r.getInfo() + "\u001B[0m" + ' ');
                }
            }
            passeioEmOrdem(r.getRight());
        }
    }

    public void emOrdem(){
        if(this.isEmpty() == true){
            System.out.println("Árvore está vázia!");
        }
        else{
            this.passeioEmOrdem(root);
            System.out.println();
        }
    }

    public void porNivel() {
        Queue<RBNode<T>> fila;
        RBNode<T> aux;
        if (this.isEmpty() == false) {
            fila = new Queue<RBNode<T>>();
            fila.enQueue(root);
            while (fila.isEmpty() == false) {
                aux = fila.deQueue();
                if (aux.getLeft() != tnil) {
                    fila.enQueue(aux.getLeft());
                }
                if(aux.getRight() != tnil && aux.getLeft() == tnil){
                    fila.enQueue(tnil);
                }
                if(aux.getRight() != tnil){
                    fila.enQueue(aux.getRight());
                }
                if(aux.getLeft() != tnil && aux.getRight() == tnil){
                    fila.enQueue(tnil);
                }
                if (aux == tnil) {
                    System.out.print("null ");
                } else {
                    System.out.print(aux.getInfo() + " ");
                }
            }
            System.out.println();
        }

    }



    private void removerNode(T value){
        RBNode<T>aux = this.root;
        int result;
        while (aux != tnil) { 
            result = value.compareTo(aux.getInfo());
            if(result == 0){
                if(aux.getStatus() == 1){
                    aux.setStatus(0);
                    System.out.println("Removido!");
                }
                else{
                    System.out.println("Este valor já foi removido!");
                }
                return;
            }
            else if(result < 0){
                aux = aux.getLeft();
            }
            else{
                aux = aux.getRight();
            }
        }
    }

    public void remover(T value){
        if(this.root == tnil){
            System.out.println("Árvore vázia!");
        }
        else{
            removerNode(value);
        }

    }
    

}
