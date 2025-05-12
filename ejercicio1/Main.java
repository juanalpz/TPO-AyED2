public class Main {
    public static void main(String[] args) {
        ConjuntoEspecialTDA conjunto = new ConjuntoEspecialTDA();

        // Valores de prueba: 18, 2, 7, 4, 18, 22, 2, 7
        conjunto.inicializarConjunto();
        conjunto.agregar(18);
        conjunto.agregar(2);
        conjunto.agregar(7);
        conjunto.agregar(4);
        conjunto.agregar(18);
        conjunto.agregar(22);
        conjunto.agregar(2);
        conjunto.agregar(7);

        // Mostrar los resultados
        System.out.println("Elementos en el conjunto: ");
        for (int i = 0; i < 23; i++) {
            if (conjunto.pertenece(i)) {
                System.out.println(i);
            }
        }

    }
}
