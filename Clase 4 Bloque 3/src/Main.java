import Implementacion.ConjuntoEstatico;
import Interface.ConjuntoTDA;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ConjuntoTDA padron = new ConjuntoEstatico();
        padron.InicializarConjunto();

        System.out.println("Padrón Electoral Escolar:");
        System.out.println(" ");

        // Simulación de alumnos que intentan votar (por DNI o ID)
        int[] votantes = {1, 2, 3, 2, 4, 1, 5};

        for (int i = 0; i < votantes.length; i++) {
            int alumno = votantes[i];

            // Si el alumno ya votó, se rechaza su voto y no se agrega al conjunto.
            if (padron.Pertenece(alumno)) {
                System.out.println("El alumno " + alumno + " ya votó. No puede votar de nuevo.");
            } else {
                padron.Agregar(alumno);
                System.out.println("El alumno " + alumno + " vota correctamente.");
            }
        }

        // Mostrar quiénes votaron (vaciar conjunto)
        System.out.println("\nAlumnos que votaron:");
        while (!padron.ConjuntoVacio()) {
            int x = padron.Elegir();
            System.out.println(x);
            padron.Sacar(x);
        }

        ConjuntoTDA invitados = new ConjuntoEstatico();
        invitados.InicializarConjunto();

        System.out.println("");
        System.out.println("Invitados a la fiesta de fin de cursada:");
        System.out.println("");

        // Lista de invitados por ID
        int[] lista = {1, 2, 3, 1, 4, 6, 2, 7};


        for (int i = 0; i < lista.length; i++) {
            int persona = lista[i];

            // Antes de agregar, contamos si cambia o no
            boolean yaEstaba = invitados.Pertenece(persona);

            invitados.Agregar(persona);

            if (yaEstaba) {
                System.out.println("La persona " + persona + " ya estaba en la lista. NO se agrega de nuevo.");
            } else {
                System.out.println("La persona " + persona + " fue agregada a la lista.");
            }
        }

        // Resultado final
        System.out.println("\nInvitados finales (sin repetidos):");
        int contador = 0;

        while (!invitados.ConjuntoVacio()) {
            int x = invitados.Elegir();
            System.out.println(x);
            invitados.Sacar(x);
            contador++;
        }

        System.out.println("\nCantidad total de invitados: " + contador);
        System.out.println(" ");

        ConjuntoTDA blacklist = new ConjuntoEstatico();
        blacklist.InicializarConjunto();

        System.out.println(" ");
        System.out.println("Blacklist de palabras");
        System.out.println(" ");

        //Palabras marcadas como spam
        String[] prohibidas = {"crypto","ganá", "premio"};

        for (String p: prohibidas) {
            blacklist.Agregar(p.hashCode());
        }
        //Mensajes a evaluar
        String[] mensajes = {"Ganá hoy", "Canjea tu premio", "Hola como estas?", "Inverti en crypto", "Juanito te envio 5000$"};

        for (String mensaje : mensajes) {
            boolean esSpam = false;

            String[] palabras = mensaje.split(" ");

            for (String palabra : palabras) {
                if (blacklist.Pertenece(palabra.toLowerCase().hashCode())) {
                    esSpam = true;
                }
            }
            if (esSpam) {
                System.out.println("SPAM: " +mensaje);
            } else {
                System.out.println("No es Spam: " +mensaje);
            }
        }
        System.out.println(" ");
        System.out.println("Tags de un post de Java");
        System.out.println(" ");

        ConjuntoTDA tags = new ConjuntoEstatico();
        tags.InicializarConjunto();

        // No se utiliza una pila ya que esta permite duplicados y solo se puede acceder al tope de la pila.
        String[] listaTags = {"programacion", "java", "OOP", "java", "programacion"};

        for (String tag : listaTags) {
            boolean yaEstaba = tags.Pertenece(tag.hashCode());

            tags.Agregar(tag.hashCode());

            if (yaEstaba) {
                System.out.println("#" + tag + " ya existía, no se agrega de nuevo.");
            } else {
                System.out.println("#" + tag + " agregado.");
            }
        }

        System.out.println(" ");
        System.out.println("Gestión de Legajos: ");

        ConjuntoTDA legajos = new ConjuntoEstatico();
        legajos.InicializarConjunto();

        //Lista de legajos, 2 alumnos se anotan a dos carreras distintas
        int[] ID = {1001, 1002, 1003, 1002, 1004, 1001};

        for (int i = 0; i < ID.length; i++) {
            int legajo = ID[i];

            if (legajos.Pertenece(legajo)) {
                System.out.println("El legajo " + legajo + " ya existe. ");
            } else {
                legajos.Agregar(legajo);
                System.out.println("Legajo " + legajo + " agregado correctamente. ");
            }
        }
        System.out.println(" ");
        System.out.println("\nLlamar a ELegir() dos veces sin llamar a Sacar()");
        System.out.println(" ");

        ConjuntoTDA conjunto = new ConjuntoEstatico();
        conjunto.InicializarConjunto();

        conjunto.Agregar(10);
        conjunto.Agregar(20);
        conjunto.Agregar(30);

        // Se llama a Elegir dos veces sin Sacar
        int primero = conjunto.Elegir();
        int segundo = conjunto.Elegir();

        System.out.println("Primer Elegir(): " + primero);
        System.out.println("Segundo Elegir(): " + segundo);

        if (primero == segundo) {
            System.out.println("Devuelve el mismo elemento.");
        } else {
            System.out.println("Devuelve elementos DISTINTOS.");
        }
    }
}