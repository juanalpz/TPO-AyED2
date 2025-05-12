/* 3. Se define un metodo que reciba una PilaTDA y devuelva un int (número entero) con
la cantidad de elementos pares de la pila. Codificar la clase que implementa PilaTDA, con
representación dinámica */

public class PilaPares implements PilaTDA {
    private class Nodo {
        int valor;
        Nodo sig;
    }

    private Nodo tope;

    public void inicializarPila() {
        tope = null;
    }

    public void apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.valor = x;
        nuevo.sig = tope;
        tope = nuevo;
    }

    public void desapilar() {
        if (!pilaVacia()) {
            tope = tope.sig;
        }
    }

    public int tope() {
        return tope.valor;
    }

    public boolean pilaVacia() {
        return (tope == null);
    }

    public int cantidadPares() {
        Nodo aux = tope;
        int contador = 0;

        while (aux != null) {
            if (aux.valor % 2 == 0) {
                contador++;
            }
            aux = aux.sig;
        }
        return contador;
    }
}
