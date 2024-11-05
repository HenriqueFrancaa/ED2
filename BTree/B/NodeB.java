package B;

class NodeB {

    private int n;
    private int[] infos;
    private NodeB[]filhos;

    NodeB(int m){
        this.infos = new int[m];
        this.filhos = new NodeB[m];
    }

    int getN(){
        return this.n;
    }

    void setN(int n){
        this.n = n;
    }

    int getInfo(int pos){
        return this.infos[pos];
    }
    NodeB getFilho(int pos){
        return this.filhos[pos];
    }
    
    void setInfo(int pos, int val){
        this.infos[pos] = val;
    }
    void setFilho(int pos, NodeB filho){
        this.filhos[pos] = filho; 
    }

}
