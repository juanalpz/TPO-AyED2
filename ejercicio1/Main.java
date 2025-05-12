public class Main {
    public static void main(String[] args) {
        ConjuntoEspecialTDA conjunto = new ConjuntoEspecialTDA();

        conjunto.inicializarConjunto();

        // Valores de prueba: 18, 2, 7, 4, 18, 22, 2, 7
        int[] datos = {18, 2, 7, 4, 18, 22, 2, 7};
        for (int i = 0; i < datos.length; i++) {
            conjunto.agregar(datos[i]);
        }

        // Muestra los valores únicos del conjunto
        System.out.println("Elementos únicos en el conjunto:");
        for (int i = 0; i <= 100; i++) {
            if (conjunto.pertenece(i)) {
                System.out.println(i);
            }
        }

    }
}
