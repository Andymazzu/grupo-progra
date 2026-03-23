package interfaces;

public interface ColaPrioridadTDA {
    void InicializarCola(); // Crea la estructura
    void AcolarPrioridad(int x, int prioridad); // inserta y ordena
    void Desacolar(); // Elimina el de mayor prioridad
    int Primero(); // Devuelve el valor con más prioridad
    int Prioridad(); // Devuelve el valor de la prioridad
    boolean ColaVacia(); // Chequea si no hay elementos
}

