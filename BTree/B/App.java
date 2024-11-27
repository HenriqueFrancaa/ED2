import BTree.BTree;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BTree<Integer> arv = new BTree<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int op, num;
        do {
            exibirOpcoes();
            op = scan.nextInt();
            switch (op) {
                case 1: // Inserir
                    System.out.println("Insira um valor na árvore: ");
                    num = scan.nextInt();
                    arv.insert(num);
                    break;
                case 2:// Procurar maior chave
                    arv.biggestKey();
                    break;
                case 3:// Procurar menor chave
                    arv.smallestKey();
                    break;
                case 4:// Calcular altura da arvore
                    arv.height();
                    break;
                case 5: // Buscar valor na arvore
                    System.out.println("Digite um valor para buscar: ");
                    num = scan.nextInt();
                    arv.searchKey(num);
                    break;
                case 6: // Passeio por nivel
                    arv.levelTour();
                    break;
                case 7: // Passeio por ordem
                    arv.ordem();
                    break;
                case 8: // Remover um valor da arvore
                    System.out.println("Digite um valor para remover da árvore: ");
                    num = scan.nextInt();
                    arv.remove(num);
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
            System.out.println("====== SIMULADOR DE ÁRVORE B ======");
            System.out.println("1. Inserir um valor");
            System.out.println("2.Exibir a maior chave armazenada na árvore\n3. Exibir a menor chave armazenada na árvore");
            System.out.println("4. Exibir altura da árvore");
            System.out.println("5. Procurar um valor na árvore");
            System.out.println("6. Exibir as chaves por nível");
            System.out.println("7. Exibir as chaves em ordem");
            System.out.println("8. Remover um valor da árvore");
            System.out.println("0. Encerrar o programa");
            System.out.println("==========================================");
        }
    }
