public interface DiccionarioMultipleTDA {
    void inicializarDiccionario();
    void agregar (int clave, int valor);
    void eliminarValor(int clave, int valor);
    void eliminar(int clave);
    ConjuntoTDA recuperar(int clave);
    ConjuntoTDA claves();
}
