import BinarySearchTree.ABB;


public class Main{
    public static void main(String[] args) {
        ABB arv = new ABB();
        arv.insert(20);
        arv.insert(10);
        arv.insert(25);
        arv.insert(7);
        arv.insert(15);
        arv.insert(22);
        arv.insert(30);

        System.out.print("Passeio Por Nivel: ");
        arv.PorNivel();
        System.out.print("Passeio Em Ordem: ");
        arv.EmOrdemnaorec();
        System.out.print("Passeio Pre Ordem: ");
        arv.PreOrdemnaorec();

        System.out.print("Quantidade nós: ");
        arv.nosEmOrdemnaorec();
        System.out.print("Quantidade nós não terminais: ");
        arv.nosnaoterminaisEmOrdemnaorec();
        System.out.print("Quantidade nós folhas: ");
        arv.folhasEmOrdemnaorec();

        arv.nosEmOrdemrec();
        arv.nosnaoterminaisEmOrdemrec();
        arv.folhasEmOrdemrec();
    }
}