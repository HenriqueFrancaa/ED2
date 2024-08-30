package BinarySearchTree;

public class ABB<T extends Comparable<T>> {
    
    ABBNode<T> raiz;

    public boolean isEmpty(){
        
        if(this.raiz == null){
            return true;
        }
        return false;
    }

    public void insert(T value){
        ABBNode<T> novo,aux;
        int result;
        novo = new ABBNode<T>(value);

        if(this.isEmpty()){
            this.raiz = novo;
            System.out.println("Produto cadastrado com sucesso!");
        }
        else{
            aux = this.raiz;
            while(true){
                result = value.compareTo(aux.getInfo());
                if(result == 0){
                    System.out.println("Este produto já está cadastrado!");
                    return;
                }
                else if(result < 0){
                    if(aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    else{
                        aux.setEsq(novo);
                        System.out.println("Produto cadastrado com sucesso!");
                        return;
                    }
                }
                else{
                    if(aux.getDir() != null){
                        aux = aux.getDir();
                    }
                    else{
                        aux.setDir(novo);
                        System.out.println("Produto cadastrado com sucesso!");
                        return;
                    }
                }
            }
        }

    }

    private ABBNode<T> search(T value){
        ABBNode<T> aux;
        int result;
        if(this.isEmpty() == true){
            System.out.println("Item não encontrado");
            return null;
        }
        else{
            aux = this.raiz;
            while(true){
                result = value.compareTo(aux.getInfo());
                if(result == 0){
                    return aux;
                }
                else if(result < 0){
                    if(aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    else{
                        return null;
                    }
                }
                else{
                    if(aux.getDir() != null){
                        aux = aux.getDir();
                    }
                    else{
                        return null;
                    }
                }
            }
        }
    }

    public T buscar(T node){
        ABBNode<T> retorno = this.search(node);
        if(retorno == null){
            return null;
        }
        return retorno.getInfo();
    }

    private void percorrerEmOrdem(ABBNode<T> r){
        if(r != null){
            percorrerEmOrdem(r.getEsq());
            System.out.println(r.getInfo());
            percorrerEmOrdem(r.getDir());
        }
    }

    public void emOrdem(){
        if(this.isEmpty()){
            System.out.println("Nenhum item encontrado!");
        }
        else{
            percorrerEmOrdem(this.raiz);
        }
    }


    

}
