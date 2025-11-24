package com.poo.unlu.controlador;

import com.poo.unlu.modelo.Juego;
import com.poo.unlu.modelo.ResultadoTirada;
import com.poo.unlu.observador.Observador;

public class Controlador {
    private Juego juego;


    public Controlador(Juego juego) {
        this.juego = juego;
    }

    public void registrarObservador(Observador observador){
        juego.addObserver(observador);
    }

    public void agregarJugador(String nombre){
        juego.agregarJugador(nombre);
    }

    public void plantarse(){
        juego.plantarse();
    }

    public ResultadoTirada lanzarDados(){
        return juego.tirarDados();
    }

    public int getPuntosTotalesJugadorActual(){
        return juego.getJugadorActual().getPuntosTotales();
    }

    public String getNombreJugadorActual(){
        return juego.getJugadorActual().getNombre();
    }

    public boolean juegoTerminado(){
        return juego.hayGanador();
    }

    public String getNombreGanador(){
        if (juego.hayGanador()){
            return juego.getGanador().getNombre();
        }
        return null;
    }



}
