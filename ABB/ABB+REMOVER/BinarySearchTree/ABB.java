package BinarySearchTree;


public class ABB<T extends Comparable <T>> {
    private ABBNode<T> root;

    public boolean isEmpty(){
        if(this.root == null)return true;
        return false;
    }

    public void insert(T value){

        ABBNode<T>novo = new ABBNode<T>(value);

        if(this.isEmpty()){
            this.root = novo;
        }
        else{
            int result;
            ABBNode<T> aux = this.root;
            while(true){
                result = value.compareTo(aux.getInfo());
                if(result < 0){
                    if(aux.getLeft() != null){
                        aux = aux.getLeft();
                    }
                    else{
                        aux.setLeft(novo);
                        System.out.println("Inserido");
                        break;
                    }
                }
                else{
                    if(aux.getRight() != null){
                        aux = aux.getRight();
                    }
                    else{
                        aux.setRight(novo);
                        System.out.println("Inserido!");
                        break;
                    }
                }
            }
        }
    }

    private ABBNode<T> buscarNo(T value){
        ABBNode<T> aux = this.root;
        int result;
        while(true){
            result = value.compareTo(aux.getInfo());
            if(result == 0){
                return aux;
            }
            else if(result < 0){
                if(aux.getLeft()!= null){
                    aux = aux.getLeft();
                }
                else{
                    return null;
                }
            }
            else{
                if(aux.getRight() != null){
                    aux = aux.getRight();
                }
                else{
                    return null;
                }
            }
        }

    }

    public void buscar(T value){
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        ABBNode<T> retorno = this.buscarNo(value);

    }

    public void remover(T value){
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            ABBNode<T>pai,filho;
            int result;
            pai = this.root; filho = pai;
            while(true){
                result = value.compareTo(filho.getInfo());
                if(result == 0){
                    if(filho.getRight() == null && filho.getLeft() == null){ // estamos removendo um nó folha
                        //filho = null; ou pai.setRight(null) ou pai.setLeft(null);
                        if(pai == this.root){
                            this.root = null;
                        }

                        else if(pai.getRight() == filho){
                            pai.setRight(null);
                        }
                        else{
                            pai.setLeft(null);
                        }
                        
                    }
                    else if(filho.getRight() == null){ // tem o filho da esquerda;
                        if(pai.getRight() == filho){
                            pai.setRight(filho.getLeft());
                        }
                        else{
                            pai.setLeft(filho.getLeft());
                        }
                        
                    }
                    else if(filho.getLeft() == null){ // tem o filho da direita
                        if(pai.getRight() == filho){
                            pai.setRight(filho.getRight());
                        }
                        else{
                            pai.setLeft(filho.getRight());
                        }
                        
                    }
                    else{ // tem os dois filhos
                        ABBNode<T> aux = filho;
                        pai = filho;
                        filho = filho.getLeft();
                        if(filho.getRight() != null){
                            while(filho.getRight() != null){
                                pai = filho;
                                filho = filho.getRight();
                            }
                            pai.setRight(filho.getLeft());
                            aux.setInfo(filho.getInfo());
                        }
                        else{
                            pai.setLeft(filho.getLeft());
                            aux.setInfo(filho.getInfo());
                        }
                        
                    }
                    return ;

                }
                else if(result < 0){
                    if(filho.getLeft() != null){
                        pai = filho;
                        filho = filho.getLeft();
                    }
                    else{
                        System.out.println("Nó não encontrado para remoção!");
                        return;
                    }
                }
                else{
                    if(filho.getRight() != null){
                        pai = filho;
                        filho = filho.getRight();
                    }
                    else{
                        System.out.println("Nó não encontrado para remoção");
                        return;
                    }

                }
            }
        }
    }

    

    private void passeioEmOrdem(ABBNode<T> r){
        if(r != null){
            passeioEmOrdem(r.getLeft());
            System.out.print( r.getInfo() + " ");
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
