package BinarySearchTree;

public class ABB<T extends Comparable<T>>{
    private ABBNode<T> raiz;

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
            System.out.println("Inserido!");
        }
        else{
            aux = this.raiz;
            while(true){
                result = value.compareTo(aux.getinfo());
                if(result < 0){
                    if(aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    else{
                        aux.setEsq(novo);
                        System.out.println("Inserido!");
                        return;
                    }
                }
                else{
                    if(aux.getDir() != null){
                        aux = aux.getDir();
                    }
                    else{
                        aux.setDir(novo);
                        System.out.println("Inserido!");
                        return;
                    }
                }
            }
        }
    }

    private ABBNode<T> Search(T value){ //QUESTÃO 1 DA LISTA
        ABBNode<T> aux;
        int result;
        if(this.raiz == null){
            System.out.println("Árvore vazia!");
            return null;
        }
        else{
            aux = this.raiz;
            while(true){
                result = value.compareTo(aux.getinfo());
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
        ABBNode<T> retorno = this.Search(node);
        if(retorno == null){
            return null;
        }
        return retorno.getinfo();
    }

    private void percorrerEmOrdem(ABBNode<T> r){
        if(r != null){
            percorrerEmOrdem(r.getEsq());
            System.out.print(r.getinfo()+ " ");
            percorrerEmOrdem(r.getDir());
        }
    }

    public void emOrdem(){
        if(this.isEmpty()){
            System.out.println("Nada encontrado!");
        }
        else{
            percorrerEmOrdem(this.raiz);
            System.out.println();
        }
    }

    private int alturaNo(ABBNode<T> r){
        int a1,a2;
        if(r == null)return 0;
        if(r.getDir() == null && r.getEsq() == null)return 0;
        else{
            a1 = alturaNo(r.getEsq());
            a2 = alturaNo(r.getDir());
            if(a1 > a2)return a1+1;
            else return a2+1;
        }    
    }

    public void altura(){
        if(this.isEmpty()){
            System.out.println("Árvore de altura 0");
        }
        else{
            System.out.println("Árvore de altura " + this.alturaNo(this.raiz));
        }
    }

    private ABBNode<T> remocao(ABBNode<T> r, T value){
        int result;
        //aux.getinfo() != value || aux != null
        
        while(true){
            result = value.compareTo(r.getinfo());

            if(result == 0){
                if(r.getEsq() == null && r.getDir() == null){
                    r = null;           
                }
                else if(r.getEsq() == null){
                    ABBNode<T>pai,filho;
                    pai = r; filho = pai.getDir();
                    pai.setDir(filho.getEsq());
                    r = r.getDir();
                }
                else if(r.getDir() == null){
                    r = r.getEsq();
                }
                else{
                    ABBNode<T>pai,filho;
                    pai = r; filho = pai.getEsq();
                    if(filho.getDir() != null){
                        while(filho.getDir() != null){
                            pai = filho;
                            filho = filho.getDir();
                        }
                        pai.setDir(filho.getEsq());
                    }
                    else{
                        pai.setEsq(filho.getEsq());
                    }
                    r.setInfo(filho.getinfo());
                }
                System.out.println("Removido!");
                return r;
            }
            else if(result < 0){
                if(r.getEsq() != null){
                    r = r.getEsq();
                }
                else{
                    return null;
                }
            }
            else{
                if(r.getDir() != null){
                    r = r.getDir();
                }
                else{
                    return null;
                }
            }
        }

        }


    public void remover(T value){
        if(this.isEmpty()){
            System.out.println("Nada para ser removido!");
            return;
        }

        //ABBNode<T>rm = this.Search(value);
        ABBNode<T>test;
        test = this.remocao(this.raiz, value);
    }

    private int frequencia(ABBNode<T> node, T value){
        int cont = 0;
        int result;
        while(node != null){
            result = value.compareTo(node.getinfo());
            if(result == 0)cont++;
            if(result < 0){
                node = node.getEsq();
            }
            else{
                node = node.getDir();
            }
        }
        return cont;
    }

    public void contarFrequencia(T value){
        if(this.isEmpty()){
            System.out.println("Árvore vazia!");
        }
        else{
            ABBNode<T> node = this.Search(value);
            if(node == null){
                System.out.println("Valor não encontrado");
            }
            else{
                System.out.println("Frequência de " + frequencia(node,value));
            }
        }
    }

}

