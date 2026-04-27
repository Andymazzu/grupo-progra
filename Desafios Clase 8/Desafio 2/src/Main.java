import Implementacion.ColaPrioridadDinamica;
import Interface.ColaPrioridadTDA;

public class Main {
    public static void main(String[] args) {
        ColaPrioridadTDA cola = new ColaPrioridadDinamica();
        ColaPrioridadTDA aux = new ColaPrioridadDinamica();
        int cont = 0;

        cola.InicializarColaPrioridad();
        aux.InicializarColaPrioridad();

        cola.AcolarPrioridad(10, 1);
        cola.AcolarPrioridad(20, 2);
        cola.AcolarPrioridad(30, 2);
        cola.AcolarPrioridad(40, 1);

        System.out.println("=== Desafio 2 ===");
        System.out.println();
        System.out.println("Primer elemento:"+ cola.Primero()+ " (Prioridad: " +cola.Prioridad()+ ")");
        System.out.println();

        while (!cola.ColaVacia() && cola.Prioridad() != 1) {
        aux.AcolarPrioridad(cola.Primero(), cola.Prioridad());
        cola.Desacolar();
        }

        while (!cola.ColaVacia()) {
            aux.AcolarPrioridad(cola.Primero(), cola.Prioridad());
            cola.Desacolar();
            cont++;
        }

        System.out.println("Hay "+ cont +" elementos de prioridad 1 en la cola");
        System.out.println();

        while (!aux.ColaVacia()) {
            cola.AcolarPrioridad(aux.Primero(), aux.Prioridad());
            aux.Desacolar();
        }

        System.out.println("Primer elemento:"+ cola.Primero()+ " (Prioridad: " +cola.Prioridad()+ ")");

        }
}