/* 1. Se define un nuevo TDA denominado ConjuntoEspecialTDA basado en
ConjuntoTDA, con la particularidad de que se permite más de una acepción de cada
elemento agregado. Tal cual como en ConjuntoTDA, no existe orden alguno. Codificar la
clase que implementa ConjuntoEspecialTDA, con representación dinamica. */

public class ConjuntoEspecialTDA implements ConjuntoTDA {
    private class Nodo {
        int valor;
        Nodo sig;
    }

    private Nodo inicio;

    public void inicializarConjunto() {
        /* Complejidad: O(1)
        * Reinicializa el conjunto, poniendo el puntero inicio en null */

        inicio = null;
    }

    public void agregar(int x) {
        /* Complejidad: O(1)
        * Agrega un nuevo valor al principio de la lista, permitiendo duplicados */

        Nodo nuevo = new Nodo();
        nuevo.valor = x;
        nuevo.sig = inicio;
        inicio = nuevo;
    }

    public void sacar(int x) {
        /* Complejidad: O(1) en el mejor caso, O(n) en el peor caso
        * Elimina todas las repeticiones del valor x que estén en la lista.
        * Primero se fija si los primeros nodos tienen se número y los va sacando.
        * Después recorre el resto de la lista y, cada vez que lo encuentra, lo
        * salta (así se elimina) */

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
        /* Complejidad: O(1)
        * Devuelve el primer número que encuentra en la lista */

        return inicio.valor;
    }

    public boolean pertenece(int x) {
        /* Complejidad: O(1) en el mejor caso, O(n) en el peor caso
        * Indica si un número está en el conjunto. Empieza en el inicio y va
        * revisando uno por uno hasta encontrarlo, o hasta llegar al final. Si
        * lo encuentra devuelve true, si no, false */

        Nodo aux = inicio;
        while (aux != null && aux.valor != x) {
            aux = aux.sig;
        }

        return (aux != null);
    }

    public boolean conjuntoVacio() {
        /* Complejidad O(1)
        * Indica si el conjunto está vacío. Mira si el inicio es null; si lo es,
        * entonces no hay nada en la lista. */

        return (inicio == null);
    }
}
