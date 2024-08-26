
class ABB {
    ABBNode raiz;

    public boolean isEmpty(){
        if(this.raiz == null){
            return true;
        }
        return false;
    }

    public void insert(Produto prod){
        ABBNode novo; ABBNode aux;
        novo = new ABBNode(prod);
        int result;
        if(this.isEmpty()){
            this.raiz = novo;
        }
        else{
            aux = this.raiz;
            
        }


    }
    // IMPLEMENTAR BUSCA
    public ABBNode buscar(){
        return null ;
    }

    // IMPLEMENTAR PASSEIOS
}
