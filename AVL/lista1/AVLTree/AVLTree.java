package AVLTree;

import TADQueue.Queue;
import java.awt.desktop.SystemEventListener;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;
    private boolean status;

    private boolean isEmpty() {
        return root == null;
    }

    private AVLNode<T> rotateRight(AVLNode<T> a) {
        AVLNode<T> b, c;
        b = a.getLeft();
        if (b.getFatBal() == -1) { // rotação simples
            a.setLeft(b.getRight());
            b.setRight(a);
            a.setFatBal(0);
            a = b;
        } else { // rotação dupla
            c = b.getRight();
            b.setRight(c.getLeft());
            c.setLeft(b);
            a.setLeft(c.getRight());
            c.setRight(a);
            if (c.getFatBal() == -1) {
                a.setFatBal(1);
            } else {
                a.setFatBal(0);
            }
            if (c.getFatBal() == 1) {
                b.setFatBal(-1);
            } else {
                b.setFatBal(0);
            }
            a = c;
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> a) {
        AVLNode<T> b, c;
        b = a.getRight();
        if (b.getFatBal() == 1) { // rot simples
            a.setRight(b.getLeft());
            b.setLeft(a);
            a.setFatBal(0);
            a = b;
        } else {
            c = b.getLeft();
            b.setLeft(c.getRight());
            c.setRight(b);
            a.setRight(c.getLeft());
            c.setLeft(a);
            if (c.getFatBal() == 1) {
                a.setFatBal(-1);
            } else {
                a.setFatBal(0);
            }
            if (c.getFatBal() == -1) {
                b.setFatBal(1);
            } else {
                b.setFatBal(0);
            }
            a = c;
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }

    private AVLNode<T> insertNode(AVLNode<T> r, T value) {
        if (r == null) {
            r = new AVLNode<T>(value);
            this.status = true;
        } else if (r.getInfo().compareTo(value) > 0) {
            r.setLeft(insertNode(r.getLeft(), value));
            if (this.status == true) {
                switch (r.getFatBal()) {
                    case 1:
                        r.setFatBal(0);
                        this.status = false;
                        break;
                    case 0:
                        r.setFatBal(-1);
                        break;
                    case -1:
                        r = this.rotateRight(r);
                        break;
                }
            }
        } else {
            r.setRight(insertNode(r.getRight(), value));
            if (this.status == true) {
                switch (r.getFatBal()) {
                    case -1:
                        r.setFatBal(0);
                        this.status = false;
                        break;
                    case 0:
                        r.setFatBal(1);
                        break;
                    case 1:
                        r = this.rotateLeft(r);
                        break;
                }
            }
        }
        return r;
    }

    public void insert(T value) {
        if (this.isEmpty() == true) {
            this.root = new AVLNode<T>(value);
        } else {
            this.root = insertNode(this.root, value);
            this.status = false;
        }
    }

    private void emOrdem(AVLNode<T> r) {
        if (r != null) {
            if (r.getLeft() == null) {
                System.out.print(" null");
            } else {
                emOrdem(r.getLeft());
            }
            System.out.print(" " + r.getInfo());
            if (r.getRight() == null) {
                System.out.print(" null");
            } else {
                emOrdem(r.getRight());
            }
        }
    }

    public void percorrerEmOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Nada para percorrer");
        } else {
            this.emOrdem(root);
            System.out.println();
        }
    }

    public void porNivel() {
        Queue<AVLNode<T>> fila;
        AVLNode<T> aux;
        if (this.isEmpty() == false) {
            fila = new Queue<AVLNode<T>>();
            fila.enQueue(root);
            while (fila.isEmpty() == false) {
                aux = fila.deQueue();
                if (aux != null && (aux.getLeft() != null || aux.getRight() != null)) {
                    fila.enQueue(aux.getLeft());
                    fila.enQueue(aux.getRight());
                }
                if (aux == null) {
                    System.out.print("null ");
                } else {
                    System.out.print(aux.getInfo() + " ");
                }
            }
            System.out.println();
        }

    }

    private int altura(AVLNode<T> r) {
        if (r.getLeft() == null && r.getRight() == null) {
            System.out.println("Altura = 0");
        }
        int cont = -1;
        while (r != null) {
            if (r.getFatBal() < 0) {
                r = r.getLeft();
            } else {
                r = r.getRight();
            }
            cont++;
        }
        return cont;

    }

    public void calcularAlturaArvore() {
        if (this.isEmpty() == true) {
            System.out.println("Altura = 0");
        } else {
            System.out.println("Altura: " + this.altura(root));
        }
    }

}
