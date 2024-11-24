
import BTree.BTree;

public class App {
    public static void main(String[] args) {
        BTree<Integer> arv = new BTree<Integer>();
        int x[] = {12,27,54,86,33,41,67,72,94,29,23,38,59,107,61,32,131};
        for(int i = 0; i < x.length; i++){
            arv.insert(x[i]);
        }
        arv.levelTour();
    }
}
