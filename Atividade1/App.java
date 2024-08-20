import java.util.Random;

public class App{
    public static void main(String[] args){
        int i = 0;
        ABB arv = new ABB();
        //arv.insert(14);
        Random gerador = new Random();
        while(i < 10){
            i++;
            arv.insert(i+i);
        }
        arv.buscarMaiorValor();
        arv.buscaMenorValor();
        arv.search(80);
    }
}