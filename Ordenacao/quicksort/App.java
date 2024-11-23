import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        int x; char ordem;
        Scanner scan = new Scanner(System.in);
        System.out.println("-----Digite o tamanho do vetor:  ------");
        x = scan.nextInt();
        System.out.println("-----ordem (c)rescente ou (d)ecrescente? -----");
        ordem = scan.next().charAt(0);

        String v[] = new String[x];

        for(int i = 0; i < x; i++){
            v[i] = scan.nextLine();
        }
        
        System.out.println("Vetor Desordenado!");
        for(int i = 0; i < v.length; i++){
            System.out.print(v[i] + " ");
        }
        


        Quicksort ordenado = new Quicksort(ordem);
        ordenado.quicksort(v,0, v.length-1);
        
        System.out.println("\nVetor Ordenado!");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        /*
        Aluno alunos[] = new Aluno[x];

        for(int i = 0; i < x; i++){
            String matricula = scan.nextLine();
            String nome = scan.nextLine();
            Double nota = scan.nextDouble();
            int faltas = scan.nextInt();
            alunos[i]= new Aluno(matricula,nome,nota,faltas);
        }
        */



    }
}
