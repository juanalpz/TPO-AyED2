/* 5. Se define un metodo ue reciba una PilaTDA y devuelva un DiccionarioSimpleTDA,
en el cual se guardarán los elementos de la pila como claves, y la cantidad de apariciones de
dicho elemento en la pila, como valores. */

public class DiccionarioSimple implements DiccionarioSimpleTDA{
    class Elemento {
        int clave;
        int valor;
    }

    Elemento[] elementos;
    int cant;

    public void inicializarDiccionario() {
        // Complejidad: O(1)
        cant = 0;
        elementos = new Elemento[100];
    }

    public void agregar(int clave, int valor) {
        // Complejidad: O(n)
        int pos = Clave2Indice(clave);
        if (pos == -1) {
            pos = cant;
            elementos[pos] = new Elemento();
            elementos[pos].clave = clave;
            cant++;
        }
        elementos[pos].valor = valor;
    }

    private int Clave2Indice(int clave) {
        // Complejidad: O(n)
        int i = cant - 1;
        while (i >= 0 && elementos[i].clave != clave) {
            i--;
        }
        return i;
    }

    public void eliminar(int clave) {
        // Complejidad: O(n)
        int pos = Clave2Indice(clave);
        if (pos != -1) {
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    public int recuperar(int clave) {
        // Complejidad: O(n)
        int pos = Clave2Indice(clave);
        return elementos[pos].valor;
    }

    public ConjuntoTDA claves() {
        // Complejidad: O(n)
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();
        for (int i = 0; i < cant; i++) {
            c.agregar(elementos[i].clave);
        }
        return c;
    }
}
