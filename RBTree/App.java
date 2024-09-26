import RedBlackTree.RB;

public class App {
    public static void main(String[] args) {
        RB<Integer> arv = new RB<Integer>();
        int[] arr = {41,14,51,90,64,43,37,99,18,100};
        for(int i = 0; i < arr.length; i++){
            arv.insert(arr[i]);
            arv.emOrdem();
        }
    }
}
