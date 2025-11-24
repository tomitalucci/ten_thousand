package com.poo.unlu.modelo;

import java.util.ArrayList;

public class Cubilete {
    private ArrayList<Dado> manoDeDados;
    private int dadosActivos;

    public Cubilete(){
        this.manoDeDados = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            this.manoDeDados.add(new Dado());
        }
        this.dadosActivos = 5;
    }


    public void tirarDados(int cantidad){
        dadosActivos = cantidad;
        for (int i = 0; i < cantidad; i++){
            Dado dado = manoDeDados.get(i);
            dado.lanzar();
        }
    }


    public ArrayList<Integer> getManoDeDados(){
        ArrayList<Integer> valores = new ArrayList<>();
        for (int i = 0; i < dadosActivos; i++){
            Dado dado = manoDeDados.get(i);
            valores.add(dado.getCaraSuperior());
        }
        return valores;
    }

}
