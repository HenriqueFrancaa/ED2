import BinarySearchTree.ABB;

public class Main {
    public static void main(String[] args) {
        ABB<Integer>arv = new ABB<Integer>();
        int[] arr = {20,10,5,30,28,32};

        for(int i = 0; i <  arr.length; i++){
            arv.insert(arr[i]);
        }

        arv.emOrdem();
        arv.remover(30);
        arv.emOrdem();
        arv.remover(32);
        arv.emOrdem();
        arv.remover(10);
        arv.emOrdem();
        arv.remover(20);
        arv.emOrdem();
    }
}
