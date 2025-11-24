package com.poo.unlu.observador;

import java.util.ArrayList;

public class Observable {
    private ArrayList<Observador> observadores;


    public Observable() {
        observadores = new ArrayList<>();
    }

    public void addObserver(Observador observador){
        observadores.add(observador);
    }


    public void notificarObservadores(){
        for (Observador observador : observadores){
            observador.actualizar();
        }
    }

}
