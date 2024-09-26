import RedBlackTree.RB;

public class Teste {
    public static void main(String[] args) {
           //arv.emOrdem();
        RB<Integer> arv = new RB<Integer>();
        int[] arr = {41,14,51,90,64,43,37,99,18,100};
        for(int i = 0; i < arr.length; i++){
            arv.insert(arr[i]);
            arv.emOrdem();
        }
        System.out.println();
        RB<Integer>arv2 = new RB<Integer>();
        int[] values = {11,27,32,43,50,61,70,99,98,97,95,93,92,91,80};
        for(int i = 0; i < values.length; i++){
            arv2.insert(values[i]);
            arv2.emOrdem();
        }

        System.out.println();
        arv2.porNivel();
    }
}
