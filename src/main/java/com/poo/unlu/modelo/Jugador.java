package com.poo.unlu.modelo;

public class Jugador {
    private String nombre;
    private int puntosTotales = 0;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }


    public void sumarPuntos(int puntos){
        puntosTotales += puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }
}
