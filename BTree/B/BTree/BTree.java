package BTree;

import java.util.LinkedList;
import java.util.Queue;

public class BTree<T extends Comparable<T>> {
    private int m;
    private BNode<T> root;

    public BTree() {
        this.m = 5;
        this.root = null;
    }

    public boolean isEmpty() {// funcao para verificar se a arvore está vazia
        return this.root == null;
    }
    // INSERT ZONE
    private void split(BNode<T> pai, int i) { // CISAO
        BNode<T> novo = new BNode<T>(m); // criamos o novo nó
        BNode<T> filho = pai.getFilho(i); // e pegamos o filho, suposto nó cheio

        novo.setFolha(filho.getFolha());  // se o filho for folha, o novo nó tambem será

        for (int j = pai.getN(); j > i; j--) {
            pai.setFilho(j + 1, pai.getFilho(j)); // vamos atualizar os ponteiros para os filhos
        }

        pai.setFilho(i + 1, novo); // adicionamos o novo nó como filho do pai no ponteiro i+1

        for (int j = pai.getN() - 1; j >= i; j--) {
            pai.setInfo(j + 1, pai.getInfo(j)); // atualizamos as posicoes das chaves
        }
        pai.setInfo(i, filho.getInfo(m / 2)); // colocamos o valor do meio de filho e subimos para o pai na pos m/2
        pai.setN(pai.getN() + 1); // pai ganhou mais uma chave
        filho.setN(m / 2); // o tamanho de chaves ativas em filho fica pela metade
        filho.setInfo(m / 2, null); // colocamos a info para null na posicao do valor promovido

        for (int j = 0; j < m / 2; j++) {
            novo.setInfo(j, filho.getInfo(j + m / 2 + 1)); //colocando no novo nó os valores que sao maiores do que a chave promovida
            filho.setInfo(j + m / 2 + 1, null); // atualizamos a info do filho para null
        }

        if (!filho.getFolha()) { // se o nó filho não for folha, precisamos atualizar os ponteiros dos filhos tambem
            for (int j = 0; j < m / 2 + 1; j++) {
                novo.setFilho(j, filho.getFilho(j + m / 2 + 1));
                filho.setFilho(j + m / 2 + 1, null);
            }
        }
        novo.setN(m / 2); //novo no vai ter m/2 chaves ativadas
        novo.setPai(pai); // Colocando o pai do no novo
    }

    private void insertNonFull(BNode<T> x, T k) { //INSERÇÃO NAO CHEIA
        int i = x.getN() - 1; // pegamos a posicao onde a ultima chave esta armazenada
        if (x.getFolha()) { // se for uma folha, vamos ver a melhor posicao do valor K dentro do vetor infos[]
            while (i >= 0 && (k.compareTo(x.getInfo(i)) < 0)) {
                x.setInfo(i + 1, x.getInfo(i)); // vamos adiantando os valores
                i--;
            }
            x.setInfo(i + 1, k); // colocamos o novo valor no nó
            x.setN(x.getN() + 1); // atualizamos a quantidade de chaves ativas do no
            if (x == root && x.getN() == m) { //verificamos se é a raiz e se ela está cheia
                BNode<T> s = new BNode<T>(m); // se estiver cheia, criamos um novo nó 
                s.setFilho(0, x);          // atribuimos ele como a nova raiz
                s.setFolha(false);         // colocamos o filho da nova raiz a raiz antiga
                x.setPai(s);                   // e chamamos o metodo split para fazer a cisao da raiz antiga
                root = s;
                split(s, 0);
            }

        } else {
            // caso não seja uma folha, precisamos saber qual ponteiro devemos pegar para conseguir chegar na chave
            while (i >= 0 && (k.compareTo(x.getInfo(i)) < 0)) {
                i--;
            }
            i++;
            insertNonFull(x.getFilho(i), k); // chamamos insertNonFull mas dessa vez levando o filho do nó usando o ponteiro I

            //depois que voltamos da recursao, temos que ver se o nó encheu, caso sim, vamos realizar a cisao
            if (x.getFilho(i).getN() == m) { // o no encheu
                split(x, i); // fazendo a cisao
                /*
                */
                if (x == root && x.getN() == m) { //verificamos se é a raiz e se ela está cheia
                    BNode<T> s = new BNode<T>(m); // se estiver cheia, criamos um novo nó 
                    s.setFilho(0, x);          // atribuimos ele como a nova raiz
                    s.setFolha(false);         // colocamos o filho da nova raiz a raiz antiga
                    x.setPai(s);                   // e chamamos o metodo split para fazer a cisao da raiz antiga
                    root = s;
                    split(s, 0);
                }
            }
        }
    }

