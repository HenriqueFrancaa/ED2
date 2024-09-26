import RedBlackTree.RB;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RB<Integer> arv = new RB<Integer>();
        int op, num;
        do {
            exibirOpcoes();
            op = scan.nextInt();
            switch (op) {
                case 1: // cadastrar um novo produto
                    num = scan.nextInt();
                    arv.insert(num);
                    break;
                case 2:// remover um valor
                    num = scan.nextInt();
                    arv.remover(num);
                    break;
                case 3:// Passeio por Nivel
                    //arv.porNivel();
                    break;
                case 4:// Passeio por Ordem;
                    arv.emOrdem();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        } while (op != 0);
        
    }
        public static void exibirOpcoes(){
        System.out.println("====== SIMULADOR DE ÁRVORE REDBLACK ======");
        System.out.println("1. Inserir um valor");
        System.out.println("2. Remover um valor\n3. Passeio por nível");
        System.out.println("4. Passeio em Ordem");
        System.out.println("0. Encerrar o programa");
        }

}
