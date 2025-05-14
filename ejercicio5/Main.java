public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.inicializarPila();

        // Apilo los números a la pila, se permiten repetidos
        int[] numeros = {4, 3, 6, 6, 6, 7, 8, 4};
        for (int i = 0; i < numeros.length; i++) {
            pila.apilar(numeros[i]);
        }

        DiccionarioSimple apariciones = contarApariciones(pila);
        for (int i = 0; i < apariciones.cant; i++) {
            System.out.println("Elemento: " + apariciones.elementos[i].clave + ", apariciones: " + apariciones.elementos[i].valor);
        }
    }

    public static DiccionarioSimple contarApariciones(Pila pila) {
        /* Recorre la pila original y por cada elemento se verifica si ya fue
        registrado en el diccionario; si ya está, se incrementa su valor, y si
        no, se agrega con valor 1. Se usa una pila auxiliar para conservar los
        elementos durante el proceso, y una vez terminado el recorrido, se
        restauran en la pila original. */
        
        Pila aux = new Pila();
        DiccionarioSimple dicc = new DiccionarioSimple();

        aux.inicializarPila();
        dicc.inicializarDiccionario();

        // Recorre la pila original (la copia a una auxiliar para luego poder restaurarla)
        while (!pila.pilaVacia()) {
            int num = pila.tope();
            pila.desapilar();
            aux.apilar(num);

            boolean encontrado = false;

            // Recorre el dicconario, si encuentra la clave entonces incrementa su valor
            for (int i = 0; i < dicc.cant; i++) {
                if (dicc.elementos[i].clave == num) {
                    dicc.elementos[i].valor += 1;
                    encontrado = true;
                    break;
                }
            }

            // Si no encuentra la clave, la agrega y establece su valor como 1
            if (!encontrado) {
                dicc.agregar(num, 1);
            }
        }

        // Restaura la pila original desde la auxiliar
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }
        return dicc; // Devuelve el diccionario con el conteo
    }
}
