import Implementacion.PilaDinamica;
import Implementacion.ConjuntoDinamico;
import Interfaces.PilaTDA;
import Interfaces.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {

        PilaTDA pila = new PilaDinamica();
        PilaTDA aux = new PilaDinamica();
        ConjuntoTDA conj = new ConjuntoDinamico();
        probarDesafio("Desafio 3", pila, aux, conj);
    }

    public static void probarDesafio(String nombre, PilaTDA pila, PilaTDA aux, ConjuntoTDA conj) {
        System.out.println("=== " + nombre + " ===");

        pila.InicializarPila();
        conj.InicializarConjunto();
        aux.InicializarPila();

        pila.Apilar(10);
        pila.Apilar(20);
        pila.Apilar(30);

        System.out.println("El tope de la pila es "+ pila.Tope());
        System.out.println();

        while (!pila.PilaVacia()) {
            aux.Apilar(pila.Tope());
            conj.Agregar(aux.Tope());
            pila.Desapilar();
        }

        if  (conj.Pertenece(20));
        System.out.println("El numero 20 pertenece a la pila");

        if (conj.Pertenece(30));
        System.out.println("El numero 30 pertenece a la pila");

        if (conj.Pertenece(10));
        System.out.println("El numero 10 pertenece a la pila");

        //Restaurar pila

        while (!aux.PilaVacia()) {
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }
        System.out.println();
        System.out.println("El tope de la pila es "+ pila.Tope());
    }
}