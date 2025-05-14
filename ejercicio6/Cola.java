public class Cola implements ColaTDA {
    int [] array;
    int indice;

    public void inicializarCola() {
        array = new int[100];
        indice = 0;
    }

    public void acolar(int x) {
        array[indice] = x;
        indice++;
    }

    public void desacolar() {
        for (int i = 0; i < indice - 1; i++) {
            array[i] = array[i + 1];
        }
        indice--;
    }

    public boolean colaVacia() {
        return (indice == 0);
    }

    public int primero() {
        return array[0];
    }
}
