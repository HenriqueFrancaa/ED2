package RedBlackTree;
import TADQueue.Queue;


public class RB<T extends Comparable<T>>{
    private RBNode<T> root;
    private RBNode<T> tnil;

    public RB(){
        tnil = new RBNode<T>(); //nó de null com os atributos de um nó normal, folha da cor PRETA
        root = tnil;
    }


    public boolean isEmpty(){
        if(this.root == tnil){ // verificando se a arvore está vazia
            return true;
        }
        return false;
    }


    private void leftRotate(RBNode<T> a){ //ROTAÇÃO SIMPLES PRA ESQUERDA
        RBNode<T> b;
        b = a.getRight(); //filho a direita do nó A
        
        a.setRight(b.getLeft()); //transforma a subárvore à esquerda de B na subárvore à direita de A;

        if(b.getLeft() != tnil){ //verificando se B tem filho da esquerda, 
            b.getLeft().setPai(a); //atualizando o pai do filho à esquerda de B para A;
        }
        b.setPai(a.getPai()); // liga o pai de A para B

        if(a.getPai() == tnil){
            this.root = b; //caso o pai de A seja a raiz, atualizamos a raiz para B;
        }

        else if(a == a.getPai().getLeft()){
            a.getPai().setLeft(b);
        }
        else{
            a.getPai().setRight(b);
        }
        b.setLeft(a);
        a.setPai(b);

    }

    private void rightRotate(RBNode<T> a){
        RBNode<T> b;
        b = a.getLeft();
        
        a.setLeft(b.getRight());
        if(b.getRight() != tnil){
            b.getRight().setPai(a);
        }
        b.setPai(a.getPai());
        if(a.getPai() == tnil){
            this.root = b;
        }
        else if(a == a.getPai().getRight()){
            a.getPai().setRight(b);
        }
        else{
            a.getPai().setLeft(b);
        }
        b.setRight(a);
        a.setPai(b);

    }

    private void CorrigeInsert(RBNode<T> k){
        RBNode<T>s; // tio de K
        RBNode<T>p = k.getPai(); // pai de K
        RBNode<T>g = p.getPai(); // avô de K
        while(p.getColor() == 1){
            
            if(p == g.getLeft()){ // p é o filho a esq
                s = g.getRight(); // y é o tio de Z, filho da dir do avô de Z
                if(s.getColor() == 1){ // se o tio for vermelho -> recolorir
                    p.setColor(0);
                    s.setColor(0);
                    g.setColor(1);
                    k = g; // novo k vai ser onde estava o avo;
                    p = k.getPai();
                    g = p.getPai();
                }
                else { //tio.cor != vermelho -> rotação
                    if(k == p.getRight()){
                        k = k.getPai(); //ROTAÇÃO DUPLA
                                        //como sabemos que P já é filho da esquerda, se K for filho da direita de P
                                        //vamos ter que realizar uma rotação dupla pra dir
                        leftRotate(k); //rotação simples pra esq e depois rotação simples pra dir
                    }
                    //atualizando o P e o G pelo novo K;
                    p = k.getPai(); 
                    g = p.getPai();
                    p.setColor(0);
                    g.setColor(1);
                    rightRotate(g); //ROTAÇÃO SIMPLES PRA DIREITA
                }
            }
            else{
                s = g.getLeft(); // s é o filho da esquerda do avô;
                if(s.getColor() == 1){
                    p.setColor(0);
                    s.setColor(0);
                    g.setColor(1);
                    k = g;
                    p = k.getPai();
                    g = p.getPai();
                }
                else{
                    if(k == p.getLeft()){
                        k = k.getPai();
                        rightRotate(k);
                    }
                    
                    p = k.getPai();
                    g = p.getPai();
                    p.setColor(0);
                    g.setColor(1);
                    leftRotate(g);
                }
            }
        }
        this.root.setColor(0);
    }

