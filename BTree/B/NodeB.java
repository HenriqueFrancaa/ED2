package B;

class NodeB {

    private int n;
    private Integer[] infos;
    private NodeB[] filhos;
    private boolean folha;

    NodeB(int m){
        this.infos = new Integer[m];
        this.filhos = new NodeB[m];
        this.folha = true;
        this.n = 0;
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
    
    void setInfo(int pos, Integer val){
        this.infos[pos] = val;
    }
    void setFilho(int pos, NodeB filho){
        this.filhos[pos] = filho; 
    }

    boolean getFolha(){
        return this.folha;
    }

    void setFolha(boolean val){
        this.folha = val;
    }

}
