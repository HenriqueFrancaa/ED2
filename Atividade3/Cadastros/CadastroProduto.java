package Cadastros;
import Dados.Produto;
import java.util.Scanner;
import BinarySearchTree.ABB;


public class CadastroProduto {
    private ABB<Produto> dados;
    
    public CadastroProduto(){
        dados = new ABB<Produto>();

    }

    private void cadastrar(Produto p){
        dados.insert(p);
    }

    public void cadastrarNovoProduto(){
        Scanner scan = new Scanner(System.in);
        String cod,desc,forn;
        Double preco;int estoque;
        System.out.println("Digite o código do produto: ");
        cod = scan.nextLine();
        System.out.println("Digite a descrição do produto: ");
        desc = scan.nextLine();
        System.out.println("Digite o fornecedor do produto: ");
        forn = scan.nextLine();
        System.out.println("Digite o preço do produto: ");
        preco = scan.nextDouble();
        System.out.println("Digite a quantidade do estoque: ");
        estoque = scan.nextInt();
        Produto p = new Produto(cod, desc, forn, preco, estoque);
        cadastrar(p);
    }

    public void alterarPreco(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o codigo do produto: ");
        String cod = scan.nextLine();
        System.out.println("Digite o novo preço do produto:");
        Double prec;
        prec = scan.nextDouble();
        Produto p = new Produto(cod);
        Produto retorno = dados.buscar(p);
        if(retorno == null){
            System.out.println("Código de produto inválido.");
        }
        else{
            retorno.setPreco(prec);
            System.out.println("Preço alterado!");
        }
        
        
    }

    public void alterarEstoque(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o codigo do produto: ");
        String cod = scan.nextLine();
        System.out.println("Digite o novo estoque do produto:");
        int estoque;
        estoque = scan.nextInt();
        Produto p = new Produto(cod);
        Produto retorno = dados.buscar(p);
        if(retorno == null){
            System.out.println("Código de produto inválido.");
        }
        else{
            retorno.setEstoque(estoque);
            System.out.println("Estoque alterado");
        }
        
    }

    private Produto buscarProduto(String cod){
        Produto aux = new Produto(cod);
        Produto retorno = dados.buscar(aux);
        return retorno;
    }
    
    public void exibir(){
        System.out.println("Digite o codigo do produto");
        Scanner scan = new Scanner(System.in);
        String codigo;
        codigo = scan.nextLine();
        Produto p = buscarProduto(codigo);
        if(p == null){
            System.out.println("Este produto não está cadastrado");
        }
        else{
            System.out.println(p);
        }
        
    }

    public void exibirProdutos(){
        System.out.println();
        dados.emOrdem();
    }

   
}
