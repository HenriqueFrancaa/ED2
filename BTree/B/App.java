
public class App{
    public static void main(String[] args) {
        BTree arv = new BTree();

        int v[] = {5,10,25,40,9,20,80};

        for(int i = 0; i < v.length; i++){
            arv.insert(v[i]);
        }

        arv.acharMaior();
    }
}