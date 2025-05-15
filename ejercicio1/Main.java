public class Main {
    public static void main(String[] args) {
        ConjuntoEspecialTDA conjunto = new ConjuntoEspecialTDA();
        conjunto.inicializarConjunto();

        // Agrega los valores de prueba al conjunto
        int[] valoresPrueba = {18, 2, 7, 4, 18, 22, 2, 7};
        for (int i = 0; i < valoresPrueba.length; i++) {
            conjunto.agregar(valoresPrueba[i]);
        }

        // Imprime los valores únicos del conjunto
        System.out.println("Elementos únicos en el conjunto:");
        for (int i = 0; i < valoresPrueba.length; i++) {
            if (conjunto.pertenece(i)) {
                System.out.println(i);
            }
        }
    }
}