    public void insert(T k) { // INSERCAO
        if (this.isEmpty()) { //verificamos se a arvore está vazia, caso sim, criamos o novo nó e colocamos a primeira chave
            BNode<T> novo = new BNode<T>(m);
            novo.setInfo(0, k);
            novo.setN(novo.getN() + 1);
            this.root = novo;
        } else {
            BNode<T> r = root;
            if (r.getN() == m) {// raiz esta cheia
                BNode<T> s = new BNode<T>(m);
                s.setFilho(0, r);
                s.setFolha(false);
                r.setPai(s);
                root = s;
                split(s, 0);
            }
            insertNonFull(root, k); // chamamos insercao nao cheio;

        }

    }
    // END INSERT ZONE


    //private void propagarConcatenacao(BNode<T> pai) {

    //private void concat(BNode<T>pai, BNode<T>node, BNode<T>irmao,int posIrmao){
        
    //private void redistribuicao()

    
    private void removeLeaf(BNode<T> node, int pos){
        int i = pos;
        while(i < node.getN()){ //atualizando o nó de infos[]
            node.setInfo(i, node.getInfo(i+1));
            i++;
        }
        node.setInfo(node.getN()-1, null); //como perdeu uma chave, atualizamos para null a ultima posicao
        node.setN(node.getN()-1);  // atualizamos a quantidade de chaves ativas

        if(node != root && node.getN() < m/2){ // se o node não for a raiz, temos que ver se ele tem no minimo m/2 chaves ainda
            BNode<T> pai = node.getPai();       // caso não tenha, vamos precisar fazer operações para balancear
            BNode<T> irmao; //
            int posIrmao;
            int posicaoPai = 0;

            //achar a pos do ponteiro no node pai que vai dar para a folha 
            while(posicaoPai <= pai.getN() && pai.getFilho(posicaoPai) != node){
                posicaoPai++;
            }

            if(posicaoPai > 0){ // significa que posso pegar o irmao da esquerda
                irmao = pai.getFilho(posicaoPai-1);
                posIrmao = posicaoPai-1;
            }else if(posicaoPai == 0){ //pego o irmao da direita por não ter irmao da esq
                irmao = pai.getFilho(posicaoPai+1);
                posIrmao = posicaoPai;
                BNode<T> temp = node;
                node = irmao;
                irmao = temp;
            }else return;

            if(irmao.getN() + node.getN() < m-1){ // caso o irmao e node juntos tenham menos de m-1, fazemos concatenação deles dois
                //concat(pai,node,irmao,posIrmao);
            }
            else{ // se nao, fazemos a redistribuicao
                //redistribuicao(pai,node,irmao);
            }
        }

    }

    public void remove(T k){
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
            return;
        }
        
        Retorno aux = search(root, k); // fazemos a busca do valor, que retorna o nó que contem a chave e a posicao dela
        if(aux == null){ // valor não esta na arvore
            System.out.println("O valor não está na árvore!");
            return;
        }
        BNode<T> node = aux.getNode(); //pegamos o node
        int posValue = aux.getPos(); // pegamos a posicao do valor no node
        if(node.getFolha()){ // se o nó for uma folha ent removemos direto
            if(node.getN() == 1 && node == root){
                root = null;
                return;   //se  a raiz só tem 1 elemento, entao a arvore fica vazia
            }
            removeLeaf(node, foundPos(node, k)); // se nao, chamamos removerFolha
            return;
        }

        BNode<T> sucessor = node.getFilho(posValue+1); // se nao for uma folha, temos que procurar o sucessor imediatamente do no a ser removido


        while(!sucessor.getFolha()){
            sucessor = sucessor.getFilho(0); // fazemos a busca
        }

        T valueSucessor = sucessor.getInfo(0); //salvamos o valor
        node.setInfo(posValue, valueSucessor); //substituimos o valor removido no nó pelo valor sucessor
                                                //mas fizemos isso e temos que remover o valor do sucessor no seu proprio nó

