package B;

public class App{
    public static void main(String[] args) {
        BTree arvore = new BTree();

        Integer v[] = {5,10,25,40};

        for(int i = 0; i < v.length; i++){
            arvore.insert(v[i]);
        }

    }
}