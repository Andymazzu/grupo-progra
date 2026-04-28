package EJERCICIOS.DESAFIOS;

import Implementaciones.Dinamicas.ColaDinámica;
import Implementaciones.Dinamicas.ColaPrioridadDinamica;
import Interfaces.ColaPrioridadTDA;
import Interfaces.ColaTDA;

public class desafio_5 {
    public static void main(String[] args){

        ColaTDA c= new ColaDinámica();
        c.InicializarCola();
        c.Acolar(-3);
        c.Acolar(5);
        c.Acolar(0);
        c.Acolar(-1);
        c.Acolar(7);
        c.Acolar(2);
        c.Acolar(-4);
        ColaPrioridadTDA colap =new ColaPrioridadDinamica();
        colap.InicializarColaPrioridad();

        System.out.println("Primer elemento desacolado: "+c.Primero());

        while (!c.ColaVacia()){
            if(c.Primero()>0){colap.AcolarPrioridad(c.Primero(),2);}
            else if (c.Primero()<0) {colap.AcolarPrioridad(c.Primero(),0);}
            else{colap.AcolarPrioridad(c.Primero(),1);}
            c.Desacolar();
        }
        colap.AcolarPrioridad(0,1);
        System.out.println("Cola con Priridad: ");
        while(!colap.ColaVacia()){
            System.out.print(colap.Primero()+",");
            colap.Desacolar();
        }
    }
}


