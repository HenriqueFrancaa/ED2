
class Retorno {
    
    private int pos;
    private NodeB node;

    Retorno(int pos, NodeB node) {
        this.pos = pos;
        this.node = node;
    }

    int getPos(){
        return this.pos;
    }
    NodeB getNode(){
        return this.node;
    }

    void setPos(int pos){
        this.pos = pos;
    }
    
    void setNode(NodeB node){
        this.node = node;
    }

}
