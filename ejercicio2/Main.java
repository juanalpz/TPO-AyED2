public class Main {
    public static void main(String[] args) {
        DiccionarioSimpleModTDA dicc = new DiccionarioSimpleModTDA();

        dicc.inicializarDiccionario();

        // Agrego claves con valores
        dicc.agregar(7, 3);
        dicc.agregar(16, 4);
        dicc.agregar(3, 4);
        dicc.agregar(16, 2); // Modifica el valor de la clave 16
        dicc.agregar(3, 6); // Modifica el valor de la clave 3
        dicc.agregar(5, 3);

        // Muestro las claves y sus valores/modificaciones
        ConjuntoTDA claves = dicc.claves();
        for (int i = 0; i <= 100; i++) {
            if (claves.pertenece(i)) {
                System.out.println("Clave: " + i);
                System.out.println("Valor: " + dicc.recuperar(i));
                System.out.println("Modificaciones: " + dicc.recuperarMod(i));
            }
        }
    }
}
