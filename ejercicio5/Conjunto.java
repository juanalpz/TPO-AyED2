public class Conjunto implements ConjuntoTDA {
    int[] elementos;
    int cant;

    public void inicializarConjunto() {
        elementos = new int[100];
        cant = 0;
    }

    public void agregar(int x) {
        if (!this.pertenece(x)) {
            elementos[cant] = x;
            cant++;
        }
    }

    public void sacar(int x) {
        int i = 0;
        while (i < cant && elementos[i] != x) {
            i++;
        }

        if (i < cant) {
            elementos[i] = elementos[cant - 1];
            cant--;
        }
    }

    public int elegir() {
        return elementos[cant - 1];
    }

    public boolean pertenece(int x) {
        int i = 0;
        while (i < cant && elementos[i] != x) {
            i++;
        }
        return (i < cant);
    }

    public boolean conjuntoVacio() {
        return cant == 0;
    }
}
