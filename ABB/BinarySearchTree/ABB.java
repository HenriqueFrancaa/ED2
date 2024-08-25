package BinarySearchTree;
import TADStack.Stack;
import TADQueue.Queue;

public class ABB{

    private ABBNode raiz;
    private int cont;

    public boolean isEmpty(){
        if(this.raiz == null){
            return true;
        }
        return false;
    }

    public void insert(Integer value){
        ABBNode novo,aux;
        novo = new ABBNode(value);
        int result;
        if(this.isEmpty() == true){
            this.raiz = novo;
        }
        else{
            aux = this.raiz;
            //looping
            while(true){
                result = value.compareTo(aux.getinfo());
                if(result == 0){
                    System.out.println("Valor repetido");
                    return;
                }
                else if(result < 0){
                    if(aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    else{
                        aux.setEsq(novo);
                        System.out.println("Inserção efetuada");
                        return;
                    }
                }
                else{
                    if(aux.getDir() != null){
                        aux = aux.getDir();
                    }
                    else{
                        aux.setDir(novo);
                        System.out.println("Inserção efetuada");
                        return;
                    }
                    
                }
            }
        }
    }
 
    public void insert2(Integer value){ //QUESTAO 3 da lista
        ABBNode aux,novo,aux2; // aux2 -> aponta para o pai e o aux -> para o filho
        novo = new ABBNode(value);
        int result;
        aux = aux2 = this.raiz;
        if(this.raiz == null){
            this.raiz = novo;
        }
        else{
            while(true){
                result = value.compareTo(aux.getinfo());
                if(result == 0){
                    System.out.println("Valor repetido!");
                }
                else if(result < 0){
                    aux2 = aux;
                    if(aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    else{
                        aux.setEsq(novo);
                        return;    
                    }
                }
                else{
                    aux2 = aux;
                    if(aux.getDir() != null){
                        aux.getDir();
                    }
                    else{
                        aux.setDir(novo);
                        return;
                    }
                }
            }
        }

    }

    private ABBNode Buscar(Integer value){ //QUESTÃO 1 DA LISTA
        ABBNode aux;
        int result;
        if(this.raiz == null){
            System.out.println("Árvore vazia!");
            return null;
        }
        else{
            aux = this.raiz;
            while(true){
                result = value.compareTo(aux.getinfo());
                if(result == 0){
                    return aux;
                }
                else if(result < 0){
                    if(aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    else{
                        return null;
                    }
                }
                else{
                    if(aux.getDir() != null){
                        aux = aux.getDir();
                    }
                    else{
                        return null;
                    }
                }
            }
        }

    }

    public void Search(Integer value){ //QUESTÃO 2 da lista;
        ABBNode node = Buscar(value);
        if(node == null){
            System.out.println("Valor não encontrado!");
        }
        else{
            System.out.println("Valor encontrado!");
        }
    }

    private ABBNode MenorValor(){ // QUESTÃO 4 letra a) da lista 
        ABBNode aux;
        aux = this.raiz;
        if(aux == null){
            System.out.println("A árvore está vázia!");
            return null;
        }
        else{
            while(true){
                if(aux.getEsq() != null){
                    aux = aux.getEsq();
                }
                else{
                    return aux;
                }
            }
        }
    }

    private ABBNode MaiorValor(){ //QUESTÃO 4 letra b) da lista
        ABBNode aux;
        aux = this.raiz;
        if(aux == null){
            System.out.println("A árvore está vázia!");
            return null;
        }
        else{
            while(true){
                if(aux.getDir() != null){
                    aux = aux.getDir();
                }
                else{
                    return aux;
                }
            }
        }
    }

    public void buscaMenorValor(){//QUESTÃO 4 letra c) da lista
        ABBNode node;
        node = MenorValor();
        if(node == null){
            System.out.println("A árvore está vázia!");
        }
        else{
            System.out.println("o menor valor encontrado foi " + node.getinfo());
        }
    }

    public void buscarMaiorValor(){// QUESTÃO 4 letra d) da lista
        ABBNode node;
        node = MaiorValor();
        if(node == null){
            System.out.println("A árvore está vázia!");
        }
        else{
            System.out.println("O maior valor encontrado foi " + node.getinfo());
        }
    }


    private void percorrerPorNivel(){// ATIVIDADE 2 Questão 3)
        Queue<ABBNode> fila; 
        ABBNode aux;
        if(this.isEmpty() == false){
            fila = new Queue<ABBNode>();
            fila.enQueue(this.raiz);
            while(!fila.isEmpty()){
                aux = fila.deQueue();
                if(aux.getEsq() != null){
                    fila.enQueue(aux.getEsq());
                }
                if(aux.getDir() != null){
                    fila.enQueue(aux.getDir());
                }
                System.out.print(aux.getinfo() + " ");
            }
            System.out.print("\n");
        }
        else{
            System.out.println("Árvore está vázia");
        }
    }

    public void PorNivel(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            this.percorrerPorNivel();
        }
    }
    
    private void percorrerEmOrdemnaorec(){ //ATIVIDADE 2 Questão 4)
        Stack<ABBNode> pilha;
        ABBNode aux;
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            pilha = new Stack<ABBNode>();
            aux = this.raiz;
            while(!pilha.isEmpty() || aux != null){
                while(aux != null){
                    pilha.Push(aux);
                    aux = aux.getEsq();
                }
                aux = pilha.Pop();
                System.out.print(aux.getinfo() + " ");
                aux = aux.getDir();
            }
            System.out.println("");
        }
    }

    public void EmOrdemnaorec(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            this.percorrerEmOrdemnaorec();
        }
    }
    
