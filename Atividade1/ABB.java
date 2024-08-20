public class ABB{
    private ABBNode raiz;

    public boolean isEmpty(){
        if(this.raiz == null){
            return true;
        }
        return false;
    }

    public void insert(Integer value){
        ABBNode novo,aux;
        novo = new ABBNode(value);
        int result;
        if(this.isEmpty() == true){
            this.raiz = novo;
        }
        else{
            aux = this.raiz;
            //looping
            while(true){
                result = value.compareTo(aux.getinfo());
                if(result == 0){
                    System.out.println("Valor repetido");
                    return;
                }
                else if(result < 0){
                    if(aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    else{
                        aux.setEsq(novo);
                        System.out.println("Inserção efetuada");
                        return;
                    }
                }
                else{
                    if(aux.getDir() != null){
                        aux = aux.getDir();
                    }
                    else{
                        aux.setDir(novo);
                        System.out.println("Inserção efetuada");
                        return;
                    }
                    
                }
            }
        }
    }

    public void insert2(Integer value){ //QUESTAO 3 da lista
        ABBNode aux,novo,aux2; // aux2 -> aponta para o pai e o aux -> para o filho
        novo = new ABBNode(value);
        int result;
        aux = aux2 = this.raiz;
        if(this.raiz == null){
            this.raiz = novo;
        }
        else{
            while(true){
                result = value.compareTo(aux.getinfo());
                if(result == 0){
                    System.out.println("Valor repetido!");
                }
                else if(result < 0){
                    aux2 = aux;
                    if(aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    else{
                        aux.setEsq(novo);
                        return;    
                    }
                }
                else{
                    aux2 = aux;
                    if(aux.getDir() != null){
                        aux.getDir();
                    }
                    else{
                        aux.setDir(novo);
                        return;
                    }
                }
            }
        }

    }


    private ABBNode buscar(Integer value){ //QUESTÃO 1 DA LISTA
        ABBNode aux;
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

    public void search(Integer value){ //QUESTÃO 2 da lista;
        ABBNode node = buscar(value);
        if(node == null){
            System.out.println("Valor não encontrado!");
        }
        else{
            System.out.println("Valor encontrado!");
        }
    }

    private ABBNode menorValor(){ // QUESTÃO 4 letra a) da lista 
        //preciso passar algo como parametro para essa função?? e para achar o maior também?
        ABBNode aux;
        aux = this.raiz;
        if(aux == null){
            System.out.println("A árvore está vázia!");
            return null;
        }
        else{
            while(true){
                if(aux.getEsq() != null){
                    aux = aux.getEsq();
                }
                else{
                    return aux;
                }
            }
        }
    }

    private ABBNode maiorValor(){ //QUESTÃO 4 letra b) da lista
        ABBNode aux;
        aux = this.raiz;
        if(aux == null){
            System.out.println("A árvore está vázia!");
            return null;
        }
        else{
            while(true){
                if(aux.getDir() != null){
                    aux = aux.getDir();
                }
                else{
                    return aux;
                }
            }
        }
    }

    public void buscaMenorValor(){//QUESTÃO 4 letra c) da lista
        ABBNode node;
        node = menorValor();
        if(node == null){
            System.out.println("A árvore está vázia!");
        }
        else{
            System.out.println("o menor valor encontrado foi " + node.getinfo());
        }
    }

    public void buscarMaiorValor(){// QUESTÃO 4 letra d) da lista
        ABBNode node;
        node = maiorValor();
        if(node == null){
            System.out.println("A árvore está vázia!");
        }
        else{
            System.out.println("O maior valor encontrado foi " + node.getinfo());
        }
    }

    

}

