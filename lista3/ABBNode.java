class ABBNode {
    private ABBNode esq;
    private Produto info;    
    private ABBNode dir;

    ABBNode(Produto prod) {
        this.info = prod;
    }

    void setEsq(ABBNode novoEsq){
        this.esq = novoEsq;
    }
    ABBNode getEsq(){
        return this.esq;
    }
    void setDir(ABBNode novoDir){
        this.dir = novoDir;
    }

    ABBNode getDir(){
        return this.dir;
    }

    void setInfo(Produto prod){
        this.info = prod;
    }

    /* 
     Produto getInfo(){
        return this.info;
    }
    */
    
}