    private void percorrerPreOrdemnaorec(){ //ATIVIDADE 2 QUESTÃO 5)
        Stack<ABBNode>pilha;
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            pilha = new Stack<ABBNode>();
            ABBNode aux = this.raiz;

            while(!pilha.isEmpty() || aux != null){
                while(aux != null){
                    System.out.print(aux.getinfo() + " ");
                    pilha.Push(aux);
                    aux = aux.getEsq();
                }
                aux = pilha.Pop();
                aux = aux.getDir();
            }
            System.out.println("");
        }
    }

    public void PreOrdemnaorec(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            this.percorrerPreOrdemnaorec();
        }
    }

    private void percorrerEmOrdemrec(ABBNode r){
        if(r != null){
            percorrerEmOrdemrec(r.getEsq());
            System.out.println(r.getinfo());
            percorrerEmOrdemrec(r.getDir());
        }
    }
    
    public void EmOrdemrec(){
        if(this.isEmpty()){
            System.out.println("Árvore vazia");
        }
        else{
            this.percorrerEmOrdemrec(raiz);
        }
    }


    private void ContagemNosEmOrdemrec(ABBNode r){ // ATIVIDADE 2 QUESTÃO 6 -> letra a)
        if(r != null){
            ContagemNosEmOrdemrec(r.getEsq());
            //System.out.println(r.getinfo());
            this.cont++;
            ContagemNosEmOrdemrec(r.getDir());
        }
    }

    public void nosEmOrdemrec(){
        if(this.isEmpty()){
            System.out.println("Árvore vazia");
        }
        else{
            this.cont = 0;
            this.ContagemNosEmOrdemrec(raiz);
            System.out.println(this.cont);
        }
    }

    private void ContagemNosEmOrdemnaorec(){//ATIVIDADE 2 Questão 6 -> letra b)
        Stack<ABBNode> pilha;
        ABBNode aux;
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            pilha = new Stack<ABBNode>();
            aux = this.raiz;
            int cont = 0;
            while(!pilha.isEmpty() || aux != null){
                while(aux != null){
                    pilha.Push(aux);
                    aux = aux.getEsq();
                }
                aux = pilha.Pop();
                cont++;
                aux = aux.getDir();
            }
            System.out.println("Árvore com " + cont + " nós");
        }
    }

    public void nosEmOrdemnaorec(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            this.ContagemNosEmOrdemnaorec();
        }
    }

    private void ContagemFolhasEmOrdemrec(ABBNode r){ //ATIVIDADE 2 Questão 6 -> letra c)
        if(r != null){
            if(r.getDir() == null && r.getEsq() == null){
                this.cont++;
            }
            ContagemFolhasEmOrdemrec(r.getEsq());
            //System.out.println(r.getinfo());
            ContagemFolhasEmOrdemrec(r.getDir());
        }
    }

    public void folhasEmOrdemrec(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        else{
            this.cont = 0;
            this.ContagemFolhasEmOrdemrec(raiz);
            System.out.println(this.cont);
        }
    }

    private void ContagemFolhasemOrdemnaorec(){//ATIVIDADE 2 Questão 6 -> letra d)
        Stack<ABBNode> pilha;
        ABBNode aux;
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            pilha = new Stack<ABBNode>();
            aux = this.raiz;
            int cont = 0;
            while(!pilha.isEmpty() || aux != null){
                while(aux != null){
                    pilha.Push(aux);
                    if(aux.getDir() == null && aux.getEsq() == null){
                        cont++;
                    }
                    aux = aux.getEsq();
                }
                aux = pilha.Pop();
                aux = aux.getDir();        
            }
            System.out.println("Árvore com " + cont + " nós folhas");

        }

    }

    public void folhasEmOrdemnaorec(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            this.ContagemFolhasemOrdemnaorec();
        }
    }

    private void ContagemNosNaoTerminaisEmOrdemrec(ABBNode r){
        if(r != null){
            if(r.getDir() != null || r.getEsq() != null){
                this.cont++;
            }
            ContagemNosNaoTerminaisEmOrdemrec(r.getEsq());
            //System.out.println(r.getinfo());
            ContagemNosNaoTerminaisEmOrdemrec(r.getDir());
        }
    }

    public void nosnaoterminaisEmOrdemrec(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            this.cont = 0;
            this.ContagemNosNaoTerminaisEmOrdemrec(raiz);
            System.out.println(this.cont);
        }
    }



    private void ContagemNosNaoTerminaisEmOrdemnaorec(){ //ATIVIDADE 2 Questão 6 -> letra f)
        Stack<ABBNode> pilha;
        ABBNode aux;
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            pilha = new Stack<ABBNode>();
            aux = this.raiz;
            int cont = 0;
            while(!pilha.isEmpty() || aux != null){
                while(aux != null){
                    pilha.Push(aux);
                    if(aux.getDir() != null || aux.getEsq() != null){
                        cont++;
                    }
                    aux = aux.getEsq();
                }
                aux = pilha.Pop();
                aux = aux.getDir();
            }
            System.out.println("Árvore com " + cont + " nós não terminais");
        }
    }

    public void nosnaoterminaisEmOrdemnaorec(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia");
        }
        else{
            this.ContagemNosNaoTerminaisEmOrdemnaorec();
        }
    }

}