    public void insert(T value){
        RBNode<T>aux = this.root;
        RBNode<T>p = tnil;
        RBNode<T>k = new RBNode<T>(value);
        while(aux != tnil){
            p = aux;
            if(k.getInfo().compareTo(aux.getInfo()) == 0){ //valor repetido
                System.out.println("Esse valor já está inserido!");
                return;
            }
            if(k.getInfo().compareTo(aux.getInfo()) < 0){ //indo pra esquerda
                aux = aux.getLeft();
            }
            else{
                aux = aux.getRight(); //pegando a dir
            }
        }

        k.setPai(p); //atualizando o pai do K para P;
        
        if(p == tnil){ // arvore esta vazia...posso chamar a função isEmpty() mas o livro adota assim
            this.root = k;
        }
        else if(k.getInfo().compareTo(p.getInfo()) < 0){ //verificando de qual lado deve ser o filho de P;
            p.setLeft(k);
        }
        else{
            p.setRight(k);
        }
        k.setLeft(tnil); //fazendo o nó inserido apontar para o TNIL(null)
        k.setRight(tnil);
        k.setColor(1); // novo nó começa com vermelho
        CorrigeInsert(k); // corrige qualquer violação das propriedades vermelho-preto
    }

    private void passeioEmOrdem(RBNode<T> r) {
        if (r != tnil) {
            passeioEmOrdem(r.getLeft());
            if(r.getStatus() == 1){

                if(r.getColor() == 1){
                    System.out.print("\u001B[31m" + "[ " + r.getInfo() + " , " + " V ]" + "\u001B[0m" + ' ');
                }
                else{
                    System.out.print("\u001B[30m" + "[ " + r.getInfo() + " , " + "P ]" + "\u001B[0m" + ' ');
                }
            }
            passeioEmOrdem(r.getRight());
        }
    }

    public void emOrdem(){
        if(this.isEmpty() == true){
            System.out.println("Árvore está vázia!");
        }
        else{
            this.passeioEmOrdem(root);
            System.out.println();
        }
    }

    private void passeioPorNivel() {
        Queue<RBNode<T>> fila;
        RBNode<T> aux;
        if (this.isEmpty() == false) {
            fila = new Queue<RBNode<T>>();
            fila.enQueue(root);
            while (fila.isEmpty() == false) {
                aux = fila.deQueue();
                if (aux.getLeft() != tnil) {
                    fila.enQueue(aux.getLeft());
                }
                if(aux.getRight() != tnil && aux.getLeft() == tnil){
                    fila.enQueue(tnil);
                }
                if(aux.getRight() != tnil){
                    fila.enQueue(aux.getRight());
                }
                if(aux.getLeft() != tnil && aux.getRight() == tnil){
                    fila.enQueue(tnil);
                }
                if (aux == tnil) {
                    System.out.print("\u001B[30m" + "[ null , P ] " + "\u001B[0m" + ' ' );
                } else {
                    if (aux.getColor() == 1) {
                        System.out.print("\u001B[31m" + "[ " + aux.getInfo() + " , " + " V ]" + "\u001B[0m" + ' ');
                    }
                    else{
                        System.out.print("\u001B[30m" + "[ " + aux.getInfo() + " , " + "P ]" + "\u001B[0m" + ' ');
                    }
                }
            }
            System.out.println();
        }

    }

    public void porNivel(){
        if(this.isEmpty()){
            System.out.println("Árvore está vazia");
        }
        else{
            this.passeioPorNivel();
        }
    }

    private void removerNode(T value){
        RBNode<T>aux = this.root;
        int result;
        while (aux != tnil) { 
            result = value.compareTo(aux.getInfo());
            if(result == 0){
                if(aux.getStatus() == 1){
                    aux.setStatus(0);
                    System.out.println("Removido!");
                }
                else{
                    System.out.println("Este valor já foi removido!");
                }
                return;
            }
            else if(result < 0){
                aux = aux.getLeft();
            }
            else{
                aux = aux.getRight();
            }
        }
    }

    public void remover(T value){
        if(this.root == tnil){
            System.out.println("Árvore vázia!");
        }
        else{
            removerNode(value);
        }

    }
    

}
