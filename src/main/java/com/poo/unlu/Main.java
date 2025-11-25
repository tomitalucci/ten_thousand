package com.poo.unlu;

import com.poo.unlu.controlador.Controlador;
import com.poo.unlu.modelo.Juego;
import com.poo.unlu.vista.VistaConsola;

public class Main {
    public static void main (String[] args){

        Juego modelo = new Juego();
        Controlador controlador = new Controlador(modelo);
        VistaConsola vista = new VistaConsola(controlador);

        vista.iniciar();


    }
}
