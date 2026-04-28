package EJERCICIOS.DESAFIOS;

import Implementaciones.Dinamicas.ColaDinámica;
import Implementaciones.Dinamicas.PilaDinamica;
import Interfaces.ColaTDA;
import Interfaces.PilaTDA;

public class desafio_1 {
    public static void main(String[] args){
    PilaTDA pila= new PilaDinamica();
        pila.InicializarPila();
    ColaTDA cola= new ColaDinámica();
        cola.InicializarCola();

        pila.Apilar(1);
        pila.Apilar(2);
        pila.Apilar(1);

    PilaTDA pilaAux=new PilaDinamica();
        while (!pila.PilaVacia()){
        cola.Acolar(pila.Tope());
        pilaAux.Apilar(pila.Tope());
        pila.Desapilar();
    }
    boolean polindrome =true;
        while (polindrome && !pilaAux.PilaVacia()){
        if (pilaAux.Tope()!=cola.Primero()){polindrome=false;}
        cola.Desacolar();
        pilaAux.Desapilar();
    }
        System.out.println("la pila es polindrome? "+polindrome);
}}