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
        inicio = null;
    }

    public void agregar(int clave, int valor) {
        Nodo aux = inicio;

        // Recorre la lista; si encuentra la clave, actualiza el valor y el contador
        while (aux != null) {
            if (aux.clave == clave) {
                // Solo incrementa si el valor es distinto
                if (aux.valor != valor) {
                    aux.valor = valor;
                    aux.contador++;
                }
                return;
            }
            aux = aux.sig;
        }

        // Si no encontró la clave, crea un nuevo nodo al inicio
        Nodo nuevo = new Nodo();
        nuevo.clave = clave;
        nuevo.valor = valor;
        nuevo.contador = 0;
        nuevo.sig = inicio;
        inicio = nuevo;
    }

    public void eliminar(int clave) {
        // Si el diccionario está vacío, no hace nada
        if (inicio == null) {
            return;
        }

        // Si la clave está en el primer nodo, el inicio apunta al siguiente nodo
        if (inicio.clave == clave) {
            inicio = inicio.sig;
        } else {
            // Si la clave no estaba en el inicio, recorre el diccionario
            Nodo aux = inicio;
            while (aux.sig != null && aux.sig.clave != clave) {
                aux = aux.sig;
            }

            // Si encuentra el nodo lo saltea
            if (aux.sig != null) {
                aux.sig = aux.sig.sig;
            }
        }
    }

    public int recuperar(int clave) {
        Nodo actual = inicio;

        while (actual != null) {
            if (actual.clave == clave) {
                return actual.valor;
            }
            actual = actual.sig;
        }
        return -1;
        // Se supone que la clave siempre existe. Pongo -1 para que pueda compilar
    }

    public int recuperarMod(int clave) {
        Nodo actual = inicio;

        while (actual != null) {
            if (actual.clave == clave) {
                return actual.contador;
            }
            actual = actual.sig;
        }
        return -1;
        // Se supone que la clave siempre existe. Pongo -1 para que pueda compilar
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new ConjuntoEspecialTDA();
        Nodo actual = inicio;
        while (actual != null) {
            claves.agregar(actual.clave);
            actual = actual.sig;
        }
        return claves;
    }
}
