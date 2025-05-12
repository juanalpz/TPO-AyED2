public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.inicializarPila();

        // Apilo los números
        int[] numeros = {3, 3, 6, 2, 6, 7, 8, 4};
        for (int i = 0; i < numeros.length; i++) {
            pila.apilar(numeros[i]);
        }

        // Llamo a la función que retorna los elementos repetidos de la pila y los imprimo
        Conjunto repetidos = conjuntoRepetidos(pila);
        System.out.println("Elementos repetidos en la pila: ");
        for (int i = 0; i < repetidos.cant; i++) {
            System.out.println(repetidos.elementos[i]);
        }

    }

    public static Conjunto conjuntoRepetidos(Pila pila) {
        Pila aux = new Pila();
        Conjunto vistos = new Conjunto();
        Conjunto repetidos = new Conjunto();

        aux.inicializarPila();
        vistos.inicializarConjunto();
        repetidos.inicializarConjunto();

        // Desapilo los elementos de la pila original y los copio en una auxiliar
        while (!pila.pilaVacia()) {
            int num = pila.tope();
            pila.desapilar();
            aux.apilar(num);

            // Si el número ya fue visto, lo agrego al conjunto de repetidos
            if (vistos.pertenece(num)) {
                repetidos.agregar(num);
            } else {
                // Si es la primera vez que lo veo, lo agrego al conjunto de vistos
                vistos.agregar(num);
            }
        }

        // Restauro la pila original usando la auxiliar
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }
        return repetidos;
    }
}
