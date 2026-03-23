package implementaciones;
import interfaces.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
    private int[] elementos;
    private int[] prioridades;
    private int indice;

    @Override
    public void InicializarCola() {
        elementos = new int[100];
        prioridades = new int[100];
        indice = 0;
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {
        int j = indice;
        // Según la guía: Mayor valor entero = Mayor prioridad
        while (j > 0 && prioridades[j - 1] < prioridad) {
            elementos[j] = elementos[j - 1];
            prioridades[j] = prioridades[j - 1];
            j--;
        }
        elementos[j] = x;
        prioridades[j] = prioridad;
        indice++;
    }

    @Override
    public void Desacolar() {
        for (int i = 0; i < indice - 1; i++) {
            elementos[i] = elementos[i + 1];
            prioridades[i] = prioridades[i + 1];
        }
        indice--;
    }

    @Override
    public int Primero() { return elementos[0]; }
    @Override
    public int Prioridad() { return prioridades[0]; }
    @Override
    public boolean ColaVacia() { return (indice == 0); }
}