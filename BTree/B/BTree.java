package  B;


public class BTree{
    private NodeB root;
    private int m = 5;

    private boolean isEmpty(){
       return root == null;
    }

    private Retorno SearchNode(NodeB x, int k){
        int i = 0;
        while(i < x.getN() && k > x.getInfo(i)){
            i++;
        }
        if(i < x.getN() && k == x.getInfo(i)){
            Retorno node = new Retorno(i, x);
            return node;
        }
        else if (x.getFolha()){
            return null;
        }
        return SearchNode(x.getFilho(i), k);
    }
    
    public void Search(int k){
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        /*
        * 
        */
        else{
            Retorno node = SearchNode(root,k);
            if(node == null){
                System.out.println("Valor não encontrado!");
            }
            else{
                System.out.println("Valor encontrado!");
            }
        }
    }

    private Retorno ProcuraMaior(){
        NodeB pai = null;
        NodeB filho = this.root;

        while( filho != null ){
            pai = filho;
            if(!filho.getFolha()){
                filho = filho.getFilho(filho.getN());
            }
            else{
                filho = filho.getFilho(filho.getN()-1);
            }
        }
        Retorno node = new Retorno(pai.getN()-1,pai);
        
        return node;
    }

    public void acharMaior(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        else{
            Retorno node = ProcuraMaior();
            System.out.println("Maior valor ");
        }
    }


}