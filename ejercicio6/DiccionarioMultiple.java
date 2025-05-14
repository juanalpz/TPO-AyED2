public class DiccionarioMultiple implements DiccionarioMultipleTDA {
    private class NodoClave {
        int clave;
        NodoValor valores; // La referencia a la lista de valores
        NodoClave sigClave; // La referencia a la siguiente clave
    }

    private class NodoValor {
        int valor; // El valor almacenado
        NodoValor sigValor; // La referencia al siguiente valor
    }

    private NodoClave origen;

    public void inicializarDiccionario() {
        origen = null;
    }

    public void agregar(int clave, int valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }

        NodoValor aux = nc.valores;
        while (aux != null && aux.valor != valor) {
            aux = aux.sigValor;
        }

        if (aux == null) {
            NodoValor nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }
    }

    private NodoClave Clave2NodoClave(int clave) {
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }

        return aux;
    }

    public void eliminarValor(int clave, int valor) {
        if (origen == null) {
            if (origen.clave == clave) { // Es en el primero
                EliminarValorEnNodo(origen, valor);
                if (origen.valores == null) { // Quedó vacío
                    origen = origen.sigClave;
                }
            } else { // Es en algún otro
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }

                if (aux.sigClave != null) {
                    EliminarValorEnNodo(aux.sigClave, valor);
                    if (aux.sigClave.valores == null) {
                        aux.sigClave = aux.sigClave.sigClave;
                    }
                }
            }
        }
    }

    private void EliminarValorEnNodo(NodoClave nodo, int valor) {
        if (nodo.valores != null) {
            if (nodo.valores.valor == valor) { // Es el primero
                nodo.valores = nodo.valores.sigValor;
            } else { // Es algún otro
                NodoValor aux = nodo.valores;
                while (aux.sigValor != null && aux.sigValor.valor != valor) {
                    aux = aux.sigValor;
                }

                if (aux.sigValor != null) {
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }
    }

    public void eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) { // Es el primero
                origen = origen.sigClave;
            } else { // Es algún otro
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }

                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    public ConjuntoTDA recuperar(int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();
        if (nc != null) {
            NodoValor aux = nc.valores;
            while (aux != null) {
                c.agregar(aux.valor);
                aux = aux.sigValor;
            }
        }

        return c;
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();
        NodoClave aux = origen;
        while (aux != null) {
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }

        return c;
    }
}
