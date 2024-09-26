package RedBlackTree;

import java.time.Year;

public class RB<T extends Comparable<T>>{
    private RBNode<T> root;
    private RBNode<T> tnil;

    public RB(){
        tnil = new RBNode<T>();
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
            p = k.getPai();
            g = p.getPai();
            if(p == g.getLeft()){ // p é o filho a esquerda
                s = g.getRight(); // y é o tio de Z, filho da direita do avô de Z
                if(s.getColor() == 1){ // se o tio for vermelho -> recolorir
                    p.setColor(0);
                    s.setColor(0);
                    g.setColor(1);
                    k = g; // novo k vai ser onde estava o avo;
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
        RBNode<T>x = this.root;
        RBNode<T>y = tnil;
        RBNode<T>z = new RBNode<T>(value);
        while(x != tnil){
            y = x;
            if(z.getInfo().compareTo(x.getInfo()) < 0){
                x = x.getLeft();
            }
            else{
                x = x.getRight();
            }
        }
        z.setPai(y);
        if(y == tnil){ // arvore esta vazia...posso chamar a função isEmpty() mas o livro adota assim
            this.root = z;
        }
        else if(z.getInfo().compareTo(y.getInfo()) < 0){
            y.setLeft(z);
        }
        else{
            y.setRight(z);
        }
        z.setLeft(tnil);
        z.setRight(tnil);
        z.setColor(1); // novo nó começa com vermelho
        CorrigeInsert(z); // corrige qualquer violação das propriedades vermelho-preto
    }

    private void passeioEmOrdem(RBNode<T> r) {
        if (r != tnil) {
            passeioEmOrdem(r.getLeft());
            if(r.getColor() == 1){
                System.out.print("\u001B[31m" + r.getInfo() + "\u001B[0m" + ' ');
            }
            else{
                System.out.print("\u001B[30m" + r.getInfo() + "\u001B[0m" + ' ');
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

}
