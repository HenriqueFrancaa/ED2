
public class BTree{
    private NodeB root;
    private int m = 5;

    private boolean isEmpty(){
       return root == null;
    }

    private void split(NodeB x, int i){
        NodeB z = new NodeB(m);
        NodeB y = x.getFilho(i);
        z.setFolha(y.getFolha());

        for(int j = 0; j < (m/2); j++){ //passando as maiores chaves para Z
            z.setInfo(j, y.getInfo(j+(m/2)));
        }
        if(!y.getFolha()){
            for(int j = 0; j < (m/2); j++ ){
                z.setFilho(j, y.getFilho(j+(m/2)));
            }
        }
        y.setN(m/2);

        for(int j = x.getN()+1; j >= i+1; j--){ //achar a posicao do ponteiro certo
            x.setFilho(j+1, x.getFilho(j));
        }

        x.setFilho(i+1, z);

        for(int j = x.getN(); j >= i; j--){
            x.setInfo(j+1, x.getInfo(j));
        }

        x.setInfo(i, y.getInfo((m/2)-1));
        x.setN(x.getN()+1);

    }

    private void insertNonFull(NodeB x, int k){
        
        int i = x.getN();
        if(x.getFolha()){
            while(i >= 0 && k < x.getInfo(i)){
                x.setInfo(i+1, x.getInfo(i));
                i--;
            }
            x.setInfo(i+1, k);
            x.setN(x.getN()+1);
        }
        else{
            while(i >= 0 && (k < x.getInfo(i) || x.getInfo(i) == 0)){
                i--;
            }
            if(x.getFilho(i).getN() == m-1){
                split(x,i);
                if(k > x.getInfo(i)){
                    i++;
                }
            }
            insertNonFull(x.getFilho(i), k);
        }
    }


    public void insert(int k){
        
        if(this.isEmpty()){
            NodeB novo = new NodeB(m);
            novo.setInfo(0, k);
            novo.setN(novo.getN()+1);
            this.root = novo;
        }
        else{

            NodeB r = root;
            
            if(r.getN() == this.m - 1){ // raiz está cheia
                NodeB s = new NodeB(m);
                this.root = s;
                s.setFolha(false);
                s.setFilho(0, r);
                split(s,0);
                insertNonFull(s,k);
            }
            else  insertNonFull(r,k);
        }
    }

    private Retorno searchNode(NodeB x, int k){
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
        return searchNode(x.getFilho(i), k);
    }
    
    public void search(int k){
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        /*
        * 
        */
        else{
            Retorno node = searchNode(root,k);
            if(node == null){
                System.out.println("Valor não encontrado!");
            }
            else{
                System.out.println("Valor encontrado!");
            }
        }
    }

    private Retorno procuraMaior(){
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
            Retorno node = procuraMaior();
            System.out.println("Maior valor " + node.getNode().getInfo(node.getPos()));
        }
    }


}