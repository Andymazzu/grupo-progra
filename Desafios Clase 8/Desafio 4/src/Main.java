import Implementacion.ConjuntoDinamico;
import Interface.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {
        ConjuntoTDA a = new ConjuntoDinamico();
        ConjuntoTDA b = new ConjuntoDinamico();
        ConjuntoTDA aux = new ConjuntoDinamico();
        a.InicializarConjunto();
        b.InicializarConjunto();
        aux.InicializarConjunto();

        a.Agregar(3);
        a.Agregar(7);
        a.Agregar(3); // no debe repetirse
        a.Agregar(10);

        b.Agregar(7);
        b.Agregar(8);
        b.Agregar(10);
        b.Agregar(1);

        while (!a.ConjuntoVacio()) {
            if (b.Pertenece(a.Elegir())) {
                System.out.println("El numero " + a.Elegir() + " pertenece al Conjunto B");
            }
            aux.Agregar(a.Elegir());
            a.Sacar(a.Elegir());
        }
        while (!aux.ConjuntoVacio()) {
            a.Agregar(aux.Elegir());
            aux.Sacar(aux.Elegir());
        }

        while (!b.ConjuntoVacio()) {
                if (a.Pertenece(b.Elegir())) {
                    System.out.println("El numero " + b.Elegir() + " pertenece al Conjunto A");
                }
                aux.Agregar(b.Elegir());
                b.Sacar(b.Elegir());
            }
            while (!aux.ConjuntoVacio()) {
                b.Agregar(aux.Elegir());
                aux.Sacar(aux.Elegir());
            }
        }
    }

