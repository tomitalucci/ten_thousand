package com.poo.unlu.modelo;

import java.util.ArrayList;


//este es el objeto q uso para mandar la informacion a traves de la calculadora de puntaje.
public class ResultadoTirada {
    private int puntaje;
    private int dadosQuePuntuaron;
    private ArrayList<Integer> valores;

    public ResultadoTirada(int puntaje, int dadosQuePuntuaron, ArrayList<Integer> valores) {
        this.puntaje = puntaje;
        this.dadosQuePuntuaron = dadosQuePuntuaron;
        this.valores = valores;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getDadosQuePuntuaron() {
        return dadosQuePuntuaron;
    }

    public ArrayList<Integer> getValores(){
        return valores;
    }
}
