import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        int x; char ordem;
        Scanner scan = new Scanner(System.in);
        System.out.println("-----Digite o tamanho do vetor:  ------");
        x = scan.nextInt();
        System.out.println("-----ordem (c)rescente ou (d)ecrescente? -----");
        ordem = scan.next().charAt(0);
        /*
        */
        Integer v[] = new Integer[x];



        for(int i = 0; i < x; i++){
            v[i] = scan.nextInt();
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
        */

        Aluno alunos[] = new Aluno[x];
        System.out.println();

        for(int i = 0; i < x; i++){
            scan.nextLine();
            String matricula = scan.nextLine();
           // scan.nextLine();
            String nome = scan.nextLine();
            //scan.nextLine();
            Double nota = scan.nextDouble();
            //scan.nextLine();
            int faltas = scan.nextInt();
            alunos[i]= new Aluno(matricula,nome,nota,faltas);
        }
        
        for (int i = 0; i < alunos.length; i++) {
            System.out.println(alunos[i].getNome() + "-> nota: " + alunos[i].getNota());
        }

        ordenado.quicksort(alunos, 0, alunos.length-1);
        System.out.println();
        for (int i = 0; i < alunos.length; i++) {
            System.out.println(alunos[i].getNome() + "-> nota: " + alunos[i].getNota());
        }


    }
}
