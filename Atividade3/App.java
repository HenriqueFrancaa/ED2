import Cadastros.CadastroProduto;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        CadastroProduto loja = new CadastroProduto();
        int op;
        Scanner scan = new Scanner(System.in);
        
        do { 
            exibirOpcoes();
            op = scan.nextInt();
            switch(op){
                case 1: //cadastrar um novo produto
                    loja.cadastrarNovoProduto();
                    break;
                case 2://exebir informações
                    loja.exibirProdutos();
                    break;
                case 3://alterar preco
                    loja.alterarPreco();
                    break;
                case 4://alterar quantidade estoque
                    loja.alterarEstoque();
                    break;
                case 5: //exibir info de um produto
                    loja.exibir();
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
        System.out.println("====== QUAL OPERAÇÃO PARA A LOJA VOCÊ DESEJA FAZER? ======");
        System.out.println("1. Cadastrar um novo produto");
        System.out.println("2. Exibir todas as informações\n3. Alterar o preço de um produto");
        System.out.println("4. Alterar a quantidade de estoque de um produto\n5. Exibir informações de um produto");
        System.out.println("0. Encerrar o programa");
    }
}
