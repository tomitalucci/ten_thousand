package com.poo.unlu.observador;

import java.util.ArrayList;

public class Observable {
    private ArrayList<Observador> observadores; //lista de interesados (vistas) que quieren saber si algo cambia


    public Observable() {
        observadores = new ArrayList<>();
    }

    //metodo para suscribirse
    public void addObserver(Observador observador){
        observadores.add(observador);
    }

    //metodo para avisar a todos
    public void notificarObservadores(){
        for (Observador observador : observadores){
            observador.actualizar(); //ejecuto el metodo actualizar de cada vista
        }
    }

}
