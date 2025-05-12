public class Main {
    public static void main(String[] args) {
        PilaPares pila = new PilaPares();

        pila.inicializarPila();

        // Apilo algunos números
        pila.apilar(3);
        pila.apilar(4);
        pila.apilar(6);
        pila.apilar(2);
        pila.apilar(45);
        pila.apilar(7);
        pila.apilar(8);

        // Muestro los números pares
        int pares = pila.cantidadPares();
        System.out.println("Cantidad de números pares: " + pares);
    }
}
