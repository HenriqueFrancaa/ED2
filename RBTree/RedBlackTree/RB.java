package RedBlackTree;

public class RB<T extends Comparable<T>>{
    private RBNode<T> root;
    private RBNode<T> tnil;

    public boolean isEmpty(){
        if(this.root == null){
            return true;
        }
        return false;
    }

    private void leftRotate(RBNode<T> a){
        RBNode<T> b;
        b = a.getRight();
        
        a.setRight(b.getLeft());
        b.getLeft().setPai(a);
        b.setLeft(a);
        b.setPai(a.getPai());
        a.getPai().setLeft(b);
        a.setPai(b);

    }

    private void rightRotate(RBNode<T> a){
        RBNode<T> b;
        b = a.getLeft();
        
        a.setLeft(b.getRight());
        b.getRight().setPai(a);
        b.setRight(a);
        b.setPai(a.getPai());
        a.getPai().setRight(b);
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
                }
                else if(k == p.getRight()){ // k é o filho da direita, p é filho da esq e k da direita
                    k = k.getPai(); //ROTAÇÃO DUPLA
                    //leftRotate(k)
                }
                
            }
            p = k.getPai();
            g = p.getPai();
        }
        this.root.setColor(0);
    }

    public void insert(RBNode<T> z){
        RBNode<T>x = this.root;
        RBNode<T>y = tnil;
        
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

}
