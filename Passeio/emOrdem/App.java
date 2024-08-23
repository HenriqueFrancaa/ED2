import BinarySearchTree.ABB;

public class App {
    public static void main(String[] args){
        ABB arv = new ABB();
        arv.insert(200);
        arv.insert(140);
        arv.insert(130);
        arv.insert(150);
        arv.insert(250);
        arv.insert(260);
        arv.insert(230);

        arv.emOrdemNaoRec();;
    }
}
