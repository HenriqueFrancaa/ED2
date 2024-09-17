
import AVLTree.AVLTree;

public class App {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<Integer>();
        int[] arr = { 2, 1, 5, 4 };
        for (int i = 0; i < arr.length; i++) {
            avl.insert(arr[i]);
        }
        avl.percorrerEmOrdem();
        avl.calcularAlturaArvore();
        avl.porNivel();
    }
}
