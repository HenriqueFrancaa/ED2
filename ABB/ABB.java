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

    public ABBNode buscar(Integer value){


    }
}

class ABBNode{ //referencia para um objeto
    private ABBNode esq;
    private Integer info;
    private ABBNode dir;
    /*
     
     */
    ABBNode (Integer value){
        this.info = value;
    }
    Integer getinfo(){
        return this.info;
    }
    void setinfo(Integer value){
        this.info = value;
    }
    ABBNode getEsq(){
        return this.esq;
    }
    void setEsq(ABBNode novoEsq){
        this.esq = novoEsq;
    }
    ABBNode getDir(){
        return this.dir;
    }
    void setDir(ABBNode novoDir){
        this.dir = novoDir;
    }


    
}