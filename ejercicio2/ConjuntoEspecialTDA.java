public class ConjuntoEspecialTDA implements ConjuntoTDA {
    private class Nodo {
        int valor;
        Nodo sig;
    }

    private Nodo inicio;

    public void inicializarConjunto() {
        inicio = null;
    }

    public void agregar(int x) {
        // Agrega un nuevo nodo, independientemente de si el valor ya existe
        Nodo nuevo = new Nodo();
        nuevo.valor = x;
        nuevo.sig = inicio;
        inicio = nuevo;
    }

    public void sacar(int x) {
        // Si el conjunto está vacío, no hace nada
        if (conjuntoVacio()) {
            return;
        }

        // Si se repite un valor al principio de la lista, se asegura de eliminar sus apariciones
        while (inicio != null && inicio.valor == x) {
            inicio = inicio.sig;
        }

        // Recorre el resto de la lista, siempre mirando al siguiente nodo
        Nodo aux = inicio;
        while (aux != null && aux.sig != null) {
            if (aux.sig.valor == x) { // Si encuentra a 'x', lo salta
                aux.sig = aux.sig.sig;
            } else {
                aux = aux.sig; // Si no lo encuentra, avanza al siguiente nodo
            }
        }
    }

    public int elegir() {
        return inicio.valor;
    }

    public boolean pertenece(int x) {
        Nodo aux = inicio;
        // Recorre la lista mientras no llegue al final y no haya encontrado el valor
        while (aux != null && aux.valor != x) {
            aux = aux.sig;
        }

        // Devuelve true si se encontró el valor, false en caso contrario
        return (aux != null);
    }

    public boolean conjuntoVacio() {
        return (inicio == null);
    }
}
