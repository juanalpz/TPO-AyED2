/* 2. Se define un nuevo TDA denominado DiccionarioSimpleModTDA basado en
DiccionarioSimpleTDA, con la particularidad de registrar la cantidad de veces que el valor
se ve modificado. Codificar la clase que implementa DiccionarioSimpleModTDA, con
representación dinámica. */

public class DiccionarioSimpleModTDA implements DiccionarioSimpleTDA {
    private class Nodo {
        int clave;
        int valor;
        int contador;
        Nodo sig;
    }

    private Nodo inicio;

    public void inicializarDiccionario() {
        /* Complejidad: O(1)
        * Inicializa el diccionario, asignando null al puntero inicio */

        inicio = null;
    }

    public void agregar(int clave, int valor) {
        /* Complejidad: O(1) en el mejor caso, O(n) en el peor caso
        * Si la clave ya existe y el valor es diferente, lo actualiza y
        * suma 1 al contador. Si no existe, lo agrega con contador en 0. */

        Nodo aux = inicio;

        while (aux != null) {
            if (aux.clave == clave) {
                if (aux.valor != valor) {
                    aux.valor = valor;
                    aux.contador++;
                }
                return;
            }
            aux = aux.sig;
        }

        Nodo nuevo = new Nodo();
        nuevo.clave = clave;
        nuevo.valor = valor;
        nuevo.contador = 0;
        nuevo.sig = inicio;
        inicio = nuevo;
    }

    public void eliminar(int clave) {
        /* Complejidad: O(1) en el mejor caso, O(n) en el peor caso
        * Si encuentra la clave la elimina, y si el diccionario está
        * vacío termina sin hacer nada. Si la clave está en el primer
        * nodo, ajusta el puntero inicio al siguiente nodo. Si no,
        * recorre la lista hasta encontrarla, y si la encuentra la
        * elimina ajustando el enlace del nodo anterior. */

        if (inicio == null) {
            return;
        }

        if (inicio.clave == clave) {
            inicio = inicio.sig;
        } else {
            Nodo aux = inicio;
            while (aux.sig != null && aux.sig.clave != clave) {
                aux = aux.sig;
            }

            if (aux.sig != null) {
                aux.sig = aux.sig.sig;
            }
        }
    }

    public int recuperar(int clave) {
        /* Complejidad: O(1) en el mejor caso, O(n) en el peor caso
        * Recorre la lista buscando la clave. Si la encuentra, devuelve
        * el valor asociado, y si no la encuentra devuelve -1 (en teoría
        * no debería pasar si las claves siempre existen, pero pongo -1
        * para que pueda compilar) */

        Nodo actual = inicio;

        while (actual != null) {
            if (actual.clave == clave) {
                return actual.valor;
            }
            actual = actual.sig;
        }
        return -1;
    }

    public int recuperarMod(int clave) {
        /* Complejidad: O(1) en el mejor caso, O(n) en el peor caso
        * Igual al metodo recuperar, pero devuelve el contador de
        * modificaciones en lugar del valor. Recorre hasta encontrar
        * la clave, y devuelve cuántas veces fue cambiado el valor
        * asociado. */

        Nodo actual = inicio;

        while (actual != null) {
            if (actual.clave == clave) {
                return actual.contador;
            }
            actual = actual.sig;
        }
        return -1;
    }

    public ConjuntoTDA claves() {
        /* Complejidad: O(1) en el mejor caso, O(n) en el peor caso
        * Crea un conjunto que permite claves repetidas. Recorre la
        * lista de nodos y agrega cada clave al conjunto. */

        ConjuntoTDA claves = new ConjuntoEspecialTDA();
        Nodo actual = inicio;
        while (actual != null) {
            claves.agregar(actual.clave);
            actual = actual.sig;
        }
        return claves;
    }
}