        removeLeaf(sucessor, foundPos(sucessor,valueSucessor)); // chamamos removeLEAF para isto

    }

    private int foundPos(BNode<T> node, T k){ //Procuramos a posicao certa do valor neste nó recebido
        int i = 0;
        while(i < node.getN() && k.compareTo(node.getInfo(i)) != 0){
            i++;
        }
        return i;
    }


    private Retorno foundBiggestKey(){// Fazemos a busca do maior valor
        BNode<T> pai = null;
        BNode<T> filho = this.root;
        while (filho != null) {
            pai = filho;
            if (!filho.getFolha()) {
                filho = filho.getFilho(filho.getN());
            } else {
                filho = filho.getFilho(filho.getN() - 1);
            }
        }
        Retorno node = new Retorno(pai.getN() - 1, pai);

        return node;
    }

    private Retorno foundSmallestKey(){ // fazemos a busca do menor valor da arvore
        BNode<T> pai = null;
        BNode<T> filho = this.root;
        while(filho != null){
            pai = filho;
            filho = filho.getFilho(0);
        }
        Retorno node = new Retorno(0, pai);
        return node;
    }

    public void biggestKey(){ // chamando a busca de maior chave
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        else{
            Retorno node = foundBiggestKey();
            System.out.println("Maior valor: " + node.getNode().getInfo(node.getPos()) + " na posição " + node.getPos());
        }
    }

    public void smallestKey(){ // chamando a busca de menor chave
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        else{
            Retorno node = foundSmallestKey();
            System.out.println("Menor valor: " + node.getNode().getInfo(node.getPos()) + " na posição " + node.getPos());

        }
    }
    

    private Retorno search(BNode<T> r,T k){ // fazemos a busca pelo numero de forma recursiva. Retornamos o node e a posicao do valor em infos[]
        int i = 0;
        while (i < r.getN() && (k.compareTo(r.getInfo(i)) > 0)) {
            i++;
        }
        if (i < r.getN() && (k.compareTo(r.getInfo(i)) == 0)) {
            Retorno node = new Retorno(i, r);
            return node;
        } else if (r.getFolha()) {
            return null;
        }
        return search(r.getFilho(i),k);
    }

    public void searchKey(T k){ // chamar o metodo de buscar valor
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        else{
            Retorno node = search(root,k);
            if(node == null){
                System.out.println("Valor não encontrado!");
            }
            else{
                System.out.println("Valor " + node.getNode().getInfo(node.getPos()) + " na posição " + node.getPos());
            }
        }
    }

    public void height(){ // calculo da arvore, todos os nós estao no mesmo nivel
        if(this.isEmpty()){
            System.out.println("Árvore vázia, logo altura = 0");
            return;
        }
        BNode<T>r = root;
        int cont = 0;
        while( !r.getFolha()){
            r = r.getFilho(0);
            cont++;
        }
        System.out.println("Altura da árvore: " + cont);
    }


    private void level(BNode<T> r) { // fazemos o passeio por nivel utilizando uma Queue de auxilio
        
        Queue<BNode<T>> fila = new LinkedList<>();
        fila.add(r); //add a raiz na fila
        fila.add(null); // add null para sabermos que o nivel acabou

        while (!fila.isEmpty()) {
            BNode<T> aux = fila.poll();

            if (aux == null) {
                System.out.println();
                if (!fila.isEmpty()) {
                    fila.add(null); // adicionamos o valor null para sabermos que o nivel acabou
                }
            } else {
                for (int j = 0; j < aux.getN(); j++) {
                    System.out.print(aux.getInfo(j) + " ");
                }
                System.out.print("| ");
                for (int i = 0; i <= aux.getN(); i++) {
                    BNode<T> filho = aux.getFilho(i);
                    if (filho != null) {
                        fila.add(filho);
                    }
                }
            }
        }

    }

    public void levelTour() { // chamamos o metodo de passeio por nivel
        if (this.isEmpty()) {
            System.out.println("Árvore vázia!");
        } else
            level(root);
    }

    private void preOrdem(BNode<T> r){ // realizamos o passeio pre-ordem
        if(r != null){
            for(int i = 0; i < r.getN(); i++){
                System.out.print(r.getInfo(i) + " ");
            }
            System.out.print("| ");
            for(int i = 0; i <= r.getN(); i++){
                preOrdem(r.getFilho(i));
            }
        }
    }

    public void preOrdemTour(){ // chamamos o passeio preOrdem
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        else preOrdem(root);
        System.out.println();
    }

    private void ordemTour(BNode<T> r){ // fazemos o passeio em ordem
        if(r != null){
            if(r.getFilho(0) != null){ // chamamos o em ordem para o primeiro filho
                ordemTour(r.getFilho(0));
            }
            System.out.print(r.getInfo(0));
            for(int i = 1; i < r.getN();i++){ // depois printamos os outros filhos
                System.out.print(" " + r.getInfo(i));
            }
            System.out.print(" | ");
            for(int i = 1; i <= r.getN(); i++){
                if(r.getFilho(i) != null){ // chamamos o em ordem para os demais filhos do no
                    ordemTour(r.getFilho(i));
                }
            }
        }
    }

    public void ordem(){ //chamamos o passeio preOrdem
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        else{
            ordemTour(root);
            System.out.println();
        }
    }
}
