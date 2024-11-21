public class Quicksort {

    // 3 4 7 6 1 2 5 cp = 3 op = esq
    // i f
    public <T extends Comparable<T>> int particao(T v[], int i, int f) {
        int op = 0; // 0-> esquerda 1-> direita
        T cp = v[i];
        while (i != f) {
            if (op == 0) { // esquerda
                if (v[f].compareTo(cp) < 0) {
                    v[i] = v[f];
                    i++;
                    op = 1; // direita
                } else {
                    f--;
                }
            } else {
                if (v[i].compareTo(cp) > 0) {
                    v[f] = v[i];
                    f--;
                    op = 0;
                } else {
                    i++;
                }
            }
        }

        v[i] = cp;

        return i;
    }

    public <T extends Comparable<T>> void quicksort(T v[], int i, int f) {
        int k;
        if (f > i) {
            k = particao(v, i, f);
            quicksort(v, i, k - 1);
            quicksort(v, k + 1, f);
        }
    }
}