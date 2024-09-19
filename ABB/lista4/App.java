import BinarySearchTree.ABB;

public class App {
    public static void main(String[] args) {
        int[] arr = {400,200,600,100,300,500,800,50,250,220,290};
        ABB<Integer> arv = new ABB<Integer>();
        for(int i = 0; i < arr.length; i++){
            arv.insert(arr[i]);
        }
        
        arv.emOrdem();
        arv.remover(600);
        arv.emOrdem();
        arv.remover(300);
        arv.emOrdem();
        /* 
        arv.contarFrequencia(800);
        arv.altura();
        arv.emOrdem();
        arv.contarFrequencia(290);
        arv.insert(800);
         arv.emOrdem();
         arv.altura();
         arv.insert(800);
         */
    }
}
