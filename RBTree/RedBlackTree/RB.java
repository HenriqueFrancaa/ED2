package RedBlackTree;
import TADQueue.Queue;


public class RB<T extends Comparable<T>>{
    private RBNode<T> root;
    private RBNode<T> tnil;

    public RB(){
        tnil = new RBNode<T>(); //nó de null com os atributos de um nó normal,
                                // folha da cor PRETA
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
        
        a.setRight(b.getLeft()); //transforma a subárvore à esquerda de B
                                // na subárvore à direita de A;

        if(b.getLeft() != tnil){ //verificando se B tem filho da esquerda, 
            b.getLeft().setPai(a); //atualizando o pai do filho à esquerda de B para A;
        }
        b.setPai(a.getPai()); // liga o pai de A para B

        if(a.getPai() == tnil){
            this.root = b; //caso o pai de A seja a raiz, atualizamos a raiz para B;
        }

        else if(a == a.getPai().getLeft()){
            a.getPai().setLeft(b); // atualizando a esq do pai de A para B
        }
        else{
            a.getPai().setRight(b); // atualizando a dir do pai de A para B
        }
        b.setLeft(a); // coloca A à esq de B
        a.setPai(b); //atualiza o pai de A para B;

    }

    private void rightRotate(RBNode<T> a){
        RBNode<T> b;
        b = a.getLeft(); // filho à esq de A
        
        a.setLeft(b.getRight()); //transforma a subárvore à dir de B
                                // na subárvore à esq de A;
        if(b.getRight() != tnil){// verificando se B tem filho da dir
            b.getRight().setPai(a);// atualizando o pai do filho à dir de B para A
        }
        b.setPai(a.getPai()); // liga o pai de A para B

        if(a.getPai() == tnil){
            this.root = b; // B vira a raiz, caso o pai de A seja a raiz
        }
        else if(a == a.getPai().getRight()){
            a.getPai().setRight(b); //atualizando a dir do pai de A para B
        }
        else{
            a.getPai().setLeft(b); // atualizando a esq do pai de A para B
        }

        b.setRight(a); // coloca A à dir de B
        a.setPai(b); // atualizando o pai de A para B

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
                        k = k.getPai(); //R.D.D
                                        //como sabemos que P já é filho da esquerda, se K for 
                                        // filho da direita de P
                                        //vamos ter que realizar uma rotação dupla pra dir
                        leftRotate(k); //R.S.E e depois R.S.D
                    }
                    //atualizando o P e o G pelo novo K;
                    p = k.getPai(); 
                    g = p.getPai();
                    p.setColor(0); // p fica preto
                    g.setColor(1);// g fica vermelho
                    rightRotate(g); //R.S.D
                }
            }
            else{
                s = g.getLeft(); // S é o filho da esquerda do avô;
                if(s.getColor() == 1){ //S é Vermelho -> RECOLORIR
                    p.setColor(0);  //P vira Preto
                    s.setColor(0);  //S vira Preto
                    g.setColor(1); //G vira Vermelho
                    k = g; // novo K
                    p = k.getPai(); //novo P
                    g = p.getPai(); // novo G
                }
                else{
                    if(k == p.getLeft()){ //P é filho da dir e se K for filho da esq de P
                        k = k.getPai();  //fazer uma R.D.E
                        rightRotate(k);  //fazendo um R.S.D e depois uma R.S.E
                    }
                    //atualizando o novo p e G pelo novo K;
                    p = k.getPai();
                    g = p.getPai();
                    p.setColor(0);
                    g.setColor(1);
                    leftRotate(g); //R.S.E
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

    private void passeioEmOrdem(RBNode<T> r) { //passeio em Ordem de forma recursiva
        if (r != tnil) {
            passeioEmOrdem(r.getLeft());

            if(r.getStatus() == 1){ // verificando se o nó está ativado

                if(r.getColor() == 1){ //verificando se o nó é vermelho
                    System.out.print("\u001B[31m" + "[ " + r.getInfo() + " , " + " V ]" + "\u001B[0m" + ' ');
                }
                else{ // nó é preto
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
        //Vamos utilizar a Queue para auxiliar no passeioPorNivel, modificando somente quando o nó só tiver um filho, 
        //irá imprimir null no filho que estiver faltando!
        if (this.isEmpty() == false) {
            fila = new Queue<RBNode<T>>();
            fila.enQueue(root); //colocamos na fila a raiz;
            while (fila.isEmpty() == false) {
                aux = fila.deQueue();
                if (aux.getLeft() != tnil) {
                    fila.enQueue(aux.getLeft()); // adicionamos o nó da esquerda na fila
                }
                if(aux.getRight() != tnil && aux.getLeft() == tnil){
                    fila.enQueue(tnil); //caso nó tenha filho da dir mas não o da esq, adicionamos na fila tnil
                                        // para conseguirmos fazer a impressao do null
                }
                if(aux.getRight() != tnil){ 
                    fila.enQueue(aux.getRight()); // adicionamos o nó da direita na fila
                }
                if(aux.getLeft() != tnil && aux.getRight() == tnil){
                    fila.enQueue(tnil);//caso o nó tenha o filho da esq mas não o da dir
                                        // adicionamos o tnil na fila
                }
                if (aux == tnil) {
                    System.out.print("\u001B[30m"+"[ null , P ] " + "\u001B[0m"); //se o nó for tnil, imprimos null
                } else {
                    if (aux.getColor() == 1) {
                        System.out.print("\u001B[31m" + "[ " + aux.getInfo() + " , " + " V ]" + "\u001B[0m" + ' ');//impressao do info e da cor
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
            this.passeioPorNivel(); //chama metodo de passeio Por Nivel
        }
    }

    private void removerNodePreguicoso(T value){ // método de remoção preguiçosa
        RBNode<T>aux = this.root;
        int result; 
        while (aux != tnil) {  // fazendo a procura do nó que vai ser removido, mas só vamos alterar o status dele para 0;
                                // dizendo que o nó vai estar inativo
            result = value.compareTo(aux.getInfo());
            if(result == 0){ 
                if(aux.getStatus() == 1){
                    aux.setStatus(0); // mudando status para inativo
                    System.out.println("Removido!");
                    
                }
                else{
                    System.out.println("Este valor já foi removido!");  // caso o nó já esteja inativo
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
        if(aux == tnil){
            System.out.println("Nó não encontrado");
        }
    }

    public void remover(T value){
        if(this.root == tnil){ 
            System.out.println("Árvore vázia!");
        }
        else{
            removerNodePreguicoso(value); //chama metodo de remoção preguiçosa
        }

    }
    

}
