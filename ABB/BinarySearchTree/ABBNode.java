package BinarySearchTree;


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