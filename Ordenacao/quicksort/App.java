import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        int x;
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o tamanho do vetor: ");
        x = scan.nextInt();
        Integer v[] = new Integer[x];

        for(int i = 0; i < x; i++){
            v[i] = scan.nextInt();
        }
        
        System.out.println("Vetor Desordenado!");
        for(int i = 0; i < v.length; i++){
            System.out.print(v[i] + " ");
        }
        
        Quicksort ordenado = new Quicksort();
        ordenado.quicksort(v,0, v.length-1);
        
        System.out.println("\nVetor Ordenado!");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }

    }
}
