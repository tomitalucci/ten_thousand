package com.poo.unlu.modelo;

import java.util.ArrayList;

public class Cubilete {
    private ArrayList<Dado> manoDeDados;
    private int dadosActivos; //mantiene cuantos dados se tienen que tirar

    public Cubilete(){
        this.manoDeDados = new ArrayList<>();
        //genero las 5 instancias de Dado
        for(int i = 0; i < 5; i++){
            this.manoDeDados.add(new Dado());
        }
        this.dadosActivos = 5; //siempre arranco con el cubilete lleno con los 5 dados generados
    }


    public void tirarDados(int cantidad){ //cantidad hace referencia a cuantos dados es con los que tengo que tirar
        dadosActivos = cantidad;
        for (int i = 0; i < cantidad; i++){
            Dado dado = manoDeDados.get(i); //recupero el dado de la lista y le digo que vuelva a tirarse
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
