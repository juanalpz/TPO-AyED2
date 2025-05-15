public class Conjunto implements ConjuntoTDA {
    private class Nodo {
        int valor;
        Nodo sig;
    }

    private Nodo inicio;

    public void inicializarConjunto() {
        inicio = null;
    }

    public void agregar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.valor = x;
        nuevo.sig = inicio;
        inicio = nuevo;
    }

    public void sacar(int x) {
        if (!conjuntoVacio()) {
            while (inicio != null && inicio.valor == x) {
                inicio = inicio.sig;
            }

            Nodo aux = inicio;
            while (aux != null && aux.sig != null) {
                if (aux.sig.valor == x) {
                    aux.sig = aux.sig.sig;
                } else {
                    aux = aux.sig;
                }
            }
        }
    }

    public int elegir() {
        return inicio.valor;
    }

    public boolean pertenece(int x) {
        Nodo aux = inicio;
        while (aux != null && aux.valor != x) {
            aux = aux.sig;
        }

        return (aux != null);
    }

    public boolean conjuntoVacio() {
        return (inicio == null);
    }
}
