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

    public boolean isEmpty() {
        return this.root == null;
    }

    private void split(BNode<T> pai, int i) {
        BNode<T> novo = new BNode<T>(m);
        BNode<T> filho = pai.getFilho(i);

        novo.setFolha(filho.getFolha());

        for (int j = pai.getN(); j > i; j--) {
            pai.setFilho(j + 1, pai.getFilho(j));
        }

        pai.setFilho(i + 1, novo);

        for (int j = pai.getN() - 1; j >= i; j--) {
            pai.setInfo(j + 1, pai.getInfo(j));
        }
        pai.setInfo(i, filho.getInfo(m / 2));
        pai.setN(pai.getN() + 1);
        filho.setN(m / 2);
        filho.setInfo(m / 2, null);

        for (int j = 0; j < m / 2; j++) {
            novo.setInfo(j, filho.getInfo(j + m / 2 + 1));
            filho.setInfo(j + m / 2 + 1, null);
        }

        if (!filho.getFolha()) {
            for (int j = 0; j < m / 2 + 1; j++) {
                novo.setFilho(j, filho.getFilho(j + m / 2 + 1));
                filho.setFilho(j + m / 2 + 1, null);
            }
        }
        novo.setN(m / 2);
        novo.setPai(pai);
    }

    private void insertNonFull(BNode<T> x, T k) {
        int i = x.getN() - 1;
        if (x.getFolha()) {
            while (i >= 0 && (k.compareTo(x.getInfo(i)) < 0)) {
                x.setInfo(i + 1, x.getInfo(i));
                i--;
            }
            x.setInfo(i + 1, k);
            x.setN(x.getN() + 1);

        } else {

            while (i >= 0 && (k.compareTo(x.getInfo(i)) < 0)) {
                i--;
            }
            i++;
            insertNonFull(x.getFilho(i), k);

            
            if (x.getFilho(i).getN() == m) { // o no encheu
                split(x, i);
                /*
                */
                if (x == root && x.getN() == m) {
                BNode<T> s = new BNode<T>(m);
                    s.setFilho(0, x);
                    s.setFolha(false);
                    x.setPai(s);
                    root = s;
                    split(s, 0);
                }
            }
        }
    }

    public void insert(T k) {
        if (this.isEmpty()) {
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
            insertNonFull(root, k);

        }

    }

    private Retorno foundBiggestKey(){
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

    public void biggestKey(){
        if(this.isEmpty()){
            System.out.println("Árvore vázia!");
        }
        else{
            Retorno node = foundBiggestKey();
            System.out.println("Maior valor: " + node.getNode().getInfo(node.getPos()) + " na posição " + node.getPos());
        }
    }
    
    private void level(BNode<T> r) {
        
        Queue<BNode<T>> fila = new LinkedList<>();
        fila.add(r);
        fila.add(null);

        while (!fila.isEmpty()) {
            BNode<T> aux = fila.poll();

            if (aux == null) {
                System.out.println();
                if (!fila.isEmpty()) {
                    fila.add(null);
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

    public void levelTour() {
        if (this.isEmpty()) {
            System.out.println("Árvore vázia!");
        } else
            level(root);
    }
}
