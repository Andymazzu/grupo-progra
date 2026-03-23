package main;

import interfaces.ColaPrioridadTDA;
import implementaciones.ColaPrioridadEstatica;

public class ResolucionBloque2 {
    public static void main(String[] args) {

        System.out.println("--- 1. GUARDIA DEL HOSPITAL (TRIAGE) ---");
        ColaPrioridadTDA hospital = new ColaPrioridadEstatica();
        hospital.InicializarCola();
        // Definimos: 100 = Emergencia, 1 = Raspón
        hospital.AcolarPrioridad(10, 1);   // Pibe con raspón
        hospital.AcolarPrioridad(99, 100); // Jubilado con bobazo
        System.out.println("Atendiendo en Guardia al ID: " + hospital.Primero()); // Sale 99
        hospital.Desacolar();
        System.out.println();

        System.out.println("--- 2. EXAMEN FINAL (PROMOCIÓN VS REGULAR) ---");
        ColaPrioridadTDA finales = new ColaPrioridadEstatica();
        finales.InicializarCola();
        // Definimos: 10 = Promocionado, 5 = Regular
        finales.AcolarPrioridad(505, 5);  // Regular (Llegó 8:00 AM)
        finales.AcolarPrioridad(101, 10); // Promocionado (Llegó 8:30 AM)
        System.out.println("Pasa a rendir primero: " + finales.Primero()); // Sale 101
        System.out.println();

        System.out.println("--- 3. PROCESADOR DE TAREAS (OS SCHEDULER) ---");
        ColaPrioridadTDA cpu = new ColaPrioridadEstatica();
        cpu.InicializarCola();
        // Definimos: 50 = Sistema, 10 = Usuario (Spotify)
        cpu.AcolarPrioridad(88, 10); // Spotify 
        cpu.AcolarPrioridad(1, 50);  // Proceso del Sistema
        System.out.println("El CPU ejecuta la tarea ID: " + cpu.Primero()); // Sale 1 (Sistema)
        System.out.println();

        System.out.println("--- 4. EMBARQUE DE AEROLÍNEAS ---");
        ColaPrioridadTDA avion = new ColaPrioridadEstatica();
        avion.InicializarCola();
        // Definimos: 3 = Movilidad Reducida, 2 = Business, 1 = Económica
        avion.AcolarPrioridad(50, 1); // Pasajero Mortal
        avion.AcolarPrioridad(20, 2); // Pasajero Business
        avion.AcolarPrioridad(5, 3);  // Movilidad Reducida
        System.out.println("Sube primero al avión el ID: " + avion.Primero()); // Sale 5
        System.out.println();

        System.out.println("--- 5. TICKETS IT (SOPORTE TÉCNICO) ---");
        ColaPrioridadTDA soporte = new ColaPrioridadEstatica();
        soporte.InicializarCola();
        // Definimos: 999 = Servidor Caído, 0 = Fondo de pantalla
        soporte.AcolarPrioridad(7, 0);    // Ticket: "No me gusta el fondo"
        soporte.AcolarPrioridad(1, 999);  // Ticket: "Servidor principal roto"
        System.out.println("Técnico reparando ticket ID: " + soporte.Primero()); // Sale 1
    }
}