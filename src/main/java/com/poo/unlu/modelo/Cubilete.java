package com.poo.unlu.modelo;

import java.util.ArrayList;

public class Cubilete {
    private ArrayList<Dado> manoDeDados;


    public Cubilete(){
        this.manoDeDados = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            this.manoDeDados.add(new Dado());
        }
    }



    public void tirarDados(){
        for (Dado dado : manoDeDados){
            dado.lanzar();
        }
    }


    public ArrayList<Integer> getManoDeDados(){
        ArrayList<Integer> valores = new ArrayList<>();
        for (Dado dado : manoDeDados){
            int valor = dado.getCaraSuperior();
            valores.add(valor);
        }
        return valores;
    }



}
