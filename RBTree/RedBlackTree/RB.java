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

    private void CorrigeInsert(RBNode<T> z){

        while(z.getPai().getColor() == 1){
            
        }
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
