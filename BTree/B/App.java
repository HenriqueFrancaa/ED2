import BTree.BTree;

public class App {
    public static void main(String[] args) {
        BTree<Integer> arv = new BTree<Integer>();
        int x[] = { 110,100,90,80,60,50,40,130,120,70,150,30,200,280,500,170,105,75,190,145,600};
        for (int i = 0; i < x.length; i++) {
            arv.insert(x[i]);
        }
        arv.levelTour();
        arv.biggestKey();
        arv.smallestKey();
        arv.searchKey(900);
        arv.height();
    }
}
