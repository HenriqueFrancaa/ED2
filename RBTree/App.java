import RedBlackTree.RB;

public class App {
    public static void main(String[] args) {
        RB<Integer> arv = new RB<Integer>();
        int[] arr = {41,14,51,90,64,43,37,99,18,100};
        for(int i = 0; i < arr.length; i++){
            arv.insert(arr[i]);
            arv.emOrdem();
        }
        System.out.println();
        RB<Integer>arv2 = new RB<Integer>();
        int[] values = {27,14,33,7,45,20,70,50,60,55};
        for(int i = 0; i < values.length; i++){
            arv2.insert(values[i]);
            arv2.emOrdem();
        }   

    }
}
