public class Main {
    public static void main(String[] args) {
        // Crea el diccionario múltiple
        DiccionarioMultiple dicc = new DiccionarioMultiple();
        dicc.inicializarDiccionario();

        // Agrega claves con valores, permitiendo repetidos
        int[] clave4 = {4, 5, 6};
        for (int i = 0; i < clave4.length; i++) {
            dicc.agregar(4, clave4[i]);
        }
        int[] clave6 = {7, 5, 8, 9};
        for (int i = 0; i < clave6.length; i++) {
            dicc.agregar(6, clave6[i]);
        }
        int[] clave9 = {4, 8, 7, 5};
        for (int i = 0; i < clave9.length; i++) {
            dicc.agregar(9, clave9[i]);
        }
        int[] clave8 = {7, 4, 5, 9, 0, 4};
        for (int i = 0; i < clave8.length; i++) {
            dicc.agregar(8, clave8[i]);
        }

        // Obtiene y muestra los valores únicos
        ColaTDA cola = valoresUnicos(dicc);

        System.out.println("Valores únicos en el diccionario:");
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

    public static ColaTDA valoresUnicos(DiccionarioMultiple dicc) {
        /* Recorre las claves del diccionario múltiple y, por cada una, obtiene
        sus valores asociados. Cada valor se guarda en un conjunto auxiliar que
        permite solo valores únicos. Si un valor aún no está en este conjunto,
        se agrega tanto al conjunto como a la cola de salida. */

        // Obtiene las claves del dicionario
        ConjuntoTDA claves = dicc.claves();

        // Crea el conjunto para registrar los valores únicos
        ConjuntoTDA valoresUnicos = new Conjunto();
        valoresUnicos.inicializarConjunto();

        // Crea la cola donde se van a guardar los valores sin repetir
        ColaTDA cola = new Cola();
        cola.inicializarCola();

        // Recorre las claves del diccionario
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);

            // Obtiene los valores asociados a esa clave
            ConjuntoTDA valores = dicc.recuperar(clave);

            // Recorre los valores de esa clave
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                valores.sacar(valor);

                // Si el valor no está en el conjunto de valores únicos, lo agrega
                if (!valoresUnicos.pertenece(valor)) {
                    valoresUnicos.agregar(valor);
                    cola.acolar(valor); // Agrega el valor a la cola final
                }
            }
        }

        // Devuelve la cola con todos los valores sin repetir
        return cola;
    }
}
